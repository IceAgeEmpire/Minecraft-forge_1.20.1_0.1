package net.iceageempire.iceageempire.item;

import net.iceageempire.iceageempire.MyFirstMod;
import net.iceageempire.iceageempire.item.custom.MetalDetectorItem;
import net.iceageempire.iceageempire.item.custom.ModFoods;
import net.iceageempire.iceageempire.item.custom.RubyStaffItem;
import net.iceageempire.iceageempire.item.custom.RubySwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyFirstMod.MODID);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new RubySwordItem(Tiers.DIAMOND, 1, -2.4f, new Item.Properties().durability(635)));
    public static final RegistryObject<Item> DIAMOND_POTATO = ITEMS.register("diamond_potato",
            () -> new Item(new Item.Properties().food(ModFoods.DIAMOND_POTATO)));
//    public static final RegistryObject<Item> TREANT_BLOCK_FUEL = ITEMS.register("treant_block",
//            () -> new FuelBlockItem(TREANT_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> RUBY_STAFF = ITEMS.register("ruby_staff",
        () -> new RubyStaffItem(new Item.Properties().stacksTo(1)));

    public static void register (IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
