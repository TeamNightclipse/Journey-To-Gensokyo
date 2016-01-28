/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.plugin.thsc;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import katrix.journeyToGensokyo.util.DanmakuHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thKaguyaMod.entity.shot.EntityTHShot;

public class EventDanmakuHit {

	@SubscribeEvent
	public void onDanmakuHit(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer && event.source.getSourceOfDamage() instanceof EntityTHShot) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			int reduce = 15;

			//Remove all small ones first
			reduce = DanmakuHelper.searchInventoryPowerItem(player, reduce, 0);

			//Then remove the big ones
			if (reduce > 0) {
				DanmakuHelper.searchInventoryPowerItem(player, reduce, 1);
			}
		}
	}
}
