package maxnoe;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

class LightSaberItem extends SwordItem {
  
  LightSaberItem(ToolMaterial material, float damage, float attackSpeed, Item.Settings settings) {
    super(material, damage, attackSpeed, settings);
  }

  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    ExampleMod.LOGGER.info("Using Lightsaber");
    if (!world.isClient) {
      ExampleMod.LOGGER.info("Playing Lightsaber sound");
      world.playSound(null, player.getBlockPos(), ModSounds.LIGHTSABER_SWING, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }
    return super.use(world, player, hand);
  }

  @Override
  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    ExampleMod.LOGGER.info("Lightsaber postHit");
    if (!attacker.getWorld().isClient) {
      ExampleMod.LOGGER.info("Playing Lightsaber sound");
      attacker.getWorld().playSound(null, attacker.getBlockPos(), ModSounds.LIGHTSABER_SWING, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }
    return super.postHit(stack, target, attacker);
  }
}

