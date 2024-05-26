
package net.mcreator.krusader_security.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.krusader_security.world.inventory.DigicodeInterfaceMenu;
import net.mcreator.krusader_security.procedures.DigicodeEmittedRedstonePowerProcedure;
import net.mcreator.krusader_security.procedures.DigicodeBlockAddedProcedure;
import net.mcreator.krusader_security.block.entity.DigicodeBlockEntity;

import java.util.List;

import io.netty.buffer.Unpooled;

public class DigicodeBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 12);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DigicodeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				if (s.getValue(BLOCKSTATE) == 10)
					return 0;
				if (s.getValue(BLOCKSTATE) == 11)
					return 0;
				if (s.getValue(BLOCKSTATE) == 12)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).noLootTable());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 11) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		if (state.getValue(BLOCKSTATE) == 12) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
						box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
						box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
				case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
						box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5),
						box(3, 1, 15, 13, 12, 16), box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
				case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
						box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
						box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
				case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
						box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5),
						box(15, 1, 3, 16, 12, 13), box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(4.5, 9.5, 0.5, 6.5, 11.5, 1.5), box(7, 9.5, 0.5, 9, 11.5, 1.5), box(9.5, 9.5, 0.5, 11.5, 11.5, 1.5), box(4.5, 7, 0.5, 6.5, 9, 1.5), box(7, 7, 0.5, 9, 9, 1.5), box(9.5, 7, 0.5, 11.5, 9, 1.5),
					box(4.5, 4.5, 0.5, 6.5, 6.5, 1.5), box(7, 4.5, 0.5, 9, 6.5, 1.5), box(9.5, 4.5, 0.5, 11.5, 6.5, 1.5), box(4.5, 2, 0.5, 6.5, 4, 1.5), box(7, 2, 0.5, 9, 4, 1.5), box(9.5, 2, 0.5, 11.5, 4, 1.5), box(3, 1, 0, 13, 12, 1),
					box(3, 12, 0, 4, 15, 1), box(12, 12, 0, 13, 15, 1), box(4, 14, 0, 12, 15, 1), box(4, 12, 0.25, 12, 14, 0.75));
			case NORTH -> Shapes.or(box(9.5, 9.5, 14.5, 11.5, 11.5, 15.5), box(7, 9.5, 14.5, 9, 11.5, 15.5), box(4.5, 9.5, 14.5, 6.5, 11.5, 15.5), box(9.5, 7, 14.5, 11.5, 9, 15.5), box(7, 7, 14.5, 9, 9, 15.5), box(4.5, 7, 14.5, 6.5, 9, 15.5),
					box(9.5, 4.5, 14.5, 11.5, 6.5, 15.5), box(7, 4.5, 14.5, 9, 6.5, 15.5), box(4.5, 4.5, 14.5, 6.5, 6.5, 15.5), box(9.5, 2, 14.5, 11.5, 4, 15.5), box(7, 2, 14.5, 9, 4, 15.5), box(4.5, 2, 14.5, 6.5, 4, 15.5), box(3, 1, 15, 13, 12, 16),
					box(12, 12, 15, 13, 15, 16), box(3, 12, 15, 4, 15, 16), box(4, 14, 15, 12, 15, 16), box(4, 12, 15.25, 12, 14, 15.75));
			case EAST -> Shapes.or(box(0.5, 9.5, 9.5, 1.5, 11.5, 11.5), box(0.5, 9.5, 7, 1.5, 11.5, 9), box(0.5, 9.5, 4.5, 1.5, 11.5, 6.5), box(0.5, 7, 9.5, 1.5, 9, 11.5), box(0.5, 7, 7, 1.5, 9, 9), box(0.5, 7, 4.5, 1.5, 9, 6.5),
					box(0.5, 4.5, 9.5, 1.5, 6.5, 11.5), box(0.5, 4.5, 7, 1.5, 6.5, 9), box(0.5, 4.5, 4.5, 1.5, 6.5, 6.5), box(0.5, 2, 9.5, 1.5, 4, 11.5), box(0.5, 2, 7, 1.5, 4, 9), box(0.5, 2, 4.5, 1.5, 4, 6.5), box(0, 1, 3, 1, 12, 13),
					box(0, 12, 12, 1, 15, 13), box(0, 12, 3, 1, 15, 4), box(0, 14, 4, 1, 15, 12), box(0.25, 12, 4, 0.75, 14, 12));
			case WEST -> Shapes.or(box(14.5, 9.5, 4.5, 15.5, 11.5, 6.5), box(14.5, 9.5, 7, 15.5, 11.5, 9), box(14.5, 9.5, 9.5, 15.5, 11.5, 11.5), box(14.5, 7, 4.5, 15.5, 9, 6.5), box(14.5, 7, 7, 15.5, 9, 9), box(14.5, 7, 9.5, 15.5, 9, 11.5),
					box(14.5, 4.5, 4.5, 15.5, 6.5, 6.5), box(14.5, 4.5, 7, 15.5, 6.5, 9), box(14.5, 4.5, 9.5, 15.5, 6.5, 11.5), box(14.5, 2, 4.5, 15.5, 4, 6.5), box(14.5, 2, 7, 15.5, 4, 9), box(14.5, 2, 9.5, 15.5, 4, 11.5), box(15, 1, 3, 16, 12, 13),
					box(15, 12, 3, 16, 15, 4), box(15, 12, 12, 16, 15, 13), box(15, 14, 4, 16, 15, 12), box(15.25, 12, 4, 15.75, 14, 12));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState blockstate, BlockGetter blockAccess, BlockPos pos, Direction direction) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Level world = (Level) blockAccess;
		return (int) DigicodeEmittedRedstonePowerProcedure.execute(world, x, y, z);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.WALKABLE;
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		DigicodeBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Digicode");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new DigicodeInterfaceMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new DigicodeBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof DigicodeBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof DigicodeBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
