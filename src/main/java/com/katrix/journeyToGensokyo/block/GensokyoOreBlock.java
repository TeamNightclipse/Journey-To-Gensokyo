package com.katrix.journeyToGensokyo.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class GensokyoOreBlock extends Block{
	
	public GensokyoOreBlock (Material material){

		super(material);
		setHardness(2.0F);
		setStepSound(Block.soundTypePiston);
		setCreativeTab(CreativeTabs.tabBlock);
	    setHarvestLevel("pickaxe", 2);
	    setResistance(5.0F);
		
	}
	
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
    	if (entity instanceof EntityDragon)
        {
            return this != JTGBlock.celestialOreBlock;
        }

        return true;
    }

}
