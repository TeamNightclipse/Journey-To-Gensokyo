package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

public class ModelMomiji extends ModelBase {

	private ModelRenderer bipedBody;
	private ModelRenderer skirtTop;
	private ModelRenderer button1;
	private ModelRenderer button2;
	private ModelRenderer bipedLeftArm;
	private ModelRenderer bipedRightArm;
	private ModelRenderer bipedLeftLeg;
	private ModelRenderer bipedRightLeg;
	private ModelRenderer bipedHead;
	private ModelRenderer skirtBottom;
	private ModelRenderer bipedLeftArm2;
	private ModelRenderer leftHand;
	private ModelRenderer shield;
	private ModelRenderer bipedRightArm2;
	private ModelRenderer rightHand;
	private ModelRenderer bipedLeftLeg2;
	private ModelRenderer leftSandal;
	private ModelRenderer bipedRightLeg2;
	private ModelRenderer rightSandal;
	private ModelRenderer rightRibbon;
	private ModelRenderer leftRibbon;
	private ModelRenderer bipedHeadChild;
	private ModelRenderer hat;
	private ModelRenderer earRight;
	private ModelRenderer leftLight;

	public ModelMomiji() {
		textureWidth = 64;
		textureHeight = 64;
		hat = new ModelRenderer(this, 0, 38);
		hat.setRotationPoint(0.0F, -7.0F, 0.0F);
		hat.addBox(-2.0F, -4.0F, -2.0F, 4, 3, 4, 0.0F);
		bipedLeftLeg2 = new ModelRenderer(this, 50, 22);
		bipedLeftLeg2.mirror = true;
		bipedLeftLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedLeftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		button1 = new ModelRenderer(this, 4, 32);
		button1.mirror = true;
		button1.setRotationPoint(0.0F, 3.0F, -1.0F);
		button1.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 36, 22);
		bipedRightLeg.mirror = true;
		bipedRightLeg.setRotationPoint(-1.5F, 10.0F, 0.0F);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.mirror = true;
		skirtTop.setRotationPoint(0.0F, 7.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		leftSandal = new ModelRenderer(this, 50, 32);
		leftSandal.mirror = true;
		leftSandal.setRotationPoint(0.0F, 6.0F, 0.0F);
		leftSandal.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
		bipedHeadChild = new ModelRenderer(this, 0, 50);
		bipedHeadChild.mirror = true;
		bipedHeadChild.setRotationPoint(0.0F, -2.0F, 4.0F);
		bipedHeadChild.addBox(-4.0F, -1.0F, -3.0F, 8, 5, 3, 0.0F);
		setRotateAngle(bipedHeadChild, 0.20943951023931953F, 0.0F, 0.0F);
		rightRibbon = new ModelRenderer(this, 0, 32);
		rightRibbon.mirror = true;
		rightRibbon.setRotationPoint(-3.0F, -2.0F, -3.0F);
		rightRibbon.addBox(-1.0F, -1.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(rightRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		rightSandal = new ModelRenderer(this, 50, 32);
		rightSandal.mirror = true;
		rightSandal.setRotationPoint(0.0F, 6.0F, 0.0F);
		rightSandal.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 36, 22);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.setRotationPoint(1.5F, 10.0F, 0.0F);
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		button2 = new ModelRenderer(this, 4, 32);
		button2.mirror = true;
		button2.setRotationPoint(0.0F, 6.0F, -1.0F);
		button2.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
		skirtBottom = new ModelRenderer(this, 16, 32);
		skirtBottom.mirror = true;
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 7, 10, 0.0F);
		shield = new ModelRenderer(this, 32, 55);
		shield.mirror = true;
		shield.setRotationPoint(2.1F, 2.0F, -1.0F);
		shield.addBox(-2.5F, -4.0F, 0.0F, 7, 8, 1, 0.0F);
		setRotateAngle(shield, 0.0F, -1.5707963267948966F, 0.0F);
		leftHand = new ModelRenderer(this, 48, 0);
		leftHand.mirror = true;
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		leftHand.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		bipedRightLeg2 = new ModelRenderer(this, 50, 22);
		bipedRightLeg2.mirror = true;
		bipedRightLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedRightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		bipedRightArm = new ModelRenderer(this, 24, 0);
		bipedRightArm.mirror = true;
		bipedRightArm.setRotationPoint(-4.0F, 2.0F, -1.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 4, 0.0F);
		leftLight = new ModelRenderer(this, 52, 7);
		leftLight.setRotationPoint(4.0F, -6.0F, 0.0F);
		leftLight.addBox(-0.0F, -3.0F, -2.0F, 3, 3, 1, 0.0F);
		setRotateAngle(leftLight, 0.0F, -0.5235987755982988F, -0.9773843811168246F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.mirror = true;
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.mirror = true;
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		earRight = new ModelRenderer(this, 52, 3);
		earRight.setRotationPoint(-4.0F, -6.0F, 0.0F);
		earRight.addBox(-3.0F, -3.0F, -2.0F, 3, 3, 1, 0.0F);
		setRotateAngle(earRight, 0.0F, 0.5235987755982988F, 0.9773843811168246F);
		bipedLeftArm = new ModelRenderer(this, 24, 0);
		bipedLeftArm.mirror = true;
		bipedLeftArm.setRotationPoint(4.0F, 2.0F, -1.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 4, 0.0F);
		bipedRightArm2 = new ModelRenderer(this, 36, 0);
		bipedRightArm2.mirror = true;
		bipedRightArm2.setRotationPoint(0.0F, 3.0F, 1.0F);
		bipedRightArm2.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 4, 0.0F);
		rightHand = new ModelRenderer(this, 48, 0);
		rightHand.mirror = true;
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		rightHand.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		bipedLeftArm2 = new ModelRenderer(this, 36, 0);
		bipedLeftArm2.mirror = true;
		bipedLeftArm2.setRotationPoint(0.0F, 3.0F, 1.0F);
		bipedLeftArm2.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 4, 0.0F);
		leftRibbon = new ModelRenderer(this, 0, 32);
		leftRibbon.mirror = true;
		leftRibbon.setRotationPoint(3.0F, -2.0F, -3.0F);
		leftRibbon.addBox(0.0F, -1.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(leftRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		bipedHead.addChild(hat);
		bipedLeftLeg.addChild(bipedLeftLeg2);
		bipedBody.addChild(button1);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(skirtTop);
		bipedLeftLeg2.addChild(leftSandal);
		bipedHead.addChild(bipedHeadChild);
		bipedHead.addChild(rightRibbon);
		bipedRightLeg2.addChild(rightSandal);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(button2);
		skirtTop.addChild(skirtBottom);
		bipedLeftArm2.addChild(shield);
		bipedLeftArm2.addChild(leftHand);
		bipedRightLeg.addChild(bipedRightLeg2);
		bipedBody.addChild(bipedRightArm);
		bipedHead.addChild(leftLight);
		bipedBody.addChild(bipedHead);
		bipedHead.addChild(earRight);
		bipedBody.addChild(bipedLeftArm);
		bipedRightArm.addChild(bipedRightArm2);
		bipedRightArm2.addChild(rightHand);
		bipedLeftArm.addChild(bipedLeftArm2);
		bipedHead.addChild(leftRibbon);
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
