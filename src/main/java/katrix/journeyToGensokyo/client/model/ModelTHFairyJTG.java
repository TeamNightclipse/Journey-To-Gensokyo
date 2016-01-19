/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityTHFairy;

@SideOnly(Side.CLIENT)
public class ModelTHFairyJTG extends ModelBase {

	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightArm;
	ModelRenderer rightLeg;
	ModelRenderer leftArm;
	ModelRenderer leftLeg;
	ModelRenderer skirt;
	ModelRenderer ribbonCenter;
	ModelRenderer longHair;
	ModelRenderer ribbonLeft;
	ModelRenderer ribbonRight;
	ModelRenderer rightWing;
	ModelRenderer rightWing2;
	ModelRenderer leftWing;
	ModelRenderer leftWing2;
	ModelRenderer flowerCenter;
	ModelRenderer flower1;
	ModelRenderer flower2;
	ModelRenderer flower3;
	ModelRenderer flower4;

	public ModelTHFairyJTG() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 7F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		longHair = new ModelRenderer(this, 24, 0);
		longHair.addBox(-4F, -7F, -3F, 8, 5, 3);
		longHair.setRotationPoint(0F, 7F, 4F);
		head.addChild(longHair);
		//リボン
		ribbonCenter = new ModelRenderer(this, 0, 32);
		ribbonCenter.addBox(-1F, -1F, 0F, 2, 2, 1);
		ribbonCenter.setRotationPoint(0F, -8F, 4F);
		head.addChild(ribbonCenter);
		setRotation(ribbonCenter, 0.2443461F, 0F, 0F);
		ribbonLeft = new ModelRenderer(this, 6, 32);
		ribbonLeft.addBox(0F, -2F, 0F, 5, 4, 1);
		ribbonLeft.setRotationPoint(1F, -8F, 4F);
		ribbonLeft.mirror = true;
		head.addChild(ribbonLeft);
		//setRotation(ribbonLeft, 0.418879F, 0F, 0F);
		ribbonRight = new ModelRenderer(this, 6, 32);
		ribbonRight.addBox(-5F, -2F, 0F, 5, 4, 1);
		ribbonRight.setRotationPoint(-1F, -8F, 4F);
		ribbonRight.mirror = true;
		head.addChild(ribbonRight);

		flowerCenter = new ModelRenderer(this, 18, 32);
		flowerCenter.addBox(-1F, -1F, -1F, 2, 2, 1);
		flowerCenter.setRotationPoint(3F, -8F, -4F);
		flowerCenter.setTextureSize(64, 64);
		flowerCenter.mirror = true;
		setRotation(flowerCenter, -0.3490659F, 0F, 0F);
		head.addChild(flowerCenter);
		flower1 = new ModelRenderer(this, 24, 32);
		flower1.addBox(1F, -1F, -1F, 1, 2, 1);
		flower1.setRotationPoint(3F, -8F, -4F);
		flower1.setTextureSize(64, 64);
		flower1.mirror = true;
		setRotation(flower1, -0.3490659F, 0F, 0F);
		head.addChild(flower1);
		flower2 = new ModelRenderer(this, 24, 32);
		flower2.addBox(-2F, -1F, -1F, 1, 2, 1);
		flower2.setRotationPoint(3F, -8F, -4F);
		flower2.setTextureSize(64, 64);
		flower2.mirror = true;
		setRotation(flower2, -0.3490659F, 0F, 0F);
		head.addChild(flower2);
		flower3 = new ModelRenderer(this, 24, 32);
		flower3.addBox(-1F, -2F, 0F, 2, 1, 1);
		flower3.setRotationPoint(3F, -8F, -5F);
		flower3.setTextureSize(64, 64);
		flower3.mirror = true;
		setRotation(flower3, -0.3490659F, 0F, 0F);
		head.addChild(flower3);
		flower4 = new ModelRenderer(this, 24, 32);
		flower4.addBox(-1F, 1F, -1F, 2, 1, 1);
		flower4.setRotationPoint(3F, -8F, -4F);
		flower4.setTextureSize(64, 64);
		flower4.mirror = true;
		setRotation(flower4, -0.3490659F, 0F, 0F);
		head.addChild(flower4);

		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 32, 8);
		body.addBox(-3F, 0F, -2F, 6, 7, 4);
		body.setRotationPoint(0F, 7F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightArm = new ModelRenderer(this, 48, 0);
		rightArm.addBox(-1F, -1F, -1F, 2, 8, 2);
		rightArm.setRotationPoint(-4F, 8F, 0F);
		rightArm.setTextureSize(64, 64);
		rightArm.mirror = true;
		setRotation(rightArm, -0.7679449F, 0F, -0.6457718F);
		rightLeg = new ModelRenderer(this, 32, 19);
		rightLeg.addBox(-1F, 0F, -2F, 3, 9, 4);
		rightLeg.setRotationPoint(-2F, 14F, 0F);
		rightLeg.setTextureSize(64, 64);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0F, 0F, 0F);
		leftArm = new ModelRenderer(this, 56, 0);
		leftArm.addBox(-1F, -1F, -1F, 2, 8, 2);
		leftArm.setRotationPoint(4F, 8F, 0F);
		leftArm.setTextureSize(64, 64);
		leftArm.mirror = true;
		setRotation(leftArm, -0.7679449F, 0F, 0.6457718F);
		leftLeg = new ModelRenderer(this, 32, 19);
		leftLeg.addBox(-2F, 0F, -2F, 3, 9, 4);
		leftLeg.setRotationPoint(2F, 14F, 0F);
		leftLeg.setTextureSize(64, 64);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0F, 0F, 0F);
		skirt = new ModelRenderer(this, 0, 16);
		skirt.addBox(-4F, 0F, -4F, 8, 8, 8);
		skirt.setRotationPoint(0F, 12F, 0F);
		skirt.setTextureSize(64, 64);
		skirt.mirror = true;
		setRotation(skirt, 0F, 0F, 0F);

		rightWing2 = new ModelRenderer(this, 0, 48);
		rightWing2.addBox(-14F, 0F, 0F, 14, 10, 1);
		rightWing2.setRotationPoint(-1F, 7F, 2F);
		rightWing2.setTextureSize(64, 64);
		rightWing2.mirror = true;
		setRotation(rightWing2, 0F, 0.4886922F, -0.3141593F);
		rightWing2.mirror = false;
		leftWing = new ModelRenderer(this, 0, 48);
		leftWing.addBox(0F, 0F, 0F, 14, 10, 1);
		leftWing.setRotationPoint(0F, 4F, 2F);
		leftWing.setTextureSize(64, 64);
		leftWing.mirror = true;
		setRotation(leftWing, 0F, -0.4886922F, -0.3141593F);
		leftWing2 = new ModelRenderer(this, 0, 48);
		leftWing2.addBox(0F, 0F, 0F, 14, 10, 1);
		leftWing2.setRotationPoint(1F, 7F, 2F);
		leftWing2.setTextureSize(64, 64);
		leftWing2.mirror = true;
		setRotation(leftWing2, 0F, -0.4886922F, 0.3141593F);
		//rightWing.mirror = true;
		rightWing = new ModelRenderer(this, 0, 48);
		rightWing.addBox(-14F, 0F, 0F, 14, 10, 1);
		rightWing.setRotationPoint(0F, 4F, 2F);
		rightWing.setTextureSize(64, 64);
		rightWing.mirror = true;
		setRotation(rightWing, 0F, 0.4886922F, 0.3141593F);
		//rightWing.mirror = false;
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		super.render(entity, movement, far, tick, yaw, pitch, size);
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

		head.render(size);
		body.render(size);
		rightArm.render(size);
		rightLeg.render(size);
		leftArm.render(size);
		leftLeg.render(size);
		skirt.render(size);

		rightWing.render(size);
		rightWing2.render(size);
		leftWing.render(size);
		leftWing2.render(size);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		EntityTHFairy thFairy = (EntityTHFairy)entity;

		head.rotateAngleY = yaw / (180F / (float)Math.PI);
		head.rotateAngleX = pitch / (180F / (float)Math.PI);
		body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(onGround) * (float)Math.PI * 2.0F) * 0.2F;
		skirt.rotateAngleX = 0F;

		if (isRiding) {
			rightArm.rotateAngleX = -((float)Math.PI / 5F);
			leftArm.rotateAngleX = -((float)Math.PI / 5F);
			rightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			leftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			rightLeg.rotateAngleY = (float)Math.PI / 14F;
			leftLeg.rotateAngleY = -((float)Math.PI / 14F);
			rightLeg.rotateAngleZ = (float)Math.PI / 14F;
			leftLeg.rotateAngleZ = -((float)Math.PI / 14F);

			skirt.rotateAngleX += -((float)Math.PI / 5F);
		}
		else {

			if (thFairy.getFlyingHeight() == 0) {
				rightLeg.rotateAngleX = MathHelper.cos(movement) * 0.7F * far;
				leftLeg.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 0.7F * far;
				rightLeg.rotateAngleZ = 0F;
				leftLeg.rotateAngleZ = 0F;

				if (movement > 0F) {
					rightArm.rotateAngleX = MathHelper.cos(movement + (float)Math.PI) * 2.0F * far * 0.5F;
					leftArm.rotateAngleX = MathHelper.cos(movement) * 2.0F * far * 0.5F;
					rightArm.rotateAngleY = -10F / 180F * (float)Math.PI;
					rightArm.rotateAngleZ = 20F / 180F * (float)Math.PI;
					leftArm.rotateAngleY = -rightArm.rotateAngleY;
					leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
				}
				else {
					rightArm.rotateAngleX = -0.7F - MathHelper.sin(tick / 10F) * 0.1F;
					rightArm.rotateAngleY = 0.0F;
					rightArm.rotateAngleZ = -0.6457718F;
					leftArm.rotateAngleX = rightArm.rotateAngleX;
					leftArm.rotateAngleY = 0.0F;
					leftArm.rotateAngleZ = 0.6457718F;

				}
			}
			else {

				rightLeg.rotateAngleZ = Math.abs(MathHelper.sin(tick / 10F) * 0.1F);
				leftLeg.rotateAngleZ = -rightLeg.rotateAngleZ;
				rightLeg.rotateAngleX = Math.abs(MathHelper.sin(tick / 10F) * 0.2F);
				leftLeg.rotateAngleX = rightLeg.rotateAngleZ;

				rightArm.rotateAngleX = -0.7F - MathHelper.sin(tick / 10F) * 0.1F;
				rightArm.rotateAngleY = 0.0F;
				rightArm.rotateAngleZ = -0.6457718F;
				leftArm.rotateAngleX = rightArm.rotateAngleX;
				leftArm.rotateAngleY = 0.0F;
				leftArm.rotateAngleZ = 0.6457718F;
			}
		}



		if (thFairy.getHealth() > 0F) {
			body.rotateAngleX = 0F;
			if (thFairy.getFlyingHeight() > 0) {
				rightWing.rotateAngleY = MathHelper.cos(tick * 1.3F) * (float)Math.PI * 0.25F;
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
				rightWing2.rotateAngleY = MathHelper.cos(tick * 1.3F) * (float)Math.PI * 0.25F;
				leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
			}
			else {
				rightWing.rotateAngleY = MathHelper.cos(tick * 0.5F) * (float)Math.PI * 0.1F + (float)Math.PI * 0.15F;
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
				rightWing2.rotateAngleY = MathHelper.cos(tick * 0.5F) * (float)Math.PI * 0.1F + (float)Math.PI * 0.15F;
				leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
			}
		}
		else {
			setRotation(head, 70F, 0F, 0F);
			rightWing.rotateAngleY = -25F;
			leftWing.rotateAngleY = -rightWing.rotateAngleY;
			rightWing2.rotateAngleY = -25F;
			leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
			//this.head.rotateAngleX = MathHelper.cos(tick * 1.3F) * (float)Math.PI * 0.25F;
		}
	}

}
