/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
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

    val output = danmaku match {
      case Some(stack) =>
        val r          = recipeAndScore
        val newShot    = r.map(r => shotCombined(stack, r)).getOrElse(shotCurrent(stack))
        val newSpeed   = r.map(r => speedCombined(stack, r)).getOrElse(speedCurrent(stack))
        val newGravity = r.map(r => gravityCombined(stack, r)).getOrElse(gravityCurrent(stack))
        val stackSize  = Math.min(if (slotCopy.getHasStack) stack.stackSize + slotCopy.getStack.stackSize else stack.stackSize, 64)
        val custom     = r.map(_ => true).getOrElse(ItemDanmaku.getCustom(stack))

        createOutput(stack, newShot, newSpeed, newGravity, stackSize, custom)
      case None => null
    }

    slotOutput.putStack(output)

    detectAndSendChanges()
  }

  private def createOutput(danmaku: ItemStack, shot: ShotData, speed: Double, gravity: Vector3, stackSize: Int, custom: Boolean): ItemStack = {
    val amount = {
      val maxNumber = ConfigHandler.danmaku.danmakuMaxNumber
      val total     = amountCurrent() + amountResult()
      if (total > maxNumber) maxNumber else total
    }

    val pattern = getPattern(amount)

    val danmakuCopy = danmaku.copy()
    danmakuCopy.stackSize = stackSize
    ShotData.serializeNBTItemStack(danmakuCopy, shot)
    ItemDanmaku.setSpeed(danmakuCopy, speed)
    ItemDanmaku.setGravity(danmakuCopy, gravity)
    ItemDanmaku.setPattern(danmakuCopy, pattern)
    ItemDanmaku.setAmount(danmakuCopy, amount)
    ItemDanmaku.setCustom(danmakuCopy, custom)

    danmakuCopy
  }

  def danmaku: Option[ItemStack] = Option(slotDanmaku.getStack)

  def shotCurrent(input: ItemStack): ShotData = ShotData.fromNBTItemStack(input)

  def shotResult(recipe: IRecipeDanmaku): ShotData = {
    val result = recipe.outputShotData

    result.copy(damage = result.damage, delay = result.delay, end = result.end, sizeX = result.sizeX, sizeY = result.sizeY, sizeZ = result.sizeZ)
  }

  def shotCombined(input: ItemStack, recipe: IRecipeDanmaku): ShotData = {
    def round(d: Float, decimalPlace: Int): Float = BigDecimal(d.toDouble).setScale(decimalPlace, BigDecimal.RoundingMode.HALF_UP).toFloat
    val current = shotCurrent(input)
    val result  = shotResult(recipe)

    val roundedDamage = round(current.damage + result.damage, 2)
    val roundedSizeX  = round(current.sizeX + result.sizeX, 2)
    val roundedSizeY  = round(current.sizeY + result.sizeY, 2)
    val roundedSizeZ  = round(current.sizeZ + result.sizeZ, 2)

    val newForm      = if (result.getForm != null) result.getForm else current.getForm
    val newColor     = if (result.color != -1) result.color else current.color
    val newSizeX     = MathHelper.clamp(roundedSizeX, 0.01F, 2F)
    val newSizeY     = MathHelper.clamp(roundedSizeY, 0.01F, 2F)
    val newSizeZ     = MathHelper.clamp(roundedSizeZ, 0.01F, 2F)
    val newDamage    = MathHelper.clamp(roundedDamage, 0F, 8F)
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

  def speedCurrent(input:  ItemStack): Double = ItemDanmaku.getSpeed(input)
  def speedResult(recipe:  IRecipeDanmaku): Double = recipe.outputMovement.getSpeedOriginal
  def speedCombined(input: ItemStack, recipe: IRecipeDanmaku): Double =
    MathHelper.clamp(speedCurrent(input) + speedResult(recipe), 0D, 2D)

  def gravityResult(recipe: IRecipeDanmaku): Vector3 = recipe.outputMovement.getGravity
  def gravityCurrent(input: ItemStack):      Vector3 = ItemDanmaku.getGravity(input)

  def gravityCombined(input: ItemStack, recipe: IRecipeDanmaku): Vector3 = {
    val current = gravityCurrent(input)
    val result  = gravityResult(recipe)

    val x = MathHelper.clamp(current.x + result.x, -0.5D, 0.5D)
    val y = MathHelper.clamp(current.y + result.y, -0.5D, 0.5D)
    val z = MathHelper.clamp(current.z + result.z, -0.5D, 0.5D)

    Vector3(x, y, z)
  }

  def amountCurrent(): Int =
    danmaku.fold(0)(ItemDanmaku.getAmount)

  def amountResult(): Int = {
    val stack = slotAmount.getStack
    if (stack == null) 0 else stack.stackSize
  }

  def getPattern(amount: Int): Int = {
    def pattern(slots: Int*): Boolean = {
      val (nonNull, nullable) = (0 until 9).partition(slots.contains)

      !nonNull.map(craftMatrix.getStackInSlot).contains(null) &&
      nullable.map(craftMatrix.getStackInSlot).forall(_ == null)
    }

    if (pattern(4)) 0
    else if (pattern(1, 4)) 1
    else if (pattern(0, 1, 2)) 2
    else if (pattern(0, 1, 2, 3, 5, 6, 7, 8)) 3
    else if (pattern(0, 1, 2, 3, 4, 5, 6, 7, 8) && amount > 2) 4
    else if (pattern(1, 3, 5, 7) && amount > 2) 5
    else danmaku.fold(0)(ItemDanmaku.getPattern)
  }

  def recipe: Option[IRecipeDanmaku] =
    CraftingManager.findMatchingRecipeDanmaku(slotMaterial)

  def recipeAndScore: Option[IRecipeDanmaku] = {
    for {
      res  <- recipe
      data <- TouhouHelper.getDanmakuCoreData(invPlayer.player).toOption
      if data.getScore >= res.scoreCost()
    } yield res
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
