package net.katsstuff.journeytogensokyo.subentity;

import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.katsstuff.journeytogensokyo.lib.LibSubEntityName;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityTypeDummy;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(LibModJ.ID)
public class JTGSubEntities {

	@ObjectHolder(LibSubEntityName.DelayedHoming)
	public static final SubEntityType DelayedHoming = SubEntityTypeDummy.instance();

	@ObjectHolder(LibSubEntityName.DelayedRotate)
	public static final SubEntityType DelayedRotate = SubEntityTypeDummy.instance();
}
