/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.api.recipe;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.minecraft.inventory.Slot;

public interface IDanmakuRecipe {

	boolean matches(Slot slot);

	int scoreCost();

	MovementData outputMovement();

	ShotData outputShotData();
}
