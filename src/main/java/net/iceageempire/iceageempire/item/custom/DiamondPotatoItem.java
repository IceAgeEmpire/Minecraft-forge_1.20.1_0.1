package net.iceageempire.iceageempire.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DiamondPotatoItem extends Item {
    public DiamondPotatoItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            // You can add custom effects when the food is consumed
            if (entity instanceof Player player) {

            }
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
