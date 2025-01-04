package maxnoe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class ModSounds {
  public static final SoundEvent LIGHTSABER_IGNITION = registerSound("lightsaber_ignition");
  public static final SoundEvent LIGHTSABER_SWING = registerSound("lightsaber_swing");

  private static SoundEvent registerSound(String name) {
    ExampleMod.LOGGER.info("Registering sound {}", name);
    Identifier id = Identifier.of(ExampleMod.MOD_ID, name);
    return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
  }

  public static void initialize() {
    ExampleMod.LOGGER.info("Initializing {}", ModItems.class.getName());
  }
}
