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
import net.katsstuff.journeytogensokyo.entity.living.{EntityFairy, EntityTenguCrow}
import net.katsstuff.journeytogensokyo.item.ItemBulletCore
import net.katsstuff.journeytogensokyo.lib.{LibEntityName, LibPhaseName}
import net.katsstuff.journeytogensokyo.phase.{PhaseTypeStageEnemy, PhaseTypeShapeArrow}
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
	def registerBlocks(event: RegistryEvent.Register[Block]): Unit = {
		event.getRegistry.registerAll(
			new BlockDanmakuCrafting
		)
	}

	@SubscribeEvent
	def registerItems(event: RegistryEvent.Register[Item]): Unit = {
		event.getRegistry.registerAll(
			new ItemBulletCore,
			itemBlock(JTGBlocks.BlockDanmakuCrafting)
		)
	}

	@SubscribeEvent
	def registerPhases(event: RegistryEvent.Register[PhaseType]): Unit = {
		event.getRegistry.registerAll(
			(new PhaseTypeStageEnemy).setRegistryName(LibPhaseName.StageEnemy),
			(new PhaseTypeShapeArrow).setRegistryName(LibPhaseName.ShapeArrow)
		)
	}

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
		EntityRegistry.addSpawn(classOf[EntityTenguCrow], 15, 1, 2, EnumCreatureType.MONSTER,
			BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN): _*)
	}

	def registerDanmakuCrafting(): Unit = {
		val defaultForm = LibForms.SPHERE
		val defaultSubEntity = LibSubEntities.DEFAULT_TYPE
		val defGravity = Vector3.GravityDefault
		val strGravity = Vector3.GravityDefault * 2.5D

		def recipe = new DanmakuRecipeBuilder
		def builder = ShotData.DefaultShotData setForm null setSubEntity null

		import net.katsstuff.danmakucore.data.Vector3.gravity
		import net.katsstuff.danmakucore.lib.LibColor._

		recipe setShot (builder setDamage 1F) setInput "logWood" build()
		recipe setShot (builder setDamage 0.25F) setInput "plankWood" build()
		recipe setShot (builder setColor COLOR_SATURATED_GREEN setDelay 2) setSpeed -0.2D setGravity gravity(0.01D) setInput "treeSapling" build()
		recipe setShot (builder setDamage 1F) setGravity defGravity setInput "oreGold" build()
		recipe setShot (builder setDamage 0.5F) setGravity defGravity setInput "oreIron" build()
		recipe setShot (builder setDamage 0.25F) setGravity defGravity setInput "oreLapis" build()
		recipe setShot (builder setDamage 2F) setGravity defGravity setInput "oreDiamond" build()
		recipe setShot (builder setEnd 5) setGravity defGravity setInput "oreRedstone" build()
		recipe setShot (builder setDamage 1.5F) setGravity defGravity setInput "oreEmerald" build()
		recipe setShot (builder setDamage 1F setDelay 10 setEnd 5) setGravity defGravity setInput "oreQuartz" build()
		recipe setShot (builder setColor COLOR_VANILLA_BLACK setDamage 0.5F setSubEntity LibSubEntities.FIRE) setGravity defGravity setInput
			"oreCoal" build()
		recipe setShot (builder setDamage 1F setEnd -20) setInput "blockGlassColorless" build()
		recipe setShot (builder setDamage 0.25F setEnd -5) setInput "paneGlassColorless" build()
		recipe setShot (builder setDamage 1F setDelay 3) setInput "ingotIron" build()
		recipe setShot (builder setColor COLOR_SATURATED_ORANGE setDamage 2F) setInput "ingotGold" build()
		recipe setShot (builder setDamage 3F) setGravity strGravity setInput "ingotBrick" build()
		recipe setShot (builder setDamage 2F setSubEntity LibSubEntities.FIRE) setGravity strGravity setInput "ingotBrickNether" build()
		recipe setShot (builder setDamage 0.25F) setInput "nuggetGold" build()
		recipe setShot (builder setColor COLOR_SATURATED_CYAN setDamage 3F) setInput "gemDiamond" build()
		recipe setShot (builder setColor COLOR_SATURATED_GREEN setDamage 2F) setInput "gemEmerald" build()
		recipe setShot (builder setColor COLOR_VANILLA_WHITE setDamage 1.5F setDelay 10 setEnd 10) setInput "gemQuartz" build()
		recipe setShot (builder setColor COLOR_SATURATED_RED setEnd 10) setInput "dustRedstone" build()
		recipe setShot (builder setColor COLOR_SATURATED_YELLOW setDamage 0.5F setEnd 1) setInput "dustGlowstone" build()
		recipe setShot (builder setDamage 2F setEnd 5) setInput "glowstone" build()
		recipe setShot (builder setDamage -0.5F setEnd 10) setGravity gravity(-0.01D) setInput "cropPotato" build()
		recipe setShot (builder setDamage -0.5F setEnd 10) setGravity gravity(-0.01D) setInput "cropCarrot" build()
		recipe setShot (builder setDamage 0.5F setDelay 2) setGravity defGravity setInput "stone" build()
		recipe setShot (builder setDamage 0.5F setDelay 2) setGravity defGravity setInput "cobblestone" build()
		recipe setShot (builder setDamage 0.5F setDelay 2) setGravity defGravity setInput "sandstone" build()
		recipe setShot (builder setColor COLOR_VANILLA_BLACK setDamage 0.5F setSubEntity LibSubEntities.FIRE) setInput Items.COAL build()
		recipe setShot (builder setColor COLOR_VANILLA_BLACK setDamage 6F) setSpeed -2D setGravity strGravity setInput Blocks.OBSIDIAN build()
		recipe setShot (builder setForm LibForms.CRYSTAL_1 setColor COLOR_VANILLA_CYAN) setInput new ItemStack(Blocks.ICE) build()
		recipe setShot (builder setForm LibForms.CRYSTAL_1 setColor COLOR_VANILLA_CYAN setDamage 0.25F) setInput Blocks.PACKED_ICE build()
		recipe setShot (builder setForm defaultForm setColor COLOR_WHITE setDamage -0.2F) setInput Blocks.SNOW build()
		recipe setShot (builder setDamage 1F setSubEntity LibSubEntities.EXPLOSION) setInput Blocks.SNOW build()
		recipe setShot (builder setColor COLOR_SATURATED_BLUE setDamage -0.2F setSubEntity defaultSubEntity) setSpeed 0.2D setInput
			Items.WATER_BUCKET build()
		recipe setShot (builder setColor COLOR_SATURATED_RED setDamage 0.5F setSubEntity LibSubEntities.FIRE) setSpeed -0.2D setInput
			Items.LAVA_BUCKET build()
		recipe setShot (builder setColor COLOR_VANILLA_PURPLE setDamage -10F setDelay 20 setSubEntity LibSubEntities.FIRE) setSpeed -1D setInput
			Items.ENDER_PEARL build()
		recipe setShot (builder setDamage 0.5F setSubEntity LibSubEntities.FIRE) setInput Items.FIRE_CHARGE build()
		recipe setShot (builder setSubEntity LibSubEntities.FIRE) setInput Items.FLINT_AND_STEEL build()

		recipe setShot (builder setColor COLOR_VANILLA_BLACK) setInput "dyeBlack" build()
		recipe setShot (builder setColor COLOR_VANILLA_BLUE) setInput "dyeBlue" build()
		recipe setShot (builder setColor COLOR_VANILLA_BROWN) setInput "dyeBrown" build()
		recipe setShot (builder setColor COLOR_VANILLA_CYAN) setInput "dyeCyan" build()
		recipe setShot (builder setColor COLOR_VANILLA_GRAY) setInput "dyeGray" build()
		recipe setShot (builder setColor COLOR_VANILLA_GREEN) setInput "dyeGreen" build()
		recipe setShot (builder setColor COLOR_VANILLA_LIGHT_BLUE) setInput "dyeLightBlue" build()
		recipe setShot (builder setColor COLOR_VANILLA_LIME) setInput "dyeLime" build()
		recipe setShot (builder setColor COLOR_VANILLA_MAGENTA) setInput "dyeMagenta" build()
		recipe setShot (builder setColor COLOR_VANILLA_ORANGE) setInput "dyeOrange" build()
		recipe setShot (builder setColor COLOR_VANILLA_PINK) setInput "dyePink" build()
		recipe setShot (builder setColor COLOR_VANILLA_PURPLE) setInput "dyePurple" build()
		recipe setShot (builder setColor COLOR_VANILLA_RED) setInput "dyeRed" build()
		recipe setShot (builder setColor COLOR_VANILLA_SILVER) setInput "dyeLightGray" build()
		recipe setShot (builder setColor COLOR_VANILLA_WHITE) setInput "dyeWhite" build()
		recipe setShot (builder setColor COLOR_VANILLA_YELLOW) setInput "dyeYellow" build()
	}
}

case class DanmakuRecipeBuilder(
		shot: ShotData = null, input: Either[String, ItemStack] = null, movement: MovementData = new MovementData(0.4D, 0.4D, 0D, Vector3.Zero)) {

	import net.katsstuff.journeytogensokyo.helper.Implicits._

	def setShot(shot: ShotData): DanmakuRecipeBuilder = {
		copy(shot = shot)
	}

	def setInput(string: String): DanmakuRecipeBuilder = {
		copy(input = Left(string))
	}

	def setInput(stack: ItemStack): DanmakuRecipeBuilder = {
		copy(input = Right(stack))
	}

	def setInput(block: Block): DanmakuRecipeBuilder = setInput(block.toStack)

	def setInput(item: Item): DanmakuRecipeBuilder = setInput(item.toStack)

	def setSpeed(speed: Double): DanmakuRecipeBuilder = {
		copy(movement = new MovementData(speed, speed, 0D, movement.getGravity))
	}

	def setGravity(gravity: Vector3): DanmakuRecipeBuilder = {
		copy(movement = movement.copy(gravity = gravity))
	}

	def build(): Unit = JTGAPI.addDanmakuRecipe(shot, movement, input.merge)

}