/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import katrix.journeyToGensokyo.plugin.thsc.entity.EntityReimuHostile;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.client.model.living.ModelReimu;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderReimuHostile extends RenderTHBoss
{
	
	ResourceLocation texture = new ResourceLocation("thkaguyamod", "textures/mob/ReimuTexture.png");

    public RenderReimuHostile()
    {
        super(new ModelReimu(), 0.25F);
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch)
    {
    	super.doRender(entity, x, y, z, yaw, pitch);
    	this.render((EntityReimuHostile)entity, x, y, z, yaw, pitch);
    	
    }

	public void render(EntityReimuHostile entity, double x, double y, double z, float yaw, float pitch)
	{
	}

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityReimuHostile)entity);
    }
    
    protected ResourceLocation getEntityTexture(EntityReimuHostile entity)
    {
    	return texture;
    }
}