/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.danmaku.DanmakuBuilder
import net.katsstuff.danmakucore.entity.living.EnumSpecies
import net.katsstuff.danmakucore.impl.shape.ShapeWideShot
import net.katsstuff.danmakucore.lib.data.LibDanmakuVariants
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.world.World

class EntityFairyNether(world: World) extends EntityFairy(world) {

	{
		val danmaku = DanmakuBuilder.builder().setUser(this).setShot(LibDanmakuVariants.SPHERE_DARK.getShotData).build()
		phaseManager.setCurrentPhase(JTGPhases.Shape.instantiate(phaseManager, new ShapeWideShot(danmaku, 8, 30F, 0F, 0D)))
		setSpecies(EnumSpecies.FAIRY_HELL)
	}
}
