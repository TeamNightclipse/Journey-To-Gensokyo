/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.model

import org.lwjgl.opengl.GL11

import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.entity.Entity
import net.minecraft.util.EnumHandSide
import net.minecraft.util.math.MathHelper
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
abstract class ModelFairy extends ModelBase {

  def body:      ModelRenderer
  def head:      ModelRenderer
  def hair:      ModelRenderer
  def rightArm:  ModelRenderer
  def leftArm:   ModelRenderer
  def rightLeg:  ModelRenderer
  def leftLeg:   ModelRenderer
  def dress1:    ModelRenderer
  def dress2:    ModelRenderer
  def dress3:    ModelRenderer
  def dress4:    ModelRenderer
  def rightWing: ModelRenderer
  def leftWing:  ModelRenderer

  override def render(
      entity: Entity,
      limbSwing: Float,
      limbSwingAmount: Float,
      age: Float,
      yaw: Float,
      pitch: Float,
      scale: Float
  ): Unit = {
    setRotationAngles(limbSwing, limbSwingAmount, age, yaw, pitch, scale, entity)
    GlStateManager.enableBlend()
    GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
    body.render(scale)
    GlStateManager.disableBlend()
  }

  def setRotationAngles(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
    modelRenderer.rotateAngleX = x
    modelRenderer.rotateAngleY = y
    modelRenderer.rotateAngleZ = z
  }

  //Adapted from ModelBiped
  override def setRotationAngles(
      limbSwing: Float,
      limbSwingAmount: Float,
      age: Float,
      headYaw: Float,
      headPitch: Float,
      scale: Float,
      entity: Entity
  ): Unit = {
    val fairy = entity.asInstanceOf[EntityFairy]

    val flag = fairy.getTicksElytraFlying > 4
    head.rotateAngleY = headYaw * 0.017453292F

    if (flag) head.rotateAngleX = -(Math.PI.toFloat / 4F) else head.rotateAngleX = headPitch * 0.017453292F

    body.rotateAngleY = 0.0F

    var f = 1.0F
    if (flag) {
      f = (fairy.motionX * fairy.motionX + fairy.motionY * fairy.motionY + fairy.motionZ * fairy.motionZ).toFloat
      f = f / 0.2F
      f = f * f * f
    }
    if (f < 1.0F) f = 1.0F

    rightArm.rotateAngleZ = 0.5061454830783556F
    leftArm.rotateAngleZ = -0.5061454830783556F

    val posDown   = fairy.getPosition.down
    val blockDown = fairy.world.getBlockState(posDown)
    val closeToGround = Option(blockDown.getCollisionBoundingBox(fairy.world, posDown))
      .exists(_.offset(posDown).contains(fairy.getPositionVector.subtract(0D, 0.2D, 0D)))

    if (closeToGround) {
      rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 2.0F * limbSwingAmount * 0.5F / f
      leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f
      rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f
      leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 1.4F * limbSwingAmount / f

      rightLeg.rotateAngleY = 0.0F
      leftLeg.rotateAngleY = 0.0F
      rightLeg.rotateAngleZ = 0.0F
      leftLeg.rotateAngleZ = 0.0F

      rightWing.rotateAngleY = -MathHelper.cos(age * 0.09F) * 0.1F - 0.7853981633974483F
      leftWing.rotateAngleY = MathHelper.cos(age * 0.09F) * 0.1F + 0.7853981633974483F
    } else {
      rightArm.rotateAngleX = 0F
      leftArm.rotateAngleX = 0F

      rightLeg.rotateAngleX = -MathHelper.cos(age * 0.03F) * 0.1F + 0.12F
      leftLeg.rotateAngleX = -MathHelper.cos(age * 0.03F) * 0.1F + 0.12F
      rightWing.rotateAngleY = -MathHelper.cos(age * 0.9F) * 0.6F - 0.7853981633974483F
      leftWing.rotateAngleY = MathHelper.cos(age * 0.9F) * 0.6F + 0.7853981633974483F
    }

    if (isRiding) {
      rightArm.rotateAngleX += -(Math.PI.toFloat / 5F)
      leftArm.rotateAngleX += -(Math.PI.toFloat / 5F)
      rightLeg.rotateAngleX = -1.4137167F
      rightLeg.rotateAngleY = Math.PI.toFloat / 10F
      rightLeg.rotateAngleZ = 0.07853982F
      leftLeg.rotateAngleX = -1.4137167F
      leftLeg.rotateAngleY = -(Math.PI.toFloat / 10F)
      leftLeg.rotateAngleZ = -0.07853982F
    }

    if (swingProgress > 0.0F) {
      val primaryHand      = fairy.getPrimaryHand
      val primaryHandModel = if (primaryHand == EnumHandSide.LEFT) leftArm else rightArm
      var f1               = swingProgress
      body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * (Math.PI.toFloat * 2F)) * 0.2F

      if (primaryHand == EnumHandSide.LEFT) body.rotateAngleY *= -1.0F

      rightArm.rotationPointZ = MathHelper.sin(body.rotateAngleY) * 5.0F
      rightArm.rotationPointX = -MathHelper.cos(body.rotateAngleY) * 5.0F
      leftArm.rotationPointZ = -MathHelper.sin(body.rotateAngleY) * 5.0F
      leftArm.rotationPointX = MathHelper.cos(body.rotateAngleY) * 5.0F
      rightArm.rotateAngleY += body.rotateAngleY
      leftArm.rotateAngleY += body.rotateAngleY
      leftArm.rotateAngleX += body.rotateAngleY
      f1 = 1.0F - this.swingProgress
      f1 = f1 * f1
      f1 = f1 * f1
      f1 = 1.0F - f1
      val f2 = MathHelper.sin(f1 * Math.PI.toFloat)
      val f3 = MathHelper.sin(this.swingProgress * Math.PI.toFloat) * -(head.rotateAngleX - 0.7F) * 0.75F
      primaryHandModel.rotateAngleX =
        (primaryHandModel.rotateAngleX.toDouble - (f2.toDouble * 1.2D + f3.toDouble)).toFloat
      primaryHandModel.rotateAngleY += body.rotateAngleY * 2.0F
      primaryHandModel.rotateAngleZ += MathHelper.sin(this.swingProgress * Math.PI.toFloat) * -0.4F
    }

    rightArm.rotateAngleZ += MathHelper.cos(age * 0.09F) * 0.05F + 0.05F
    leftArm.rotateAngleZ -= MathHelper.cos(age * 0.09F) * 0.05F + 0.05F
    rightArm.rotateAngleX += MathHelper.sin(age * 0.067F) * 0.05F
    leftArm.rotateAngleX -= MathHelper.sin(age * 0.067F) * 0.05F
  }
}
