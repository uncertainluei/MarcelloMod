package io.github.luisrandomness.marcellomod.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.GlowSquidRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;
import io.github.luisrandomness.marcellomod.entity.MarkEntity;


@Environment(EnvType.CLIENT)
public class MarkRenderer extends HumanoidNpcRenderer<MarkEntity> {
    private static final ResourceLocation MARK_ENTITY_TEXTURE = MarcelloMod.modIdentifier("textures/entity/mark/mark.png");

    public MarkRenderer(EntityRendererProvider.Context context) {
        super(context, false, MARK_ENTITY_TEXTURE, false);
        this.addLayer(new MarkEyesLayer<>(this));
    }
}
