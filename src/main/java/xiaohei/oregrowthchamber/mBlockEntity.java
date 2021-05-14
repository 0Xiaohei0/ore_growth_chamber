package xiaohei.oregrowthchamber;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import xiaohei.oregrowthchamber.GUI.ExampleGuiDescription;

public class mBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {

   private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

   public mBlockEntity() {
      super(OreGrowthChamber.ORE_GROWTH_CHAMBER_ENTITY);
   }

   @Override
   public DefaultedList<ItemStack> getItems() {
      return items;
   }

   @Override
   public Text getDisplayName() {
      // Using the block name as the screen title
      return new TranslatableText(getCachedState().getBlock().getTranslationKey());
   }

   @Override
   public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
      return new ExampleGuiDescription(syncId, inventory, ScreenHandlerContext.create(world, pos));
   }

   @Override
   public boolean canPlayerUse(PlayerEntity player) {
      System.out.println("can use 2");
      return true;
      // return pos.isWithinDistance(player.getBlockPos(), 4.5);
   }

   @Override
   public void fromTag(BlockState state, CompoundTag tag) {
      super.fromTag(state, tag);
      Inventories.fromTag(tag, items);
   }

   @Override
   public CompoundTag toTag(CompoundTag tag) {
      Inventories.toTag(tag, items);
      return super.toTag(tag);
   }

}
