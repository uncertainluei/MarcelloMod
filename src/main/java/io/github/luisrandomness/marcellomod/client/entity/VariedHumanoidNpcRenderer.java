package io.github.luisrandomness.marcellomod.client.entity;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VariedHumanoidNpcRenderer<T extends MobEntity> extends HumanoidNpcRenderer<T> {
    public final ResourceLocation[] textures;
    private final int texturesLength;

    private int textureIndex;

    public VariedHumanoidNpcRenderer(EntityRendererManager context, boolean useSlimModel, ResourceLocation[] textures, boolean scaled) {
        super(context, useSlimModel, null, scaled);
        this.textures = textures;
        this.texturesLength = this.textures.length;
    }

    public VariedHumanoidNpcRenderer(EntityRendererManager context, boolean useSlimModel, ResourceLocation[] textures) {
        this(context, useSlimModel, null, false);
    }

    @Override
    public ResourceLocation getTextureLocation(MobEntity entity) {
        textureIndex = (int) entity.getUUID().getMostSignificantBits() % texturesLength;
        if (textureIndex < 0)
            textureIndex += texturesLength;

        return textures[textureIndex];
    }
}