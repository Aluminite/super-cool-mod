package party.mrow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperCoolMod implements ModInitializer {
	//define blocks and items
	public static final Block COOL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("supercool");

	@Override
	public void onInitialize() {
		//register blocks and items
		Registry.register(Registry.BLOCK, new Identifier("supercool", "cool_block"), COOL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("supercool", "cool_block"), new BlockItem(COOL_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("This is a test of the ULTRA OMEGA SUPER COOL MOD!");
	}
}
