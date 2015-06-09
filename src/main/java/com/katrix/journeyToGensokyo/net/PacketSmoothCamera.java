package com.katrix.journeyToGensokyo.net;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class PacketSmoothCamera implements IMessage {

	public boolean SmoothOn;
	
	public PacketSmoothCamera() {}
	
	public PacketSmoothCamera(boolean SmoothOn) {
		this.SmoothOn = SmoothOn;
	}
	
	@Override
	public void toBytes(ByteBuf buf){
		buf.writeBoolean(SmoothOn);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.SmoothOn = buf.readBoolean();
	}
}
