package io.github.uncertainluei.mc.marcellomod.client.render;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import io.github.uncertainluei.mc.marcellomod.client.render.entity.HumanoidNpcRenderer;
import io.github.uncertainluei.mc.marcellomod.client.render.entity.MarkRenderer;
import io.github.uncertainluei.mc.marcellomod.client.render.entity.VariedHumanoidNpcRenderer;
import io.github.uncertainluei.mc.marcellomod.init.MM_EntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.resources.ResourceLocation;

import static io.github.uncertainluei.mc.marcellomod.MarcelloMod.modIdentifier;


public class MM_EntityRendering {
    public static final ResourceLocation[] MARCELLO_ENTITY_TEXTURES = new ResourceLocation[]
            {
                    modIdentifier("textures/entity/marcello/classic.png"),
                    modIdentifier("textures/entity/marcello/glasses.png"),
                    modIdentifier("textures/entity/marcello/redhair.png")
            };
    public static final ResourceLocation MOLDY_ENTITY_TEXTURE = modIdentifier("textures/entity/moldy.png");

    public static void initialize()
    {
        EntityRendererRegistry.register(MM_EntityTypes.MARCELLO, (context) -> new VariedHumanoidNpcRenderer<>(context, false, MARCELLO_ENTITY_TEXTURES, true));
        EntityRendererRegistry.register(MM_EntityTypes.MOLDY, (context) -> new HumanoidNpcRenderer<>(context, true, MOLDY_ENTITY_TEXTURE, true));
        EntityRendererRegistry.register(MM_EntityTypes.MARK, MarkRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(modIdentifier("marcelium"), false);
    }
}
