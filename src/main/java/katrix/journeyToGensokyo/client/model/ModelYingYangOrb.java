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

/**
 * YingYang - Katrix
 * Created using Tabula 4.1.1
 */
public class ModelYingYangOrb extends ModelBase {
    public ModelRenderer YingYangOrb;

    public ModelYingYangOrb() {
        this.textureWidth = 48;
        this.textureHeight = 24;
        this.YingYangOrb = new ModelRenderer(this, 0, 0);
        this.YingYangOrb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.YingYangOrb.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.YingYangOrb.render(f5);
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
