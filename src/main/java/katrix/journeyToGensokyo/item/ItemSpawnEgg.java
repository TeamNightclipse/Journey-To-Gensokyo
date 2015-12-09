/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

import katrix.journeyToGensokyo.reference.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSpawnEgg extends Item
{
	static ArrayList<EntityEggInfo> entityList = new ArrayList<EntityEggInfo>();
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public ItemSpawnEgg()
    {
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    static class EntityEggInfo{
    	
        int colorBase = 0x000000;
        int colorSpots = 0xFFFFFF;
        String entityName = "";
        String entityNameFull = "";
        EntityLiving entityToSpawn = null;
        
        public EntityEggInfo(String entityName, int colorBase, int colorSpots){
        	
            this.colorBase = colorBase;
            this.colorSpots = colorSpots;
            this.entityName = entityName;
            this.entityNameFull = ModInfo.MODID+"." + entityName;
        }
    }
    
    public static void addMapping(String name, int colorBase, int colorSpots)
    {
    	entityList.add(new EntityEggInfo(name, colorBase, colorSpots));
    }

    public String getItemStackDisplayName(ItemStack itemStack)
    {
        String s = ("" + StatCollector.translateToLocal("item.spawnEggJTG.name")).trim();
        String s1 = ((EntityEggInfo)entityList.get(itemStack.getItemDamage())).entityName;

        if (s1 != null)
        {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int pass)
    {
        EntityEggInfo entityegginfo = (EntityEggInfo)entityList.get(itemStack.getItemDamage());
        return entityegginfo != null ? (pass == 0 ? entityegginfo.colorBase : entityegginfo.colorSpots) : 16777215;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            x += Facing.offsetsXForSide[side];
            y += Facing.offsetsYForSide[side];
            z += Facing.offsetsZForSide[side];
            double d0 = 0.0D;

            if (side == 1 && block.getRenderType() == 11)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(world, itemStack.getItemDamage(), (double)x + 0.5D, (double)y + d0, (double)z + 0.5D);

            if (entity != null)
            {
                if (entity instanceof EntityLivingBase && itemStack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
                }

                if (!player.capabilities.isCreativeMode)
                {
                    --itemStack.stackSize;
                }
            }

            return true;
        }
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (world.isRemote)
        {
            return itemStack;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

            if (movingobjectposition == null)
            {
                return itemStack;
            }
            else
            {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!world.canMineBlock(player, i, j, k))
                    {
                        return itemStack;
                    }

                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
                    {
                        return itemStack;
                    }

                    if (world.getBlock(i, j, k) instanceof BlockLiquid)
                    {
                        Entity entity = spawnCreature(world, itemStack.getItemDamage(), (double)i, (double)j, (double)k);

                        if (entity != null)
                        {
                            if (entity instanceof EntityLivingBase && itemStack.hasDisplayName())
                            {
                                ((EntityLiving)entity).setCustomNameTag(itemStack.getDisplayName());
                            }

                            if (!player.capabilities.isCreativeMode)
                            {
                                --itemStack.stackSize;
                            }
                        }
                    }
                }

                return itemStack;
            }
        }
    }

    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    public static Entity spawnCreature(World world, int damageValue, double x, double y, double z)
    {
        if (entityList.get(damageValue) == null)
        {
            return null;
        }
        else
        {
            Entity entity = null;

            for (int j = 0; j < 1; ++j)
            {
                entity = EntityList.createEntityByName(((EntityEggInfo)entityList.get(damageValue)).entityNameFull, world);

                if (entity != null && entity instanceof EntityLivingBase)
                {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((IEntityLivingData)null);
                    world.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_)
    {
        return p_77618_2_ > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
    	for(int i = 0; i < entityList.size(); i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        super.registerIcons(reg);
        this.theIcon = reg.registerIcon(this.getIconString() + "_overlay");
    }
}