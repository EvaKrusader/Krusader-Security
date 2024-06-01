
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.krusader_security.world.inventory.PCPasswordResetMenu;
import net.mcreator.krusader_security.world.inventory.GifterMenu;
import net.mcreator.krusader_security.world.inventory.DigicodeInterfaceMenu;
import net.mcreator.krusader_security.world.inventory.DevDigicodeMenu;
import net.mcreator.krusader_security.world.inventory.ComputerLoginMenu;
import net.mcreator.krusader_security.KrusaderSecurityMod;

public class KrusaderSecurityModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KrusaderSecurityMod.MODID);
	public static final RegistryObject<MenuType<DigicodeInterfaceMenu>> DIGICODE_INTERFACE = REGISTRY.register("digicode_interface", () -> IForgeMenuType.create(DigicodeInterfaceMenu::new));
	public static final RegistryObject<MenuType<DevDigicodeMenu>> DEV_DIGICODE = REGISTRY.register("dev_digicode", () -> IForgeMenuType.create(DevDigicodeMenu::new));
	public static final RegistryObject<MenuType<PCPasswordResetMenu>> PC_PASSWORD_RESET = REGISTRY.register("pc_password_reset", () -> IForgeMenuType.create(PCPasswordResetMenu::new));
	public static final RegistryObject<MenuType<ComputerLoginMenu>> COMPUTER_LOGIN = REGISTRY.register("computer_login", () -> IForgeMenuType.create(ComputerLoginMenu::new));
	public static final RegistryObject<MenuType<GifterMenu>> GIFTER = REGISTRY.register("gifter", () -> IForgeMenuType.create(GifterMenu::new));
}
