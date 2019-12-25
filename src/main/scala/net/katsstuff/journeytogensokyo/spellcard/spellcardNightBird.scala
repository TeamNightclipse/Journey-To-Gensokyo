package net.katsstuff.journeytogensokyo.spellcard
import net.katsstuff.journeytogensokyo.lib.LibSpellcardName
import net.katsstuff.journeytogensokyo.shape.ShapeWideSlow
import net.katsstuff.teamnightclipse.danmakucore.EnumDanmakuLevel
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.{EntitySpellcard, Spellcard, SpellcardEntity}
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuHelper
import net.katsstuff.teamnightclipse.danmakucore.shape.ShapeHandler
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase

class SpellcardNightBird extends Spellcard(LibSpellcardName.NightBird) {
  override def instantiate(card: EntitySpellcard, target: Option[EntityLivingBase]): SpellcardEntity =
    new SpellcardEntityNightBird(this, card, target)

  override def level: Int = 1

  override def removeTime: Int = 80

  override def endTime: Int = 120

  override def touhouUser: TouhouCharacter = TouhouCharacter.RUMIA
}
class SpellcardEntityNightBird(
    spellcard: Spellcard,
    card: EntitySpellcard,
    target: Option[EntityLivingBase]
) extends SpellcardEntity(spellcard, card, target) {

  override def onSpellcardUpdate(): Unit = {
    if(time < 80) {
      if (time % 20 == 0) {
        spawnWave(LibColor.COLOR_SATURATED_BLUE, reverse = false)
      }

      if (time % 20 == 10) {
        spawnWave(LibColor.COLOR_SATURATED_CYAN, reverse = true)
      }
    }
  }

  private def spawnWave(color: Int, reverse: Boolean): Unit = {
    danmakuLevel = EnumDanmakuLevel.NORMAL
    val waves = danmakuLevel.getMultiplier / 2
    val height = danmakuLevel.getMultiplier / 2

    for(i <- 1 to math.max(2, waves); j <- -height to height) {
      val danmaku = DanmakuTemplate.builder
        .setUser(user)
        .setSource(cardEntity)
        .setShot(LibShotData.SHOT_CIRCLE.setEdgeColor(color))
        .setMovementData(0.2D + (0.025D * i))
        .setOrientation(Quat.fromEuler(0F, 5 * j, 0F))
        .build

      //TODO: Make ShapeHandler use target of living entity if it exists
      ShapeHandler.createShape(new ShapeWideSlow(danmaku, danmakuLevel.getMultiplier * 2, 45F, 20F, i * 0.5D, 8, reverse), user)
      DanmakuHelper.playSoundAt(danmaku.world, danmaku.pos, LibSounds.SHOT1, 0.1F, 1F)
    }
  }
}
