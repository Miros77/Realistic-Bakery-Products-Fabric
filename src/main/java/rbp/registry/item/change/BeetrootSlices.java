package rbp.registry.item.change;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import rbp.registry.ModRegistry;

public class BeetrootSlices extends Item {

    public static final Map<Block, BlockState> TILLED_BLOCKS;

    public BeetrootSlices(Settings settings) {
        super(settings);
    }

//1
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();

        if (context.getSide() != Direction.DOWN && world.getBlockState(blockPos.up()).isAir()) {
            BlockState blockState = (BlockState)TILLED_BLOCKS.get(world.getBlockState(blockPos).getBlock());
            if (blockState != null) {
                PlayerEntity playerEntity = context.getPlayer();
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClient) {
                    world.setBlockState(blockPos, blockState, 11);
                }
                if (playerEntity != null)
                    {
                        context.getStack().decrement(1);
                    }
                return ActionResult.success(world.isClient);
            }
        }

        return ActionResult.PASS;
    }


    static {

        TILLED_BLOCKS = Maps.newHashMap(ImmutableMap.of(
                ModRegistry.STRAWBERRYBUSH, ModRegistry.STRAWBERRYBUSH_HAY.getDefaultState()
        ));
    }
}
