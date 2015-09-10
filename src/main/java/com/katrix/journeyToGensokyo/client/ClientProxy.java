/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.client;

import com.katrix.journeyToGensokyo.CommonProxy;
import com.katrix.journeyToGensokyo.client.render.RenderHellRaven;
import com.katrix.journeyToGensokyo.client.render.RenderSunFlowerFairyEnd;
import com.katrix.journeyToGensokyo.client.render.RenderTHFairyEnd;
import com.katrix.journeyToGensokyo.client.render.RenderTHFairyIce;
import com.katrix.journeyToGensokyo.client.render.RenderTHFairyNether;
import com.katrix.journeyToGensokyo.client.render.RenderTenguCrow;
import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
import com.katrix.journeyToGensokyo.thsc.entity.EntitySunFlowerFairyEnd;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyEnd;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyNether;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
       
        @Override
        public void registerRenderers() {

        	RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyIce.class, new RenderTHFairyIce());
        	RenderingRegistry.registerEntityRenderingHandler(EntityHellRaven.class, new RenderHellRaven());
        	RenderingRegistry.registerEntityRenderingHandler(EntityTenguCrow.class, new RenderTenguCrow());
        	RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyNether.class, new RenderTHFairyNether());
        	RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyEnd.class, new RenderTHFairyEnd());
        	RenderingRegistry.registerEntityRenderingHandler(EntitySunFlowerFairyEnd.class, new RenderSunFlowerFairyEnd());
        }
       
}