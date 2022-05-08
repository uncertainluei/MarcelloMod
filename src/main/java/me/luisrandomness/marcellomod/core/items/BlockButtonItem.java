package me.luisrandomness.marcellomod.core.items;

import me.luisrandomness.marcellomod.core.registry.MM_PotionEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;

public class BlockButtonItem extends Item {
    public BlockButtonItem(Properties properties) {
        super(properties);
    }

    //Placeholder code

    @Override
    public ActionResultType interactLivingEntity(ItemStack p_111207_1_, PlayerEntity p_111207_2_, LivingEntity p_111207_3_, Hand p_111207_4_) {
        if (p_111207_2_.level.isClientSide)
            return super.interactLivingEntity(p_111207_1_, p_111207_2_, p_111207_3_, p_111207_4_);

        if (p_111207_3_.hasEffect(MM_PotionEffects.BLOCKED.get())) {
            p_111207_3_.removeEffect(MM_PotionEffects.BLOCKED.get());
        } else {
            p_111207_3_.addEffect(new EffectInstance(MM_PotionEffects.BLOCKED.get(), 600));
            p_111207_2_.playSound(SoundEvents.WITHER_HURT, 0.75F,1F);
        }
        p_111207_1_.shrink(1);
        return super.interactLivingEntity(p_111207_1_, p_111207_2_, p_111207_3_, p_111207_4_);
    }
}
