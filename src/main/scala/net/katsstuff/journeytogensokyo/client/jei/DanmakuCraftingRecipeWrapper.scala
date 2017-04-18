package net.katsstuff.journeytogensokyo.client.jei

import mezz.jei.api.ingredients.IIngredients
import mezz.jei.api.recipe.{BlankRecipeWrapper, IStackHelper}
import net.katsstuff.journeytogensokyo.api.recipe.RecipeDanmakuItem
import net.minecraft.client.Minecraft
import net.minecraft.item.ItemStack
import scala.collection.JavaConverters._

class DanmakuCraftingRecipeWrapper(recipe: RecipeDanmakuItem)(implicit stackHelper: IStackHelper) extends BlankRecipeWrapper {
  override def getIngredients(ingredients: IIngredients): Unit = {
    ingredients.setOutput(???, ???)
    ingredients.setInputLists(classOf[ItemStack], Seq(stackHelper.toItemStackList(recipe.input)).asJava)
  }

  override def drawInfo(minecraft: Minecraft, recipeWidth: Int, recipeHeight: Int, mouseX: Int, mouseY: Int): Unit = {}
}
