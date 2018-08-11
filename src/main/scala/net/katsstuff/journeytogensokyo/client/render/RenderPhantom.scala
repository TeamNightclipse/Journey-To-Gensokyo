/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.render

import org.lwjgl.opengl.GL11

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore
import net.katsstuff.journeytogensokyo.client.model.EmptyModel
import net.katsstuff.journeytogensokyo.entity.living.EntityPhantom
import net.katsstuff.teamnightclipse.mirror.client.helper.MirrorRenderHelper
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
class RenderPhantom(manager: RenderManager) extends RenderLiving[EntityPhantom](manager, EmptyModel, 0.5F) {
  val White: ResourceLocation = DanmakuCore.resource("textures/white.png")

  override def doRender(
      entity: EntityPhantom,
      x: Double,
      y: Double,
      z: Double,
      entityYaw: Float,
      partialTicks: Float
  ): Unit = {
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

    val dist = x * x + y * y + z * z

    MirrorRenderHelper.drawSphere(0xFFFFFF, 1F, dist)

    GlStateManager.enableBlend()
    GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE)
    GlStateManager.depthMask(false)
    GlStateManager.scale(1.4F, 1.4F, 1.4F) //This is bigger
    MirrorRenderHelper.drawSphere(color, alpha, dist)
    GlStateManager.depthMask(true)
    GlStateManager.disableBlend()

    GlStateManager.enableLighting()
    GlStateManager.popMatrix()
  }

  override def getEntityTexture(entity: EntityPhantom): ResourceLocation = White
}
