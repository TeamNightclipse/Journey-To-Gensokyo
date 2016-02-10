package katrix.journeyToGensokyo.client.model;

import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thKaguyaMod.entity.living.EntityDanmakuMob;

public class ModelSeija extends ModelBase {
    public ModelRenderer bipedBody;
    public ModelRenderer skirtTop;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer skirtBottom;
    public ModelRenderer longHair;
    public ModelRenderer rightHorn;
    public ModelRenderer leftHorn;
    public ModelRenderer redBraid;
    public ModelRenderer rightHair;
    public ModelRenderer leftHair;

    public ModelSeija() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bipedRightLeg = new ModelRenderer(this, 50, 18);
        this.bipedRightLeg.setRotationPoint(-2.0F, 11.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
        this.skirtTop = new ModelRenderer(this, 0, 16);
        this.skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 3, 8, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 2.0F, 0.009999999776482582F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 48, 0);
        this.bipedLeftArm.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 50, 18);
        this.bipedLeftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
        this.bipedBody = new ModelRenderer(this, 32, 8);
        this.bipedBody.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 48, 0);
        this.bipedRightArm.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
        this.rightHorn = new ModelRenderer(this, 0, 16);
        this.rightHorn.setRotationPoint(-3.0F, -8.0F, -3.5F);
        this.rightHorn.addBox(-1.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rightHorn, 0.7853981633974483F, 0.7853981633974483F, 0.0F);
        this.leftHair = new ModelRenderer(this, 22, 54);
        this.leftHair.setRotationPoint(4.0F, -4.0F, -0.01F);
        this.leftHair.addBox(-4.0F, 0.0F, 0.0F, 8, 5, 3, 0.0F);
        this.setRotateAngle(leftHair, -0.14870205226991687F, -1.5707963267948966F, 0.0F);
        this.skirtBottom = new ModelRenderer(this, 16, 32);
        this.skirtBottom.setRotationPoint(0.0F, 3.0F, 4.0F);
        this.skirtBottom.addBox(-5.0F, 0.0F, -9.0F, 10, 6, 10, 0.0F);
        this.rightHair = new ModelRenderer(this, 0, 54);
        this.rightHair.setRotationPoint(-4.0F, -4.0F, -0.01F);
        this.rightHair.addBox(-4.0F, 0.0F, -3.0F, 8, 5, 3, 0.0F);
        this.setRotateAngle(rightHair, 0.14870205226991687F, -1.5707963267948966F, 0.0F);
        this.longHair = new ModelRenderer(this, 0, 48);
        this.longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 2, 3, 0.0F);
        this.leftHorn = new ModelRenderer(this, 0, 16);
        this.leftHorn.setRotationPoint(4.0F, -8.0F, -3.0F);
        this.leftHorn.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leftHorn, 0.7853981633974483F, 2.356194490192345F, 0.0F);
        this.redBraid = new ModelRenderer(this, 0, 31);
        this.redBraid.setRotationPoint(0.0F, -8.0F, -4.0F);
        this.redBraid.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(redBraid, -0.2815216083466853F, 0.0F, -0.18587756533739608F);
        this.bipedBody.addChild(this.bipedRightLeg);
        this.bipedBody.addChild(this.skirtTop);
        this.bipedBody.addChild(this.bipedHead);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedBody.addChild(this.bipedLeftLeg);
        this.bipedBody.addChild(this.bipedRightArm);
        this.bipedHead.addChild(this.rightHorn);
        this.bipedHead.addChild(this.leftHair);
        this.skirtTop.addChild(this.skirtBottom);
        this.bipedHead.addChild(this.rightHair);
        this.bipedHead.addChild(this.longHair);
        this.bipedHead.addChild(this.leftHorn);
        this.bipedHead.addChild(this.redBraid);
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
