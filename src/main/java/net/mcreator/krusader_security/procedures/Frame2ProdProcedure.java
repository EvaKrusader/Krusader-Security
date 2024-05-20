package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame2ProdProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 31 && entity.getPersistentData().getDouble("devFrame") <= 35) {
			return true;
		}
		return false;
	}
}
