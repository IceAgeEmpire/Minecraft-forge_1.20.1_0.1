package net.iceageempire.iceageempire.events;

import net.iceageempire.iceageempire.item.custom.ModArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
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

}
