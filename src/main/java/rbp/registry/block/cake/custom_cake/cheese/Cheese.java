package rbp.registry.block.cake.custom_cake.cheese;

//Item
import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
import rbp.registry.ModRegistry;
//import net.minecraft.item.Items;

//Block
import net.minecraft.block.Material;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;

//Sound
import net.minecraft.sound.BlockSoundGroup;

//Util
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.entity.ItemEntity;
//Entity
import net.minecraft.entity.player.PlayerEntity;
//Stats


//World

import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

//NEW


//Not use
  //import net.minecraft.entity.ai.pathing.NavigationType;
  //import net.minecraft.item.ItemStack;
  //import net.minecraft.world.WorldView;
  //import net.minecraft.util.math.Direction;
  //import net.minecraft.util.shape.VoxelShape;
  //import net.minecraft.world.BlockView;
  //import net.minecraft.world.World;
  //import net.minecraft.state.StateManager;
  //import net.minecraft.state.property.IntProperty;
  //import net.minecraft.state.property.Properties;
  //import net.minecraft.util.Hand;
  //import net.minecraft.util.hit.BlockHitResult;
//Not use  

public class Cheese extends CakeBlock {
	public Cheese() {
		super(FabricBlockSettings.of(Material.CAKE).ticksRandomly().sounds(BlockSoundGroup.CORAL).nonOpaque());
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

   public ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
		//helped fix : Reece
		
		/*if (stack.getItem() == Items.IRON_SWORD || player.getStackInHand(Hand.OFF_HAND).getItem() == Items.IRON_SWORD)*/ 
          if (player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.MAIN_HAND).getItem() != ModRegistry.GOLDEN_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.IRON_KNIFE && player.getStackInHand(Hand.OFF_HAND).getItem() != ModRegistry.GOLDEN_KNIFE)
      {
           return ActionResult.PASS;
        } else if (!player.canConsume(true)) {
           return ActionResult.PASS;
        } else {
           world.spawnEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModRegistry.CHEESE_SLICE, 1)));
           int i = (Integer)state.get(BITES);
           if (i < 6) {
              world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
           } else {
              world.removeBlock(pos, false);
           }

           return ActionResult.SUCCESS;
        }
     }


}