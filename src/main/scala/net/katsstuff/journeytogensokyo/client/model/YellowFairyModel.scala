package net.katsstuff.journeytogensokyo.client.model

import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.entity.Entity
import net.minecraftforge.fml.relauncher.{Side, SideOnly}
import org.lwjgl.opengl.GL11

@SideOnly(Side.CLIENT)
object YellowFairyModel extends ModelFairy {
  textureWidth = 64
  textureHeight = 32

  val body      = new ModelRenderer(this, 0, 7)
  val head      = new ModelRenderer(this, 0, 20)
  val hair      = new ModelRenderer(this, 24, 18)
  val ribbon    = new ModelRenderer(this, 46, 18)
  val rightArm  = new ModelRenderer(this, 16, 10)
  val leftArm   = new ModelRenderer(this, 16, 10)
  val rightLeg  = new ModelRenderer(this, 0, 0)
  val leftLeg   = new ModelRenderer(this, 0, 0)
  val dress1    = new ModelRenderer(this, 8, 0)
  val dress2    = new ModelRenderer(this, 20, 0)
  val dress3    = new ModelRenderer(this, 8, 0)
  val dress4    = new ModelRenderer(this, 20, 0)
  val leftWing  = new ModelRenderer(this, 32, 0)
  val rightWing = new ModelRenderer(this, 32, 0)

  body.setRotationPoint(0.0F, 13.0F, 0.0F)
  body.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4)

  head.setRotationPoint(0.0F, 0.0F, 0.0F)
  head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6)

  hair.setRotationPoint(0.0F, -0.5F, 0.0F)
  hair.addBox(-3.5F, -6.0F, -3.5F, 7, 7, 7)

  ribbon.setRotationPoint(0.0F, -5.5F, -1.5F)
  ribbon.addBox(-4.0F, -5.0F, 3.5F, 8, 5, 1)

  rightArm.setRotationPoint(-1.5F, 1.0F, 0.0F)
  rightArm.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 2)
  setRotationAngles(rightArm, 0.0F, 0.0F, 0.5061454830783556F)

  leftArm.setRotationPoint(1.5F, 1.0F, 0.0F)
  leftArm.addBox(0.0F, 0.0F, -1.0F, 1, 5, 2)
  setRotationAngles(leftArm, 0.0F, 0.0F, -0.5061454830783556F)

  rightLeg.setRotationPoint(-1.0F, 6.0F, 0.0F)
  rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2)

  leftLeg.setRotationPoint(1.0F, 6.0F, 0.0F)
  leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2)

  dress1.setRotationPoint(0.0F, 3.5F, -2.0F)
  dress1.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1)
  setRotationAngles(dress1, -0.2617993877991494F, 0.0F, 0.0F)

  dress2.setRotationPoint(2.0F, 3.5F, 0.0F)
  dress2.addBox(-0.5F, 0.0F, -2.5F, 1, 6, 5)
  setRotationAngles(dress2, 0.0F, 0.0F, -0.2617993877991494F)

  dress3.setRotationPoint(0.0F, 3.5F, 2.0F)
  dress3.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1)
  setRotationAngles(dress3, 0.2617993877991494F, 0.0F, 0.0F)

  dress4.setRotationPoint(-2.0F, 3.5F, 0.0F)
  dress4.addBox(-0.5F, 0.0F, -2.5F, 1, 6, 5)
  setRotationAngles(dress4, 0.0F, 0.0F, 0.2617993877991494F)

  leftWing.setRotationPoint(1.0F, -0.5F, 2.0F)
  leftWing.addBox(0.0F, -4.0F, 0.0F, 1, 8, 8)
  setRotationAngles(leftWing, 0.0F, 0.7853981633974483F, 0.0F)

  rightWing.setRotationPoint(-1.0F, -0.5F, 2.0F)
  rightWing.addBox(0.0F, -4.0F, 0.0F, 1, 8, 8)
  setRotationAngles(rightWing, 0.0F, -0.7853981633974483F, 0.0F)

  body.addChild(head)
  head.addChild(hair)
  head.addChild(ribbon)
  body.addChild(rightArm)
  body.addChild(leftArm)
  body.addChild(rightLeg)
  body.addChild(leftLeg)
  body.addChild(dress1)
  body.addChild(dress2)
  body.addChild(dress3)
  body.addChild(dress4)
  body.addChild(leftWing)
  body.addChild(rightWing)
}
