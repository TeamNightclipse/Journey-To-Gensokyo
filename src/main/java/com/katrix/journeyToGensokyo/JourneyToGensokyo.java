/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo;

import com.katrix.journeyToGensokyo.net.PacketHandler;
import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.crafting.IC2OreCrafting;
import com.katrix.journeyToGensokyo.crafting.TEOreCrafting;
import com.katrix.journeyToGensokyo.crafting.VanillaCrafting;
import com.katrix.journeyToGensokyo.handler.ConfigHandler;
import com.katrix.journeyToGensokyo.item.JTGItem;
import com.katrix.journeyToGensokyo.thaumcraft.JTGThaumcraft;
import com.katrix.journeyToGensokyo.thsc.JTG_THSC;
import com.katrix.journeyToGensokyo.util.LogHelper;
import com.katrix.journeyToGensokyo.worldgen.ChestGen;
import com.katrix.journeyToGensokyo.worldgen.JTGWorldGen;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = ModInfo.MODID, 
		name = ModInfo.NAME, 
		version = ModInfo.VERSION,
		guiFactory = ModInfo.GUI_FACTORY_CLASS,
		dependencies  = "required-after:THKaguyaMod;"
				+ "after:Thaumcraft;"
				+ "after:IC2;"
				+ "after:Botania;"
				+ "after:ThermalExpansion;"
				+ "after:AdvancedSolarPanel")

public class JourneyToGensokyo {

        @Instance(value = "journeyToGensokyo")
        public static JourneyToGensokyo instance;
       
        @SidedProxy(clientSide=ModInfo.CLIENT_PROXY_CLASS, serverSide=ModInfo.SERVER_PROXY_CLASS)
        public static CommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	
    		ConfigHandler.setConfig(event.getSuggestedConfigurationFile());
        	
            PacketHandler.preInit();
        	
        	JTGItem.preInit();
        	JTGBlock.preInit();
        	JTG_THSC.preInit();
        	
        	if(ConfigHandler.NotesEnabled) {
        		LogHelper.warn("JTG Notes enabled, this is not a officialy suported feature");
        		ChestGen.preInit();
        	}
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
        	
            proxy.registerRenderers();
            
        	if(Loader.isModLoaded("ThermalExpansion") && ConfigHandler.OresEnabled) {
        		LogHelper.info("JTG adding TE Ore recipes");
        		TEOreCrafting.init();
        	}
        	
        	if(Loader.isModLoaded("ThermalExpansion") && ConfigHandler.OresEnabled) {
        		LogHelper.info("JTG adding IC2 Ore recipes");
                IC2OreCrafting.init();
        	}
            VanillaCrafting.init();
            JTGWorldGen.init();
            JTG_THSC.init();
            
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
    	
        	if(Loader.isModLoaded("Thaumcraft")) {
        		LogHelper.info("JTG adding Thaumcraft aspects");
            	JTGThaumcraft.postInit();
        	}
        }
}