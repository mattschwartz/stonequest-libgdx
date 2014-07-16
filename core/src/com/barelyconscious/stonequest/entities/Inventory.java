/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Inventory.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.entities;

import com.badlogic.gdx.Gdx;
import com.barelyconscious.stonequest.items.Equippable;
import com.barelyconscious.stonequest.items.Equippable.EquipmentSlot;
import com.barelyconscious.stonequest.items.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static final int INVENTORY_SLOTS = 36;

    private int gold;
    private List<ItemSlot> inventory;
    private List<ItemSlot> equipment;
    private Entity owner;

    public Inventory(Entity owner) {
        this.owner = owner;
        inventory = new ArrayList<>(INVENTORY_SLOTS);
        equipment = new ArrayList<>();

        for (int i = 0; i < INVENTORY_SLOTS; i++) {
            inventory.add(new ItemSlot());
        }

        for (final EquipmentSlot slotId : EquipmentSlot.values()) {
            equipment.add(new ItemSlot() {

                @Override
                public boolean itemGoesHere(Item item) {
                    if (!(item instanceof Equippable)) {
                        return false;
                    }

                    return ((Equippable) item).getSlotId() == slotId;
                }

            });
        }
    }

    public int getGold() {
        return gold;
    }

    public void adjustGold(int amount) {
        this.gold += amount;
    }

    public ItemSlot[] getItemSlots() {
        return inventory.toArray(new ItemSlot[]{});
    }

    /**
     * Finds and returns the Item at the supplied index, if one exists.
     *
     * @param index The index within the Entity's inventory to retrieve the
     * Item.
     * @return Returns the Item at the supplied index if one exists or returns
     * null.
     */
    public Item getItem(int index) {
        if (index < 0 || index >= INVENTORY_SLOTS) {
            return null;
        }

        return inventory.get(index).item;
    }

    /**
     * Searches for an Item matching the parameter within the Entity's
     * inventory.
     *
     * @param item The Item to be searched for.
     * @return Returns the index within the inventory of the Item if found, or
     * -1 if no such Item exists.
     */
    public int contains(Item item) {

        return -1;
    }

    /**
     * Attempts to add the Item to the Entity's inventory, stacking with other
     * similar items, if possible.
     *
     * @param item The Item to be added to the Entity's inventory
     * @return Returns true if the Item was successfully added and false if the
     * Item could not be added.
     */
    public boolean addItem(Item item) {
        for (ItemSlot itemSlot : inventory) {
            if (itemSlot.empty()) {
                itemSlot.item = item;
                Gdx.app.log(null, "Item added " + item);
                return true;
            }
        }

        Gdx.app.log(null, "Item was not added");

        return false;
    }

    /**
     * Adds the supplied Item to the entity's inventory at the supplied index
     * and returns the Item replaced at that slot, if any.
     *
     * @param index The index within the inventory to add the Item.
     * @param item The Item to be added to the entity's inventory.
     * @return Returns the Item at the supplied index (if any) or null if the
     * Item added does not replace another or if the index is invalid.
     */
    public Item addItem(int index, Item item) {
        if (index < 0 || index >= INVENTORY_SLOTS) {
            return null;
        }

        return inventory.get(index).swap(item);
    }

    /**
     * Removes the Item (if any) or decreases its stack count by one at index
     * and returns the Item in that slot.
     *
     * @param index The integer value of the slot of the Item to be removed.
     * @return Returns the Item in the slot at index. If no Item exists at that
     * slot, or if the index points outside the bounds of the entity's
     * inventory, null is returned.
     */
    public Item removeItem(int index) {
        if (index < 0 || index >= INVENTORY_SLOTS) {
            return null;
        }

        return inventory.get(index).swap(null);
    }

    /**
     * Removes the Item (if any) or decreases its stack count by one of the Item
     * that matches the parameter.
     *
     * @param item The Item to be matched and removed from the Entity's
     * inventory.
     * @return Returns the Item removed if it was found or null if the Item was
     * not found in the inventory.
     */
    public Item removeItem(Item item) {
        return null;
    }
} // Inventory
