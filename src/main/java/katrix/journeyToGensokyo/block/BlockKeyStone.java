/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockKeyStone extends BlockJTGBase{
	
    @SideOnly(Side.CLIENT)
    private IIcon texTop;
    @SideOnly(Side.CLIENT)
    private IIcon texFront;
	
	public BlockKeyStone (Material material){

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
