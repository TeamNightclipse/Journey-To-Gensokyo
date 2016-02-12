/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.client.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelMarisa extends ModelBipedDanmaku {

	ModelRenderer hatBase;
	ModelRenderer hatBase2;
	ModelRenderer hatBase3;
	ModelRenderer hatBase4;
	ModelRenderer brim;
	ModelRenderer ribbonRight;
	ModelRenderer ribbonLeft;

	public ModelMarisa() {
		textureWidth = 128;
		textureHeight = 64;
		skirtBottom = new ModelRenderer(this, 0, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 4.0F);
		skirtBottom.addBox(-5.0F, -1.0F, -9.0F, 10, 5, 10, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 4, 3, 0.0F);
		setRotateAngle(longHair, 0.10471975511965977F, 0.0F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 19);
		bipedLeftLeg.setRotationPoint(2.0F, 9.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 19);
		bipedRightLeg.setRotationPoint(-2.0F, 9.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		leftRibbon = new ModelRenderer(this, 32, 33);
		leftRibbon.setRotationPoint(5.0F, -5.0F, 0.0F);
		leftRibbon.addBox(-1.5F, 0.0F, 0.0F, 3, 8, 1, 0.0F);
		setRotateAngle(leftRibbon, 0.0F, 1.5707963267948966F, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(3.0F, 2.0F, 0.0F);
		bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 9, 2, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-3.0F, 2.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 9, 2, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 7.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		rightRibbon = new ModelRenderer(this, 32, 33);
		rightRibbon.setRotationPoint(-4.0F, -5.0F, 0.0F);
		rightRibbon.addBox(-1.5F, 0.0F, -1.0F, 3, 8, 1, 0.0F);
		setRotateAngle(rightRibbon, 0.0F, 1.5707963267948966F, 0.0F);
		
		hatBase = new ModelRenderer(this, 64, 0);
		hatBase.addBox(-4F, -8F, -4F, 8, 3, 8, 0F);
		hatBase.setRotationPoint(0F, -2F, 0F);
		hatBase.setTextureSize(64, 32);
		hatBase.mirror = true;
		bipedHead.addChild(hatBase);
		setRotateAngle(hatBase, 0F, 0F, 0F);
		hatBase2 = new ModelRenderer(this, 96, 2);
		hatBase2.addBox(-3F, -3F, -3F, 6, 3, 6, 0F);
		hatBase2.setRotationPoint(0F, -7F, 0F);
		hatBase2.setTextureSize(64, 32);
		hatBase2.mirror = true;
		hatBase.addChild(hatBase2);
		setRotateAngle(hatBase2, -0.2792527F, 0F, 0F);
		hatBase3 = new ModelRenderer(this, 112, 16);
		hatBase3.addBox(-2F, -3F, -2F, 4, 3, 4, 0F);
		hatBase3.setRotationPoint(0F, -9F, 0F);
		hatBase3.setTextureSize(64, 32);
		hatBase3.mirror = true;
		hatBase.addChild(hatBase3);
		setRotateAngle(hatBase3, -0.5410521F, 0F, 0F);
		hatBase4 = new ModelRenderer(this, 112, 24);
		hatBase4.addBox(-1F, -3F, -1F, 2, 3, 2, 0F);
		hatBase4.setRotationPoint(0F, -11F, 1F);
		hatBase4.setTextureSize(64, 32);
		hatBase4.mirror = true;
		hatBase.addChild(hatBase4);
		setRotateAngle(hatBase4, -0.8203047F, 0F, 0F);
		brim = new ModelRenderer(this, 64, 16);
		brim.addBox(-6F, 0F, -6F, 12, 1, 12, 0F);
		brim.setRotationPoint(0F, -6F, 0F);
		brim.setTextureSize(64, 32);
		brim.mirror = true;
		hatBase.addChild(brim);
		setRotateAngle(brim, 0F, 0F, 0F);
		ribbonRight = new ModelRenderer(this, 108, 12);
		ribbonRight.addBox(0F, -2F, -1F, 4, 3, 1, 0F);
		ribbonRight.setRotationPoint(0.5F, -6F, -4F);
		ribbonRight.setTextureSize(64, 32);
		ribbonRight.mirror = true;
		hatBase.addChild(ribbonRight);
		setRotateAngle(ribbonRight, 0F, 0F, -0.3490659F);
		ribbonLeft = new ModelRenderer(this, 96, 12);
		ribbonLeft.addBox(-4F, -2F, -1F, 4, 3, 1, 0F);
		ribbonLeft.setRotationPoint(-0.5F, -6F, -4F);
		ribbonLeft.setTextureSize(64, 32);
		ribbonLeft.mirror = true;
		hatBase.addChild(ribbonLeft);
		setRotateAngle(ribbonLeft, 0F, 0F, 0.3490659F);
		setChild();
	}

	@Override
	public void setChild() {
		super.setChild();
	}
}
