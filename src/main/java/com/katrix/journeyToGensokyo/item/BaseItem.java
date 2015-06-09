package com.katrix.journeyToGensokyo.item;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class BaseItem extends Item {
	
	public BaseItem() {
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		
	}

}
