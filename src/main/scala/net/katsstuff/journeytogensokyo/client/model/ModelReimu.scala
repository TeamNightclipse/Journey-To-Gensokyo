package net.katsstuff.journeytogensokyo.client.model

import net.katsstuff.journeytogensokyo.entity.living.EntityReimuNPC
import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.entity.Entity
import net.minecraft.util.EnumHandSide
import net.minecraft.util.math.MathHelper

/**
  * reimu - arekkuusu, katrix
  * Created using Tabula 7.0.0
  */
object ModelReimu extends ModelBase {
  textureWidth = 64
  textureHeight = 32

  val head             = new ModelRenderer(this, 0, 0)
  val hairTop          = new ModelRenderer(this, 42, 26)
  val hairLeft         = new ModelRenderer(this, 24, 18)
  val hairLeftRibbon   = new ModelRenderer(this, 12, 27)
  val hairRight        = new ModelRenderer(this, 0, 18)
  val hairRightRibbon  = new ModelRenderer(this, 22, 27)
  val hairBack         = new ModelRenderer(this, 36, 23)
  val hairFront        = new ModelRenderer(this, 12, 23)
  val ribbonBase       = new ModelRenderer(this, 42, 26)
  val ribbonLeft       = new ModelRenderer(this, 33, 0)
  val ribbonLeftSmall  = new ModelRenderer(this, 51, 5)
  val ribbonRight      = new ModelRenderer(this, 19, 0)
  val ribbonRightSmall = new ModelRenderer(this, 51, 1)
  val skirtBase        = new ModelRenderer(this, 0, 0)
  val skirtLeft        = new ModelRenderer(this, 31, 13)
  val skirtRight       = new ModelRenderer(this, 39, 7)
  val skirtFront       = new ModelRenderer(this, 25, 5)
  val skirtBack        = new ModelRenderer(this, 50, 10)
  val legLeft          = new ModelRenderer(this, 56, 17)
  val legRight         = new ModelRenderer(this, 48, 17)
  val armLeft          = new ModelRenderer(this, 24, 13)
  val armRight         = new ModelRenderer(this, 17, 13)
  val yellowStuff      = new ModelRenderer(this, 0, 21)
  val torso            = new ModelRenderer(this, 0, 12)

  hairFront.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairFront.addBox(-3.0F, -5.9F, -3.26F, 6, 4, 0, 0.0F)
  setRotateAngle(hairFront, -0.04363323129985824F, 0.0F, 0.0F)

  skirtBack.setRotationPoint(0.0F, 0.0F, 1.0F)
  skirtBack.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F)
  setRotateAngle(skirtBack, 0.13962634015954636F, 0.0F, 0.0F)

  armLeft.setRotationPoint(2.0F, -3.5F, 0.0F)
  armLeft.addBox(0.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F)
  setRotateAngle(armLeft, 0.0F, 0.0F, -0.13962634015954636F)

  skirtBase.setRotationPoint(0.0F, 2.0F, 0.0F)
  skirtBase.addBox(-2.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F)

  skirtRight.setRotationPoint(-2.0F, 0.0F, 0.0F)
  skirtRight.addBox(-1.0F, 0.0F, -2.0F, 1, 6, 4, 0.0F)
  setRotateAngle(skirtRight, 0.0F, 0.0F, 0.13962634015954636F)

  hairLeftRibbon.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairLeftRibbon.addBox(-0.4F, -5.9F, -4.4F, 1, 5, 0, 0.0F)
  setRotateAngle(hairLeftRibbon, 0.0F, 0.7853981633974483F, 0.03490658503988659F)

  skirtFront.setRotationPoint(0.0F, 0.0F, -2.0F)
  skirtFront.addBox(-3.0F, -0.1F, 0.0F, 6, 6, 1, 0.0F)
  setRotateAngle(skirtFront, -0.13962634015954636F, 0.0F, 0.0F)

  ribbonRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonRight.addBox(-6.0F, -2.6F, 0.0F, 6, 3, 1, 0.0F)
  setRotateAngle(ribbonRight, -0.6829473363053812F, 0.045553093477052F, 0.18203784098300857F)

  hairRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairRight.addBox(-3.19F, -5.9F, -3.0F, 0, 8, 6, 0.0F)
  setRotateAngle(hairRight, 0.0F, 0.0F, 0.031415926535897934F)

  hairLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairLeft.addBox(3.19F, -5.9F, -3.0F, 0, 8, 6, 0.0F)
  setRotateAngle(hairLeft, 0.0F, 0.0F, -0.031415926535897934F)

  ribbonLeftSmall.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonLeftSmall.addBox(0.0F, -2.6F, 0.0F, 4, 3, 1, 0.0F)
  setRotateAngle(ribbonLeftSmall, -0.6373942428283291F, -0.091106186954104F, 0.5009094953223726F)

  torso.setRotationPoint(0.0F, 16.0F, 0.0F)
  torso.addBox(-2.5F, -4.0F, -1.5F, 5, 6, 3, 0.0F)

  hairRightRibbon.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairRightRibbon.addBox(-0.4F, -5.9F, -4.4F, 1, 5, 0, 0.0F)
  setRotateAngle(hairRightRibbon, 0.0F, -0.7853981633974483F, -0.03490658503988659F)

  armRight.setRotationPoint(-2.0F, -3.5F, 0.0F)
  armRight.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F)
  setRotateAngle(armRight, 0.0F, 0.0F, 0.13962634015954636F)

  hairTop.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairTop.addBox(-3.0F, -6.0F, -3.0F, 6, 0, 6, 0.0F)

  hairBack.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairBack.addBox(-3.0F, -6.0F, 3.02F, 6, 9, 0, 0.0F)
  setRotateAngle(hairBack, 0.0017453292519943296F, 0.0F, 0.0F)

  ribbonBase.setRotationPoint(0.0F, -6.0F, 3.0F)
  ribbonBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F)

  head.setRotationPoint(-0.1F, -4.2F, 0.0F)
  head.addBox(-3.0F, -5.8F, -3.0F, 6, 6, 6, 0.0F)

  yellowStuff.setRotationPoint(0.0F, -3.7F, -1.5F)
  yellowStuff.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 0, 0.0F)
  setRotateAngle(yellowStuff, -0.091106186954104F, 0.0F, 0.0F)

  skirtLeft.setRotationPoint(2.5F, 0.0F, 0.0F)
  skirtLeft.addBox(-0.5F, 0.0F, -2.0F, 1, 6, 4, 0.0F)
  setRotateAngle(skirtLeft, 0.0F, 0.0F, -0.13962634015954636F)

  ribbonRightSmall.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonRightSmall.addBox(-4.0F, -2.5F, 0.1F, 4, 3, 1, 0.0F)
  setRotateAngle(ribbonRightSmall, -0.6829473363053812F, 0.045553093477052F, -0.4194026192542374F)

  ribbonLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonLeft.addBox(0.0F, -2.6F, -0.1F, 6, 3, 1, 0.0F)
  setRotateAngle(ribbonLeft, -0.6373942428283291F, -0.22759093446006054F, -0.18203784098300857F)

  legLeft.setRotationPoint(1.1F, 1.0F, 0.0F)
  legLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F)

  legRight.setRotationPoint(-1.1F, 1.0F, 0.0F)
  legRight.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F)

  head.addChild(hairTop)
  head.addChild(hairLeft)
  head.addChild(hairLeftRibbon)
  head.addChild(hairRight)
  head.addChild(hairRightRibbon)
  head.addChild(hairFront)
  head.addChild(hairBack)
  head.addChild(ribbonBase)

  ribbonBase.addChild(ribbonLeft)
  ribbonBase.addChild(ribbonLeftSmall)
  ribbonBase.addChild(ribbonRight)
  ribbonBase.addChild(ribbonRightSmall)

  skirtBase.addChild(skirtLeft)
  skirtBase.addChild(skirtRight)
  skirtBase.addChild(skirtFront)
  skirtBase.addChild(skirtBack)
  skirtBase.addChild(legLeft)
  skirtBase.addChild(legRight)

  torso.addChild(head)
  torso.addChild(armLeft)
  torso.addChild(armRight)
  torso.addChild(yellowStuff)
  torso.addChild(skirtBase)

  override def render(entity: Entity, f: Float, f1: Float, f2: Float, f3: Float, f4: Float, f5: Float): Unit =
    torso.render(f5)

  override def setRotationAngles(
      limbSwing: Float,
      limbSwingAmount: Float,
      age: Float,
      headYaw: Float,
      headPitch: Float,
      scale: Float,
      entity: Entity
  ): Unit = {
    val reimu = entity.asInstanceOf[EntityReimuNPC]

    val flag = reimu.getTicksElytraFlying > 4
    head.rotateAngleY = headYaw * 0.017453292F

    if (flag) head.rotateAngleX = -(Math.PI.toFloat / 4F) else head.rotateAngleX = headPitch * 0.017453292F

    torso.rotateAngleY = 0.0F

    var f = 1.0F
    if (flag) {
      f = (reimu.motionX * reimu.motionX + reimu.motionY * reimu.motionY + reimu.motionZ * reimu.motionZ).toFloat
      f = f / 0.2F
      f = f * f * f
    }
    if (f < 1.0F) f = 1.0F

    armRight.rotateAngleZ = 0.5061454830783556F
    armLeft.rotateAngleZ = -0.5061454830783556F

    val posDown   = reimu.getPosition.down
    val blockDown = reimu.world.getBlockState(posDown)
    val closeToGround = Option(blockDown.getCollisionBoundingBox(reimu.world, posDown))
      .exists(_.offset(posDown).contains(reimu.getPositionVector.subtract(0D, 0.2D, 0D)))

    if (closeToGround) {
      armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 2.0F * limbSwingAmount * 0.5F / f
      armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f
      legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f
      legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 1.4F * limbSwingAmount / f

      legRight.rotateAngleY = 0.0F
      legLeft.rotateAngleY = 0.0F
      legRight.rotateAngleZ = 0.0F
      legLeft.rotateAngleZ = 0.0F
    } else {
      armRight.rotateAngleX = 0F
      armLeft.rotateAngleX = 0F

      legRight.rotateAngleX = -MathHelper.cos(age * 0.03F) * 0.1F + 0.12F
      legLeft.rotateAngleX = -MathHelper.cos(age * 0.03F) * 0.1F + 0.12F
    }

    if (isRiding) {
      armRight.rotateAngleX += -(Math.PI.toFloat / 5F)
      armLeft.rotateAngleX += -(Math.PI.toFloat / 5F)
      legRight.rotateAngleX = -1.4137167F
      legRight.rotateAngleY = Math.PI.toFloat / 10F
      legRight.rotateAngleZ = 0.07853982F
      legLeft.rotateAngleX = -1.4137167F
      legLeft.rotateAngleY = -(Math.PI.toFloat / 10F)
      legLeft.rotateAngleZ = -0.07853982F
    }

    if (swingProgress > 0.0F) {
      val primaryHand      = reimu.getPrimaryHand
      val primaryHandModel = if (primaryHand == EnumHandSide.LEFT) armLeft else armRight
      var f1               = swingProgress
      torso.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * (Math.PI.toFloat * 2F)) * 0.2F

      if (primaryHand == EnumHandSide.LEFT) torso.rotateAngleY *= -1.0F

      armRight.rotationPointZ = MathHelper.sin(torso.rotateAngleY) * 5.0F
      armRight.rotationPointX = -MathHelper.cos(torso.rotateAngleY) * 5.0F
      armLeft.rotationPointZ = -MathHelper.sin(torso.rotateAngleY) * 5.0F
      armLeft.rotationPointX = MathHelper.cos(torso.rotateAngleY) * 5.0F
      armRight.rotateAngleY += torso.rotateAngleY
      armLeft.rotateAngleY += torso.rotateAngleY
      armLeft.rotateAngleX += torso.rotateAngleY
      f1 = 1.0F - this.swingProgress
      f1 = f1 * f1
      f1 = f1 * f1
      f1 = 1.0F - f1
      val f2 = MathHelper.sin(f1 * Math.PI.toFloat)
      val f3 = MathHelper.sin(this.swingProgress * Math.PI.toFloat) * -(head.rotateAngleX - 0.7F) * 0.75F
      primaryHandModel.rotateAngleX =
        (primaryHandModel.rotateAngleX.toDouble - (f2.toDouble * 1.2D + f3.toDouble)).toFloat
      primaryHandModel.rotateAngleY += torso.rotateAngleY * 2.0F
      primaryHandModel.rotateAngleZ += MathHelper.sin(this.swingProgress * Math.PI.toFloat) * -0.4F
    }

    armRight.rotateAngleZ += MathHelper.cos(age * 0.09F) * 0.05F + 0.05F
    armLeft.rotateAngleZ -= MathHelper.cos(age * 0.09F) * 0.05F + 0.05F
    armRight.rotateAngleX += MathHelper.sin(age * 0.067F) * 0.05F
    armLeft.rotateAngleX -= MathHelper.sin(age * 0.067F) * 0.05F
  }

  /**
    * This is a helper function from Tabula to set the rotation of model parts
    */
  def setRotateAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float): Unit = {
    modelRenderer.rotateAngleX = x
    modelRenderer.rotateAngleY = y
    modelRenderer.rotateAngleZ = z
  }
}
