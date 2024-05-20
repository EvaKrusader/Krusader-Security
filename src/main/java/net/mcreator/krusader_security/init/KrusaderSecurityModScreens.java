
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.krusader_security.client.gui.PCPasswordResetScreen;
import net.mcreator.krusader_security.client.gui.PCLogingScreen;
import net.mcreator.krusader_security.client.gui.DigicodeInterfaceScreen;
import net.mcreator.krusader_security.client.gui.DevDigicodeScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KrusaderSecurityModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(KrusaderSecurityModMenus.DIGICODE_INTERFACE.get(), DigicodeInterfaceScreen::new);
			MenuScreens.register(KrusaderSecurityModMenus.DEV_DIGICODE.get(), DevDigicodeScreen::new);
			MenuScreens.register(KrusaderSecurityModMenus.PC_LOGING.get(), PCLogingScreen::new);
			MenuScreens.register(KrusaderSecurityModMenus.PC_PASSWORD_RESET.get(), PCPasswordResetScreen::new);
		});
	}
}