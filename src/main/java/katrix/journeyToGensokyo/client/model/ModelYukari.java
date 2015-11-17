/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod.. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelYukari extends ModelBase {
    public ModelRenderer bipedBody;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer skirtTop;
    public ModelRenderer HatBase;
    public ModelRenderer rightBraidBack;
    public ModelRenderer leftBraidBack;
    public ModelRenderer rightLongHair;
    public ModelRenderer leftBraid;
    public ModelRenderer rightBraid;
    public ModelRenderer leftLongHair;
    public ModelRenderer HatRing;
    public ModelRenderer rightRibbon;
    public ModelRenderer leftRibbon;
    public ModelRenderer rightMiniRibbonBack;
    public ModelRenderer leftMiniRibbonBack;
    public ModelRenderer leftMiniRibbonFront;
    public ModelRenderer rightMiniRibbonFront;
    public ModelRenderer skirtBottom;
    public ModelRenderer skirtBottom2;

    public ModelYukari() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.skirtTop = new ModelRenderer(this, 0, 16);
        this.skirtTop.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
        this.leftMiniRibbonBack = new ModelRenderer(this, 38, 0);
        this.leftMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
        this.leftMiniRibbonBack.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 56, 0);
        this.bipedLeftArm.setRotationPoint(3.0F, 1.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotate(bipedLeftArm, 0.0F, 0.0F, -0.5235987755982988F);
        this.rightBraidBack = new ModelRenderer(this, 32, 20);
        this.rightBraidBack.setRotationPoint(-3.0F, -1.0F, 3.0F);
        this.rightBraidBack.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotate(rightBraidBack, 0.0F, 0.0F, 0.17453292519943295F);
        this.rightRibbon = new ModelRenderer(this, 24, 0);
        this.rightRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
        this.rightRibbon.addBox(-6.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotate(rightRibbon, 0.0F, 0.0F, 0.17453292519943295F);
        this.leftMiniRibbonFront = new ModelRenderer(this, 38, 0);
        this.leftMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
        this.leftMiniRibbonFront.addBox(-1.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.skirtBottom = new ModelRenderer(this, 0, 28);
        this.skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 5, 10, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 56, 0);
        this.bipedRightArm.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotate(bipedRightArm, -0.0F, 0.0F, 0.5235987755982988F);
        this.skirtBottom2 = new ModelRenderer(this, 0, 43);
        this.skirtBottom2.setRotationPoint(0.0F, 5.0F, -5.0F);
        this.skirtBottom2.addBox(-6.0F, 0.0F, -1.0F, 12, 5, 12, 0.0F);
        this.leftLongHair = new ModelRenderer(this, 40, 34);
        this.leftLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.leftLongHair.addBox(0.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
        this.setRotate(leftLongHair, 0.20943951023931953F, 0.0F, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 50, 16);
        this.bipedRightLeg.setRotationPoint(-2.0F, 8.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.HatBase = new ModelRenderer(this, 64, 0);
        this.HatBase.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.HatBase.addBox(-4.5F, -2.0F, -4.5F, 9, 2, 9, 0.0F);
        this.HatRing = new ModelRenderer(this, 64, 11);
        this.HatRing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HatRing.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10, 0.0F);
        this.rightMiniRibbonBack = new ModelRenderer(this, 38, 0);
        this.rightMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
        this.rightMiniRibbonBack.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.leftBraid = new ModelRenderer(this, 0, 16);
        this.leftBraid.setRotationPoint(3.0F, -2.0F, -3.0F);
        this.leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
        this.setRotate(leftBraid, -0.10471975511965977F, 0.0F, 0.0F);
        this.leftRibbon = new ModelRenderer(this, 24, 0);
        this.leftRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
        this.leftRibbon.addBox(0.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
        this.setRotate(leftRibbon, 0.0F, 0.0F, -0.17453292519943295F);
        this.leftBraidBack = new ModelRenderer(this, 32, 20);
        this.leftBraidBack.setRotationPoint(3.0F, -1.0F, 3.0F);
        this.leftBraidBack.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotate(leftBraidBack, 0.0F, 0.0F, -0.17453292519943295F);
        this.rightLongHair = new ModelRenderer(this, 62, 34);
        this.rightLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.rightLongHair.addBox(-8.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
        this.setRotate(rightLongHair, 0.20943951023931953F, 0.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 50, 16);
        this.bipedLeftLeg.setRotationPoint(2.0F, 8.0F, 0.0F);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.rightBraid = new ModelRenderer(this, 0, 16);
        this.rightBraid.setRotationPoint(-3.0F, -2.0F, -3.0F);
        this.rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
        this.setRotate(rightBraid, -0.10471975511965977F, 0.0F, 0.0F);
        this.rightMiniRibbonFront = new ModelRenderer(this, 38, 0);
        this.rightMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
        this.rightMiniRibbonFront.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bipedBody = new ModelRenderer(this, 32, 7);
        this.bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
        this.bipedBody.addChild(this.skirtTop);
        this.leftBraidBack.addChild(this.leftMiniRibbonBack);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedHead.addChild(this.rightBraidBack);
        this.HatBase.addChild(this.rightRibbon);
        this.leftBraid.addChild(this.leftMiniRibbonFront);
        this.skirtTop.addChild(this.skirtBottom);
        this.bipedBody.addChild(this.bipedRightArm);
        this.skirtBottom.addChild(this.skirtBottom2);
        this.bipedHead.addChild(this.leftLongHair);
        this.bipedBody.addChild(this.bipedRightLeg);
        this.bipedHead.addChild(this.HatBase);
        this.HatBase.addChild(this.HatRing);
        this.rightBraidBack.addChild(this.rightMiniRibbonBack);
        this.bipedHead.addChild(this.leftBraid);
        this.HatBase.addChild(this.leftRibbon);
        this.bipedHead.addChild(this.leftBraidBack);
        this.bipedHead.addChild(this.rightLongHair);
        this.bipedBody.addChild(this.bipedLeftLeg);
        this.bipedBody.addChild(this.bipedHead);
        this.bipedHead.addChild(this.rightBraid);
        this.rightBraid.addChild(this.rightMiniRibbonFront);
    }

    @Override
    public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size)
    {
    	this.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
  	    this.bipedBody.render(size);
    }
    
	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity)
	{
		
		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		EntityYukari yukari = (EntityYukari)entity;
		
	  	this.bipedHead.rotateAngleY = yaw / (180F / (float)Math.PI);
	    this.bipedHead.rotateAngleX = pitch / (180F / (float)Math.PI);
	  	this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(onGround) * (float)Math.PI * 2.0F) * 0.2F;
		
		bipedRightArm.rotateAngleX = MathHelper.cos(movement * 0.6662F + 3.141593F) * 2.0F * far * 0.5F;
		bipedLeftArm.rotateAngleX = MathHelper.cos(movement * 0.6662F) * 2.0F * far * 0.5F;
		bipedRightArm.rotateAngleZ = 30F / 180F * 3.141593F;
		bipedLeftArm.rotateAngleZ = -30F / 180F * 3.141593F;
		
	  	this.skirtTop.rotateAngleX = 0F;
		
		if (yukari.isSneaking()){
			bipedBody.rotateAngleY = MathHelper.cos(movement * 0.6662F + (float) Math.PI) * 2.4F * far;
			skirtTop.rotateAngleY = MathHelper.cos(movement * 0.6662F + (float) Math.PI) * 2.4F * far;
			bipedRightArm.rotateAngleX = MathHelper.cos(movement * 0.6662F + (float) Math.PI) * 1.4F * far;
			bipedLeftArm.rotateAngleX = MathHelper.cos(movement * 0.6662F) * 1.4F * far;
			bipedHead.rotateAngleX -= 0.5F;
		}
		
		else if (yukari.isRiding()) {
			
			this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
			this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
			this.bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			this.bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 14F);
			this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 14F);
			this.bipedRightLeg.rotateAngleZ = ((float)Math.PI / 14F);
			this.bipedLeftLeg.rotateAngleZ = -((float)Math.PI / 14F);
	        this.skirtTop.rotateAngleX = -((float)Math.PI / 5F);
	        this.skirtBottom.rotateAngleX = -((float)Math.PI / 4F);
		}
		
	    else
	    {
	  	
		  	if(yukari.getFlyingHeight() == 0)
		  	{
		  		bipedRightLeg.rotateAngleX = MathHelper.cos(movement) * 0.7F * far;
		  		bipedLeftLeg.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 0.7F * far;
			  	bipedRightLeg.rotateAngleZ = 0F; 
			  	bipedLeftLeg.rotateAngleZ = 0F;
			  	
			  	if(movement > 0F)
			  	{
			        this.bipedRightArm.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 2.0F * far * 0.5F;
			        this.bipedLeftArm.rotateAngleX = MathHelper.cos(movement) * 2.0F * far * 0.5F;
			        bipedRightArm.rotateAngleY = -10F / 180F * (float)Math.PI;
			        bipedRightArm.rotateAngleZ = 20F / 180F * (float)Math.PI;
			        bipedLeftArm.rotateAngleY = -bipedRightArm.rotateAngleY;
			        bipedLeftArm.rotateAngleZ = -bipedRightArm.rotateAngleZ;
			  	}
			  	else
			  	{
			  	  	bipedRightArm.rotateAngleX = -0.7F - MathHelper.sin(tick  / 10F) * 0.1F;
			  	  	bipedRightArm.rotateAngleY = 0.0F;
			  	  	bipedRightArm.rotateAngleZ = -0.6457718F;
			  	  	bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX;
			  	  	bipedLeftArm.rotateAngleY = 0.0F;
			  	  	bipedLeftArm.rotateAngleZ = 0.6457718F;
		
			  	}
		  	}
		  	else
		  	{
		  		
		  	  	bipedRightLeg.rotateAngleZ = Math.abs(MathHelper.sin(tick  / 10F) * 0.1F); 
		  	  	bipedLeftLeg.rotateAngleZ = -bipedRightLeg.rotateAngleZ;
		  	  	bipedRightLeg.rotateAngleX = Math.abs(MathHelper.sin(tick  / 10F) * 0.2F); 
		  	  	bipedLeftLeg.rotateAngleX = bipedRightLeg.rotateAngleZ;
		  	  	
		  	  	bipedRightArm.rotateAngleX = -0.7F - MathHelper.sin(tick  / 10F) * 0.1F;
		  	  	bipedRightArm.rotateAngleY = 0.0F;
			  	bipedRightArm.rotateAngleZ = -0.6457718F;
		  	  	bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX;
		  	  	bipedLeftArm.rotateAngleY = 0.0F;
			  	bipedLeftArm.rotateAngleZ = 0.6457718F;
		  	}
	    }
	}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotate(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}