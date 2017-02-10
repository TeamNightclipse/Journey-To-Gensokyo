/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.handler

import net.katsstuff.journeytogensokyo.client.gui.GuiDanmakuCrafting
import net.katsstuff.journeytogensokyo.container.ContainerDanmakuCrafting
import net.katsstuff.journeytogensokyo.lib.LibGuiId
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

//Might need to change this to a class
object GuiHandler extends IGuiHandler {

  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = ID match {
    case LibGuiId.DanmakuCraftingGui => new GuiDanmakuCrafting(player.inventory, world, new BlockPos(x, y, z))
  }

  override def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = ID match {
    case LibGuiId.DanmakuCraftingGui => new ContainerDanmakuCrafting(player.inventory, world, new BlockPos(x, y, z))
  }
}
