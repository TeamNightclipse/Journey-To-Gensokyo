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

public class ModelKaguya extends ModelBipedDanmaku {

	private ModelRenderer skirtBottom2;
	private ModelRenderer rightBraid;
	private ModelRenderer leftBraid;
	private ModelRenderer longHairLeft;
	private ModelRenderer rightHand;
	private ModelRenderer leftHand;

	public ModelKaguya() {
		textureWidth = 64;
		textureHeight = 64;
		bipedLeftArm = new ModelRenderer(this, 48, 0);
		bipedLeftArm.setRotationPoint(4.0F, 1.0F, 0.0F);
		bipedLeftArm.addBox(-3.0F, -1.0F, -1.0F, 4, 7, 2, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 16);
		bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 28);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 4.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -9.0F, 10, 5, 10, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-4.0F, 1.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 4, 7, 2, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		longHairLeft = new ModelRenderer(this, 40, 32);
		longHairLeft.setRotationPoint(0.0F, -1.0F, 4.0F);
		longHairLeft.addBox(-4.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(longHairLeft, 0.20943951023931953F, 0.0F, -0.2617993877991494F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		leftHand = new ModelRenderer(this, 52, 9);
		leftHand.setRotationPoint(0.0F, 6.0F, 0.0F);
		leftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		longHair = new ModelRenderer(this, 40, 32);
		longHair.setRotationPoint(0.0F, -1.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(longHair, 0.20943951023931953F, 0.0F, 0.2617993877991494F);
		rightBraid = new ModelRenderer(this, 0, 28);
		rightBraid.setRotationPoint(-3.0F, -3.0F, -3.0F);
		rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(rightBraid, -0.10471975511965977F, 0.0F, 0.0F);
		skirtBottom2 = new ModelRenderer(this, 0, 46);
		skirtBottom2.setRotationPoint(0.0F, 5.0F, -9.0F);
		skirtBottom2.addBox(-6.0F, 0.0F, -1.0F, 12, 5, 12, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 16);
		bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 12, 4, 0.0F);
		rightHand = new ModelRenderer(this, 52, 9);
		rightHand.setRotationPoint(0.0F, 6.0F, 0.0F);
		rightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
		leftRibbon = new ModelRenderer(this, 24, 0);
		leftRibbon.setRotationPoint(0.0F, 1.0F, -2.0F);
		leftRibbon.addBox(0.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
		setRotateAngle(leftRibbon, 0.0F, 0.0F, 0.296705972839036F);
		rightRibbon = new ModelRenderer(this, 34, 0);
		rightRibbon.setRotationPoint(0.0F, 1.0F, -2.0F);
		rightRibbon.addBox(-4.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
		setRotateAngle(rightRibbon, 0.0F, 0.0F, -0.296705972839036F);
		leftBraid = new ModelRenderer(this, 0, 28);
		leftBraid.setRotationPoint(3.0F, -3.0F, -3.0F);
		leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(leftBraid, -0.10471975511965977F, 0.0F, 0.0F);
		setChild();
	}
	
	@Override
	public void setChild() {
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(skirtTop);
		skirtTop.addChild(skirtBottom);
		bipedHead.addChild(longHair);

		bipedHead.addChild(longHairLeft);
		bipedHead.addChild(rightBraid);
		bipedHead.addChild(leftBraid);
		bipedLeftArm.addChild(leftHand);
		bipedRightArm.addChild(rightHand);
		skirtBottom.addChild(skirtBottom2);
		
		bipedBody.addChild(leftRibbon);
		bipedBody.addChild(rightRibbon);
	}
}
