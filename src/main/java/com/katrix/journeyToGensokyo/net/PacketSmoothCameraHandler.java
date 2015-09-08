/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

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