/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityTHFairy;

public class ModelSunFlowerFairyJTG extends ModelBase {

	ModelRenderer bipedBody;
	ModelRenderer bipedRightArm;
	ModelRenderer bipedLeftArm;
	ModelRenderer bipedRightLeg;
	ModelRenderer bipedLeftLeg;
	ModelRenderer skirtTop;
	ModelRenderer skirtBottom;
	ModelRenderer leftWing;
	ModelRenderer rightWing;
	ModelRenderer himawari1;
	ModelRenderer himawari2;
	ModelRenderer bipedHead;
	ModelRenderer longHair;
	ModelRenderer rightRibbon;
	ModelRenderer rightTail;
	ModelRenderer leftRibbon;
	ModelRenderer leftTail;

	public ModelSunFlowerFairyJTG() {
		textureWidth = 128;
		textureHeight = 64;

		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3F, 0F, -2F, 6, 7, 4);
		bipedBody.setRotationPoint(0F, 5F, 0F);
		bipedBody.setTextureSize(128, 64);
		setRotation(bipedBody, 0F, 0F, 0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1F, -1F, -1F, 2, 8, 2);
		bipedRightArm.setRotationPoint(-4F, 6F, 0F);
		bipedRightArm.setTextureSize(128, 64);
		setRotation(bipedRightArm, -0.7679449F, 0F, -0.6457718F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1F, -1F, -1F, 2, 8, 2);
		bipedLeftArm.setRotationPoint(4F, 6F, 0F);
		bipedLeftArm.setTextureSize(128, 64);
		setRotation(bipedLeftArm, -0.7679449F, 0F, 0.6457718F);
		bipedRightLeg = new ModelRenderer(this, 50, 16);
		bipedRightLeg.addBox(-1F, 0F, -2F, 3, 11, 4);
		bipedRightLeg.setRotationPoint(-2F, 12F, 0F);
		bipedRightLeg.setTextureSize(128, 64);
		setRotation(bipedRightLeg, 0F, 0F, 0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 16);
		bipedLeftLeg.addBox(-2F, 0F, -2F, 3, 11, 4);
		bipedLeftLeg.setRotationPoint(2F, 12F, 0F);
		bipedLeftLeg.setTextureSize(128, 64);
		setRotation(bipedLeftLeg, 0F, 0F, 0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.addBox(-4F, 5F, -4F, 8, 4, 8);
		skirtTop.setRotationPoint(0F, 0F, 0F);
		skirtTop.setTextureSize(128, 64);
		setRotation(skirtTop, 0F, 0F, 0F);
		skirtBottom = new ModelRenderer(this, 32, 32);
		skirtBottom.addBox(-5F, 0F, -5F, 10, 6, 10);
		skirtBottom.setRotationPoint(0F, 9F, 0F);
		skirtBottom.setTextureSize(128, 64);
		setRotation(skirtBottom, 0F, 0F, 0F);
		leftWing = new ModelRenderer(this, 64, 0);
		leftWing.addBox(-1F, -16F, 0F, 20, 26, 1);
		leftWing.setRotationPoint(2F, 3F, 2F);
		leftWing.setTextureSize(128, 64);
		setRotation(leftWing, 0F, -0.4886922F, 0.0167304F);
		rightWing = new ModelRenderer(this, 72, 32);
		rightWing.addBox(-1F, -16F, 0F, 20, 26, 1);
		rightWing.setRotationPoint(-2F, 3F, 2F);
		rightWing.setTextureSize(128, 64);
		setRotation(rightWing, 0F, -2.6529F, 0.0167304F);
		himawari1 = new ModelRenderer(this, 0, 32);
		himawari1.addBox(-7F, -20F, 0F, 12, 31, 1);
		himawari1.setRotationPoint(0F, 6F, -2F);
		himawari1.setTextureSize(128, 64);
		setRotation(himawari1, 0.4089647F, -0.7435722F, 0.3666439F);
		himawari2 = new ModelRenderer(this, 0, 32);
		himawari2.addBox(-7F, -20F, 0F, 12, 31, 1);
		himawari2.setRotationPoint(-1F, 6F, -2F);
		himawari2.setTextureSize(128, 64);
		setRotation(himawari2, 0.2230717F, -0.669215F, 0.2551081F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		bipedHead.setRotationPoint(0F, 5F, 0F);
		bipedHead.setTextureSize(128, 64);
		setRotation(bipedHead, 0F, 0F, 0F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.addBox(-4F, 4F, -3F, 8, 5, 3);
		longHair.setRotationPoint(0F, -5F, 4F);
		longHair.setTextureSize(128, 64);
		setRotation(longHair, 0F, 0F, 0F);
		rightRibbon = new ModelRenderer(this, 32, 19);
		rightRibbon.addBox(-3F, -2F, -1F, 5, 4, 1);
		rightRibbon.setRotationPoint(-4F, -7F, 0F);
		rightRibbon.setTextureSize(128, 64);
		setRotation(rightRibbon, -0.4712389F, (float)(Math.PI / 2), 0F);
		rightTail = new ModelRenderer(this, 32, 24);
		rightTail.addBox(-2F, -1F, -2F, 3, 8, 2);
		rightTail.setRotationPoint(-5F, -7F, 0F);
		rightTail.setTextureSize(128, 64);
		setRotation(rightTail, -0.2617994F, (float)(Math.PI / 2), 0F);
		leftRibbon = new ModelRenderer(this, 32, 19);
		leftRibbon.addBox(-3F, -2F, 0F, 5, 4, 1);
		leftRibbon.setRotationPoint(4F, -7F, 0F);
		leftRibbon.setTextureSize(128, 64);
		setRotation(leftRibbon, 0.4712389F, (float)(Math.PI / 2), 0F);
		leftTail = new ModelRenderer(this, 32, 24);
		leftTail.addBox(-2F, -1F, 0F, 3, 8, 2);
		leftTail.setRotationPoint(5F, -7F, 0F);
		leftTail.setTextureSize(128, 64);
		setRotation(leftTail, 0.2617994F, (float)(Math.PI / 2), 0F);

		bipedBody.addChild(rightWing);
		bipedBody.addChild(leftWing);
		bipedBody.addChild(skirtTop);
		skirtTop.addChild(skirtBottom);
		bipedLeftArm.addChild(himawari1);
		bipedLeftArm.addChild(himawari2);

		bipedHead.addChild(longHair);
		bipedHead.addChild(rightRibbon);
		bipedHead.addChild(leftRibbon);
		bipedHead.addChild(rightTail);
		bipedHead.addChild(leftTail);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		super.render(entity, movement, far, tick, yaw, pitch, size);
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

		bipedBody.render(size);
		bipedRightArm.render(size);
		bipedLeftArm.render(size);
		bipedRightLeg.render(size);
		bipedLeftLeg.render(size);
		bipedHead.render(size);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		EntityTHFairy thFairy = (EntityTHFairy)entity;

		bipedHead.rotateAngleY = yaw / (180F / (float)Math.PI);
		bipedHead.rotateAngleX = pitch / (180F / (float)Math.PI);
		bipedBody.rotateAngleY = (float)(MathHelperJTG.sin(MathHelper.sqrt_float(onGround) * (float)Math.PI * 2.0F) * 0.2F);
		skirtTop.rotateAngleX = 0F;

		if (isRiding) {
			bipedRightArm.rotateAngleX = (float)-(Math.PI / 5F);
			bipedLeftArm.rotateAngleX = (float)-(Math.PI / 5F);
			bipedRightLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = (float)(Math.PI / 14F);
			bipedLeftLeg.rotateAngleY = (float)-(Math.PI / 14F);
			bipedRightLeg.rotateAngleZ = (float)(Math.PI / 14F);
			bipedLeftLeg.rotateAngleZ = (float)-(Math.PI / 14F);

			skirtTop.rotateAngleX += -(Math.PI / 5F);
		}
		else {

			if (thFairy.getFlyingHeight() == 0) {
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



		if (thFairy.getHealth() > 0F) {
			bipedBody.rotateAngleX = 0F;
			if (thFairy.getFlyingHeight() > 0) {
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 1.3F) * Math.PI * 0.25F - Math.PI);
				leftWing.rotateAngleY = (float)(-MathHelperJTG.cos(tick * 1.3F) * Math.PI * 0.25F);
			}
			else {
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 0.5F) * Math.PI * 0.1F - Math.PI);
				leftWing.rotateAngleY = (float)(-MathHelperJTG.cos(tick * 0.5F) * Math.PI * 0.1F);
			}
		}
		else {
			setRotation(bipedHead, 70F, 0F, 0F);
			rightWing.rotateAngleY = -25F;
			leftWing.rotateAngleY = -rightWing.rotateAngleY;
		}
	}
}
