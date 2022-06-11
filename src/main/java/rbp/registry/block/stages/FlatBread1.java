package rbp.registry.block.stages;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.GourdBlock;
//import net.minecraft.block.Material;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;

import java.util.function.Consumer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rbp.RBP;
import rbp.registry.ModRegistry;

public class FlatBread1 extends Block {
   public static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 0.6D, 15.0D);
	public FlatBread1() {
      super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
    }
    
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
       ItemStack itemStack = player.getStackInHand(hand);
       if (itemStack.getItem() == ModRegistry.CHEESE_SLICE) {
         if (!player.abilities.creativeMode) {
            itemStack.decrement(1);
         }
          if (!world.isClient) {
             world.setBlockState(pos, (BlockState)ModRegistry.CHEESE_FLAT_BLOCK.getDefaultState(), 11);
          }
 
          return ActionResult.success(world.isClient);
       } else {
          return super.onUse(state, world, pos, player, hand, hit);
       }
    }
 }