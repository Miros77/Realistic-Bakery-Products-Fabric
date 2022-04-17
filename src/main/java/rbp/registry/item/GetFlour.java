package rbp.registry.item;

import net.minecraft.item.Item;
import net.minecraft.text.TranslatableText;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import java.util.List;

public class GetFlour extends Item {
    public GetFlour(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("get_flour.realistic_bakery_products.tooltip"));
    }
}