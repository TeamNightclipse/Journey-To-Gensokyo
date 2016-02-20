/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import katrix.journeyToGensokyo.CommonProxy;
import katrix.journeyToGensokyo.client.lib.LibResource;
import katrix.journeyToGensokyo.client.model.ModelHellRaven;
import katrix.journeyToGensokyo.client.model.ModelMarisa;
import katrix.journeyToGensokyo.client.model.ModelSunFlowerFairyJTG;
import katrix.journeyToGensokyo.client.model.ModelTHFairyIce;
import katrix.journeyToGensokyo.client.model.ModelTenguCrow;
import katrix.journeyToGensokyo.client.render.RenderLivingJTG;
import katrix.journeyToGensokyo.client.render.RenderMiniHakkeroJTG;
import katrix.journeyToGensokyo.client.render.RenderStandardShot;
import katrix.journeyToGensokyo.client.render.RenderTHBoss;
import katrix.journeyToGensokyo.client.render.RenderTHFairyEnd;
import katrix.journeyToGensokyo.client.render.RenderTHFairyNether;
import katrix.journeyToGensokyo.client.render.RenderYukari;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityHellRaven;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMarisa;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroJTG;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityReimuHostile;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntitySunFlowerFairyEnd;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyEnd;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyIce;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyNether;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTenguCrow;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import thKaguyaMod.client.model.living.ModelReimu;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyIce.class, new RenderLivingJTG(new ModelTHFairyIce(), LibResource.FAIRY_ICE));
		RenderingRegistry.registerEntityRenderingHandler(EntityHellRaven.class, new RenderLivingJTG(new ModelHellRaven(), LibResource.HELL_RAVEN));
		RenderingRegistry.registerEntityRenderingHandler(EntityTenguCrow.class, new RenderLivingJTG(new ModelTenguCrow(), LibResource.TENGU_CROW));
		RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyNether.class, new RenderTHFairyNether());
		RenderingRegistry.registerEntityRenderingHandler(EntityTHFairyEnd.class, new RenderTHFairyEnd());
		RenderingRegistry.registerEntityRenderingHandler(EntitySunFlowerFairyEnd.class, new RenderLivingJTG(new ModelSunFlowerFairyJTG(), LibResource.FAIRY_SUNFLOWER_END));
		RenderingRegistry.registerEntityRenderingHandler(EntityReimuHostile.class, new RenderTHBoss(new ModelReimu(), LibResource.REIMU));
		RenderingRegistry.registerEntityRenderingHandler(EntityYukari.class, new RenderYukari());
		RenderingRegistry.registerEntityRenderingHandler(EntityStandardShot.class, new RenderStandardShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityMiniHakkeroJTG.class, new RenderMiniHakkeroJTG());
		RenderingRegistry.registerEntityRenderingHandler(EntityMarisa.class, new RenderTHBoss(new ModelMarisa(), LibResource.MARISA));
	}
}