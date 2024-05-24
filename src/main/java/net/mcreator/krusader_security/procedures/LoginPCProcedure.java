package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class LoginPCProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((guistate.containsKey("text:Username") ? ((EditBox) guistate.get("text:Username")).getValue() : "").equals(entity.getDisplayName().getString())
				&& (guistate.containsKey("text:Password") ? ((EditBox) guistate.get("text:Password")).getValue() : "").equals(entity.getPersistentData().getString("loginPassword"))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You are now logged in."), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Wrong info"), false);
		}
	}
}
