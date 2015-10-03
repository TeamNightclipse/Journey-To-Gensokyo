/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.client.gui;

import java.util.ArrayList;
import java.util.List;

import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.reference.ConfigRef;
import katrix.journeyToGensokyo.reference.ModInfo;
import katrix.journeyToGensokyo.util.LogHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.ConfigGuiType;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class JTGGuiConfig extends GuiConfig {

	public JTGGuiConfig(GuiScreen parentScreen) {
		
		super(parentScreen,
				getConfigList(),
				ModInfo.MODID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.cfg.toString()));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<IConfigElement> getConfigList() {
		
		List<IConfigElement> list = new ArrayList();
		list.addAll(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigRef.CAT_ENTITYID)).getChildElements());
		list.addAll(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigRef.CAT_RTY)).getChildElements());
        list.add(new DummyConfigElement<String>("broken", "JTG in game config is currently broken", ConfigGuiType.STRING, "jtg.gui.config.is.broken"));
		
		LogHelper.info("Config Suff: " + list);
		
		return list;
	}
}
