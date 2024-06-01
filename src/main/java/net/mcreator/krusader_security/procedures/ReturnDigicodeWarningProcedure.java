package net.mcreator.krusader_security.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.krusader_security.init.KrusaderSecurityModBlocks;

public class ReturnDigicodeWarningProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == KrusaderSecurityModBlocks.DIGICODE_WARNING.get()) {
			return true;
		}
		return false;
	}
}
