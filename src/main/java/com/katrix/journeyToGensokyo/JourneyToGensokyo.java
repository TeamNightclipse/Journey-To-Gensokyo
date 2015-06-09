package com.katrix.journeyToGensokyo;

import com.katrix.journeyToGensokyo.net.PacketHandler;
import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.crafting.IC2OreCrafting;
import com.katrix.journeyToGensokyo.crafting.TEOreCrafting;
import com.katrix.journeyToGensokyo.crafting.VanillaCrafting;
import com.katrix.journeyToGensokyo.item.JTGItem;
import com.katrix.journeyToGensokyo.thaumcraft.JTGThaumcraft;
import com.katrix.journeyToGensokyo.thsc.JTG_THSC;
import com.katrix.journeyToGensokyo.worldgen.ChestGen;
import com.katrix.journeyToGensokyo.worldgen.JTGWorldGen;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= ModInfo.MODID, name= ModInfo.NAME, version= ModInfo.VERSION, dependencies  = "required-after:THKaguyaMod;"
		+ "after:Thaumcraft;"
		+ "after:IC2;"
		+ "after:Botania;"
		+ "after:ThermalExpansion;"
		+ "after:AdvancedSolarPanel")

public class JourneyToGensokyo {

        // The instance of your mod that Forge uses.
        @Instance(value = "journeyToGensokyo")
        public static JourneyToGensokyo instance;
       
        @SidedProxy(clientSide="com.katrix.journeyToGensokyo.client.ClientProxy", serverSide="com.katrix.journeyToGensokyo.CommonProxy")
        public static CommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	
    		Config.setConfig(event);
        	
            PacketHandler.preInit();
        	
        	JTGItem.preInit();
        	JTGBlock.preInit();
        	JTG_THSC.preInit();
        	
        	if(Config.NotesEnabled) {
        		ChestGen.preInit();
        	}
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
        	
            proxy.registerRenderers();
            
        	if(Loader.isModLoaded("ThermalExpansion") && Config.OresEnabled) {
        		TEOreCrafting.init();
        	}
        	
        	if(Loader.isModLoaded("ThermalExpansion") && Config.OresEnabled) {
                IC2OreCrafting.init();
        	}
            VanillaCrafting.init();
            JTGWorldGen.init();
            JTG_THSC.init();
            
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
    	
        	if(Loader.isModLoaded("Thaumcraft")) {
            	JTGThaumcraft.postInit();
        	}
        }
}