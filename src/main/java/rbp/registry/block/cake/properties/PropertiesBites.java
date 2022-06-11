package rbp.registry.block.cake.properties;

import net.minecraft.block.CakeBlock;
import net.minecraft.item.Item;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class PropertiesBites{

    public static final IntProperty LEVEL_29;
    public static final IntProperty LEVEL_15;
    public static final IntProperty LEVEL_13;


    static{
        LEVEL_29 = IntProperty.of("level", 0, 29);
        LEVEL_15 = IntProperty.of("level", 0, 16);
        LEVEL_13 = IntProperty.of("level", 0, 13);
    }
}

