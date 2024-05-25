
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.krusader_security.block.entity.TerminalBlockEntity;
import net.mcreator.krusader_security.block.entity.DigicodeBlockEntity;
import net.mcreator.krusader_security.block.entity.ComputerBlockEntity;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KrusaderSecurityMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> DIGICODE = register("digicode", KrusaderSecurityModBlocks.DIGICODE, DigicodeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TERMINAL = register("terminal", KrusaderSecurityModBlocks.TERMINAL, TerminalBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COMPUTER = register("computer", KrusaderSecurityModBlocks.COMPUTER, ComputerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
