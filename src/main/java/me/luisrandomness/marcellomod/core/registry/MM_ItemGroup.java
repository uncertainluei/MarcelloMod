package me.luisrandomness.marcellomod.core.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

public class MM_ItemGroup {

    public static ItemGroup TAB = new ItemGroup("marcellomod.items") {
        @Override @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(MM_Items.MARCELLO_FRUIT.get());
        }

        @Override @OnlyIn(Dist.CLIENT)
        public void fillItemList(NonNullList<ItemStack> p_78018_1_) {

            for (Item item : ForgeRegistries.ITEMS) {
                if (item.getRegistryName().toString().startsWith("marcellomod")) {
                    p_78018_1_.add(new ItemStack(item));
                }
            }
        }

        @Override @OnlyIn(Dist.CLIENT)
        public boolean hasSearchBar() { return true; }

    }.setBackgroundImage(new ResourceLocation("textures/gui/container/creative_inventory/tab_item_search.png"));

}
