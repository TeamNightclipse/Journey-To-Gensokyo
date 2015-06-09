package com.katrix.journeyToGensokyo.client;

import com.katrix.journeyToGensokyo.CommonProxy;
import com.katrix.journeyToGensokyo.client.render.RenderHellRaven;
import com.katrix.journeyToGensokyo.client.render.RenderTHFairyIce;
import com.katrix.journeyToGensokyo.client.render.RenderTHFairyNether;
import com.katrix.journeyToGensokyo.client.render.RenderTenguCrow;
import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
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
        }
       
}