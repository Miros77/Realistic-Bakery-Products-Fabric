package rbp.registry.block.cakeconstructionstages;

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

public class DoughBlockCut2 extends Block {
   public static final VoxelShape SHAPE = Block.createCuboidShape(2.0999999999999996, 0, 5.1, 13.8, 5, 10.9);
	public DoughBlockCut2() {
      super(FabricBlockSettings.of(Material.PLANT).ticksRandomly().sounds(BlockSoundGroup.WOOL).nonOpaque());
    }

          public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }
 
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
       ItemStack itemStack = player.getStackInHand(hand);
       if (itemStack.getItem() == ModRegistry.IRON_KNIFE) {
          if (!world.isClient) {
             //Direction direction = hit.getSide();
             //Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
             //!world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
             world.setBlockState(pos, (BlockState)ModRegistry.DOUGH_BLOCK_C3.getDefaultState(), 11);
             //ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)direction2.getOffsetX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction2.getOffsetZ() * 0.65D, new ItemStack(Items.PUMPKIN_SEEDS, 4));//
             //itemEntity.setVelocity(0.05D * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02D);
             //world.spawnEntity(itemEntity);
          }
 
          return ActionResult.success(world.isClient);
       } else {
          return super.onUse(state, world, pos, player, hand, hit);
       }
    }
 }
