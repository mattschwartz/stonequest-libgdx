/* *****************************************************************************
 * Project:           core
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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.items.Equippable.SLOT_ID;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryWindow extends InGameComponent {

    private Window window;
    private ImageButton closeWindowButton;
    private Label goldAmountLabel;
    private List<ItemSlotActor> inventorySlots;
    private Map<Integer, ItemSlotActor> equipmentSlots;

    public InventoryWindow(InGameMenu menu) {
        super(menu);
    }

    public void create() {
        createActors();
        createRootWindow();
        registerEvents();

        hide();
    }

    private void createActors() {
        inventorySlots = new ArrayList<>();
        equipmentSlots = new HashMap<>();
        closeWindowButton = new ImageButton(GUIHelper.createImageButtonStyle("closeWindowButton"));
        goldAmountLabel = new Label("0 g", GUIHelper.createLabelStyle(14, new Color(234f / 255f, (185f / 255f), (51f / 255f), 1)));

        goldAmountLabel.setAlignment(Align.right);

        for (int i = 0; i < Offset.INVENTORY_SLOTS_ROWS * Offset.INVENTORY_SLOTS_COLS; i++) {
            inventorySlots.add(new ItemSlotActor());
        }

        for (int i = 0; i < SLOT_ID.NUM_SLOTS; i++) {
            equipmentSlots.put(i, new ItemSlotActor());
        }
    }

    private void createRootWindow() {
        WindowStyle style = new WindowStyle();
        style.background = GUIHelper.getDrawable("inventoryBackground");
        style.titleFont = FontFactory.createDefaultFont(18);

        window = new Window("", style);

        window.addActor(closeWindowButton);
        window.addActor(goldAmountLabel);

        for (ItemSlotActor itemSlot : inventorySlots) {
            window.addActor(itemSlot);
        }

        for (ItemSlotActor itemSlot : equipmentSlots.values()) {
            window.addActor(itemSlot);
        }
    }

    private void registerEvents() {
        closeWindowButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                hide();
            }
        });
    }

    public Window getWindow() {
        return window;
    }

    public void hide() {
        window.setVisible(false);
        window.setTouchable(Touchable.disabled);
    }

    public void show() {
        window.setSize(Offset.INVENTORY_WINDOW_WIDTH, Offset.INVENTORY_WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1, -Offset.INVENTORY_WINDOW_WIDTH, -Offset.INVENTORY_WINDOW_HEIGHT);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.INVENTORY_CLOSEBUTTON_OFFS_X, Offset.INVENTORY_CLOSEBUTTON_OFFS_Y);

        GUIHelper.setSize(goldAmountLabel, 0, 0, Offset.INVENTORY_GOLD_AMOUNT_WIDTH, Offset.INVENTORY_GOLD_AMOUNT_HEIGHT);
        GUIHelper.setPosition(goldAmountLabel, 0, 0, Offset.INVENTORY_GOLD_AMOUNT_OFFS_X, Offset.INVENTORY_GOLD_AMOUNT_OFFS_Y);

        for (int r = 0; r < Offset.INVENTORY_SLOTS_ROWS; r++) {
            for (int c = 0; c < Offset.INVENTORY_SLOTS_COLS; c++) {
                inventorySlots.get(r + c * Offset.INVENTORY_SLOTS_ROWS).setPosition(Offset.INVENTORY_SLOTS_OFFS_X + c * Offset.INVENTORY_SLOTS_STEP_X, Offset.INVENTORY_SLOTS_OFFS_Y - r * Offset.INVENTORY_SLOTS_STEP_Y);
            }
        }

        equipmentSlots.get(SLOT_ID.helmet.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_HELMET_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_HELMET_OFFS_Y);
        equipmentSlots.get(SLOT_ID.chest.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_CHEST_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_CHEST_OFFS_Y);
        equipmentSlots.get(SLOT_ID.legs.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_LEGS_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_LEGS_OFFS_Y);
        equipmentSlots.get(SLOT_ID.boots.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_BOOTS_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_BOOTS_OFFS_Y);

        equipmentSlots.get(SLOT_ID.gloves.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_GLOVES_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_GLOVES_OFFS_Y);
        equipmentSlots.get(SLOT_ID.belt.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_BELT_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_BELT_OFFS_Y);
        equipmentSlots.get(SLOT_ID.necklace.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_NECKLACE_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_NECKLACE_OFFS_Y);
        equipmentSlots.get(SLOT_ID.ring.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_RING_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_RING_OFFS_Y);

        equipmentSlots.get(SLOT_ID.weapon.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_WEAPON_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_WEAPON_OFFS_Y);
        equipmentSlots.get(SLOT_ID.offHand.ordinal()).setPosition(Offset.INVENTORY_EQUIPMENT_SLOT_OFFHAND_OFFS_X, Offset.INVENTORY_EQUIPMENT_SLOT_OFFHAND_OFFS_Y);

        window.setVisible(true);
        window.setTouchable(Touchable.enabled);
    }

    public void remove() {
        window.clear();
        window.remove();
    }

    public void toggle() {
        boolean visible = !window.isVisible();

        if (visible) {
            show();
        } else {
            hide();
        }
    }

} // InventoryWindow
