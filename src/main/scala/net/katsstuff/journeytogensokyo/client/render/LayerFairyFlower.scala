/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.render

import net.katsstuff.journeytogensokyo.client.model.ModelFairy
import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.minecraft.block.Block
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.entity.layers.LayerRenderer
import net.minecraft.client.renderer.texture.TextureMap
import net.minecraft.client.renderer.{GlStateManager, OpenGlHelper}
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
class LayerFairyFlower(val fairyRenderer: RenderFairy) extends LayerRenderer[EntityFairy] {
  override def doRenderLayer(
      fairy: EntityFairy,
      limbSwing: Float,
      limbSwingAmount: Float,
      partialTicks: Float,
      ageInTicks: Float,
      netHeadYaw: Float,
      headPitch: Float,
      scale: Float
  ): Unit = {
    val fairyModel = fairyRenderer.getMainModel.asInstanceOf[ModelFairy]

    if (fairy.holdingFlower) {
      val likedFlower   = fairy.likedFlower
      val blockRenderer = Minecraft.getMinecraft.getBlockRendererDispatcher

      GlStateManager.enableRescaleNormal()
      GlStateManager.pushMatrix()
      GlStateManager.rotate(90F, 1.0F, 0.0F, 0.0F)
      GlStateManager.translate(-0.45F, -0.04F, -0.87F)
      GlStateManager.rotate(Math.toDegrees(fairyModel.rightArm.rotateAngleX).toFloat, 1F, 0F, 0F)
      GlStateManager.scale(0.4F, -0.4F, 0.4F)
      val i = fairy.getBrightnessForRender
      val j = i % 65536
      val k = i / 65536
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j.toFloat, k.toFloat)
      GlStateManager.color(1F, 1F, 1F, 1F)
      this.fairyRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE)
      //noinspection ScalaDeprecation
      val state = Block.getBlockFromItem(likedFlower.getItem).getStateFromMeta(likedFlower.getItemDamage)

      blockRenderer.renderBlockBrightness(state, 1.0F)
      GlStateManager.popMatrix()
      GlStateManager.disableRescaleNormal()
    }
  }
  override def shouldCombineTextures = false
}
