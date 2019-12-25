/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase;

import net.katsstuff.journeytogensokyo.entity.living.boss.phase.PhaseRumiaEasy;
import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.katsstuff.journeytogensokyo.lib.LibPhaseName;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.PhaseType;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGPhases {

	@ObjectHolder(LibPhaseName.StageEnemy)
	public static final PhaseTypeGenericStageEnemy StageEnemy = new PhaseTypeGenericStageEnemy();

	@ObjectHolder(LibPhaseName.ShapeArrow)
	public static final PhaseTypeShapeArrow ShapeArrow = new PhaseTypeShapeArrow();

	@ObjectHolder(LibPhaseName.Tengu)
	public static final PhaseTypeTengu Tengu = new PhaseTypeTengu();

	@ObjectHolder(LibPhaseName.HellRaven)
	public static final PhaseTypeHellRaven HellRaven = new PhaseTypeHellRaven();

	@ObjectHolder(LibPhaseName.RumiaEasyWarmup1)
	public static final PhaseType RUMIA_EASY_WARMUP_1 = new PhaseRumiaEasy.Warmup1Type();
	@ObjectHolder(LibPhaseName.RumiaEasyWarmup2)
	public static final PhaseType RUMIA_EASY_WARMUP_2 = new PhaseRumiaEasy.Warmup2Type();
	@ObjectHolder(LibPhaseName.RumiaEasyWarmup3)
	public static final PhaseType RUMIA_EASY_WARMUP_3 = new PhaseRumiaEasy.Warmup3Type();
}
