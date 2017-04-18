package net.katsstuff.journeytogensokyo.client.jei

import mezz.jei.api.ingredients.IModIngredientRegistration
import mezz.jei.api.{IJeiRuntime, IModPlugin, IModRegistry, ISubtypeRegistry, JEIPlugin}
import net.katsstuff.danmakucore.lib.data.LibItems
import net.katsstuff.journeytogensokyo.api.recipe.CraftingManager
import net.katsstuff.journeytogensokyo.block.JTGBlocks
import net.minecraft.item.ItemStack
import scala.collection.JavaConverters._

import net.katsstuff.danmakucore.entity.danmaku.form.Form
import net.katsstuff.danmakucore.registry.DanmakuRegistry

class JtgJeiPlugin extends IModPlugin {

  override def registerItemSubtypes(subtypeRegistry: ISubtypeRegistry): Unit = {
    subtypeRegistry.useNbtForSubtypes(LibItems.DANMAKU)
  }

  override def registerIngredients(registry: IModIngredientRegistration): Unit = {
    registry.register(classOf[Form], DanmakuRegistry.FORM.getValues, ???, ???)
  }

  override def register(registry: IModRegistry): Unit = {
    implicit val guiHelper = registry.getJeiHelpers.getGuiHelper
    implicit val stackHelper = registry.getJeiHelpers.getStackHelper

    registry.addRecipeCategories(new DanmakuCraftingCategory)
    registry.addRecipeHandlers(new DanmakuCraftingHandler)
    registry.addRecipeCategoryCraftingItem(new ItemStack(JTGBlocks.BlockDanmakuCrafting), JtgJeiPlugin.danmakuCraftingCategoryUid)
    registry.addRecipes(CraftingManager.getRecipes)
  }

  override def onRuntimeAvailable(jeiRuntime: IJeiRuntime): Unit = {}
}
object JtgJeiPlugin {
  final val danmakuCraftingCategoryUid = "danmakucrafting"
}
