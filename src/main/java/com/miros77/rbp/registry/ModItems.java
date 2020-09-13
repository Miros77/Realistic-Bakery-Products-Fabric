package com.miros77.rbp.registry;

import com.miros77.rbp.registry.all_cake.ModCakeBlock;
import com.miros77.rbp.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.FoodComponent;
//import net.minecraft.block.CakeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;


public class ModItems {

    public static final Item DOUGH = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item FLOUR = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static final Item RAW_BREAD = new Item(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item RAW_CAKE = new Item(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item RAW_COOKIE = new Item(new Item.Settings().group(ItemGroup.FOOD));
    // PIE
    public static final Item RAW_PUMPKIN_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD));

    public static final Item BERRIES_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).build()));
    public static final Item HONEY_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build()));
    public static final Item MELON_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));

    // RAW_PIE
    public static final Item RAW_BERRIES_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item RAW_HONEY_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item RAW_MELON_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD));
    // BLOCK
    public static Block HONEY_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));

    public static void registerItems() {
            //item
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "dough"), DOUGH);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "flour"), FLOUR);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_bread"), RAW_BREAD);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cake"), RAW_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cookie"), RAW_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_pumpkin_pie"), RAW_PUMPKIN_PIE);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_pie"), BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_pie"), HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "melon_pie"), MELON_PIE);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_berries_pie"), RAW_BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_pie"), RAW_HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_melon_pie"), RAW_MELON_PIE);
           //blockitem
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_cake"), new BlockItem(HONEY_CAKE, new Item.Settings().group(ItemGroup.FOOD)));
           //block
           Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "honey_cake"), HONEY_CAKE);
    }

}
