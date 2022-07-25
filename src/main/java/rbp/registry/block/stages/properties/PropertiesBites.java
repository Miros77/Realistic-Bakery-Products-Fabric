package rbp.registry.block.stages.properties;

import net.minecraft.state.property.IntProperty;

public class PropertiesBites{

    public static final IntProperty LEVEL_29;
    public static final IntProperty LEVEL_15;
    public static final IntProperty LEVEL_4;
    public static final IntProperty LEVEL_7;
    public static final IntProperty LEVEL_5;
    public static final IntProperty LEVEL_8;
    public static final IntProperty LEVEL_13;
    public static final IntProperty LEVEL_1;
    public static final IntProperty LEVEL_3;


    static{
        LEVEL_29 = IntProperty.of("level", 0, 29);
        LEVEL_15 = IntProperty.of("level", 0, 17);
        LEVEL_4 = IntProperty.of("level", 0, 3);
        LEVEL_7 = IntProperty.of("level", 0, 6);
        LEVEL_5 = IntProperty.of("bites", 0, 5);
        LEVEL_8 = IntProperty.of("level", 0, 7);
        LEVEL_13 = IntProperty.of("level", 0, 13);
        LEVEL_1 = IntProperty.of("bites", 0, 1);
        LEVEL_3 = IntProperty.of("level", 0, 2);
    }
}

