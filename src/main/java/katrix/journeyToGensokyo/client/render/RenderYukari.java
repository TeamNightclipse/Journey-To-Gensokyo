/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.render;

import katrix.journeyToGensokyo.client.model.ModelYukari;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import katrix.journeyToGensokyo.util.LogHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import thKaguyaMod.entity.living.EntityRumia;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderYukari extends RenderTHBoss
{
	
	ResourceLocation texture = new ResourceLocation("journeytogensokyo", "textures/entity/mob/yukari.png");
	ResourceLocation shieldTexture = new ResourceLocation("journeytogensokyo", "textures/misc/shieldTexture.png");

    public RenderYukari()
    {
        super(new ModelYukari(), 0.25F);
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch)
    {
    	super.doRender(entity, x, y, z, yaw, pitch);
    	this.renderYukari((EntityYukari)entity, x, y, z, yaw, pitch);
    }
	
	public void renderYukari(EntityYukari yukari, double x, double y, double z, float yaw, float pitch)
	{
		if(yukari.invicibilityTimer > 0){
			GL11.glPushMatrix();
        	GL11.glDisable(GL11.GL_CULL_FACE);
        	GL11.glTranslatef((float)x, (float)y, (float)z);
    	
        	Tessellator tessellator = Tessellator.instance;
        	GL11.glDepthMask(false);
        	GL11.glEnable(GL11.GL_BLEND);
        
    		GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
    		GL11.glTranslatef(0.0F, 1.2F, 0.0F);
    		GL11.glRotatef(90F, 1F, 0F, 0F);
    		this.bindTexture(shieldTexture);
    		renderDark(tessellator, 2.8F, 0.0D, yukari.invicibilityTimer, 0);
    		GL11.glDisable(GL11.GL_BLEND);
    	
    		GL11.glEnable(GL11.GL_CULL_FACE);//表綿描画
    		GL11.glDepthMask(true);
    		GL11.glPopMatrix();
		}
	}
	
	protected void renderDark(Tessellator tessellator, float width, double zPos, int alpha, int time)
	{
		
		float maxWidth = (float)width / 2.0F;
		
    	int zAngleDivNum = 16;
    	double angleZ = 0F;
    	double angleSpanZ = Math.PI * 2.0D / (double)zAngleDivNum;
    	
    	int zDivNum = 16;
    	zPos = Math.sin(-Math.PI / 2.0D) * maxWidth;
    	double zPosOld = zPos;
    	float xPos = 0F;
    	float yPos = 0F;
    	float xPos2 = 0F;
    	float yPos2 = 0F;
    	float xPosOld = xPos;
    	float yPosOld = yPos;
    	float xPos2Old = xPos2;
    	float yPos2Old = yPos2;
    	float angle = -(float)Math.PI / 2.0F;
    	float angleSpan = (float)Math.PI / (float)(zDivNum);
    	angle += angleSpan;
    	float widthOld = 0.0F;
    	
		for(int j = 0; j < zDivNum; j++)
		{
			zPos = Math.sin(angle) * maxWidth;
    		width = (float)Math.cos(angle) * maxWidth;
    		
    		xPos = width;
    		yPos = 0F;//(float)width;
    		angleZ = 0F;
    		xPosOld = (float)Math.cos(angleZ) * width;
			yPosOld = (float)Math.sin(angleZ) * width;
			xPos2Old = (float)Math.cos(angleZ) * widthOld;
			yPos2Old = (float)Math.sin(angleZ) * widthOld;
    		angleZ = angleSpanZ;
    		
    		for(int i = 1; i <= zAngleDivNum; i++)
    		{
	    		xPos = (float)Math.cos(angleZ) * width;
	    		yPos = (float)Math.sin(angleZ) * width;
	    		xPos2 = (float)Math.cos(angleZ) * widthOld;
	    		yPos2 = (float)Math.sin(angleZ) * widthOld;
	    		
    			tessellator.startDrawingQuads();
	    		tessellator.setColorRGBA_F(0.0F, 1.0F, 0.0F , 1.0F);
	    		tessellator.setBrightness(alpha*6);
	    		tessellator.setNormal(0.0F, 1.0F, 0.0F);
	    		tessellator.addVertexWithUV(  xPos    , yPos    , zPos   , 1.0F, 0.0F);
	    		tessellator.addVertexWithUV(  xPosOld , yPosOld , zPos   , 0.0F, 0.0F);
	    		tessellator.addVertexWithUV(  xPos2Old, yPos2Old, zPosOld, 0.0F, 1.0F);
	        	tessellator.addVertexWithUV(  xPos2   , yPos2   , zPosOld, 1.0F, 1.0F);
	        	
	    		tessellator.draw();
    			
    			xPosOld = xPos;
    			yPosOld = yPos;
    			xPos2Old = xPos2;
    			yPos2Old = yPos2;
    			angleZ += angleSpanZ;
    			
    		}
    		zPosOld = zPos;
    		angle += angleSpan;
    		widthOld = width;
    		
    	}
	}

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityYukari)entity);
    }
    
    protected ResourceLocation getEntityTexture(EntityYukari entity)
    {
    	return texture;
    }
}