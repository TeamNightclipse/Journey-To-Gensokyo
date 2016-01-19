/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thaumcraft;

import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.item.JTGItem;
import katrix.journeyToGensokyo.lib.LibEntityName;
import net.minecraft.item.ItemStack;
import thKaguyaMod.init.THKaguyaItems;
import thaumcraft.api.ThaumcraftApi;

public class RegisterAspect {

	public static void postInit() {

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0), AspectListJTG.blockGensokyoOre);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1), AspectListJTG.blockCelestialOre);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2), AspectListJTG.blockDemonOre);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 0), AspectListJTG.itemGensokyoDust);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 1), AspectListJTG.itemDemonDust);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 2), AspectListJTG.itemCelestialDust);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 0), AspectListJTG.itemGensokyoIngot);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 1), AspectListJTG.itemDemonIngot);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 2), AspectListJTG.itemCelestialIngot);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 0), AspectListJTG.itemGensokyoNote);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 1), AspectListJTG.itemCelestialNote);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 2), AspectListJTG.itemDemonNote);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 0), AspectListJTG.itemRuinedGensokyoNotes);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 1), AspectListJTG.itemGensokyoNotesPat);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 2), AspectListJTG.itemGensokyoNotesDus);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 3), AspectListJTG.itemGensokyoNotes);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 4), AspectListJTG.itemGensokyoNotesImb);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 5), AspectListJTG.itemGensokyoNotesArc);

		ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.point_item), AspectListJTG.itemPointItem);
		ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.power_item), AspectListJTG.itemPowerItem);

		ThaumcraftApi.registerEntityTag(LibEntityName.FAIRY_ICE, AspectListJTG.entityTHFairyIce);
		ThaumcraftApi.registerEntityTag("THFairy", AspectListJTG.entityTHFairy);
		ThaumcraftApi.registerEntityTag("SunflowerFairy", AspectListJTG.entitySunflowerFairy);
		ThaumcraftApi.registerEntityTag("THPhantom", AspectListJTG.entityTHPhantom);
		ThaumcraftApi.registerEntityTag("Cirno", AspectListJTG.entityCirno);
		ThaumcraftApi.registerEntityTag("Rumia", AspectListJTG.entityRumia);
		ThaumcraftApi.registerEntityTag("Toziko", AspectListJTG.entityToziko);
		ThaumcraftApi.registerEntityTag("Sanae", AspectListJTG.entitySanae);
		ThaumcraftApi.registerEntityTag("Hanabeeper", AspectListJTG.entityHanabeeper);
		ThaumcraftApi.registerEntityTag("Rinnosuke", AspectListJTG.entityRinnosuke);
	}
}
