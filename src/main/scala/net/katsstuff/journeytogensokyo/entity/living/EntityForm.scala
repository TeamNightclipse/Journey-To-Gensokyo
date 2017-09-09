/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import java.lang.{Byte => JByte}

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.datasync.{DataParameter, DataSerializers, EntityDataManager}
import net.minecraft.world.World

object EntityForm {

  private final val Form: DataParameter[JByte] = EntityDataManager.createKey(classOf[EntityForm], DataSerializers.BYTE)
}
abstract class EntityForm(_world: World) extends EntityJTGDanmakuMob(_world) {

  override def entityInit(): Unit = {
    super.entityInit()
    dataManager.register(EntityForm.Form, Byte.box(0))
  }

  def form:               Byte = dataManager.get(EntityForm.Form)
  def form_=(byte: Byte): Unit = dataManager.set(EntityForm.Form, Byte.box(byte))

  override def readEntityFromNBT(tag: NBTTagCompound): Unit = {
    super.readEntityFromNBT(tag)
    form = tag.getByte("form")
  }

  override def writeEntityToNBT(tag: NBTTagCompound): Unit = {
    super.writeEntityToNBT(tag)
    tag.setByte("form", form)
  }
}
