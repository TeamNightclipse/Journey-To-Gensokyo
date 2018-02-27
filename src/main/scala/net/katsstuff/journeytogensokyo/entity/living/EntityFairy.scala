/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import java.lang.{Boolean => JBoolean}
import java.util.Random

import net.katsstuff.danmakucore.entity.living.TouhouSpecies
import net.katsstuff.danmakucore.entity.living.ai.EntityAIMoveRanged
import net.katsstuff.journeytogensokyo.entity.living.ai.{EntityAIFollowFriend, EntityAITemptStack}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.handler.ConfigHandler.Spawns.SpawnEntry
import net.katsstuff.journeytogensokyo.lib.LibEntityName
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.block.BlockFlower
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.IEntityLivingData
import net.minecraft.entity.ai.{
  EntityAIHurtByTarget,
  EntityAILookIdle,
  EntityAINearestAttackableTarget,
  EntityAISwimming,
  EntityAIWander,
  EntityAIWatchClosest
}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.datasync.{DataParameter, DataSerializers, EntityDataManager}
import net.minecraft.util.math.BlockPos
import net.minecraft.util.{EnumHand, EnumParticleTypes}
import net.minecraft.world.{DifficultyInstance, EnumSkyBlock, World, WorldServer}
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.ReflectionHelper

object EntityFairy {
  var counter = 0
  def nextCounter(): Byte = {
    if (counter == 3) counter = 0
    else counter += 1

    counter.toByte
  }

  private final val LikedFlower: DataParameter[ItemStack] =
    EntityDataManager.createKey(classOf[EntityFairy], DataSerializers.ITEM_STACK)
  private final val HoldingFlower: DataParameter[JBoolean] =
    EntityDataManager.createKey(classOf[EntityFairy], DataSerializers.BOOLEAN)

  lazy val flowers: Seq[ItemStack] = {
    val typesForColor = ReflectionHelper
      .findField(classOf[BlockFlower.EnumFlowerType], "TYPES_FOR_BLOCK", "field_176981_k")
      .get(null)
      .asInstanceOf[Array[Array[BlockFlower.EnumFlowerType]]]

    BlockFlower.EnumFlowerColor
      .values()
      .flatMap { flowerColor =>
        val blockTypes = typesForColor(flowerColor.ordinal())
        val block      = flowerColor.getBlock
        blockTypes.map(tpe => new ItemStack(block, 1, tpe.getMeta))
      }
      .toSeq
  }

  def randomFlower(rand: Random): ItemStack = flowers(rand.nextInt(flowers.length))

  case class FairyGroupData(form: Byte) extends IEntityLivingData
}
class EntityFairy(_world: World) extends EntityForm(_world) with EntityIsCallable with EntityIsAlly {

  private var aiTempt:      EntityAITemptStack                            = _
  private var attackPlayer: EntityAINearestAttackableTarget[EntityPlayer] = _
  private var followFriend: EntityAIFollowFriend                          = _

  private var throwAwayTime = 0
  private var _friend: Option[EntityPlayer] = None

  setSize(0.5F, 1F)
  experienceValue = 5

  form = {
    if (world.isRemote) 0
    else EntityFairy.nextCounter()
  }

  phaseManager.addPhase(JTGPhases.StageEnemy.instantiate(phaseManager))
  phaseManager.currentPhase.init()

  setFlyingSpeed(0.3D)
  setGroundSpeed(0.2D)
  setSpecies(TouhouSpecies.FAIRY)

  callable.setCallDistance(30)
  setMaxHP(2F)

  override def initEntityAI(): Unit = {
    val liked = {
      val l = likedFlower
      if (l.isEmpty) {
        val newLiked = EntityFairy.randomFlower(rand)
        likedFlower = newLiked
        newLiked
      } else l
    }

    aiTempt = new EntityAITemptStack(this, 0.5D, true, Set(liked))
    attackPlayer = new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true)
    followFriend = new EntityAIFollowFriend(this, 1.5D, 2F, 16F)

    tasks.addTask(0, new EntityAISwimming(this))
    tasks.addTask(1, aiTempt)
    tasks.addTask(2, new EntityAIMoveRanged(this, 1D, 16F, 12F))
    tasks.addTask(6, new EntityAIWander(this, 1D))
    tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 16F))
    tasks.addTask(7, new EntityAILookIdle(this))
    targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    targetTasks.addTask(2, attackPlayer)
  }

  override def entityInit(): Unit = {
    super.entityInit()

    dataManager.register(EntityFairy.LikedFlower, EntityFairy.randomFlower(rand))
    dataManager.register(EntityFairy.HoldingFlower, Boolean.box(false))
  }

  override def onUpdate(): Unit = {
    super.onUpdate()
    if (aiTempt != null) {
      if (aiTempt.isTempted) {
        targetTasks.removeTask(attackPlayer)

        if (ticksExisted % 10 == 0 && world.isInstanceOf[WorldServer]) {
          world
            .asInstanceOf[WorldServer]
            .spawnParticle(EnumParticleTypes.HEART, false, posX, posY, posZ, 1 + rand.nextInt(2), 0D, 0D, 0D, 0.1D)
        }
      } else if (!holdingFlower) {
        targetTasks.addTask(2, attackPlayer)
      }

    }

    if (throwAwayTime > 0) {
      throwAwayTime -= 1

      if (throwAwayTime == 0) {
        holdingFlower = false
        entityDropItem(likedFlower, 0F)
      }
    }
  }

  override def onInitialSpawn(difficulty: DifficultyInstance, livingData: IEntityLivingData): IEntityLivingData = {
    val superData = super.onInitialSpawn(difficulty, livingData)

    val groupData = superData match {
      case fairy: EntityFairy.FairyGroupData => fairy
      case _                                 => EntityFairy.FairyGroupData(form)
    }

    form = groupData.form

    groupData
  }

  override def processInteract(player: EntityPlayer, hand: EnumHand): Boolean = {
    val stack = player.getHeldItem(hand)
    if ((aiTempt == null || aiTempt.isTempted) && !stack.isEmpty && likedFlower.isItemEqual(stack) && player
          .getDistanceSq(this) < 9.0D) {
      if (!player.capabilities.isCreativeMode) stack.shrink(1)

      if (!world.isRemote) {
        holdingFlower = true
        _friend = Some(player)
      }

      true
    } else super.processInteract(player, hand)
  }

  override def isValidLightLevel: Boolean = {
    val blockpos = new BlockPos(this.posX, this.getEntityBoundingBox.minY, this.posZ)
    world.getLightFor(EnumSkyBlock.SKY, blockpos) > 8
  }

  override def getBlockPathWeight(pos: BlockPos): Float =
    super.getBlockPathWeight(pos) + world.getLightBrightness(pos) - 0.5F

  override def lootTableName: String = LibEntityName.Fairy

  override def spawnEntry: SpawnEntry = ConfigHandler.spawns.fairy
  override def spawnBlockCheck(state: IBlockState): Boolean = {
    val spawnMaterial = Seq(Material.GRASS, Material.GROUND, Material.SAND)
    spawnMaterial.contains(state.getMaterial)
  }

  def holdingFlower: Boolean = dataManager.get(EntityFairy.HoldingFlower)
  def holdingFlower_=(holding: Boolean): Unit = {
    if (holding) {
      throwAwayTime = 400 + rand.nextInt(1201)
      targetTasks.removeTask(attackPlayer)
      tasks.addTask(3, followFriend)
    } else {
      _friend = None
      targetTasks.addTask(2, attackPlayer)
      tasks.removeTask(followFriend)
    }

    dataManager.set(EntityFairy.HoldingFlower, Boolean.box(holding))
  }

  def likedFlower: ItemStack = dataManager.get(EntityFairy.LikedFlower)
  def likedFlower_=(flower: ItemStack): Unit = {
    dataManager.set(EntityFairy.LikedFlower, flower)
    if (aiTempt != null) {
      aiTempt.temptStacks = Set(flower)
    }
  }

  def friend: Option[EntityPlayer] = _friend

  override def readEntityFromNBT(tag: NBTTagCompound): Unit = {
    super.readEntityFromNBT(tag)
    val flowerName = tag.getString("likedFlowerName")
    val flowerMeta = tag.getByte("likedFlowerMeta")
    likedFlower = GameRegistry.makeItemStack(flowerName, flowerMeta, 1, "")
  }

  override def writeEntityToNBT(tag: NBTTagCompound): Unit = {
    super.writeEntityToNBT(tag)
    val liked = likedFlower
    tag.setString("likedFlowerName", Item.REGISTRY.getNameForObject(liked.getItem).toString)
    tag.setByte("likedFlowerMeta", liked.getItemDamage.toByte)
  }
}
