/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.handler.ChestGenHandler;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.handler.OreDictionaryHandler;
import katrix.journeyToGensokyo.item.JTGItem;
import katrix.journeyToGensokyo.item.crafting.CraftingIC2;
import katrix.journeyToGensokyo.item.crafting.CraftingVanilla;
import katrix.journeyToGensokyo.lib.LibMod;
import katrix.journeyToGensokyo.net.PacketHandler;
import katrix.journeyToGensokyo.plugin.botania.JTGBotania;
import katrix.journeyToGensokyo.plugin.thaumcraft.JTGThaumcraft;
import katrix.journeyToGensokyo.plugin.thsc.JTG_THSC;
import katrix.journeyToGensokyo.util.LogHelper;
import katrix.journeyToGensokyo.worldgen.JTGWorldGen;

@Mod(modid = LibMod.MODID, name = LibMod.NAME, version = LibMod.VERSION, guiFactory = LibMod.GUI_FACTORY_CLASS, dependencies = "required-after:THKaguyaMod;"
		+ "after:Thaumcraft;" + "after:IC2;" + "after:Botania;" + "after:ThermalExpansion;" + "after:AdvancedSolarPanel")

public class JourneyToGensokyo {

	public static boolean IC2Installed; 
	public static boolean thaumcraftInstalled;
	public static boolean botaniaInstalled;

	@Instance
	public static JourneyToGensokyo instance;

	@SidedProxy(clientSide = LibMod.CLIENT_PROXY_CLASS, serverSide = LibMod.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ConfigHandler.setConfig(event.getSuggestedConfigurationFile());
		
		IC2Installed = Loader.isModLoaded("IC2");
		thaumcraftInstalled = Loader.isModLoaded("Thaumcraft");
		botaniaInstalled = Loader.isModLoaded("Botania");

		PacketHandler.preInit();

		JTGItem.preInit();
		JTGBlock.preInit();
		JTG_THSC.preInit();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		OreDictionaryHandler.init();

		proxy.registerRenderers();

		if (IC2Installed && ConfigHandler.OresEnabled) {
			LogHelper.info("JTG adding IC2 Ore recipes");
			CraftingIC2.init();
		}
		
		CraftingVanilla.misc();
		CraftingVanilla.smelting();
		CraftingVanilla.notes();

		if (ConfigHandler.NotesEnabled) {
			LogHelper.warn("JTG Notes enabled, this is not a officialy suported feature");
			ChestGenHandler.init();
		}

		if (botaniaInstalled) {
			JTGBotania.init();
		}

		JTGWorldGen.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		JTG_THSC.postInit();
		if (thaumcraftInstalled) {
			LogHelper.info("JTG adding Thaumcraft aspects");
			JTGThaumcraft.postInit();
		}
	}
}