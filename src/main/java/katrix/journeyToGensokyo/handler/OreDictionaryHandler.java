/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.handler;

import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.item.JTGItem;
import katrix.journeyToGensokyo.lib.LibOreDictionary;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

	public static void init() {

		OreDictionary.registerOre(LibOreDictionary.ORE_GENSOKYO, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0));
		OreDictionary.registerOre(LibOreDictionary.ORE_DEMON, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1));
		OreDictionary.registerOre(LibOreDictionary.ORE_CELESTIAL, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2));

		OreDictionary.registerOre(LibOreDictionary.DUST_GENSOKYO, new ItemStack(JTGItem.gensokyoDustItem, 1, 0));
		OreDictionary.registerOre(LibOreDictionary.DUST_DEMON, new ItemStack(JTGItem.gensokyoDustItem, 1, 1));
		OreDictionary.registerOre(LibOreDictionary.DUST_CELESTIAL, new ItemStack(JTGItem.gensokyoDustItem, 1, 2));

		OreDictionary.registerOre(LibOreDictionary.INGOT_GENSOKYO, new ItemStack(JTGItem.gensokyoIngotItem, 1, 0));
		OreDictionary.registerOre(LibOreDictionary.INGOT_DEMON, new ItemStack(JTGItem.gensokyoIngotItem, 1, 1));
		OreDictionary.registerOre(LibOreDictionary.INGOT_CELESTIAL, new ItemStack(JTGItem.gensokyoIngotItem, 1, 2));

		OreDictionary.registerOre(LibOreDictionary.ORE_DEMON, JTGBlock.compDemonOreBlock);
		OreDictionary.registerOre(LibOreDictionary.ORE_CELESTIAL, JTGBlock.compCelestialOreBlock);
	}
}
