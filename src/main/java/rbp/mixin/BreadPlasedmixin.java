//package com.miros77.rbp.mixin;
//
//import org.spongepowered.asm.mixin.Mixin;
//import net.minecraft.item.Items;
//import net.minecraft.item.AliasedBlockItem;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
//import com.miros77.rbp.registry.ModRegistry;
////import net.minecraft.block.Blocks;
//import net.minecraft.block.Block;
//import net.minecraft.item.ItemGroup;
//
//
//@Mixin(Items.class)
//public class BreadPlasedmixin {
//    public static final Item BREAD;
//    
////    private static Item register(Block block) {
////        return register(new BlockItem(block, new Item.Settings()));
////     }
////  
////     private static Item register(Block block, ItemGroup group) {
////        return register(new BlockItem(block, (new Item.Settings()).group(group)));
////     }
////  
////   private static Item register(BlockItem item) {
////      return register((Block)item.getBlock(), (Item)item);
////   }
////
//     protected static Item register(Block block, Item item) {
//        return register(Registry.BLOCK.getId(block), item);
//     }
//  
//     private static Item register(String id, Item item) {
//        return register(new Identifier(id), item);
//     }
//  
//     private static Item register(Identifier id, Item item) {
//        if (item instanceof BlockItem) {
//           ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
//        }
//  
//        return (Item)Registry.register(Registry.ITEM, (Identifier)id, item);
//     }
//
//    static{
//        //BREAD = register("bread", new Item((new Item.Settings()).group(ItemGroup.FOOD).food(FoodComponents.BREAD)));
//        BREAD = register((String)"bread", (Item)(new AliasedBlockItem(ModRegistry.BREADBLOCK, (new Item.Settings()).group(ItemGroup.FOOD))));
//    }
//}