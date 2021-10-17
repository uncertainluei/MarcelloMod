package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.core.registry.MarcelloModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MM_Item extends Item {

    public MM_Item(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    protected boolean allowdedIn(ItemGroup p_194125_1_) {
        if (getCreativeTabs().stream().anyMatch(tab -> tab == p_194125_1_)) return true;
        ItemGroup itemgroup = this.getItemCategory();
        return itemgroup != null && (p_194125_1_ == ItemGroup.TAB_SEARCH || p_194125_1_ == itemgroup || p_194125_1_ == MarcelloModItemGroups.MAIN);
    }
}
