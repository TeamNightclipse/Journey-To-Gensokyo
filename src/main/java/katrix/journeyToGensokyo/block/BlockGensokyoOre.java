/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockGensokyoOre extends BlockJTGBase {

	public BlockGensokyoOre(Material material) {

		super(material);
		setHardness(2.0F);
		setStepSound(Block.soundTypePiston);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 2);
		setResistance(5.0F);

	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon)
			return this != JTGBlock.gensokyoOreBlock;

		return true;
	}

	public IIcon[] icons = new IIcon[3];

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				icons[i] = reg.registerIcon("journeytogensokyo:gensokyoOre");
			}

			if (i == 1) {
				icons[i] = reg.registerIcon("journeytogensokyo:demonOre");
			}

			if (i == 2) {
				icons[i] = reg.registerIcon("journeytogensokyo:celestialOre");
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta > 2) {
			meta = 0;
		}

		return icons[meta];
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 3; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
}
