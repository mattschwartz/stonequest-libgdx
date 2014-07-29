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

import com.barelyconscious.stonequest.gui.Tooltip;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.entities.Attribute;
import com.barelyconscious.stonequest.entities.Inventory;
import com.barelyconscious.stonequest.entities.ItemSlot;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.gui.ItemSlotActor;
import com.barelyconscious.stonequest.gui.ItemTooltip;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.ColorHelper;
import com.barelyconscious.util.GUIHelper;
import java.util.ArrayList;
import java.util.List;

public class InventoryWindow extends InGameComponent {

    private Label goldAmountLabel;
    private Label hitpointsLabel;
    private Label strengthLabel;
    private Label accuracyLabel;
    private Label defenseLabel;
    private Label evasionLabel;
    private Label fireLabel;
    private Label iceLabel;
    private Label holyLabel;
    private Label chaosLabel;
    private Label faithLabel;
    private ItemTooltip tooltip;
    private List<ItemSlotActor> itemSlots;

    public InventoryWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "GUI_inventory_window_background");
        itemSlots = new ArrayList<>();
    }

    @Override
    protected void createActors() {
        super.createActors();

        goldAmountLabel = GUIHelper.createLabel("", 13, Color.BLACK);
        hitpointsLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        strengthLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        accuracyLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        defenseLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        evasionLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        fireLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        iceLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        holyLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        chaosLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        faithLabel = GUIHelper.createLabel("", 14, ColorHelper.FOREST_GREEN);
        tooltip = new ItemTooltip();

        Inventory inventory = GameWorld.getInstance().getPlayer().getInventory();
        for (ItemSlot slot : inventory.getItemSlots()) {
            ItemSlotActor itemSlotActor = new ItemSlotActor();
            itemSlotActor.setTooltip(tooltip);
            itemSlotActor.setItemSlot(slot);
            itemSlots.add(itemSlotActor);
        }

        goldAmountLabel.setAlignment(Align.right);
        hitpointsLabel.setAlignment(Align.right);
        strengthLabel.setAlignment(Align.right);
        accuracyLabel.setAlignment(Align.right);
        defenseLabel.setAlignment(Align.right);
        evasionLabel.setAlignment(Align.right);
        fireLabel.setAlignment(Align.right);
        iceLabel.setAlignment(Align.right);
        holyLabel.setAlignment(Align.right);
        chaosLabel.setAlignment(Align.right);
        faithLabel.setAlignment(Align.right);
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(goldAmountLabel);
        window.addActor(hitpointsLabel);
        window.addActor(strengthLabel);
        window.addActor(accuracyLabel);
        window.addActor(defenseLabel);
        window.addActor(evasionLabel);
        window.addActor(fireLabel);
        window.addActor(iceLabel);
        window.addActor(holyLabel);
        window.addActor(chaosLabel);
        window.addActor(faithLabel);
        inGameMenu.getStage().addActor(tooltip);

        for (ItemSlotActor itemSlot : itemSlots) {
            itemSlot.show(inGameMenu.getStage());
            window.addActor(itemSlot);
        }

        window.setSize(Offset.InventoryWindow.WINDOW_WIDTH,
                Offset.InventoryWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1,
                -Offset.InventoryWindow.WINDOW_WIDTH,
                -Offset.InventoryWindow.WINDOW_HEIGHT);

        GUIHelper.setPosition(closeWindowButton, 0, 0,
                Offset.InventoryWindow.CLOSE_WINDOW_BUTTON_OFFS_X,
                Offset.InventoryWindow.CLOSE_WINDOW_BUTTON_OFFS_Y);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        positionLabels();
    }

    @Override
    public void show() {
        super.show();

        setLabelText();
        showItemSlots();
    }

    private void setLabelText() {
        Player player = GameWorld.getInstance().getPlayer();

        goldAmountLabel.setText("" + player.getInventory().getGold());
        hitpointsLabel.setText("" + Math.round(player.getAttribute(Attribute.HITPOINTS)));
        strengthLabel.setText("" + Math.round(player.getAttribute(Attribute.STRENGTH)));
        accuracyLabel.setText("" + Math.round(player.getAttribute(Attribute.ACCURACY)));
        defenseLabel.setText("" + Math.round(player.getAttribute(Attribute.DEFENSE)));
        evasionLabel.setText("" + Math.round(player.getAttribute(Attribute.EVASION)));
        fireLabel.setText("" + Math.round(player.getAttribute(Attribute.FIRE_MAGIC)));
        iceLabel.setText("" + Math.round(player.getAttribute(Attribute.ICE_MAGIC)));
        holyLabel.setText("" + Math.round(player.getAttribute(Attribute.HOLY_MAGIC)));
        chaosLabel.setText("" + Math.round(player.getAttribute(Attribute.CHAOS_MAGIC)));
        faithLabel.setText("" + Math.round(player.getAttribute(Attribute.FAITH)));
    }

    private void positionLabels() {
        GUIHelper.setSize(goldAmountLabel, 0, 0,
                Offset.InventoryWindow.GOLD_AMOUNT_WIDTH,
                Offset.InventoryWindow.GOLD_AMOUNT_HEIGHT);
        hitpointsLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        strengthLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        accuracyLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        defenseLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        evasionLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        fireLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        iceLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        holyLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        chaosLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);
        faithLabel.setWidth(Offset.InventoryWindow.STAT_LABEL_WIDTH);

        GUIHelper.setPosition(goldAmountLabel, 0, 0,
                Offset.InventoryWindow.GOLD_AMOUNT_OFFS_X,
                Offset.InventoryWindow.GOLD_AMOUNT_OFFS_Y);
        GUIHelper.setPosition(hitpointsLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_LEFT_COL_OFFS_X,
                Offset.InventoryWindow.HITPOINTS_OFFS_Y);
        GUIHelper.setPosition(strengthLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_LEFT_COL_OFFS_X,
                Offset.InventoryWindow.STRENGTH_OFFS_Y);
        GUIHelper.setPosition(accuracyLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_LEFT_COL_OFFS_X,
                Offset.InventoryWindow.ACCURACY_OFFS_Y);
        GUIHelper.setPosition(defenseLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_LEFT_COL_OFFS_X,
                Offset.InventoryWindow.DEFENSE_OFFS_Y);
        GUIHelper.setPosition(evasionLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_LEFT_COL_OFFS_X,
                Offset.InventoryWindow.EVASION_OFFS_Y);

        GUIHelper.setPosition(fireLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_RIGHT_COL_OFFS_X,
                Offset.InventoryWindow.FIRE_OFFS_Y);
        GUIHelper.setPosition(iceLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_RIGHT_COL_OFFS_X,
                Offset.InventoryWindow.ICE_OFFS_Y);
        GUIHelper.setPosition(holyLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_RIGHT_COL_OFFS_X,
                Offset.InventoryWindow.HOLY_OFFS_Y);
        GUIHelper.setPosition(chaosLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_RIGHT_COL_OFFS_X,
                Offset.InventoryWindow.CHAOS_OFFS_Y);
        GUIHelper.setPosition(faithLabel, 0, 0,
                Offset.InventoryWindow.STAT_LABEL_RIGHT_COL_OFFS_X,
                Offset.InventoryWindow.FAITH_OFFS_Y);
    }

    private void showItemSlots() {
        int i = 0;
        float x = Offset.InventoryWindow.INVENTORY_OFFS_X;
        float y = Offset.InventoryWindow.INVENTORY_OFFS_Y;
        ItemSlotActor actor;

        for (int r = 0; r < Offset.InventoryWindow.INVENTORY_ROWS; r++) {
            for (int c = 0; c < Offset.InventoryWindow.INVENTORY_COLS; c++) {
                actor = itemSlots.get(i);

                GUIHelper.setPosition(actor, 0, 0,
                        x + c * Offset.InventoryWindow.INVENTORY_STEP_X,
                        y - r * Offset.InventoryWindow.INVENTORY_STEP_Y);
                i++;
            }
        }
    }

    @Override
    public void dispose() {
        goldAmountLabel.remove();
        hitpointsLabel.remove();
        strengthLabel.remove();
        accuracyLabel.remove();
        defenseLabel.remove();
        evasionLabel.remove();
        fireLabel.remove();
        iceLabel.remove();
        holyLabel.remove();
        chaosLabel.remove();
        faithLabel.remove();

        for (ItemSlotActor itemSlotActor : itemSlots) {
            itemSlotActor.remove();
        }

        super.dispose();
    }
}
