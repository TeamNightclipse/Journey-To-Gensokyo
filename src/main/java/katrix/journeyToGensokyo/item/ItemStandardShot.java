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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thKaguyaMod.THKaguyaLib;
import thKaguyaMod.THShotLib;
import thKaguyaMod.init.THKaguyaItems;

public class ItemStandardShot extends Item {
	
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
		
		ArrayList<EntityStandardShot> listShotEntity = getShotList(stack, player);
		
		for(int i = 0; i < listShotEntity.size(); i++){
			EntityStandardShot shotEntity = listShotEntity.get(i);
			if(shotEntity != null){
				shotEntity.shotTimer = 3;
				
				float power = getPower(stack);
				
				shotEntity.power = power;
			}
		}
		
		return stack;
	}
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int pos, boolean equipped) {
			
		if(!world.isRemote && entity instanceof EntityPlayer) {
			
			if(!stack.hasTagCompound()){
				stack.setTagCompound(new NBTTagCompound());
			}
			
			EntityPlayer player = (EntityPlayer)entity;
			int cooldown = getCooldown(stack);
			float power = THKaguyaLib.getPlayerPower(player)/100;
			int intPower = MathHelper.floor_float(power);
			int prevIntPower = getPrevIntPower(stack);
			ArrayList<EntityStandardShot> listShotEntity = getShotList(stack, entity);
			
			if(!equipped && cooldown == 0) {
				setCanSpawn(stack, true);
			}
			
			//Drop item if more than one in inventory
			int amount = 0;
			for(int i = 0 ; i < player.inventory.mainInventory.length ; i++ ) {
				
				ItemStack[] inventory = player.inventory.mainInventory;
				if(inventory[i] != null && inventory[i].getItem() == this)
				{
					amount++;
				}
				
				if(amount > 1){
					player.dropPlayerItemWithRandomChoice(inventory[i], true);
					inventory[i] = null;
					amount--;
				}
			}
			
			if(equipped) {
				
				//Spawn initial bunch
				if(getCanSpawn(stack)) {
					setCanSpawn(stack, false);
					cooldown = 5;
					listShotEntity.clear();
					
					for(int i = 0; i < intPower; i++){
						listShotEntity.add(i, new EntityStandardShot(world, player, stack.getItemDamage(), i, THKaguyaLib.getPlayerPower(player)/100));
						world.spawnEntityInWorld(listShotEntity.get(i));
					}
				}
				
				int shotAmount = listShotEntity.size();
				
				//Spawn more if power increases
				if(intPower > prevIntPower  && shotAmount + (intPower - prevIntPower) <= 4){
					
					for(int i = shotAmount;  i < shotAmount + (intPower - prevIntPower); i++) {
						listShotEntity.add(i, new EntityStandardShot(world, player, stack.getItemDamage(), i, THKaguyaLib.getPlayerPower(player)/100));
						world.spawnEntityInWorld(listShotEntity.get(i));
					}
					
					for(int i = 0; i < listShotEntity.size(); i++){
						EntityStandardShot shotEntity = listShotEntity.get(i);
						if(shotEntity != null){
							
							float shotPower = THKaguyaLib.getPlayerPower(player)/100;
							shotEntity.power = shotPower;
						}
					}
				}
				
				//Kill if power decreases
				else if(intPower < prevIntPower && shotAmount + (intPower - prevIntPower) >= -1){
					
					shotAmount -= 1;
					for(int i = shotAmount;  i > shotAmount + (intPower - prevIntPower); i--) {
						//TODO: some sanity check here
						EntityStandardShot deadEntity = listShotEntity.get(i);
						
						deadEntity.setDead();
						listShotEntity.remove(i);
					}
					
					for(int i = 0; i < listShotEntity.size(); i++){
						EntityStandardShot shotEntity = listShotEntity.get(i);
						if(shotEntity != null){
							
							float shotPower = THKaguyaLib.getPlayerPower(player)/100;
							shotEntity.power = shotPower;
						}
					}
				}
			}
			
			prevIntPower = intPower;
			
			if(cooldown != 0){
				cooldown--;
			}
			
			setCooldown(stack, cooldown);
			setPower(stack, power);
			setPrevIntPower(stack, prevIntPower);
			setShotList(stack, listShotEntity);
		}
	}
	
	@Override
    public boolean onEntityItemUpdate(EntityItem entityItem)
    {
		if(entityItem.age == 1) {
			setCanSpawn(entityItem.getEntityItem(), true);
		}
		
        return false;
    }
	
	@Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
		if(entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityLiving;
			
			for(int i = 0 ; i < player.inventory.mainInventory.length ; i++ ) {
				
				ItemStack[] inventory = player.inventory.mainInventory;
				if(inventory[i] != null && inventory[i].getItem() == THKaguyaItems.spell_card)
				{
					ItemStack spellcard = inventory[i];
					THKaguyaLib.checkSpellCardDeclaration(player.worldObj, spellcard, player, spellcard.getItemDamage(), THShotLib.NORMAL, true);
				}
			}
		}
        return false;
    }
	
	@Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return true;
    }
	
	@Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1D - (double)getPower(stack)/4D;
    }
	
	public float getPower(ItemStack stack) {
		
		if(stack.hasTagCompound()) {
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.hasKey("power")) {
				return tag.getFloat("power");
			}
		}
		return 0.0F;
	}
	
	public void setPower(ItemStack stack, float power) {
		
		if(stack.hasTagCompound()) {
			stack.getTagCompound().setFloat("power", power);
		}
	}
	
	public int getPrevIntPower(ItemStack stack) {
		
		if(stack.hasTagCompound()) {
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.hasKey("prevIntPower")) {
				return tag.getInteger("prevIntPower");
			}
		}
		return 0;
	}
	
	public void setPrevIntPower(ItemStack stack, int prevIntPower) {
		
		if(stack.hasTagCompound()) {
			stack.getTagCompound().setInteger("prevIntPower", prevIntPower);
		}
	}
	
	public int getCooldown(ItemStack stack) {
		
		if(stack.hasTagCompound()) {
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.hasKey("cooldown")) {
				return tag.getInteger("cooldown");
			}
		}
		return 10;
	}
	
	public void setCooldown(ItemStack stack, int cooldown) {
		
		if(stack.hasTagCompound()) {
			stack.getTagCompound().setInteger("cooldown", cooldown);
		}
	}
	
	public boolean getCanSpawn(ItemStack stack) {
		
		if(stack.hasTagCompound()) {
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.hasKey("canSpawn")) {
				return tag.getBoolean("canSpawn");
			}
		}
		return true;
	}
	
	public void setCanSpawn(ItemStack stack, boolean flag) {
		
		if(stack.hasTagCompound()) {
			stack.getTagCompound().setBoolean("canSpawn", flag);
		}
	}
	
	public void setShotList(ItemStack stack, ArrayList<EntityStandardShot> list) {
		
		if(stack.hasTagCompound()) {
			
			ArrayList<Integer> ids = new ArrayList<Integer>();
			
			for(int i = 0; i < list.size(); i++){
				EntityStandardShot shotEntity = list.get(i);
				if(shotEntity != null){
					ids.add(shotEntity.getEntityId());
				}
			}
			stack.getTagCompound().setIntArray("shotList", toIntArray(ids));
		}
	}
	
	public ArrayList<EntityStandardShot> getShotList(ItemStack stack, Entity entity) {
		
		if(stack.hasTagCompound()) {
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.hasKey("canSpawn")) {
				int ids[] = tag.getIntArray("shotList");
				ArrayList<EntityStandardShot> shotList = new ArrayList<EntityStandardShot>();
				
				for(int i = 0; i < ids.length; i++){
					
					shotList.add((EntityStandardShot) entity.worldObj.getEntityByID(ids[i]));
				}
				return shotList;
			}
		}
		return new ArrayList<EntityStandardShot>();
	}
	
	int[] toIntArray(List<Integer> list){
		
		  int[] ret = new int[list.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = list.get(i);
		  return ret;
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
