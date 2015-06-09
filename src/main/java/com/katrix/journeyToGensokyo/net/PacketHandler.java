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