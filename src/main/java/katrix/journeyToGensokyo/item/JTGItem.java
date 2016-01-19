/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.item;

import cpw.mods.fml.common.registry.GameRegistry;
import katrix.journeyToGensokyo.lib.LibEntityName;
import katrix.journeyToGensokyo.lib.LibItemName;
import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JTGItem {

	public static Item oldGensokyoSpellItem;
	public static Item gensokyoIngotItem;
	public static Item gensokyoDustItem;
	public static Item gensokyoNotesItem;

	public static Item spawnEggItem;

	public static Item compOldDemonSpellcardItem;
	public static Item compOldCelestialSpellcardItem;
	public static Item compRuinedOldNotebook;

	public static Item standardShot;

	public static void preInit() {

		oldGensokyoSpellItem = new ItemOldSpellcard();

		gensokyoIngotItem = new ItemGensokyoIngot().setCreativeTab(CreativeTabs.tabMaterials);
		gensokyoDustItem = new ItemGensokyoDust().setCreativeTab(CreativeTabs.tabMaterials);

		gensokyoNotesItem = new ItemGensokyoNote();

		spawnEggItem = new ItemSpawnEgg().setTextureName(LibMod.MODID + ":spawn_egg");
		ItemSpawnEgg.addMapping(LibEntityName.HELL_RAVEN, 0x2D2727, 0xFF2700);
		ItemSpawnEgg.addMapping(LibEntityName.TENGU_CROW, 0x191616, 0x593A30);
		ItemSpawnEgg.addMapping(LibEntityName.FAIRY_ICE, 0x3DFFEE, 0xA0A000);
		ItemSpawnEgg.addMapping(LibEntityName.FAIRY_NETHER, 0x2D2727, 0xA0A000);
		ItemSpawnEgg.addMapping(LibEntityName.FAIRY_END, 0x362060, 0xD3C95D);
		ItemSpawnEgg.addMapping(LibEntityName.FAIRY_SUNFLOWER_END, 0x1C1133, 0x828200);
		ItemSpawnEgg.addMapping(LibEntityName.REIMU_HOSTILE, 0xD10400, 0xFFFFFF);
		//ItemSpawnEgg.addMapping(EntityName.YUKARI, 0x982D9F, 0x1A1956); //Hiding this for now

		standardShot = new ItemStandardShot().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("standardShot");

		GameRegistry.registerItem(oldGensokyoSpellItem, LibItemName.OLD_SPELLCARD);

		GameRegistry.registerItem(gensokyoIngotItem, LibItemName.GENSOKYO_INGOT);
		GameRegistry.registerItem(gensokyoDustItem, LibItemName.GENSOKYO_DUST);

		GameRegistry.registerItem(gensokyoNotesItem, LibItemName.GENSOKYO_NOTE);

		GameRegistry.registerItem(spawnEggItem, LibItemName.SPAWN_EGG);

		GameRegistry.registerItem(standardShot, LibItemName.STANDARD_SHOT);

		compOldDemonSpellcardItem = new ItemJTGBase().setTextureName(LibMod.MODID + ":oldDemonSpell").setUnlocalizedName("oldDemonSpell");
		compOldCelestialSpellcardItem = new ItemJTGBase().setTextureName(LibMod.MODID + ":oldCelestialSpell").setUnlocalizedName("oldCelestialSpell");
		compRuinedOldNotebook = new ItemJTGBase().setTextureName(LibMod.MODID + ":gensokyoNotesRuined").setUnlocalizedName("ruinedNotes");

		GameRegistry.registerItem(compOldDemonSpellcardItem, LibItemName.COMP_OLD_SPELLCARD_DEMON);
		GameRegistry.registerItem(compOldCelestialSpellcardItem, LibItemName.COMP_OLD_SPELLCARD_CELESTIAL);
		GameRegistry.registerItem(compRuinedOldNotebook, LibItemName.COMP_NOTE_RUINED);
	}
}
