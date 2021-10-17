package me.luisrandomness.marcellomod.client.entity;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.entities.MoldyEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoldyRenderer extends BipedRenderer<MoldyEntity, NPCModel<MoldyEntity>> {

    private static final ResourceLocation MOLDY_TEXTURE = new ResourceLocation(MarcelloMod.ID + ":textures/entity/moldy.png");

    public MoldyRenderer(EntityRendererManager p_i46168_1_, NPCModel<MoldyEntity> p_i46168_2_, float p_i46168_3_) {
        super(p_i46168_1_, p_i46168_2_, p_i46168_3_);
        this.addLayer(new BipedArmorLayer<>(this, p_i46168_2_, new BipedModel<>(0F)));
    }

    public MoldyRenderer(EntityRendererManager manager) {
        this(manager, new NPCModel<MoldyEntity>(0F,true), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(MoldyEntity p_110775_1_) {
        return MOLDY_TEXTURE;
    }
}
