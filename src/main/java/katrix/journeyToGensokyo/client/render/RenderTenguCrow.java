/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import katrix.journeyToGensokyo.client.model.ModelTenguCrow;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTenguCrow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTenguCrow extends RenderLiving {

	ResourceLocation texture = new ResourceLocation("journeytogensokyo", "textures/entity/mob/tenguCrow.png");

	public RenderTenguCrow() {
		super(new ModelTenguCrow(), 0.25F);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		super.doRender(entity, x, y, z, yaw, pitch);
		render((EntityTenguCrow)entity, x, y, z, yaw, pitch);

	}

	public void render(EntityTenguCrow entity, double x, double y, double z, float yaw, float pitch) {
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityTenguCrow)entity);
	}

	protected ResourceLocation getEntityTexture(EntityTenguCrow entity) {
		return texture;
	}
}