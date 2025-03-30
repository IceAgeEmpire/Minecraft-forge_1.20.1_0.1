package net.iceageempire.iceageempire.item.custom;

import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RubyStaffItem extends BowItem {
    public RubyStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player && !world.isClientSide) {
            // Calculate charge time
            int chargeTime = this.getUseDuration(stack) - timeLeft;
            float power = Math.min(chargeTime / 20.0f, 1.0f); // Max charge at 20 ticks (1 second)

            // Get the precise aim direction of the player
            Vec3 lookVector = player.getViewVector(1.0F);

            double speed = 1.0 + power * 5.0; // Base speed 1.0, max speed ~4.0

            // Create fireball with scaled velocity
            SmallFireball fireball = new SmallFireball(world, player,
                    lookVector.x * speed, lookVector.y * speed, lookVector.z * speed);
            world.addFreshEntity(fireball);


            // Set fireball position slightly in front of the player
            Position spawnPos = player.position().add(lookVector.scale(2.0)); // Spawns 2 blocks in front
            fireball.setPos(spawnPos.x(), spawnPos.y() + 1.5, spawnPos.z()); // Adjust height slightly

            // Spawn fireball in the world
            world.addFreshEntity(fireball);

            // Play fireball shooting sound
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Add flame particles
            for (int i = 0; i < 5; i++) {
                world.addParticle(ParticleTypes.FLAME,
                        player.getX() + lookVector.x * i,
                        player.getY() + 1.5 + lookVector.y * i,
                        player.getZ() + lookVector.z * i,
                        0, 0, 0);
            }

            // Damage the item slightly on use
            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW; // Keep bow animation
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // Allows charging like a bow
    }
}
