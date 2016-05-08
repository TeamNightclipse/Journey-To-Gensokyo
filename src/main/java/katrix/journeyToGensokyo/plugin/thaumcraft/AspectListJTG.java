/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thaumcraft;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

class AspectListJTG {

	//Blocks
	static final AspectList BLOCK_GENSOKYO_ORE = new AspectList().add(Aspect.SOUL, 2).add(Aspect.EARTH, 2).add(Aspect.MAGIC, 4);
	static final AspectList BLOCK_CELESTIAL_ORE = new AspectList().add(Aspect.SOUL, 2).add(Aspect.ELDRITCH, 2).add(Aspect.MAGIC, 4);
	static final AspectList BLOCK_DEMON_ORE = new AspectList().add(Aspect.SOUL, 2).add(Aspect.FIRE, 2).add(Aspect.MAGIC, 4);

	static final AspectList ITEM_GENSOKYO_DUST = new AspectList().add(Aspect.SOUL, 1).add(Aspect.EARTH, 1).add(Aspect.MAGIC, 2);
	static final AspectList ITEM_CELESTIAL_DUST = new AspectList().add(Aspect.SOUL, 1).add(Aspect.ELDRITCH, 1).add(Aspect.MAGIC, 2);
	static final AspectList ITEM_DEMON_DUST = new AspectList().add(Aspect.SOUL, 1).add(Aspect.FIRE, 1).add(Aspect.MAGIC, 2);

	static final AspectList ITEM_GENSOKYO_INGOT = new AspectList().add(Aspect.SOUL, 1).add(Aspect.EARTH, 1).add(Aspect.MAGIC, 2);
	static final AspectList ITEM_CELESTIAL_INGOT = new AspectList().add(Aspect.SOUL, 1).add(Aspect.ELDRITCH, 1).add(Aspect.MAGIC, 2);
	static final AspectList ITEM_DEMON_INGOT = new AspectList().add(Aspect.SOUL, 1).add(Aspect.FIRE, 1).add(Aspect.MAGIC, 2);

	static final AspectList ITEM_GENSOKYO_NOTE = new AspectList().add(Aspect.SOUL, 3).add(Aspect.EARTH, 3).add(Aspect.MAGIC, 6).add(Aspect.MIND, 3);
	static final AspectList ITEM_CELESTIAL_NOTE = new AspectList().add(Aspect.SOUL, 3).add(Aspect.ELDRITCH, 3).add(Aspect.MAGIC, 6).add(Aspect.MIND, 3);
	static final AspectList ITEM_DEMON_NOTE = new AspectList().add(Aspect.SOUL, 3).add(Aspect.FIRE, 3).add(Aspect.MAGIC, 6).add(Aspect.MIND, 3);

	static final AspectList ITEM_RUINED_GENSOKYO_NOTES = new AspectList().add(Aspect.MIND, 1);
	static final AspectList ITEM_GENSOKYO_NOTES_PAT = new AspectList().add(Aspect.MIND, 2);
	static final AspectList ITEM_GENSOKYO_NOTES_DUS = new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 3).add(Aspect.MAN, 1);
	static final AspectList ITEM_GENSOKYO_NOTES = new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 4).add(Aspect.MAN, 2);
	static final AspectList ITEM_GENSOKYO_NOTES_IMB = new AspectList().add(Aspect.SOUL, 1).add(Aspect.MAGIC, 2).add(Aspect.MIND, 4).add(Aspect.MAN, 2);
	static final AspectList ITEM_GENSOKYO_NOTES_ARC = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.MIND, 4).add(Aspect.MAN, 2);

	static final AspectList ITEM_POINT_ITEM = new AspectList().add(Aspect.SOUL, 1).add(Aspect.MAGIC, 2).add(Aspect.GREED, 2);
	static final AspectList ITEM_POWER_ITEM = new AspectList().add(Aspect.SOUL, 1).add(Aspect.MAGIC, 2).add(Aspect.ENERGY, 2);

	static final AspectList ENTITY_TH_FAIRY_ICE = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.COLD, 1);
	static final AspectList ENTITY_TH_FAIRY = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2);
	static final AspectList ENTITY_SUNFLOWER_FAIRY = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.PLANT, 1);
	static final AspectList ENTITY_TH_PHANTOM = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.DARKNESS, 1);
	static final AspectList ENTITY_CIRNO = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.COLD, 9);
	static final AspectList ENTITY_RUMIA = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.DARKNESS, 2);
	static final AspectList ENTITY_TOZIKO = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.ENERGY, 2);
	static final AspectList ENTITY_SANAE = new AspectList().add(Aspect.SOUL, 2).add(Aspect.MAGIC, 2).add(Aspect.MAN, 2);
	static final AspectList ENTITY_HANABEEPER = new AspectList().add(Aspect.MAGIC, 2).add(Aspect.PLANT, 2).add(Aspect.FIRE, 2);
	static final AspectList ENTITY_RINNOSUKE = ENTITY_SANAE;

}
