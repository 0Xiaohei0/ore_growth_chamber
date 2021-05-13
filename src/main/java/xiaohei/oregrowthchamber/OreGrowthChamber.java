package xiaohei.oregrowthchamber;

import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class OreGrowthChamber implements ModInitializer {

	public static final Block ORE_GROWTH_CHAMBER = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f)
			.sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES));
	public static BlockEntityType<mBlockEntity> ORE_GROWTH_CHAMBER_ENTITY;

	// public static final String MOD_ID = "oregrowthchamber";
	// public static final Identifier ORE_GROWTH_CHAMBER_ID = new Identifier(MOD_ID,
	// "OreGrowthChamber");

	// public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER =
	// ScreenHandlerRegistry
	// .registerSimple(new Identifier("oregrowthchamber", "OreGrowthChamber"),
	// BoxScreenHandler::new);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("oregrowthchamber", "ore_growth_chamber"), ORE_GROWTH_CHAMBER);
		Registry.register(Registry.ITEM, new Identifier("oregrowthchamber", "ore_growth_chamber"),
				new BlockItem(ORE_GROWTH_CHAMBER, new FabricItemSettings().group(ItemGroup.MISC)));

		ORE_GROWTH_CHAMBER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "oregrowthchamber:ore_growth_chamber",
				BlockEntityType.Builder.create(mBlockEntity::new, ORE_GROWTH_CHAMBER).build(null));

	}
}
