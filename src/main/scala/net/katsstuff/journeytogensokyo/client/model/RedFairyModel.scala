package net.katsstuff.journeytogensokyo.client.model

import org.lwjgl.opengl.GL11

import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.entity.Entity
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
object RedFairyModel extends ModelBase {
  textureWidth = 64
  textureHeight = 32

  val body = new ModelRenderer(this, 0, 7)
  this.body.setRotationPoint(0.0F, 6.0F, 0.0F)
  this.body.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4)
  val head = new ModelRenderer(this, 0, 20)
  this.head.setRotationPoint(0.0F, 0.0F, 0.0F)
  this.head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6)
  this.body.addChild(this.head)
  val hair = new ModelRenderer(this, 24, 18)
  this.hair.setRotationPoint(0.0F, -0.5F, 0.0F)
  this.hair.addBox(-3.5F, -6.0F, -3.5F, 7, 7, 7)
  this.head.addChild(this.hair)
  val ribbon = new ModelRenderer(this, 48, 16)
  this.ribbon.setRotationPoint(-3.0F, -5.5F, -0.5F)
  this.ribbon.addBox(-1.0F, -5.0F, 3.6F, 8, 5, 0)
  this.head.addChild(this.ribbon)
  val arm1 = new ModelRenderer(this, 16, 10)
  this.arm1.setRotationPoint(-1.5F, 1.0F, 0.0F)
  this.arm1.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 2)
  this.setRotationAngles(this.arm1, 0.0F, 0.0F, 0.5061454830783556F)
  this.body.addChild(this.arm1)
  val arm2 = new ModelRenderer(this, 16, 10)
  this.arm2.setRotationPoint(1.5F, 1.0F, 0.0F)
  this.arm2.addBox(0.0F, 0.0F, -1.0F, 1, 5, 2)
  this.setRotationAngles(this.arm2, 0.0F, 0.0F, -0.5061454830783556F)
  this.body.addChild(this.arm2)
  val leg1 = new ModelRenderer(this, 0, 0)
  this.leg1.setRotationPoint(-1.0F, 6.0F, 0.0F)
  this.leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2)
  this.body.addChild(this.leg1)
  val leg2 = new ModelRenderer(this, 0, 0)
  this.leg2.setRotationPoint(1.0F, 6.0F, 0.0F)
  this.leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2)
  this.body.addChild(this.leg2)
  val dress1 = new ModelRenderer(this, 8, 0)
  this.dress1.setRotationPoint(0.0F, 3.5F, -2.0F)
  this.dress1.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1)
  this.setRotationAngles(this.dress1, -0.2617993877991494F, 0.0F, 0.0F)
  this.body.addChild(this.dress1)
  val dress2 = new ModelRenderer(this, 20, 0)
  this.dress2.setRotationPoint(2.0F, 3.5F, 0.0F)
  this.dress2.addBox(-0.5F, 0.0F, -2.5F, 1, 6, 5)
  this.setRotationAngles(this.dress2, 0.0F, 0.0F, -0.2617993877991494F)
  this.body.addChild(this.dress2)
  val dress3 = new ModelRenderer(this, 8, 0)
  this.dress3.setRotationPoint(0.0F, 3.5F, 2.0F)
  this.dress3.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1)
  this.setRotationAngles(this.dress3, 0.2617993877991494F, 0.0F, 0.0F)
  this.body.addChild(this.dress3)
  val Dress4 = new ModelRenderer(this, 20, 0)
  this.Dress4.setRotationPoint(-2.0F, 3.5F, 0.0F)
  this.Dress4.addBox(-0.5F, 0.0F, -2.5F, 1, 6, 5)
  this.setRotationAngles(this.Dress4, 0.0F, 0.0F, 0.2617993877991494F)
  this.body.addChild(this.Dress4)
  val wing1 = new ModelRenderer(this, 32, 0)
  this.wing1.setRotationPoint(1.0F, -0.5F, 2.0F)
  this.wing1.addBox(0.0F, -4.0F, 0.0F, 0, 8, 8)
  this.setRotationAngles(this.wing1, 0.0F, 0.7853981633974483F, 0.0F)
  this.body.addChild(this.wing1)
  val wing2 = new ModelRenderer(this, 32, 0)
  this.wing2.setRotationPoint(-1.0F, -0.5F, 2.0F)
  this.wing2.addBox(0.0F, -4.0F, 0.0F, 0, 8, 8)
  this.setRotationAngles(this.wing2, 0.0F, -0.7853981633974483F, 0.0F)
  this.body.addChild(this.wing2)

  override def render(entity:          Entity,
                      limbSwing:       Float,
                      limbSwingAmount: Float,
                      ageInTick:       Float,
                      rotationYaw:     Float,
                      rotationPitch:   Float,
                      scale:           Float): Unit = {
    GlStateManager.enableBlend()
    GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
    GlStateManager.color(1.0F, 1.0F, 1.0F, 0.0F)
    this.body.render(scale)
    GlStateManager.disableBlend()
  }

  def setRotationAngles(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float): Unit = {
    modelRenderer.rotateAngleX = x
    modelRenderer.rotateAngleY = y
    modelRenderer.rotateAngleZ = z
  }
}
