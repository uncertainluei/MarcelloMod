package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.AnyBlockInteractionTrigger;
import net.minecraft.advancements.critereon.DefaultBlockInteractionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.packs.VanillaAdventureAdvancements;
import net.minecraft.data.advancements.packs.VanillaStoryAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MM_AdvancementProvider extends FabricAdvancementProvider {
    public MM_AdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> writer) {
        AdvancementHolder core = Advancement.Builder.advancement().display(MM_Items.MARCELLO_FRUIT, Component.translatable("advancements.marcellomod.root.title"), Component.translatable("advancements.marcellomod.root.description"), MarcelloMod.modIdentifier("textures/gui/advancement_background.png"), AdvancementType.TASK, false, false, false).addCriterion("marcello_block", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{MM_Blocks.MARCELLO_BLOCK})).save(writer, "marcellomod:root");

        Advancement.Builder.advancement().display(MM_Blocks.DOOR_2_WALL, Component.translatable("advancements.marcellomod.door_2_wall.title"), Component.translatable("advancements.marcellomod.door_2_wall.description"), null, AdvancementType.TASK, true, true, false).addCriterion("door_2_wall", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{MM_Blocks.DOOR_2_WALL})).parent(core).save(writer, "marcellomod:door_2_wall");
    }
}
