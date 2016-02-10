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

public class ModelYingYangOrb extends ModelBase {

	public ModelRenderer yinYangOrb;

	public ModelYingYangOrb() {
		textureWidth = 48;
		textureHeight = 24;
		yinYangOrb = new ModelRenderer(this, 0, 0);
		yinYangOrb.setRotationPoint(0.0F, 0.0F, 0.0F);
		yinYangOrb.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F);
	}

	@Override
	public void render(Entity entity, float movement, float far, float tick, float yaw, float pitch, float size) {
		yinYangOrb.render(size);
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
