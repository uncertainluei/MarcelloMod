package me.luisrandomness.marcellomod.core.events;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.registry.MM_PotionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BlockedEffectEvents {
    private static final TranslationTextComponent BLOCKED_MESSAGE = new TranslationTextComponent("misc." + MarcelloMod.MOD_ID + ".blocked_chat");

    @SubscribeEvent
    public void onBlockPlace(final BlockEvent.EntityPlaceEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(MM_PotionEffects.BLOCKED.get()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onBlockBreak(final BlockEvent.BreakEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player != null && player.hasEffect(MM_PotionEffects.BLOCKED.get()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onEntityAttacked(final LivingAttackEvent event) {
        Entity attacker = event.getSource().getDirectEntity();
        if (attacker != null && attacker instanceof LivingEntity && ((LivingEntity) attacker).hasEffect(MM_PotionEffects.BLOCKED.get()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onChat(final ServerChatEvent event) {
        ServerPlayerEntity player = event.getPlayer();
        if (player != null && player.hasEffect(MM_PotionEffects.BLOCKED.get())) {
            if (!player.getLevel().isClientSide())
                player.displayClientMessage(BLOCKED_MESSAGE,false);
            event.setCanceled(true);
        }
    }
}
