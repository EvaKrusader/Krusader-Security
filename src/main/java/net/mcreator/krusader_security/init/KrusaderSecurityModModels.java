
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.krusader_security.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.krusader_security.client.model.Modelzombie;
import net.mcreator.krusader_security.client.model.Modelsculkarmor;
import net.mcreator.krusader_security.client.model.Modellilithmask;
import net.mcreator.krusader_security.client.model.Modelendo2torso;
import net.mcreator.krusader_security.client.model.Modelcustom_model;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KrusaderSecurityModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelzombie.LAYER_LOCATION, Modelzombie::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelendo2torso.LAYER_LOCATION, Modelendo2torso::createBodyLayer);
		event.registerLayerDefinition(Modelsculkarmor.LAYER_LOCATION, Modelsculkarmor::createBodyLayer);
		event.registerLayerDefinition(Modellilithmask.LAYER_LOCATION, Modellilithmask::createBodyLayer);
	}
}
