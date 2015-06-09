package com.katrix.journeyToGensokyo.net;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketSmoothCameraHandler implements IMessageHandler<PacketSmoothCamera, IMessage> {
	
	@Override
	public IMessage onMessage(PacketSmoothCamera message, MessageContext ctx) {
        System.out.println(message.SmoothOn);
		Minecraft.getMinecraft().gameSettings.smoothCamera = message.SmoothOn;
		return null;
	}
}