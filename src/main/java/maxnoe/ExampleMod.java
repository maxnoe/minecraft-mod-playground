package maxnoe;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "maxnoe-playground";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("mod loaded: {}", MOD_ID);

    ModSounds.initialize();
    ModItems.initialize();
    AttackEntityCallback.EVENT.register(LightSaberItem::onAttack);
    AttackBlockCallback.EVENT.register(LightSaberItem::onBlockAttack);
	}
}
