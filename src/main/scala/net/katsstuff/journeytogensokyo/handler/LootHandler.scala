/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.handler

import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.util.ResourceLocation
import net.minecraft.world.storage.loot.LootTableList
import net.minecraftforge.event.LootTableLoadEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class LootHandler {

  val toReplace = Seq(LootTableList.CHESTS_SIMPLE_DUNGEON, LootTableList.CHESTS_END_CITY_TREASURE, LootTableList.CHESTS_NETHER_BRIDGE)

  val poolNames: Seq[String] = Seq("gensokyo", "makai", "celestial").map(s => s"journeytogensokyo:extra_${s}_loot")

  @SubscribeEvent
  def onLoot(event: LootTableLoadEvent): Unit =
    if (toReplace.contains(event.getName)) {
      val custom = new ResourceLocation(LibMod.Id, event.getName.getResourcePath)
      val tableManager = event.getLootTableManager
      val table = tableManager.getLootTableFromLocation(custom)

      for {
        poolName <- poolNames
        pool     <- Option(table.getPool(poolName)).toSeq
      } {
        event.getTable.addPool(pool)
      }
    }

  def registerLootTables(): Unit =
    toReplace.map(r => new ResourceLocation(LibMod.Id, r.getResourcePath)).foreach(LootTableList.register)
}
