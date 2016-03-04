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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import katrix.journeyToGensokyo.lib.LibMod;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import katrix.journeyToGensokyo.util.DanmakuHelper;
import katrix.journeyToGensokyo.util.ItemNBTHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.THKaguyaLib;
import thKaguyaMod.init.THKaguyaItems;

public class ItemStandardShot extends Item {

	public static final String NBT_POWER = "power";
	public static final String NBT_COOLDOWN = "cooldown";
	public static final String NBT_CANSPAWN = "canSpawn";
	public static final String NBT_PREVPOWER = "prevIntPower";
	public static final String NBT_SHOTLIST = "shotList";
	public static final String NBT_USETIME = "useTime";

	public static final String[] NAMES = {"needle", "homing", "laser", "rocket"};
	private IIcon[] icon;

	public ItemStandardShot() {
		super();
		setHasSubtypes(true);
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(1);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + NAMES[stack.getItemDamage()];
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		return icon[damage];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		icon = new IIcon[NAMES.length];

		for (int i = 0; i < NAMES.length; ++i) {
			icon[i] = iconRegister.registerIcon(LibMod.MODID + ":shot/" + NAMES[i]);
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		int useTime = ItemNBTHelper.getByte(stack, NBT_USETIME, (byte)0);
		
		if(useTime == 0) {
			int reduce = 1;

			//Remove all small ones first
			reduce = DanmakuHelper.searchInventoryPowerItem(player, reduce, 0);

			//Then remove the big ones
			if (reduce > 0) {
				DanmakuHelper.searchInventoryPowerItem(player, reduce, 1);
			}
		}

		List<EntityStandardShot> listShotEntity = getShotList(stack, player.worldObj);
		EntityStandardShot shotEntity;

		for (int i = 0; i < listShotEntity.size(); i++) {
			shotEntity = listShotEntity.get(i);
			if (shotEntity != null) {
				shotEntity.shotTimer = 3;
				shotEntity.power = ItemNBTHelper.getFloat(stack, NBT_POWER, 0F);
			}
		}
		
		if(useTime > 1) {
			ItemNBTHelper.setByte(stack, NBT_USETIME, (byte)0);
		}
		else {
			ItemNBTHelper.setByte(stack, NBT_USETIME, (byte)(useTime + 1));
		}

		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int pos, boolean equipped) {

		if (!world.isRemote && entity instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer)entity;
			int cooldown = ItemNBTHelper.getInt(stack, NBT_COOLDOWN, 0);

			if (!equipped && cooldown == 0) {
				ItemNBTHelper.setBoolean(stack, NBT_CANSPAWN, true);
			}

			//Drop item if more than one in inventory
			ItemStack[] inventory = player.inventory.mainInventory;
			for (int i = 0; i < inventory.length; i++) {
				if (inventory[i] != null && inventory[i].getItem() == this && i != pos) {
					player.dropPlayerItemWithRandomChoice(inventory[i], true);
					inventory[i] = null;
				}
			}
			
			float power = THKaguyaLib.getPlayerPower(player) / 100;

			if (equipped) {
				int intPower = MathHelper.floor_float(power);
				int prevIntPower = ItemNBTHelper.getInt(stack, NBT_PREVPOWER, 0);
				List<EntityStandardShot> listShotEntity = getShotList(stack, entity.worldObj);

				//Spawn initial bunch
				if (ItemNBTHelper.getBoolean(stack, NBT_CANSPAWN, false)) {
					ItemNBTHelper.setBoolean(stack, NBT_CANSPAWN, false);
					cooldown = 5;
					listShotEntity.clear();

					for (int i = 0; i < intPower; i++) {
						EntityStandardShot shot = new EntityStandardShot(world, player, stack.getItemDamage(), i, power);
						world.spawnEntityInWorld(shot);
						listShotEntity.add(i, shot);
					}
				}

				int shotAmount = listShotEntity.size();

				boolean updatePower = false;
				//Spawn more if power increases
				if (intPower > prevIntPower && shotAmount + intPower - prevIntPower <= 4) {

					for (int i = shotAmount; i < shotAmount + intPower - prevIntPower; i++) {
						EntityStandardShot shot = new EntityStandardShot(world, player, stack.getItemDamage(), i, power);
						world.spawnEntityInWorld(shot);
						listShotEntity.add(i, shot);
					}
					updatePower = true;
				}

				//Kill if power decreases
				else if (intPower < prevIntPower && shotAmount + intPower - prevIntPower >= -1) {

					shotAmount -= 1;
					for (int i = shotAmount; i > shotAmount + intPower - prevIntPower; i--) {

						EntityStandardShot deadEntity = listShotEntity.get(i);
						deadEntity.setDead();
						listShotEntity.remove(i);
					}
					updatePower = true;
				}

				if (updatePower) {
					for (EntityStandardShot shotEntity : listShotEntity) {
						shotEntity.power = power;
					}
				}

				prevIntPower = intPower;

				ItemNBTHelper.setInt(stack, NBT_PREVPOWER, prevIntPower);
				setShotList(stack, listShotEntity);
			}

			if (cooldown != 0) {
				cooldown--;
			}

			ItemNBTHelper.setFloat(stack, NBT_POWER, power);
			ItemNBTHelper.setInt(stack, NBT_COOLDOWN, cooldown);
		}
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		if (entityItem.age == 1) {
			ItemNBTHelper.setBoolean(entityItem.getEntityItem(), NBT_CANSPAWN, true);
		}
		return false;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityLiving;
			ItemStack[] inventory = player.inventory.mainInventory;

			for (ItemStack spellcard : inventory) {

				if (spellcard != null && spellcard.getItem() == THKaguyaItems.spell_card) {
					THKaguyaLib.checkSpellCardDeclaration(player.worldObj, spellcard, player, spellcard.getItemDamage(), DanmakuConstants.NORMAL, true);
				}
			}
		}
		return false;
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1D - ItemNBTHelper.getFloat(stack, NBT_POWER, 0) / 4D;
	}

	public void setShotList(ItemStack stack, List<EntityStandardShot> list) {
		List<Integer> ids = new ArrayList<Integer>();
		for (EntityStandardShot shotEntity : list) {
			if (shotEntity != null) {
				ids.add(shotEntity.getEntityId());
			}
		}
		ItemNBTHelper.setIntArray(stack, NBT_SHOTLIST, toIntArray(ids));
	}

	public List<EntityStandardShot> getShotList(ItemStack stack, World world) {
		int[] ids = ItemNBTHelper.getIntArray(stack, NBT_SHOTLIST, null);
		List<EntityStandardShot> shotList = new ArrayList<EntityStandardShot>();
		if (ids != null) {
			for (int id : ids) {
				shotList.add((EntityStandardShot)world.getEntityByID(id));
			}
		}
		return shotList;
	}

	private int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < NAMES.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
		super.addInformation(itemStack, player, list, bool);

		switch (itemStack.getItemDamage()) {
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
