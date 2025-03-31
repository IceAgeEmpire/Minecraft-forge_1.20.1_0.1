package net.iceageempire.iceageempire.util;

import net.iceageempire.iceageempire.MyFirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> RUBY_TIER = tag("ruby_tier");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MyFirstMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> RUBY_GEMS = tag("items/ruby_gems"); // ✅ Added "items/"

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MyFirstMod.MODID, name));
        }
    }
}