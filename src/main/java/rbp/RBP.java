package rbp;

import rbp.registry.ModRegistry;
import net.fabricmc.api.ModInitializer;

public class RBP implements ModInitializer {

    public static final String MOD_ID = "realistic_bakery_products";

    @Override
    public void onInitialize() {
        ModRegistry.registerItems();
    }
}
