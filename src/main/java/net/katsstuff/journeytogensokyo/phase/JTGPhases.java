/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase;

import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.katsstuff.journeytogensokyo.lib.LibPhaseName;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGPhases {

	@ObjectHolder(LibPhaseName.StageEnemy)
	public static final PhaseTypeStageEnemy StageEnemy = new PhaseTypeStageEnemy();

	@ObjectHolder(LibPhaseName.ShapeArrow)
	public static final PhaseTypeShapeArrow ShapeArrow = new PhaseTypeShapeArrow();
}
