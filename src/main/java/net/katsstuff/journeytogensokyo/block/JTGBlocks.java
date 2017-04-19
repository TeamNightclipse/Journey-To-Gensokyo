/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.block;

import net.katsstuff.journeytogensokyo.lib.LibBlockName;
import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGBlocks {

	@ObjectHolder(LibBlockName.DanmakuCrafting)
	public static final Block DanmakuCrafting = new Block(Material.AIR);

	@ObjectHolder(LibBlockName.GensokyoOre)
	public static final Block GensokyoOre = new Block(Material.AIR);
	@ObjectHolder(LibBlockName.MakaiOre)
	public static final Block MakaiOre = new Block(Material.AIR);
	@ObjectHolder(LibBlockName.CelestialOre)
	public static final Block CelestialOre = new Block(Material.AIR);
}
