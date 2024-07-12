package io.github.luisrandomness.marcellomod.client.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HumanoidNpcRenderer<T extends MobEntity> extends MobRenderer<T, PlayerModel<T>> {
    public final ResourceLocation texture;
    public final boolean playerScale;

    public HumanoidNpcRenderer(EntityRendererManager context, boolean useSlimModel, ResourceLocation texture) {
        this(context,useSlimModel,texture,false);
    }

    public HumanoidNpcRenderer(EntityRendererManager context, boolean useSlimModel, ResourceLocation texture, boolean scaled) {
        super(context, new PlayerModel<>(0F, useSlimModel), 0.5F);
        playerScale = scaled;
        this.texture = texture;
        this.addLayer(new BipedArmorLayer(this, new BipedModel(0.5F), new BipedModel(1.0F)));
        this.addLayer(new HeldItemLayer(this));
        this.addLayer(new HeadLayer(this));
        this.addLayer(new ElytraLayer(this));
    }

    @Override
    protected void scale(MobEntity livingEntity, MatrixStack poseStack, float partialTickTime) {
        if (playerScale)
            poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    public ResourceLocation getTextureLocation(MobEntity t) {
        return texture;
    }
}