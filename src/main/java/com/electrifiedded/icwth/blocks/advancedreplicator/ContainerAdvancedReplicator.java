//package com.electrifiedded.icwth.advancedreplicator;
//
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.InventoryPlayer;
//import net.minecraft.inventory.Container;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.inventory.Slot;
//import net.minecraft.item.ItemStack;
//
//public class ContainerAdvancedReplicator extends Container {
//
//    private final TileEntityAdvancedReplicator tileEntity;
//
//    public ContainerAdvancedReplicator(InventoryPlayer playerInventory, TileEntityAdvancedReplicator tileEntity) {
//        this.tileEntity = tileEntity;
//
//        // Слот для вывода
//        this.addSlotToContainer(new Slot((IInventory) tileEntity.outputSlot, 0, 90, 59));
//
//        // Слот для жидкости
//        this.addSlotToContainer(new Slot((IInventory) tileEntity.fluidSlot, 0, 8, 27));
//
//        // Слот для ячеек
//        this.addSlotToContainer(new Slot((IInventory) tileEntity.cellSlot, 0, 8, 72));
//
//        // Слоты для улучшений
//        for (int i = 0; i < 4; ++i) {
//            this.addSlotToContainer(new Slot((IInventory) tileEntity.upgradeSlot, i, 152, 8 + i * 18));
//        }
//
//        // Слоты инвентаря игрока
//        for (int row = 0; row < 3; ++row) {
//            for (int col = 0; col < 9; ++col) {
//                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
//            }
//        }
//
//        // Слоты горячих клавиш игрока
//        for (int col = 0; col < 9; ++col) {
//            this.addSlotToContainer(new Slot(playerInventory, col, 8 + col * 18, 142));
//        }
//    }
//
//
//    @Override
//    public boolean canInteractWith(EntityPlayer player) {
//        return tileEntity.isUsableByPlayer(player);
//    }
//
//    @Override
//    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
//        ItemStack stack = ItemStack.EMPTY;
//        Slot slot = this.inventorySlots.get(index);
//
//        if (slot != null && slot.getHasStack()) {
//            ItemStack stackInSlot = slot.getStack();
//            stack = stackInSlot.copy();
//
//            if (index < tileEntity.getSizeInventory()) {
//                if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), this.inventorySlots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (stackInSlot.isEmpty()) {
//                slot.putStack(ItemStack.EMPTY);
//            } else {
//                slot.onSlotChanged();
//            }
//        }
//
//        return stack;
//    }
//}