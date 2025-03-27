package net.iceageempire.iceageempire.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class RubySwordItem extends SwordItem {
    public RubySwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(pAttacker.getHealth() < pAttacker.getMaxHealth())
            pAttacker.setHealth(Math.min(pAttacker.getHealth() + 2f, pAttacker.getMaxHealth()));
        else pAttacker.setAbsorptionAmount(pAttacker.getAbsorptionAmount()+2);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
