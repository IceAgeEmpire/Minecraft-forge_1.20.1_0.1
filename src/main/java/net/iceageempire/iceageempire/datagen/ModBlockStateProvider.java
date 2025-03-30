package net.iceageempire.iceageempire.datagen;

import net.iceageempire.iceageempire.MyFirstMod;
import net.iceageempire.iceageempire.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MyFirstMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.RUBY_BLOCK, "ruby_block", "ruby_block", "ruby_block", "ruby_block");
        blockWithItem(ModBlocks.RAW_RUBY_BLOCK, "raw_ruby_block", "raw_ruby_block", "raw_ruby_block", "raw_ruby_block");
        blockWithItem(ModBlocks.RUBY_ORE, "ruby_ore", "ruby_ore", "ruby_ore", "ruby_ore");
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE, "deepslate_ruby_ore", "deepslate_ruby_ore", "deepslate_ruby_ore", "deepslate_ruby_ore");
        blockWithItem(ModBlocks.TREANT_BLOCK, "treant_block_front", "treant_block_top", "treant_block_top", "treant_block_side");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject,String textureFront, String textureTop, String textureBottom, String textureSide) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cube(blockRegistryObject.getId().getPath(),
                        modLoc("block/" + textureBottom),// Bottom texture
                        modLoc("block/" + textureTop),   // Top texture
                        modLoc("block/" + textureFront),  // Side texture
                        modLoc("block/" + textureSide),  // Side texture
                        modLoc("block/" + textureSide),  // Side texture
                        modLoc("block/" + textureSide)   // Side texture
                )
        );
    }

}
