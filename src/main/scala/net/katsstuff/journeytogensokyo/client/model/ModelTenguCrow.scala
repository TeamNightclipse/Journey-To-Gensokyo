/*
 * This class was created by <Katrix>. It's distributed as
 * part of the DanmakuCore Mod. Get the Source Code in github:
 * https://github.com/Katrix-/DanmakuCore
 *
 * DanmakuCore is Open Source and distributed under the
 * the DanmakuCore license: https://github.com/Katrix-/DanmakuCore/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.model

import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.entity.Entity
import net.minecraft.util.math.MathHelper

object ModelTenguCrow extends ModelBase {
  textureWidth = 64
  textureHeight = 64

  val tenguFootLeft   = new ModelRenderer(this, 32, 32)
  val tenguWingRight  = new ModelRenderer(this, 34, 13)
  val tenguWingLeft2  = new ModelRenderer(this, 42, 0)
  val tenguBeak       = new ModelRenderer(this, 32, 28)
  val tenguWingLeft   = new ModelRenderer(this, 34, 13)
  val tenguTail       = new ModelRenderer(this, 24, 0)
  val tenguHead       = new ModelRenderer(this, 0, 0)
  val tenguHat        = new ModelRenderer(this, 42, 28)
  val tenguFootRight  = new ModelRenderer(this, 32, 32)
  val tenguBody       = new ModelRenderer(this, 0, 16)
  val tenguWingRight2 = new ModelRenderer(this, 42, 0)

  tenguFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F)

  tenguWingRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F)
  setRotateAngle(tenguWingRight, 0.0F, 0.7853981633974483F, 0.0F)

  tenguWingLeft2.mirror = true
  tenguWingLeft2.setRotationPoint(14.0F, 4.0F, 0.0F)
  tenguWingLeft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F)
  setRotateAngle(tenguWingLeft2, 0.0F, -0.39269908169872414F, 0.0F)

  tenguBeak.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F)

  tenguWingLeft.mirror = true
  tenguWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F)
  setRotateAngle(tenguWingLeft, 0.0F, -0.7853981633974483F, 0.0F)

  tenguTail.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F)
  setRotateAngle(tenguTail, 0.05235987755982988F, 0.0F, 0.0F)

  tenguHead.setRotationPoint(0.0F, 8.0F, -8.0F)
  tenguHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F)

  tenguHat.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguHat.addBox(-2.0F, -7.0F, -2.0F, 4, 3, 4, 0.0F)

  tenguFootRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  tenguFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F)

  tenguBody.setRotationPoint(0.0F, 8.0F, -8.0F)
  tenguBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F)
  setRotateAngle(tenguBody, 1.1971213339429108F, 0.0F, 0.0F)

  tenguWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F)
  tenguWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F)
  setRotateAngle(tenguWingRight2, 0.0F, 0.39269908169872414F, 0.0F)

  tenguBody.addChild(tenguFootLeft)
  tenguBody.addChild(tenguWingRight)
  tenguBody.addChild(tenguWingLeft)
  tenguBody.addChild(tenguTail)
  tenguBody.addChild(tenguFootRight)
  tenguHead.addChild(tenguBeak)
  tenguHead.addChild(tenguHat)
  tenguWingLeft.addChild(tenguWingLeft2)
  tenguWingRight.addChild(tenguWingRight2)

  override def render(entity: Entity, movement: Float, far: Float, tick: Float, yaw: Float, pitch: Float, size: Float) {
    setRotationAngles(movement, far, tick, yaw, pitch, size, entity)
    tenguBody.render(size)
    tenguHead.render(size)
  }
  override def setRotationAngles(
      movement: Float,
      far: Float,
      tick: Float,
      yaw: Float,
      pitch: Float,
      size: Float,
      entity: Entity
  ) {
    tenguHead.rotateAngleY = (yaw / (180F / Math.PI)).toFloat
    tenguHead.rotateAngleX = (pitch / (180F / Math.PI)).toFloat
    tenguBody.rotateAngleX = (Math.PI / 3F + MathHelper.cos(tick * 0.1F) * 0.15F).toFloat
    tenguWingRight.rotateAngleY = (MathHelper.cos(tick * 0.8F) * Math.PI * 0.25F).toFloat
    tenguWingLeft.rotateAngleY = -tenguWingRight.rotateAngleY
    tenguWingRight2.rotateAngleY = tenguWingRight.rotateAngleY * 0.5F
    tenguWingLeft2.rotateAngleY = -tenguWingRight.rotateAngleY * 0.5F
  }

  /**
		* This is a helper function from Tabula to set the rotation of model parts
		*/
  def setRotateAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
    modelRenderer.rotateAngleX = x
    modelRenderer.rotateAngleY = y
    modelRenderer.rotateAngleZ = z
  }
}
