package net.katsstuff.journeytogensokyo.client.render

import org.lwjgl.opengl.GL11

import net.katsstuff.danmakucore.client.helper.RenderHelper
import net.katsstuff.danmakucore.lib.LibMod
import net.katsstuff.journeytogensokyo.client.model.EmptyModel
import net.katsstuff.journeytogensokyo.entity.living.EntityPhantom
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

class RenderPhantom(manager: RenderManager) extends RenderLiving[EntityPhantom](manager, EmptyModel, 0.5F) {
  val White = new ResourceLocation(LibMod.MODID, "textures/white.png")

  override def doRender(entity: EntityPhantom, x: Double, y: Double, z: Double, entityYaw: Float, partialTicks: Float): Unit = {
    super.doRender(entity, x, y, z, entityYaw, partialTicks)
    GlStateManager.pushMatrix()

    //Fairly similar to fire form
    val pitch = entity.rotationPitch
    val yaw   = entity.rotationYaw
    val size  = 0.3F
    val color = EntityPhantom.formToColor(entity.form)
    val alpha = 0.3F

    GlStateManager.translate(x, y + 0.2, z)
    GlStateManager.rotate(-yaw, 0F, 1F, 0F)
    GlStateManager.rotate(-pitch, 1F, 0F, 0F)
    GlStateManager.scale(size, size, size)

    GlStateManager.disableLighting()

    RenderHelper.drawSphere(0xFFFFFF, 1F)

    GlStateManager.enableBlend()
    GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE)
    GlStateManager.depthMask(false)
    GlStateManager.scale(1.4F, 1.4F, 1.4F) //This is bigger
    RenderHelper.drawSphere(color, alpha)
    GlStateManager.depthMask(true)
    GlStateManager.disableBlend()

    GlStateManager.enableLighting()
    GlStateManager.popMatrix()
  }

  override def getEntityTexture(entity: EntityPhantom): ResourceLocation = White
}
