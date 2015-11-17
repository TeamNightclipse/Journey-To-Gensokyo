/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import java.util.List;

import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import katrix.journeyToGensokyo.reference.SpellcardID;
import katrix.journeyToGensokyo.util.LogHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityTHLaser;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.init.THKaguyaItems;
import thKaguyaMod.item.ItemTHShot;

/** 楽園の素敵な巫女　博麗 霊夢 */
public class EntityYukari extends EntityDanmakuMob
{
	
	public int invicibilityTimer;
	
	public EntityYukari(World world)
    {
        super(world);
        
        this.setSize(1.0F, 2.0F);
        
        this.experienceValue = 250;
        
        this.setDanmakuMobName("Yukari Yakumo");
        this.setSpecies(this.SPECIES_YOUKAI);
    	
    	this.setDanmakuPattern(NORMAL_ATTACK01);
    	this.setMaxHP(100.0F);
        this.setHealth(100.0F);
        this.setSpeed(0.45F);
        this.setAttackDistance(20.0D);
    	this.setDetectionDistance(20.0D);
    	this.setFlyingHeight(4);
    	this.isFlyingMode = true;
    	
    	this.isSpellCardMode = false;
    	this.attackInterval = 0;
    }
	
    /**
     * 使用しているスペルカードNoを返す
     * @return 使用しているスペルカードNo
     */
    public int getUsingSpellCardNo()
    {
    	switch(this.getDanmakuPattern())
    	{
    		case SPELLCARD_ATTACK01:
    			return EntitySpellCard.SC_YUKARI_HikouchuuNest; //Fantasy Nest "Flying-glowworm Nest"
    		case SPELLCARD_ATTACK02:
    			return SpellcardID.DREAMS_AND_REALITY; //Boundary "Curse of Dreams and Reality"
    		case SPELLCARD_ATTACK03:
    			return EntitySpellCard.SC_YUKARI_NijuuKokushichou; //Sinister Spirits "Double Black Death Butterfly"
    		case SPELLCARD_ATTACK04:
    			return SpellcardID.MESH_LIGHT_DARKNESS; //Boundary "Mesh of Light and Darkness"
    		case SPELLCARD_ATTACK05:
    			return EntitySpellCard.SC_YUKARI_Nami_to_Tubu_no_Kyoukai; //Boundary Sign "Boundary between Wave and Particle" 
    		default:
    			return -1;
    	}
    }
    
    //死んでいるときに呼ばれる
    @Override
    protected void onDeathUpdate()
    {
    	switch(getDanmakuPattern())
    	{
    		case NORMAL_ATTACK01:
    			moveDanmakuAttack(SPELLCARD_ATTACK01, 10, 40.0F, 160);
    			break;
    		case SPELLCARD_ATTACK01:
    			moveDanmakuAttack(NORMAL_ATTACK02, 10, 40.0F, 160);
    			break;
    		case NORMAL_ATTACK02:
    			moveDanmakuAttack(SPELLCARD_ATTACK02, 10, 60.0F, 160);
    			break;
    		case SPELLCARD_ATTACK02:
    			moveDanmakuAttack(NORMAL_ATTACK03, 10, 40.0F, 160);
    			break;
    		case NORMAL_ATTACK03:
    			moveDanmakuAttack(SPELLCARD_ATTACK03, 10, 100.0F, 160);
    			break;
    		case SPELLCARD_ATTACK03:
    			moveDanmakuAttack(NORMAL_ATTACK04, 10, 40.0F, 160);
    			break;
    		case NORMAL_ATTACK04:
    			moveDanmakuAttack(SPELLCARD_ATTACK04, 10, 40.0F, 160);
    			break;
    		case SPELLCARD_ATTACK04:
    			moveDanmakuAttack(NORMAL_ATTACK05, 10, 40.0F, 160);
    			break;
    		case NORMAL_ATTACK05:
    			moveDanmakuAttack(SPELLCARD_ATTACK05, 10, 40.0F, 160);
    			break;
    		case SPELLCARD_ATTACK05:
    			moveDanmakuAttack(ATTACK_END, 10, 0.0F, 160);
    			break;
    		default:
    			if(deathTime % 6 == 0)
    			{
    				THShotLib.explosionEffect(worldObj, posX, posY, posZ, 1.0F + deathTime * 0.1F);
    			}
    			super.onDeathUpdate();
    			break;
    	}
    }

    
    /**
     * 弾幕のパターンを記述
     * @param level : EASY～LUNATICの難易度
     */
    @Override
    public void danmakuPattern(int level)
    {
    	Vec3 look = this.getLookVec();
    	switch(getDanmakuPattern())
    	{
    		case NORMAL_ATTACK01:
    			danmaku01(look, level);
    			break;
    		case SPELLCARD_ATTACK01:
    			spellcard01(look, level);
    			break;
    		case NORMAL_ATTACK02:
    			danmaku02(look, level);
    			break;
    		case SPELLCARD_ATTACK02:
    			spellcard02(look, level);
    			break;
    		case NORMAL_ATTACK03:
    			danmaku03(look, level);
    			break;
    		case SPELLCARD_ATTACK03:
    			spellcard03(look, level);
    			break;
    		case NORMAL_ATTACK04:
    			danmaku04(look, level);
    			break;
    		case SPELLCARD_ATTACK04:
    			spellcard04(look, level);
    			break;
    		case NORMAL_ATTACK05:
    			danmaku05(look, level);
    			break;
    		case SPELLCARD_ATTACK05:
    			spellcard05(look, level);
    			break;
    		default:
    			break;
    	}
    }
    
    private void danmaku01(Vec3 angle, int level)
    {
    	if(attackCounter == 1){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), angle, 0.3D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.PURPLE, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
    	}
    	
    	else if(attackCounter == 2){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), angle, 0.31D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.PURPLE, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
        	THShotLib.createCircleShot(this, pos(), angle, 0.5D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.PURPLE, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
    	}
    	if(attackCounter >= 10){
    		attackCounter = 0;
    	}
    }
    
    private void spellcard01(Vec3 angle, int level)
    {
		if(attackCounter == 1)
		{
			this.useSpellCard(EntitySpellCard.SC_YUKARI_HikouchuuNest);
		}
		
    	if(attackCounter >= 170){
    		attackCounter = 0;
    	}
    }
    
    private void danmaku02(Vec3 angle, int level)
    {
    	if(attackCounter == 1){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), angle, 0.3D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.PURPLE, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
    	}
    	
    	else if(attackCounter == 2){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), angle, 0.4D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
        	THShotLib.createCircleShot(this, pos(), angle, 0.5D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 12*level);
    	}
    	
    	if(attackCounter >= 10){
    		attackCounter = 0;
    	}
    }
    
    private void spellcard02(Vec3 angle, int level)
    {
		if(attackCounter == 1)
		{
			this.useSpellCard(SpellcardID.DREAMS_AND_REALITY);
		}
		
    	if(attackCounter >= 130){
    		attackCounter = 0;
    	}
    }
    
    private void danmaku03(Vec3 angle, int level)
    {
    	if(attackCounter == 1){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), angle, 0.3D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 32*level);
        	THShotLib.createCircleShot(this, pos(), angle, 0.6D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 32*level);
    	}
    	
    	if(attackCounter >= 20){
    		attackCounter = 0;
    	}
    }
    
    private void spellcard03(Vec3 angle, int level)
    {
		if(attackCounter == 1)
		{
			this.useSpellCard(EntitySpellCard.SC_YUKARI_NijuuKokushichou);
		}
		
    	if(attackCounter >= 150){
    		attackCounter = 0;
    	}
    }
    
    private void danmaku04(Vec3 angle, int level)
    {
    	if(attackCounter % 2 == 0){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter*5, rotationPitch), 0.3D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.GREEN, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 2*level);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter*5, rotationPitch), 0.4D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.GREEN, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 2*level);
    	}
    	
    	if(attackCounter % 2 == 1){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw - attackCounter*5, rotationPitch), 0.3D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 2*level);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw - attackCounter*5, rotationPitch), 0.4D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 60), 2*level);
    	}
    	
    	if(attackCounter >= 60){
    		attackCounter = 0;
    	}
    }
    
    private void spellcard04(Vec3 angle, int level)
    {
		if(attackCounter == 1)
		{
			this.useSpellCard(SpellcardID.MESH_LIGHT_DARKNESS);
		}
		
    	if(attackCounter >= 100){
    		attackCounter = 0;
    	}
    }
    
    private void danmaku05(Vec3 angle, int level)
    {
    	if(attackCounter % 3 == 0){
    		THShotLib.playShotSound(this);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter*5, rotationPitch), 0.4D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 50), 4*level);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter*5, rotationPitch), 0.5D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 50), 4*level);
        	THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter*5, rotationPitch), 0.6D, ShotData.shot(THShotLib.FORM_KUNAI, THShotLib.AQUA, THShotLib.SIZE[THShotLib.FORM_KUNAI], 1.5f, 0, 50), 4*level);
    	}
    	
    	if(attackCounter >= 60){
    		attackCounter = 0;
    	}
    }
    
    private void spellcard05(Vec3 angle, int level)
    {
    	LogHelper.info(attackCounter);
		if(attackCounter == 1)
		{
			this.useSpellCard(EntitySpellCard.SC_YUKARI_Nami_to_Tubu_no_Kyoukai);
		}
		
    	if(attackCounter >= 300){
    		attackCounter = 0;
    	}
    }
    
    @Override
	public void onUpdate()
    {
    	super.onUpdate();
    	int range = 2;
    	List<EntityTHShot> listShot = worldObj.getEntitiesWithinAABB(EntityTHShot.class, AxisAlignedBB.getBoundingBox(this.posX - range, this.posY - range, this.posZ - range, this.posX + range + 1, this.posY + range + 1, this.posZ + range + 1));
    	
    	for(int i = 0; i < listShot.size(); i++){
    		EntityTHShot shots = listShot.get(i);
    		if(shots.source instanceof EntitySpellCard && shots.user != this){
    			shots.delete();
    			invicibilityTimer += 3;
    		}
    	}
    	
    	List<EntityTHLaser> listLaser = worldObj.getEntitiesWithinAABB(EntityTHLaser.class, AxisAlignedBB.getBoundingBox(this.posX - range, this.posY - range, this.posZ - range, this.posX + range + 1, this.posY + range + 1, this.posZ + range + 1));
    	
    	for(int i = 0; i < listLaser.size(); i++){
    		EntityTHLaser lasers = listLaser.get(i);
    		if(lasers.source instanceof EntitySpellCard  && lasers.user != this){
    			invicibilityTimer += 3;
    		}
    	}
    	
    	List<EntitySpellCard> listspellcard = worldObj.getEntitiesWithinAABB(EntitySpellCard.class, AxisAlignedBB.getBoundingBox(this.posX - range*12, this.posY - range*12, this.posZ - range*12, this.posX + range*12 + 1, this.posY + range*12 + 1, this.posZ + range*12 + 1));
    	
    	for(int i = 0; i < listspellcard.size(); i++){
    		EntitySpellCard spellcards = listspellcard.get(i);
    		if(spellcards.user != this){
    			invicibilityTimer += 3;
    		}
    	}
    	
    	if(invicibilityTimer > 0)
    	{
    		LogHelper.info(invicibilityTimer);
        	if(invicibilityTimer > 28)
        	{
        		LogHelper.info(invicibilityTimer);
        		invicibilityTimer = 28;
        	}
    		invicibilityTimer--;
    	}
    }
    
    @Override
    public boolean isEntityInvulnerable()
    {
    	if(invicibilityTimer > 0)
    	{
    		return true;
    	}
    	return false;
    }
    
    @Override
    protected boolean canFairyCall()
    {
    	return false;
    }
    
    @Override
    protected float applyPotionDamageCalculations(DamageSource damageSource, float damage)
    {
        damage = super.applyPotionDamageCalculations(damageSource, damage);

        if (isEntityInvulnerable())
        {
            damage = (float)((double)damage * 0.05D);
        }

        return damage;
    }
    
    public boolean attackEntityFrom(DamageSource damageSource, float amount)
    {
    	if(!damageSource.isMagicDamage()){
    		amount *= 0.5F;
    	}
    	this.isFlyingMode = true;
    	this.setFlyingHeight(4);
        return super.attackEntityFrom(damageSource, amount);
    }
	
	@Override
	protected void dropFewItems(boolean hasBeenAttackedByPlayer, int lootingLevel)
    {
		super.dropFewItems(hasBeenAttackedByPlayer, lootingLevel);
		
		if( hasBeenAttackedByPlayer && this.isSpellCardAttack() )
		{
	        int j = 40;
	        int k;
	        Vec3 vec3;
	        float yaw, pitch;
	
	        for (k = 0; k < j; k+=2)
	        {
	        	yaw = 360F / (float)j * (float)k;
	        	pitch = MathHelper.sin( yaw / 180F * 3.141593F * 4F) * 20F - 60F;
	        	vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
	        	this.dropPointItem(this.pos(), vec3);
	        	yaw = 360F / (float)j * (float)(k + 1);
	        	pitch = MathHelper.cos( yaw / 180F * 3.141593F * 4F) * 20F - 60F;
	        	vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
	        	this.dropPowerUpItem(this.pos(), vec3);
	        }
	        
	        this.dropShotItem(ItemTHShot.KUNAI, 17 + rand.nextInt(2) + lootingLevel, 5, 32, THShotLib.BLUE, 0, 0, 2);
		}
        if( hasBeenAttackedByPlayer && getDanmakuPattern() == SPELLCARD_ATTACK05)
        {
        	this.dropItem(THKaguyaItems.gapFoldingUmbrella, 1);
        	this.dropItem(THKaguyaItems.gap, 16);
        }
    }
    
	@Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

	@Override
    public boolean getCanSpawnHere()
    {
    	return false;
    }
	
    public static void postInit() 
    {
    	EntityRegistry.registerModEntity(EntityYukari.class, EntityName.YUKARI,  MobID.YUKARI, JourneyToGensokyo.instance, 80, 1, true);
    }
}