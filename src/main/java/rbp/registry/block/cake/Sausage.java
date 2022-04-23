package rbp.registry.block.cake;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import rbp.registry.ModRegistry;

public class Sausage extends CakeBlock {
   public static final IntProperty BITES;
   protected static final VoxelShape[] BITES_TO_SHAPE;

   public Sausage() {
		super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque().build());
	}

   public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
      return BITES_TO_SHAPE[(Integer)state.get(BITES)];
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      if (world.isClient) {
         ItemStack itemStack = player.getStackInHand(hand);
         if (this.tryEat(world, pos, state, player) == ActionResult.SUCCESS) {
            return ActionResult.SUCCESS;
         }

         if (itemStack.isEmpty()) {
            return ActionResult.CONSUME;
         }
      }

      return this.tryEat(world, pos, state, player);
   }

   private ActionResult tryEat(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
    if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.GOLDEN_KNIFE){
         return ActionResult.PASS;
      } else if (!player.canConsume(true)) {
         return ActionResult.PASS;
    } else {
       player.incrementStat(Stats.EAT_CAKE_SLICE);
	   world.spawnEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModRegistry.SAUSAGE_SLICE, 1)));
         int i = (Integer)state.get(BITES);
         if (i < 6) {
            world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
         } else {
            world.removeBlock(pos, false);
         }

         return ActionResult.SUCCESS;
      }
   }

   public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
      return facing == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
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

   public boolean canPlaceAtSide(BlockState world, BlockView view, BlockPos pos, BlockPlacementEnvironment env) {
      return false;
   }

   static {
      BITES = Properties.BITES;
      BITES_TO_SHAPE = new VoxelShape[]{
		Block.createCuboidShape(1D, 0D, 4.500000000000002D, 15D, 8D, 11.500000000000002D),
		Block.createCuboidShape(3D, 0D, 4.500000000000002D, 15D, 8D, 11.500000000000002D), 
		Block.createCuboidShape(5D, 0D, 4.500000000000002D, 15D, 9D, 11.500000000000002D), 
		Block.createCuboidShape(7D, 0D, 4.500000000000002D, 15D, 9D, 11.500000000000002D), 
		Block.createCuboidShape(9D, 0D, 4.500000000000002D, 15D, 9D, 11.500000000000002D), 
		Block.createCuboidShape(11D, 0D, 4.500000000000002D, 15D, 9D, 11.500000000000002D), 
		Block.createCuboidShape(13D, 0D, 4.500000000000002D, 14D, 7D, 11.500000000000002D)};
   }
}