/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.plugin.botania;

import java.util.List;

import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityFamiliar;
import thKaguyaMod.entity.shot.EntityTHShot;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;

public class SubTileSpiritFlower extends SubTileGenerating {

	private static final int RANGE = 3;
	private int cooldown = 0;

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (mana != getMaxMana()) {
			@SuppressWarnings("unchecked")
			List<EntityTHShot> shots = supertile.getWorldObj().getEntitiesWithinAABB(EntityTHShot.class,
					AxisAlignedBB.getBoundingBox(supertile.xCoord - RANGE, supertile.yCoord - RANGE, supertile.zCoord - RANGE, supertile.xCoord + RANGE + 1,
							supertile.yCoord + RANGE + 1, supertile.zCoord + RANGE + 1));
			for (EntityTHShot shot : shots) {
				if (!shot.isDead) {
					if(!supertile.getWorldObj().isRemote && !(shot.user instanceof EntityFamiliar) && !(shot.source instanceof EntityStandardShot && cooldown == 0)) {
						shot.setDead();
						mana += 50;
						cooldown = 5;
						sync();
					}

					for (int i = 0; i < 50; i++) {
						BotaniaAPI.internalHandler.sparkleFX(supertile.getWorldObj(), shot.posX + Math.random() * 4 - 2, shot.posY + Math.random() * 4 - 2,
										shot.posZ + Math.random() * 4 - 2, 1F, (float)Math.random() * 0.25F, (float)Math.random() * 0.25F,
										(float)(Math.random() * 0.5F + 0.5F), 4);
					}

					return;
				}
			}
		}
		else {
			EntityFamiliar living = new EntityFamiliar(supertile.getWorldObj());
			ShotData shotData = ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RANDOM, 0, 10, LibSpecialShotId.SPIRITULIP01);
			THShotLib.createShot(living, Vec3.createVectorHelper(supertile.xCoord, supertile.yCoord + 1, supertile.zCoord), THShotLib.angle(0, 1, 0), 0.4D,
					shotData);
			mana -= getMaxMana();
			cooldown = 80;
		}
		if (cooldown != 0) {
			cooldown--;
		}
	}

	@Override
	public int getColor() {
		return 0xcb0000;
	}

	@Override
	public int getMaxMana() {
		return 300;
	}

	@Override
	public RadiusDescriptor getRadius() {
		return new RadiusDescriptor.Square(toChunkCoordinates(), RANGE);
	};

	@Override
	public LexiconEntry getEntry() {
		return JTGBotania.spiritFlowerLexicon;
	}

}