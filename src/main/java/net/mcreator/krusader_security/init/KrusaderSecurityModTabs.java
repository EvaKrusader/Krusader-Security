
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.krusader_security.KrusaderSecurityMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KrusaderSecurityModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KrusaderSecurityMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(KrusaderSecurityModBlocks.DIGICODE.get().asItem());
			tabData.accept(KrusaderSecurityModBlocks.DIGICODE_WARNING.get().asItem());
			tabData.accept(KrusaderSecurityModItems.ONE_TIME_PASSCODE_CHANGE.get());
			tabData.accept(KrusaderSecurityModItems.WRENCH.get());
			tabData.accept(KrusaderSecurityModItems.GIVE_HINT_DIGICODE.get());
			tabData.accept(KrusaderSecurityModItems.SHOW_LOGS.get());
			tabData.accept(KrusaderSecurityModItems.CREPERC.get());
			tabData.accept(KrusaderSecurityModBlocks.TERMINAL.get().asItem());
			tabData.accept(KrusaderSecurityModBlocks.COMPUTER.get().asItem());
			tabData.accept(KrusaderSecurityModItems.JAMMER_IMPROVISED.get());
			tabData.accept(KrusaderSecurityModItems.JAMMER_NORMAL.get());
			tabData.accept(KrusaderSecurityModItems.JAMMER_ELITE.get());
			tabData.accept(KrusaderSecurityModItems.WARNING_TAPE.get());
			tabData.accept(KrusaderSecurityModBlocks.DIGICODE_POISON.get().asItem());
			tabData.accept(KrusaderSecurityModItems.POISON_GEL.get());
			tabData.accept(KrusaderSecurityModBlocks.DIGICODE_FIRE.get().asItem());
			tabData.accept(KrusaderSecurityModBlocks.DIGICODE_GLOWING.get().asItem());
			tabData.accept(KrusaderSecurityModItems.GLOWING_PAINT.get());
			tabData.accept(KrusaderSecurityModItems.SPICY_POWDER.get());
		}
	}
}
