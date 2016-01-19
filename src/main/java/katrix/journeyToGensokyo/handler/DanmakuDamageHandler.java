/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.handler;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import thKaguyaMod.entity.shot.EntityTHShot;

public class DanmakuDamageHandler {

	public static DamageSource danmakuDamage(EntityTHShot shot, Entity sender) {
		return new EntityDamageSourceIndirect("danmakuDamage", shot, sender).setDamageBypassesArmor().setMagicDamage();
	}
}
