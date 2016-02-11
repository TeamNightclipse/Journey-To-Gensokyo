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
import net.minecraft.client.Minecraft;
import vazkii.botania.api.BotaniaAPI;

public class PacketSparkleFXHandler implements IMessageHandler<PacketSparkleFX, IMessage> {

	@Override
	public IMessage onMessage(PacketSparkleFX message, MessageContext ctx) {
		BotaniaAPI.internalHandler.sparkleFX(Minecraft.getMinecraft().theWorld, message.x, message.y, message.z, message.r, message.g, message.b, message.size, message.m);
		return null;
	}

}
