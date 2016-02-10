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

public class ModelKasen extends ModelBipedDanmaku {

	public ModelRenderer rightSinyon;
	public ModelRenderer leftSinyon;

	public ModelKasen() {
		textureWidth = 64;
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
		leftSinyon = new ModelRenderer(this, 32, 25);
		leftSinyon.setRotationPoint(3.5F, -6.0F, 0.0F);
		leftSinyon.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
		setRotateAngle(leftSinyon, 0.0F, 0.0F, 1.3089969389957472F);
		rightSinyon = new ModelRenderer(this, 32, 25);
		rightSinyon.setRotationPoint(-3.5F, -6.0F, 0.0F);
		rightSinyon.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
		setRotateAngle(rightSinyon, 0.0F, 0.0F, -1.3089969389957472F);
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
		setChild();
	}
	
	@Override
	public void setChild() {
		super.setChild();
		bipedHead.addChild(leftSinyon);
		bipedHead.addChild(rightSinyon);
	}
}
