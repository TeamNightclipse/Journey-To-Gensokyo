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
    public ModelRenderer cape;
    public ModelRenderer ribbonBackRight;
    public ModelRenderer ribbonBackLeft;
    public ModelRenderer hatBase;
    public ModelRenderer rightBraid;
    public ModelRenderer leftBraid;
    public ModelRenderer hatBase2;
    public ModelRenderer hatBase3;
    public ModelRenderer hatBase4;
    public ModelRenderer hatRim;
    public ModelRenderer hatRibbonLeft;
    public ModelRenderer hatRibbonRight;
    public ModelRenderer bipedRightLeg2;
    public ModelRenderer bipedLeftLeg2;
    public ModelRenderer bipedLeftArm2;
    public ModelRenderer bipedRightArm2;

    public ModelMarisa() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.hatBase3 = new ModelRenderer(this, 112, 16);
        this.hatBase3.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.hatBase3.addBox(-2.0F, -3.0F, -2.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(hatBase3, -0.5410520681182421F, 0.0F, 0.0F);
        this.hatRim = new ModelRenderer(this, 64, 16);
        this.hatRim.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.hatRim.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedLeftArm2 = new ModelRenderer(this, 56, 0);
        this.bipedLeftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.bipedLeftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 36, 22);
        this.bipedLeftLeg.setRotationPoint(1.5F, 9.0F, 0.0F);
        this.bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
        this.rightBraid = new ModelRenderer(this, 0, 32);
        this.rightBraid.setRotationPoint(-3.0F, -2.0F, -3.0F);
        this.rightBraid.addBox(-1.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rightBraid, -0.22759093446006054F, 0.0F, 0.0F);
        this.bipedRightArm2 = new ModelRenderer(this, 56, 0);
        this.bipedRightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.bipedRightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.bipedBody = new ModelRenderer(this, 32, 8);
        this.bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
        this.hatRibbonLeft = new ModelRenderer(this, 108, 12);
        this.hatRibbonLeft.setRotationPoint(0.5F, -6.0F, -4.0F);
        this.hatRibbonLeft.addBox(0.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(hatRibbonLeft, 0.0F, 0.0F, -0.3490658503988659F);
        this.skirtBottom = new ModelRenderer(this, 16, 32);
        this.skirtBottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.skirtBottom.addBox(-5.0F, 0.0F, -5.0F, 10, 7, 10, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 36, 22);
        this.bipedRightLeg.setRotationPoint(-1.5F, 9.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 48, 0);
        this.bipedRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(bipedRightArm, -0.7000515629749255F, 0.0F, -0.6457718232379019F);
        this.skirtTop = new ModelRenderer(this, 0, 16);
        this.skirtTop.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.skirtTop.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
        this.hatRibbonRight = new ModelRenderer(this, 96, 12);
        this.hatRibbonRight.setRotationPoint(-0.5F, -6.0F, -4.0F);
        this.hatRibbonRight.addBox(-4.0F, -2.0F, -1.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(hatRibbonRight, 0.0F, 0.0F, 0.3490658503988659F);
        this.longHair = new ModelRenderer(this, 0, 50);
        this.longHair.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.longHair.addBox(-4.0F, 0.0F, -3.0F, 8, 5, 3, 0.0F);
        this.setRotateAngle(longHair, 0.17453292519943295F, 0.0F, 0.0F);
        this.hatBase = new ModelRenderer(this, 64, 0);
        this.hatBase.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.hatBase.addBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F);
        this.bipedLeftLeg2 = new ModelRenderer(this, 50, 22);
        this.bipedLeftLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.bipedLeftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 48, 0);
        this.bipedLeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(bipedLeftArm, -0.7000515629749255F, 0.0F, 0.6457718232379019F);
        this.hatBase4 = new ModelRenderer(this, 112, 24);
        this.hatBase4.setRotationPoint(0.0F, -11.0F, 1.0F);
        this.hatBase4.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(hatBase4, -0.8203047484373349F, 0.0F, 0.0F);
        this.bipedRightLeg2 = new ModelRenderer(this, 50, 22);
        this.bipedRightLeg2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.bipedRightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, 0.0F);
        this.leftBraid = new ModelRenderer(this, 0, 32);
        this.leftBraid.setRotationPoint(3.0F, -2.0F, -3.0F);
        this.leftBraid.addBox(0.0F, 0.0F, -1.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leftBraid, -0.22759093446006054F, 0.0F, 0.0F);
        this.cape = new ModelRenderer(this, 32, 56);
        this.cape.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cape.addBox(-5.0F, 0.0F, -2.5F, 10, 3, 5, 0.0F);
        this.ribbonBackRight = new ModelRenderer(this, 64, 36);
        this.ribbonBackRight.setRotationPoint(0.0F, 3.5F, 2.0F);
        this.ribbonBackRight.addBox(-3.5F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(ribbonBackRight, 0.0F, 0.0F, 0.3490658503988659F);
        this.ribbonBackLeft = new ModelRenderer(this, 64, 32);
        this.ribbonBackLeft.setRotationPoint(0.0F, 3.5F, 2.0F);
        this.ribbonBackLeft.addBox(-0.5F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(ribbonBackLeft, 0.0F, 0.0F, -0.3490658503988659F);
        this.hatBase2 = new ModelRenderer(this, 96, 2);
        this.hatBase2.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.hatBase2.addBox(-3.0F, -3.0F, -3.0F, 6, 3, 6, 0.0F);
        this.setRotateAngle(hatBase2, -0.2792526803190927F, 0.0F, 0.0F);
        setChild();
    }
    
    @Override
    public void setChild() {
    	super.setChild();
        this.bipedHead.addChild(this.leftBraid);
        this.bipedHead.addChild(this.rightBraid);
        this.bipedHead.addChild(this.hatBase);
        this.hatBase.addChild(this.hatBase2);
        this.hatBase.addChild(this.hatBase3);
        this.hatBase.addChild(this.hatBase4);
        this.hatBase.addChild(this.hatRim);
        this.hatBase.addChild(this.hatRibbonLeft);
        this.hatBase.addChild(this.hatRibbonRight);
        this.bipedLeftArm.addChild(this.bipedLeftArm2);
        this.bipedRightArm.addChild(this.bipedRightArm2);
        this.bipedLeftLeg.addChild(this.bipedLeftLeg2);
        this.bipedRightLeg.addChild(this.bipedRightLeg2);
        this.bipedBody.addChild(this.cape);
        this.bipedBody.addChild(this.ribbonBackRight);
        this.bipedBody.addChild(this.ribbonBackLeft);
    }
}
