package rbp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import rbp.registry.ModRegistry;

public class RBPclient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModRegistry.STRAWBERRYBUSH_HAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModRegistry.STRAWBERRYBUSH, RenderLayer.getCutout());

    }


}
