package io.github.luisrandomness.marcellomod.client.render.entity;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import io.github.luisrandomness.marcellomod.entity.MarkEntity;

@Environment(EnvType.CLIENT)
public class MarkRenderer extends HumanoidNpcRenderer<MarkEntity> {
    private static final ResourceLocation MARK_ENTITY_TEXTURE = MarcelloMod.modIdentifier("textures/entity/mark/mark.png");

    public MarkRenderer(EntityRendererProvider.Context context) {
        super(context, false, MARK_ENTITY_TEXTURE, false);
        this.addLayer(new MarkEyesLayer<>(this));
    }
}
