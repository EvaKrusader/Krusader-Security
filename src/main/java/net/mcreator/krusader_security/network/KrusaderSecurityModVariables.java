package net.mcreator.krusader_security.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.krusader_security.KrusaderSecurityMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrusaderSecurityModVariables {
	public static double whatWorldVersionSession = 0;
	public static String VersionLockTextSession = "\"\"";

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		KrusaderSecurityMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.ItemColorReset = original.ItemColorReset;
			clone.currentDate = original.currentDate;
			clone.nextDate = original.nextDate;
			clone.currentVersion = original.currentVersion;
			clone.nextVersion = original.nextVersion;
			clone.sendDownloadLink = original.sendDownloadLink;
			clone.ver1 = original.ver1;
			clone.ver2 = original.ver2;
			clone.ver3 = original.ver3;
			clone.nextDateNum = original.nextDateNum;
			clone.currentDateNum = original.currentDateNum;
			clone.login_anim = original.login_anim;
			clone.whatPcAnim = original.whatPcAnim;
			clone.pcAdSpace = original.pcAdSpace;
			clone.whatWorldVersionPlayerLock = original.whatWorldVersionPlayerLock;
			clone.VersionLockText = original.VersionLockText;
			clone.JammerUses = original.JammerUses;
			if (!event.isWasDeath()) {
				clone.isLoggedIn = original.isLoggedIn;
				clone.sendOutMessage = original.sendOutMessage;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("krusader_security", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean isLoggedIn = false;
		public boolean sendOutMessage = false;
		public String ItemColorReset = "\u00A7r\u00A7f";
		public String currentDate = "\"\"";
		public String nextDate = "\"\"";
		public String currentVersion = "\"\"";
		public String nextVersion = "\"\"";
		public boolean sendDownloadLink = false;
		public double ver1 = 0;
		public double ver2 = 0;
		public double ver3 = 1.0;
		public double nextDateNum = 0.0;
		public double currentDateNum = 0;
		public double login_anim = 0.0;
		public double whatPcAnim = 0.0;
		public String pcAdSpace = "\"\"";
		public double whatWorldVersionPlayerLock = 0;
		public String VersionLockText = "\"\"";
		public double JammerUses = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				KrusaderSecurityMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("isLoggedIn", isLoggedIn);
			nbt.putBoolean("sendOutMessage", sendOutMessage);
			nbt.putString("ItemColorReset", ItemColorReset);
			nbt.putString("currentDate", currentDate);
			nbt.putString("nextDate", nextDate);
			nbt.putString("currentVersion", currentVersion);
			nbt.putString("nextVersion", nextVersion);
			nbt.putBoolean("sendDownloadLink", sendDownloadLink);
			nbt.putDouble("ver1", ver1);
			nbt.putDouble("ver2", ver2);
			nbt.putDouble("ver3", ver3);
			nbt.putDouble("nextDateNum", nextDateNum);
			nbt.putDouble("currentDateNum", currentDateNum);
			nbt.putDouble("login_anim", login_anim);
			nbt.putDouble("whatPcAnim", whatPcAnim);
			nbt.putString("pcAdSpace", pcAdSpace);
			nbt.putDouble("whatWorldVersionPlayerLock", whatWorldVersionPlayerLock);
			nbt.putString("VersionLockText", VersionLockText);
			nbt.putDouble("JammerUses", JammerUses);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			isLoggedIn = nbt.getBoolean("isLoggedIn");
			sendOutMessage = nbt.getBoolean("sendOutMessage");
			ItemColorReset = nbt.getString("ItemColorReset");
			currentDate = nbt.getString("currentDate");
			nextDate = nbt.getString("nextDate");
			currentVersion = nbt.getString("currentVersion");
			nextVersion = nbt.getString("nextVersion");
			sendDownloadLink = nbt.getBoolean("sendDownloadLink");
			ver1 = nbt.getDouble("ver1");
			ver2 = nbt.getDouble("ver2");
			ver3 = nbt.getDouble("ver3");
			nextDateNum = nbt.getDouble("nextDateNum");
			currentDateNum = nbt.getDouble("currentDateNum");
			login_anim = nbt.getDouble("login_anim");
			whatPcAnim = nbt.getDouble("whatPcAnim");
			pcAdSpace = nbt.getString("pcAdSpace");
			whatWorldVersionPlayerLock = nbt.getDouble("whatWorldVersionPlayerLock");
			VersionLockText = nbt.getString("VersionLockText");
			JammerUses = nbt.getDouble("JammerUses");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.isLoggedIn = message.data.isLoggedIn;
					variables.sendOutMessage = message.data.sendOutMessage;
					variables.ItemColorReset = message.data.ItemColorReset;
					variables.currentDate = message.data.currentDate;
					variables.nextDate = message.data.nextDate;
					variables.currentVersion = message.data.currentVersion;
					variables.nextVersion = message.data.nextVersion;
					variables.sendDownloadLink = message.data.sendDownloadLink;
					variables.ver1 = message.data.ver1;
					variables.ver2 = message.data.ver2;
					variables.ver3 = message.data.ver3;
					variables.nextDateNum = message.data.nextDateNum;
					variables.currentDateNum = message.data.currentDateNum;
					variables.login_anim = message.data.login_anim;
					variables.whatPcAnim = message.data.whatPcAnim;
					variables.pcAdSpace = message.data.pcAdSpace;
					variables.whatWorldVersionPlayerLock = message.data.whatWorldVersionPlayerLock;
					variables.VersionLockText = message.data.VersionLockText;
					variables.JammerUses = message.data.JammerUses;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
