package io.github.luisrandomness.marcellomod.entity;

import io.github.luisrandomness.marcellomod.init.*;
import io.github.luisrandomness.marcellomod.item.BlockButtonItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class MarkEntity extends Monster {

    public MarkEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        if (getItemInHand(InteractionHand.MAIN_HAND).isEmpty())
            setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(MM_Items.MARCELLO_SWORD, 1));
        if (getItemInHand(InteractionHand.OFF_HAND).isEmpty() && random.nextInt(0,2) == 0)
            setItemInHand(InteractionHand.OFF_HAND, new ItemStack(MM_Items.BLOCK_BUTTON, 1));

        populateDefaultEquipmentSlots(level.getRandom(),difficulty);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public static AttributeSupplier.Builder createMarkAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60)
                .add(Attributes.ARMOR, 6)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.6D)
                .add(Attributes.FOLLOW_RANGE, 24.0);
    }

    @Nullable
    protected SoundEvent get() {
        return MM_SoundEvents.ENTITY_MARK_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return MM_SoundEvents.ENTITY_MARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return MM_SoundEvents.ENTITY_MARK_DEATH;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, true, (livingEntity) -> {
            return !livingEntity.getType().is(MM_Tags.ENTITY_MARCELLO_TYPE) && !(livingEntity instanceof MarkEntity);
        }));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1, 120));
    }

    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);
        if (flag && target instanceof LivingEntity && !target.getType().is(MM_Tags.ENTITY_BLOCK_BUTTON_IMMUNE)) {
            float f = level().getCurrentDifficultyAt(blockPosition()).getEffectiveDifficulty();
            InteractionHand hand;
            LivingEntity livingTarget = (LivingEntity)target;

            if (getMainHandItem().getItem() instanceof BlockButtonItem)
                hand = InteractionHand.MAIN_HAND;
            else if (getOffhandItem().getItem() instanceof BlockButtonItem)
                hand = InteractionHand.OFF_HAND;
            else
                hand = null;

            if (!livingTarget.hasEffect(MM_MobEffects.BLOCKED) && hand != null && getRandom().nextInt(3) <= f)
            {
                playSound(MM_SoundEvents.ENTITY_MARK_BLOCK);
                livingTarget.addEffect(new MobEffectInstance(MM_MobEffects.BLOCKED, 200 + 100 * (int)f), this);

                swing(hand);
                getItemInHand(hand).hurtAndBreak(1, this, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            }
        }
        return flag;
    }
}
