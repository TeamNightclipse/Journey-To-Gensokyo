package katrix.journeyToGensokyo.plugin.thsc.entity.shot;

import java.util.List;

import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotMissile implements ISpecialShot {

	private int range = 2;

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
	}

	@Override
	public boolean specialShot_hitBlock(World world, int id, EntityTHShot shot, MovingObjectPosition movingObjectPosition) {
		switch (id) {
			case LibSpecialShotId.MISSILE01:

				//TODO: Particle is bugged. Find a way to fix it.
				if (!world.isRemote) {
					//Explosion explode = world.newExplosion(shot.user, shot.posX, shot.posY, shot.posZ, 2F, false, false);

					world.spawnParticle("hugeexplosion", shot.posX, shot.posY, shot.posZ, 0.0D, 0.0D, 0.0D);
					world.playSoundEffect(shot.posX, shot.posY, shot.posZ, "random.explode", 4.0F,
							(1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F) * 0.7F);

					@SuppressWarnings("unchecked")
					List<EntityLivingBase> listEntity = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(shot.posX - range,
							shot.posY - range, shot.posZ - range, shot.posX + range + 1, shot.posY + range + 1, shot.posZ + range + 1));

					for (int i = 0; i < listEntity.size(); i++) {
						EntityLivingBase living = listEntity.get(i);
						living.attackEntityFrom(DamageSource.causeIndirectMagicDamage(shot, shot.user), shot.damageRate);
					}
				}
				return false;
			default:
				return false;
		}
	}

	@Override
	public boolean specialShot_hitEntity(World world, int id, EntityTHShot shot, Entity entity_Hit) {
		switch (id) {
			case LibSpecialShotId.MISSILE01:

				//TODO: Particle is bugged. Find a way to fix it.
				world.spawnParticle("hugeexplosion", shot.posX, shot.posY, shot.posZ, 1.0D, 0.0D, 0.0D);
				world.playSoundEffect(shot.posX, shot.posY, shot.posZ, "random.explode", 4.0F,
						(1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F) * 0.7F);

				if (!world.isRemote) {
					@SuppressWarnings("unchecked")
					List<EntityLivingBase> listEntity = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(shot.posX - range,
							shot.posY - range, shot.posZ - range, shot.posX + range + 1, shot.posY + range + 1, shot.posZ + range + 1));

					for (int i = 0; i < listEntity.size(); i++) {
						EntityLivingBase living = listEntity.get(i);
						living.attackEntityFrom(DamageSource.causeIndirectMagicDamage(shot, shot.user), shot.damageRate);
					}
				}
				return false;
			default:
				return false;
		}
	}

}
