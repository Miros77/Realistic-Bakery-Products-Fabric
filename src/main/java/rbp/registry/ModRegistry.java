package rbp.registry;

//=========================================Imports=========================================//

//Rbp
import rbp.RBP;
import rbp.registry.block.cake.RawChokoladeCakeBlock;
import rbp.registry.block.cake.RawHoneyCakeBlock;
import rbp.registry.block.cake.RawStrawberryCakeBlock;
import rbp.registry.block.cake.Sausage;
import rbp.registry.block.cake.ChokoladeCakeBlock;
import rbp.registry.block.cake.HoneyCakeBlock;
import rbp.registry.block.cake.StrawberryCakeBlock;
import rbp.registry.block.cake.Pizza;
import rbp.registry.block.cake.RawPizza;
import rbp.registry.block.cake.BreadBlock;
import rbp.registry.block.cake.RawBreadBlock;
import rbp.registry.block.cake.Cheese;
import rbp.registry.block.crop.StrawberryBushBlock;
import rbp.registry.block.crop.StrawberryBushBlockHay;

import rbp.*;

//Tooltip 
import rbp.registry.item.IngredientsforPizza;

import rbp.registry.item.UseKnife;
import rbp.registry.item.UseSpoon;

import rbp.registry.item.GetSausageSlice;
import rbp.registry.item.GetSliceCheese;
import rbp.registry.item.GetSliceBread;
import rbp.registry.item.GetSliceRawBread;

//import rbp.registry.item.HandMillItem;
//import rbp.registry.item.RollingPinItem;
//Group
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

//Block
import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;    
//import com.miros77.rbp.registry.block.kitchen.Freezer;

//Effect
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;

//Item
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
//Util
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;



public class ModRegistry {
//=========================================ItemGroup=========================================//
//public static final ItemGroup REALISTIC_BAKERY_PRODUCTS = FabricItemGroupBuilder.build(
//	new Identifier("realistic_bakery_products", "realistic_bakery_products"),
//    () -> new ItemStack(ModRegistry.RAW_BREADBLOCK));      

      public static final ItemGroup REALISTIC_BAKERY_PRODUCTS_NEW = FabricItemGroupBuilder.create(
        new Identifier("realistic_bakery_products", "realistic_bakery_products"))
      .icon(() -> new ItemStack(ModRegistry.RAW_BREADBLOCK)).appendItems(stacks -> {
        
      	      stacks.add(ItemStack.EMPTY);
      	      stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.FLOUR));
              stacks.add(new ItemStack(ModRegistry.COCOA_DUST));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.DOUGH));
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_DOUGH));
              stacks.add(new ItemStack(ModRegistry.HONEY_DOUGH));    //MILK_DOUGH//
              stacks.add(new ItemStack(ModRegistry.MILK_DOUGH));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.BUN));
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_BUN));
              stacks.add(new ItemStack(ModRegistry.HONEY_BUN));
              stacks.add(new ItemStack(ModRegistry.MILK_BUN));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.RAW_BREADBLOCK));
              stacks.add(new ItemStack(ModRegistry.RAW_BREAD_SLICE));
              stacks.add(new ItemStack(ModRegistry.BREADBLOCK));
              stacks.add(new ItemStack(ModRegistry.BREAD_SLICE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.RAW_COOKIE));
              stacks.add(new ItemStack(Items.COOKIE));
              stacks.add(new ItemStack(ModRegistry.CRUMBS_COOKIE));
              stacks.add(new ItemStack(ModRegistry.RAW_CHOCOLATE_COOKIE));
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_COOKIE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.STRAWBERRYBUSH));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRYBUSH_HAY));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY_BIG));
              stacks.add(new ItemStack(ModRegistry.PUMPKIN_SLICE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.RAW_CHOCOLATE_SHORTCAKE));
              stacks.add(new ItemStack(ModRegistry.CAKE_BASE));
              stacks.add(new ItemStack(ModRegistry.RAW_HONEY_SHORTCAKE));
              stacks.add(new ItemStack(ModRegistry.RAW_DONUT));
              stacks.add(new ItemStack(ModRegistry.COKED_DONUT));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);     
              stacks.add(new ItemStack(ModRegistry.PUMPKIN_SLICE));
              stacks.add(new ItemStack(Items.SWEET_BERRIES));
              stacks.add(new ItemStack(Items.CARROT));
              stacks.add(new ItemStack(Items.HONEY_BOTTLE));
              stacks.add(new ItemStack(Items.MELON_SLICE));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY));
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);         
              stacks.add(new ItemStack(ModRegistry.RAW_PUMPKIN_PIE));
              stacks.add(new ItemStack(ModRegistry.RAW_BERRIES_PIE));
              stacks.add(new ItemStack(ModRegistry.RAW_CARROT_PIE));
              stacks.add(new ItemStack(ModRegistry.RAW_HONEY_PIE));
              stacks.add(new ItemStack(ModRegistry.RAW_MELON_PIE));
              stacks.add(new ItemStack(ModRegistry.RAW_STRAWBERRY_PIE));
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(Items.PUMPKIN_PIE));
              stacks.add(new ItemStack(ModRegistry.BERRIES_PIE));
              stacks.add(new ItemStack(ModRegistry.CARROT_PIE));
              stacks.add(new ItemStack(ModRegistry.HONEY_PIE));
              stacks.add(new ItemStack(ModRegistry.MELON_PIE));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY_PIE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.CREAM));
              stacks.add(new ItemStack(ModRegistry.RAW_CREAM_DONUT));
              stacks.add(new ItemStack(ModRegistry.CREAM_DONUT));
              stacks.add(new ItemStack(ModRegistry.RAW_CAKE));
              stacks.add(new ItemStack(Items.CAKE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);   
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_CREAM));
              stacks.add(new ItemStack(ModRegistry.RAW_CHOCOLATE_DONUT));
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_DONUT));
              stacks.add(new ItemStack(ModRegistry.RAW_CHOCOLATE_CAKE));
              stacks.add(new ItemStack(ModRegistry.CHOCOLATE_CAKE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);   
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY_CREAM));
              stacks.add(new ItemStack(ModRegistry.RAW_STRAWBERRY_DONUT));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY_DONUT));
              stacks.add(new ItemStack(ModRegistry.RAW_STRAWBERRY_CAKE));
              stacks.add(new ItemStack(ModRegistry.STRAWBERRY_CAKE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);  
              stacks.add(new ItemStack(ModRegistry.HONEY_CREAM));
              stacks.add(new ItemStack(ModRegistry.RAW_HONEY_DONUT));
              stacks.add(new ItemStack(ModRegistry.HONEY_DONUT));
              stacks.add(new ItemStack(ModRegistry.RAW_HONEY_CAKE));
              stacks.add(new ItemStack(ModRegistry.HONEY_CAKE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);  
              stacks.add(new ItemStack(ModRegistry.RAW_FLATBREAD));
              stacks.add(new ItemStack(ModRegistry.CHEESE_BLOCK));
              stacks.add(new ItemStack(ModRegistry.CHEESE_SLICE));
              stacks.add(new ItemStack(ModRegistry.RAW_SAUSAGE));
              stacks.add(new ItemStack(ModRegistry.SAUSAGE_BLOCK));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);  
              stacks.add(new ItemStack(ModRegistry.SAUSAGE_SLICE));
              stacks.add(new ItemStack(ModRegistry.SAUSAGE_SLICE_9));
              stacks.add(new ItemStack(ModRegistry.SAUSAGE_SLICE_15));
              stacks.add(new ItemStack(ModRegistry.BROWN_MUSHROOM_7));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);

              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);  
              stacks.add(new ItemStack(ModRegistry.RAW_CHEESE_FLATBREAD));
              stacks.add(new ItemStack(ModRegistry.RAW_Pizza));
              stacks.add(ItemStack.EMPTY);  
              stacks.add(new ItemStack(ModRegistry.CHEESE_FLATBREAD));
              stacks.add(new ItemStack(ModRegistry.Pizza));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY); 
              stacks.add(new ItemStack(ModRegistry.IRON_SPOON));
              stacks.add(new ItemStack(ModRegistry.IRON_KNIFE)); 
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.GOLDEN_SPOON));
              stacks.add(new ItemStack(ModRegistry.GOLDEN_KNIFE));
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              
              stacks.add(ItemStack.EMPTY);
              stacks.add(ItemStack.EMPTY);
              stacks.add(new ItemStack(ModRegistry.HAND_MILL));  
              stacks.add(new ItemStack(ModRegistry.HAND_MILL_CRANK)); 
              stacks.add(new ItemStack(ModRegistry.HAND_MILL_MILLSTONE)); 
              stacks.add(new ItemStack(ModRegistry.HAND_MILL_WOODEN_FUNNEL)); 
              stacks.add(new ItemStack(ModRegistry.ROLLING_PIN));  
              stacks.add(ItemStack.EMPTY); 
  }).build();

//=========================================Make Item, Block=========================================//
  //DUST//
    public static final Item FLOUR = new Item(new Item.Settings()); 
    public static final Item COCOA_DUST = new Item(new Item.Settings()); 
    

    //Slice
    public static final GetSliceRawBread RAW_BREAD_SLICE = new GetSliceRawBread(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final GetSliceBread BREAD_SLICE = new GetSliceBread(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build()));
    public static final GetSliceCheese CHEESE_SLICE = new GetSliceCheese(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build()));
    public static final GetSausageSlice SAUSAGE_SLICE = new GetSausageSlice(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));
    
    //PLANTS
    public static final Item PUMPKIN_SLICE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build()));
    public static final Item STRAWBERRY = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build()));   
    public static final Item STRAWBERRY_BIG = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()));  
      
      //Block
      public static final StrawberryBushBlock STRAWBERRYBUSH = new StrawberryBushBlock();
      public static final StrawberryBushBlockHay STRAWBERRYBUSH_HAY = new StrawberryBushBlockHay();

    //DOUGH
    public static final Item DOUGH = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
    public static final Item CHOCOLATE_DOUGH = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
    public static final Item HONEY_DOUGH = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
    public static final Item MILK_DOUGH = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));

    //SHORTCAKE
    public static final Item RAW_HONEY_SHORTCAKE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_SHORTCAKE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item CAKE_BASE = new Item(new Item.Settings()); 
    
    //RAW_BREAD
    public static Block RAW_BREADBLOCK = new RawBreadBlock();

    
    //RAW_COOKIE
    public static final Item RAW_COOKIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_COOKIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
    //Raw Pie
    public static final Item RAW_BERRIES_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_MELON_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CARROT_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_STRAWBERRY_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
    //Cream
    public static Item CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item CHOCOLATE_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item STRAWBERRY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item HONEY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    
    //Raw Donut
    public static final Item RAW_CREAM_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_STRAWBERRY_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
    //RAW CAKE
    public static Block RAW_CAKE = new RawChokoladeCakeBlock();
    public static Block RAW_STRAWBERRY_CAKE = new RawStrawberryCakeBlock();
    public static Block RAW_CHOCOLATE_CAKE = new RawChokoladeCakeBlock();
    public static Block RAW_HONEY_CAKE = new RawHoneyCakeBlock();
    public static Block RAW_Pizza = new RawPizza();
    
    //FLATBREAD
    public static final Item RAW_FLATBREAD = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHEESE_FLATBREAD = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
  
    //COOKED  
     //BUNS
    public static final Item BUN = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
    public static final Item CHOCOLATE_BUN = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()));
    public static final Item HONEY_BUN = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build()));
    public static final Item MILK_BUN = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build()));

    //BREADS
    public static Block BREADBLOCK = new BreadBlock();
    //public static final Item BREAD_SLICE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build()));
    
    //Cookie
    public static final Item CHOCOLATE_COOKIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()));
    public static final Item CRUMBS_COOKIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    
    //Pie
    public static final Item RAW_PUMPKIN_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item BERRIES_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).build()));
    public static final Item HONEY_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build()));
    public static final Item MELON_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));
    public static final Item CARROT_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item STRAWBERRY_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()));
    
    //Donut
    public static final Item COKED_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build()));
    public static final Item CREAM_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5f).build()));
    public static final Item STRAWBERRY_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item CHOCOLATE_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(9).saturationModifier(0.8f).build()));
    public static final Item HONEY_DONUT = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    
    //Cake
    public static Block STRAWBERRY_CAKE = new StrawberryCakeBlock();
    public static Block CHOCOLATE_CAKE = new ChokoladeCakeBlock();
    public static Block HONEY_CAKE = new HoneyCakeBlock();
    
    //CHEESE
    public static Block CHEESE_BLOCK = new Cheese();
    
    //Meat
    public static final Item RAW_SAUSAGE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
    public static Block SAUSAGE_BLOCK = new Sausage();

    //Ingredients for Pizza

    //SAUSAGE
    public static final Item SAUSAGE_SLICE_9 = new Item(new Item.Settings().maxCount(1));
    public static final IngredientsforPizza SAUSAGE_SLICE_15 = new IngredientsforPizza(new Item.Settings().maxCount(1));

    //BROWN_MUSHROOM
    public static final IngredientsforPizza BROWN_MUSHROOM_7 = new IngredientsforPizza(new Item.Settings().maxCount(1));

    //FLATBREAD
    public static final Item CHEESE_FLATBREAD = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(9).saturationModifier(0.6f).build()));
    public static Block Pizza = new Pizza();

   //Tools
    //Iron  
    public static final UseSpoon GOLDEN_SPOON = new UseSpoon(new Item.Settings().recipeRemainder(ModRegistry.GOLDEN_SPOON).maxCount(1)); 
    public static final UseKnife GOLDEN_KNIFE = new UseKnife(new Item.Settings().recipeRemainder(ModRegistry.GOLDEN_KNIFE).maxCount(1));   
    //Gold
    public static final UseKnife IRON_KNIFE = new UseKnife(new Item.Settings().recipeRemainder(ModRegistry.IRON_KNIFE).maxCount(1)); 
    public static final UseSpoon IRON_SPOON = new UseSpoon(new Item.Settings().recipeRemainder(ModRegistry.IRON_SPOON).maxCount(1)); 

    public static final KitchenAppliance ROLLING_PIN = new KitchenAppliance(new Item.Settings().maxCount(1)); 
    //HAND_MILL parts
    public static final KitchenAppliance HAND_MILL = new KitchenAppliance(new Item.Settings().maxCount(1));  
    public static final Item HAND_MILL_WOODEN_FUNNEL = new Item(new Item.Settings().maxCount(1)); 
    public static final Item HAND_MILL_CRANK = new Item(new Item.Settings().maxCount(1)); 
    public static final Item HAND_MILL_MILLSTONE = new Item(new Item.Settings().maxCount(1)); 

//=========================================Register: Items and Block=========================================//
    public static void registerItems() {
        //==============================Item======================================//
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "flour"), FLOUR);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cocoa_dust"), COCOA_DUST);

        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "dough"), DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_dough"), CHOCOLATE_DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_dough"), HONEY_DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "milk_dough"), MILK_DOUGH);

        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "bun"), BUN);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_bun"), CHOCOLATE_BUN);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_bun"), HONEY_BUN);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "milk_bun"), MILK_BUN);

        //Plants
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "pumpkin_slice"), PUMPKIN_SLICE);
         //Crop
          //Seed

          Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_seed"), new AliasedBlockItem(STRAWBERRYBUSH, new Item.Settings()));
          Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_hay"), new AliasedBlockItem(STRAWBERRYBUSH_HAY, new Item.Settings()));
        
          Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry"), STRAWBERRY);
          Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_big"), STRAWBERRY_BIG);

        //Raw bread      
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_new_bread"), new AliasedBlockItem(RAW_BREADBLOCK, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_bread_slice"), RAW_BREAD_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "new_bread"), new AliasedBlockItem(BREADBLOCK, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "bread_slice"), BREAD_SLICE);
        
        //Raw Cookie
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cookie"), RAW_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "crumbs_cookie"), CRUMBS_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_cookie"), RAW_CHOCOLATE_COOKIE);

        //Cookie 
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_cookie"), CHOCOLATE_COOKIE);

        //Raw Pie
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_pumpkin_pie"), RAW_PUMPKIN_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_berries_pie"), RAW_BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_pie"), RAW_HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_melon_pie"), RAW_MELON_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_carrot_pie"), RAW_CARROT_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_strawberry_pie"), RAW_STRAWBERRY_PIE);

        //Pie
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "berries_pie"), BERRIES_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_pie"), HONEY_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "melon_pie"), MELON_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "carrot_pie"), CARROT_PIE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_pie"), STRAWBERRY_PIE);

        //Cream
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cream"), CREAM);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_cream"), CHOCOLATE_CREAM);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_cream"), STRAWBERRY_CREAM);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_cream"), HONEY_CREAM);

        //Raw Donuts
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_donut"), RAW_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cream_donut"), RAW_CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_strawberry_donut"), RAW_STRAWBERRY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_donut"), RAW_CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_donut"), RAW_HONEY_DONUT);
        
        //Donuts
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "coked_donut"), COKED_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cream_donut"), CREAM_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_donut"), STRAWBERRY_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_donut"), CHOCOLATE_DONUT);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_donut"), HONEY_DONUT);
        
        //SHORTCAKE
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_shortcake"), RAW_HONEY_SHORTCAKE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_shortcake"), RAW_CHOCOLATE_SHORTCAKE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cake_base"), CAKE_BASE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_flatbread"), RAW_FLATBREAD);
                
        //==============================BlockItem======================================//

        //Raw Cake
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cake"), new BlockItem(RAW_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_cake"), new BlockItem(RAW_CHOCOLATE_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_strawberry_cake"), new BlockItem(RAW_STRAWBERRY_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_cake"), new BlockItem(RAW_HONEY_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_block"), new BlockItem(CHEESE_BLOCK, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_slice"), CHEESE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_pizza"), new BlockItem(RAW_Pizza, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cheese_flatbread"), RAW_CHEESE_FLATBREAD);
       
        //Cake
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_cake"), new BlockItem(CHOCOLATE_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_cake"), new BlockItem(STRAWBERRY_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_cake"), new BlockItem(HONEY_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "pizza"), new BlockItem(Pizza, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_flatbread"), CHEESE_FLATBREAD);


        //Meat
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_sausage"), RAW_SAUSAGE); 
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "sausage"), new AliasedBlockItem(SAUSAGE_BLOCK, new Item.Settings().maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "sausage_slice"), SAUSAGE_SLICE); 
        
        //Ingredients for Pizza
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "sausage_slice_9"), SAUSAGE_SLICE_9); 
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "sausage_slice_15"), SAUSAGE_SLICE_15); 
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "brown_mushroom_7"), BROWN_MUSHROOM_7);
        //Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "beetroot_slice_4"), BEETROOT_SLICE_4);
        

       //Tools
        //Iron
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "iron_knife"), IRON_KNIFE);   
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "iron_spoon"), IRON_SPOON);   
        
        //Gold
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "golden_knife"), GOLDEN_KNIFE);   
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "golden_spoon"), GOLDEN_SPOON);  

        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "hand_mill"), HAND_MILL);  
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "hand_mill_wooden_funnel"), HAND_MILL_WOODEN_FUNNEL);  
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "hand_mill_crank"), HAND_MILL_CRANK);  
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "hand_mill_millstone"), HAND_MILL_MILLSTONE);  

        //==============================Block======================================//

        //Crop
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID,"strawberrybush"), STRAWBERRYBUSH);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID,"strawberrybush_hay"), STRAWBERRYBUSH_HAY);
        //Registry.register(Registry.BLOCK, new Identifier(Tutorial.MOD_ID,"test"), TEST);
        
        //Raw Cake
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_cake"), RAW_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_honey_cake"), RAW_HONEY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_chocolate_cake"), RAW_CHOCOLATE_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_strawberry_cake"), RAW_STRAWBERRY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_pizza"), RAW_Pizza);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "raw_bread_block"), RAW_BREADBLOCK);
        
        //Cake
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "honey_cake"), HONEY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "chocolate_cake"), CHOCOLATE_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "strawberry_cake"), STRAWBERRY_CAKE);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "pizza"), Pizza);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "cheese_block"), CHEESE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "bread_block"), BREADBLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RBP.MOD_ID, "sausage_block"), SAUSAGE_BLOCK);

        //[Deleted]
           //Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_bread"), RAW_BREAD);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "rolling_pin"), ROLLING_PIN);      
        //Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "glass_bowl"), GLASS_BOWL);   


    }
}
