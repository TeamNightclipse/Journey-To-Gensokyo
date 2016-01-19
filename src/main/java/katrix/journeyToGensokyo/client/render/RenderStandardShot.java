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

import katrix.journeyToGensokyo.client.model.ModelYingYangOrb;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.client.model.ModelMiniHakkero;
import thKaguyaMod.client.model.ModelMiniHakkero2;

public class RenderStandardShot extends Render {

	private static final ResourceLocation miniHakkeroTexture = new ResourceLocation("thkaguyamod", "textures/MiniHakkeroTexture.png");
	private static final ResourceLocation yingYangTexture = new ResourceLocation("journeytogensokyo", "textures/entity/YinYangOrb.png");
	protected ModelBase modelMiniHakkero, modelMiniHakkero2, modelYingYangOrb;

	public RenderStandardShot() {
		shadowSize = 0.5F;
		modelMiniHakkero = new ModelMiniHakkero();
		modelMiniHakkero2 = new ModelMiniHakkero2();
		modelYingYangOrb = new ModelYingYangOrb();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {

		EntityStandardShot standardShot = (EntityStandardShot)entity;

		if (standardShot.getType() <= 1) {
			renderYingYangOrb(standardShot, x, y, z, yaw, pitch);
		}
		else {
			renderMiniHakkero(standardShot, x, y, z, yaw, pitch);
			renderMiniHakkero2(standardShot, x, y, z, yaw, pitch);
		}
	}

	public void renderYingYangOrb(EntityStandardShot yingYangOrb, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(yingYangOrb));
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(yingYangOrb.rotationPitch, -MathHelper.sin((float)((yaw - 90F) / 180F * Math.PI)), 0.0F,
				MathHelper.cos((float)((yaw - 90F) / 180F * Math.PI)));
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);

		GL11.glScalef(0.5F, 0.5F, 0.5F);
		modelYingYangOrb.render(yingYangOrb, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		float angle = 30F;
		GL11.glRotatef((float)(MathHelper.sin(angle) / Math.PI * 180F), 0.0F, 0.0F, 1.0F);


		GL11.glPopMatrix();
	}

	public void renderMiniHakkero(EntityStandardShot miniHakkero, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(miniHakkero));
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(miniHakkero.rotationPitch, -MathHelper.sin((float)((yaw - 90F) / 180F * Math.PI)), 0.0F,
				MathHelper.cos((float)((yaw - 90F) / 180F * Math.PI)));
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);

		GL11.glScalef(0.5F, 0.5F, 0.5F);
		modelMiniHakkero.render(miniHakkero, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		float angle = 30F;
		GL11.glRotatef((float)(MathHelper.sin(angle) / Math.PI * 180F), 0.0F, 0.0F, 1.0F);


		GL11.glPopMatrix();
	}


	public void renderMiniHakkero2(EntityStandardShot miniHakkero, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(miniHakkero.rotationPitch, -MathHelper.sin((float)((miniHakkero.rotationYaw - 90F) / 180F * Math.PI)), 0.0F,
				MathHelper.cos((float)((yaw - 90F) / 180F * Math.PI)));
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);

		GL11.glScalef(0.501F, 0.501F, 0.501F);

		modelMiniHakkero2.render(miniHakkero, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);

		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {

		EntityStandardShot standardShot = (EntityStandardShot)entity;

		if (standardShot.getType() <= 1)
			return yingYangTexture;
		else
			return miniHakkeroTexture;
	}
}
