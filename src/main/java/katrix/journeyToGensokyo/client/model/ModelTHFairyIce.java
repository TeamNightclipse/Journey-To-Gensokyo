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
import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityTHFairy;

/**
 * ModelTHFairyIce - Katrix Created using Tabula 4.1.1
 */

@SideOnly(Side.CLIENT)
public class ModelTHFairyIce extends ModelBase {

	public ModelRenderer skirt;
	public ModelRenderer leftWing;
	public ModelRenderer body;
	public ModelRenderer leftWing2;
	public ModelRenderer rightArm;
	public ModelRenderer rightLeg;
	public ModelRenderer rightWing;
	public ModelRenderer leftArm;
	public ModelRenderer rightWing2;
	public ModelRenderer leftLeg;
	public ModelRenderer head;
	public ModelRenderer snowflake;
	public ModelRenderer longHair;
	public ModelRenderer ribbonCenter;
	public ModelRenderer ribbonRight;
	public ModelRenderer ribbonLeft;
	public ModelRenderer flowerCenter;
	public ModelRenderer flower1;
	public ModelRenderer flower2;
	public ModelRenderer flower3;
	public ModelRenderer flower4;
	public ModelRenderer snowflake0Deg;
	public ModelRenderer snowflake60Deg;
	public ModelRenderer snowflake120Deg;
	public ModelRenderer snowflake180Deg;
	public ModelRenderer snowflake240Deg;
	public ModelRenderer snowflake300Deg;
	public ModelRenderer snowflake0DegTip45Deg;
	public ModelRenderer snowflake0DegTip45Deg_1;
	public ModelRenderer snowflake60DegTip45Deg;
	public ModelRenderer snowflake60DegTip45Deg_1;
	public ModelRenderer snowflake120DegTip45Deg;
	public ModelRenderer snowflake120DegTip45Deg_1;
	public ModelRenderer snowflake180DegTip45Deg;
	public ModelRenderer snowflake180DegTip45Deg_1;
	public ModelRenderer snowflake240DegTip45Deg;
	public ModelRenderer snowflake240DegTip45Deg_1;
	public ModelRenderer snowflake300DegTip45Deg;
	public ModelRenderer snowflake300DegTip45Deg_1;

	public ModelTHFairyIce() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 7.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		rightLeg = new ModelRenderer(this, 32, 19);
		rightLeg.setRotationPoint(-2.0F, 14.0F, 0.0F);
		rightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
		snowflake60Deg = new ModelRenderer(this, 60, 48);
		snowflake60Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake60Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		setRotateAngle(snowflake60Deg, 0.0F, 0.0F, 1.0471975511965976F);
		snowflake60DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake60DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake60DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake60DegTip45Deg_1, 0.0F, 0.0F, 0.7853981633974483F);
		leftArm = new ModelRenderer(this, 56, 0);
		leftArm.setRotationPoint(4.0F, 8.0F, 0.0F);
		leftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotateAngle(leftArm, -0.699999988079071F, 0.0F, 0.6457718014717102F);
		flower3 = new ModelRenderer(this, 24, 32);
		flower3.setRotationPoint(3.0F, -8.0F, -5.0F);
		flower3.addBox(-1.0F, -2.0F, 0.0F, 2, 1, 1, 0.0F);
		setRotateAngle(flower3, -0.3490658503988659F, 0.0F, 0.0F);
		snowflake300DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake300DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake300DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake300DegTip45Deg, 0.0F, 0.0F, 0.7853981633974483F);
		snowflake120DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake120DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake120DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake120DegTip45Deg_1, 0.0F, 0.0F, -0.7853981633974483F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.setRotationPoint(0.0F, 7.0F, 4.0F);
		longHair.addBox(-4.0F, -7.0F, -3.0F, 8, 5, 3, 0.0F);
		snowflake300DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake300DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake300DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake300DegTip45Deg_1, 0.0F, 0.0F, -0.7853981633974483F);
		snowflake60DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake60DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake60DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake60DegTip45Deg, 0.0F, 0.0F, -0.7853981633974483F);
		snowflake0DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake0DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake0DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake0DegTip45Deg_1, 0.0F, 0.0F, 0.7853981633974483F);
		leftWing2 = new ModelRenderer(this, 0, 48);
		leftWing2.setRotationPoint(1.0F, 7.0F, 2.0F);
		leftWing2.addBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
		setRotateAngle(leftWing2, 0.0F, -0.7853981852531433F, 0.3141593039035797F);
		ribbonRight = new ModelRenderer(this, 6, 32);
		ribbonRight.setRotationPoint(1.0F, -8.0F, 4.0F);
		ribbonRight.addBox(0.0F, -2.0F, 0.0F, 5, 4, 1, 0.0F);
		snowflake240DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake240DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake240DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake240DegTip45Deg, 0.0F, 0.0F, 0.7853981633974483F);
		snowflake180DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake180DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake180DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake180DegTip45Deg_1, 0.0F, 0.0F, -0.7853981633974483F);
		rightWing = new ModelRenderer(this, 0, 48);
		rightWing.setRotationPoint(0.0F, 4.0F, 2.0F);
		rightWing.addBox(-14.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
		setRotateAngle(rightWing, 0.0F, 0.7853981852531433F, 0.3141593039035797F);
		skirt = new ModelRenderer(this, 0, 16);
		skirt.setRotationPoint(0.0F, 12.0F, 0.0F);
		skirt.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F);
		setRotateAngle(skirt, 0.0F, -4.4567208585665846E-17F, 0.0F);
		snowflake180Deg = new ModelRenderer(this, 60, 48);
		snowflake180Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake180Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		setRotateAngle(snowflake180Deg, 0.0F, 0.0F, 3.141592653589793F);
		flowerCenter = new ModelRenderer(this, 18, 32);
		flowerCenter.setRotationPoint(3.0F, -8.0F, -4.0F);
		flowerCenter.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1, 0.0F);
		setRotateAngle(flowerCenter, -0.3490658503988659F, 0.0F, 0.0F);
		snowflake240DegTip45Deg_1 = new ModelRenderer(this, 60, 48);
		snowflake240DegTip45Deg_1.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake240DegTip45Deg_1.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake240DegTip45Deg_1, 0.0F, 0.0F, -0.7853981633974483F);
		leftWing = new ModelRenderer(this, 0, 48);
		leftWing.setRotationPoint(0.0F, 4.0F, 2.0F);
		leftWing.addBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
		setRotateAngle(leftWing, 0.0F, -0.7853981852531433F, -0.3141593039035797F);
		snowflake120Deg = new ModelRenderer(this, 60, 48);
		snowflake120Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake120Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		setRotateAngle(snowflake120Deg, 0.0F, 0.0F, 2.0943951023931953F);
		snowflake0DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake0DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake0DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake0DegTip45Deg, 0.0F, 0.0F, -0.7853981633974483F);
		flower1 = new ModelRenderer(this, 24, 32);
		flower1.setRotationPoint(3.0F, -8.0F, -4.0F);
		flower1.addBox(1.0F, -1.0F, -1.0F, 1, 2, 1, 0.0F);
		setRotateAngle(flower1, -0.3490658503988659F, 0.0F, 0.0F);
		ribbonLeft = new ModelRenderer(this, 6, 32);
		ribbonLeft.setRotationPoint(-1.0F, -8.0F, 4.0F);
		ribbonLeft.addBox(-5.0F, -2.0F, 0.0F, 5, 4, 1, 0.0F);
		snowflake300Deg = new ModelRenderer(this, 60, 48);
		snowflake300Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake300Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		setRotateAngle(snowflake300Deg, 0.0F, 0.0F, 5.235987755982989F);
		snowflake = new ModelRenderer(this, 0, 0);
		snowflake.setRotationPoint(0.0F, 7.0F, 5.0F);
		snowflake.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, -0.5F);
		flower4 = new ModelRenderer(this, 24, 32);
		flower4.setRotationPoint(3.0F, -8.0F, -4.0F);
		flower4.addBox(-1.0F, 1.0F, -1.0F, 2, 1, 1, 0.0F);
		setRotateAngle(flower4, -0.3490658503988659F, 0.0F, 0.0F);
		snowflake120DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake120DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake120DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake120DegTip45Deg, 0.0F, 0.0F, 0.7853981633974483F);
		ribbonCenter = new ModelRenderer(this, 0, 32);
		ribbonCenter.setRotationPoint(0.0F, -8.0F, 4.0F);
		ribbonCenter.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F);
		setRotateAngle(ribbonCenter, 0.24434609527920614F, 0.0F, 0.0F);
		rightArm = new ModelRenderer(this, 48, 0);
		rightArm.setRotationPoint(-4.0F, 8.0F, 0.0F);
		rightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotateAngle(rightArm, -0.699999988079071F, 0.0F, -0.6457718014717102F);
		body = new ModelRenderer(this, 32, 8);
		body.setRotationPoint(0.0F, 7.0F, 0.0F);
		body.addBox(-3.0F, 0.0F, -2.0F, 6, 7, 4, 0.0F);
		leftLeg = new ModelRenderer(this, 32, 19);
		leftLeg.setRotationPoint(2.0F, 14.0F, 0.0F);
		leftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
		rightWing2 = new ModelRenderer(this, 0, 48);
		rightWing2.setRotationPoint(-1.0F, 7.0F, 2.0F);
		rightWing2.addBox(-14.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F);
		setRotateAngle(rightWing2, 0.0F, 0.7853981852531433F, -0.3141593039035797F);
		snowflake180DegTip45Deg = new ModelRenderer(this, 60, 48);
		snowflake180DegTip45Deg.setRotationPoint(0.0F, 8.0F, 0.0F);
		snowflake180DegTip45Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(snowflake180DegTip45Deg, 0.0F, 0.0F, 0.7853981633974483F);
		snowflake0Deg = new ModelRenderer(this, 60, 48);
		snowflake0Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake0Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		snowflake240Deg = new ModelRenderer(this, 60, 48);
		snowflake240Deg.setRotationPoint(0.0F, 0.0F, 0.0F);
		snowflake240Deg.addBox(-0.5F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
		setRotateAngle(snowflake240Deg, 0.0F, 0.0F, 4.1887902047863905F);
		flower2 = new ModelRenderer(this, 24, 32);
		flower2.setRotationPoint(3.0F, -8.0F, -4.0F);
		flower2.addBox(-2.0F, -1.0F, -1.0F, 1, 2, 1, 0.0F);
		setRotateAngle(flower2, -0.3490658503988659F, 0.0F, 0.0F);
		snowflake.addChild(snowflake60Deg);
		snowflake60Deg.addChild(snowflake60DegTip45Deg_1);
		head.addChild(flower3);
		snowflake300Deg.addChild(snowflake300DegTip45Deg);
		snowflake120Deg.addChild(snowflake120DegTip45Deg_1);
		head.addChild(longHair);
		snowflake300Deg.addChild(snowflake300DegTip45Deg_1);
		snowflake60Deg.addChild(snowflake60DegTip45Deg);
		snowflake0Deg.addChild(snowflake0DegTip45Deg_1);
		head.addChild(ribbonRight);
		snowflake240Deg.addChild(snowflake240DegTip45Deg);
		snowflake180Deg.addChild(snowflake180DegTip45Deg_1);
		snowflake.addChild(snowflake180Deg);
		head.addChild(flowerCenter);
		snowflake240Deg.addChild(snowflake240DegTip45Deg_1);
		snowflake.addChild(snowflake120Deg);
		snowflake0Deg.addChild(snowflake0DegTip45Deg);
		head.addChild(flower1);
		head.addChild(ribbonLeft);
		snowflake.addChild(snowflake300Deg);
		head.addChild(flower4);
		snowflake120Deg.addChild(snowflake120DegTip45Deg);
		head.addChild(ribbonCenter);
		snowflake180Deg.addChild(snowflake180DegTip45Deg);
		snowflake.addChild(snowflake0Deg);
		snowflake.addChild(snowflake240Deg);
		head.addChild(flower2);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {

		super.render(entity, movement, far, tick, yaw, pitch, size);
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

		head.render(size);
		rightLeg.render(size);
		leftArm.render(size);
		leftWing2.render(size);
		rightWing.render(size);
		skirt.render(size);
		leftWing.render(size);
		snowflake.render(size);
		rightArm.render(size);
		body.render(size);
		leftLeg.render(size);
		rightWing2.render(size);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		EntityTHFairy thFairy = (EntityTHFairy)entity;

		head.rotateAngleY = (float)(yaw / (180F / Math.PI));
		head.rotateAngleX = (float)(pitch / (180F / Math.PI));
		body.rotateAngleY = (float)(MathHelperJTG.sin(MathHelper.sqrt_float(onGround) * (float)Math.PI * 2.0F) * 0.2F);
		skirt.rotateAngleX = 0F;

		if (isRiding) {
			rightArm.rotateAngleX = (float)-(Math.PI / 5F);
			leftArm.rotateAngleX = (float)-(Math.PI / 5F);
			rightLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			leftLeg.rotateAngleX = (float)-(Math.PI * 2F / 5F);
			rightLeg.rotateAngleY = (float)(Math.PI / 14F);
			leftLeg.rotateAngleY = (float)-(Math.PI / 14F);
			rightLeg.rotateAngleZ = (float)(Math.PI / 14F);
			leftLeg.rotateAngleZ = (float)-(Math.PI / 14F);

			skirt.rotateAngleX += -(Math.PI / 5F);
		}
		else {

			if (thFairy.getFlyingHeight() == 0) {
				rightLeg.rotateAngleX = (float)(MathHelperJTG.cos(movement) * 0.7F * far);
				leftLeg.rotateAngleX = (float)(MathHelperJTG.cos(movement + Math.PI) * 0.7F * far);
				rightLeg.rotateAngleZ = 0F;
				leftLeg.rotateAngleZ = 0F;

				if (movement > 0F) {
					rightArm.rotateAngleX = (float)(MathHelperJTG.cos(movement + Math.PI) * 2.0F * far * 0.5F);
					leftArm.rotateAngleX = (float)(MathHelperJTG.cos(movement) * 2.0F * far * 0.5F);
					rightArm.rotateAngleY = (float)(-10F / 180F * Math.PI);
					rightArm.rotateAngleZ = (float)(20F / 180F * Math.PI);
					leftArm.rotateAngleY = -rightArm.rotateAngleY;
					leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
				}
				else {
					rightArm.rotateAngleX = (float)(-0.7F - MathHelperJTG.sin(tick / 10F) * 0.1F);
					rightArm.rotateAngleY = 0.0F;
					rightArm.rotateAngleZ = -0.6457718F;
					leftArm.rotateAngleX = rightArm.rotateAngleX;
					leftArm.rotateAngleY = 0.0F;
					leftArm.rotateAngleZ = 0.6457718F;

				}
			}
			else {

				rightLeg.rotateAngleZ = (float)Math.abs(MathHelperJTG.sin(tick / 10F) * 0.1F);
				leftLeg.rotateAngleZ = -rightLeg.rotateAngleZ;
				rightLeg.rotateAngleX = (float)Math.abs(MathHelperJTG.sin(tick / 10F) * 0.2F);
				leftLeg.rotateAngleX = rightLeg.rotateAngleZ;

				rightArm.rotateAngleX = (float)(-0.7F - MathHelperJTG.sin(tick / 10F) * 0.1F);
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
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 1.3F) * Math.PI * 0.25F);
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
				rightWing2.rotateAngleY = (float)(MathHelperJTG.cos(tick * 1.3F) * Math.PI * 0.25F);
				leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
			}
			else {
				rightWing.rotateAngleY = (float)(MathHelperJTG.cos(tick * 0.5F) * Math.PI * 0.1F + Math.PI * 0.15F);
				leftWing.rotateAngleY = -rightWing.rotateAngleY;
				rightWing2.rotateAngleY = (float)(MathHelperJTG.cos(tick * 0.5F) * Math.PI * 0.1F + Math.PI * 0.15F);
				leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
			}
		}
		else {
			setRotateAngle(head, 70F, 0F, 0F);
			rightWing.rotateAngleY = -25F;
			leftWing.rotateAngleY = -rightWing.rotateAngleY;
			rightWing2.rotateAngleY = -25F;
			leftWing2.rotateAngleY = -rightWing2.rotateAngleY;
		}
	}
}
