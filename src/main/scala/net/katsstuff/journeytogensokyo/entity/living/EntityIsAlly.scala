package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.teamnightclipse.danmakucore.capability.danmakuhit.{AllyDanmakuHitBehavior, CapabilityDanmakuHitBehaviorJ}
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

trait EntityIsAlly extends EntityJTGDanmakuMob {

  override def hasCapability(capability: Capability[_], facing: EnumFacing): Boolean = {
    capability == CapabilityDanmakuHitBehaviorJ.HIT_BEHAVIOR || super.hasCapability(capability, facing)
  }

  override def getCapability[T](capability: Capability[T], facing: EnumFacing): T = {
    if(capability == CapabilityDanmakuHitBehaviorJ.HIT_BEHAVIOR) {
      AllyDanmakuHitBehavior.asInstanceOf[T]
    } else super.getCapability(capability, facing)
  }
}
