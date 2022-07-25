package rbp.registry.block.stages.Pizza;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
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

import rbp.registry.block.stages.properties.PropertiesBites;

public class CheeseFlatBreadBeetrootSlices extends Block {

    public static final IntProperty LEVEL_4;
    public static final VoxelShape[] LEVEL_4_TO_SHAPE;

    public CheeseFlatBreadBeetrootSlices() {
        super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
        this.setDefaultState((BlockState) ((BlockState)
                this.stateManager.getDefaultState()).with(LEVEL_4, 0));
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_4_TO_SHAPE[(Integer) state.get(LEVEL_4)];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == ModRegistry.BEETROOT_SLICES) {

            if (!world.isClient)  {

                int i = (Integer)state.get(LEVEL_4);
                if (i < 3) {
                    world.setBlockState(pos, (BlockState)state.with(LEVEL_4, i + 1),3);
                    if  (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }
                    return ActionResult.SUCCESS;
                } else{
                    world.setBlockState(pos, (BlockState) ModRegistry.CHEESE_FLAT_BLOCK_MUSHROOM.getDefaultState(), 11);
                    if  (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        }

        else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial().isSolid();
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL_4);
    }

    static {
        LEVEL_4 = PropertiesBites.LEVEL_4;
        LEVEL_4_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15)
        };
    }
}
