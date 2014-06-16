/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         InventoryWindow.java
 * Author:            Matt Schwartz
 * Date Created:      05.31.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.items.Equippable.SLOT_ID;
import com.barelyconscious.util.GUIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryWindow extends InGameComponent {

    private Label goldAmountLabel;
    private List<ItemSlotActor> inventorySlots;
    private Map<Integer, ItemSlotActor> equipmentSlots;

    public InventoryWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "inventoryBackground");
    }

    @Override
    protected void createActors() {
        super.createActors();

        inventorySlots = new ArrayList<>();
        equipmentSlots = new HashMap<>();
        goldAmountLabel = new Label("0 g", GUIHelper.createLabelStyle(14, new Color(234f / 255f, (185f / 255f), (51f / 255f), 1)));

        goldAmountLabel.setAlignment(Align.right);

        for (int i = 0; i < Offset.InventoryWindow.SLOTS_ROWS * Offset.InventoryWindow.SLOTS_COLS; i++) {
            inventorySlots.add(new ItemSlotActor());
        }

        for (int i = 0; i < SLOT_ID.NUM_SLOTS; i++) {
            equipmentSlots.put(i, new ItemSlotActor());
        }
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(goldAmountLabel);

        for (ItemSlotActor itemSlot : inventorySlots) {
            window.addActor(itemSlot);
        }

        for (ItemSlotActor itemSlot : equipmentSlots.values()) {
            window.addActor(itemSlot);
        }
    }

    @Override
    public void show() {
        super.show();

        window.setSize(Offset.InventoryWindow.WINDOW_WIDTH, Offset.InventoryWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1, -Offset.InventoryWindow.WINDOW_WIDTH, -Offset.InventoryWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.InventoryWindow.CLOSEBUTTON_OFFS_X, Offset.InventoryWindow.CLOSEBUTTON_OFFS_Y);

        GUIHelper.setSize(goldAmountLabel, 0, 0, Offset.InventoryWindow.GOLD_AMOUNT_WIDTH, Offset.InventoryWindow.GOLD_AMOUNT_HEIGHT);
        GUIHelper.setPosition(goldAmountLabel, 0, 0, Offset.InventoryWindow.GOLD_AMOUNT_OFFS_X, Offset.InventoryWindow.GOLD_AMOUNT_OFFS_Y);

        for (int r = 0; r < Offset.InventoryWindow.SLOTS_ROWS; r++) {
            for (int c = 0; c < Offset.InventoryWindow.SLOTS_COLS; c++) {
                inventorySlots.get(r + c * Offset.InventoryWindow.SLOTS_ROWS).setPosition(Offset.InventoryWindow.SLOTS_OFFS_X + c * Offset.InventoryWindow.SLOTS_STEP_X, Offset.InventoryWindow.SLOTS_OFFS_Y - r * Offset.InventoryWindow.SLOTS_STEP_Y);
            }
        }

        equipmentSlots.get(SLOT_ID.helmet.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_HELMET_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_HELMET_OFFS_Y);
        equipmentSlots.get(SLOT_ID.chest.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_CHEST_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_CHEST_OFFS_Y);
        equipmentSlots.get(SLOT_ID.legs.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_LEGS_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_LEGS_OFFS_Y);
        equipmentSlots.get(SLOT_ID.boots.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_BOOTS_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_BOOTS_OFFS_Y);

        equipmentSlots.get(SLOT_ID.gloves.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_GLOVES_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_GLOVES_OFFS_Y);
        equipmentSlots.get(SLOT_ID.belt.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_BELT_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_BELT_OFFS_Y);
        equipmentSlots.get(SLOT_ID.necklace.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_NECKLACE_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_NECKLACE_OFFS_Y);
        equipmentSlots.get(SLOT_ID.ring.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_RING_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_RING_OFFS_Y);

        equipmentSlots.get(SLOT_ID.weapon.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_WEAPON_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_WEAPON_OFFS_Y);
        equipmentSlots.get(SLOT_ID.offHand.ordinal()).setPosition(Offset.InventoryWindow.EQUIPMENT_SLOT_OFFHAND_OFFS_X, Offset.InventoryWindow.EQUIPMENT_SLOT_OFFHAND_OFFS_Y);
    }

    @Override
    public void dispose() {
        goldAmountLabel.remove();
        for (ItemSlotActor itemSlotActor : inventorySlots) {
            itemSlotActor.remove();
        }
        for (ItemSlotActor itemSlotActor : equipmentSlots.values()) {
            itemSlotActor.remove();
        }
        inventorySlots.clear();
        equipmentSlots.clear();
        super.dispose();
    }
    
} // InventoryWindow
