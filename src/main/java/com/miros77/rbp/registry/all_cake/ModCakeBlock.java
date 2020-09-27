package com.miros77.rbp.registry.all_cake;


  import net.minecraft.block.CakeBlock;

  //not realised
  //import net.minecraft.block.BlockState;
  //import net.minecraft.entity.player.PlayerEntity;
  //import net.minecraft.item.ItemStack;
  //import net.minecraft.stat.Stats;
  //import net.minecraft.util.ActionResult;
  //import net.minecraft.util.Hand;
  //import net.minecraft.util.hit.BlockHitResult;
  //import net.minecraft.util.math.BlockPos;
  //import net.minecraft.world.World;
  //import net.minecraft.world.WorldAccess;

public class ModCakeBlock extends CakeBlock {
	public ModCakeBlock(Settings settings) {
		super(settings);
	}


//not realised

//@Override
//public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (world.isClient) {
//            ItemStack itemStack = player.getStackInHand(hand);
//            if (this.tryEat(world, pos, state, player).isAccepted()) {
//                return ActionResult.SUCCESS;
//            }
//
//            if (itemStack.isEmpty()) {
//                return ActionResult.CONSUME;
//            }
//        }
// 
//        return this.tryEat(world, pos, state, player);
//	}
//	//not realised(lock)
//@Override
//public ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
//        if (!player.canConsume(false)) {
//            return ActionResult.PASS;
//        } else {
//            player.incrementStat(Stats.EAT_CAKE_SLICE);
//            player.getHungerManager().add(2, 0.1F);
//            int i = (Integer)state.get(BITES);
//            if (i < 6) {
//                world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
//            } else {
//                world.removeBlock(pos, false);
//            }
//
//            return ActionResult.SUCCESS;
//        }
//	}
}	
