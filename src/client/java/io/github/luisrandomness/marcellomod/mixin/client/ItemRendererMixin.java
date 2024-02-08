package io.github.luisrandomness.marcellomod.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.luisrandomness.marcellomod.client.render.MM_ItemRendering;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel utiliseAltModel(BakedModel value, ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (itemStack.is(MM_Items.HAMMER_PENCIL)
                && displayContext != ItemDisplayContext.GUI
                && displayContext != ItemDisplayContext.FIXED
                && displayContext != ItemDisplayContext.GROUND)
            return ((ItemRendererAccessor) this).marcellomod$getModels().getModelManager().getModel(MM_ItemRendering.HAMMER_PENCIL_HANDHELD_MODEL);
        return value;
    }
}