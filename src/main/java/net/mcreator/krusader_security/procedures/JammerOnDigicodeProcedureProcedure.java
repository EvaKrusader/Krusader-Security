package net.mcreator.krusader_security.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.krusader_security.network.KrusaderSecurityModVariables;
import net.mcreator.krusader_security.init.KrusaderSecurityModItems;
import net.mcreator.krusader_security.KrusaderSecurityMod;

import javax.annotation.Nullable;

import java.util.Calendar;

@Mod.EventBusSubscriber
public class JammerOnDigicodeProcedureProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double dayLength = 0;
		double minutesLength = 0;
		double monthLength = 0;
		double randomDigit = 0;
		double hoursLength = 0;
		double secondsLength = 0;
		String hoursString = "";
		String daysString = "";
		String minutesString = "";
		String secondsString = "";
		String monthsStrings = "";
		String isJammed = "";
		ItemStack whatJammer = ItemStack.EMPTY;
		secondsLength = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.SECOND))).length();
		minutesLength = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MINUTE))).length();
		hoursLength = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))).length();
		dayLength = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))).length();
		monthLength = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH))).length();
		if (secondsLength == 1) {
			secondsString = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.SECOND));
		} else if (secondsLength == 2) {
			secondsString = new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.SECOND));
		}
		if (minutesLength == 1) {
			minutesString = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MINUTE));
		} else if (minutesLength == 2) {
			minutesString = new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MINUTE));
		}
		if (hoursLength == 1) {
			hoursString = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		} else if (hoursLength == 2) {
			hoursString = new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		}
		if (dayLength == 1) {
			daysString = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		} else if (dayLength == 2) {
			daysString = new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		}
		if (monthLength == 1) {
			monthsStrings = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH) + 1);
		} else if (monthLength == 2) {
			monthsStrings = new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH) + 1);
		}
		if (blockstate.is(BlockTags.create(new ResourceLocation("minecraft:digicodes")))) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KrusaderSecurityModItems.JAMMER_IMPROVISED.get()) {
					whatJammer = new ItemStack(KrusaderSecurityModItems.JAMMER_IMPROVISED.get());
					if (Math.random() > 0.9) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("typingPassword", (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "realPassword")));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7asucceeded";
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("krusader_security:jammer_cheap"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						OnButtonVClickedProcedure.execute(world, x, y, z, entity);
						KrusaderSecurityMod.queueServerWork(100, () -> {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("typingPassword", "");
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							OnButtonVClickedProcedure.execute(world, x, y, z, entity);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("justJammed", false);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						});
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7cfailed";
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KrusaderSecurityModItems.JAMMER_NORMAL.get()) {
					whatJammer = new ItemStack(KrusaderSecurityModItems.JAMMER_NORMAL.get());
					if (Math.random() > 0.5) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("typingPassword", (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "realPassword")));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7asucceeded";
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						OnButtonVClickedProcedure.execute(world, x, y, z, entity);
						{
							double _setval = (entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).JammerUses + 1;
							entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JammerUses = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if ((entity.getCapability(KrusaderSecurityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KrusaderSecurityModVariables.PlayerVariables())).JammerUses > 9) {
							if (entity instanceof ServerPlayer _serverPlayer)
								_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("krusader_security:jammer_elite_recipe")});
						}
						KrusaderSecurityMod.queueServerWork(100, () -> {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("typingPassword", "");
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							OnButtonVClickedProcedure.execute(world, x, y, z, entity);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("justJammed", false);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						});
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7cfailed";
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KrusaderSecurityModItems.JAMMER_ELITE.get()) {
					whatJammer = new ItemStack(KrusaderSecurityModItems.JAMMER_ELITE.get());
					if (Math.random() > 0.01) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("typingPassword", (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "realPassword")));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7asucceeded";
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						OnButtonVClickedProcedure.execute(world, x, y, z, entity);
						KrusaderSecurityMod.queueServerWork(100, () -> {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("typingPassword", "");
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							OnButtonVClickedProcedure.execute(world, x, y, z, entity);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("justJammed", false);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						});
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("justJammed", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						isJammed = "\u00A7cfailed";
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("krusader_security:jammer_elite"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (whatJammer.getItem() == KrusaderSecurityModItems.JAMMER_IMPROVISED.get() || whatJammer.getItem() == KrusaderSecurityModItems.JAMMER_NORMAL.get() || whatJammer.getItem() == KrusaderSecurityModItems.JAMMER_ELITE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("howManyJams", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "howManyJams") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putString(("jam" + new java.text.DecimalFormat("###").format(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "howManyJams"))),
									("J : " + ("<" + entity.getDisplayName().getString() + ">")
											+ (" jammed this digicode with a " + (whatJammer.getDisplayName().getString()).substring(0, (int) ((whatJammer.getDisplayName().getString()).length() - 0))) + (" and \u00A7n" + isJammed + "\u00A7r\u00A7f ")
											+ " at " + ((hoursString + ":") + "" + (minutesString + ":") + secondsString) + " on "
											+ ((daysString + "/") + "" + (monthsStrings + "/") + new java.text.DecimalFormat("####").format(Calendar.getInstance().get(Calendar.YEAR)))));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
	}
}
