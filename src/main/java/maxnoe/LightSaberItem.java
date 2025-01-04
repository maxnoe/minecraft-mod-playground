package maxnoe;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

class LightSaberItem extends SwordItem {

  LightSaberItem(ToolMaterial material, float damage, float attackSpeed, Item.Settings settings) {
    super(material, damage, attackSpeed, settings);
  }

  public static void playSwingSound(PlayerEntity player, World world) {
    if (world.isClient) { return; }
    ExampleMod.LOGGER.info("Playing Lightsaber sound");
    world.playSound(null, player.getBlockPos(), ModSounds.LIGHTSABER_SWING, SoundCategory.PLAYERS, 1.0F, 1.0F);
  }

  public static ActionResult onAttack(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
    if (world.isClient) { return ActionResult.PASS; }

    ExampleMod.LOGGER.info("onAttack");
    if (player.getMainHandStack().getItem() instanceof LightSaberItem) {
      playSwingSound(player, world);
    }
    return ActionResult.PASS;
  }

  public static ActionResult onBlockAttack(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
    if (world.isClient) { return ActionResult.PASS; }

    ExampleMod.LOGGER.info("onAttackBlock");
    if (player.getMainHandStack().getItem() instanceof LightSaberItem) {
      playSwingSound(player, world);
    }
    return ActionResult.PASS;
  }
}

