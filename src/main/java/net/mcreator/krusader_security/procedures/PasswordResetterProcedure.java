package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class PasswordResetterProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((guistate.containsKey("text:OldPassword") ? ((EditBox) guistate.get("text:OldPassword")).getValue() : "").equals(entity.getPersistentData().getString("loginPassword"))) {
			entity.getPersistentData().putString("loginPassword", (guistate.containsKey("text:NewPassword") ? ((EditBox) guistate.get("text:NewPassword")).getValue() : ""));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your new password is '\u00A7n" + entity.getPersistentData().getString("loginPassword") + "\u00A7r'.")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Your old password is incorrect."), false);
		}
	}
}
