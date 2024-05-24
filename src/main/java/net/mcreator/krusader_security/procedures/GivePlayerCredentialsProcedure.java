package net.mcreator.krusader_security.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GivePlayerCredentialsProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getPersistentData().getString("loginPassword")).equals("")) {
			entity.getPersistentData().putString("loginPassword",
					((entity.getDisplayName().getString()).substring(0, 1) + "" + (entity.getDisplayName().getString()).substring((int) ((entity.getDisplayName().getString()).length() - 1), (int) (entity.getDisplayName().getString()).length())
							+ new java.text.DecimalFormat("##").format((entity.getDisplayName().getString()).length()) + "-"
							+ (new java.text.DecimalFormat("#").format(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getDisplayName().getString()).length())) + ""
									+ new java.text.DecimalFormat("#").format(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getDisplayName().getString()).length())))));
			entity.getPersistentData().putString("playerIP", ((new java.text.DecimalFormat("#").format(255) + ".") + "" + (new java.text.DecimalFormat("#").format(169) + ".") + (new java.text.DecimalFormat("#").format(0) + ".")
					+ ("" + new java.text.DecimalFormat("#").format(Mth.nextInt(RandomSource.create(), (int) (entity.getDisplayName().getString()).length(), 255)))));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your credentials are '\u00A7n" + entity.getPersistentData().getString("loginPassword") + "\u00A7r'.")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your IP is '\u00A7n" + entity.getPersistentData().getString("playerIP") + "\u00A7r'.")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your credentials are '\u00A7n" + entity.getPersistentData().getString("loginPassword") + "\u00A7r'.")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your IP is '\u00A7n" + entity.getPersistentData().getString("playerIP") + "\u00A7r'.")), false);
		}
	}
}
