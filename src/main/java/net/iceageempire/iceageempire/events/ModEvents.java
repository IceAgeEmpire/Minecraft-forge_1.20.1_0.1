package net.iceageempire.iceageempire.events;

import net.iceageempire.iceageempire.item.custom.ModArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onEntityKill(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            ModArmorItem.repairArmorOnKill(player, event.getEntity(), 2); // Pass the killed entity
        }
    }

    @SubscribeEvent
    public static void onArmorEquip(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            EquipmentSlot slot = event.getSlot(); // Get the slot where the change happened
            ItemStack newItem = event.getTo();   // New item equipped
            ItemStack oldItem = event.getFrom(); // Old item removed

            // Check if a piece of custom armor was equipped
            if (newItem.getItem() instanceof ModArmorItem && !(oldItem.getItem() instanceof ModArmorItem)) {
                ((ModArmorItem) newItem.getItem()).setBlindnessTimer(500);
            }
        }
    }

}
