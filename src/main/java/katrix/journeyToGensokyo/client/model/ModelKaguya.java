package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

/**
 * ModelKaguya - Either Mojang or a mod author Created using Tabula 4.1.1
 */
public class ModelKaguya extends ModelBase {

	private ModelRenderer bipedBody;
	private ModelRenderer skirtTop;
	private ModelRenderer rightRibbon;
	private ModelRenderer leftRibbon;
	private ModelRenderer bipedRightLeg;
	private ModelRenderer bipedLeftLeg;
	private ModelRenderer bipedHead;
	private ModelRenderer bipedRightArm;
	private ModelRenderer bipedLeftArm;
	private ModelRenderer skirtBottom;
	private ModelRenderer skirtBottom2;
	private ModelRenderer rightBraid;
	private ModelRenderer leftBraid;
	private ModelRenderer longHair;
	private ModelRenderer longHairLeft;
	private ModelRenderer rightHand;
	private ModelRenderer leftHand;

	public ModelKaguya() {
		textureWidth = 64;
		textureHeight = 64;
		bipedLeftArm = new ModelRenderer(this, 48, 0);
		bipedLeftArm.mirror = true;
		bipedLeftArm.setRotationPoint(4.0F, 1.0F, 0.0F);
		bipedLeftArm.addBox(-3.0F, -1.0F, -1.0F, 4, 7, 2, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 16);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.mirror = true;
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 28);
		skirtBottom.mirror = true;
		skirtBottom.setRotationPoint(0.0F, 4.0F, 4.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -9.0F, 10, 5, 10, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.mirror = true;
		bipedRightArm.setRotationPoint(-4.0F, 1.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 4, 7, 2, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.mirror = true;
		bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		longHairLeft = new ModelRenderer(this, 40, 32);
		longHairLeft.mirror = true;
		longHairLeft.setRotationPoint(0.0F, -1.0F, 4.0F);
		longHairLeft.addBox(-4.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(longHairLeft, 0.20943951023931953F, 0.0F, -0.2617993877991494F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.mirror = true;
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		leftHand = new ModelRenderer(this, 52, 9);
		leftHand.setRotationPoint(0.0F, 6.0F, 0.0F);
		leftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		longHair = new ModelRenderer(this, 40, 32);
		longHair.mirror = true;
		longHair.setRotationPoint(0.0F, -1.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(longHair, 0.20943951023931953F, 0.0F, 0.2617993877991494F);
		rightBraid = new ModelRenderer(this, 0, 28);
		rightBraid.mirror = true;
		rightBraid.setRotationPoint(-3.0F, -3.0F, -3.0F);
		rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(rightBraid, -0.10471975511965977F, 0.0F, 0.0F);
		skirtBottom2 = new ModelRenderer(this, 0, 46);
		skirtBottom2.mirror = true;
		skirtBottom2.setRotationPoint(0.0F, 5.0F, -9.0F);
		skirtBottom2.addBox(-6.0F, 0.0F, -1.0F, 12, 5, 12, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 16);
		bipedRightLeg.mirror = true;
		bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
		rightHand = new ModelRenderer(this, 52, 9);
		rightHand.setRotationPoint(0.0F, 6.0F, 0.0F);
		rightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		leftRibbon = new ModelRenderer(this, 24, 0);
		leftRibbon.setRotationPoint(0.0F, 1.0F, -2.0F);
		leftRibbon.addBox(0.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
		setRotateAngle(leftRibbon, 0.0F, 0.0F, 0.296705972839036F);
		rightRibbon = new ModelRenderer(this, 34, 0);
		rightRibbon.setRotationPoint(0.0F, 1.0F, -2.0F);
		rightRibbon.addBox(-4.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
		setRotateAngle(rightRibbon, 0.0F, 0.0F, -0.296705972839036F);
		leftBraid = new ModelRenderer(this, 0, 28);
		leftBraid.setRotationPoint(3.0F, -3.0F, -3.0F);
		leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(leftBraid, -0.10471975511965977F, 0.0F, 0.0F);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(skirtTop);
		skirtTop.addChild(skirtBottom);
		bipedBody.addChild(bipedRightArm);
		bipedHead.addChild(longHairLeft);
		bipedBody.addChild(bipedHead);
		bipedLeftArm.addChild(leftHand);
		bipedHead.addChild(longHair);
		bipedHead.addChild(rightBraid);
		skirtBottom.addChild(skirtBottom2);
		bipedBody.addChild(bipedRightLeg);
		bipedRightArm.addChild(rightHand);
		bipedBody.addChild(leftRibbon);
		bipedBody.addChild(rightRibbon);
		bipedHead.addChild(leftBraid);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		bipedBody.render(size);
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {

		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		EntityDanmakuMob danmakuMob = (EntityDanmakuMob)entity;

		bipedHead.rotateAngleY = (float)(yaw / (180F / Math.PI));
		bipedHead.rotateAngleX = (float)(pitch / (180F / Math.PI));
		bipedBody.rotateAngleY = (float)(MathHelperJTG.sin(MathHelper.sqrt_float(onGround) * Math.PI * 2.0F) * 0.2F);

		bipedRightArm.rotateAngleX = (float)(MathHelperJTG.cos(movement * 0.6662F + Math.PI) * 2.0F * far * 0.5F);
		bipedLeftArm.rotateAngleX = (float)(MathHelperJTG.cos(movement * 0.6662F) * 2.0F * far * 0.5F);
		bipedRightArm.rotateAngleZ = (float)(30F / 180F * Math.PI);
		bipedLeftArm.rotateAngleZ = (float)(-30F / 180F * Math.PI);

		skirtTop.rotateAngleX = 0F;

		if (danmakuMob.isSneaking()) {
			bipedBody.rotateAngleY = (float)(MathHelperJTG.cos(movement * 0.6662F + Math.PI) * 2.4F * far);
			skirtTop.rotateAngleY = (float)(MathHelperJTG.cos(movement * 0.6662F + Math.PI) * 2.4F * far);
			bipedRightArm.rotateAngleX = (float)(MathHelperJTG.cos(movement * 0.6662F + Math.PI) * 1.4F * far);
			bipedLeftArm.rotateAngleX = (float)(MathHelperJTG.cos(movement * 0.6662F) * 1.4F * far);
			bipedHead.rotateAngleX -= 0.5F;
		}

		else if (danmakuMob.isRiding()) {

			bipedRightArm.rotateAngleX += -(Math.PI / 5F);
			bipedLeftArm.rotateAngleX += -(Math.PI / 5F);
			bipedRightLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = (float)(Math.PI / 14F);
			bipedLeftLeg.rotateAngleY = (float)-(Math.PI / 14F);
			bipedRightLeg.rotateAngleZ = (float)(Math.PI / 14F);
			bipedLeftLeg.rotateAngleZ = (float)-(Math.PI / 14F);
			skirtTop.rotateAngleX = (float)-(Math.PI / 5F);
			skirtBottom.rotateAngleX = (float)-(Math.PI / 4F);
		}

		else {

			if (danmakuMob.getFlyingHeight() == 0) {
				bipedRightLeg.rotateAngleX = (float)(MathHelperJTG.cos(movement) * 0.7F * far);
				bipedLeftLeg.rotateAngleX = (float)(MathHelperJTG.cos(movement + Math.PI) * 0.7F * far);
				bipedRightLeg.rotateAngleZ = 0F;
				bipedLeftLeg.rotateAngleZ = 0F;

				if (movement > 0F) {
					bipedRightArm.rotateAngleX = (float)(MathHelperJTG.cos(movement + Math.PI) * 2.0F * far * 0.5F);
					bipedLeftArm.rotateAngleX = (float)(MathHelperJTG.cos(movement) * 2.0F * far * 0.5F);
					bipedRightArm.rotateAngleY = (float)(-10F / 180F * Math.PI);
					bipedRightArm.rotateAngleZ = (float)(20F / 180F * Math.PI);
					bipedLeftArm.rotateAngleY = -bipedRightArm.rotateAngleY;
					bipedLeftArm.rotateAngleZ = -bipedRightArm.rotateAngleZ;
				}
				else {
					bipedRightArm.rotateAngleX = (float)(-0.7F - MathHelperJTG.sin(tick / 10F) * 0.1F);
					bipedRightArm.rotateAngleY = 0.0F;
					bipedRightArm.rotateAngleZ = -0.6457718F;
					bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX;
					bipedLeftArm.rotateAngleY = 0.0F;
					bipedLeftArm.rotateAngleZ = 0.6457718F;

				}
			}
			else {

				bipedRightLeg.rotateAngleZ = (float)Math.abs(MathHelperJTG.sin(tick / 10F) * 0.1F);
				bipedLeftLeg.rotateAngleZ = -bipedRightLeg.rotateAngleZ;
				bipedRightLeg.rotateAngleX = (float)Math.abs(MathHelperJTG.sin(tick / 10F) * 0.2F);
				bipedLeftLeg.rotateAngleX = bipedRightLeg.rotateAngleZ;

				bipedRightArm.rotateAngleX = (float)(-0.7F - MathHelperJTG.sin(tick / 10F) * 0.1F);
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
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
