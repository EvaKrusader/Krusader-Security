package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.krusader_security.network.KrusaderSecurityModVariables;

public class PcAnim8Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).whatPcAnim == 8) {
			return true;
		}
		return false;
	}
}
