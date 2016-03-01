/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.net;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class PacketSmoothCamera implements IMessage {

	public boolean flag;

	public PacketSmoothCamera() {}

	public PacketSmoothCamera(boolean SmoothOn) {
		this.flag = SmoothOn;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(flag);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		flag = buf.readBoolean();
	}
	
	public static class Handler implements IMessageHandler<PacketSmoothCamera, IMessage> {

		@Override
		public IMessage onMessage(PacketSmoothCamera message, MessageContext ctx) {
			Minecraft.getMinecraft().gameSettings.smoothCamera = message.flag;
			return null;
		}
	}
}
