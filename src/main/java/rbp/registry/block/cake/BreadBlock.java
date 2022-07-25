package rbp.registry.block.cake;

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
import net.minecraft.state.property.Properties;

//World

import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.ItemEntity;

//New
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

//Sound

//World
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;

public class BreadBlock extends Block {
	public BreadBlock() {
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
		if (itemStack.getItem() == ModRegistry.IRON_KNIFE || itemStack.getItem() == ModRegistry.GOLDEN_KNIFE) {

			if (!world.isClient)  {

				int i = (Integer)state.get(BITES);
				world.spawnEntity(new ItemEntity((World) world, pos.getX() + 0.0D, pos.getY() + 0.1D, pos.getZ() + 0.5D, new ItemStack(ModRegistry.BREAD_SLICE, 1)));
				if (i < 7) {
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
//
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	}

	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return world.getBlockState(pos.down()).getMaterial().isSolid();
	}

	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(BITES);
	}
  
	 static {
		BITES = Properties.BITES;
		BITES_TO_SHAPE = new VoxelShape[]{
			Block.createCuboidShape(2.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D),
			Block.createCuboidShape(3.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D), 
			Block.createCuboidShape(5.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D), 
			Block.createCuboidShape(7.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D), 
			Block.createCuboidShape(9.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D), 
			Block.createCuboidShape(11.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D), 
			Block.createCuboidShape(13.0D, 0.0D, 4.0D, 14.0D, 4.2D, 12.0D)};
	 }
	 
  }


  //2, 0, 4, 14, 4.2, 12  


  /* 


  */