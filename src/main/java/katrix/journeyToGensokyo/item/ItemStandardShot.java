/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.item;

import java.util.ArrayList;
import java.util.List;

import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import katrix.journeyToGensokyo.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thKaguyaMod.THKaguyaLib;

public class ItemStandardShot extends Item {
	
	public boolean canSpawn;
	public int cooldown;
	public int timeSinceUse = 0;
	ArrayList<EntityStandardShot> listShotEntity = new ArrayList<EntityStandardShot>();
	
	public ItemStandardShot()
	{
		super();
		setHasSubtypes(true);
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(1);
	}
	
	private IIcon[] icon;
	
	public static final String shotNames[] =
	    {
	        "needle", "homing", "laser", "rocket"	
	    };
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
    {
        int i = MathHelper.clamp_int(stack.getItemDamage(), 0, shotNames.length);
        return super.getUnlocalizedName() + "." + shotNames[i];
    }
	
    public IIcon getIconFromDamage(int damage)
    {
        int i = MathHelper.clamp_int(damage, 0, shotNames.length);
        return this.icon[i];
    }
    
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.icon = new IIcon[shotNames.length];

        for (int i = 0; i < shotNames.length; ++i)
        {
            this.icon[i]	= iconRegister.registerIcon( "journeytogensokyo:shot/" + shotNames[i]);
        }
    }

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		for(int i = 0; i < listShotEntity.size(); i++){
			EntityStandardShot shotEntity = listShotEntity.get(i);
			if(shotEntity != null){
				shotEntity.setShotTimer(3);
				
				float power = THKaguyaLib.getPlayerPower(player)/100;
				
				shotEntity.setPower(power);
			}
		}
		
		return stack;
	}
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int pos, boolean equipped) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			
			if(!equipped && cooldown == 0 && timeSinceUse == 0){
				canSpawn = true;
			}
			
			if(equipped && canSpawn && !world.isRemote) {
				canSpawn = false;
				cooldown = 5;
				listShotEntity.clear();
				
				for(int i = 0; i < THKaguyaLib.getPlayerPower(player)/100; i++){
					listShotEntity.add(i, new EntityStandardShot(world, player, stack.getItemDamage(), i, THKaguyaLib.getPlayerPower(player)/100));
					world.spawnEntityInWorld(listShotEntity.get(i));
				}
				
			}
			
			if(equipped){
				timeSinceUse = 3;
			}
			
			if(timeSinceUse != 0){
				timeSinceUse--;
			}
			
			if(cooldown != 0){
				cooldown--;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < shotNames.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
	
    @Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool)
	{
		super.addInformation(itemStack, player, list, bool);
		
		int type = itemStack.getItemDamage();
		
		switch(type)
		{
			case 0:
				list.add(StatCollector.translateToLocal("standardShot.description.needle"));
				break;
			case 1:
				list.add(StatCollector.translateToLocal("standardShot.description.homing"));
				break;
			case 2:
				list.add(StatCollector.translateToLocal("standardShot.description.laser"));
				break;
			case 3:
				list.add(StatCollector.translateToLocal("standardShot.description.rocket"));
				break;
			default:
				break;
		}
	}
}
