package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

public class ModelSeiga extends ModelBase {

	public ModelRenderer bipedBody;
	public ModelRenderer skirtTop;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer skirtBottom;
	public ModelRenderer longHair;
	public ModelRenderer rightRingHair1;
	public ModelRenderer leftRingHair1;
	public ModelRenderer stick;
	public ModelRenderer rightRingHair2;
	public ModelRenderer rightRingHair3;
	public ModelRenderer leftRingHair2;
	public ModelRenderer leftRingHair3;
	public ModelRenderer chisel;

	public ModelSeiga() {
		textureWidth = 64;
		textureHeight = 64;
		chisel = new ModelRenderer(this, 0, 49);
		chisel.setRotationPoint(-11.0F, -1.0F, 0.0F);
		chisel.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		leftRingHair2 = new ModelRenderer(this, 32, 26);
		leftRingHair2.setRotationPoint(3.0F, 1.0F, 0.0F);
		leftRingHair2.addBox(0.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		setRotateAngle(leftRingHair2, 0.0F, 0.0F, -1.8325957145940461F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-3.0F, 3.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 19);
		bipedRightLeg.setRotationPoint(-2.0F, 11.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 19);
		bipedLeftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		rightRingHair3 = new ModelRenderer(this, 32, 26);
		rightRingHair3.setRotationPoint(6.0F, 0.0F, 0.0F);
		rightRingHair3.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		setRotateAngle(rightRingHair3, 0.0F, 0.0F, 1.8325957145940461F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(3.0F, 3.0F, 0.0F);
		bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, -1.0F, -5.0F, 10, 5, 10, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		stick = new ModelRenderer(this, 0, 47);
		stick.setRotationPoint(2.0F, -8.0F, 0.0F);
		stick.addBox(-9.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
		setRotateAngle(stick, 0.0F, -0.17453292519943295F, 0.17453292519943295F);
		leftRingHair1 = new ModelRenderer(this, 32, 26);
		leftRingHair1.setRotationPoint(3.0F, -7.0F, 0.0F);
		leftRingHair1.addBox(0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		setRotateAngle(leftRingHair1, 0.0F, 0.0F, -0.7853981633974483F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 4, 3, 0.0F);
		setRotateAngle(longHair, 0.10471975511965977F, 0.0F, 0.0F);
		rightRingHair1 = new ModelRenderer(this, 32, 26);
		rightRingHair1.setRotationPoint(-3.0F, -7.0F, 0.0F);
		rightRingHair1.addBox(0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		setRotateAngle(rightRingHair1, 0.0F, 0.0F, -2.356194490192345F);
		rightRingHair2 = new ModelRenderer(this, 32, 26);
		rightRingHair2.setRotationPoint(3.0F, -1.0F, 0.0F);
		rightRingHair2.addBox(0.0F, -2.0F, -1.0F, 6, 2, 2, 0.0F);
		setRotateAngle(rightRingHair2, 0.0F, 0.0F, 1.8325957145940461F);
		leftRingHair3 = new ModelRenderer(this, 32, 26);
		leftRingHair3.setRotationPoint(6.0F, 0.0F, 0.0F);
		leftRingHair3.addBox(0.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F);
		setRotateAngle(leftRingHair3, 0.0F, 0.0F, -1.8325957145940461F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		stick.addChild(chisel);
		leftRingHair1.addChild(leftRingHair2);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(bipedLeftLeg);
		rightRingHair2.addChild(rightRingHair3);
		bipedBody.addChild(bipedLeftArm);
		skirtTop.addChild(skirtBottom);
		bipedHead.addChild(stick);
		bipedHead.addChild(leftRingHair1);
		bipedBody.addChild(skirtTop);
		bipedHead.addChild(longHair);
		bipedHead.addChild(rightRingHair1);
		rightRingHair1.addChild(rightRingHair2);
		leftRingHair2.addChild(leftRingHair3);
		bipedBody.addChild(bipedHead);
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
