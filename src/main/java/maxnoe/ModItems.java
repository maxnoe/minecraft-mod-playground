package maxnoe;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

class ModItems {

  public static Item register(Item.Settings itemSettings, String name) {
    Identifier id = Identifier.of(ExampleMod.MOD_ID, name);
    RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

    Item.Settings settings = itemSettings.registryKey(key);
    return Registry.register(Registries.ITEM, key, new Item(settings));
  }

  public static final Item SUSPICIOUS_SUBSTANCE = register(
    new Item.Settings(),
    "suspicious_substance"
  );

  public static void initialize() {
    ExampleMod.LOGGER.info("Initializing {}", ModItems.class.getName());

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
      .register((itemGroup) -> itemGroup.add(SUSPICIOUS_SUBSTANCE));
  }

}
