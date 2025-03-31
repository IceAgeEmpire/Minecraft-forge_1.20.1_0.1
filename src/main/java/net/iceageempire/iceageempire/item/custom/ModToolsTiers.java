package net.iceageempire.iceageempire.item.custom;

import net.iceageempire.iceageempire.MyFirstMod;
import net.iceageempire.iceageempire.item.ModItems;
import net.iceageempire.iceageempire.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolsTiers {
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(3,635, 7f, 2f,22,
                    ModTags.Blocks.RUBY_TIER, () -> Ingredient.of(ModItems.RUBY.get())),
                    new ResourceLocation(MyFirstMod.MODID, "ruby"), List.of(Tiers.IRON), List.of(Tiers.NETHERITE));
}
