package net.iceageempire.iceageempire.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RUBY_POTATO = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.3f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 18000, 1),1f).build();
}
