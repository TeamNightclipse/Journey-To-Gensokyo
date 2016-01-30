package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

/**
 * ModelKasen - Either Mojang or a mod author Created using Tabula 4.1.1
 */
public class ModelKasen extends ModelBase {

	public ModelRenderer bipedBody;
	public ModelRenderer skirtTop;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer skirtBottom;
	public ModelRenderer longHair;
	public ModelRenderer rightSinyon;
	public ModelRenderer leftSinyon;
	public ModelRenderer rightRibbon;
	public ModelRenderer leftRibbon;

	public ModelKasen() {
		textureWidth = 64;
		textureHeight = 64;
		skirtBottom = new ModelRenderer(this, 0, 32);
		skirtBottom.mirror = true;
		skirtBottom.setRotationPoint(0.0F, 4.0F, 4.0F);
		skirtBottom.addBox(-5.0F, -1.0F, -9.0F, 10, 5, 10, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.mirror = true;
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.mirror = true;
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.mirror = true;
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 4, 3, 0.0F);
		setRotateAngle(longHair, 0.10471975511965977F, 0.0F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.setRotationPoint(2.0F, 10.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 19);
		bipedRightLeg.mirror = true;
		bipedRightLeg.setRotationPoint(-2.0F, 10.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		leftRibbon = new ModelRenderer(this, 32, 33);
		leftRibbon.mirror = true;
		leftRibbon.setRotationPoint(5.0F, -5.0F, 0.0F);
		leftRibbon.addBox(-1.5F, 0.0F, 0.0F, 3, 8, 1, 0.0F);
		setRotateAngle(leftRibbon, 0.0F, 1.5707963267948966F, 0.0F);
		leftSinyon = new ModelRenderer(this, 32, 25);
		leftSinyon.mirror = true;
		leftSinyon.setRotationPoint(3.5F, -6.0F, 0.0F);
		leftSinyon.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
		setRotateAngle(leftSinyon, 0.0F, 0.0F, 1.3089969389957472F);
		rightSinyon = new ModelRenderer(this, 32, 25);
		rightSinyon.mirror = true;
		rightSinyon.setRotationPoint(-3.5F, -6.0F, 0.0F);
		rightSinyon.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
		setRotateAngle(rightSinyon, 0.0F, 0.0F, -1.3089969389957472F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.mirror = true;
		bipedLeftArm.setRotationPoint(3.0F, 2.0F, 0.0F);
		bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 9, 2, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.mirror = true;
		bipedRightArm.setRotationPoint(-3.0F, 2.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 9, 2, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.mirror = true;
		skirtTop.setRotationPoint(0.0F, 7.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		rightRibbon = new ModelRenderer(this, 32, 33);
		rightRibbon.mirror = true;
		rightRibbon.setRotationPoint(-4.0F, -5.0F, 0.0F);
		rightRibbon.addBox(-1.5F, 0.0F, -1.0F, 3, 8, 1, 0.0F);
		setRotateAngle(rightRibbon, 0.0F, 1.5707963267948966F, 0.0F);
		skirtTop.addChild(skirtBottom);
		bipedBody.addChild(bipedHead);
		bipedHead.addChild(longHair);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(bipedRightLeg);
		bipedHead.addChild(leftRibbon);
		bipedHead.addChild(leftSinyon);
		bipedHead.addChild(rightSinyon);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(skirtTop);
		bipedHead.addChild(rightRibbon);
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
