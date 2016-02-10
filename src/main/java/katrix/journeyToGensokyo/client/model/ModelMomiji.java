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

public class ModelMomiji extends ModelBipedDanmaku {

	private ModelRenderer button1;
	private ModelRenderer button2;
	private ModelRenderer bipedLeftArm2;
	private ModelRenderer leftHand;
	private ModelRenderer shield;
	private ModelRenderer bipedRightArm2;
	private ModelRenderer rightHand;
	private ModelRenderer bipedLeftLeg2;
	private ModelRenderer leftSandal;
	private ModelRenderer bipedRightLeg2;
	private ModelRenderer rightSandal;
	private ModelRenderer hat;
	private ModelRenderer earRight;
	private ModelRenderer earLeft;

	public ModelMomiji() {
		textureWidth = 64;
		textureHeight = 64;
		hat = new ModelRenderer(this, 0, 38);
		hat.setRotationPoint(0.0F, -7.0F, 0.0F);
		hat.addBox(-2.0F, -4.0F, -2.0F, 4, 3, 4, 0.0F);
		bipedLeftLeg2 = new ModelRenderer(this, 50, 22);
		bipedLeftLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedLeftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		button1 = new ModelRenderer(this, 4, 32);
		button1.setRotationPoint(0.0F, 3.0F, -1.0F);
		button1.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 36, 22);
		bipedRightLeg.setRotationPoint(-1.5F, 10.0F, 0.0F);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 7.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		leftSandal = new ModelRenderer(this, 50, 32);
		leftSandal.setRotationPoint(0.0F, 6.0F, 0.0F);
		leftSandal.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
		longHair = new ModelRenderer(this, 0, 50);
		longHair.setRotationPoint(0.0F, -2.0F, 4.0F);
		longHair.addBox(-4.0F, -1.0F, -3.0F, 8, 5, 3, 0.0F);
		setRotateAngle(longHair, 0.20943951023931953F, 0.0F, 0.0F);
		rightRibbon = new ModelRenderer(this, 0, 32);
		rightRibbon.setRotationPoint(-3.0F, -2.0F, -3.0F);
		rightRibbon.addBox(-1.0F, -1.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(rightRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		rightSandal = new ModelRenderer(this, 50, 32);
		rightSandal.setRotationPoint(0.0F, 6.0F, 0.0F);
		rightSandal.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 36, 22);
		bipedLeftLeg.setRotationPoint(1.5F, 10.0F, 0.0F);
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		button2 = new ModelRenderer(this, 4, 32);
		button2.setRotationPoint(0.0F, 6.0F, -1.0F);
		button2.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
		skirtBottom = new ModelRenderer(this, 16, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 7, 10, 0.0F);
		shield = new ModelRenderer(this, 32, 55);
		shield.setRotationPoint(2.1F, 2.0F, -1.0F);
		shield.addBox(-2.5F, -4.0F, 0.0F, 7, 8, 1, 0.0F);
		setRotateAngle(shield, 0.0F, -1.5707963267948966F, 0.0F);
		leftHand = new ModelRenderer(this, 48, 0);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		leftHand.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		bipedRightLeg2 = new ModelRenderer(this, 50, 22);
		bipedRightLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedRightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		bipedRightArm = new ModelRenderer(this, 24, 0);
		bipedRightArm.setRotationPoint(-4.0F, 2.0F, -1.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 4, 0.0F);
		earLeft = new ModelRenderer(this, 52, 7);
		earLeft.setRotationPoint(4.0F, -6.0F, 0.0F);
		earLeft.addBox(-0.0F, -3.0F, -2.0F, 3, 3, 1, 0.0F);
		setRotateAngle(earLeft, 0.0F, -0.5235987755982988F, -0.9773843811168246F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		earRight = new ModelRenderer(this, 52, 3);
		earRight.setRotationPoint(-4.0F, -6.0F, 0.0F);
		earRight.addBox(-3.0F, -3.0F, -2.0F, 3, 3, 1, 0.0F);
		setRotateAngle(earRight, 0.0F, 0.5235987755982988F, 0.9773843811168246F);
		bipedLeftArm = new ModelRenderer(this, 24, 0);
		bipedLeftArm.setRotationPoint(4.0F, 2.0F, -1.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 4, 0.0F);
		bipedRightArm2 = new ModelRenderer(this, 36, 0);
		bipedRightArm2.setRotationPoint(0.0F, 3.0F, 1.0F);
		bipedRightArm2.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 4, 0.0F);
		rightHand = new ModelRenderer(this, 48, 0);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		rightHand.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		bipedLeftArm2 = new ModelRenderer(this, 36, 0);
		bipedLeftArm2.setRotationPoint(0.0F, 3.0F, 1.0F);
		bipedLeftArm2.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 4, 0.0F);
		leftRibbon = new ModelRenderer(this, 0, 32);
		leftRibbon.setRotationPoint(3.0F, -2.0F, -3.0F);
		leftRibbon.addBox(0.0F, -1.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(leftRibbon, -0.24434609527920614F, 0.0F, 0.0F);
		setChild();
	}
	
	@Override
	public void setChild() {
		super.setChild();
		bipedBody.addChild(button1);
		bipedBody.addChild(button2);
		bipedHead.addChild(hat);
		bipedHead.addChild(earLeft);
		bipedHead.addChild(earRight);
		bipedLeftLeg.addChild(bipedLeftLeg2);
		bipedLeftLeg2.addChild(leftSandal);
		bipedRightLeg.addChild(bipedRightLeg2);
		bipedRightLeg2.addChild(rightSandal);
		bipedLeftArm.addChild(bipedLeftArm2);
		bipedLeftArm2.addChild(shield);
		bipedLeftArm2.addChild(leftHand);
		bipedRightArm.addChild(bipedRightArm2);
		bipedRightArm2.addChild(rightHand);
	}
}
