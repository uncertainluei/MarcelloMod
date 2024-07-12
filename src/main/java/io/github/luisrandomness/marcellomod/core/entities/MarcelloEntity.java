package io.github.luisrandomness.marcellomod.core.entities;

import io.github.luisrandomness.marcellomod.core.registry.MM_Items;
import io.github.luisrandomness.marcellomod.core.types.MM_CreatureTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class MarcelloEntity extends MonsterEntity {

    public MarcelloEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
        super(p_i48553_1_, p_i48553_2_);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(MM_Items.PHONE.get(), 1));
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.225D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 32);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MoldyEntity.class, true, true));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new SwimGoal(this));
    }

    @Override
    public CreatureAttribute getMobType() {
        return MM_CreatureTypes.MARCELLO;
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
