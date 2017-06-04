/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container

import scala.collection.mutable.ListBuffer

import net.katsstuff.danmakucore.data.{ShotData, Vector3}
import net.katsstuff.danmakucore.handler.ConfigHandler
import net.katsstuff.danmakucore.helper.TouhouHelper
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.lib.data.LibItems
import net.katsstuff.journeytogensokyo.api.recipe.{CraftingManager, IRecipeDanmaku}
import net.katsstuff.journeytogensokyo.block.JTGBlocks
import net.katsstuff.journeytogensokyo.container.slot.{SingleItemSlot, SlotDanmakuInput, SlotDanmakuOutput, SlotDanmakuType}
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{ClickType, Container, IInventory, InventoryCraftResult, InventoryCrafting, Slot}
import net.minecraft.item.ItemStack
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World
import net.katsstuff.journeytogensokyo.helper.Implicits._
import net.katsstuff.journeytogensokyo.helper.LogHelper

class ContainerDanmakuCrafting(invPlayer: InventoryPlayer, world: World, pos: BlockPos) extends Container {

  private val craftMatrix = new InventoryCrafting(this, 3, 3)
  private val craftResult = new InventoryCraftResult

  private val craftIngredients = new InventoryCrafting(this, 1, 4)

  private val slotDanmaku  = new SlotDanmakuInput(craftIngredients, 0, 107, 142, SlotDanmakuType.Danmaku, true)
  private val slotCopy     = new SlotDanmakuInput(craftIngredients, 1, 20, 160, SlotDanmakuType.BulletCore, false)
  private val slotAmount   = new SlotDanmakuInput(craftIngredients, 2, 56, 160, SlotDanmakuType.BulletCore, false)
  private val slotMaterial = new SingleItemSlot(craftIngredients, 3, 161, 142)

  private val slotOutput = new SlotDanmakuOutput(this, invPlayer.player, craftIngredients, craftMatrix, craftResult, 0, 224, 142)

  addSlotToContainer(slotOutput)
  addSlotToContainer(slotDanmaku)
  addSlotToContainer(slotCopy)
  addSlotToContainer(slotAmount)
  addSlotToContainer(slotMaterial)

  {
    val offsetX = 89
    val offsetY = 173

    for {
      i <- 0 until 3
      j <- 0 until 3
    } {
      addSlotToContainer(
        new SlotDanmakuInput(craftMatrix, j + i * 3, offsetX - 69 + j * 18, offsetY + 22 + i * 18, SlotDanmakuType.BulletCore, true)
      )
    }

    for {
      i <- 0 until 3
      j <- 0 until 9
    } {
      addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, offsetX + j * 18, offsetY + i * 18))
    }

    for (i <- 0 until 9) {
      addSlotToContainer(new Slot(invPlayer, i, offsetX + i * 18, offsetY + 58))
    }
  }

  onCraftMatrixChanged(null)

  override def onCraftMatrixChanged(inventoryIn: IInventory): Unit = {
    val out = for {
      data <- TouhouHelper.getDanmakuCoreData(invPlayer.player).toOption
      ctx <- createContext
      output <- ctx.createOutput(data.getScore)
    } yield output

    slotOutput.putStack(out.orNull)
    detectAndSendChanges()
  }

  def createContext: Option[DanmakuCraftingContext] = Option(slotDanmaku.getStack).map { danmakuStack =>
    DanmakuCraftingContext(
      danmakuStack = danmakuStack,
      copyStack = Option(slotCopy.getStack),
      amountStack = Option(slotAmount.getStack),
      recipe = CraftingManager.findMatchingRecipeDanmaku(slotMaterial),
      patternResult = getPattern
    )
  }

  def getPattern(amount: Int): Option[ItemDanmaku.Pattern] = {
    def pattern(slots: Int*): Boolean = {
      val (nonNull, nullable) = (0 until 9).partition(slots.contains)

      !nonNull.map(craftMatrix.getStackInSlot).contains(null) &&
        nullable.map(craftMatrix.getStackInSlot).forall(_ == null)
    }

    if (pattern(4)) Some(ItemDanmaku.Pattern.LINE)
    else if (pattern(1, 4)) Some(ItemDanmaku.Pattern.RANDOM_RING)
    else if (pattern(0, 1, 2)) Some(ItemDanmaku.Pattern.WIDE)
    else if (pattern(0, 1, 2, 3, 5, 6, 7, 8)) Some(ItemDanmaku.Pattern.CIRCLE)
    else if (pattern(0, 2, 4, 6, 8) && amount >= 3) Some(ItemDanmaku.Pattern.STAR)
    else if (pattern(0, 1, 2, 3, 4, 5, 6, 7, 8) && amount >= 4) Some(ItemDanmaku.Pattern.SPHERE)
    else if (pattern(1, 3, 5, 7) && amount >= 3) Some(ItemDanmaku.Pattern.RING)
    else None
  }

  override def slotClick(slotId: Int, dragType: Int, mode: ClickType, player: EntityPlayer): ItemStack = {
    val stack = super.slotClick(slotId, dragType, mode, player)
    onCraftMatrixChanged(null) //We need more updates because of stackSize
    stack
  }

  override def onContainerClosed(player: EntityPlayer) {
    super.onContainerClosed(player)

    if (!world.isRemote) {
      def drop(stack: ItemStack) = player.dropItem(stack, false)

      val stacks = new ListBuffer[ItemStack]
      stacks ++= (0 until craftIngredients.getSizeInventory).map(craftIngredients.getStackInSlot)
      stacks ++= (0 until craftMatrix.getSizeInventory).map(craftMatrix.getStackInSlot)
      stacks.foreach(drop)
    }
  }

  override def transferStackInSlot(player: EntityPlayer, index: Int): ItemStack = {
    var resultStack: ItemStack = null
    val slot = inventorySlots.get(index)

    if (slot != null && slot.getHasStack) {
      val slotStack = slot.getStack
      resultStack = slotStack.copy()

      def merge(from: Int, to: Int, reverse: Boolean = false): Boolean = mergeItemStack(slotStack, from, to, reverse)

      def mergeType(defaultFrom: Int, defaultTo: Int): Boolean = slotStack.getItem match {
        case item if item == LibItems.DANMAKU => merge(1, 2)
        case _                                => merge(defaultFrom, defaultTo)
      }

      val mergeRes = index match {
        case 0 =>
          val ret = merge(13, 50, reverse = true)
          slot.onSlotChange(resultStack, slotStack)
          ret
        case x if 14 to 40 contains x => mergeType(41, 50)
        case x if 41 to 49 contains x => mergeType(14, 41)
        case _                        => merge(14, 50)
      }

      if (!mergeRes) return null

      if (slotStack.stackSize == 0) {
        slot.putStack(null)
      } else slot.onSlotChanged()

      if (slotStack.stackSize == resultStack.stackSize) return null
      slot.onPickupFromSlot(player, slotStack)
    }

    resultStack
  }

  override def canInteractWith(playerIn: EntityPlayer): Boolean =
    world.getBlockState(pos).getBlock == JTGBlocks.DanmakuCrafting &&
      playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D
}

case class DanmakuCraftingContext(
    danmakuStack: ItemStack,
    copyStack: Option[ItemStack],
    amountStack: Option[ItemStack],
    recipe: Option[IRecipeDanmaku],
    patternResult: Int => Option[ItemDanmaku.Pattern]
) {

  val PatternCosts = Map(
    ItemDanmaku.Pattern.LINE -> 10,
    ItemDanmaku.Pattern.RANDOM_RING -> 20,
    ItemDanmaku.Pattern.WIDE -> 30,
    ItemDanmaku.Pattern.CIRCLE -> 35,
    ItemDanmaku.Pattern.STAR -> 45,
    ItemDanmaku.Pattern.SPHERE -> 2000,
    ItemDanmaku.Pattern.RING -> 35
  )

  def requiredScore: Int = recipe.fold(0)(_.scoreCost()) + patternResult(usedAmount).fold(0)(PatternCosts)

  def createOutput(currentScore: Int): Option[ItemStack] = {
    if(requiredScore > currentScore) None
    else {
      val danmakuCopy = danmakuStack.copy()

      shotCombined.foreach(ShotData.serializeNBTItemStack(danmakuCopy, _))
      speedCombined.foreach(ItemDanmaku.setSpeed(danmakuCopy, _))
      gravityCombined.foreach(ItemDanmaku.setGravity(danmakuCopy, _))
      patternResult(usedAmount).foreach(ItemDanmaku.setPattern(danmakuCopy, _))
      stackSizeCombined.foreach(danmakuCopy.stackSize = _)
      amountCombined.foreach(ItemDanmaku.setAmount(danmakuCopy, _))
      recipe.foreach(_ => ItemDanmaku.setCustom(danmakuCopy, true))

      Some(danmakuCopy)
    }
  }

  def shotCurrent: ShotData = ShotData.fromNBTItemStack(danmakuStack)
  def shotResult:  Option[ShotData] = recipe.map(_.outputShotData)

  def shotCombined: Option[ShotData] = shotResult.map { result =>
    def round(d: Float, decimalPlace: Int): Float = BigDecimal(d.toDouble).setScale(decimalPlace, BigDecimal.RoundingMode.HALF_UP).toFloat
    val current = shotCurrent

    val roundedDamage = round(current.damage + result.damage, 2)
    val roundedSizeX  = round(current.sizeX + result.sizeX, 2)
    val roundedSizeY  = round(current.sizeY + result.sizeY, 2)
    val roundedSizeZ  = round(current.sizeZ + result.sizeZ, 2)

    val newForm      = if (result.getForm != null) result.getForm else current.getForm
    val newColor     = if (result.color != -1) result.color else current.color
    val newDamage    = MathHelper.clamp(roundedDamage, 0F, 6F)
    val newSizeX     = MathHelper.clamp(roundedSizeX, 0.01F, 2F)
    val newSizeY     = MathHelper.clamp(roundedSizeY, 0.01F, 2F)
    val newSizeZ     = MathHelper.clamp(roundedSizeZ, 0.01F, 2F)
    val newDelay     = MathHelper.clamp(current.delay + result.delay, 0, 100)
    val newEnd       = MathHelper.clamp(current.end + result.end, 1, 120)
    val newSubEntity = if (result.getSubEntity != null) result.getSubEntity else current.getSubEntity

    ShotData(
      form = newForm,
      color = newColor,
      damage = newDamage,
      sizeX = newSizeX,
      sizeY = newSizeY,
      sizeZ = newSizeZ,
      delay = newDelay,
      end = newEnd,
      subEntity = newSubEntity
    )
  }

  def speedCurrent:  Double = ItemDanmaku.getSpeed(danmakuStack)
  def speedResult:   Option[Double] = recipe.map(_.outputMovement.getSpeedOriginal)
  def speedCombined: Option[Double] = speedResult.map(result => MathHelper.clamp(speedCurrent + result, 0D, 2D))

  def gravityResult:  Option[Vector3] = recipe.map(_.outputMovement.getGravity)
  def gravityCurrent: Vector3 = ItemDanmaku.getGravity(danmakuStack)

  def gravityCombined: Option[Vector3] = gravityResult.map { result =>
    val current = gravityCurrent

    val x = MathHelper.clamp(current.x + result.x, -0.5D, 0.5D)
    val y = MathHelper.clamp(current.y + result.y, -0.5D, 0.5D)
    val z = MathHelper.clamp(current.z + result.z, -0.5D, 0.5D)

    Vector3(x, y, z)
  }

  def patternCurrent: ItemDanmaku.Pattern = ItemDanmaku.getPattern(danmakuStack)

  def stackSizeCurrent:  Int = danmakuStack.stackSize
  def stackSizeResult:   Option[Int] = copyStack.map(_.stackSize)
  def stackSizeCombined: Option[Int] = stackSizeResult.map(result => Math.min(result + stackSizeCurrent, 64))

  def amountCurrent: Int = ItemDanmaku.getAmount(danmakuStack)
  def amountResult: Option[Int] = amountStack.map(_.stackSize)
  def amountCombined: Option[Int] = amountResult.map { result =>
    val maxNumber = ConfigHandler.danmaku.danmakuMaxNumber
    val total     = amountCurrent + result
    if (total > maxNumber) maxNumber else total
  }
  def usedAmount: Int = amountCombined.getOrElse(amountCurrent)
}