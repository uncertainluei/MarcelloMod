package io.github.uncertainluei.mc.marcellomod.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class VariedHumanoidNpcRenderer<T extends Mob> extends HumanoidNpcRenderer<T> {
    public final ResourceLocation[] textures;
    private final int texturesLength;

    private int textureIndex;

    public VariedHumanoidNpcRenderer(EntityRendererProvider.Context context, boolean useSlimModel, ResourceLocation[] textures, boolean scaled) {
        super(context, useSlimModel, null, scaled);
        this.textures = textures;
        this.texturesLength = this.textures.length;
    }

    public VariedHumanoidNpcRenderer(EntityRendererProvider.Context context, boolean useSlimModel, ResourceLocation[] textures) {
        this(context, useSlimModel, null, false);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(Mob entity) {
        textureIndex = (int) entity.getUUID().getMostSignificantBits() % texturesLength;
        if (textureIndex < 0)
            textureIndex += texturesLength;

        return textures[textureIndex];
    }
}
