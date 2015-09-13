package com.katrix.journeyToGensokyo.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class GensokyoNoteEffectItem extends JTGBaseItem {
	
	public GensokyoNoteEffectItem() {
		super();
		setHasSubtypes(true);
	}
	
	public IIcon[] icons = new IIcon[2];
	
    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < 2; i ++) {
        	if(i == 0){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotes");
        	}
        	if(i == 1){
                this.icons[i] = reg.registerIcon("journeytogensokyo:gensokyoNotesArc");
        	}
        }
    }
    
    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta > 1)
            meta = 0;

        return this.icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 2; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		
		return true;
	}
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.gensokyoNotesEffect" + "_" + stack.getItemDamage();
    }
}
