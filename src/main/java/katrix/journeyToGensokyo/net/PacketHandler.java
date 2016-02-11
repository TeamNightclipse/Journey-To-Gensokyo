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
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import katrix.journeyToGensokyo.lib.LibMod;

public class PacketHandler {

	public static SimpleNetworkWrapper net = NetworkRegistry.INSTANCE.newSimpleChannel(LibMod.MODID);

	public static void preInit() {

		registerMessage(PacketSmoothCameraHandler.class, PacketSmoothCamera.class);
		registerMessage(PacketSparkleFXHandler.class, PacketSparkleFX.class);
	}

	private static int nextPacketId = 1;

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void registerMessage(Class packet, Class message) {
		net.registerMessage(packet, message, nextPacketId, Side.CLIENT);
		net.registerMessage(packet, message, nextPacketId, Side.SERVER);
		nextPacketId++;
	}
}