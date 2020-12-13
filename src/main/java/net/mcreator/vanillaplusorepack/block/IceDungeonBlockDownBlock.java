
package net.mcreator.vanillaplusorepack.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.vanillaplusorepack.VanillaPlusOrePackModElements;

import java.util.List;
import java.util.Collections;

@VanillaPlusOrePackModElements.ModElement.Tag
public class IceDungeonBlockDownBlock extends VanillaPlusOrePackModElements.ModElement {
	@ObjectHolder("vanilla_plus_ore_pack:ice_dungeon_block_down")
	public static final Block block = null;
	public IceDungeonBlockDownBlock(VanillaPlusOrePackModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.BARRIER).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(5)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("ice_dungeon_block_down");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR, (int) (1)));
		}
	}
}
