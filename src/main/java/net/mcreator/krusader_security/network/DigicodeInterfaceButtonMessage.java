
package net.mcreator.krusader_security.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.krusader_security.world.inventory.DigicodeInterfaceMenu;
import net.mcreator.krusader_security.procedures.OnButtonXClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButtonVClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton9ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton8ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton7ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton6ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton5ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton4ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton3ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton2ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton1ClickedProcedure;
import net.mcreator.krusader_security.procedures.OnButton0ClickedProcedure;
import net.mcreator.krusader_security.KrusaderSecurityMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DigicodeInterfaceButtonMessage {
	private final int buttonID, x, y, z;

	public DigicodeInterfaceButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public DigicodeInterfaceButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(DigicodeInterfaceButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(DigicodeInterfaceButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DigicodeInterfaceMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OnButton1ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			OnButton2ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			OnButton3ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			OnButton4ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			OnButton5ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			OnButton6ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			OnButton7ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			OnButton8ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 8) {

			OnButton9ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 9) {

			OnButton0ClickedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 10) {

			OnButtonVClickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			OnButtonXClickedProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		KrusaderSecurityMod.addNetworkMessage(DigicodeInterfaceButtonMessage.class, DigicodeInterfaceButtonMessage::buffer, DigicodeInterfaceButtonMessage::new, DigicodeInterfaceButtonMessage::handler);
	}
}
