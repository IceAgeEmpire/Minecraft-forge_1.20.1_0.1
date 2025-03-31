package net.iceageempire.iceageempire.datagen;

import net.iceageempire.iceageempire.MyFirstMod;
import net.iceageempire.iceageempire.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MyFirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.RAW_RUBY);
        handheldItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.DIAMOND_POTATO);

        handheldItem(ModItems.RUBY_STAFF);
        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);

    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MyFirstMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MyFirstMod.MODID,"item/" + item.getId().getPath()));
    }
}
