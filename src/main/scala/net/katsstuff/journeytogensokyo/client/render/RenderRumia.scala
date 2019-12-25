package net.katsstuff.journeytogensokyo.client.render
import net.katsstuff.journeytogensokyo.client.model.{ModelReimu, ModelRumia}
import net.katsstuff.journeytogensokyo.entity.living.boss.EntityRumiaEasy
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
class RenderRumia(renderManager: RenderManager) extends RenderLiving[EntityRumiaEasy](renderManager, ModelRumia, 0.5F) {
  protected def getEntityTexture(entity: EntityRumiaEasy) =
    new ResourceLocation(LibMod.Id, "textures/entity/rumia.png")
}
