/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import katrix.journeyToGensokyo.client.lib.LibResource;
import katrix.journeyToGensokyo.client.model.ModelYukari;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import net.minecraft.entity.EntityLivingBase;

public class RenderYukari extends RenderTHBoss {

	public RenderYukari() {
		super(new ModelYukari(), LibResource.YUKARI);
	}

	@Override
	protected void passSpecialRender(EntityLivingBase entity, double x, double y, double z) {
		super.passSpecialRender(entity, x, y, z);
		EntityYukari yukari = (EntityYukari)entity;

		if(yukari.getInvicibilityTimer() > 0) {
			GL11.glPushMatrix();
			GL11.glTranslated(x, y + entity.height / 2, z);
			GL11.glScalef(2.75F, 2.75F, 2.75F);
			GL11.glEnable(GL11.GL_BLEND);

			GL11.glDepthMask(false);

			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 0.0F, 1.0F, (float)yukari.getInvicibilityTimer() / 80);
			GL11.glEnable(GL11.GL_ALPHA_TEST);

			Sphere sphere = new Sphere();

			sphere.setDrawStyle(GLU.GLU_FILL);
			sphere.setNormals(GLU.GLU_SMOOTH);
			sphere.setOrientation(GLU.GLU_OUTSIDE);
			sphere.setTextureFlag(true);

			bindTexture(LibResource.YUKARI_SHIELD);
			sphere.draw(0.5F, 32, 32);

			sphere.setOrientation(GLU.GLU_INSIDE);
			sphere.draw(0.5F, 32, 32);

			GL11.glPopMatrix();
		}
	}
}