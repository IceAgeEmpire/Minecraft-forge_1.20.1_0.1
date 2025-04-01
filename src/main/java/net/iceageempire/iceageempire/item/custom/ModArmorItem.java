package net.iceageempire.iceageempire.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class ModArmorItem extends ArmorItem {
    public int blindnessTimer = 200;

    public int getBlindessTimer() {
        return blindnessTimer;
    }

    public void setBlindnessTimer(int blindnessTimer){
        this.blindnessTimer = blindnessTimer;
    }

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    private static int getRepairAmount(LivingEntity entity, int baseAmount) {
        Random rand = new Random();
        if (entity instanceof Monster) return baseAmount + (rand.nextInt(2) + 1) * 2;
        if (entity instanceof WitherBoss || entity instanceof EnderDragon) return baseAmount * 200;
        if (entity instanceof Player) return baseAmount + 8;
        return baseAmount + rand.nextInt(3); // Default repair amount
    }

    public static void repairArmorOnKill(Player player, LivingEntity killedEntity, int baseRepairAmount) {
        EquipmentSlot mostDamagedSlot = null;
        int highestDamage = 0;

        // Find the most damaged armor piece
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack armorPiece = player.getItemBySlot(slot);

                if (armorPiece.getItem() instanceof ModArmorItem) {
                    int damage = armorPiece.getDamageValue();
                    if (damage > highestDamage) {
                        highestDamage = damage;
                        mostDamagedSlot = slot;
                    }
                }
            }
        }

        // Repair only the most damaged armor piece
        if (mostDamagedSlot != null) {
            ItemStack armorToRepair = player.getItemBySlot(mostDamagedSlot);
            armorToRepair.setDamageValue(Math.max(armorToRepair.getDamageValue() - getRepairAmount(killedEntity,baseRepairAmount), 0));
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.iceageempire.RubyArmor.tooltip").withStyle(ChatFormatting.YELLOW));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (!level.isClientSide && player != null && hasFullArmorSet(player)) {
            blindnessTimer--;
            MobEffectInstance effect = player.getEffect(MobEffects.REGENERATION);
            //MobEffectInstance effect2 = player.getEffect(MobEffects.HUNGER);
            if(effect != null){
                if(blindnessTimer <= 0){
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false, true));
                    Random rand = new Random();
                    int nextBlindess = rand.nextInt(4800) + 1200;
                    blindnessTimer+=nextBlindess;
                }
                if(effect.getDuration()<20){
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false, true));
                }
//                if(effect2.getDuration()<20){
//                    player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0, false, false, true));
//                }
            }
            else {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0, false, false, true));
            }
        }
    }

    private boolean hasFullArmorSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ModArmorItem &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ModArmorItem &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ModArmorItem &&
                player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ModArmorItem;
    }

/* Unused. Maybe in the future.

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (!level.isClientSide && player != null) {
            if (isWearingHelmet(player, ModItems.RUBY_HELMET.get()))
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10, 0, false, false, true));
            if (isWearingChestplate(player, ModItems.RUBY_CHESTPLATE.get()))
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 10, 0, false, false, true));
            if (isWearingLeggings(player, ModItems.RUBY_LEGGINGS.get()))
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 0, false, false, true));
            if (isWearingBoots(player, ModItems.RUBY_BOOTS.get()))
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0, false, false, true));
        }
    }

    private boolean isWearingHelmet(Player player, Item helmet) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == helmet;
    }

    private boolean isWearingChestplate(Player player, Item chestplate) {
        return player.getItemBySlot(EquipmentSlot.CHEST).getItem() == chestplate;
    }

    private boolean isWearingLeggings(Player player, Item leggings) {
        return player.getItemBySlot(EquipmentSlot.LEGS).getItem() == leggings;
    }

    private boolean isWearingBoots(Player player, Item boots) {
        return player.getItemBySlot(EquipmentSlot.FEET).getItem() == boots;
    }
 */

}