package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.teamnightclipse.danmakucore.capability.callableentity.{CallableEntity, CapabilityCallableEntityJ}
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

trait EntityIsCallable extends EntityJTGDanmakuMob {

  protected val callable: CallableEntity = CapabilityCallableEntityJ.CALLABLE.getDefaultInstance

  override def hasCapability(capability: Capability[_], facing: EnumFacing): Boolean = {
    capability == CapabilityCallableEntityJ.CALLABLE || super.hasCapability(capability, facing)
  }

  override def getCapability[T](capability: Capability[T], facing: EnumFacing): T = {
    if(capability == CapabilityCallableEntityJ.CALLABLE) {
      callable.asInstanceOf[T]
    } else super.getCapability(capability, facing)
  }
}
