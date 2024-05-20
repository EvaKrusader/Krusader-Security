package net.mcreator.krusader_security.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.krusader_security.init.KrusaderSecurityModItems;
import net.mcreator.krusader_security.init.KrusaderSecurityModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiveDigicodeResetProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getState(), event.getEntity());
	}

	public static void execute(BlockState blockstate, Entity entity) {
		execute(null, blockstate, entity);
	}

	private static void execute(@Nullable Event event, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == KrusaderSecurityModBlocks.DIGICODE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(KrusaderSecurityModItems.ONE_TIME_PASSCODE_CHANGE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
