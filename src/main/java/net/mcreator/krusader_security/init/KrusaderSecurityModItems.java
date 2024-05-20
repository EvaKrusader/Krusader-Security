
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.krusader_security.item.WrenchItem;
import net.mcreator.krusader_security.item.ShowLogsItem;
import net.mcreator.krusader_security.item.OneTimePasscodeChangeItem;
import net.mcreator.krusader_security.item.GiveHintDigicodeItem;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, KrusaderSecurityMod.MODID);
	public static final RegistryObject<Item> DIGICODE = block(KrusaderSecurityModBlocks.DIGICODE);
	public static final RegistryObject<Item> WRENCH = REGISTRY.register("wrench", () -> new WrenchItem());
	public static final RegistryObject<Item> GIVE_HINT_DIGICODE = REGISTRY.register("give_hint_digicode", () -> new GiveHintDigicodeItem());
	public static final RegistryObject<Item> ONE_TIME_PASSCODE_CHANGE = REGISTRY.register("one_time_passcode_change", () -> new OneTimePasscodeChangeItem());
	public static final RegistryObject<Item> PC = block(KrusaderSecurityModBlocks.PC);
	public static final RegistryObject<Item> SHOW_LOGS = REGISTRY.register("show_logs", () -> new ShowLogsItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
