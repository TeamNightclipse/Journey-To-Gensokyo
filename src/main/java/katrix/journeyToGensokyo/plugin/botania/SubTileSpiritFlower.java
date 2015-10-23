/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Jun 7, 2014, 10:59:44 PM (GMT)]
 */
package katrix.journeyToGensokyo.plugin.botania;

import java.util.List;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityFamiliar;
import thKaguyaMod.entity.shot.EntityTHShot;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;
import vazkii.botania.common.Botania;

public class SubTileSpiritFlower extends SubTileGenerating {

	private static final int RANGE = 3;

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(mana != getMaxMana()) {
			List<EntityTHShot> shots = supertile.getWorldObj().getEntitiesWithinAABB(EntityTHShot.class, AxisAlignedBB.getBoundingBox(supertile.xCoord - RANGE, supertile.yCoord - RANGE, supertile.zCoord - RANGE, supertile.xCoord + RANGE + 1, supertile.yCoord + RANGE + 1, supertile.zCoord + RANGE + 1));
			for(EntityTHShot shot : shots) {
				if(!shot.isDead && !(shot.user instanceof EntityFamiliar)) {
					if(!supertile.getWorldObj().isRemote) {
						shot.setDead();
						mana += 50;
						sync();
					}

					for(int i = 0; i < 50; i++)
						Botania.proxy.sparkleFX(shot.worldObj, shot.posX + Math.random() * 4 - 2, shot.posY + Math.random() * 4 - 2, shot.posZ + Math.random() * 4 - 2, 1F, (float) Math.random() * 0.25F, (float) Math.random() * 0.25F, (float) (Math.random() * 0.5F + 0.5F), 4);

					return;
				}
			}
		}
		else{
			EntityFamiliar living = new EntityFamiliar(supertile.getWorldObj());
			THShotLib.createSphereShot(living, Vec3.createVectorHelper(supertile.xCoord, supertile.yCoord+1, supertile.zCoord), THShotLib.angle_Random(), 0.4D, new ShotData(THShotLib.FORM_BIG, THShotLib.RANDOM, THShotLib.SIZE[THShotLib.FORM_BIG], 0.5f, 0, 60, 0), 8, 0.0f);
			mana -= getMaxMana();
		}
	}

	@Override
	public int getColor() {
		return 0xcb0000;
	}

	@Override
	public int getMaxMana() {
		return 500;
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