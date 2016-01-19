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
		textureWidth = 128;
		textureHeight = 64;
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 5.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		leftMiniRibbonBack = new ModelRenderer(this, 38, 0);
		leftMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
		leftMiniRibbonBack.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(3.0F, 1.0F, 0.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotate(bipedLeftArm, 0.0F, 0.0F, -0.5235987755982988F);
		rightBraidBack = new ModelRenderer(this, 32, 20);
		rightBraidBack.setRotationPoint(-3.0F, -1.0F, 3.0F);
		rightBraidBack.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		setRotate(rightBraidBack, 0.0F, 0.0F, 0.17453292519943295F);
		rightRibbon = new ModelRenderer(this, 24, 0);
		rightRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
		rightRibbon.addBox(-6.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
		setRotate(rightRibbon, 0.0F, 0.0F, 0.17453292519943295F);
		leftMiniRibbonFront = new ModelRenderer(this, 38, 0);
		leftMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
		leftMiniRibbonFront.addBox(-1.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 28);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 5, 10, 0.0F);
		bipedRightArm = new ModelRenderer(this, 56, 0);
		bipedRightArm.setRotationPoint(-3.0F, 1.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotate(bipedRightArm, -0.0F, 0.0F, 0.5235987755982988F);
		skirtBottom2 = new ModelRenderer(this, 0, 43);
		skirtBottom2.setRotationPoint(0.0F, 5.0F, -5.0F);
		skirtBottom2.addBox(-6.0F, 0.0F, -1.0F, 12, 5, 12, 0.0F);
		leftLongHair = new ModelRenderer(this, 40, 34);
		leftLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
		leftLongHair.addBox(0.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotate(leftLongHair, 0.20943951023931953F, 0.0F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 16);
		bipedRightLeg.setRotationPoint(-2.0F, 8.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		HatBase = new ModelRenderer(this, 64, 0);
		HatBase.setRotationPoint(0.0F, -7.0F, 0.0F);
		HatBase.addBox(-4.5F, -2.0F, -4.5F, 9, 2, 9, 0.0F);
		HatRing = new ModelRenderer(this, 64, 11);
		HatRing.setRotationPoint(0.0F, 0.0F, 0.0F);
		HatRing.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10, 0.0F);
		rightMiniRibbonBack = new ModelRenderer(this, 38, 0);
		rightMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
		rightMiniRibbonBack.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		leftBraid = new ModelRenderer(this, 0, 16);
		leftBraid.setRotationPoint(3.0F, -2.0F, -3.0F);
		leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotate(leftBraid, -0.10471975511965977F, 0.0F, 0.0F);
		leftRibbon = new ModelRenderer(this, 24, 0);
		leftRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
		leftRibbon.addBox(0.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
		setRotate(leftRibbon, 0.0F, 0.0F, -0.17453292519943295F);
		leftBraidBack = new ModelRenderer(this, 32, 20);
		leftBraidBack.setRotationPoint(3.0F, -1.0F, 3.0F);
		leftBraidBack.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		setRotate(leftBraidBack, 0.0F, 0.0F, -0.17453292519943295F);
		rightLongHair = new ModelRenderer(this, 62, 34);
		rightLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
		rightLongHair.addBox(-8.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotate(rightLongHair, 0.20943951023931953F, 0.0F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 16);
		bipedLeftLeg.setRotationPoint(2.0F, 8.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		rightBraid = new ModelRenderer(this, 0, 16);
		rightBraid.setRotationPoint(-3.0F, -2.0F, -3.0F);
		rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotate(rightBraid, -0.10471975511965977F, 0.0F, 0.0F);
		rightMiniRibbonFront = new ModelRenderer(this, 38, 0);
		rightMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
		rightMiniRibbonFront.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 7);
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		bipedBody.addChild(skirtTop);
		leftBraidBack.addChild(leftMiniRibbonBack);
		bipedBody.addChild(bipedLeftArm);
		bipedHead.addChild(rightBraidBack);
		HatBase.addChild(rightRibbon);
		leftBraid.addChild(leftMiniRibbonFront);
		skirtTop.addChild(skirtBottom);
		bipedBody.addChild(bipedRightArm);
		skirtBottom.addChild(skirtBottom2);
		bipedHead.addChild(leftLongHair);
		bipedBody.addChild(bipedRightLeg);
		bipedHead.addChild(HatBase);
		HatBase.addChild(HatRing);
		rightBraidBack.addChild(rightMiniRibbonBack);
		bipedHead.addChild(leftBraid);
		HatBase.addChild(leftRibbon);
		bipedHead.addChild(leftBraidBack);
		bipedHead.addChild(rightLongHair);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(bipedHead);
		bipedHead.addChild(rightBraid);
		rightBraid.addChild(rightMiniRibbonFront);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		bipedBody.render(size);
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {

		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		EntityYukari yukari = (EntityYukari)entity;

		bipedHead.rotateAngleY = yaw / (180F / (float)Math.PI);
		bipedHead.rotateAngleX = pitch / (180F / (float)Math.PI);
		bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(onGround) * (float)Math.PI * 2.0F) * 0.2F;

		bipedRightArm.rotateAngleX = MathHelper.cos((float)(movement * 0.6662F + Math.PI)) * 2.0F * far * 0.5F;
		bipedLeftArm.rotateAngleX = MathHelper.cos(movement * 0.6662F) * 2.0F * far * 0.5F;
		bipedRightArm.rotateAngleZ = (float)(30F / 180F * Math.PI);
		bipedLeftArm.rotateAngleZ = (float)(-30F / 180F * Math.PI);

		skirtTop.rotateAngleX = 0F;

		if (yukari.isSneaking()) {
			bipedBody.rotateAngleY = MathHelper.cos(movement * 0.6662F + (float)Math.PI) * 2.4F * far;
			skirtTop.rotateAngleY = MathHelper.cos(movement * 0.6662F + (float)Math.PI) * 2.4F * far;
			bipedRightArm.rotateAngleX = MathHelper.cos(movement * 0.6662F + (float)Math.PI) * 1.4F * far;
			bipedLeftArm.rotateAngleX = MathHelper.cos(movement * 0.6662F) * 1.4F * far;
			bipedHead.rotateAngleX -= 0.5F;
		}

		else if (yukari.isRiding()) {

			bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
			bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
			bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = (float)Math.PI / 14F;
			bipedLeftLeg.rotateAngleY = -((float)Math.PI / 14F);
			bipedRightLeg.rotateAngleZ = (float)Math.PI / 14F;
			bipedLeftLeg.rotateAngleZ = -((float)Math.PI / 14F);
			skirtTop.rotateAngleX = -((float)Math.PI / 5F);
			skirtBottom.rotateAngleX = -((float)Math.PI / 4F);
		}

		else {

			if (yukari.getFlyingHeight() == 0) {
				bipedRightLeg.rotateAngleX = MathHelper.cos(movement) * 0.7F * far;
				bipedLeftLeg.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 0.7F * far;
				bipedRightLeg.rotateAngleZ = 0F;
				bipedLeftLeg.rotateAngleZ = 0F;

				if (movement > 0F) {
					bipedRightArm.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 2.0F * far * 0.5F;
					bipedLeftArm.rotateAngleX = MathHelper.cos(movement) * 2.0F * far * 0.5F;
					bipedRightArm.rotateAngleY = -10F / 180F * (float)Math.PI;
					bipedRightArm.rotateAngleZ = 20F / 180F * (float)Math.PI;
					bipedLeftArm.rotateAngleY = -bipedRightArm.rotateAngleY;
					bipedLeftArm.rotateAngleZ = -bipedRightArm.rotateAngleZ;
				}
				else {
					bipedRightArm.rotateAngleX = -0.7F - MathHelper.sin(tick / 10F) * 0.1F;
					bipedRightArm.rotateAngleY = 0.0F;
					bipedRightArm.rotateAngleZ = -0.6457718F;
					bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX;
					bipedLeftArm.rotateAngleY = 0.0F;
					bipedLeftArm.rotateAngleZ = 0.6457718F;

				}
			}
			else {

				bipedRightLeg.rotateAngleZ = Math.abs(MathHelper.sin(tick / 10F) * 0.1F);
				bipedLeftLeg.rotateAngleZ = -bipedRightLeg.rotateAngleZ;
				bipedRightLeg.rotateAngleX = Math.abs(MathHelper.sin(tick / 10F) * 0.2F);
				bipedLeftLeg.rotateAngleX = bipedRightLeg.rotateAngleZ;

				bipedRightArm.rotateAngleX = -0.7F - MathHelper.sin(tick / 10F) * 0.1F;
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