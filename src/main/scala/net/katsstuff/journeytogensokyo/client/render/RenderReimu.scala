package net.katsstuff.journeytogensokyo.client.render
import net.katsstuff.journeytogensokyo.client.model.{ModelReimu, ModelReimu}
import net.katsstuff.journeytogensokyo.entity.living.EntityReimuNPC
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

@SideOnly(Side.CLIENT)
class RenderReimu(renderManager: RenderManager) extends RenderLiving[EntityReimuNPC](renderManager, ModelReimu, 0.5F) {
  protected def getEntityTexture(entity: EntityReimuNPC) =
    new ResourceLocation(LibMod.Id, "textures/entity/reimu.png")
}
