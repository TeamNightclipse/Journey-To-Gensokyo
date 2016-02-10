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

public class ModelSeiga extends ModelBipedDanmaku {

	public ModelRenderer rightRingHair1;
	public ModelRenderer leftRingHair1;
	public ModelRenderer stick;
	public ModelRenderer rightRingHair2;
	public ModelRenderer rightRingHair3;
	public ModelRenderer leftRingHair2;
	public ModelRenderer leftRingHair3;
	public ModelRenderer chisel;

	public ModelSeiga() {
		textureWidth = 64;
		textureHeight = 64;
		chisel = new ModelRenderer(this, 0, 49);
		chisel.setRotationPoint(-11.0F, -1.0F, 0.0F);
		chisel.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		leftRingHair2 = new ModelRenderer(this, 32, 26);
		leftRingHair2.setRotationPoint(3.0F, 1.0F, 0.0F);
		leftRingHair2.addBox(0.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		setRotateAngle(leftRingHair2, 0.0F, 0.0F, -1.8325957145940461F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.setRotationPoint(-3.0F, 3.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 50, 19);
		bipedRightLeg.setRotationPoint(-2.0F, 11.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 50, 19);
		bipedLeftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		rightRingHair3 = new ModelRenderer(this, 32, 26);
		rightRingHair3.setRotationPoint(6.0F, 0.0F, 0.0F);
		rightRingHair3.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		setRotateAngle(rightRingHair3, 0.0F, 0.0F, 1.8325957145940461F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.setRotationPoint(3.0F, 3.0F, 0.0F);
		bipedLeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, 0.0F);
		skirtBottom = new ModelRenderer(this, 0, 32);
		skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
		skirtBottom.addBox(-5.0F, -1.0F, -5.0F, 10, 5, 10, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
		stick = new ModelRenderer(this, 0, 47);
		stick.setRotationPoint(2.0F, -8.0F, 0.0F);
		stick.addBox(-9.0F, 0.0F, 0.0F, 16, 1, 1, 0.0F);
		setRotateAngle(stick, 0.0F, -0.17453292519943295F, 0.17453292519943295F);
		leftRingHair1 = new ModelRenderer(this, 32, 26);
		leftRingHair1.setRotationPoint(3.0F, -7.0F, 0.0F);
		leftRingHair1.addBox(0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		setRotateAngle(leftRingHair1, 0.0F, 0.0F, -0.7853981633974483F);
		skirtTop = new ModelRenderer(this, 0, 16);
		skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
		skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
		longHair = new ModelRenderer(this, 24, 0);
		longHair.setRotationPoint(0.0F, 0.0F, 4.0F);
		longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 4, 3, 0.0F);
		setRotateAngle(longHair, 0.10471975511965977F, 0.0F, 0.0F);
		rightRingHair1 = new ModelRenderer(this, 32, 26);
		rightRingHair1.setRotationPoint(-3.0F, -7.0F, 0.0F);
		rightRingHair1.addBox(0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		setRotateAngle(rightRingHair1, 0.0F, 0.0F, -2.356194490192345F);
		rightRingHair2 = new ModelRenderer(this, 32, 26);
		rightRingHair2.setRotationPoint(3.0F, -1.0F, 0.0F);
		rightRingHair2.addBox(0.0F, -2.0F, -1.0F, 6, 2, 2, 0.0F);
		setRotateAngle(rightRingHair2, 0.0F, 0.0F, 1.8325957145940461F);
		leftRingHair3 = new ModelRenderer(this, 32, 26);
		leftRingHair3.setRotationPoint(6.0F, 0.0F, 0.0F);
		leftRingHair3.addBox(0.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F);
		setRotateAngle(leftRingHair3, 0.0F, 0.0F, -1.8325957145940461F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		setChild();
	}
	
	@Override
	public void setChild() {
		super.setChild();
		
		stick.addChild(chisel);
		bipedHead.addChild(stick);
		bipedHead.addChild(rightRingHair1);
		rightRingHair1.addChild(rightRingHair2);
		rightRingHair2.addChild(rightRingHair3);
		bipedHead.addChild(leftRingHair1);
		leftRingHair1.addChild(leftRingHair2);
		leftRingHair2.addChild(leftRingHair3);
	}
}
