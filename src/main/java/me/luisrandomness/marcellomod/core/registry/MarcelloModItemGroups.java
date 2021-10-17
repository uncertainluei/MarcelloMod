package me.luisrandomness.marcellomod.core.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MarcelloModItemGroups {
    public static ItemGroup MAIN = new ItemGroup("marcellomod.items") {

        @Override @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(MarcelloModItems.MARCELLO_FRUIT.get());
        }
    };

}
