
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.krusader_security.block.PCBlock;
import net.mcreator.krusader_security.block.DigicodeBlock;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, KrusaderSecurityMod.MODID);
	public static final RegistryObject<Block> DIGICODE = REGISTRY.register("digicode", () -> new DigicodeBlock());
	public static final RegistryObject<Block> PC = REGISTRY.register("pc", () -> new PCBlock());
}
