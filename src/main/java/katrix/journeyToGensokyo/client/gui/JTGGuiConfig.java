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

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

public class JTGGuiConfig extends GuiConfig {

	public JTGGuiConfig(GuiScreen parentScreen) {

		super(parentScreen, getConfigList(), LibMod.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.cfg.toString()));
	}

	@SuppressWarnings("rawtypes")
	public static List<IConfigElement> getConfigList() {

		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigHandler.MOBS.toLowerCase())));
		list.add(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigHandler.MISC.toLowerCase())));
		list.add(new ConfigElement(ConfigHandler.cfg.getCategory(ConfigHandler.RTY.toLowerCase())));

		return list;
	}
}
