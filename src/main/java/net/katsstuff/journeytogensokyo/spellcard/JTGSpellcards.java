package net.katsstuff.journeytogensokyo.spellcard;

import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.katsstuff.journeytogensokyo.lib.LibSpellcardName;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardDummy;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGSpellcards {

	@ObjectHolder(LibSpellcardName.MoonlightRay)
	public static final Spellcard MoonlightRay = SpellcardDummy.instance();

	@ObjectHolder(LibSpellcardName.NightBird)
	public static final Spellcard NightBird = SpellcardDummy.instance();

	@ObjectHolder(LibSpellcardName.Demarcation)
	public static final Spellcard Demarcation = SpellcardDummy.instance();

	@ObjectHolder(LibSpellcardName.MeshLightDarkness)
	public static final Spellcard MeshLightDarkness = SpellcardDummy.instance();

	@ObjectHolder(LibSpellcardName.CurseDreamsReality)
	public static final Spellcard CurseDreamsReality = SpellcardDummy.instance();
}
