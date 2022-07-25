package rbp.registry.block.cake;

//Item
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

//Block
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;

//Sound
import net.minecraft.sound.BlockSoundGroup;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

//Util
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

//Entity
import net.minecraft.entity.player.PlayerEntity;

//Stats
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

//World

import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

//New
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import rbp.registry.ModRegistry;
import rbp.registry.block.stages.properties.PropertiesBites;

//Sound

public class Pizza extends Block {

   public Pizza() {
      super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
   }
   
   public static final IntProperty BITES;
   protected static final VoxelShape[] BITES_TO_SHAPE;
   
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return BITES_TO_SHAPE[(Integer)state.get(BITES)];
   }

   @Override
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      ItemStack itemStack = player.getStackInHand(hand);
      if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_KNIFE) {

         if (!world.isClient)  {

            int i = (Integer)state.get(BITES);
            world.spawnEntity(new ItemEntity((World) world, pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5, new ItemStack(ModRegistry.PIZZA_SLICE, 1)));
            if (i < 3) {
               world.setBlockState(pos, (BlockState)state.with(BITES, i + 1),3);
               return ActionResult.PASS;
            } else {
               world.removeBlock(pos, false);
            }
         }

         return ActionResult.SUCCESS;
      } else {
         return super.onUse(state, world, pos, player, hand, hit);
      }
   }

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

   static {
      BITES = PropertiesBites.LEVEL_4;
      BITES_TO_SHAPE = new VoxelShape[]{
         Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 0.6D, 15.0D), 
         Block.createCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 0.6D, 15.0D), 
         Block.createCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 0.6D, 15.0D), 
         Block.createCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 0.6D, 15.0D)};
   }
   
}
