package io.github.luisrandomness.marcellomod.client.render.entity;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class MarkEyesLayer<T extends LivingEntity> extends EyesLayer<T, PlayerModel<T>> {
    private static final RenderType MARK_EYES = RenderType.eyes(MarcelloMod.modIdentifier("textures/entity/mark/mark_eyes.png"));

    public MarkEyesLayer(RenderLayerParent<T, PlayerModel<T>> renderLayerParent) {
        super(renderLayerParent);
    }

    public RenderType renderType() {
        return MARK_EYES;
    }
}
