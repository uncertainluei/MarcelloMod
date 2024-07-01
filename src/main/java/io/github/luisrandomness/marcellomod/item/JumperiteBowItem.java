package io.github.luisrandomness.marcellomod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class JumperiteBowItem extends BowItem {
    private final Tier tier;

    public JumperiteBowItem(Tier tier, Properties properties) {
        super(properties.durability(514));
        this.tier = tier;
    }

    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return this.tier.getRepairIngredient().test(repairCandidate) || super.isValidRepairItem(stack, repairCandidate);
    }

    public static float getPowerForTime(int charge) {
        float f = (float)charge / 30F;
        f = (f * f + f * 2F) / 3F;

        if (f <= 1F)
            return f;

        // TODO: Re-adjust equation and provide a 'cap'
        float total = 0F;
        while (f >= 0.5F) {
            total += 0.5F;
            f -= 0.5F;
            f *= 0.8F;
        }

        return total+f;
    }
}
