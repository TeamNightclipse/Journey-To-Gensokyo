/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.render.model

import net.minecraft.client.model.{ModelBase, ModelRenderer}
import net.minecraft.entity.Entity
import net.minecraft.util.math.MathHelper

//Yes, this placeholder is a creeper
object ModelFairy extends ModelBase {

	val head         = new ModelRenderer(this, 0, 0)
	val creeperArmor = new ModelRenderer(this, 32, 0)
	val body         = new ModelRenderer(this, 16, 16)
	val leg1         = new ModelRenderer(this, 0, 16)
	val leg2         = new ModelRenderer(this, 0, 16)
	val leg3         = new ModelRenderer(this, 0, 16)
	val leg4         = new ModelRenderer(this, 0, 16)

	val i    = 6
	val size = 0.5F
	head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, size)
	head.setRotationPoint(0.0F, i, 0.0F)
	creeperArmor.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, size + 0.5F)
	creeperArmor.setRotationPoint(0.0F, i, 0.0F)
	body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, size)
	body.setRotationPoint(0.0F, i, 0.0F)
	leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, size)
	leg1.setRotationPoint(-2.0F, 12 + i, 4.0F)
	leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, size)
	leg2.setRotationPoint(2.0F, 12 + i, 4.0F)
	leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, size)
	leg3.setRotationPoint(-2.0F, 12 + i, -4.0F)
	leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, size)
	leg4.setRotationPoint(2.0F, 12 + i, -4.0F)

	override def render(entity: Entity, limbSwing: Float, limbSwingAmount: Float, age: Float, headYaw: Float, headPitch: Float, scale: Float): Unit = {
		setRotationAngles(limbSwing, limbSwingAmount, age, headYaw, headPitch, scale, entity)
		head.render(scale)
		body.render(scale)
		leg1.render(scale)
		leg2.render(scale)
		leg3.render(scale)
		leg4.render(scale)
	}

	override def setRotationAngles(limbSwing: Float, limbSwingAmount: Float, age: Float, headYaw: Float, headPitch: Float, scale: Float,
			entity: Entity): Unit = {
		head.rotateAngleY = headYaw * 0.017453292F
		head.rotateAngleX = headPitch * 0.017453292F
		leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount
		leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 1.4F * limbSwingAmount
		leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + Math.PI.toFloat) * 1.4F * limbSwingAmount
		leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount
	}
}