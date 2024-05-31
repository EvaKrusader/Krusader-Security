package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.krusader_security.network.KrusaderSecurityModVariables;

public class ClickedButtonAdspaceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace).equals("lazarus")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace)), false);
		} else if (((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace).equals("test")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace)), false);
		} else if (((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace).equals("telecom")) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("krusader_security:jammer_improvised_recipe")});
		} else if (((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace).equals("thalp")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace)), false);
		} else if (((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace).equals("marble")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace)), false);
		}
	}
}
