package net.katsstuff.journeytogensokyo.client.jei

import mezz.jei.api.recipe.{IRecipeHandler, IRecipeWrapper, IStackHelper}
import net.katsstuff.journeytogensokyo.api.recipe.RecipeDanmakuItem

class DanmakuCraftingHandler(implicit stackHelper: IStackHelper) extends IRecipeHandler[RecipeDanmakuItem] {
  override def getRecipeClass: Class[RecipeDanmakuItem] = classOf[RecipeDanmakuItem]
  override def getRecipeCategoryUid: String = JtgJeiPlugin.danmakuCraftingCategoryUid
  override def getRecipeCategoryUid(recipe: RecipeDanmakuItem): String = JtgJeiPlugin.danmakuCraftingCategoryUid

  override def getRecipeWrapper(recipe: RecipeDanmakuItem): IRecipeWrapper = new DanmakuCraftingRecipeWrapper(recipe)

  override def isRecipeValid(recipe: RecipeDanmakuItem): Boolean = {
    recipe.outputMovement() != null && recipe.outputShotData() != null
  }
}
