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

public class ModelYukari extends ModelBipedDanmaku {

	public ModelRenderer HatBase;
	public ModelRenderer rightBraidBack;
	public ModelRenderer leftBraidBack;
	public ModelRenderer rightLongHair;
	public ModelRenderer leftBraid;
	public ModelRenderer rightBraid;
	public ModelRenderer leftLongHair;
	public ModelRenderer HatRing;
	public ModelRenderer rightMiniRibbonBack;
	public ModelRenderer leftMiniRibbonBack;
	public ModelRenderer leftMiniRibbonFront;
	public ModelRenderer rightMiniRibbonFront;
	public ModelRenderer skirtBottom2;

	public ModelYukari() {
		textureWidth = 128;
		textureHeight = 64;
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 5.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		leftMiniRibbonBack = new ModelRenderer(this, 38, 0);
		leftMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
		leftMiniRibbonBack.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(3.0F, 1.0F, 0.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotateAngle(bipedLeftArm, 0.0F, 0.0F, -0.5235987755982988F);
		rightBraidBack = new ModelRenderer(this, 32, 20);
		rightBraidBack.setRotationPoint(-3.0F, -1.0F, 3.0F);
		rightBraidBack.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		setRotateAngle(rightBraidBack, 0.0F, 0.0F, 0.17453292519943295F);
		rightRibbon = new ModelRenderer(this, 24, 0);
		rightRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
		rightRibbon.addBox(-6.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
		setRotateAngle(rightRibbon, 0.0F, 0.0F, 0.17453292519943295F);
		leftMiniRibbonFront = new ModelRenderer(this, 38, 0);
		leftMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
		leftMiniRibbonFront.addBox(-1.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 28);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 5, 10, 0.0F);
		bipedRightArm = new ModelRenderer(this, 56, 0);
		bipedRightArm.setRotationPoint(-3.0F, 1.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		setRotateAngle(bipedRightArm, -0.0F, 0.0F, 0.5235987755982988F);
		skirtBottom2 = new ModelRenderer(this, 0, 43);
		skirtBottom2.setRotationPoint(0.0F, 5.0F, -5.0F);
		skirtBottom2.addBox(-6.0F, 0.0F, -1.0F, 12, 5, 12, 0.0F);
		leftLongHair = new ModelRenderer(this, 40, 34);
		leftLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
		leftLongHair.addBox(0.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(leftLongHair, 0.20943951023931953F, 0.0F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 16);
		bipedRightLeg.setRotationPoint(-2.0F, 8.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		HatBase = new ModelRenderer(this, 64, 0);
		HatBase.setRotationPoint(0.0F, -7.0F, 0.0F);
		HatBase.addBox(-4.5F, -2.0F, -4.5F, 9, 2, 9, 0.0F);
		HatRing = new ModelRenderer(this, 64, 11);
		HatRing.setRotationPoint(0.0F, 0.0F, 0.0F);
		HatRing.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10, 0.0F);
		rightMiniRibbonBack = new ModelRenderer(this, 38, 0);
		rightMiniRibbonBack.setRotationPoint(0.0F, 6.0F, -0.1F);
		rightMiniRibbonBack.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		leftBraid = new ModelRenderer(this, 0, 16);
		leftBraid.setRotationPoint(3.0F, -2.0F, -3.0F);
		leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(leftBraid, -0.10471975511965977F, 0.0F, 0.0F);
		leftRibbon = new ModelRenderer(this, 24, 0);
		leftRibbon.setRotationPoint(0.0F, -2.0F, -5.1F);
		leftRibbon.addBox(0.0F, -1.0F, 0.0F, 6, 4, 1, 0.0F);
		setRotateAngle(leftRibbon, 0.0F, 0.0F, -0.17453292519943295F);
		leftBraidBack = new ModelRenderer(this, 32, 20);
		leftBraidBack.setRotationPoint(3.0F, -1.0F, 3.0F);
		leftBraidBack.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		setRotateAngle(leftBraidBack, 0.0F, 0.0F, -0.17453292519943295F);
		rightLongHair = new ModelRenderer(this, 62, 34);
		rightLongHair.setRotationPoint(0.0F, -2.0F, 4.0F);
		rightLongHair.addBox(-8.0F, 0.0F, -3.0F, 8, 15, 3, 0.0F);
		setRotateAngle(rightLongHair, 0.20943951023931953F, 0.0F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 16);
		bipedLeftLeg.setRotationPoint(2.0F, 8.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		rightBraid = new ModelRenderer(this, 0, 16);
		rightBraid.setRotationPoint(-3.0F, -2.0F, -3.0F);
		rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
		setRotateAngle(rightBraid, -0.10471975511965977F, 0.0F, 0.0F);
		rightMiniRibbonFront = new ModelRenderer(this, 38, 0);
		rightMiniRibbonFront.setRotationPoint(0.0F, 3.0F, -1.1F);
		rightMiniRibbonFront.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 7);
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		setChild();
	}
	
	@Override
	public void setChild() {
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(bipedLeftLeg);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(skirtTop);
		skirtTop.addChild(skirtBottom);
		skirtBottom.addChild(skirtBottom2);
		bipedHead.addChild(leftBraid);
		leftBraid.addChild(leftMiniRibbonFront);
		bipedHead.addChild(rightBraid);
		rightBraid.addChild(rightMiniRibbonFront);
		bipedHead.addChild(rightBraidBack);
		rightBraidBack.addChild(rightMiniRibbonBack);
		bipedHead.addChild(leftBraidBack);
		leftBraidBack.addChild(leftMiniRibbonBack);
		bipedHead.addChild(leftLongHair);
		bipedHead.addChild(rightLongHair);
		bipedHead.addChild(HatBase);
		HatBase.addChild(leftRibbon);
		HatBase.addChild(rightRibbon);
		HatBase.addChild(HatRing);
	}
}