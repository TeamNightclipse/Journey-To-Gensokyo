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
import net.katsstuff.journeytogensokyo.block.{BlockDanOre, BlockDanmakuCrafting, JTGBlocks}
import net.katsstuff.journeytogensokyo.entity.living.{EntityFairy, EntityHellRaven, EntityPhantom, EntityTenguCrow}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.item.{ItemJTGBase, JTGItems}
import net.katsstuff.journeytogensokyo.lib.{LibBlockName, LibEntityName, LibItemName, LibPhaseName}
import net.katsstuff.journeytogensokyo.phase.{PhaseTypeGenericStageEnemy, PhaseTypeHellRaven, PhaseTypeShapeArrow, PhaseTypeTengu}
import net.katsstuff.journeytogensokyo.worldgen.OreWorldGen
import net.minecraft.block.Block
import net.minecraft.entity.{EntityLiving, EnumCreatureType}
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.{Item, ItemBlock, ItemStack}
import net.minecraft.world.biome.Biome
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.{EntityRegistry, GameRegistry}
import net.minecraftforge.oredict.OreDictionary

object CommonProxy {

  private val LightLevel = 1F / 15F

  @SubscribeEvent
  def registerBlocks(event: RegistryEvent.Register[Block]): Unit = {
    event.getRegistry.registerAll(
      new BlockDanmakuCrafting setRegistryName LibBlockName.DanmakuCrafting,
      new BlockDanOre(LibBlockName.GensokyoOre) setRegistryName LibBlockName.GensokyoOre,
      new BlockDanOre(LibBlockName.MakaiOre) setRegistryName LibBlockName.MakaiOre setLightLevel LightLevel * 5,
      new BlockDanOre(LibBlockName.CelestialOre) setRegistryName LibBlockName.CelestialOre setLightLevel LightLevel * 5
    )
  }

  @SubscribeEvent
  def registerItems(event: RegistryEvent.Register[Item]): Unit = {
    val gensokyoDust     = new ItemJTGBase(LibItemName.GensokyoDust) setRegistryName LibItemName.GensokyoDust
    val makaiDust        = new ItemJTGBase(LibItemName.MakaiDust) setRegistryName LibItemName.MakaiDust
    val celestialDust    = new ItemJTGBase(LibItemName.CelestialDust) setRegistryName LibItemName.CelestialDust
    val gensokyoCrystal  = new ItemJTGBase(LibItemName.GensokyoCrystal) setRegistryName LibItemName.GensokyoCrystal
    val makaiCrystal     = new ItemJTGBase(LibItemName.MakaiCrystal) setRegistryName LibItemName.MakaiCrystal
    val celestialCrystal = new ItemJTGBase(LibItemName.CelestialCrystal) setRegistryName LibItemName.CelestialCrystal

    val gensokyoOre  = itemBlock(JTGBlocks.GensokyoOre)
    val makaiOre     = itemBlock(JTGBlocks.MakaiOre)
    val celestialOre = itemBlock(JTGBlocks.CelestialOre)

    event.getRegistry.registerAll(
      new ItemJTGBase(LibItemName.BulletCore) setRegistryName LibItemName.BulletCore,
      gensokyoOre,
      makaiOre,
      celestialOre,
      gensokyoDust,
      makaiDust,
      celestialDust,
      gensokyoCrystal,
      makaiCrystal,
      celestialCrystal,
      new ItemJTGBase(LibItemName.GensokyoSpell) setRegistryName LibItemName.GensokyoSpell,
      new ItemJTGBase(LibItemName.MakaiSpell) setRegistryName LibItemName.MakaiSpell,
      new ItemJTGBase(LibItemName.CelestialSpell) setRegistryName LibItemName.CelestialSpell,
      new ItemJTGBase(LibItemName.GensokyoNotes) setRegistryName LibItemName.GensokyoNotes,
      new ItemJTGBase(LibItemName.PatchedGensokyoNotes) setRegistryName LibItemName.PatchedGensokyoNotes,
      itemBlock(JTGBlocks.DanmakuCrafting)
    )

    OreDictionary.registerOre("oreGensokyo", gensokyoOre)
    OreDictionary.registerOre("oreMakai", makaiOre)
    OreDictionary.registerOre("oreCelestial", celestialOre)

    OreDictionary.registerOre("dustGensokyo", gensokyoDust)
    OreDictionary.registerOre("dustMakai", makaiDust)
    OreDictionary.registerOre("dustCelestial", celestialDust)

    OreDictionary.registerOre("ingotGensokyo", gensokyoCrystal)
    OreDictionary.registerOre("ingotMakai", makaiCrystal)
    OreDictionary.registerOre("ingotCelestial", celestialCrystal)
  }

  @SubscribeEvent
  def registerPhases(event: RegistryEvent.Register[PhaseType]): Unit =
    event.getRegistry.registerAll(
      new PhaseTypeGenericStageEnemy setRegistryName LibPhaseName.StageEnemy,
      new PhaseTypeShapeArrow setRegistryName LibPhaseName.ShapeArrow,
      new PhaseTypeTengu setRegistryName LibPhaseName.Tengu,
      new PhaseTypeHellRaven setRegistryName LibPhaseName.HellRaven
    )

  private def itemBlock(block: Block): Item =
    new ItemBlock(block).setRegistryName(block.getRegistryName)
}

class CommonProxy {

  def registerRenderers(): Unit = {}

  def registerEntities(): Unit = {
    import BiomeDictionary.{Type => BiomeType}

    EntityRegistry.registerModEntity(classOf[EntityFairy], LibEntityName.Fairy, 0, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    registerSpawn(classOf[EntityFairy], ConfigHandler.spawns.fairy, EnumCreatureType.MONSTER, BiomeType.HILLS, BiomeType.PLAINS, BiomeType.FOREST)

    EntityRegistry.registerModEntity(classOf[EntityTenguCrow], LibEntityName.TenguCrow, 1, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    registerSpawn(classOf[EntityTenguCrow], ConfigHandler.spawns.tenguCrow, EnumCreatureType.MONSTER, BiomeType.MOUNTAIN)

    EntityRegistry.registerModEntity(classOf[EntityHellRaven], LibEntityName.HellRaven, 2, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    registerSpawn(classOf[EntityHellRaven], ConfigHandler.spawns.hellRaven, EnumCreatureType.MONSTER, BiomeType.NETHER)

    EntityRegistry.registerModEntity(classOf[EntityPhantom], LibEntityName.Phantom, 3, JourneyToGensokyo, 64, 1, true, 0xFFFFFF, 0x000000)
    registerSpawn(
      classOf[EntityPhantom],
      ConfigHandler.spawns.hellRaven,
      EnumCreatureType.MONSTER,
      BiomeType.HILLS,
      BiomeType.PLAINS,
      BiomeType.FOREST,
      BiomeType.NETHER
    )
  }

  def registerCrafting(): Unit = {
    GameRegistry.addSmelting(JTGBlocks.GensokyoOre, new ItemStack(JTGItems.GensokyoCrystal), 5F)
    GameRegistry.addSmelting(JTGBlocks.MakaiOre, new ItemStack(JTGItems.MakaiCrystal), 5F)
    GameRegistry.addSmelting(JTGBlocks.CelestialOre, new ItemStack(JTGItems.CelestialCrystal), 5F)
  }

  def registerWorldGen(): Unit = {
    GameRegistry.registerWorldGenerator(OreWorldGen.GensokyoOreGen, 5)
    GameRegistry.registerWorldGenerator(OreWorldGen.MakaiOreGen, 5)
    GameRegistry.registerWorldGenerator(OreWorldGen.CelestialOreGen, 5)
  }

  def registerSpawn(
      clazz:        Class[_ <: EntityLiving],
      entry:        ConfigHandler.Spawns.SpawnEntry,
      creatureType: EnumCreatureType,
      biomeTypes:   BiomeDictionary.Type*
  ): Unit =
    EntityRegistry.addSpawn(
      clazz,
      entry.weightedProbability(),
      entry.minAmount(),
      entry.maxAmount(),
      creatureType,
      biomesForTypes(biomeTypes: _*): _*
    )

  def biomesForTypes(types: BiomeDictionary.Type*): Seq[Biome] =
    types.flatMap(BiomeDictionary.getBiomesForType).distinct

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
      .withCost(100)
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
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F))
      .withGravity(defGravity)
      .withOreInput("oreIron")
      .withCost(500)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F))
      .withGravity(defGravity)
      .withOreInput("oreLapis")
      .withCost(250)
      .build()

    recipe
      .withShot(shot.setDamage(2F))
      .withGravity(defGravity)
      .withOreInput("oreDiamond")
      .withCost(3000)
      .build()

    recipe
      .withShot(shot.setEnd(5))
      .withGravity(defGravity)
      .withOreInput("oreRedstone")
      .withCost(250)
      .build()

    recipe
      .withShot(shot.setDamage(1.5F))
      .withGravity(defGravity)
      .withOreInput("oreEmerald")
      .withCost(2000)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setDelay(10).setEnd(5))
      .withGravity(defGravity)
      .withOreInput("oreQuartz")
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_BLACK).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withGravity(defGravity)
      .withOreInput("oreCoal")
      .withCost(250)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setEnd(-20))
      .withOreInput("blockGlassColorless")
      .withCost(500)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F).setEnd(-5))
      .withOreInput("paneGlassColorless")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.6F).setDelay(3))
      .withOreInput("ingotIron")
      .withCost(500)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_ORANGE).setDamage(1.2F))
      .withOreInput("ingotGold")
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setDamage(0.75F))
      .withGravity(strGravity)
      .withOreInput("ingotBrick")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withGravity(strGravity)
      .withOreInput("ingotBrickNether")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setDamage(0.1F))
      .withOreInput("nuggetGold")
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_CYAN).setDamage(2.4F))
      .withOreInput("gemDiamond")
      .withCost(3000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_GREEN).setDamage(1.7F))
      .withOreInput("gemEmerald")
      .withCost(2000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_WHITE).setDamage(1.2F).setDelay(10).setEnd(10))
      .withOreInput("gemQuartz")
      .withCost(1000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_RED).setEnd(10))
      .withOreInput("dustRedstone")
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_YELLOW).setDamage(0.5F).setEnd(1))
      .withOreInput("dustGlowstone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setEnd(5))
      .withOreInput("glowstone")
      .withCost(800)
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
      .withShot(shot.setDamage(0.25F).setDelay(2))
      .withGravity(defGravity)
      .withOreInput("stone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F).setDelay(2))
      .withGravity(defGravity)
      .withOreInput("cobblestone")
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setDamage(0.25F).setDelay(2))
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
      .withShot(shot.setColor(COLOR_VANILLA_BLACK).setDamage(4F))
      .withSpeed(-3D)
      .withGravity(strGravity)
      .withInput(Blocks.OBSIDIAN)
      .withCost(5000)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.CRYSTAL_1).setColor(COLOR_VANILLA_CYAN))
      .withInput(Blocks.ICE)
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.CRYSTAL_2).setColor(COLOR_VANILLA_CYAN).setDamage(0.25F))
      .withInput(Blocks.PACKED_ICE)
      .withCost(200)
      .build()

    recipe
      .withShot(shot.setForm(defaultForm).setColor(COLOR_WHITE).setDamage(-0.2F))
      .withInput(Blocks.SNOW)
      .withCost(100)
      .build()

    recipe
      .withShot(shot.setDamage(1F).setSubEntity(LibSubEntities.EXPLOSION))
      .withInput(Blocks.TNT)
      .withCost(5000)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_SATURATED_BLUE).setDamage(-0.2F).setSubEntity(defaultSubEntity))
      .withSpeed(0.2D)
      .withInput(Items.WATER_BUCKET)
      .withCost(400)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.FIRE).setColor(COLOR_SATURATED_RED).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withSpeed(-0.2D)
      .withInput(Items.LAVA_BUCKET)
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setColor(COLOR_VANILLA_PURPLE).setDamage(-10F).setDelay(20).setSubEntity(LibSubEntities.FIRE))
      .withSpeed(-1D)
      .withInput(Items.ENDER_PEARL)
      .withCost(5000)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.FIRE).setDamage(0.5F).setSubEntity(LibSubEntities.FIRE))
      .withInput(Items.FIRE_CHARGE)
      .withCost(300)
      .build()

    recipe
      .withShot(shot.setForm(LibForms.FIRE).setSubEntity(LibSubEntities.FIRE))
      .withInput(Items.FLINT_AND_STEEL)
      .withCost(300)
      .build()

    def dyeRecipe(color: Int, oreName: String): Unit = recipe.withShot(shot.setColor(color)).withOreInput(oreName).withCost(200).build()

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

case class DanmakuRecipeBuilder(
    shot:     ShotData = null,
    input:    Either[String, ItemStack] = null,
    movement: MovementData = new MovementData(0.4D, 0.4D, 0D, Vector3.Zero),
    cost:     Int = 1000
) {

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
