/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo

import net.katsstuff.danmakucore.data.{MovementData, ShotData, Vector3}
import net.katsstuff.danmakucore.entity.living.phase.PhaseType
import net.katsstuff.danmakucore.lib.data.{LibForms, LibSubEntities}
import net.katsstuff.journeytogensokyo.api.{JourneyToGensokyoAPI => JTGAPI}
import net.katsstuff.journeytogensokyo.block.{BlockDanmakuCrafting, JTGBlocks}
import net.katsstuff.journeytogensokyo.entity.living.{EntityFairy, EntityHellRaven, EntityTenguCrow}
import net.katsstuff.journeytogensokyo.item.ItemBulletCore
import net.katsstuff.journeytogensokyo.lib.{LibBlockName, LibEntityName, LibItemName, LibPhaseName}
import net.katsstuff.journeytogensokyo.phase.{PhaseTypeGenericStageEnemy, PhaseTypeHellRaven, PhaseTypeShapeArrow, PhaseTypeTengu}
import net.minecraft.block.Block
import net.minecraft.entity.EnumCreatureType
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.{Item, ItemBlock, ItemStack}
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.EntityRegistry

object CommonProxy {

  @SubscribeEvent
  def registerBlocks(event: RegistryEvent.Register[Block]): Unit =
    event.getRegistry.registerAll((new BlockDanmakuCrafting).setRegistryName(LibBlockName.DanmakuCrafting))

  @SubscribeEvent
  def registerItems(event: RegistryEvent.Register[Item]): Unit =
    event.getRegistry.registerAll((new ItemBulletCore).setRegistryName(LibItemName.BulletCore), itemBlock(JTGBlocks.BlockDanmakuCrafting))

  @SubscribeEvent
  def registerPhases(event: RegistryEvent.Register[PhaseType]): Unit =
    event.getRegistry.registerAll(
      (new PhaseTypeGenericStageEnemy).setRegistryName(LibPhaseName.StageEnemy),
      (new PhaseTypeShapeArrow).setRegistryName(LibPhaseName.ShapeArrow),
      (new PhaseTypeTengu).setRegistryName(LibPhaseName.Tengu),
      (new PhaseTypeHellRaven).setRegistryName(LibPhaseName.HellRaven)
    )

  private def itemBlock(block: Block): ItemBlock = {
    val itemBlock = new ItemBlock(block)
    itemBlock.setRegistryName(block.getRegistryName)
    itemBlock
  }
}

class CommonProxy {

  def registerRenderers(): Unit = {}

  def registerEntities(): Unit = {
    EntityRegistry.registerModEntity(classOf[EntityFairy], LibEntityName.Fairy, 0, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    val fairySpawn = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HILLS) ++ BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS)
    EntityRegistry.addSpawn(classOf[EntityFairy], 25, 1, 4, EnumCreatureType.MONSTER, fairySpawn: _*)

    EntityRegistry.registerModEntity(classOf[EntityTenguCrow], LibEntityName.TenguCrow, 1, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    val mountain = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN)
    EntityRegistry.addSpawn(classOf[EntityTenguCrow], 15, 1, 2, EnumCreatureType.MONSTER, mountain: _*)

    EntityRegistry.registerModEntity(classOf[EntityHellRaven], LibEntityName.HellRaven, 2, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    val nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER)
    EntityRegistry.addSpawn(classOf[EntityHellRaven], 15, 1, 2, EnumCreatureType.MONSTER, nether: _*)
  }

  def registerDanmakuCrafting(): Unit = {
    val defaultForm      = LibForms.SPHERE
    val defaultSubEntity = LibSubEntities.DEFAULT_TYPE
    val defGravity       = Vector3.GravityDefault
    val strGravity       = Vector3.GravityDefault * 2.5D

    def recipe = new DanmakuRecipeBuilder
    def shot   = ShotData.DefaultShotData setForm null setSubEntity null

    import net.katsstuff.danmakucore.data.Vector3.gravity
    import net.katsstuff.danmakucore.lib.LibColor._

    recipe
      .withShot(shot.setDamage(1F))
      .withOreInput("logWood")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F))
      .withOreInput("plankWood")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_GREEN).setDelay(2))
      .withSpeed(-0.2D)
      .withGravity(gravity(0.01D))
      .withOreInput("treeSapling")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(1F))
      .withGravity(defGravity)
      .withOreInput("oreGold")
      .build()

    recipe
      .withShot(shot.setDamage(0.5F))
      .withGravity(defGravity)
      .withOreInput("oreIron")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F))
      .withGravity(defGravity)
      .withOreInput("oreLapis")
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setDamage(2F))
      .withGravity(defGravity)
      .withOreInput("oreDiamond")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setEnd(5))
      .withGravity(defGravity)
      .withOreInput("oreRedstone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(1.5F))
      .withGravity(defGravity)
      .withOreInput("oreEmerald")
      .withCost(400)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setDelay(10).setEnd(5))
      .withGravity(defGravity)
      .withOreInput("oreQuartz")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_BLACK).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withGravity(defGravity)
      .withOreInput("oreCoal")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setEnd(-20))
      .withOreInput("blockGlassColorless")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F).setEnd(-5))
      .withOreInput("paneGlassColorless")
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setDelay(3))
      .withOreInput("ingotIron")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_ORANGE).setDamage(2F))
      .withOreInput("ingotGold")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(3F))
      .withGravity(strGravity)
      .withOreInput("ingotBrick")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(2F).setSubEntity(LibSubEntities.FIRE))
      .withGravity(strGravity)
      .withOreInput("ingotBrickNether")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F))
      .withOreInput("nuggetGold")
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_CYAN).setDamage(3F))
      .withOreInput("gemDiamond")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_GREEN).setDamage(2F))
      .withOreInput("gemEmerald")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_WHITE).setDamage(1.5F).setDelay(10).setEnd(10))
      .withOreInput("gemQuartz")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_RED).setEnd(10))
      .withOreInput("dustRedstone")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_YELLOW).setDamage(0.5F).setEnd(1))
      .withOreInput("dustGlowstone")
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setDamage(2F).setEnd(5))
      .withOreInput("glowstone")
      .withCost(400)
      .build()

    recipe
      .withShot(shot.setDamage(-0.5F).setEnd(10))
      .withGravity(gravity(-0.01D))
      .withOreInput("cropPotato")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(-0.5F).setEnd(10))
      .withGravity(gravity(-0.01D))
      .withOreInput("cropCarrot")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F).setDelay(2))
      .withGravity(defGravity)
      .withOreInput("stone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F).setDelay(2))
      .withGravity(defGravity)
      .withOreInput("cobblestone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F).setDelay(2))
      .withGravity(defGravity)
      .withOreInput("sandstone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_BLACK).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withInput(Items.COAL)
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_BLACK).setDamage(6F))
      .withSpeed(-2D)
      .withGravity(strGravity)
      .withInput(Blocks.OBSIDIAN)
      .withCost(500)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.CRYSTAL_1).setColor(COLOR_VANILLA_CYAN))
      .withInput(new ItemStack(Blocks.ICE))
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.CRYSTAL_1).setColor(COLOR_VANILLA_CYAN).setDamage(0.25F))
      .withInput(Blocks.PACKED_ICE)
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setForm(defaultForm).setColor(COLOR_WHITE).setDamage(-0.2F))
      .withInput(Blocks.SNOW)
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setSubEntity(LibSubEntities.EXPLOSION))
      .withInput(Blocks.TNT)
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_BLUE).setDamage(-0.2F).setSubEntity(defaultSubEntity))
      .withSpeed(0.2D)
      .withInput(Items.WATER_BUCKET)
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_RED).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withSpeed(-0.2D)
      .withInput(Items.LAVA_BUCKET)
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_PURPLE).setDamage(-10F).setDelay(20).setSubEntity(LibSubEntities.FIRE))
      .withSpeed(-1D)
      .withInput(Items.ENDER_PEARL)
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withInput(Items.FIRE_CHARGE)
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setSubEntity(LibSubEntities.FIRE))
      .withInput(Items.FLINT_AND_STEEL)
      .withCost(300)
      .build()

    def dyeRecipe(color: Int, oreName: String): Unit = recipe.withShot(shot.setColor(color)).withOreInput(oreName).withCost(100).build()

    dyeRecipe(COLOR_VANILLA_BLACK, "dyeBlack")
    dyeRecipe(COLOR_VANILLA_BLUE, "dyeBlue")
    dyeRecipe(COLOR_VANILLA_BROWN, "dyeBrown")
    dyeRecipe(COLOR_VANILLA_CYAN, "dyeCyan")
    dyeRecipe(COLOR_VANILLA_GRAY, "dyeGray")
    dyeRecipe(COLOR_VANILLA_GREEN, "dyeGreen")
    dyeRecipe(COLOR_VANILLA_LIGHT_BLUE, "dyeLightBlue")
    dyeRecipe(COLOR_VANILLA_LIME, "dyeLime")
    dyeRecipe(COLOR_VANILLA_MAGENTA, "dyeMagenta")
    dyeRecipe(COLOR_VANILLA_ORANGE, "dyeOrange")
    dyeRecipe(COLOR_VANILLA_PINK, "dyePink")
    dyeRecipe(COLOR_VANILLA_PURPLE, "dyePurple")
    dyeRecipe(COLOR_VANILLA_RED, "dyeRed")
    dyeRecipe(COLOR_VANILLA_SILVER, "dyeLightGray")
    dyeRecipe(COLOR_VANILLA_WHITE, "dyeWhite")
    dyeRecipe(COLOR_VANILLA_YELLOW, "dyeYellow")
  }
}

case class DanmakuRecipeBuilder(shot:     ShotData = null,
                                input:    Either[String, ItemStack] = null,
                                movement: MovementData = new MovementData(0.4D, 0.4D, 0D, Vector3.Zero),
                                cost:     Int = 1000) {

  import net.katsstuff.journeytogensokyo.helper.Implicits._

  def withShot(shot:       ShotData):  DanmakuRecipeBuilder = copy(shot = shot)
  def withOreInput(string: String):    DanmakuRecipeBuilder = copy(input = Left(string))
  def withInput(stack:     ItemStack): DanmakuRecipeBuilder = copy(input = Right(stack))
  def withCost(cost:       Int):       DanmakuRecipeBuilder = copy(cost = cost)
  def withInput(block:     Block):     DanmakuRecipeBuilder = withInput(block.toStack)
  def withInput(item:      Item):      DanmakuRecipeBuilder = withInput(item.toStack)
  def withSpeed(speed:     Double):    DanmakuRecipeBuilder = copy(movement = new MovementData(speed, speed, 0D, movement.getGravity))
  def withGravity(gravity: Vector3):   DanmakuRecipeBuilder = copy(movement = movement.copy(gravity = gravity))
  def build(): Unit = JTGAPI.addDanmakuRecipe(shot, movement, input.merge, cost)

}
