package net.iceageempire.iceageempire.item;

import net.iceageempire.iceageempire.MyFirstMod;
import net.iceageempire.iceageempire.item.custom.DiamondPotatoItem;
import net.iceageempire.iceageempire.item.custom.MetalDetectorItem;
import net.iceageempire.iceageempire.item.custom.RubySwordItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final FoodProperties CUSTOM_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(6)         // Amount of hunger it restores (out of 20)
            .saturationMod(0.8f)    // Saturation modifier
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 100), 1.0f)
            .build();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyFirstMod.MODID);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new RubySwordItem(Tiers.DIAMOND, 1, -2.4f, new Item.Properties().durability(635)));
    public static final RegistryObject<Item> DIAMOND_POTATO = ITEMS.register("diamond_potato",
            () -> new DiamondPotatoItem(new Item.Properties().food(CUSTOM_FOOD_PROPERTIES)));


    public static void register (IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
