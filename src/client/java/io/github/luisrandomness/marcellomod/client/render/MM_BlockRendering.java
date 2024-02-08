package io.github.luisrandomness.marcellomod.client.render;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.SpriteTicker;
import net.minecraft.client.resources.model.Material;

public class MM_BlockRendering {
    public static void initialize()
    {
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(Sheets.SIGN_SHEET, MM_Blocks.MARCELIUM_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(Sheets.SIGN_SHEET, MM_Blocks.MARCELIUM_HANGING_SIGN_TEXTURE));

        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.MARCELIUM_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.MARCELIUM_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.RED_MARCELIUM_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.GREEN_MARCELIUM_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.YELLOW_MARCELIUM_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.RED_MARCELIUM_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.GREEN_MARCELIUM_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.YELLOW_MARCELIUM_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_RED_MARCELIUM_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING, RenderType.cutout());
    }
}
