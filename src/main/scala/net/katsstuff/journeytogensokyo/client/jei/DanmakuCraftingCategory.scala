package net.katsstuff.journeytogensokyo.client.jei

import mezz.jei.api.IGuiHelper
import mezz.jei.api.gui.{IDrawable, IRecipeLayout}
import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.recipe.BlankRecipeCategory
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.resources.I18n
import net.minecraft.util.ResourceLocation

class DanmakuCraftingCategory(implicit guiHelper: IGuiHelper) extends BlankRecipeCategory[DanmakuCraftingRecipeWrapper] {

  final val Background = new ResourceLocation(LibMod.Id, "textures/gui/danmaku_crafting_table.png")

  override def setRecipe(recipeLayout: IRecipeLayout, recipeWrapper: DanmakuCraftingRecipeWrapper, ingredients: IIngredients): Unit = {
    val stackLayout = recipeLayout.getItemStacks


  }

  override def getUid:        String    = JtgJeiPlugin.danmakuCraftingCategoryUid
  override def getTitle:      String    = I18n.format("journeytogensokyo.jei.danmakucrafting.title")
  override def getBackground: IDrawable = guiHelper.createDrawable(Background, 0, 0, 256, 256)
}
