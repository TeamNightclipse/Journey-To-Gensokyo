/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.net;

import com.katrix.journeyToGensokyo.reference.ModInfo;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler{
	public static SimpleNetworkWrapper net = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MODID);
		  
	public static void preInit() {
		
		registerMessage(PacketSmoothCameraHandler.class, PacketSmoothCamera.class);
	}
		  
	private static int nextPacketId = 1;
		  
	private static void registerMessage(Class<PacketSmoothCameraHandler> packet, Class<PacketSmoothCamera> message)
	{
	net.registerMessage(packet, message, nextPacketId, Side.CLIENT);
	net.registerMessage(packet, message, nextPacketId, Side.SERVER);
	nextPacketId++;
	}
}