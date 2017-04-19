package net.katsstuff.journeytogensokyo.handler

import scala.util.Try

import com.google.common.base.Charsets
import com.google.common.io.Resources
import com.google.gson.GsonBuilder

import net.katsstuff.journeytogensokyo.helper.LogHelper
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.util.ResourceLocation
import net.minecraft.world.storage.loot.LootContext.EntityTarget
import net.minecraft.world.storage.loot.conditions.{LootCondition, LootConditionManager}
import net.minecraft.world.storage.loot.functions.{LootFunction, LootFunctionManager}
import net.minecraft.world.storage.loot.{LootContext, LootEntry, LootPool, LootTable, LootTableList, RandomValueRange}
import net.minecraftforge.common.ForgeHooks
import net.minecraftforge.event.LootTableLoadEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LootHandler {

  val toReplace = Seq(LootTableList.CHESTS_SIMPLE_DUNGEON, LootTableList.CHESTS_END_CITY_TREASURE, LootTableList.CHESTS_NETHER_BRIDGE)

  val poolNames: Seq[String] = Seq("gensokyo", "makai", "celestial").map(s => s"journeytogensokyo:extra_${s}_loot")

  @SubscribeEvent
  def onLoot(event: LootTableLoadEvent): Unit =
    if (toReplace.contains(event.getName)) {
      val custom = new ResourceLocation(LibMod.Id, event.getName.getResourcePath)

      for {
        table <- JTGLootTableLoader.loadTable(custom).toSeq
        poolName <- poolNames
        pool <- Option(table.getPool(poolName)).toSeq
      } {
        event.getTable.addPool(pool)
      }
    }

  def registerLootTables(): Unit =
    toReplace.map(r => new ResourceLocation(LibMod.Id, r.getResourcePath)).foreach(LootTableList.register)

  object JTGLootTableLoader {
    private val Gson = (new GsonBuilder)
      .registerTypeAdapter(classOf[RandomValueRange], new RandomValueRange.Serializer)
      .registerTypeAdapter(classOf[LootPool], new LootPool.Serializer)
      .registerTypeAdapter(classOf[LootTable], new LootTable.Serializer)
      .registerTypeHierarchyAdapter(classOf[LootEntry], new LootEntry.Serializer)
      .registerTypeHierarchyAdapter(classOf[LootFunction], new LootFunctionManager.Serializer)
      .registerTypeHierarchyAdapter(classOf[LootCondition], new LootConditionManager.Serializer)
      .registerTypeHierarchyAdapter(classOf[LootContext.EntityTarget], new EntityTarget.Serializer)
      .create

    def loadTable(resource: ResourceLocation): Option[LootTable] = {
      val url = Option(
        ClassLoader.getSystemClassLoader.getResource(s"assets/${resource.getResourceDomain}/loot_tables/${resource.getResourcePath}.json")
      )

      url.flatMap { url =>
        val res = Try(Resources.toString(url, Charsets.UTF_8))
          .flatMap(s => Try(ForgeHooks.loadLootTable(Gson, resource, s, false)))
          .map[Option[LootTable]](Some.apply)

        res.failed.foreach(e => LogHelper.error(s"Couldn\'t load loot table $resource from $url", e))

        res.getOrElse(None)
      }
    }
  }
}
