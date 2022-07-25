package rbp.registry.item.change;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rbp.registry.ModRegistry;

import java.util.Map;
public class Rolling_Pin extends Item {

    protected static final Map<Block, Block> STRIPPED_BLOCKS;

    public Rolling_Pin(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = (Block)STRIPPED_BLOCKS.get(blockState.getBlock());
        if (block != null) {
            PlayerEntity playerEntity = context.getPlayer();
            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClient) {
                world.setBlockState(blockPos, (BlockState)block.getDefaultState(), 11);
            }

            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    static {
        STRIPPED_BLOCKS = (new ImmutableMap.Builder<Block, Block>())
                .put(ModRegistry.MILK_DOUGH, ModRegistry.FLAT_BREAD)
                .put(ModRegistry.FLAT_BREAD, ModRegistry.FLAT_BREAD_1)
                .put(ModRegistry.CHOCOLATE_DOUGH, ModRegistry.FLAT_CHOCOLATE)
                .put(ModRegistry.HONEY_DOUGH, ModRegistry.FLATHONEY)
                .build();
    }
}




