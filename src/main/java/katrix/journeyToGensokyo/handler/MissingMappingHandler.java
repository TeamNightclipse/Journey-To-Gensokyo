/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.handler;

import java.util.List;

import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import cpw.mods.fml.common.registry.GameRegistry.Type;
import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.item.JTGItem;
import katrix.journeyToGensokyo.reference.ModInfo;
import katrix.journeyToGensokyo.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MissingMappingHandler {

	public static void MissingMappings(FMLMissingMappingsEvent event) {
		List<MissingMapping> mappings = event.get();
		for (MissingMapping mapping : mappings) {
			if (mapping.type == Type.ITEM) {
				remapItem(mapping, compareItem(mapping));
			}
			else {
				remapBlock(mapping, compareBlock(mapping));
			}
		}
	}

	public static void remapItem(MissingMapping mapping, Item target) {
		if (target != null) {
			mapping.remap(target);
		}
	}

	public static void remapBlock(MissingMapping mapping, Block target) {
		if (target != null) {
			mapping.remap(target);
		}
	}

	public static Item compareItem(MissingMapping mapping) {
		String Tester = mapping.name.substring(ModInfo.MODID.length() + 1);



		if (Tester.equals("gensokyoNotesRuinedItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem; //remap to damage 0
		}
		else if (Tester.equals("gensokyoNotesPatItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem; //remap to damage 1
		}
		else if (Tester.equals("gensokyoNotesDusItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem; //remap to damage 2
		}
		else if (Tester.equals("gensokyoNotesImbItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem; //remap to damage 4
		}
		else if (Tester.equals("gensokyoNotesArcItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem; //remap to damage 5
		}



		else if (Tester.equals("oldDemonSpellItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.oldGensokyoSpellItem; //remap to damage 1
		}
		else if (Tester.equals("oldCelestialSpellItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.oldGensokyoSpellItem; //remap to damage 2
		}



		else if (Tester.equals("demonDustItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoDustItem; //remap to damage 1
		}
		else if (Tester.equals("celestialDustItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoDustItem; //remap to damage 2
		}



		else if (Tester.equals("demonIngotItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoIngotItem; //remap to damage 1
		}
		else if (Tester.equals("celestialIngotItem")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoIngotItem; //remap to damage 2
		}

		return null;
	}

	public static Block compareBlock(MissingMapping mapping) {
		String Tester = mapping.name.substring(ModInfo.MODID.length() + 1);
		if (Tester.equals("celestialOreBlock")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGBlock.gensokyoOreBlock; //remap to damage 2
		}
		if (Tester.equals("demonOreBlock")) {
			LogHelper.info("Found: " + mapping.name);
			return JTGBlock.gensokyoOreBlock; //remap to damage 1
		}

		return null;
	}
}
