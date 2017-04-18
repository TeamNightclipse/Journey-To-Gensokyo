package net.katsstuff.journeytogensokyo.client.jei

import java.awt.Color
import java.{lang, util}

import scala.collection.JavaConverters._

import mezz.jei.api.ingredients.{IIngredientHelper, IIngredientRenderer}
import net.katsstuff.danmakucore.entity.danmaku.form.Form
import net.katsstuff.danmakucore.entity.danmaku.subentity.SubEntityType
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraft.client.resources.I18n

object Ingredients {

  object FormIngredientsHelper extends IIngredientHelper[Form] {
    override def expandSubtypes(ingredients: util.List[Form]): util.List[Form] = ingredients

    override def getMatch(ingredients: lang.Iterable[Form], ingredientToMatch: Form): Form = ingredients.asScala.find(_ == ingredientToMatch).orNull

    override def getDisplayName(ingredient: Form): String = I18n.format(ingredient.getUnlocalizedName)
    override def getUniqueId(ingredient:    Form): String = ingredient.getRegistryName.toString
    override def getWildcardId(ingredient:  Form): String = getUniqueId(ingredient)
    override def getModId(ingredient:       Form): String = ingredient.getModId

    override def getColors(ingredient:    Form): lang.Iterable[Color] = Seq[Color]().asJava
    override def getErrorInfo(ingredient: Form): String =
      if (ingredient == null) "null"
      else if (ingredient.getRegistryName == null) "Null registry name"
      else ingredient.getRegistryName.toString
  }

  object SubEntityIngredientsHelper extends IIngredientHelper[SubEntityType] {
    override def expandSubtypes(ingredients: util.List[SubEntityType]): util.List[SubEntityType] = ingredients

    override def getMatch(ingredients: lang.Iterable[SubEntityType], ingredientToMatch: SubEntityType): SubEntityType =
      ingredients.asScala.find(_ == ingredientToMatch).orNull

    override def getDisplayName(ingredient: SubEntityType): String = I18n.format(ingredient.getUnlocalizedName)
    override def getUniqueId(ingredient:    SubEntityType): String = ingredient.getRegistryName.toString
    override def getWildcardId(ingredient:  SubEntityType): String = getUniqueId(ingredient)
    override def getModId(ingredient:       SubEntityType): String = ingredient.getModId

    override def getColors(ingredient:    SubEntityType): lang.Iterable[Color] = Seq[Color]().asJava
    override def getErrorInfo(ingredient: SubEntityType): String =
      if (ingredient == null) "null"
      else if (ingredient.getRegistryName == null) "Null registry name"
      else ingredient.getRegistryName.toString
  }

  object FormIngredientsRenderer extends IIngredientRenderer[Form] {
    override def render(minecraft:          Minecraft, xPosition:  Int, yPosition: Int, ingredient: Form): Unit = ???
    override def getTooltip(minecraft:      Minecraft, ingredient: Form): util.List[String] = ???
    override def getFontRenderer(minecraft: Minecraft, ingredient: Form): FontRenderer = ???
  }

}
