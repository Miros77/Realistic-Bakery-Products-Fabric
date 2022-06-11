package rbp.registry.block.stages;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import rbp.registry.ModRegistry;

import rbp.registry.block.cake.properties.PropertiesBites;

public class CheeseFlatBreadBeetrootSlices extends Block {

    public static final IntProperty LEVEL_4;
    public static final VoxelShape[] LEVEL_4_TO_SHAPE;
    public CheeseFlatBreadBeetrootSlices() {
        super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
        this.setDefaultState((BlockState)((BlockState)
        this.stateManager.getDefaultState()).with(LEVEL_4, 0));
    }



    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_4_TO_SHAPE[(Integer)state.get(LEVEL_4)];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == ModRegistry.SAUSAGE_SLICE) {

            if (!world.isClient) {

                int i = (Integer)state.get(LEVEL_4);
                if (i < 16) {
                    world.setBlockState(pos, (BlockState)state.with(LEVEL_4, i + 1), 3);
                    if  (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    } else {
                        world.removeBlock(pos, true);
                    }
                    return ActionResult.SUCCESS;
                }

            }

            return ActionResult.PASS;
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
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
