package rbp.registry.block.cake.custom_cake;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import rbp.registry.ModRegistry;

public class Sausage extends Block {
   public static final int MAX_BITES = 6;
   public static final IntProperty BITES;
   public static final int DEFAULT_COMPARATOR_OUTPUT;
   protected static final float field_31047 = 1.0F;
   protected static final float field_31048 = 2.0F;
   protected static final VoxelShape[] BITES_TO_SHAPE;

   public Sausage() {
    super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
   }

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

   public ActionResult tryEat(net.minecraft.world.WorldAccess world, net.minecraft.util.math.BlockPos pos, net.minecraft.block.BlockState state, net.minecraft.entity.player.PlayerEntity player) {
	//helped fix : Reece
	
	/*if (stack.getItem() == Items.IRON_SWORD || player.getStackInHand(Hand.OFF_HAND).getItem() == Items.IRON_SWORD)*/ 
	  if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.GOLDEN_KNIFE)
  {
	   return ActionResult.PASS;
	} else if (!player.canConsume(true)) {
	   return ActionResult.PASS;
	} else {
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

   public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
      return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
      return world.getBlockState(pos.down()).getMaterial().isSolid();
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(BITES);
   }

   public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
      return getComparatorOutput((Integer)state.get(BITES));
   }

   public static int getComparatorOutput(int bites) {
      return (7 - bites) * 2;
   }

   public boolean hasComparatorOutput(BlockState state) {
      return true;
   }

   public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
      return false;
   }

   static {
      BITES = Properties.BITES;
      DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);
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