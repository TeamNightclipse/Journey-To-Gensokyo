/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.block;

import cpw.mods.fml.common.registry.GameRegistry;
import katrix.journeyToGensokyo.item.ItemGensokyoOreBlock;
import katrix.journeyToGensokyo.lib.LibBlockName;
import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class JTGBlock {
	
	public static Block gensokyoOreBlock;

	public static Block keyStoneBlock;

	public static Block compDemonOreBlock;
	public static Block compCelestialOreBlock;

	public static void preInit() {

		gensokyoOreBlock = new BlockGensokyoOre(Material.rock);
		keyStoneBlock = new BlockKeyStone(Material.rock).setBlockName("keyStoneBlock").setBlockTextureName(LibMod.MODID + ":keyStone");

		GameRegistry.registerBlock(gensokyoOreBlock, ItemGensokyoOreBlock.class, LibBlockName.ORE_GENSOKYO);

		GameRegistry.registerBlock(keyStoneBlock, LibBlockName.KEYSTONE);

		compDemonOreBlock = new BlockJTGBase(Material.rock).setBlockName("demonOreBlock").setBlockTextureName(LibMod.MODID + ":demonOre");
		compCelestialOreBlock = new BlockJTGBase(Material.rock).setBlockName("celestialOreBlock").setBlockTextureName(LibMod.MODID + ":celestialOre");

		GameRegistry.registerBlock(compDemonOreBlock, LibBlockName.COMP_ORE_DEMON);
		GameRegistry.registerBlock(compCelestialOreBlock, LibBlockName.COMP_ORE_CELESTIAL);

	}
}
