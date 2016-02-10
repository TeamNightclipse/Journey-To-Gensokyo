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

public class ModelAlice extends ModelBipedDanmaku {

	public ModelRenderer cape;
	public ModelRenderer ribbon1;
	public ModelRenderer ribbon2;
	public ModelRenderer bipedLeftArm2;
	public ModelRenderer bipedRightArm2;
	public ModelRenderer leftBraid;
	public ModelRenderer rightBraid;
	public ModelRenderer bipedRightLeg2;
	public ModelRenderer bibedLeftLeg2;

	public ModelAlice() {
		textureWidth = 64;
		textureHeight = 64;
		cape = new ModelRenderer(this, 32, 56);
		cape.setRotationPoint(0.0F, 0.0F, 0.0F);
		cape.addBox(-5.0F, 0.0F, -2.5F, 10, 3, 5, 0.0F);
		leftBraid = new ModelRenderer(this, 0, 32);
		leftBraid.setRotationPoint(3.0F, -2.0F, -3.0F);
		leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(leftBraid, -0.22759093446006054F, 0.0F, 0.0F);
		bipedLeftArm2 = new ModelRenderer(this, 56, 0);
		bipedLeftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
		bipedLeftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		ribbon2 = new ModelRenderer(this, 4, 32);
		ribbon2.setRotationPoint(0.0F, 0.0F, -2.0F);
		ribbon2.addBox(-1.5F, 0.0F, -0.5F, 3, 5, 1, 0.0F);
		setRotateAngle(ribbon2, -0.27314402793711257F, 0.0F, -0.136659280431156F);
		bibedLeftLeg2 = new ModelRenderer(this, 50, 22);
		bibedLeftLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bibedLeftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		rightBraid = new ModelRenderer(this, 0, 32);
		rightBraid.setRotationPoint(-3.0F, -2.0F, -3.0F);
		rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
		setRotateAngle(rightBraid, -0.22759093446006054F, 0.0F, 0.0F);
		bipedRightLeg2 = new ModelRenderer(this, 50, 22);
		bipedRightLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedRightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 48, 0);
		bipedLeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 36, 22);
		bipedRightLeg.setRotationPoint(1.5F, 9.0F, 0.0F);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		ribbon1 = new ModelRenderer(this, 4, 32);
		ribbon1.setRotationPoint(0.0F, 0.0F, -2.0F);
		ribbon1.addBox(-1.5F, 0.0F, -0.5F, 3, 5, 1, 0.0F);
		setRotateAngle(ribbon1, -0.136659280431156F, 0.0F, 0.0F);
		skirtBottom = new ModelRenderer(this, 16, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 7, 10, 0.0F);
		longHair = new ModelRenderer(this, 0, 50);
		longHair.setRotationPoint(0.0F, -1.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 5, 3, 0.0F);
		setRotateAngle(longHair, 0.17453292519943295F, 0.0F, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 36, 22);
		bipedLeftLeg.setRotationPoint(-1.5F, 9.0F, 0.0F);
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
		bipedRightArm2 = new ModelRenderer(this, 56, 0);
		bipedRightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
		bipedRightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		setChild();
	}
	
	@Override
	public void setChild() {
		super.setChild();
		bipedBody.addChild(cape);
		bipedBody.addChild(ribbon1);
		bipedBody.addChild(ribbon2);
		bipedHead.addChild(rightBraid);
		bipedHead.addChild(leftBraid);
		bipedLeftArm.addChild(bipedLeftArm2);
		bipedLeftLeg.addChild(bibedLeftLeg2);
		bipedRightLeg.addChild(bipedRightLeg2);
		bipedRightArm.addChild(bipedRightArm2);
	}
}
