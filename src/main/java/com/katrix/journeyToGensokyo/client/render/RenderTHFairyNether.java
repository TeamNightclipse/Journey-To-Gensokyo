package com.katrix.journeyToGensokyo.client.render;

import com.katrix.journeyToGensokyo.client.model.ModelTHFairyNether;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.entity.living.EntityTHFairy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/** å¦–ç²¾ã‚’æ��ç”»ã�™ã‚‹ */
@SideOnly(Side.CLIENT)
public class RenderTHFairyNether extends RenderLiving
{	
	
    public RenderTHFairyNether()
    {
        super(new ModelTHFairyNether(), 0.25F);
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
