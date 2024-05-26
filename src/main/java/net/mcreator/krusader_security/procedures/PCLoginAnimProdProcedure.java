package net.mcreator.krusader_security.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.krusader_security.network.KrusaderSecurityModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PCLoginAnimProdProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double length = 0;
		length = 80;
		if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 0) {
			{
				double _setval = (entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim - 1;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.login_anim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = length;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.login_anim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 70) {
			{
				double _setval = 1;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 60) {
			{
				double _setval = 2;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 50) {
			{
				double _setval = 3;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > length / 2) {
			{
				double _setval = 4;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 30) {
			{
				double _setval = 5;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 20) {
			{
				double _setval = 6;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 10) {
			{
				double _setval = 7;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).login_anim > 0) {
			{
				double _setval = 8;
				entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.whatPcAnim = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
