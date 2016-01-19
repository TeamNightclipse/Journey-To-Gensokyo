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
import katrix.journeyToGensokyo.reference.EntityName;
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

		spawnEggItem = new ItemSpawnEgg().setTextureName("journeytogensokyo:spawn_egg");
		ItemSpawnEgg.addMapping(EntityName.HELL_RAVEN, 0x2D2727, 0xFF2700);
		ItemSpawnEgg.addMapping(EntityName.TENGU_CROW, 0x191616, 0x593A30);
		ItemSpawnEgg.addMapping(EntityName.FAIRY_ICE, 0x3DFFEE, 0xA0A000);
		ItemSpawnEgg.addMapping(EntityName.FAIRY_NETHER, 0x2D2727, 0xA0A000);
		ItemSpawnEgg.addMapping(EntityName.FAIRY_END, 0x362060, 0xD3C95D);
		ItemSpawnEgg.addMapping(EntityName.FAIRY_SUNFLOWER_END, 0x1C1133, 0x828200);
		ItemSpawnEgg.addMapping(EntityName.REIMU_HOSTILE, 0xD10400, 0xFFFFFF);
		//ItemSpawnEgg.addMapping(EntityName.YUKARI, 0x982D9F, 0x1A1956); //Hiding this for now

		standardShot = new ItemStandardShot().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("standardShot");

		GameRegistry.registerItem(oldGensokyoSpellItem, "oldGensokyoSpellItem");

		GameRegistry.registerItem(gensokyoIngotItem, "gensokyoIngotItem");
		GameRegistry.registerItem(gensokyoDustItem, "gensokyoDustItem");

		GameRegistry.registerItem(gensokyoNotesItem, "gensokyoNotesItem");

		GameRegistry.registerItem(spawnEggItem, "spawnEggJTG");

		GameRegistry.registerItem(standardShot, "standardShot");

		compOldDemonSpellcardItem = new ItemJTGBase().setTextureName("journeytogensokyo:oldDemonSpell").setUnlocalizedName("oldDemonSpell");
		compOldCelestialSpellcardItem = new ItemJTGBase().setTextureName("journeytogensokyo:oldCelestialSpell").setUnlocalizedName("oldCelestialSpell");
		compRuinedOldNotebook = new ItemJTGBase().setTextureName("journeytogensokyo:gensokyoNotesRuined").setUnlocalizedName("ruinedNotes");

		GameRegistry.registerItem(compOldDemonSpellcardItem, "oldDemonSpellItem");
		GameRegistry.registerItem(compOldCelestialSpellcardItem, "oldCelestialSpellItem");
		GameRegistry.registerItem(compRuinedOldNotebook, "gensokyoNotesRuinedItem");
	}
}
