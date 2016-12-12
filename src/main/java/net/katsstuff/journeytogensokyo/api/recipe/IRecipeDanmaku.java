package net.katsstuff.journeytogensokyo.api.recipe;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.minecraft.inventory.Slot;

public interface IRecipeDanmaku {

	boolean matches(Slot slot);

	int scoreCost();

	MovementData outputMovement();

	ShotData outputShotData();
}
