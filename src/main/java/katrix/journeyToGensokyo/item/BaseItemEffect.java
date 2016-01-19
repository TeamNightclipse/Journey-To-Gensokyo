package katrix.journeyToGensokyo.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BaseItemEffect extends Item {

	public BaseItemEffect() {

		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);

	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return true;
	}

}
