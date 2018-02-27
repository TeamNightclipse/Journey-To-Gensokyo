/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container

import net.katsstuff.danmakucore.data.ShotData
import net.katsstuff.danmakucore.handler.ConfigHandler
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.lib.data.LibItems
import net.katsstuff.danmakucore.scalastuff.TouhouHelper
import net.katsstuff.journeytogensokyo.api.recipe.{CraftingManager, IDanmakuRecipe}
import net.katsstuff.journeytogensokyo.block.JTGBlocks
import net.katsstuff.journeytogensokyo.container.slot.{
  SingleItemSlot,
  SlotDanmakuInput,
  SlotDanmakuOutput,
  SlotDanmakuType
}
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{ClickType, Container, IInventory, InventoryCraftResult, InventoryCrafting, Slot}
import net.minecraft.item.ItemStack
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World
import net.katsstuff.mirror.data.Vector3

class ContainerDanmakuCrafting(invPlayer: InventoryPlayer, world: World, pos: BlockPos) extends Container {

  private val craftMatrix = new InventoryCrafting(this, 3, 3)
  private val craftResult = new InventoryCraftResult

  private val craftIngredients = new InventoryCrafting(this, 1, 4)

  private val slotDanmaku  = new SlotDanmakuInput(craftIngredients, 0, 107, 142, SlotDanmakuType.Danmaku, true)
  private val slotCopy     = new SlotDanmakuInput(craftIngredients, 1, 20, 160, SlotDanmakuType.BulletCore, false)
  private val slotAmount   = new SlotDanmakuInput(craftIngredients, 2, 56, 160, SlotDanmakuType.BulletCore, false)
  private val slotMaterial = new SingleItemSlot(craftIngredients, 3, 161, 142)

  private val slotOutput =
    new SlotDanmakuOutput(this, invPlayer.player, craftIngredients, craftMatrix, craftResult, 0, 224, 142)

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
        new SlotDanmakuInput(
          craftMatrix,
          j + i * 3,
          offsetX - 69 + j * 18,
          offsetY + 22 + i * 18,
          SlotDanmakuType.BulletCore,
          true
        )
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
    val out = (for {
      data <- TouhouHelper.getDanmakuCoreData(invPlayer.player)
      ctx  <- createContext
    } yield ctx.createOutput(data.getScore)).getOrElse(ItemStack.EMPTY)

    if (ItemStack.areItemStacksEqual(out, slotDanmaku.getStack)) {
      slotOutput.putStack(slotDanmaku.getStack)
    } else {
      slotOutput.putStack(out)
    }

    detectAndSendChanges()
  }

  def createContext: Option[DanmakuCraftingContext] = {
    val danStack = slotDanmaku.getStack
    if (!danStack.isEmpty) {
      Some(
        DanmakuCraftingContext(
          danmakuStack = danStack,
          copyStack = slotCopy.getStack,
          amountStack = slotAmount.getStack,
          recipe = CraftingManager.findMatchingDanmakuRecipe(slotMaterial),
          patternResult = getPattern
        )
      )
    } else None
  }

  def getPattern(amount: Int): Option[ItemDanmaku.Pattern] = {
    def pattern(slots: Int*): Boolean = {
      val (nonEmpty, empty) = (0 until 9).partition(slots.contains)

      !nonEmpty.map(craftMatrix.getStackInSlot).exists(_.isEmpty) &&
      empty.map(craftMatrix.getStackInSlot).forall(_.isEmpty)
    }

    if (pattern(4)) Some(ItemDanmaku.Line)
    else if (pattern(1, 4)) Some(ItemDanmaku.RandomRing)
    else if (pattern(0, 1, 2)) Some(ItemDanmaku.Wide)
    else if (pattern(0, 1, 2, 3, 5, 6, 7, 8)) Some(ItemDanmaku.Circle)
    else if (pattern(0, 1, 2, 3, 4, 5, 6, 7, 8) && amount >= 4) Some(ItemDanmaku.Sphere)
    else if (pattern(1, 3, 5, 7) && amount >= 3) Some(ItemDanmaku.Ring)
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

      val stacks = (0 until craftIngredients.getSizeInventory).map(craftIngredients.getStackInSlot) ++
        (0 until craftMatrix.getSizeInventory).map(craftMatrix.getStackInSlot)
      stacks.foreach(drop)
    }
  }

  override def transferStackInSlot(player: EntityPlayer, index: Int): ItemStack = {
    var resultStack = ItemStack.EMPTY
    val slot        = inventorySlots.get(index)

    if (slot != null && slot.getHasStack) {
      val slotStack = slot.getStack
      resultStack = slotStack.copy()

      def merge(from: Int, to: Int, reverse: Boolean = false): Boolean = mergeItemStack(slotStack, from, to, reverse)

      def mergeType(defaultFrom: Int, defaultTo: Int): Boolean = slotStack.getItem match {
        case item if item == LibItems.DANMAKU =>
          if (!slotDanmaku.getHasStack) {
            slotDanmaku.putStack(slotStack.splitStack(1))
            true
          } else false
        case _ => merge(defaultFrom, defaultTo)
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

      if (!mergeRes) return ItemStack.EMPTY

      if (slotStack.isEmpty) {
        slot.putStack(ItemStack.EMPTY)
      } else slot.onSlotChanged()

      if (slotStack.getCount == resultStack.getCount) return ItemStack.EMPTY
      slot.onTake(player, slotStack)
    }

    resultStack
  }

  override def canInteractWith(playerIn: EntityPlayer): Boolean =
    world.getBlockState(pos).getBlock == JTGBlocks.DanmakuCrafting &&
      playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D
}

case class DanmakuCraftingContext(
    danmakuStack: ItemStack,
    copyStack: ItemStack,
    amountStack: ItemStack,
    recipe: Option[IDanmakuRecipe],
    patternResult: Int => Option[ItemDanmaku.Pattern]
) {

  val PatternCosts: Map[ItemDanmaku.Pattern, Int] = Map(
    ItemDanmaku.Line       -> 10,
    ItemDanmaku.RandomRing -> 20,
    ItemDanmaku.Wide       -> 30,
    ItemDanmaku.Circle     -> 35,
    ItemDanmaku.Sphere     -> 2000,
    ItemDanmaku.Ring       -> 35
  )

  def requiredScore: Int = recipe.fold(0)(_.scoreCost()) + patternResult(amountCombined).fold(0)(PatternCosts)

  def createOutput(currentScore: Int): ItemStack = {
    if (requiredScore > currentScore) ItemStack.EMPTY
    else {
      val danmakuCopy = danmakuStack.copy()

      shotCombined.foreach(ShotData.serializeNBTItemStack(danmakuCopy, _))
      speedCombined.foreach(ItemDanmaku.Speed.set(_, danmakuCopy))
      gravityCombined.foreach(ItemDanmaku.setGravity(_, danmakuCopy))
      patternResult(amountCombined).foreach(ItemDanmaku.DanPattern.set(_, danmakuCopy))
      danmakuCopy.setCount(stackSizeCombined)
      if (amountCombined != 1) {
        ItemDanmaku.Amount.set(amountCombined, danmakuCopy)
      }
      //noinspection NameBooleanParameters
      recipe.foreach(_ => ItemDanmaku.Custom.set(true, danmakuCopy))

      danmakuCopy
    }
  }

  def shotCurrent: ShotData         = ShotData.fromNBTItemStack(danmakuStack)
  def shotResult:  Option[ShotData] = recipe.map(_.outputShotData)

  def shotCombined: Option[ShotData] = shotResult.map { result =>
    def round(d: Float, decimalPlace: Int): Float =
      BigDecimal(d.toDouble).setScale(decimalPlace, BigDecimal.RoundingMode.HALF_UP).toFloat
    val current = shotCurrent

    val roundedDamage = round(current.damage + result.damage, 2)
    val roundedSizeX  = round(current.sizeX + result.sizeX, 2)
    val roundedSizeY  = round(current.sizeY + result.sizeY, 2)
    val roundedSizeZ  = round(current.sizeZ + result.sizeZ, 2)

    val newForm           = if (result.getForm != null) result.getForm else current.getForm
    val newMainColor      = if (result.edgeColor != -1) result.edgeColor else current.mainColor
    val newSecondaryColor = if (result.coreColor != -1) result.coreColor else current.secondaryColor
    val newDamage         = MathHelper.clamp(roundedDamage, 0F, 6F)
    val newSizeX          = MathHelper.clamp(roundedSizeX, 0.01F, 2F)
    val newSizeY          = MathHelper.clamp(roundedSizeY, 0.01F, 2F)
    val newSizeZ          = MathHelper.clamp(roundedSizeZ, 0.01F, 2F)
    val newDelay          = MathHelper.clamp(current.delay + result.delay, 0, 100)
    val newEnd            = MathHelper.clamp(current.end + result.end, 1, 120)
    val newSubEntity      = if (result.getSubEntity != null) result.getSubEntity else current.getSubEntity

    current.copy(
      form = newForm,
      damage = newDamage,
      sizeX = newSizeX,
      sizeY = newSizeY,
      sizeZ = newSizeZ,
      delay = newDelay,
      end = newEnd,
      subEntity = newSubEntity
    ).setMainColor(newMainColor).setSecondaryColor(newSecondaryColor)
  }

  def speedCurrent:  Double         = ItemDanmaku.Speed.get(danmakuStack)
  def speedResult:   Option[Double] = recipe.map(_.outputMovement.getSpeedOriginal)
  def speedCombined: Option[Double] = speedResult.map(result => MathHelper.clamp(speedCurrent + result, 0D, 2D))

  def gravityResult:  Option[Vector3] = recipe.map(_.outputMovement.getGravity)
  def gravityCurrent: Vector3         = ItemDanmaku.getGravity(danmakuStack)

  def gravityCombined: Option[Vector3] = gravityResult.map { result =>
    val current = gravityCurrent

    val x = MathHelper.clamp(current.x + result.x, -0.5D, 0.5D)
    val y = MathHelper.clamp(current.y + result.y, -0.5D, 0.5D)
    val z = MathHelper.clamp(current.z + result.z, -0.5D, 0.5D)

    Vector3(x, y, z)
  }

  def patternCurrent: ItemDanmaku.Pattern = ItemDanmaku.DanPattern.get(danmakuStack)

  def stackSizeCurrent:  Int = danmakuStack.getCount
  def stackSizeResult:   Int = copyStack.getCount
  def stackSizeCombined: Int = Math.min(stackSizeResult + stackSizeCurrent, 64)

  def amountCurrent: Int = ItemDanmaku.Amount.get(danmakuStack)
  def amountResult:  Int = amountStack.getCount
  def amountCombined: Int = {
    val maxNumber = ConfigHandler.danmaku.danmakuMaxNumber
    val total     = amountCurrent + amountResult
    if (total > maxNumber) maxNumber else total
  }
}
