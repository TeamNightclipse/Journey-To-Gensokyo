package com.katrix.journeyToGensokyo.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class KeyStoneBlock extends Block{
	
    @SideOnly(Side.CLIENT)
    private IIcon texTop;
    @SideOnly(Side.CLIENT)
    private IIcon texFront;
	
	public KeyStoneBlock (Material material){

		super(material);
		setHardness(2.0F);
		setStepSound(Block.soundTypePiston);
		setCreativeTab(CreativeTabs.tabBlock);
	    setHarvestLevel("pickaxe", 1);
	    setResistance(15.0F);
		
	}
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? Blocks.stone.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ == 0 ? Blocks.stone.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
    }
}
