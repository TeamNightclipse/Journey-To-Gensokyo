package net.katsstuff.journeytogensokyo.item;

import net.katsstuff.journeytogensokyo.lib.LibItemName;
import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGItems {

	@ObjectHolder(LibItemName.BulletCore)
	public static final Item BulletCore = new Item();
}
