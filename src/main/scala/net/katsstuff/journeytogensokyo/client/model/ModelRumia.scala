package net.katsstuff.journeytogensokyo.client.model
import net.katsstuff.journeytogensokyo.entity.living.boss.EntityRumiaEasy
import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.entity.Entity
import net.minecraft.util.EnumHandSide
import net.minecraft.util.math.MathHelper

/**
  * rumia - arekkuusu, katrix
  * Created using Tabula 7.0.0
  */
object ModelRumia extends ModelBase {
  textureWidth = 64
  textureHeight = 32

  val head            = new ModelRenderer(this, 0, 0)
  val hairTop         = new ModelRenderer(this, 42, 26)
  val hairLeft        = new ModelRenderer(this, 24, 18)
  val hairRight       = new ModelRenderer(this, 0, 18)
  val hairBack        = new ModelRenderer(this, 36, 23)
  val hairFront       = new ModelRenderer(this, 12, 23)
  val ribbonBase      = new ModelRenderer(this, 42, 26)
  val ribbonLeft      = new ModelRenderer(this, 33, 0)
  val ribbonLeftSmall = new ModelRenderer(this, 51, 5)
  val neccLeft        = new ModelRenderer(this, 0, 1)
  val neccRight       = new ModelRenderer(this, 0, 0)
  val neccRibbonBase  = new ModelRenderer(this, 0, 4)
  val skirtBase       = new ModelRenderer(this, 0, 0)
  val skirtLeft       = new ModelRenderer(this, 31, 13)
  val skirtRight      = new ModelRenderer(this, 39, 7)
  val skirtBack       = new ModelRenderer(this, 50, 10)
  val skirtFront      = new ModelRenderer(this, 25, 5)
  val legLeft         = new ModelRenderer(this, 56, 17)
  val legRight        = new ModelRenderer(this, 48, 17)
  val armLeft         = new ModelRenderer(this, 24, 13)
  val armRight        = new ModelRenderer(this, 17, 13)
  val armLeftThing    = new ModelRenderer(this, 18, 0)
  val armRightThing   = new ModelRenderer(this, 18, 0)
  val torso           = new ModelRenderer(this, 0, 12)
  val shape33         = new ModelRenderer(this, 2, 2)
  val shape34         = new ModelRenderer(this, 0, 2)

  shape33.setRotationPoint(0.0F, 0.0F, 0.0F)
  shape33.addBox(-0.4F, 0.0F, 0.0F, 1, 2, 0, 0.0F)
  setRotateAngle(shape33, -0.091106186954104F, 0.0F, -0.27314402793711257F)

  neccLeft.setRotationPoint(0.0F, -4.0F, -1.5F)
  neccLeft.addBox(0.1F, 0.0F, 0.0F, 2, 1, 0, 0.0F)
  setRotateAngle(neccLeft, -0.22759093446006054F, 0.0F, -0.3141592653589793F)

  hairBack.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairBack.addBox(-3.0F, -6.0F, 3.02F, 6, 7, 0, 0.0F)
  setRotateAngle(hairBack, 0.0017453292519943296F, 0.0F, 0.0F)

  hairRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairRight.addBox(-3.19F, -5.9F, -3.0F, 0, 7, 6, 0.0F)
  setRotateAngle(hairRight, 0.0F, 0.0F, 0.031415926535897934F)

  hairFront.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairFront.addBox(-3.0F, -5.9F, -3.26F, 6, 4, 0, 0.0F)
  setRotateAngle(hairFront, -0.04363323129985824F, 0.0F, 0.0F)

  neccRight.setRotationPoint(0.0F, -4.0F, -1.5F)
  neccRight.addBox(-2.1F, 0.0F, 0.0F, 2, 1, 0, 0.0F)
  setRotateAngle(neccRight, -0.22759093446006054F, 0.0F, 0.3141592653589793F)

  ribbonBase.setRotationPoint(2.5F, -6.0F, 1.3F)
  ribbonBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F)

  armRight.setRotationPoint(-2.5F, -3.0F, 0.0F)
  armRight.addBox(-1.0F, 0.5F, -1.0F, 1, 5, 2, 0.0F)
  setRotateAngle(armRight, 0.0F, 0.0F, 1.5707963267948966F)

  skirtBase.setRotationPoint(0.0F, 1.0F, 0.0F)
  skirtBase.addBox(-2.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F)

  armLeft.setRotationPoint(2.5F, -3.0F, 0.0F)
  armLeft.addBox(0.0F, 0.5F, -1.0F, 1, 5, 2, 0.0F)
  setRotateAngle(armLeft, 0.0F, 0.0F, -1.5707963267948966F)

  skirtLeft.setRotationPoint(2.5F, 0.0F, 0.0F)
  skirtLeft.addBox(-0.5F, 0.0F, -2.0F, 1, 5, 4, 0.0F)
  setRotateAngle(skirtLeft, 0.0F, 0.0F, -0.13962634015954636F)

  hairLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairLeft.addBox(3.19F, -5.9F, -3.0F, 0, 7, 6, 0.0F)
  setRotateAngle(hairLeft, 0.0F, 0.0F, -0.031415926535897934F)

  legLeft.setRotationPoint(1.1F, 1.0F, 0.0F)
  legLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F)

  ribbonLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonLeft.addBox(-0.8F, -0.3F, 0.0F, 4, 3, 1, 0.0F)
  setRotateAngle(ribbonLeft, -0.6373942428283291F, -0.22759093446006054F, -0.5394812717914472F)

  skirtFront.setRotationPoint(0.0F, 0.0F, -2.0F)
  skirtFront.addBox(-3.0F, -0.1F, 0.0F, 6, 5, 1, 0.0F)
  setRotateAngle(skirtFront, -0.13962634015954636F, 0.0F, 0.0F)

  skirtBack.setRotationPoint(0.0F, 0.0F, 1.0F)
  skirtBack.addBox(-3.0F, 0.0F, 0.0F, 6, 5, 1, 0.0F)
  setRotateAngle(skirtBack, 0.13962634015954636F, 0.0F, 0.0F)

  skirtRight.setRotationPoint(-2.0F, 0.0F, 0.0F)
  skirtRight.addBox(-1.0F, 0.0F, -2.0F, 1, 5, 4, 0.0F)
  setRotateAngle(skirtRight, 0.0F, 0.0F, 0.13962634015954636F)

  hairTop.setRotationPoint(0.0F, 0.0F, 0.0F)
  hairTop.addBox(-3.0F, -6.0F, -3.0F, 6, 0, 6, 0.0F)

  armLeftThing.setRotationPoint(0.5F, 0.0F, 0.0F)
  armLeftThing.addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2, 0.0F)

  legRight.setRotationPoint(-1.1F, 1.0F, 0.0F)
  legRight.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F)

  neccRibbonBase.setRotationPoint(0.0F, -3.1F, -1.5F)
  neccRibbonBase.addBox(-0.5F, -0.9F, -0.3F, 1, 1, 1, 0.0F)

  shape34.setRotationPoint(0.0F, 0.0F, 0.0F)
  shape34.addBox(-0.6F, 0.0F, 0.0F, 1, 2, 0, 0.0F)
  setRotateAngle(shape34, -0.045553093477052F, 0.0F, 0.27314402793711257F)

  torso.setRotationPoint(0.0F, 16.0F, 0.0F)
  torso.addBox(-2.5F, -4.0F, -1.5F, 5, 5, 3, 0.0F)

  head.setRotationPoint(-0.1F, -4.2F, 0.0F)
  head.addBox(-3.0F, -5.8F, -3.0F, 6, 6, 6, 0.0F)

  armRightThing.setRotationPoint(-0.5F, 0.0F, 0.0F)
  armRightThing.addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2, 0.0F)

  ribbonLeftSmall.setRotationPoint(0.0F, 0.0F, 0.0F)
  ribbonLeftSmall.addBox(-0.3F, -1.7F, 0.0F, 3, 3, 1, 0.0F)
  setRotateAngle(ribbonLeftSmall, -0.059341194567807204F, -0.6462954220135002F, -0.8375835080320788F)

  head.addChild(hairTop)
  head.addChild(hairLeft)
  head.addChild(hairRight)
  head.addChild(hairBack)
  head.addChild(hairFront)
  head.addChild(ribbonBase)

  ribbonBase.addChild(ribbonLeft)
  ribbonBase.addChild(ribbonLeftSmall)

  skirtBase.addChild(skirtLeft)
  skirtBase.addChild(skirtRight)
  skirtBase.addChild(skirtFront)
  skirtBase.addChild(skirtBack)
  skirtBase.addChild(legLeft)
  skirtBase.addChild(legRight)

  torso.addChild(head)
  torso.addChild(armLeft)
  torso.addChild(armRight)
  torso.addChild(neccLeft)
  torso.addChild(neccRight)
  torso.addChild(skirtBase)
  torso.addChild(neccRibbonBase)

  neccRibbonBase.addChild(shape33)
  neccRibbonBase.addChild(shape34)

  armLeft.addChild(armLeftThing)
  armRight.addChild(armRightThing)

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
    val rumia = entity.asInstanceOf[EntityRumiaEasy]

    val isElytraFlying = rumia.getTicksElytraFlying > 4
    head.rotateAngleY = headYaw * 0.017453292F

    if (isElytraFlying) head.rotateAngleX = -(Math.PI.toFloat / 4F) else head.rotateAngleX = headPitch * 0.017453292F

    torso.rotateAngleY = 0.0F

    var f = 1.0F
    if (isElytraFlying) {
      f = (rumia.motionX * rumia.motionX + rumia.motionY * rumia.motionY + rumia.motionZ * rumia.motionZ).toFloat
      f = f / 0.2F
      f = f * f * f
    }
    if (f < 1.0F) f = 1.0F

    armRight.rotateAngleZ = 1.527163F
    armLeft.rotateAngleZ = -1.527163F

    val posDown   = rumia.getPosition.down
    val blockDown = rumia.world.getBlockState(posDown)
    val closeToGround = Option(blockDown.getCollisionBoundingBox(rumia.world, posDown))
      .exists(_.offset(posDown).contains(rumia.getPositionVector.subtract(0D, 0.2D, 0D)))

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
      val primaryHand      = rumia.getPrimaryHand
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
