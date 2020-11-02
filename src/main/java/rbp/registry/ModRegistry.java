package rbp.registry;

//=========================================Imports=========================================//

//Rbp
import rbp.RBP;
import rbp.registry.block.cake.cake.ChokoladeCakeBlock;
import rbp.registry.block.cake.cake.HoneyCakeBlock;
import rbp.registry.block.cake.cake.StrawberryCakeBlock;
import rbp.registry.block.cake.custom_cake.Pizza.Pizza;
import rbp.registry.block.cake.custom_cake.Pizza.RawPizza;
import rbp.registry.block.cake.custom_cake.bread.BreadBlock;
import rbp.registry.block.cake.custom_cake.bread.RawBreadBlock;
import rbp.registry.block.cake.custom_cake.cheese.Cheese;
import rbp.registry.block.cake.rawcake.RawChokoladeCakeBlock;
import rbp.registry.block.crop.StrawberryBushBlock;
import rbp.registry.block.crop.StrawberryBushBlockHay;

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
    public static final ItemGroup REALISTIC_BAKERY_PRODUCTS = FabricItemGroupBuilder.build(
		new Identifier("realistic_bakery_products", "realistic_bakery_products"),
        () -> new ItemStack(ModRegistry.RAW_BREADBLOCK));

//=========================================Make Item, Block=========================================//
    //Food   
    public static final Item FLOUR = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS)); 
    public static final Item PUMPKIN_SLICE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build()));
    //took simplefarming :)
    public static final Item CHEESE_SLICE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).build()));
    public static final Item BREAD_SLICE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build()));
    public static final Item RAW_BREAD_SLICE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));

    //BREAD_SLICE
      //DOUGH
      public static final Item DOUGH = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
      public static final Item RAW_HONEY_SHORTCAKE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
      public static final Item RAW_CHOCOLATE_SHORTCAKE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
      public static final Item RAW_FLATBREAD = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
      public static final Item RAW_CHEESE_FLATBREAD = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
      public static final Item CHEESE_FLATBREAD = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(9).saturationModifier(0.6f).build()));
      public static final Item CAKE_BASE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS)); 
      public static final Item BUN = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()));
      public static final Item CHOCOLATE_DOUGH = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));
      public static final Item HONEY_DOUGH = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 0.3F).build()));

    //Raw Food  
    public static final Item RAW_BREAD = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
    //RAW Cookie
    public static final Item RAW_COOKIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_COOKIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));

    //Cookie
    public static final Item CHOCOLATE_COOKIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()));
    public static final Item CRUMBS_COOKIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));

    //Crop Item
    //public static final Item STRAWBERRY = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(2f).build()));
    
    //Pie
    public static final Item RAW_PUMPKIN_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()).maxCount(1));
    public static final Item BERRIES_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.7f).build()));
    public static final Item HONEY_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build()));
    public static final Item MELON_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build()));
    public static final Item CARROT_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item STRAWBERRY_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()));

    // Raw Pie
    public static final Item RAW_BERRIES_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_MELON_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CARROT_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_STRAWBERRY_PIE = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    //Cream
    public static Item CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item CHOCOLATE_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item STRAWBERRY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
    public static Item HONEY_CREAM = new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(6).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()));
     
    //Donut
    public static final Item COKED_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build()));
    public static final Item CREAM_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5f).build()));
    public static final Item STRAWBERRY_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    public static final Item CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(9).saturationModifier(0.8f).build()));
    public static final Item HONEY_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7f).build()));
    
    //Raw Donut
    public static final Item RAW_CREAM_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_STRAWBERRY_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_CHOCOLATE_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_HONEY_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    public static final Item RAW_DONUT = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).build()));
    
    //Harvest
    public static final Item STRAWBERRY = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build()));   
    public static final Item STRAWBERRY_BIG = new Item(new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()));  

    //Block
       //Crop
    public static final StrawberryBushBlock STRAWBERRYBUSH = new StrawberryBushBlock();
    public static final StrawberryBushBlockHay STRAWBERRYBUSH_HAY = new StrawberryBushBlockHay();


    //public static final MyCakeBlock TEST = new MyCakeBlock();

     //RAw Cake
     public static Block RAW_CAKE = new RawChokoladeCakeBlock();
     public static Block RAW_STRAWBERRY_CAKE = new RawChokoladeCakeBlock();
     public static Block RAW_CHOCOLATE_CAKE = new RawChokoladeCakeBlock();
     public static Block RAW_HONEY_CAKE = new RawChokoladeCakeBlock();
     public static Block RAW_Pizza = new RawPizza();
     public static Block RAW_BREADBLOCK = new RawBreadBlock();

     //Cake
    public static Block STRAWBERRY_CAKE = new StrawberryCakeBlock();
    public static Block CHOCOLATE_CAKE = new ChokoladeCakeBlock();
    public static Block HONEY_CAKE = new HoneyCakeBlock();
    public static Block Pizza = new Pizza();
    public static Block CHEESE_BLOCK = new Cheese();
    public static Block BREADBLOCK = new BreadBlock();
    //public static Block FREEZER = new Freezer(Block.Settings.copy(Blocks.FURNACE));
    
    //Tools
    public static final Item IRON_KNIFE = new Item(new Item.Settings().recipeRemainder(ModRegistry.IRON_KNIFE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)); 
    public static final Item GOLDEN_KNIFE = new Item(new Item.Settings().recipeRemainder(ModRegistry.GOLDEN_KNIFE).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1));   
    
    public static final Item IRON_SPOON = new Item(new Item.Settings().recipeRemainder(ModRegistry.IRON_SPOON).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)); 
    public static final Item GOLDEN_SPOON = new Item(new Item.Settings().recipeRemainder(ModRegistry.GOLDEN_SPOON).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)); 

    //public static final Item ROLLING_PIN_1 = new Item(new Item.Settings().recipeRemainder(ModRegistry.ROLLING_PIN_2).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)); 
    //public static final Item ROLLING_PIN_2 = new Item(new Item.Settings().recipeRemainder(ModRegistry.ROLLING_PIN_1).group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)); 
//ModRegistry.ROLLING_PIN

//=========================================Register Items, Block=========================================//
    public static void registerItems() {
        //==============================Item======================================//
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "flour"), FLOUR);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "dough"), DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "bun"), BUN);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_dough"), CHOCOLATE_DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_dough"), HONEY_DOUGH);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "pumpkin_slice"), PUMPKIN_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_slice"), CHEESE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_bread_slice"), RAW_BREAD_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "bread_slice"), BREAD_SLICE);

        //Raw Food      
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_bread"), RAW_BREAD);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_new_bread"), new AliasedBlockItem(RAW_BREADBLOCK, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "new_bread"), new AliasedBlockItem(BREADBLOCK, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
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
        

        //==============================BlockItem======================================//
        //SHORTCAKE
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_shortcake"), RAW_HONEY_SHORTCAKE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_shortcake"), RAW_CHOCOLATE_SHORTCAKE);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_flatbread"), RAW_FLATBREAD);
        
        
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cake_base"), CAKE_BASE);

        //Raw Cake
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cake"), new BlockItem(RAW_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_chocolate_cake"), new BlockItem(RAW_CHOCOLATE_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_strawberry_cake"), new BlockItem(RAW_STRAWBERRY_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_honey_cake"), new BlockItem(RAW_HONEY_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_pizza"), new BlockItem(RAW_Pizza, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "raw_cheese_flatbread"), RAW_CHEESE_FLATBREAD);
       
        //Cake
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "chocolate_cake"), new BlockItem(CHOCOLATE_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_cake"), new BlockItem(STRAWBERRY_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "honey_cake"), new BlockItem(HONEY_CAKE, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "pizza"), new BlockItem(Pizza, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_block"), new BlockItem(CHEESE_BLOCK, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "cheese_flatbread"), CHEESE_FLATBREAD);
        //Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "bread"), new AliasedBlockItem(BREADBLOCK, new Item.Settings().group(ItemGroup.FOOD).maxCount(1)));

       //Crop

        //Seed
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry"), STRAWBERRY);
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_big"), STRAWBERRY_BIG);

        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_seed"), new AliasedBlockItem(STRAWBERRYBUSH, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS)));
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "strawberry_hay"), new AliasedBlockItem(STRAWBERRYBUSH_HAY, new Item.Settings().group(ModRegistry.REALISTIC_BAKERY_PRODUCTS)));
        
                //Tools(Item)

          //Iron
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "iron_knife"), IRON_KNIFE);   
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "iron_spoon"), IRON_SPOON);   
        
        //Gold
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "golden_knife"), GOLDEN_KNIFE);   
        Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "golden_spoon"), GOLDEN_SPOON);  

        //Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "rolling_pin_1"), ROLLING_PIN_1);   
        //Registry.register(Registry.ITEM, new Identifier(RBP.MOD_ID, "rolling_pin_2"), ROLLING_PIN_2);  

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
    }
}
