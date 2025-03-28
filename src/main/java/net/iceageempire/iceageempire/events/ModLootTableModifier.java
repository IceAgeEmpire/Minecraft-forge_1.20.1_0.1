package net.iceageempire.iceageempire.events;

import net.iceageempire.iceageempire.item.ModItems;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModLootTableModifier {
    private static final ResourceLocation NETHER_FORTRESS_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/nether_bridge");
    private static final ResourceLocation BASTION_REMNANT_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_treasure");
    private static final ResourceLocation BURIED_TREASURE_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/buried_treasure");
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getName().equals(NETHER_FORTRESS_CHEST)) {
            LootPool customLootPool = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(1, 3))
                    .add(LootItem.lootTableItem(ModItems.RUBY.get()).setWeight(15))
                    .build();

            event.getTable().addPool(customLootPool);
        }
        if (event.getName().equals(BASTION_REMNANT_CHEST)) {
            LootPool customLootPool = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(2, 4))
                    .add(LootItem.lootTableItem(ModItems.RUBY.get()).setWeight(10))
                    .build();

            event.getTable().addPool(customLootPool);
        }
        if (event.getName().equals(BURIED_TREASURE_CHEST)) {
            LootPool customLootPool = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(2, 5))
                    .add(LootItem.lootTableItem(ModItems.RUBY.get()).setWeight(5))
                    .build();

            event.getTable().addPool(customLootPool);
        }
    }
}