/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelTenguCrow - Katrix Created using Tabula 4.1.1
 */
public class ModelTenguCrow extends ModelBase {

	public ModelRenderer tenguBody;
	public ModelRenderer tenguHead;
	public ModelRenderer tenguFootRight;
	public ModelRenderer tenguWingLeft;
	public ModelRenderer tenguFootLeft;
	public ModelRenderer tenguTail;
	public ModelRenderer tenguWingRight;
	public ModelRenderer tenguWingLeft2;
	public ModelRenderer tenguWingRight2;
	public ModelRenderer tenguBeak;
	public ModelRenderer tenguHat;

	public ModelTenguCrow() {
		textureWidth = 64;
		textureHeight = 64;
		tenguFootLeft = new ModelRenderer(this, 32, 32);
		tenguFootLeft.mirror = true;
		tenguFootLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguFootLeft.addBox(1.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
		tenguWingRight = new ModelRenderer(this, 34, 13);
		tenguWingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguWingRight.addBox(-16.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
		setRotateAngle(tenguWingRight, 0.0F, 0.7853981633974483F, 0.0F);
		tenguWingLeft2 = new ModelRenderer(this, 42, 0);
		tenguWingLeft2.mirror = true;
		tenguWingLeft2.setRotationPoint(14.0F, 4.0F, 0.0F);
		tenguWingLeft2.addBox(0.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
		setRotateAngle(tenguWingLeft2, 0.0F, -0.39269908169872414F, 0.0F);
		tenguBeak = new ModelRenderer(this, 32, 28);
		tenguBeak.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguBeak.addBox(-1.6F, -0.5F, -6.0F, 3, 2, 2, 0.0F);
		tenguWingLeft = new ModelRenderer(this, 34, 13);
		tenguWingLeft.mirror = true;
		tenguWingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguWingLeft.addBox(2.0F, 4.0F, 0.0F, 14, 14, 1, 0.0F);
		setRotateAngle(tenguWingLeft, 0.0F, -0.7853981633974483F, 0.0F);
		tenguTail = new ModelRenderer(this, 24, 0);
		tenguTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguTail.addBox(-3.0F, 19.0F, 1.0F, 6, 6, 1, 0.0F);
		setRotateAngle(tenguTail, 0.05235987755982988F, 0.0F, 0.0F);
		tenguHead = new ModelRenderer(this, 0, 0);
		tenguHead.setRotationPoint(0.0F, 8.0F, -8.0F);
		tenguHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		tenguHat = new ModelRenderer(this, 42, 28);
		tenguHat.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguHat.addBox(-2.0F, -7.0F, -2.0F, 4, 3, 4, 0.0F);
		tenguFootRight = new ModelRenderer(this, 32, 32);
		tenguFootRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		tenguFootRight.addBox(-3.0F, 16.0F, -5.5F, 2, 2, 3, 0.0F);
		tenguBody = new ModelRenderer(this, 0, 16);
		tenguBody.setRotationPoint(0.0F, 8.0F, -8.0F);
		tenguBody.addBox(-4.0F, 4.0F, -3.0F, 8, 16, 8, 0.0F);
		setRotateAngle(tenguBody, 1.1971213339429108F, 0.0F, 0.0F);
		tenguWingRight2 = new ModelRenderer(this, 42, 0);
		tenguWingRight2.setRotationPoint(-14.0F, 4.0F, 0.0F);
		tenguWingRight2.addBox(-10.0F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
		setRotateAngle(tenguWingRight2, 0.0F, 0.39269908169872414F, 0.0F);
		tenguBody.addChild(tenguFootLeft);
		tenguBody.addChild(tenguWingRight);
		tenguWingLeft.addChild(tenguWingLeft2);
		tenguHead.addChild(tenguBeak);
		tenguBody.addChild(tenguWingLeft);
		tenguBody.addChild(tenguTail);
		tenguHead.addChild(tenguHat);
		tenguBody.addChild(tenguFootRight);
		tenguWingRight.addChild(tenguWingRight2);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		super.render(entity, movement, far, tick, yaw, pitch, size);
		setRotationAngles(movement, far, tick, yaw, pitch, size, entity);

		tenguBody.render(size);
		tenguHead.render(size);
	}

	@Override
	public void setRotationAngles(float movement, float far, float tick, float yaw, float pitch, float size, Entity entity) {
		super.setRotationAngles(movement, far, tick, yaw, pitch, size, entity);
		tenguHead.rotateAngleY = yaw / (180F / (float)Math.PI);
		tenguHead.rotateAngleX = pitch / (180F / (float)Math.PI);
		tenguBody.rotateAngleX = (float)Math.PI / 3F + MathHelper.cos(tick * 0.1F) * 0.15F;
		tenguWingRight.rotateAngleY = MathHelper.cos(tick * 0.8F) * (float)Math.PI * 0.25F;
		tenguWingLeft.rotateAngleY = -tenguWingRight.rotateAngleY;
		tenguWingRight2.rotateAngleY = tenguWingRight.rotateAngleY * 0.5F;
		tenguWingLeft2.rotateAngleY = -tenguWingRight.rotateAngleY * 0.5F;
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
