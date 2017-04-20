/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.item;

import net.katsstuff.journeytogensokyo.lib.LibItemName;
import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGItems {

	@ObjectHolder(LibItemName.BulletCore)
	public static final Item BulletCore = new Item();

	@ObjectHolder(LibItemName.GensokyoDust)
	public static final Item GensokyoDust = new Item();
	@ObjectHolder(LibItemName.MakaiDust)
	public static final Item MakaiDust = new Item();
	@ObjectHolder(LibItemName.CelestialDust)
	public static final Item CelestialDust = new Item();

	@ObjectHolder(LibItemName.GensokyoCrystal)
	public static final Item GensokyoCrystal = new Item();
	@ObjectHolder(LibItemName.MakaiCrystal)
	public static final Item MakaiCrystal = new Item();
	@ObjectHolder(LibItemName.CelestialCrystal)
	public static final Item CelestialCrystal = new Item();

	@ObjectHolder(LibItemName.GensokyoSpell)
	public static final Item GensokyoSpell = new Item();
	@ObjectHolder(LibItemName.MakaiSpell)
	public static final Item MakaiSpell = new Item();
	@ObjectHolder(LibItemName.CelestialSpell)
	public static final Item CelestialSpell = new Item();

	@ObjectHolder(LibItemName.GensokyoNotes)
	public static final Item GensokyoNotes = new Item();
	@ObjectHolder(LibItemName.PatchedGensokyoNotes)
	public static final Item PatchedGensokyoNotes = new Item();
}
