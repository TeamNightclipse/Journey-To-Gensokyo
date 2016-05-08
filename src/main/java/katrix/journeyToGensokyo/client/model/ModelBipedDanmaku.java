/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

public class ModelBipedDanmaku extends ModelBase {

	public ModelRenderer bipedBody;
	public ModelRenderer skirtTop;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer skirtBottom;
	public ModelRenderer longHair;
	public ModelRenderer rightRibbon;
	public ModelRenderer leftRibbon;

	public void setChild() {
		if(bipedBody != null && bipedHead != null) bipedBody.addChild(bipedHead);
		if(bipedBody != null && bipedLeftLeg != null) bipedBody.addChild(bipedLeftLeg);
		if(bipedBody != null && bipedRightLeg != null) bipedBody.addChild(bipedRightLeg);
		if(bipedBody != null && bipedLeftArm != null) bipedBody.addChild(bipedLeftArm);
		if(bipedBody != null && bipedRightArm != null) bipedBody.addChild(bipedRightArm);
		if(bipedBody != null && skirtTop != null) bipedBody.addChild(skirtTop);
		if(skirtTop  != null && skirtBottom != null) skirtTop.addChild(skirtBottom);
		if(bipedHead != null && longHair != null) bipedHead.addChild(longHair);
		if(bipedHead != null && leftRibbon != null) bipedHead.addChild(leftRibbon);
		if(bipedHead != null && rightRibbon != null) bipedHead.addChild(rightRibbon);
	}
	
	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		bipedBody.render(size);
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		EntityDanmakuMob danmakuMob = (EntityDanmakuMob)entity;
		float rad30F = (float)Math.toRadians(30F);
		float cosMovTimes0_66 = MathHelper.cos(movement * 0.6662F);
		float cosMovTimes0_66PlusPi = MathHelper.cos((float)(movement * 0.6662F + Math.PI));
		float sinTickDiv10F = MathHelper.sin(tick / 10F);

		bipedHead.rotateAngleY = (float)(yaw / (180F / Math.PI));
		bipedHead.rotateAngleX = (float)(pitch / (180F / Math.PI));
		bipedBody.rotateAngleY = MathHelper.sin((float)(MathHelper.sqrt_float(onGround) * Math.PI * 2.0F)) * 0.2F;

		bipedRightArm.rotateAngleX = cosMovTimes0_66PlusPi * 2.0F * far * 0.5F;
		bipedLeftArm.rotateAngleX = cosMovTimes0_66 * 2.0F * far * 0.5F;
		bipedRightArm.rotateAngleZ = rad30F;
		bipedLeftArm.rotateAngleZ = -rad30F;

		skirtTop.rotateAngleX = 0F;

		if (danmakuMob.isSneaking()) {
			bipedBody.rotateAngleY = cosMovTimes0_66PlusPi * 2.4F * far;
			skirtTop.rotateAngleY = cosMovTimes0_66PlusPi * 2.4F * far;
			bipedRightArm.rotateAngleX = cosMovTimes0_66PlusPi * 1.4F * far;
			bipedLeftArm.rotateAngleX = cosMovTimes0_66 * 1.4F * far;
			bipedHead.rotateAngleX -= 0.5F;
		}

		else if (danmakuMob.isRiding()) {

			float piDiv5 = (float)(Math.PI / 5F);
			float piDiv14 = (float)(Math.PI / 14F);
			float piDiv4 = (float)(Math.PI / 4F);
			float tauDiv5 = (float)(Math.PI * 2F / 5F);

			bipedRightArm.rotateAngleX += -piDiv5;
			bipedLeftArm.rotateAngleX += -piDiv5;
			bipedRightLeg.rotateAngleX = -tauDiv5;
			bipedLeftLeg.rotateAngleX = -tauDiv5;
			bipedRightLeg.rotateAngleY = piDiv14;
			bipedLeftLeg.rotateAngleY = -piDiv14;
			bipedRightLeg.rotateAngleZ = piDiv14;
			bipedLeftLeg.rotateAngleZ = -piDiv14;
			skirtTop.rotateAngleX = -piDiv5;
			skirtBottom.rotateAngleX = -piDiv4;
		}

		else {

			if (danmakuMob.getFlyingHeight() == 0) {
				float cosMovement = MathHelper.cos(movement);
				float cosMovementPlussPi = MathHelper.cos((float)(movement + Math.PI));

				bipedRightLeg.rotateAngleX = cosMovement * 0.7F * far;
				bipedLeftLeg.rotateAngleX = cosMovementPlussPi * 0.7F * far;
				bipedRightLeg.rotateAngleZ = 0F;
				bipedLeftLeg.rotateAngleZ = 0F;

				if (movement > 0F) {
					bipedRightArm.rotateAngleX = cosMovementPlussPi * 2.0F * far * 0.5F;
					bipedLeftArm.rotateAngleX = cosMovement * 2.0F * far * 0.5F;
					bipedRightArm.rotateAngleY = (float)Math.toRadians(-10F);
					bipedRightArm.rotateAngleZ = (float)Math.toRadians(20F);
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

				bipedRightLeg.rotateAngleZ = Math.abs(sinTickDiv10F * 0.1F);
				bipedLeftLeg.rotateAngleZ = -bipedRightLeg.rotateAngleZ;
				bipedRightLeg.rotateAngleX = Math.abs(sinTickDiv10F * 0.2F);
				bipedLeftLeg.rotateAngleX = bipedRightLeg.rotateAngleZ;

				bipedRightArm.rotateAngleX = -0.7F - sinTickDiv10F * 0.1F;
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
