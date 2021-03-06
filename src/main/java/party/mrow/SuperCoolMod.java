package party.mrow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperCoolMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("supercool");

    // define blocks and items
    public static final Block COOL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .hardness(-1f).resistance(Float.MAX_VALUE));
    public static final ItemGroup COOL_GROUP = FabricItemGroupBuilder.build(
            new Identifier("supercool", "general"), () -> new ItemStack(COOL_BLOCK));
    private static final Item COOL_BLOCK_ITEM = new BlockItem(COOL_BLOCK,
            new Item.Settings().group(COOL_GROUP).rarity(Rarity.EPIC).fireproof());
    public static ToolItem COOL_SWORD = new SwordItem(CoolToolMaterial.INSTANCE, Integer.MAX_VALUE, 0F,
            new Item.Settings().group(COOL_GROUP).rarity(Rarity.EPIC).fireproof());
    private static final Identifier DUNGEON_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/simple_dungeon");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // register blocks and items
        Registry.register(Registry.BLOCK,
                new Identifier("supercool", "cool_block"), COOL_BLOCK);
        Registry.register(Registry.ITEM,
                new Identifier("supercool", "cool_block"),
                COOL_BLOCK_ITEM);
        Registry.register(Registry.ITEM,
                new Identifier("supercool", "cool_sword"), COOL_SWORD);

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (DUNGEON_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootNumberProvider.create(1, 0.25f))
                        .with(ItemEntry.builder(COOL_BLOCK_ITEM));

                table.pool(poolBuilder);
            }
        });

        LOGGER.info("Super Cool Mod loaded successfully");
    }
}
