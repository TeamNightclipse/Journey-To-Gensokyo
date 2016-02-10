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

public class ModelByakuren extends ModelBipedDanmaku {

	public ModelRenderer leftBraid;
	public ModelRenderer rightBraid;

	public ModelByakuren() {
		textureWidth = 64;
		textureHeight = 64;
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		leftBraid = new ModelRenderer(this, 0, 32);
		leftBraid.setRotationPoint(3.0F, -1.0F, -3.0F);
		leftBraid.addBox(0.0F, -2.0F, -1.0F, 1, 5, 1, 0.0F);
		setRotateAngle(leftBraid, -0.24434609527920614F, 0.0F, 0.0F);
		skirtBottom = new ModelRenderer(this, 16, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 9, 10, 0.0F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 7.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 18);
		bipedLeftLeg.setRotationPoint(2.0F, 10.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 18);
		bipedRightLeg.setRotationPoint(-2.0F, 10.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		longHair = new ModelRenderer(this, 0, 50);
		longHair.setRotationPoint(0.0F, 1.0F, 1.0F);
		longHair.addBox(-4.0F, -2.0F, -3.0F, 8, 9, 3, 0.0F);
		setRotateAngle(longHair, -0.20943951023931953F, 3.141592653589793F, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 48, 0);
		bipedLeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		rightBraid = new ModelRenderer(this, 0, 32);
		rightBraid.setRotationPoint(-3.0F, -1.0F, -3.0F);
		rightBraid.addBox(-1.0F, -2.0F, -1.0F, 1, 5, 1, 0.0F);
		setRotateAngle(rightBraid, -0.24434609527920614F, 0.0F, 0.0F);
		setChild();
	}
}
