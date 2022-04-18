package rbp.registry.block.cake;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

//import net.minecraft.item.Item;
//Item
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//Block
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
//import net.minecraft.block.entity.BlockEntity;

//Sound
import net.minecraft.sound.BlockSoundGroup;

//My
import rbp.registry.ModRegistry;

//Block
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CandleBlock;
import net.minecraft.block.CandleCakeBlock;

//Effects
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class RawChokoladeCakeBlock extends CakeBlock {
	public RawChokoladeCakeBlock() {
		super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	   return BITES_TO_SHAPE[(Integer)state.get(BITES)];
	}

	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getStackInHand(hand);
		Item item = itemStack.getItem();
		if (itemStack.isIn(ItemTags.BUTTONS) && (Integer)state.get(BITES) == 0) {
		   Block block = Block.getBlockFromItem(item);
		   if (block instanceof CandleBlock) {
			  if (!player.isCreative()) {
				 itemStack.decrement(1);
			  }
  
			  world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
			  world.setBlockState(pos, CandleCakeBlock.getCandleCakeFromCandle(block));
			  world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
			  player.incrementStat(Stats.USED.getOrCreateStat(item));
			  return ActionResult.SUCCESS;
		   }
		}
  
		if (world.isClient) {
		   if (tryEat(world, pos, state, player).isAccepted()) {
			  return ActionResult.SUCCESS;
		   }
  
		   if (itemStack.isEmpty()) {
			  return ActionResult.CONSUME;
		   }
		}
  
		return tryEat(world, pos, state, player);
	 }
  //
     
  protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
   if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_SPOON && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_SPOON && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.IRON_SPOON && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.GOLDEN_SPOON){
	   return ActionResult.PASS;
   } else if (!player.canConsume(true)) {
      return ActionResult.PASS;
	} else {
	   player.incrementStat(Stats.EAT_CAKE_SLICE);
      player.getHungerManager().add(2, 0.1F);
      player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0));
	   int i = (Integer)state.get(BITES);
	   world.emitGameEvent(player, GameEvent.EAT, (BlockPos)pos);
	   if (i < 6) {
		  world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), Block.NOTIFY_ALL);
	   } else {
		  world.removeBlock(pos, false);
		  world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, (BlockPos)pos);
	   }

	   return ActionResult.SUCCESS;
	}
 }
//
	 public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	 }
  
	 public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return world.getBlockState(pos.down()).getMaterial().isSolid();
	 }
  
	 protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(BITES);
	 }
  
	 public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
		return (7 - (Integer)state.get(BITES)) * 2;
	 }
  
	 public boolean hasComparatorOutput(BlockState state) {
		return true;
	 }
  
	 public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	 }
  }