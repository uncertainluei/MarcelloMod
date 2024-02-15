package io.github.luisrandomness.marcellomod.client.render;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.client.render.entity.HumanoidNpcRenderer;
import io.github.luisrandomness.marcellomod.client.render.entity.MarkRenderer;
import io.github.luisrandomness.marcellomod.init.MM_EntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;


public class MM_EntityRendering {
    public static final ResourceLocation MARCELLO_ENTITY_TEXTURE = MarcelloMod.modIdentifier("textures/entity/marcello/classic.png");
    public static final ResourceLocation MOLDY_ENTITY_TEXTURE = MarcelloMod.modIdentifier("textures/entity/moldy.png");

    public static void initialize()
    {
        EntityRendererRegistry.register(MM_EntityTypes.MARCELLO, (context) -> new HumanoidNpcRenderer(context, false, MARCELLO_ENTITY_TEXTURE, true));
        EntityRendererRegistry.register(MM_EntityTypes.MOLDY, (context) -> new HumanoidNpcRenderer(context, true, MOLDY_ENTITY_TEXTURE, true));
        EntityRendererRegistry.register(MM_EntityTypes.MARK, (context) -> new MarkRenderer(context));
    }
}
