package io.github.luisrandomness.marcellomod.client.render;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.client.render.entity.HumanoidNpcRenderer;
import io.github.luisrandomness.marcellomod.client.render.entity.MarkRenderer;
import io.github.luisrandomness.marcellomod.client.render.entity.VariedHumanoidNpcRenderer;
import io.github.luisrandomness.marcellomod.init.MM_EntityTypes;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;


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
        EntityRendererRegistry.register(MM_EntityTypes.MARCELLO, (context) -> new VariedHumanoidNpcRenderer(context, false, MARCELLO_ENTITY_TEXTURES, true));
        EntityRendererRegistry.register(MM_EntityTypes.MOLDY, (context) -> new HumanoidNpcRenderer(context, true, MOLDY_ENTITY_TEXTURE, true));
        EntityRendererRegistry.register(MM_EntityTypes.MARK, (context) -> new MarkRenderer(context));

        TerraformBoatClientHelper.registerModelLayers(modIdentifier("marcelium"), false);
    }
}
