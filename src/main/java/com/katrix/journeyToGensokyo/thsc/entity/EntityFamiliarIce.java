package com.katrix.journeyToGensokyo.thsc.entity;

import com.katrix.journeyToGensokyo.Config;
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
    	
    	EntityRegistry.registerGlobalEntityID(EntityFamiliarIce.class, "FamiliarIce", Config.entityIdFamiliarIce);
    	
    }

}
