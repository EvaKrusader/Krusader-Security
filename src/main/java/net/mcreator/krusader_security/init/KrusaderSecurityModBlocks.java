
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.krusader_security.block.TerminalBlock;
import net.mcreator.krusader_security.block.DigicodeWarningBlock;
import net.mcreator.krusader_security.block.DigicodeRelayerBlock;
import net.mcreator.krusader_security.block.DigicodePoisonBlock;
import net.mcreator.krusader_security.block.DigicodeGlowingBlock;
import net.mcreator.krusader_security.block.DigicodeFireBlock;
import net.mcreator.krusader_security.block.DigicodeBlock;
import net.mcreator.krusader_security.block.ComputerBlock;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, KrusaderSecurityMod.MODID);
	public static final RegistryObject<Block> DIGICODE = REGISTRY.register("digicode", () -> new DigicodeBlock());
	public static final RegistryObject<Block> DIGICODE_WARNING = REGISTRY.register("digicode_warning", () -> new DigicodeWarningBlock());
	public static final RegistryObject<Block> TERMINAL = REGISTRY.register("terminal", () -> new TerminalBlock());
	public static final RegistryObject<Block> COMPUTER = REGISTRY.register("computer", () -> new ComputerBlock());
	public static final RegistryObject<Block> DIGICODE_POISON = REGISTRY.register("digicode_poison", () -> new DigicodePoisonBlock());
	public static final RegistryObject<Block> DIGICODE_FIRE = REGISTRY.register("digicode_fire", () -> new DigicodeFireBlock());
	public static final RegistryObject<Block> DIGICODE_GLOWING = REGISTRY.register("digicode_glowing", () -> new DigicodeGlowingBlock());
	public static final RegistryObject<Block> DIGICODE_RELAYER = REGISTRY.register("digicode_relayer", () -> new DigicodeRelayerBlock());
}
