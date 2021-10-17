package me.luisrandomness.marcellomod.core.effects;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BlockedEffect extends Effect {
    public BlockedEffect(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    public double getAttributeModifierValue(int p_111183_1_, AttributeModifier p_111183_2_) {
        return 0.0D;
    }
}
