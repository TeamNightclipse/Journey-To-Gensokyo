/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import katrix.journeyToGensokyo.net.PacketHandler;
import katrix.journeyToGensokyo.net.PacketSmoothCamera;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroJTG;
import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.entity.spellcard.THSpellCard;

public class THSC_FinalSpark extends THSpellCard {

	private EntityMiniHakkeroJTG miniHakkero;

	public THSC_FinalSpark() {
		setNeedLevel(10);
		setRemoveTime(100);
		setEndTime(150);
		setOriginalUserName(MARISA);
	}

	@Override
	public void init(World worldObj, EntitySpellCard entitySpellCard, EntityLivingBase living_user, EntityLivingBase living_target, int spLevel) {
		super.init(worldObj, entitySpellCard, living_user, living_target, spLevel);
		miniHakkero = new EntityMiniHakkeroJTG(world, user, card, true, 30, 100, false, false);
		world.spawnEntityInWorld(miniHakkero);
	}

	@Override
	public void spellcard_main() {

		miniHakkero.setLocationAndAngles(userPosX, userPosY, userPosZ, user.rotationYaw, user.rotationPitch);
		miniHakkero.getLaser().get(0).angle = user.getLookVec();

		if (time == 30) {
			if (user instanceof EntityPlayerMP) {
				IMessage msg = new PacketSmoothCamera(true);
				PacketHandler.net.sendTo(msg, (EntityPlayerMP)user);
			}
		}

		if (time >= 30 && time <= 100) {

			Vec3 look = user.getLookVec();
			if (time % 2 == 0) {
				user.addVelocity(-look.xCoord * 0.2, -look.yCoord * 0.2, -look.zCoord * 0.2);
				user.setPosition(user.posX + user.motionX, user.posY + user.motionY, user.posZ + user.motionZ);
				if (user instanceof EntityPlayer) {
					((EntityPlayerMP)user).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(user));
				}
			}

			double xVector, yVector, zVector, angleXZ, X1, Z1, X2, Z2;
			int pieces = 12;
			double speed = Math.PI * 2;

			Vec3 lookAt = THShotLib.angle(user.rotationYaw, user.rotationPitch + 90F);
			double angle = time * speed;
			double angleSpan = 360D / pieces;
			double gRate = 0.034 + 0.03D * MathHelperJTG.sin(Math.toRadians(angle));

			Vec3 gravity = THShotLib.getVecFromAngle(user.rotationYaw, user.rotationPitch, gRate);
			ShotData shot = ShotData.shot(DanmakuConstants.FORM_STAR, time % 7, 0.5F, 8.0F, 0, 55);

			double userYawRad = Math.toRadians(user.rotationYaw);
			double userPitchRad = Math.toRadians(user.rotationPitch + 90F);
			double userYawSin = MathHelperJTG.sin(userYawRad);
			double userYawCos = MathHelperJTG.cos(userYawRad);
			double userPitchSin = MathHelperJTG.sin(userPitchRad);

			double angleY = 0;
			double angleYRad = Math.toRadians(angleY);
			double angleYSin = MathHelperJTG.sin(angleYRad);
			double angleYCos = MathHelperJTG.cos(angleYRad);

			for (int i = 0; i < pieces; i++) {
				angleXZ = Math.toRadians(angle);
				double angleXZSin = MathHelperJTG.sin(angleXZ);
				double angleXZCos = MathHelperJTG.cos(angleXZ);

				X1 = angleXZSin * userYawCos;
				Z1 = angleXZSin * userYawSin;
				X2 = angleXZCos * angleYSin * userPitchSin * userYawSin;
				Z2 = angleXZCos * angleYSin * userPitchSin * userYawCos;

				yVector = -angleXZCos * MathHelperJTG.sin(userPitchRad - angleYRad);
				xVector = angleXZCos * angleYCos * lookAt.xCoord + X1 - X2;
				zVector = angleXZCos * angleYCos * lookAt.zCoord + Z1 + Z2;

				THShotLib.createShot(user, card, pos_User(user.getLookVec(), 0.7D), angle(xVector, yVector, zVector), 0F, 0.1D, 0.5D, 0.15D, gravity, shot);
				angle += angleSpan;
			}
		}

		if (time == 100) {
			if (user instanceof EntityPlayerMP) {
				IMessage msg = new PacketSmoothCamera(false);
				PacketHandler.net.sendTo(msg, (EntityPlayerMP)user);
			}
		}
	}
}
