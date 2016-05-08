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

import katrix.journeyToGensokyo.lib.LibMod;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroJTG;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.client.model.ModelMiniHakkero;
import thKaguyaMod.client.model.ModelMiniHakkero2;

public class RenderMiniHakkeroJTG extends Render {

	private static final ResourceLocation TEXTURE = new ResourceLocation(LibMod.KAGUYAMOD.toLowerCase(), "textures/MiniHakkeroTexture.png");
	private static final ModelBase MODEL_MINI_HAKKERO = new ModelMiniHakkero();
	private static final ModelBase MODEL_MINI_HAKKERO2 = new ModelMiniHakkero2();

	public RenderMiniHakkeroJTG() {
		shadowSize = 0.5F; //TODO: Needed?
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		renderMiniHakkero((EntityMiniHakkeroJTG)entity, x, y, z, yaw, pitch);
		renderMiniHakkero2((EntityMiniHakkeroJTG)entity, x, y, z, yaw, pitch);
	}

	public void renderMiniHakkero(EntityMiniHakkeroJTG miniHakkero, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		bindEntityTexture(miniHakkero);
		GL11.glTranslated(x, y, z);
		GL11.glRotated(miniHakkero.rotationPitch, -MathHelper.sin((float)Math.toRadians(yaw - 90F)), 0.0F, MathHelper.cos(
				(float)Math.toRadians(yaw - 90F)));
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);

		GL11.glScalef(0.5F, 0.5F, 0.5F);
		MODEL_MINI_HAKKERO.render(miniHakkero, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		Tessellator tessellator = Tessellator.instance;
		float[] constR = {255F, 255F, 255F, 0F, 0F, 76F, 128F};
		float[] constG = {0F, 165F, 255F, 128F, 0F, 0F, 0F};
		float[] constB = {0F, 0F, 0F, 0F, 255F, 130F, 128F};
		float uMin = 0F;
		float vMin = 0F;
		float uMax = 1F / 2F;
		float vMax = 1F / 4F;

		float angle = miniHakkero.getCircleAngle();
		float pi18 = (float)Math.PI / 9F;
		int c = miniHakkero.ticksExisted;
		GL11.glRotatef(MathHelper.sin(angle) / 3.141593F * 180F, 0.0F, 0.0F, 1.0F);
		for (int i = 0; i < 18; i++) {

			GL11.glRotatef(MathHelper.sin(pi18) / 3.141593F * 180F, 0.0F, 0.0F, 1.0F);
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(constR[c % 7] / 255F * 0.5F, constG[c % 7] / 255F * 0.5F, constB[c % 7] / 255F * 0.5F, 0.8F);
			tessellator.addVertexWithUV(0.77F, 4.5F, -6.0D, uMin, vMin);
			tessellator.addVertexWithUV(-0.77F, 4.5F, -6.0D, uMax, vMin);
			tessellator.addVertexWithUV(-0.77F, 4.5F, -4.0, uMax, vMax);
			tessellator.addVertexWithUV(0.77F, 4.5F, -4.0D, uMin, vMax);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(constR[c % 7] / 255F * 0.5F, constG[c % 7] / 255F * 0.5F, constB[c % 7] / 255F * 0.5F, 0.8F);
			tessellator.addVertexWithUV(-0.77F, 4.5F, -6.0D, uMin, vMin);
			tessellator.addVertexWithUV(0.77F, 4.5F, -6.0D, uMax, vMin);
			tessellator.addVertexWithUV(0.77F, 4.5F, -4.0D, uMax, vMax);
			tessellator.addVertexWithUV(-0.77F, 4.5F, -4.0D, uMin, vMax);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(constR[(c + 3) % 7] / 255F * 0.5F, constG[(c + 3) % 7] / 255F * 0.5F, constB[(c + 3) % 7] / 255F * 0.5F, 0.8F);
			tessellator.addVertexWithUV(1.11F, 6.5F, -12.0D, uMin, vMin);
			tessellator.addVertexWithUV(-1.11F, 6.5F, -12.0D, uMax, vMin);
			tessellator.addVertexWithUV(-1.11F, 6.5F, -10.0D, uMax, vMax);
			tessellator.addVertexWithUV(1.11F, 6.5F, -10.0D, uMin, vMax);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(constR[(c + 3) % 7] / 255F * 0.5F, constG[(c + 3) % 7] / 255F * 0.5F, constB[(c + 3) % 7] / 255F * 0.5F, 0.8F);
			tessellator.addVertexWithUV(-1.11F, 6.5F, -12.0D, uMin, vMin);
			tessellator.addVertexWithUV(1.11F, 6.5F, -12.0D, uMax, vMin);
			tessellator.addVertexWithUV(1.11F, 6.5F, -10.0D, uMax, vMax);
			tessellator.addVertexWithUV(-1.11F, 6.5F, -10.0D, uMin, vMax);
			tessellator.draw();
			angle += pi18;
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}


	public void renderMiniHakkero2(EntityMiniHakkeroJTG miniHakkero, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glRotated(miniHakkero.rotationPitch, -MathHelper.sin((float)Math.toRadians(yaw - 90F)), 0.0F, MathHelper.cos(
				(float)Math.toRadians(yaw - 90F)));
		GL11.glRotatef(180F - yaw, 0.0F, 1.0F, 0.0F);

		GL11.glScalef(0.5F, 0.5F, 0.5F);

		MODEL_MINI_HAKKERO2.render(miniHakkero, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return TEXTURE;
	}
}
