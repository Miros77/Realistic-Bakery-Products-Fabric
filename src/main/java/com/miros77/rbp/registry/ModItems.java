package com.miros77.rbp.registry;

//=========================================Imports=========================================//


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
//import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
//import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

//Item
import com.miros77.rbp.Tutorial;
//import net.minecraft.item.Item;
import net.minecraft.item.Items;
//import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
import net.minecraft.item.FoodComponent;

//Cake
import com.miros77.rbp.registry.all_cake.ModCakeBlock;

//Crop
//import com.miros77.rbp.registry.all_cake.CropBlockMod;
import com.miros77.rbp.registry.all_cake.BerryBushBlock;

//Group
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

//Block
//import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.Material;
import net.minecraft.item.AliasedBlockItem;
//import net.minecraft.item.BlockItem;

//BottledFoodItem
import net.minecraft.item.HoneyBottleItem;

//Effect
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModItems {
//=========================================ItemGroup=========================================//
    public static final ItemGroup REALISTIC_BAKERY_PRODUCTS = FabricItemGroupBuilder.build(
		new Identifier("realistic_bakery_products"),
        () -> new ItemStack(ModItems.RAW_BREAD));

//=========================================Make Item, Block=========================================//
    //Food   
    public static final Item FLOUR = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS)); 
      //DOUGH
      public static final Item DOUGH = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
      public static final Item RAW_HONEY_SHORTCAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
      
    
    //Raw Food  
    public static final Item RAW_BREAD = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS));
    public static final Item RAW_COOKIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    //Crop Item
    //public static final Item STRAWBERRY = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    
    //Pie
    public static final Item RAW_PUMPKIN_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()).maxCount(1));
    public static final Item BERRIES_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).build()));
    public static final Item HONEY_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build()));
    public static final Item MELON_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));
    public static final Item CARROT_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));

    // Raw Pie
    public static final Item RAW_BERRIES_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_MELON_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CARROT_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    //Raw Cake
    public static final Item RAW_HONEY_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
    public static final Item RAW_CHOCOLATE_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
    public static final Item RAW_STRAWBERRY_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
      //SHORTCAKE


    //Cream
    public static Item CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item CHOCOLATE_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item STRAWBERRY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item HONEY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
     
    //Donut
    public static final Item COKED_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build()));
    public static final Item CREAM_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5f).build()));
    public static final Item STRAWBERRY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(9).saturationModifier(0.8f).build()));
    public static final Item HONEY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    
    //Raw Donut
    public static final Item RAW_CREAM_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_STRAWBERRY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
  //Block
    //Crop
    //public static final BerryBushBlock STRAWBERRY = new BerryBushBlock(FabricBlockSettings.of(Material.PLANT));
    public static final BerryBushBlock STRAWBERRYBUSH = new BerryBushBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly()
                        .breakInstantly());
     //Cake
    public static Block STRAWBERRY_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));
    public static Block HONEY_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));
    public static Block CHOCOLATE_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));

//=========================================Register Items, Block=========================================//
    public static void registerItems() {
    //Item
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "dough"), DOUGH);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "flour"), FLOUR);
       
        //Raw Food
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_bread"), RAW_BREAD);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cake"), RAW_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cookie"), RAW_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_pumpkin_pie"), RAW_PUMPKIN_PIE);
        
        //Pie
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_pie"), BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_pie"), HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "melon_pie"), MELON_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "carrot_pie"), CARROT_PIE);
        
        //Raw Pie
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_berries_pie"), RAW_BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_pie"), RAW_HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_melon_pie"), RAW_MELON_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_carrot_pie"), RAW_CARROT_PIE);
        
        //Cream
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "cream"), CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_cream"), CHOCOLATE_CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "strawberry_cream"), STRAWBERRY_CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_cream"), HONEY_CREAM);
        
        //Raw Cake
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_cake"), RAW_HONEY_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_chocolate_cake"), RAW_CHOCOLATE_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_strawberry_cake"), RAW_STRAWBERRY_CAKE);

          //SHORTCAKE
          Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_shortcake"), RAW_HONEY_SHORTCAKE);
        
        //Donuts
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "coked_donut"), COKED_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "cream_donut"), CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "strawberry_donut"), STRAWBERRY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_donut"), CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_donut"), HONEY_DONUT);

        //Raw Donuts
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cream_donut"), RAW_CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_strawberry_donut"), RAW_STRAWBERRY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_chocolate_donut"), RAW_CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_donut"), RAW_HONEY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_donut"), RAW_DONUT);

    //BlockItem
        //Crop
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "strawberry"), new AliasedBlockItem(STRAWBERRYBUSH, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build())));
        
        //Cake
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_cake"), new BlockItem(HONEY_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_cake"), new BlockItem(CHOCOLATE_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "strawberry_cake"), new BlockItem(STRAWBERRY_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        
    //Block
        //Crop
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID,"strawberrybush"), STRAWBERRYBUSH);
        
        //Cake
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "honey_cake"), HONEY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "chocolate_cake"), CHOCOLATE_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "strawberry_cake"), STRAWBERRY_CAKE);
    }

}
