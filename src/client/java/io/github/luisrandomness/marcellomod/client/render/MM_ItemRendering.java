package io.github.luisrandomness.marcellomod.client.render;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class MM_ItemRendering {
    public static final ModelResourceLocation HAMMER_PENCIL_HANDHELD_MODEL = ModelResourceLocation.inventory(MarcelloMod.modIdentifier("hammer_pencil_in_hand"));
    public static void initialize()
    {
        ItemProperties.register(MM_Items.RUISIUM_BOW, ResourceLocation.withDefaultNamespace("pulling"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
        ItemProperties.register(MM_Items.RUISIUM_BOW, ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 60.0F;
            }
        });
    }
}
