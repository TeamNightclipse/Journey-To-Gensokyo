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
import katrix.journeyToGensokyo.client.model.ModelTHFairyJTG;
import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.entity.living.EntityTHFairy;

@SideOnly(Side.CLIENT)
public class RenderTHFairyEnd extends RenderLiving {

	public RenderTHFairyEnd() {
		super(new ModelTHFairyJTG(), 0.25F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityTHFairy)entity);
	}

	protected ResourceLocation getEntityTexture(EntityTHFairy thFairy) {
		ResourceLocation texture = new ResourceLocation(LibMod.MODID.toLowerCase(), "textures/entity/mob/FairyTextureEnd_" + thFairy.getForm() % 3 + ".png");

		return texture;
	}
}
