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
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class mBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

   private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

   public mBlockEntity() {
      super(OreGrowthChamber.ORE_GROWTH_CHAMBER_ENTITY);
   }

   @Override
   public DefaultedList<ItemStack> getItems() {
      return items;
   }

   // These Methods are from the NamedScreenHandlerFactory Interface
   // createMenu creates the ScreenHandler itself
   // getDisplayName will Provide its name which is normally shown at the top

   @Override
   public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
      // We provide *this* to the screenHandler as our class Implements Inventory
      // Only the Server has the Inventory at the start, this will be synced to the
      // client in the ScreenHandler
      return new BoxScreenHandler(syncId, playerInventory, this);
   }

   @Override
   public Text getDisplayName() {
      return new TranslatableText(getCachedState().getBlock().getTranslationKey());
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
