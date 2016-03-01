/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.net;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import katrix.journeyToGensokyo.lib.LibMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketHandler {

	private static final SimpleNetworkWrapper NET = NetworkRegistry.INSTANCE.newSimpleChannel(LibMod.MODID);
	private static byte packetId = 0;
	
	public static void preInit() {
		NET.registerMessage(PacketSmoothCamera.Handler.class, PacketSmoothCamera.class, packetId++, Side.CLIENT);
	}
	
	public static void sendTo(IMessage message, EntityPlayerMP player) {
		NET.sendTo(message, player);
	}
	
	public static void sendToAllNear(IMessage message, Entity entity, int range) {
		NET.sendToAllAround(message, new TargetPoint(entity.worldObj.provider.dimensionId, entity.posX, entity.posY, entity.posZ, range));
	}
}