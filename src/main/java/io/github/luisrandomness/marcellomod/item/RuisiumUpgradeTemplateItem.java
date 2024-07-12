package io.github.luisrandomness.marcellomod.item;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class RuisiumUpgradeTemplateItem extends SmithingTemplateItem {

    private static final List<ResourceLocation> BASE_SLOT_EMPTY_ICONS =
    List.of (
            new ResourceLocation("item/empty_armor_slot_helmet"),
            new ResourceLocation("item/empty_armor_slot_chestplate"),
            new ResourceLocation("item/empty_armor_slot_leggings"),
            new ResourceLocation("item/empty_armor_slot_boots"),
            new ResourceLocation("item/empty_slot_hoe"),
            new ResourceLocation("item/empty_slot_axe"),
            new ResourceLocation("item/empty_slot_sword"),
            new ResourceLocation("item/empty_slot_shovel"),
            new ResourceLocation("item/empty_slot_pickaxe"),
            MarcelloMod.modIdentifier("item/empty_slot_bow")
    );

    public RuisiumUpgradeTemplateItem() {
        super(Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", MarcelloMod.modIdentifier("smithing_template.ruisium_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", MarcelloMod.modIdentifier("ruisium_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", MarcelloMod.modIdentifier("smithing_template.ruisium_upgrade.additions_slot_description"))),
                BASE_SLOT_EMPTY_ICONS, List.of(MarcelloMod.modIdentifier ("item/empty_slot_ruisium_ingot")));
    }
}
