package net.katsstuff.journeytogensokyo.entity

import net.katsstuff.mirror.data.Vector3
import net.minecraft.entity.Entity
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

class EntityCamera(at: Vector3, yaw: Float, pitch: Float, world: World) extends Entity(world) {
  if(at != null) {
    setPositionAndRotation(at.x, at.y, at.z, yaw, pitch)
  }

  def this(other: Entity) = this(new Vector3(other), other.rotationYaw, other.rotationPitch, other.world)
  def this(world: World) = this(null, 0F, 0F, world)

  override def entityInit(): Unit = ()
  override def readEntityFromNBT(compound: NBTTagCompound): Unit = ()
  override def writeEntityToNBT(compound: NBTTagCompound): Unit = ()
}
