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

public class ModelSeija extends ModelBipedDanmaku {

	public ModelRenderer rightHorn;
	public ModelRenderer leftHorn;
	public ModelRenderer redBraid;
	public ModelRenderer rightHair;
	public ModelRenderer leftHair;

	public ModelSeija() {
		textureWidth = 64;
		textureHeight = 64;
		bipedRightLeg = new ModelRenderer(this, 50, 18);
		bipedRightLeg.setRotationPoint(-2.0F, 11.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 3, 8, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 2.0F, 0.009999999776482582F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 48, 0);
		bipedLeftArm.setRotationPoint(3.0F, 3.0F, 0.0F);
		bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 18);
		bipedLeftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-3.0F, 3.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		rightHorn = new ModelRenderer(this, 0, 16);
		rightHorn.setRotationPoint(-3.0F, -8.0F, -3.5F);
		rightHorn.addBox(-1.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
		setRotateAngle(rightHorn, 0.7853981633974483F, 0.7853981633974483F, 0.0F);
		leftHair = new ModelRenderer(this, 22, 54);
		leftHair.setRotationPoint(4.0F, -4.0F, -0.01F);
		leftHair.addBox(-4.0F, 0.0F, 0.0F, 8, 5, 3, 0.0F);
		setRotateAngle(leftHair, -0.14870205226991687F, -1.5707963267948966F, 0.0F);
		skirtBottom = new ModelRenderer(this, 16, 32);
		skirtBottom.setRotationPoint(0.0F, 3.0F, 4.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -9.0F, 10, 6, 10, 0.0F);
		rightHair = new ModelRenderer(this, 0, 54);
		rightHair.setRotationPoint(-4.0F, -4.0F, -0.01F);
		rightHair.addBox(-4.0F, 0.0F, -3.0F, 8, 5, 3, 0.0F);
		setRotateAngle(rightHair, 0.14870205226991687F, -1.5707963267948966F, 0.0F);
		longHair = new ModelRenderer(this, 0, 48);
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 2, 3, 0.0F);
		leftHorn = new ModelRenderer(this, 0, 16);
		leftHorn.setRotationPoint(4.0F, -8.0F, -3.0F);
		leftHorn.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		setRotateAngle(leftHorn, 0.7853981633974483F, 2.356194490192345F, 0.0F);
		redBraid = new ModelRenderer(this, 0, 31);
		redBraid.setRotationPoint(0.0F, -8.0F, -4.0F);
		redBraid.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		setRotateAngle(redBraid, -0.2815216083466853F, 0.0F, -0.18587756533739608F);
		setChild();
	}
	
	@Override
	public void setChild() {
		super.setChild();
		bipedHead.addChild(leftHair);
		bipedHead.addChild(rightHair);
		bipedHead.addChild(leftHorn);
		bipedHead.addChild(rightHorn);
		bipedHead.addChild(redBraid);
	}
}
