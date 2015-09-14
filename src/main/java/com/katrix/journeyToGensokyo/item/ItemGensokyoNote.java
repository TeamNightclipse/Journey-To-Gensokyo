/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemGensokyoNote extends ItemJTGBase {
	
	public ItemGensokyoNote() {
		super();
		setHasSubtypes(true);
	}
	
	public IIcon[] icons = new IIcon[6];
	
    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
        	if(i == 0){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotesRuined");
        	}
        	if(i == 1){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotesPat");
        	}
        	if(i == 2){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotesDus");
        	}
        	if(i == 3){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotes");
        	}
        	if(i == 4){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotes");
        	}
        	if(i == 5){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotesArc");
        	}
        }
    }
    
    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta > 5)
            meta = 0;

        return this.icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 6; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		
		if(par1ItemStack.getItemDamage() >= 4){
			return true;
		}
		return false;
	}
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.gensokyoNotes" + "_" + stack.getItemDamage();
    }
}
