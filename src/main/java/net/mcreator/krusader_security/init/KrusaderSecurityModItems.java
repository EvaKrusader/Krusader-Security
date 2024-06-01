
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
import net.mcreator.krusader_security.item.WarningTapeItem;
import net.mcreator.krusader_security.item.SpicyPowderItem;
import net.mcreator.krusader_security.item.ShowLogsItem;
import net.mcreator.krusader_security.item.PoisonGelItem;
import net.mcreator.krusader_security.item.OneTimePasscodeChangeItem;
import net.mcreator.krusader_security.item.JammerNormalItem;
import net.mcreator.krusader_security.item.JammerImprovisedItem;
import net.mcreator.krusader_security.item.JammerEliteItem;
import net.mcreator.krusader_security.item.GlowingPaintItem;
import net.mcreator.krusader_security.item.GiveHintDigicodeItem;
import net.mcreator.krusader_security.item.CrepercItem;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, KrusaderSecurityMod.MODID);
	public static final RegistryObject<Item> DIGICODE = block(KrusaderSecurityModBlocks.DIGICODE);
	public static final RegistryObject<Item> DIGICODE_WARNING = block(KrusaderSecurityModBlocks.DIGICODE_WARNING);
	public static final RegistryObject<Item> ONE_TIME_PASSCODE_CHANGE = REGISTRY.register("one_time_passcode_change", () -> new OneTimePasscodeChangeItem());
	public static final RegistryObject<Item> WRENCH = REGISTRY.register("wrench", () -> new WrenchItem());
	public static final RegistryObject<Item> GIVE_HINT_DIGICODE = REGISTRY.register("give_hint_digicode", () -> new GiveHintDigicodeItem());
	public static final RegistryObject<Item> SHOW_LOGS = REGISTRY.register("show_logs", () -> new ShowLogsItem());
	public static final RegistryObject<Item> CREPERC = REGISTRY.register("creperc", () -> new CrepercItem());
	public static final RegistryObject<Item> TERMINAL = block(KrusaderSecurityModBlocks.TERMINAL);
	public static final RegistryObject<Item> COMPUTER = block(KrusaderSecurityModBlocks.COMPUTER);
	public static final RegistryObject<Item> JAMMER_IMPROVISED = REGISTRY.register("jammer_improvised", () -> new JammerImprovisedItem());
	public static final RegistryObject<Item> JAMMER_NORMAL = REGISTRY.register("jammer_normal", () -> new JammerNormalItem());
	public static final RegistryObject<Item> JAMMER_ELITE = REGISTRY.register("jammer_elite", () -> new JammerEliteItem());
	public static final RegistryObject<Item> WARNING_TAPE = REGISTRY.register("warning_tape", () -> new WarningTapeItem());
	public static final RegistryObject<Item> DIGICODE_POISON = block(KrusaderSecurityModBlocks.DIGICODE_POISON);
	public static final RegistryObject<Item> POISON_GEL = REGISTRY.register("poison_gel", () -> new PoisonGelItem());
	public static final RegistryObject<Item> DIGICODE_FIRE = block(KrusaderSecurityModBlocks.DIGICODE_FIRE);
	public static final RegistryObject<Item> DIGICODE_GLOWING = block(KrusaderSecurityModBlocks.DIGICODE_GLOWING);
	public static final RegistryObject<Item> GLOWING_PAINT = REGISTRY.register("glowing_paint", () -> new GlowingPaintItem());
	public static final RegistryObject<Item> SPICY_POWDER = REGISTRY.register("spicy_powder", () -> new SpicyPowderItem());
	public static final RegistryObject<Item> DIGICODE_RELAYER = block(KrusaderSecurityModBlocks.DIGICODE_RELAYER);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
