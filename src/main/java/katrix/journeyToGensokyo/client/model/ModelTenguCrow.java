/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelTenguCrow - Katrix
 * Created using Tabula 4.1.1
 */
public class ModelTenguCrow extends ModelBase {
    public ModelRenderer tenguBody;
    public ModelRenderer tenguHead;
    public ModelRenderer tenguFootRight;
    public ModelRenderer tenguWingLeft;
    public ModelRenderer tenguFootLeft;
    public ModelRenderer tenguTail;
    public ModelRenderer tenguWingRight;
    public ModelRenderer tenguWingLeft2;
    public ModelRenderer tenguWingRight2;
    public ModelRenderer tenguBeak;
    public ModelRenderer tenguHat;

    public ModelTenguCrow() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tenguFootLeft = new ModelRenderer(this, 32, 32);
        this.tenguFootLeft.mirror = true;
        this.tenguFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
        this.tenguWingRight = new ModelRenderer(this, 34, 13);
        this.tenguWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
        this.setRotateAngle(tenguWingRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.tenguWingLeft2 = new ModelRenderer(this, 42, 0);
        this.tenguWingLeft2.mirror = true;
        this.tenguWingLeft2.setRotationPoint(14.0F, 4.0F, 0.0F);
        this.tenguWingLeft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
        this.setRotateAngle(tenguWingLeft2, 0.0F, -0.39269908169872414F, 0.0F);
        this.tenguBeak = new ModelRenderer(this, 32, 28);
        this.tenguBeak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F);
        this.tenguWingLeft = new ModelRenderer(this, 34, 13);
        this.tenguWingLeft.mirror = true;
        this.tenguWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
        this.setRotateAngle(tenguWingLeft, 0.0F, -0.7853981633974483F, 0.0F);
        this.tenguTail = new ModelRenderer(this, 24, 0);
        this.tenguTail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(tenguTail, 0.05235987755982988F, 0.0F, 0.0F);
        this.tenguHead = new ModelRenderer(this, 0, 0);
        this.tenguHead.setRotationPoint(0.0F, 8.0F, -8.0F);
        this.tenguHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.tenguHat = new ModelRenderer(this, 42, 28);
        this.tenguHat.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguHat.addBox(-2.0F, -7.0F, -2.0F, 4, 3, 4, 0.0F);
        this.tenguFootRight = new ModelRenderer(this, 32, 32);
        this.tenguFootRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tenguFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
        this.tenguBody = new ModelRenderer(this, 0, 16);
        this.tenguBody.setRotationPoint(0.0F, 8.0F, -8.0F);
        this.tenguBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F);
        this.setRotateAngle(tenguBody, 1.1971213339429108F, 0.0F, 0.0F);
        this.tenguWingRight2 = new ModelRenderer(this, 42, 0);
        this.tenguWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F);
        this.tenguWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
        this.setRotateAngle(tenguWingRight2, 0.0F, 0.39269908169872414F, 0.0F);
        this.tenguBody.addChild(this.tenguFootLeft);
        this.tenguBody.addChild(this.tenguWingRight);
        this.tenguWingLeft.addChild(this.tenguWingLeft2);
        this.tenguHead.addChild(this.tenguBeak);
        this.tenguBody.addChild(this.tenguWingLeft);
        this.tenguBody.addChild(this.tenguTail);
        this.tenguHead.addChild(this.tenguHat);
        this.tenguBody.addChild(this.tenguFootRight);
        this.tenguWingRight.addChild(this.tenguWingRight2);
    }

    @Override
    public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size)
    {
  	  super.render(entity, movement, far, tick, yaw, pitch, size);
  	  setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

      this.tenguBody.render(size);
      this.tenguHead.render(size);
    }
    
    @SuppressWarnings("unused")
	@Override
    public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity)
    {
      super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
      EntityTenguCrow hellRaven = (EntityTenguCrow)entity;
      
      this.tenguHead.rotateAngleY = yaw / (180F / (float)Math.PI);
      this.tenguHead.rotateAngleX = pitch / (180F / (float)Math.PI);
      this.tenguBody.rotateAngleX = ((float)Math.PI / 3F) + MathHelper.cos(tick * 0.1F) * 0.15F;
      this.tenguWingRight.rotateAngleY = MathHelper.cos(tick * 0.8F) * (float)Math.PI * 0.25F;
      this.tenguWingLeft.rotateAngleY = -this.tenguWingRight.rotateAngleY;
      this.tenguWingRight2.rotateAngleY = this.tenguWingRight.rotateAngleY * 0.5F;
      this.tenguWingLeft2.rotateAngleY = -this.tenguWingRight.rotateAngleY * 0.5F;
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
