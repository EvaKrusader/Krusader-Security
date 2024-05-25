package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.krusader_security.network.KrusaderSecurityModVariables;

public class PCLogingThisGUIIsOpenedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).pcAdSpace;
	}
}
