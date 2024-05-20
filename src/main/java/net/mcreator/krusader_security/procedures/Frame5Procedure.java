package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 16 && entity.getPersistentData().getDouble("devFrame") <= 20) {
			return true;
		}
		return false;
	}
}
