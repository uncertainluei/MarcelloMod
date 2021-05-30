package com.luisrandomness.marcellomod.client.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class MarcelloModel<MarcelloEntity extends LivingEntity> extends BipedModel<MarcelloEntity> {
    private List<ModelRenderer> cubes = Lists.newArrayList();
    public final ModelRenderer leftSleeve;
    public final ModelRenderer rightSleeve;
    public final ModelRenderer leftPants;
    public final ModelRenderer rightPants;
    public final ModelRenderer jacket;

    public MarcelloModel(float p_i46304_1_) {
        super(RenderType::entityTranslucent, p_i46304_1_, 0.0F, 64, 64);
        this.leftArm = new ModelRenderer(this, 32, 48);
        this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_);
        this.leftArm.setPos(5.0F, 2.0F, 0.0F);
        this.leftSleeve = new ModelRenderer(this, 48, 48);
        this.leftSleeve.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_ + 0.25F);
        this.leftSleeve.setPos(5.0F, 2.0F, 0.0F);
        this.rightSleeve = new ModelRenderer(this, 40, 32);
        this.rightSleeve.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_ + 0.25F);
        this.rightSleeve.setPos(-5.0F, 2.0F, 10.0F);
        this.leftLeg = new ModelRenderer(this, 16, 48);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_);
        this.leftLeg.setPos(1.9F, 12.0F, 0.0F);
        this.leftPants = new ModelRenderer(this, 0, 48);
        this.leftPants.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_ + 0.25F);
        this.leftPants.setPos(1.9F, 12.0F, 0.0F);
        this.rightPants = new ModelRenderer(this, 0, 32);
        this.rightPants.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_i46304_1_ + 0.25F);
        this.rightPants.setPos(-1.9F, 12.0F, 0.0F);
        this.jacket = new ModelRenderer(this, 16, 32);
        this.jacket.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_i46304_1_ + 0.25F);
        this.jacket.setPos(0.0F, 0.0F, 0.0F);
    }

    protected Iterable<ModelRenderer> bodyParts() {
        return Iterables.concat(super.bodyParts(), ImmutableList.of(this.leftPants, this.rightPants, this.leftSleeve, this.rightSleeve, this.jacket));
    }

    public void setupAnim(MarcelloEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setupAnim((MarcelloEntity) p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.leftPants.copyFrom(this.leftLeg);
        this.rightPants.copyFrom(this.rightLeg);
        this.leftSleeve.copyFrom(this.leftArm);
        this.rightSleeve.copyFrom(this.rightArm);
        this.jacket.copyFrom(this.body);
    }

    public void setAllVisible(boolean p_178719_1_) {
        super.setAllVisible(p_178719_1_);
        this.leftSleeve.visible = p_178719_1_;
        this.rightSleeve.visible = p_178719_1_;
        this.leftPants.visible = p_178719_1_;
        this.rightPants.visible = p_178719_1_;
        this.jacket.visible = p_178719_1_;
    }

    public void translateToHand(HandSide p_225599_1_, MatrixStack p_225599_2_) {
        ModelRenderer modelrenderer = this.getArm(p_225599_1_);
        modelrenderer.translateAndRotate(p_225599_2_);
    }

    public ModelRenderer getRandomModelPart(Random p_228288_1_) {
        return this.cubes.get(p_228288_1_.nextInt(this.cubes.size()));
    }

    public void accept(ModelRenderer p_accept_1_) {
        if (this.cubes == null) {
            this.cubes = Lists.newArrayList();
        }
        this.cubes.add(p_accept_1_);
    }
}