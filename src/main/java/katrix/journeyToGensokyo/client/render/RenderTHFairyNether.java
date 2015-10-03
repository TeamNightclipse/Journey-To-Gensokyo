/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import katrix.journeyToGensokyo.client.model.ModelTHFairyJTG;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.entity.living.EntityTHFairy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTHFairyNether extends RenderLiving
{	
	
    public RenderTHFairyNether()
    {
        super(new ModelTHFairyJTG(), 0.25F);
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch)
    {
    	super.doRender(entity, x, y, z, yaw, pitch);
    	this.render((EntityTHFairy)entity, x, y, z, yaw, pitch);
    	
    }

	public void render(EntityTHFairy entity, double x, double y, double z, float yaw, float pitch)
	{
	}
	
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityTHFairy)entity);
    }
    
    protected ResourceLocation getEntityTexture(EntityTHFairy thFairy)
    {
    	ResourceLocation resourceLocation;
    	if(thFairy.getForm() >= 0)
    	{
    		resourceLocation = new ResourceLocation("thkaguyamod", "textures/mob/FairyTexture_0.png");
    	}
    	else
    	{
    		resourceLocation = new ResourceLocation("thkaguyamod", "textures/mob/ZombieFairyTexture.png");
    	}
    	
        return resourceLocation;
    }
}
