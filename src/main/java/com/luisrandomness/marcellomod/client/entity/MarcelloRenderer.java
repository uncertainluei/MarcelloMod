package com.luisrandomness.marcellomod.client.entity;

import com.luisrandomness.marcellomod.MarcelloMod;
import com.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MarcelloRenderer extends BipedRenderer<MarcelloEntity,MarcelloModel<MarcelloEntity>> {

    private static final ResourceLocation MARCELLO_TEXTURE = new ResourceLocation(MarcelloMod.ID + ":textures/entity/marcello/marcello0.png");

    public MarcelloRenderer(EntityRendererManager p_i46168_1_, MarcelloModel<MarcelloEntity> p_i46168_2_, float p_i46168_3_) {
        super(p_i46168_1_, p_i46168_2_, p_i46168_3_);
        this.addLayer(new BipedArmorLayer<>(this, p_i46168_2_, new BipedModel<>(0F)));
    }

    public MarcelloRenderer(EntityRendererManager manager) {
        this(manager, new MarcelloModel<MarcelloEntity>(0F), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(MarcelloEntity p_110775_1_) {
        return MARCELLO_TEXTURE;
    }
}
