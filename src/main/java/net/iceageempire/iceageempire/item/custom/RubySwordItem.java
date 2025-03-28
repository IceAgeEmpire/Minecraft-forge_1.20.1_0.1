package net.iceageempire.iceageempire.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RubySwordItem extends SwordItem {
    public RubySwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(pAttacker.getHealth() < pAttacker.getMaxHealth()) pAttacker.setHealth(Math.min(pAttacker.getHealth() + 1f, pAttacker.getMaxHealth()));

        if(pTarget.getHealth() <= 0) pAttacker.setAbsorptionAmount(Math.min(pAttacker.getAbsorptionAmount()+2, 20));

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
