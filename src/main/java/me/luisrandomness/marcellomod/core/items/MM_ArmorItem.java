package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.core.registry.MarcelloModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MM_ArmorItem extends ArmorItem {

    public MM_ArmorItem(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_);
    }

    @Override
    protected boolean allowdedIn(ItemGroup p_194125_1_) {
        if (getCreativeTabs().stream().anyMatch(tab -> tab == p_194125_1_)) return true;
        ItemGroup itemgroup = this.getItemCategory();
        return itemgroup != null && (p_194125_1_ == ItemGroup.TAB_SEARCH || p_194125_1_ == itemgroup || p_194125_1_ == MarcelloModItemGroups.MAIN);
    }
}
