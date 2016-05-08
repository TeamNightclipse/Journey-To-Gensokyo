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

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0), AspectListJTG.BLOCK_GENSOKYO_ORE);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1), AspectListJTG.BLOCK_CELESTIAL_ORE);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2), AspectListJTG.BLOCK_DEMON_ORE);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 0), AspectListJTG.ITEM_GENSOKYO_DUST);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 1), AspectListJTG.ITEM_DEMON_DUST);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem, 1, 2), AspectListJTG.ITEM_CELESTIAL_DUST);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 0), AspectListJTG.ITEM_GENSOKYO_INGOT);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 1), AspectListJTG.ITEM_DEMON_INGOT);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem, 1, 2), AspectListJTG.ITEM_CELESTIAL_INGOT);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 0), AspectListJTG.ITEM_GENSOKYO_NOTE);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 1), AspectListJTG.ITEM_CELESTIAL_NOTE);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem, 1, 2), AspectListJTG.ITEM_DEMON_NOTE);

		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 0), AspectListJTG.ITEM_RUINED_GENSOKYO_NOTES);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 1), AspectListJTG.ITEM_GENSOKYO_NOTES_PAT);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 2), AspectListJTG.ITEM_GENSOKYO_NOTES_DUS);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 3), AspectListJTG.ITEM_GENSOKYO_NOTES);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 4), AspectListJTG.ITEM_GENSOKYO_NOTES_IMB);
		ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem, 1, 5), AspectListJTG.ITEM_GENSOKYO_NOTES_ARC);

		ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.point_item), AspectListJTG.ITEM_POINT_ITEM);
		ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.power_item), AspectListJTG.ITEM_POWER_ITEM);

		ThaumcraftApi.registerEntityTag(LibEntityName.FAIRY_ICE, AspectListJTG.ENTITY_TH_FAIRY_ICE);
		ThaumcraftApi.registerEntityTag("THFairy", AspectListJTG.ENTITY_TH_FAIRY);
		ThaumcraftApi.registerEntityTag("SunflowerFairy", AspectListJTG.ENTITY_SUNFLOWER_FAIRY);
		ThaumcraftApi.registerEntityTag("THPhantom", AspectListJTG.ENTITY_TH_PHANTOM);
		ThaumcraftApi.registerEntityTag("Cirno", AspectListJTG.ENTITY_CIRNO);
		ThaumcraftApi.registerEntityTag("Rumia", AspectListJTG.ENTITY_RUMIA);
		ThaumcraftApi.registerEntityTag("Toziko", AspectListJTG.ENTITY_TOZIKO);
		ThaumcraftApi.registerEntityTag("Sanae", AspectListJTG.ENTITY_SANAE);
		ThaumcraftApi.registerEntityTag("Hanabeeper", AspectListJTG.ENTITY_HANABEEPER);
		ThaumcraftApi.registerEntityTag("Rinnosuke", AspectListJTG.ENTITY_RINNOSUKE);
	}
}
