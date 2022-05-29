package rbp.registry.item.get;

import net.minecraft.item.Item;
import net.minecraft.text.TranslatableText;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import java.util.List;

public class GetSliceRawBread extends Item {
    public GetSliceRawBread(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("raw_bread_slice.realistic_bakery_products.tooltip"));
    }
}