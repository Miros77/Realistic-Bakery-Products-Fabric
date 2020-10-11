package com.miros77.rbp.registry.all_cake.cheese;

//Item
import net.minecraft.item.ItemStack;
import com.miros77.rbp.registry.ModItems;

//Block
import net.minecraft.block.Material;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;

//Util
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.entity.ItemEntity;
//Entity
import net.minecraft.entity.player.PlayerEntity;
//Stats
import net.minecraft.stat.Stats;

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
		super(FabricBlockSettings.of(Material.CAKE));
	}

   //========================================new

   //public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	//	if (worldIn.isRemote) {
	//		ItemStack itemstack = player.getHeldItem(handIn);
	//		if (eatBlock(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
	//			return ActionResultType.SUCCESS;
	//		}
//
	//		if (itemstack.isEmpty()) {
	//			return ActionResultType.CONSUME;
	//		}
	//	}
//
	//	return eatBlock(worldIn, pos, state, player);
	//}
//
	//private ActionResultType eatBlock(IWorld world, BlockPos pos, BlockState state, PlayerEntity entity) {
	//	int bites = state.get(BITES);
	//	world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.CHEESE, 1)));
	//	if (bites < 6) {
	//		world.setBlockState(pos, state.with(BITES, bites + 1), Constants.BlockFlags.DEFAULT);
	//	} else {
	//		world.removeBlock(pos, false);
	//	}
//
	//	return ActionResultType.SUCCESS;
	//}

   //========================================old
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
      if (!player.canConsume(false)) {
         return ActionResult.PASS;
      } else {
         world.spawnEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.CHEESE_SLICE, 1)));
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
