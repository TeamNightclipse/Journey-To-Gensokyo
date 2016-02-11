/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.util;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class NBTHelper {

	public static final String NBT_BLOCKPOS = "blockPos";
	public static final String NBT_VECTOR = "vector";
	public static final String NBT_FACING = "facing";
	public static final String NBT_MOP_TYPE_OF_HIT = "typeOfHit";
	public static final String NBT_UUID = "uuid";

	public static void setVector(NBTTagCompound tag, String tagName, Vec3 vector) {
		NBTTagList list = new NBTTagList();
		list.appendTag(new NBTTagDouble(vector.xCoord));
		list.appendTag(new NBTTagDouble(vector.yCoord));
		list.appendTag(new NBTTagDouble(vector.zCoord));
		tag.setTag(tagName, list);
	}

	public static Vec3 getVector(NBTTagCompound tag, String tagName) {
		NBTTagList list = tag.getTagList(tagName, Constants.NBT.TAG_DOUBLE);
		return Vec3.createVectorHelper(list.func_150309_d(0), list.func_150309_d(1), list.func_150309_d(2));
	}

	/*
	public static void setMOP(NBTTagCompound tag, String tagName, MovingObjectPosition mop) {
		switch (mop.typeOfHit) {
			case BLOCK:
				tag.setInteger(NBT_MOP_TYPE_OF_HIT, 0);
				setBlockPos(tag, NBT_BLOCKPOS, mop.getBlockPos());
				tag.setInteger("sideHit", mop.sideHit.getIndex());
				setVector(tag, NBT_VECTOR, mop.hitVec);
				break;
			case ENTITY:
				setEntityByUUID(tag, NBT_UUID, mop.entityHit);
				setVector(tag, NBT_VECTOR, mop.hitVec);
				break;
			default:
				break;
		}
	}

	public static MovingObjectPosition getMOP(NBTTagCompound tag, String tagName, World world) {
		switch (tag.getInteger(NBT_MOP_TYPE_OF_HIT)) {
			case 0:
				return new MovingObjectPosition(getVector(tag, NBT_VECTOR), EnumFacing.getFront(tag.getInteger(NBT_FACING)), getBlockPos(tag, NBT_BLOCKPOS));
			case 1:
				Entity entity = getEntityByUUID(tag, NBT_UUID, world);
				if (entity != null)
					return new MovingObjectPosition(entity, getVector(tag, NBT_VECTOR));
				else
					return null;
			default:
				break;
		}
		return null;
	}
	*/

	public static void setEntityByUUID(NBTTagCompound tag, String tagName, Entity entity) {
		tag.setString(tagName, entity.getUniqueID().toString());
	}

	public static Entity getEntityByUUID(NBTTagCompound tag, String tagName, World world) {
		@SuppressWarnings("unchecked")
		List<Entity> entityList = world.loadedEntityList;
		UUID uuid = UUID.fromString(tag.getString(tagName));
		
		for (Entity entity : entityList) {
			if (entity.getUniqueID().equals(uuid))
				return entity;
		}
		
		return null;
	}
}
