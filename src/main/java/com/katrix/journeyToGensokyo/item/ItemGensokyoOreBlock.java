/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemGensokyoOreBlock extends ItemBlockWithMetadata {

        public ItemGensokyoOreBlock(Block block) {
                super(block, block);
        }
        
        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return "tile.gensokyoOreBlock" + "_" + stack.getItemDamage();
        }
}