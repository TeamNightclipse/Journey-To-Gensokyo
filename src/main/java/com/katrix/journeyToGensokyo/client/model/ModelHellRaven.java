/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.client.model;

import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelHellRaven - Katrix
 * Created using Tabula 4.1.1
 */

@SideOnly(Side.CLIENT)
public class ModelHellRaven extends ModelBase {
    public ModelRenderer ravenBody;
    public ModelRenderer ravenWingRight;
    public ModelRenderer ravenWingLeft;
    public ModelRenderer ravenTail;
    public ModelRenderer ravenHead;
    public ModelRenderer ravenWingRight2;
    public ModelRenderer ravenWingleft2;
    public ModelRenderer ravenFootRight;
    public ModelRenderer ravenFootLeft;
    public ModelRenderer ravenBeak;

    public ModelHellRaven() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ravenWingleft2 = new ModelRenderer(this, 42, 0);
        this.ravenWingleft2.mirror = true;
        this.ravenWingleft2.setRotationPoint(14.0F, 4.0F, 0.0F);
        this.ravenWingleft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
        this.setRotateAngle(ravenWingleft2, 0.0F, -0.31154127148098787F, 0.0F);
        this.ravenFootRight = new ModelRenderer(this, 32, 32);
        this.ravenFootRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
        this.ravenBeak = new ModelRenderer(this, 32, 28);
        this.ravenBeak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F);
        this.ravenWingRight2 = new ModelRenderer(this, 42, 0);
        this.ravenWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F);
        this.ravenWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
        this.setRotateAngle(ravenWingRight2, 0.0F, 0.31154127148098787F, 0.0F);
        this.ravenWingLeft = new ModelRenderer(this, 34, 13);
        this.ravenWingLeft.mirror = true;
        this.ravenWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
        this.setRotateAngle(ravenWingLeft, 0.0F, -0.6108652381980153F, 0.0F);
        this.ravenFootLeft = new ModelRenderer(this, 32, 32);
        this.ravenFootLeft.mirror = true;
        this.ravenFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
        this.ravenBody = new ModelRenderer(this, 0, 16);
        this.ravenBody.setRotationPoint(0.0F, 8.0F, -8.0F);
        this.ravenBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F);
        this.setRotateAngle(ravenBody, 1.3089969389957472F, 0.0F, 0.0F);
        this.ravenTail = new ModelRenderer(this, 24, 0);
        this.ravenTail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(ravenTail, 0.05235987755982988F, 0.0F, 0.0F);
        this.ravenWingRight = new ModelRenderer(this, 34, 13);
        this.ravenWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ravenWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
        this.setRotateAngle(ravenWingRight, 0.0F, 0.6108652381980153F, 0.0F);
        this.ravenHead = new ModelRenderer(this, 0, 0);
        this.ravenHead.setRotationPoint(0.0F, 8.0F, -8.0F);
        this.ravenHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.ravenWingLeft.addChild(this.ravenWingleft2);
        this.ravenBody.addChild(this.ravenFootRight);
        this.ravenHead.addChild(this.ravenBeak);
        this.ravenWingRight.addChild(this.ravenWingRight2);
        this.ravenBody.addChild(this.ravenWingLeft);
        this.ravenBody.addChild(this.ravenFootLeft);
        this.ravenBody.addChild(this.ravenTail);
        this.ravenBody.addChild(this.ravenWingRight);
    }
    
    @Override
    public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size)
    {
  	  super.render(entity, movement, far, tick, yaw, pitch, size);
  	  setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

      this.ravenBody.render(size);
      this.ravenHead.render(size);
    }
    
    @SuppressWarnings("unused")
	@Override
    public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity)
    {
      super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
      EntityHellRaven hellRaven = (EntityHellRaven)entity;
      
      this.ravenHead.rotateAngleY = yaw / (180F / (float)Math.PI);
      this.ravenHead.rotateAngleX = pitch / (180F / (float)Math.PI);
      this.ravenBody.rotateAngleX = ((float)Math.PI / 3F) + MathHelper.cos(tick * 0.1F) * 0.15F;
      this.ravenWingRight.rotateAngleY = MathHelper.cos(tick * 0.8F) * (float)Math.PI * 0.25F;
      this.ravenWingLeft.rotateAngleY = -this.ravenWingRight.rotateAngleY;
      this.ravenWingRight2.rotateAngleY = this.ravenWingRight.rotateAngleY * 0.5F;
      this.ravenWingleft2.rotateAngleY = -this.ravenWingRight.rotateAngleY * 0.5F;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
