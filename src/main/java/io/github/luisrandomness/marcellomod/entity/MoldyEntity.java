package io.github.luisrandomness.marcellomod.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoldyEntity extends Monster {
    public MoldyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        if (getItemInHand(InteractionHand.MAIN_HAND).isEmpty())
            setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.IRON_SWORD, 1));
        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    protected float ridingOffset(Entity entity) {
        return -0.6F;
    }

    public static AttributeSupplier.Builder createMoldyAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.325D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0D)
                .add(Attributes.ATTACK_SPEED, 4.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 16.0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MarcelloEntity.class, true));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1, 120));
    }

}
