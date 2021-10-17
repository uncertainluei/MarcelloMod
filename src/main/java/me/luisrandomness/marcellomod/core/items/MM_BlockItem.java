package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.core.registry.MarcelloModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class MM_BlockItem extends BlockItem {
    public MM_BlockItem(Block p_i48527_1_, Properties p_i48527_2_) {
        super(p_i48527_1_, p_i48527_2_);
    }

    @Override
    protected boolean allowdedIn(ItemGroup p_194125_1_) {
        if (getCreativeTabs().stream().anyMatch(tab -> tab == p_194125_1_)) return true;
        ItemGroup itemgroup = this.getItemCategory();
        return itemgroup != null && (p_194125_1_ == ItemGroup.TAB_SEARCH || p_194125_1_ == itemgroup || p_194125_1_ == MarcelloModItemGroups.MAIN);
    }
}
