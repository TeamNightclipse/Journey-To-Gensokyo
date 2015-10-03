/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo;

import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.crafting.CraftingIC2Ore;
import katrix.journeyToGensokyo.crafting.CraftingTEOre;
import katrix.journeyToGensokyo.crafting.CraftingVanilla;
import katrix.journeyToGensokyo.handler.ChestGenHandler;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.handler.MissingMappingHandler;
import katrix.journeyToGensokyo.handler.OreDictionaryHandler;
import katrix.journeyToGensokyo.item.JTGItem;
import katrix.journeyToGensokyo.net.PacketHandler;
import katrix.journeyToGensokyo.reference.ModInfo;
import katrix.journeyToGensokyo.thaumcraft.JTGThaumcraft;
import katrix.journeyToGensokyo.thsc.JTG_THSC;
import katrix.journeyToGensokyo.util.LogHelper;
import katrix.journeyToGensokyo.worldgen.JTGWorldGen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
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
        	

        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
        	
        	OreDictionaryHandler.init();
        	
            proxy.registerRenderers();
        	
        	if(Loader.isModLoaded("ThermalExpansion") && ConfigHandler.OresEnabled) {
        		LogHelper.info("JTG adding IC2 Ore recipes");
                CraftingIC2Ore.init();
        	}
            CraftingVanilla.init();
            
        	if(ConfigHandler.NotesEnabled) {
        		LogHelper.warn("JTG Notes enabled, this is not a officialy suported feature");
        		ChestGenHandler.init();
        	}
        	
            JTGWorldGen.init();
            
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
    	
            JTG_THSC.postInit();
        	if(Loader.isModLoaded("Thaumcraft")) {
        		LogHelper.info("JTG adding Thaumcraft aspects");
            	JTGThaumcraft.postInit();
        	}
        }
        
        @EventHandler
        public void missingMappings(FMLMissingMappingsEvent event) {
        	//MissingMappingHandler.MissingMappings(event);
        }
}