package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

public class ModelRemilia extends ModelBase {

	public ModelRenderer bipedBody;
	public ModelRenderer skirtBottom;
	public ModelRenderer rightWing;
	public ModelRenderer leftWing;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer skirtTop;
	public ModelRenderer rightRibbon;
	public ModelRenderer leftRibbon;
	public ModelRenderer longHair;
	public ModelRenderer hatRim;
	public ModelRenderer hatRibbon;

	public ModelRemilia() {
		textureWidth = 64;
		textureHeight = 64;
		rightRibbon = new ModelRenderer(this, 0, 12);
		rightRibbon.setRotationPoint(-2.95F, -2.0F, -3.0F);
		rightRibbon.addBox(-1.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(rightRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		leftRibbon = new ModelRenderer(this, 0, 12);
		leftRibbon.setRotationPoint(2.95F, -2.0F, -3.0F);
		leftRibbon.addBox(0.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(leftRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 28);
		skirtBottom.setRotationPoint(0.0F, 5.0F, 0.0F);
		skirtBottom.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 42, 8);
		bipedLeftLeg.setRotationPoint(2.0F, 13.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
		hatRibbon = new ModelRenderer(this, 32, 5);
		hatRibbon.setRotationPoint(-3.0F, -7.0F, -5.0F);
		hatRibbon.addBox(-4.0F, -2.0F, 0.0F, 4, 3, 1, 0.0F);
		setRotateAngle(hatRibbon, 0.0F, 0.6806784082777886F, 0.29740410453983374F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 2, 3, 0.0F);
		setRotateAngle(longHair, 0.13962634015954636F, 0.0F, 0.0F);
		rightWing = new ModelRenderer(this, 32, 29);
		rightWing.mirror = true;
		rightWing.setRotationPoint(0.0F, 3.0F, 2.0F);
		rightWing.addBox(-15.0F, -13.0F, 0.0F, 15, 17, 1, 0.0F);
		setRotateAngle(rightWing, 0.0F, 0.7853981633974483F, 0.0F);
		hatRim = new ModelRenderer(this, 0, 17);
		hatRim.setRotationPoint(0.0F, -7.0F, 0.0F);
		hatRim.addBox(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
		bipedRightArm = new ModelRenderer(this, 56, 0);
		bipedRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		leftWing = new ModelRenderer(this, 32, 29);
		leftWing.setRotationPoint(0.0F, 3.0F, 2.0F);
		leftWing.addBox(0.0F, -13.0F, 0.0F, 15, 17, 1, 0.0F);
		setRotateAngle(leftWing, 0.0F, -0.7853981633974483F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 42, 8);
		bipedRightLeg.setRotationPoint(-2.0F, 13.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
		bipedBody = new ModelRenderer(this, 40, 17);
		bipedBody.setRotationPoint(0.0F, 5.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 40);
		skirtTop.setRotationPoint(0.0F, 4.0F, 4.0F);
		skirtTop.addBox(-5.0F, 0.0F, -9.0F, 10, 6, 10, 0.0F);
		bipedHead.addChild(rightRibbon);
		bipedHead.addChild(leftRibbon);
		bipedBody.addChild(skirtBottom);
		bipedBody.addChild(bipedLeftLeg);
		bipedHead.addChild(hatRibbon);
		bipedHead.addChild(longHair);
		bipedBody.addChild(rightWing);
		bipedHead.addChild(hatRim);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(leftWing);
		bipedBody.addChild(bipedRightLeg);
		skirtBottom.addChild(skirtTop);
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

		if (danmakuMob.getHealth() > 0F) {
			if (danmakuMob.getFlyingHeight() > 0) {
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 0.8F) * Math.PI * 0.20F + Math.PI * 0.15F);
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
			}
			else {
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 0.5F) * Math.PI * 0.1F + Math.PI * 0.15F);
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
			}
		}
		else {
			rightWing.rotateAngleY = -25F;
			leftWing.rotateAngleY = -rightWing.rotateAngleY;
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
