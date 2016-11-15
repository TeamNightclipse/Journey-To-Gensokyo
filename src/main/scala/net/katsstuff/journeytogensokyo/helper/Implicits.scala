/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.helper

import net.katsstuff.danmakucore.data.Vector3
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.math.Vec3d

/**
	* All implicit classes and methods to add functionality or convert
	* between classes go in here.
	*/
object Implicits {

	implicit class RichEntity(val entity: Entity) extends AnyVal {

		def getAngle: Vector3 = Vector3.fromSpherical(entity.rotationYaw, entity.rotationPitch)

	}

	implicit def vector3(vec: Vec3d): Vector3 = new Vector3(vec)

	implicit def vec3d(vec: Vector3): Vec3d = vec.toVec3d

	implicit class RichItem(val item: Item) extends AnyVal {

		def toStack: ItemStack = new ItemStack(item)

	}

	implicit class RichBlock(val block: Block) extends AnyVal {

		def toStack: ItemStack = new ItemStack(block)

	}
}
