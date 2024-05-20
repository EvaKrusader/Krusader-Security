package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class Frame4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("devFrame") >= 21 && entity.getPersistentData().getDouble("devFrame") <= 25) {
			return true;
		}
		return false;
	}
}
