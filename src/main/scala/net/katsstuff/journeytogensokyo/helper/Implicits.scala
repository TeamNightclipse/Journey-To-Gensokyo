/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.helper

import java.util.Optional

import net.katsstuff.danmakucore.data.Vector3
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.{Item, ItemStack}

/**
	* All implicit classes and methods to add functionality or convert
	* between classes go in here.
	*/
object Implicits {

  implicit class RickOptional[A](val optional: Optional[A]) extends AnyVal {

    def toOption: Option[A] = if (optional.isPresent) Some(optional.get()) else None
  }

  implicit class RichEntity(val entity: Entity) extends AnyVal {

    def direction: Vector3 = Vector3.fromSpherical(entity.rotationYaw, entity.rotationPitch)
  }

  implicit class RichItem(val item: Item) extends AnyVal {

    def toStack: ItemStack = new ItemStack(item)
  }

  implicit class RichBlock(val block: Block) extends AnyVal {

    def toStack: ItemStack = new ItemStack(block)
  }
}
