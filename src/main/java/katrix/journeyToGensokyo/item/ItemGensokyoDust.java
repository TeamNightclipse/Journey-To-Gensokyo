/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.item;

import java.util.List;

import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGensokyoDust extends ItemJTGBase {
	
	public static final String[] NAMES = {"gensokyo", "demon", "celestial"};
	public IIcon[] icons = new IIcon[NAMES.length];
	
	public ItemGensokyoDust() {
		super();
		setHasSubtypes(true);
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < NAMES.length; i++) {
			icons[i] = reg.registerIcon(LibMod.MODID + ":" + NAMES[i] + "Dust");
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > NAMES.length -1) {
			meta = 0;
		}

		return icons[meta];
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 3; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item.gensokyoDust" + "_" + stack.getItemDamage();
	}
}
