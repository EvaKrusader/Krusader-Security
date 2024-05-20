package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame6Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 11 && entity.getPersistentData().getDouble("devFrame") <= 15) {
			return true;
		}
		return false;
	}
}
