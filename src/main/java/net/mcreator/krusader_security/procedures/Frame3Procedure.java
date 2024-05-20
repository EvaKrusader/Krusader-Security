package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 26 && entity.getPersistentData().getDouble("devFrame") <= 30) {
			return true;
		}
		return false;
	}
}
