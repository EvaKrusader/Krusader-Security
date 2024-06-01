package net.mcreator.krusader_security.procedures;

import net.minecraft.world.level.LevelAccessor;

public class DigicodeRelayerEmittedRedstonePowerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		return DigicodeRelayerUpdateTickProcedure.execute(world, x, y, z);
	}
}
