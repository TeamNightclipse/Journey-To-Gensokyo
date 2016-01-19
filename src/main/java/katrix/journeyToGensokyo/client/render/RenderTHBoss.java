/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod.. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;

@SideOnly(Side.CLIENT)
public abstract class RenderTHBoss extends RenderLiving {

	ResourceLocation statusTexture = new ResourceLocation("thkaguyamod", "textures/mob/Status.png");

	public RenderTHBoss(ModelBase model, float size) {
		super(model, size);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		super.doRender(entity, x, y, z, yaw, pitch);
		if (entity instanceof EntityYukari) {
			EntityYukari yukari = (EntityYukari)entity;

			if (yukari.getIsAgressive() == 1) {
				if (ConfigHandler.newHealthBar) {

					int divider = 8;
					int resolution = divider * 2;

					for (int i = 0; i < resolution; i++) {
						renderCircleHealth((EntityDanmakuMob)entity, x, y, z, yaw, pitch, i, resolution);
					}

					renderName((EntityDanmakuMob)entity, x, y, z, yaw, pitch);
				}
				else {
					renderTHBossStatus((EntityDanmakuMob)entity, x, y, z, yaw, pitch);
				}
			}
		}
	}

	public void renderTHBossStatus(EntityDanmakuMob danmakuMob, double x, double y, double z, float yaw, float pitch) {
		if (danmakuMob.getDanmakuPattern() == EntityDanmakuMob.NOT_ATTACK)
			return;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		Tessellator tessellator = Tessellator.instance;
		float viewY = renderManager.playerViewY % 360F;
		if (viewY > 180F) {
			viewY -= 360F;
		}
		else if (viewY <= -180) {
			viewY += 360F;
		}
		Vec3 look = THShotLib.getVecFromAngle(viewY, renderManager.playerViewX);
		Vec3 toEntity = Vec3.createVectorHelper(x, y, z);
		float span = THShotLib.getVectorAndVectorAngle(look, toEntity);
		float alpha = 1F - (Math.abs(span) - 20F) / 30F;

		double distance = renderManager.getDistanceToCamera(danmakuMob.posX, danmakuMob.posY, danmakuMob.posZ);
		float size = 1.0F + (float)distance / 64F;
		if (size > 5.0F) {
			size = 5.0F;
		}

		if (Math.abs(span) <= 70F) {
			GL11.glTranslatef((float)x, (float)y + danmakuMob.height + 1.5F, (float)z);
			GL11.glScalef(1.0F * size, 1.0F * size, 1.0F * size);



			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

			bindTexture(statusTexture);
			int cardNo = danmakuMob.getUsingSpellCardNo();

			float hp = danmakuMob.getHealth() / danmakuMob.getMaxHealth();
			float hp2 = danmakuMob.getHealth() / danmakuMob.getMaxHealth() * 2.0F - 1.0F;

			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-1.02F, 0.07F, 0.001D, 0.0F, 3F / 16F);
			tessellator.addVertexWithUV(1.02F, 0.07F, 0.001D, 1.0F, 3F / 16F);
			tessellator.addVertexWithUV(1.02F, -0.02F, 0.001D, 1.0F, 4F / 16F);
			tessellator.addVertexWithUV(-1.02F, -0.02F, 0.001D, 0.0F, 4F / 16F);

			tessellator.draw();

			if (cardNo >= 0) {
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(-hp2, 0.05F, 0.0D, hp, 8F / 16F);
				tessellator.addVertexWithUV(1.0F, 0.05F, 0.0D, 0.0F, 8F / 16F);
				tessellator.addVertexWithUV(1.0F, 0.00F, 0.0D, 0.0F, 11F / 16F);
				tessellator.addVertexWithUV(-hp2, 0.00F, 0.0D, hp, 11F / 16F);

				tessellator.draw();
			}
			else {
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(-hp2, 0.05F, 0.0D, hp / 2, 0F / 16F);
				tessellator.addVertexWithUV(1.0F, 0.05F, 0.0D, 0.0F, 0F / 16F);
				tessellator.addVertexWithUV(1.0F, 0.00F, 0.0D, 0.0F, 3F / 16F);
				tessellator.addVertexWithUV(-hp2, 0.00F, 0.0D, hp / 2, 3F / 16F);

				tessellator.draw();
			}

			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glScalef(0.02F, 0.02F, 0.02F);
			tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, alpha);
			FontRenderer font = getFontRendererFromRenderManager();
			font.drawStringWithShadow(danmakuMob.getDanmakuMobName(), -50, 0, 0x00FF88);

			if (cardNo >= 0) {
				tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, alpha);
				font.drawStringWithShadow(StatCollector.translateToLocal("item.thSpellCard." + cardNo + ".name"), -50, -12, 0xFFFFFF);
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public void renderCircleHealth(EntityDanmakuMob danmakuMob, double x, double y, double z, float yaw, float pitch, int i, int resolution) {
		if (danmakuMob.getDanmakuPattern() == EntityDanmakuMob.NOT_ATTACK)
			return;

		float size = 6F;
		float length = size / resolution;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);


		Tessellator tessellator = Tessellator.instance;
		float viewY = renderManager.playerViewY % 360F;
		if (viewY > 180F) {
			viewY -= 360F;
		}
		else if (viewY <= -180) {
			viewY += 360F;
		}
		Vec3 look = THShotLib.getVecFromAngle(viewY, renderManager.playerViewX);
		Vec3 toEntity = Vec3.createVectorHelper(x, y, z);
		float span = THShotLib.getVectorAndVectorAngle(look, toEntity);

		if (Math.abs(span) <= 70F) {
			GL11.glTranslatef((float)x, (float)y + danmakuMob.height - 0.5F, (float)z);

			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(i * -(360F / resolution), 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(0F, size * 0.3F, 0F);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

			bindTexture(statusTexture);
			int cardNo = danmakuMob.getUsingSpellCardNo();

			float hp = danmakuMob.getHealth() / danmakuMob.getMaxHealth();
			float hp2;

			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-length, 0.15F, 0.001D, 0.0F, 3F / 16F);
			tessellator.addVertexWithUV(length, 0.15F, 0.001D, 1.0F, 3F / 16F);
			tessellator.addVertexWithUV(length, 0.0F, 0.001D, 1.0F, 4F / 16F);
			tessellator.addVertexWithUV(-length, 0.0F, 0.001D, 0.0F, 4F / 16F);

			tessellator.draw();

			if (i < hp * resolution) {
				if (i + 1 == MathHelper.ceiling_float_int(hp * resolution)) {
					hp2 = (hp - 1F / resolution * i) * resolution * length * 2 - length;
				}
				else {
					hp2 = length;
				}

				if (cardNo >= 0) {
					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV(-hp2, 0.12F, 0.0D, 0.0F, 8F / 16F);
					tessellator.addVertexWithUV(length, 0.12F, 0.0D, 0.0F, 8F / 16F);
					tessellator.addVertexWithUV(length, 0.03F, 0.0D, 0.0F, 11F / 16F);
					tessellator.addVertexWithUV(-hp2, 0.03F, 0.0D, 0.0F, 11F / 16F);

					tessellator.draw();
				}
				else {
					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV(-hp2, 0.12F, 0.0D, 0.0F, 0F / 16F);
					tessellator.addVertexWithUV(length, 0.12F, 0.0D, 0.0F, 0F / 16F);
					tessellator.addVertexWithUV(length, 0.03F, 0.0D, 0.0F, 3F / 16F);
					tessellator.addVertexWithUV(-hp2, 0.03F, 0.0D, 0.0F, 3F / 16F);

					tessellator.draw();
				}
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public void renderName(EntityDanmakuMob danmakuMob, double x, double y, double z, float yaw, float pitch) {
		if (danmakuMob.getDanmakuPattern() == EntityDanmakuMob.NOT_ATTACK)
			return;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		Tessellator tessellator = Tessellator.instance;
		float viewY = renderManager.playerViewY % 360F;
		if (viewY > 180F) {
			viewY -= 360F;
		}
		else if (viewY <= -180) {
			viewY += 360F;
		}
		Vec3 look = THShotLib.getVecFromAngle(viewY, renderManager.playerViewX);
		Vec3 toEntity = Vec3.createVectorHelper(x, y, z);
		float span = THShotLib.getVectorAndVectorAngle(look, toEntity);
		float alpha = 1F - (Math.abs(span) - 20F) / 30F;

		double distance = renderManager.getDistanceToCamera(danmakuMob.posX, danmakuMob.posY, danmakuMob.posZ);
		float size = 1.0F + (float)distance / 64F;
		if (size > 5.0F) {
			size = 5.0F;
		}

		if (Math.abs(span) <= 70F) {
			GL11.glTranslatef((float)x, (float)y + danmakuMob.height + 1.5F, (float)z);

			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

			GL11.glTranslatef(1.05F, 0.0F, 0.0F);

			int cardNo = danmakuMob.getUsingSpellCardNo();

			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glScalef(0.03F, 0.03F, 0.03F);
			tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, alpha);
			FontRenderer font = getFontRendererFromRenderManager();
			font.setBidiFlag(true);
			font.drawStringWithShadow(danmakuMob.getDanmakuMobName(), 0, 25, 0x00FF88);

			if (cardNo >= 0) {
				tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, alpha);
				font.drawStringWithShadow(StatCollector.translateToLocal("item.thSpellCard." + cardNo + ".name"),
						-font.getStringWidth(StatCollector.translateToLocal("item.thSpellCard." + cardNo + ".name")) / 4, -8, 0xFFFFFF);
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityDanmakuMob)entity);
	}

	protected ResourceLocation getEntityTexture(EntityDanmakuMob danmakuMob) {
		return statusTexture;
	}
}