
package net.mcreator.krusader_security.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootParams;
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
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.krusader_security.world.inventory.PCLogingMenu;
import net.mcreator.krusader_security.block.entity.PCBlockEntity;

import java.util.List;
import java.util.Collections;

import io.netty.buffer.Unpooled;

public class PCBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PCBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LADDER).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
				default ->
					Shapes.or(box(4, 0, 5, 12, 0.5, 11), box(6.75, 0, 7, 9.25, 2.5, 9.5), box(4, 3, 5, 12, 10, 11), box(3, 2, 4, 13, 3, 12), box(3, 10, 4, 13, 11, 12), box(12, 3, 5, 13, 10, 12), box(3, 3, 5, 4, 10, 12), box(3, 3, 4, 13, 10, 5));
				case NORTH ->
					Shapes.or(box(4, 0, 5, 12, 0.5, 11), box(6.75, 0, 6.5, 9.25, 2.5, 9), box(4, 3, 5, 12, 10, 11), box(3, 2, 4, 13, 3, 12), box(3, 10, 4, 13, 11, 12), box(3, 3, 4, 4, 10, 11), box(12, 3, 4, 13, 10, 11), box(3, 3, 11, 13, 10, 12));
				case EAST ->
					Shapes.or(box(5, 0, 4, 11, 0.5, 12), box(7, 0, 6.75, 9.5, 2.5, 9.25), box(5, 3, 4, 11, 10, 12), box(4, 2, 3, 12, 3, 13), box(4, 10, 3, 12, 11, 13), box(5, 3, 3, 12, 10, 4), box(5, 3, 12, 12, 10, 13), box(4, 3, 3, 5, 10, 13));
				case WEST ->
					Shapes.or(box(5, 0, 4, 11, 0.5, 12), box(6.5, 0, 6.75, 9, 2.5, 9.25), box(5, 3, 4, 11, 10, 12), box(4, 2, 3, 12, 3, 13), box(4, 10, 3, 12, 11, 13), box(4, 3, 12, 11, 10, 13), box(4, 3, 3, 11, 10, 4), box(11, 3, 3, 12, 10, 13));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(4, 0, 5, 12, 0.5, 11), box(6.75, 0, 7, 9.25, 2.5, 9.5), box(4, 3, 5, 12, 10, 11), box(3, 2, 4, 13, 3, 12), box(3, 10, 4, 13, 11, 12), box(12, 3, 5, 13, 10, 12), box(3, 3, 5, 4, 10, 12), box(3, 3, 4, 13, 10, 5));
			case NORTH ->
				Shapes.or(box(4, 0, 5, 12, 0.5, 11), box(6.75, 0, 6.5, 9.25, 2.5, 9), box(4, 3, 5, 12, 10, 11), box(3, 2, 4, 13, 3, 12), box(3, 10, 4, 13, 11, 12), box(3, 3, 4, 4, 10, 11), box(12, 3, 4, 13, 10, 11), box(3, 3, 11, 13, 10, 12));
			case EAST -> Shapes.or(box(5, 0, 4, 11, 0.5, 12), box(7, 0, 6.75, 9.5, 2.5, 9.25), box(5, 3, 4, 11, 10, 12), box(4, 2, 3, 12, 3, 13), box(4, 10, 3, 12, 11, 13), box(5, 3, 3, 12, 10, 4), box(5, 3, 12, 12, 10, 13), box(4, 3, 3, 5, 10, 13));
			case WEST ->
				Shapes.or(box(5, 0, 4, 11, 0.5, 12), box(6.5, 0, 6.75, 9, 2.5, 9.25), box(5, 3, 4, 11, 10, 12), box(4, 2, 3, 12, 3, 13), box(4, 10, 3, 12, 11, 13), box(4, 3, 12, 11, 10, 13), box(4, 3, 3, 11, 10, 4), box(11, 3, 3, 12, 10, 13));
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
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Computer");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new PCLogingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
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
		return new PCBlockEntity(pos, state);
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
			if (blockEntity instanceof PCBlockEntity be) {
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
		if (tileentity instanceof PCBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
