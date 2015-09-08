/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thsc.entity;

import com.katrix.journeyToGensokyo.handler.ConfigHandler;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.world.World;
import thKaguyaMod.entity.living.EntityFamiliar;

public class EntityFamiliarIce extends EntityFamiliar {

	public EntityFamiliarIce(World world) {
		super(world);
		
     	setForm((byte)6);
     	this.setSpeed(0.6D);
     	this.setAttackDistance(12.0D);
     	this.setFlyingHeight(3);
	}
	
    public static void Init() {
    	
    	EntityRegistry.registerGlobalEntityID(EntityFamiliarIce.class, "FamiliarIce", ConfigHandler.entityIdFamiliarIce);
    	
    }

}
