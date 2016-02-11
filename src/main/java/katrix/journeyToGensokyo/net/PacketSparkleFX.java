/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.net;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import katrix.journeyToGensokyo.util.NBTHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;

public class PacketSparkleFX implements IMessage {
	
	public double x;
	public double y;
	public double z;
	public float r;
	public float g;
	public float b;
	public float size;
	public int m;
	
	public static final String POS = "pos";
	public static final String COLOR = "color";
	public static final String SIZE = "size";
	public static final String M = "m";
	
	public PacketSparkleFX() {}
	
	public PacketSparkleFX(double x, double y, double z, float r, float g, float b, float size, int m) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
		this.g = g;
		this.b = b;
		this.size = size;
		this.m = m;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		NBTTagCompound tag = ByteBufUtils.readTag(buf);
		Vec3 pos = NBTHelper.getVector(tag, POS);
		Vec3 color = NBTHelper.getVector(tag, COLOR);
		this.x = pos.xCoord;
		this.y = pos.yCoord;
		this.z = pos.zCoord;
		this.r = (float)color.xCoord;
		this.g = (float)color.yCoord;
		this.b = (float)color.zCoord;
		this.size = tag.getFloat(SIZE);
		this.m = tag.getInteger(M);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		NBTTagCompound tag = new NBTTagCompound();
		NBTHelper.setVector(tag, POS, Vec3.createVectorHelper(x, y, z));
		NBTHelper.setVector(tag, COLOR, Vec3.createVectorHelper(r, g, b));
		tag.setFloat(SIZE, size);
		tag.setInteger(M, m);
		ByteBufUtils.writeTag(buf, tag);
	}

}
