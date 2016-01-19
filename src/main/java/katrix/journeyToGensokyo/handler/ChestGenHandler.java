/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.handler;

import katrix.journeyToGensokyo.item.JTGItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestGenHandler {

	public static WeightedRandomChestContent gensokyoSpell = new WeightedRandomChestContent(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 0), 1, 2, 9);
	public static WeightedRandomChestContent demonSpell = new WeightedRandomChestContent(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 1), 1, 2, 9);
	public static WeightedRandomChestContent celestialSpell = new WeightedRandomChestContent(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 2), 1, 2, 9);
	public static WeightedRandomChestContent ruinedNotebook = new WeightedRandomChestContent(new ItemStack(JTGItem.gensokyoNotesItem, 1, 0), 1, 1, 5);

	public static void init() {

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(gensokyoSpell);
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(demonSpell);
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(celestialSpell);
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(ruinedNotebook);
	}

}
