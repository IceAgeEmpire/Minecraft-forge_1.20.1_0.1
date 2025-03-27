package net.iceageempire.iceageempire.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LightningBoltItem extends SwordItem {
    public LightningBoltItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Level world = pTarget.level();

        //pAttacker.setHealth(pAttacker.getHealth()+2f);
//        pAttacker.setHealth(Math.min(pAttacker.getHealth() + 2f, pAttacker.getMaxHealth()));


        if(!world.isClientSide && world instanceof ServerLevel serverLevel){
            BlockPos blockPos = pTarget.blockPosition();
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if(lightningBolt != null){
                    lightningBolt.moveTo(blockPos.getX(),blockPos.getY(),blockPos.getZ());
                    serverLevel.addFreshEntity(lightningBolt);
                }

        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
