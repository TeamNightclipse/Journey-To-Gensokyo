package com.katrix.journeyToGensokyo.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class GensokyoOreBlockItem extends ItemBlockWithMetadata {

        public GensokyoOreBlockItem(Block block) {
                super(block, block);
        }
        
        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return "tile.gensokyoOreBlock" + "_" + stack.getItemDamage();
        }
}