/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import net.minecraft.world.World;
import thKaguyaMod.entity.living.EntityFamiliar;

public class EntityFamiliarIce extends EntityFamiliar {

	public EntityFamiliarIce(World world) {
		super(world);

		setForm((byte)6);
		setSpeed(0.6D);
		setAttackDistance(12.0D);
		setFlyingHeight(3);
	}

	public static void postInit() {

		EntityRegistry.registerModEntity(EntityFamiliarIce.class, EntityName.FAMILIAR_ICE, MobID.FAMILIAR_ICE, JourneyToGensokyo.instance, 80, 1, true);

	}

}
