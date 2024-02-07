package io.github.luisrandomness.marcellomod.client.render;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class MM_BlockRendering {
    public static void initialize()
    {
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, MM_Blocks.MARCELIUM_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, MM_Blocks.MARCELIUM_HANGING_SIGN_TEXTURE));

        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.MARCELIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.MARCELIUM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.RED_MARCELIUM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.GREEN_MARCELIUM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.YELLOW_MARCELIUM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.RED_MARCELIUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.GREEN_MARCELIUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.YELLOW_MARCELIUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_RED_MARCELIUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING, RenderLayer.getCutout());
    }
}
