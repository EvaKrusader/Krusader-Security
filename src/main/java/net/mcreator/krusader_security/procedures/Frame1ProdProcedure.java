package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame1ProdProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 36 && entity.getPersistentData().getDouble("devFrame") <= 40) {
			return true;
		}
		return false;
	}
}
