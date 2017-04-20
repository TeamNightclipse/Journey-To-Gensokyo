/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.model

import net.minecraft.client.model.ModelBase
import net.minecraft.client.model.ModelRenderer
import net.minecraft.entity.Entity
import net.minecraft.util.math.MathHelper

object ModelHellRaven extends ModelBase {
  textureWidth = 64
  textureHeight = 64

  val ravenWingLeft2  = new ModelRenderer(this, 42, 0)
  val ravenFootRight  = new ModelRenderer(this, 32, 32)
  val ravenBeak       = new ModelRenderer(this, 32, 28)
  val ravenWingRight2 = new ModelRenderer(this, 42, 0)
  val ravenWingLeft   = new ModelRenderer(this, 34, 13)
  val ravenFootLeft   = new ModelRenderer(this, 32, 32)
  val ravenBody       = new ModelRenderer(this, 0, 16)
  val ravenTail       = new ModelRenderer(this, 24, 0)
  val ravenWingRight  = new ModelRenderer(this, 34, 13)
  val ravenHead       = new ModelRenderer(this, 0, 0)

  ravenWingLeft2.mirror = true
  ravenWingLeft2.setRotationPoint(14.0F, 4.0F, 0.0F)
  ravenWingLeft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F)
  setRotateAngle(ravenWingLeft2, 0.0F, -0.31154127148098787F, 0.0F)

  ravenFootRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F)

  ravenBeak.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F)

  ravenWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F)
  ravenWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F)
  setRotateAngle(ravenWingRight2, 0.0F, 0.31154127148098787F, 0.0F)

  ravenWingLeft.mirror = true
  ravenWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F)
  setRotateAngle(ravenWingLeft, 0.0F, -0.6108652381980153F, 0.0F)

  ravenFootLeft.mirror = true
  ravenFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F)

  ravenBody.setRotationPoint(0.0F, 8.0F, -8.0F)
  ravenBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F)
  setRotateAngle(ravenBody, 1.3089969389957472F, 0.0F, 0.0F)

  ravenTail.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F)
  setRotateAngle(ravenTail, 0.05235987755982988F, 0.0F, 0.0F)

  ravenWingRight.setRotationPoint(0.0F, 0.0F, 0.0F)
  ravenWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F)
  setRotateAngle(ravenWingRight, 0.0F, 0.6108652381980153F, 0.0F)

  ravenHead.setRotationPoint(0.0F, 8.0F, -8.0F)
  ravenHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F)

  ravenWingLeft.addChild(ravenWingLeft2)
  ravenBody.addChild(ravenFootRight)
  ravenHead.addChild(ravenBeak)
  ravenWingRight.addChild(ravenWingRight2)
  ravenBody.addChild(ravenWingLeft)
  ravenBody.addChild(ravenFootLeft)
  ravenBody.addChild(ravenTail)
  ravenBody.addChild(ravenWingRight)

  override def render(entity: Entity, movement: Float, far: Float, tick: Float, yaw: Float, pitch: Float, size: Float): Unit = {
    setRotationAngles(movement, far, tick, yaw, pitch, size, entity)
    ravenBody.render(size)
    ravenHead.render(size)
  }

  override def setRotationAngles(movement: Float, far: Float, tick: Float, yaw: Float, pitch: Float, size: Float, entity: Entity): Unit = {
    ravenHead.rotateAngleY = yaw / (180F / Math.PI.toFloat)
    ravenHead.rotateAngleX = pitch / (180F / Math.PI.toFloat)
    ravenBody.rotateAngleX = (Math.PI / 3F + MathHelper.cos(tick * 0.1F) * 0.15F).toFloat
    ravenWingRight.rotateAngleY = (MathHelper.cos(tick * 0.8F) * Math.PI * 0.25F).toFloat
    ravenWingLeft.rotateAngleY = -ravenWingRight.rotateAngleY
    ravenWingRight2.rotateAngleY = ravenWingRight.rotateAngleY * 0.5F
    ravenWingLeft2.rotateAngleY = -ravenWingRight.rotateAngleY * 0.5F
  }

  def setRotateAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float): Unit = {
    modelRenderer.rotateAngleX = x
    modelRenderer.rotateAngleY = y
    modelRenderer.rotateAngleZ = z
  }
}
