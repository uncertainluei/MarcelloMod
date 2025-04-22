package io.github.uncertainluei.mc.marcellomod.client.render;

import io.github.uncertainluei.mc.marcellomod.init.MM_Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class MM_BlockRendering {
    public static void initialize()
    {
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

        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.RUISIUM_CLUSTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.LARGE_RUISIUM_BUD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.MEDIUM_RUISIUM_BUD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MM_Blocks.SMALL_RUISIUM_BUD, RenderType.cutout());
    }
}
    