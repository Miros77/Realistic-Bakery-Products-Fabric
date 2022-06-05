package rbp.registry.block.cake;

//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Material;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.sound.BlockSoundGroup;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.BlockView;
//
//public class Cheese extends Block{
//    //public static final VoxelShape SHAPE = Block.createCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
//
//    public Cheese() {
//      super(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
//  }
//
//     // public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//     //   return SHAPE;
//     //}
//}

//import net.minecraft.item.Item;
//Item
import net.minecraft.item.ItemStack;
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
//import net.minecraft.block.CakeBlock;

//Util
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

//Entity
import net.minecraft.entity.player.PlayerEntity;

//Stats
//import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
//import net.minecraft.state.property.Properties;

//World

import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.ItemEntity;

//New
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import static rbp.registry.block.cake.properties.PropertiesBites.LEVEL_13;

public class Cheese extends Block {
	public Cheese() {
		super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.CORAL).nonOpaque());
      this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
	}

   public static final IntProperty BITES;
	protected static final VoxelShape[] BITES_TO_SHAPE;

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	   return BITES_TO_SHAPE[(Integer)state.get(BITES)];
	}
   
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      if (world.isClient) {
         ItemStack itemStack = player.getStackInHand(hand);
         if (this.tryEat(world, pos, state, player).isAccepted()) {
            return ActionResult.SUCCESS;
         }

         if (itemStack.isEmpty()) {
            return ActionResult.CONSUME;
         }
      }

      return this.tryEat(world, pos, state, player);
   }

   public ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
		//helped fix : Reece
		
		/*if (stack.getItem() == Items.IRON_SWORD || player.getStackInHand(Hand.OFF_HAND).getItem() == Items.IRON_SWORD)*/ 
          if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.GOLDEN_KNIFE)
      {
           return ActionResult.PASS;
        } else if (!player.canConsume(true)) {
           return ActionResult.PASS;
        } else {
           world.spawnEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModRegistry.CHEESE_SLICE, 1)));
           int i = (Integer)state.get(BITES);
           if (i < 13) {
              world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
           } else {
              world.removeBlock(pos, false);
           }

           return ActionResult.SUCCESS;
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
         BITES = LEVEL_13;
         BITES_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(1, 0, 1, 15, 8, 15), 
            Block.createCuboidShape(2, 0, 1, 15, 8, 15), 
            Block.createCuboidShape(3, 0, 1, 15, 8, 15), 		
            Block.createCuboidShape(4, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(5, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(6, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(7, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(8, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(9, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(10, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(11, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(12, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(13, 0, 1, 15, 8, 15),		
            Block.createCuboidShape(14, 0, 1, 15, 8, 15)
         };
     }
}