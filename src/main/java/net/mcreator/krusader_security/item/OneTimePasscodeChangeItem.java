
package net.mcreator.krusader_security.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.krusader_security.procedures.WrenchRightclickedOnBlockProcedure;

import java.util.List;

public class OneTimePasscodeChangeItem extends Item {
	public OneTimePasscodeChangeItem() {
		super(new Item.Properties().durability(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("This allows you to set a custom 4-digit passcode to your digicode."));
		list.add(Component.literal("This item is single-use, so be careful with it"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WrenchRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
