package net.katsstuff.journeytogensokyo.client.render

import net.katsstuff.journeytogensokyo.client.model.ModelTenguCrow
import net.katsstuff.journeytogensokyo.entity.living.EntityTenguCrow
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

class RenderTenguCrow(renderManager: RenderManager) extends RenderLiving[EntityTenguCrow](renderManager, ModelTenguCrow, 0.5F) {
  protected def getEntityTexture(entity: EntityTenguCrow) = new ResourceLocation(LibMod.Id, "textures/entity/mob/tengu_crow.png")
}
