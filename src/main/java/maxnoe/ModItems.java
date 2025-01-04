package maxnoe;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

class ModItems {

  public static Item createLightSaber() {
    Identifier id = Identifier.of(ExampleMod.MOD_ID, "lightsaber");
    ExampleMod.LOGGER.info("Adding item {}", id);

    RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
    Item.Settings settings = new Item.Settings().registryKey(key);

    SwordItem sword = new LightSaberItem(LIGHTSABER_MATERIAL, 100.0f, 2.5f, settings);

    return Registry.register(Registries.ITEM, key, sword);
  }

  public static void initialize() {
    ExampleMod.LOGGER.info("Initializing {}", ModItems.class.getName());

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
      .register((itemGroup) -> itemGroup.add(LIGHTSABER));
  }

  public static final ToolMaterial LIGHTSABER_MATERIAL = ToolMaterial.NETHERITE;
  public static final Item LIGHTSABER = createLightSaber();
}
