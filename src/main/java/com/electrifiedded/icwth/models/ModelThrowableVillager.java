package com.electrifiedded.icwth.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelThrowableVillager extends ModelBase {
    public ModelRenderer villagerHead;
    public ModelRenderer villagerBody;
    public ModelRenderer villagerArms;
    public ModelRenderer rightVillagerLeg;
    public ModelRenderer leftVillagerLeg;
    public ModelRenderer villagerNose;

    public ModelThrowableVillager(float scale) {
        this(scale, 0.0f, 64, 64);
    }

    public ModelThrowableVillager(float scale, float offset, int textureWidth, int textureHeight) {
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;

        this.villagerHead = new ModelRenderer(this, 0, 0);
        this.villagerHead.setRotationPoint(0.0f, -22.0f + offset, 0.0f);
        this.villagerHead.addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, scale);

        this.villagerNose = new ModelRenderer(this, 24, 0);
        this.villagerNose.setRotationPoint(0.0f, offset - 2.0f, 0.0f);
        this.villagerNose.addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, scale);
        this.villagerHead.addChild(this.villagerNose);

        this.villagerBody = new ModelRenderer(this, 16, 20);
        this.villagerBody.setRotationPoint(0.0f, -22.0f + offset, 0.0f);
        this.villagerBody.addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, scale);
        this.villagerBody.addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, scale + 0.5f);

        this.villagerArms = new ModelRenderer(this, 44, 22);
        this.villagerArms.setRotationPoint(0.0f, -22.0f + offset + 2.0f, 0.0f);
        this.villagerArms.addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, scale);
        this.villagerArms.addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, scale);
        this.villagerArms.addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, scale);

        this.rightVillagerLeg = new ModelRenderer(this, 0, 22);
        this.rightVillagerLeg.setRotationPoint(-2.0f, -10.0f + offset, 0.0f);
        this.rightVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, scale);

        this.leftVillagerLeg = new ModelRenderer(this, 0, 22);
        this.leftVillagerLeg.mirror = true;
        this.leftVillagerLeg.setRotationPoint(2.0f, -10.0f + offset, 0.0f);
        this.leftVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, scale);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.villagerHead.render(scale);
        this.villagerBody.render(scale);
        this.rightVillagerLeg.render(scale);
        this.leftVillagerLeg.render(scale);
        this.villagerArms.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        this.villagerHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.villagerHead.rotateAngleX = headPitch * 0.017453292F;
        this.villagerArms.rotationPointY = -19.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        this.villagerArms.rotateAngleX = -0.75F;
        this.rightVillagerLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.leftVillagerLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.rightVillagerLeg.rotateAngleY = 0.0F;
        this.leftVillagerLeg.rotateAngleY = 0.0F;
    }
}