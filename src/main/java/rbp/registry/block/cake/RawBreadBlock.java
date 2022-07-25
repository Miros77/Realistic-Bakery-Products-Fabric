package rbp.registry.block.cake;

//import net.minecraft.item.Item;
//Item
//import net.minecraft.item.Items;
//Block
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
//import net.minecraft.block.entity.BlockEntity;

//Sound
import net.minecraft.sound.BlockSoundGroup;

//My

//Block
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

//Util
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

//Entity

//Stats
//import net.minecraft.stat.Stats;

//World

        import net.minecraft.world.WorldAccess;

//New
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

//Sound

//World
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;

public class RawBreadBlock extends Block{
	public static final VoxelShape SHAPE = Block.createCuboidShape(2.0999999999999996, 0, 5.1, 10.9, 5, 10.9);

	public RawBreadBlock() {
		super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}


	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	}

	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return world.getBlockState(pos.down()).getMaterial().isSolid();
	}

	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	}
}