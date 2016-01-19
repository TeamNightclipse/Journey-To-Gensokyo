/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelHellRaven - Katrix Created using Tabula 4.1.1
 */

@SideOnly(Side.CLIENT)
public class ModelHellRaven extends ModelBase {

	public ModelRenderer ravenBody;
	public ModelRenderer ravenWingRight;
	public ModelRenderer ravenWingLeft;
	public ModelRenderer ravenTail;
	public ModelRenderer ravenHead;
	public ModelRenderer ravenWingRight2;
	public ModelRenderer ravenWingleft2;
	public ModelRenderer ravenFootRight;
	public ModelRenderer ravenFootLeft;
	public ModelRenderer ravenBeak;

	public ModelHellRaven() {
		textureWidth = 64;
		textureHeight = 64;
		ravenWingleft2 = new ModelRenderer(this, 42, 0);
		ravenWingleft2.mirror = true;
		ravenWingleft2.setRotationPoint(14.0F, 4.0F, 0.0F);
		ravenWingleft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
		setRotateAngle(ravenWingleft2, 0.0F, -0.31154127148098787F, 0.0F);
		ravenFootRight = new ModelRenderer(this, 32, 32);
		ravenFootRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
		ravenBeak = new ModelRenderer(this, 32, 28);
		ravenBeak.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F);
		ravenWingRight2 = new ModelRenderer(this, 42, 0);
		ravenWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F);
		ravenWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
		setRotateAngle(ravenWingRight2, 0.0F, 0.31154127148098787F, 0.0F);
		ravenWingLeft = new ModelRenderer(this, 34, 13);
		ravenWingLeft.mirror = true;
		ravenWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
		setRotateAngle(ravenWingLeft, 0.0F, -0.6108652381980153F, 0.0F);
		ravenFootLeft = new ModelRenderer(this, 32, 32);
		ravenFootLeft.mirror = true;
		ravenFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
		ravenBody = new ModelRenderer(this, 0, 16);
		ravenBody.setRotationPoint(0.0F, 8.0F, -8.0F);
		ravenBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F);
		setRotateAngle(ravenBody, 1.3089969389957472F, 0.0F, 0.0F);
		ravenTail = new ModelRenderer(this, 24, 0);
		ravenTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F);
		setRotateAngle(ravenTail, 0.05235987755982988F, 0.0F, 0.0F);
		ravenWingRight = new ModelRenderer(this, 34, 13);
		ravenWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		ravenWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
		setRotateAngle(ravenWingRight, 0.0F, 0.6108652381980153F, 0.0F);
		ravenHead = new ModelRenderer(this, 0, 0);
		ravenHead.setRotationPoint(0.0F, 8.0F, -8.0F);
		ravenHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		ravenWingLeft.addChild(ravenWingleft2);
		ravenBody.addChild(ravenFootRight);
		ravenHead.addChild(ravenBeak);
		ravenWingRight.addChild(ravenWingRight2);
		ravenBody.addChild(ravenWingLeft);
		ravenBody.addChild(ravenFootLeft);
		ravenBody.addChild(ravenTail);
		ravenBody.addChild(ravenWingRight);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		super.render(entity, movement, far, tick, yaw, pitch, size);
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

		ravenBody.render(size);
		ravenHead.render(size);
	}

	@SuppressWarnings("unused")
	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		ravenHead.rotateAngleY = yaw / (180F / (float)Math.PI);
		ravenHead.rotateAngleX = pitch / (180F / (float)Math.PI);
		ravenBody.rotateAngleX = (float)Math.PI / 3F + MathHelper.cos(tick * 0.1F) * 0.15F;
		ravenWingRight.rotateAngleY = MathHelper.cos(tick * 0.8F) * (float)Math.PI * 0.25F;
		ravenWingLeft.rotateAngleY = -ravenWingRight.rotateAngleY;
		ravenWingRight2.rotateAngleY = ravenWingRight.rotateAngleY * 0.5F;
		ravenWingleft2.rotateAngleY = -ravenWingRight.rotateAngleY * 0.5F;
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
