package net.mcreator.krusader_security.procedures;

import net.minecraft.world.entity.Entity;

public class DevDigicodeWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("devFrame") > 1) {
			entity.getPersistentData().putDouble("devFrame", (entity.getPersistentData().getDouble("devFrame") - 1));
		} else {
			entity.getPersistentData().putDouble("devFrame", 40);
		}
	}
}
