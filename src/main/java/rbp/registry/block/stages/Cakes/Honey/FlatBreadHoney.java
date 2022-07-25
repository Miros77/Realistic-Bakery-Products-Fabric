package rbp.registry.block.stages.Cakes.Honey;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class FlatBreadHoney extends Block {

    public static final IntProperty LEVEL;
    public static final VoxelShape[] LEVEL_TO_SHAPE;
    public FlatBreadHoney() {
        super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
        this.setDefaultState((BlockState)((BlockState)
        this.stateManager.getDefaultState()).with(LEVEL, 0));
    }



    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_TO_SHAPE[(Integer)state.get(LEVEL)];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == ModRegistry.FLATHONEY.asItem()) {

            if (!world.isClient) {

                int i = (Integer)state.get(LEVEL);
                if (i == 1 || i == 3 || i == 5 || i == 6) {
                    world.setBlockState(pos, (BlockState)state.with(LEVEL, i + 1),4);
                    if  (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.CONSUME;
        }

        if (itemStack.getItem() == ModRegistry.CREAM) {

            if (!world.isClient) {
                ItemStack itemStack4;
                int i = (Integer)state.get(LEVEL);
                if (i == 0 || i == 2 || i == 4) {
                    world.setBlockState(pos, (BlockState)state.with(LEVEL, i + 1),4);
                    if  (!player.abilities.creativeMode) {
                        itemStack4 = new ItemStack(Items.GLASS_BOTTLE);
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            player.setStackInHand(hand, itemStack4);
                        } else if (!player.inventory.insertStack(itemStack4)) {
                            player.dropItem(itemStack4, false);
                        }
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
        builder.add(LEVEL);
    }

    static {
        LEVEL = PropertiesBites.LEVEL_8;
        LEVEL_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15),
                Block.createCuboidShape(1, 0, 1, 15, 0.6, 15)
        };
    }
}
