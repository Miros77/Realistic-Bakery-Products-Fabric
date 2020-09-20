package com.miros77.rbp.registry;

//item
import com.miros77.rbp.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.FoodComponent;
//Cake
import com.miros77.rbp.registry.all_cake.ModCakeBlock;
//Group
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
//Block
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
//BottledFoodItem
import net.minecraft.item.HoneyBottleItem;
//Effect
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
public class ModItems {

    public static final ItemGroup REALISTIC_BAKERY_PRODUCTS = FabricItemGroupBuilder.build(
		new Identifier("Tutorial.MOD_ID"),
        () -> new ItemStack(ModItems.RAW_BREAD));
        
        
    public static final Item DOUGH = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
    public static final Item FLOUR = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS));

    public static final Item RAW_BREAD = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS));
    public static final Item RAW_COOKIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    // PIE
    public static final Item RAW_PUMPKIN_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()).maxCount(1));

    public static final Item BERRIES_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).build()));
    public static final Item HONEY_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build()));
    public static final Item MELON_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));

    // RAW_PIE
    public static final Item RAW_BERRIES_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_MELON_PIE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));

    //RAW_CAKE
    public static final Item RAW_HONEY_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
    public static final Item RAW_CHOCOLATE_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
    public static final Item RAW_BERRIES_CAKE = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1));
   
    //CREAM
        //public static final Item CREAM = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS));
//old   //public static final Item CHOCOLATE_CREAM = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS)); 
        //public static final Item BERRIES_CREAM = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS)); 

    public static Item CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item CHOCOLATE_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item BERRIES_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item HONEY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
     
    //Donut
    public static final Item COKED_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build()));
    public static final Item CREAM_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5f).build()));
    public static final Item BERRIES_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(9).saturationModifier(0.8f).build()));
    public static final Item HONEY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    //RAW DONUT
    public static final Item RAW_CREAM_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_BERRIES_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_DONUT = new Item(new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
     // BLOCK
    public static Block BERRIES_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));
    public static Block HONEY_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));
    public static Block CHOCOLATE_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));

    public static void registerItems() {
        //item
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "dough"), DOUGH);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "flour"), FLOUR);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_bread"), RAW_BREAD);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cake"), RAW_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cookie"), RAW_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_pumpkin_pie"), RAW_PUMPKIN_PIE);
        //PIE
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_pie"), BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_pie"), HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "melon_pie"), MELON_PIE);
        //RAW PIE
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_berries_pie"), RAW_BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_pie"), RAW_HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_melon_pie"), RAW_MELON_PIE);
        //CREAM
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "cream"), CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_cream"), CHOCOLATE_CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_cream"), BERRIES_CREAM);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_cream"), HONEY_CREAM);
        //RAW_CAKE
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_cake"), RAW_HONEY_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_chocolate_cake"), RAW_CHOCOLATE_CAKE);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_berries_cake"), RAW_BERRIES_CAKE);
        //DONUTS
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "coked_donut"), COKED_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "cream_donut"), CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_donut"), BERRIES_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_donut"), CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_donut"), HONEY_DONUT);

        //RAW DONUTS
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_cream_donut"), RAW_CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_berries_donut"), RAW_BERRIES_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_chocolate_donut"), RAW_CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_honey_donut"), RAW_HONEY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "raw_donut"), RAW_DONUT);
        //blockitem

        //CAKE
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "honey_cake"), new BlockItem(HONEY_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "chocolate_cake"), new BlockItem(CHOCOLATE_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "berries_cake"), new BlockItem(BERRIES_CAKE, new Item.Settings().group(ModItems.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        
        //block
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "honey_cake"), HONEY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "chocolate_cake"), CHOCOLATE_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID, "berries_cake"), BERRIES_CAKE);
    }

}
