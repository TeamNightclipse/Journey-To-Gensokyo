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

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemOldSpellcard extends ItemJTGBase {
	
	public ItemOldSpellcard() {
		super();
		setHasSubtypes(true);
	}
	
	public IIcon[] icons = new IIcon[3];
	
    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < 3; i ++) {
        	if(i == 0){
                this.icons[i] = reg.registerIcon("journeytogensokyo:oldGensokyoSpell");
        	}
        	
        	if(i == 1){
                this.icons[i] = reg.registerIcon("journeytogensokyo:oldDemonSpell");
        	}
        	
        	if(i == 2){
                this.icons[i] = reg.registerIcon("journeytogensokyo:oldCelestialSpell");
        	}
        }
    }
    
    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta > 2)
            meta = 0;

        return this.icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 3; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.oldGensokyoSpell" + "_" + stack.getItemDamage();
    }
}
