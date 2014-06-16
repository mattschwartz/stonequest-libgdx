/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         UpgradeItemWindow.java
 * Author:            Matt Schwartz
 * Date Created:      06.05.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.stonequest.items.Salvage;
import com.barelyconscious.util.ColorHelper;
import com.barelyconscious.util.GUIHelper;
import com.barelyconscious.util.StringHelper;

public class UpgradeItemWindow extends InGameComponent {

    private ItemSlotActor itemToUpgradeSlot;
    private ItemSlotActor salvageSlot;
    private ItemSlotActor augmentationSlot;
    private ItemSlotActor divineFavorSlot;
    private ProgressBar progressBar;
    private JustifiedTextArea itemToUpgradeTextArea;
    private JustifiedTextArea ritualDetailsTextArea;
    private Label itemNameLabel;
    private Button applySalvageButton;
    private Button applyAugmentationButton;
    private Button removeAugmentationButton;
    private Button performRitualButton;

    public UpgradeItemWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "upgradeItemBackground");
    }

    @Override
    protected void createActors() {
        super.createActors();

        itemToUpgradeSlot = new ItemSlotActor();
        salvageSlot = new ItemSlotActor();
        augmentationSlot = new ItemSlotActor();
        divineFavorSlot = new ItemSlotActor();

        itemNameLabel = GUIHelper.createLabel("Item to Upgrade", 16, Color.BLACK);
        applySalvageButton = GUIHelper.createButton("Apply");
        applyAugmentationButton = GUIHelper.createButton("Apply");
        removeAugmentationButton = GUIHelper.createButton("Remove");
        performRitualButton = GUIHelper.createButton("Perform Ritual");
        progressBar = new ProgressBar();
        ritualDetailsTextArea = new JustifiedTextArea(14, Color.LIGHT_GRAY, ColorHelper.SUMMER_GREEN);

        itemToUpgradeTextArea = new JustifiedTextArea(14, Color.LIGHT_GRAY, ColorHelper.SUMMER_GREEN);
        itemToUpgradeTextArea.setCenterLines(true);
        ritualDetailsTextArea.setTouchable(Touchable.disabled);
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(itemNameLabel);
        window.addActor(itemToUpgradeSlot);
        window.addActor(salvageSlot);
        window.addActor(augmentationSlot);
        window.addActor(divineFavorSlot);
        window.addActor(applySalvageButton);
        window.addActor(applyAugmentationButton);
        window.addActor(applyAugmentationButton);
        window.addActor(removeAugmentationButton);
        window.addActor(performRitualButton);
        window.addActor(itemToUpgradeTextArea);
        window.addActor(ritualDetailsTextArea);
        window.addActor(progressBar);

        progressBar.setProgress(0.25f);
        progressBar.setPreviewAmount(7);
        progressBar.setPreviewProgress(0.65f);
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();
        itemToUpgradeSlot.setItemChangeRunnable(new Runnable() {

            @Override
            public void run() {
                String materials;
                Item item = itemToUpgradeSlot.getItem();

                itemToUpgradeTextArea.clearText();

                if (item == null) {
                    itemNameLabel.setText("item to upgrade");
                    return;
                }

                itemNameLabel.setText(item.getName());

                materials = StringHelper.listAsString(item.getMaterials());

                itemToUpgradeTextArea.addLine("item level", "" + item.getLevel());
                itemToUpgradeTextArea.addLine("next level", "" + item.getRequiredSalvage());
                itemToUpgradeTextArea.addLine("materials", materials);
            }
        });
        salvageSlot.setItemChangeRunnable(new Runnable() {

            @Override
            public void run() {
                float preview;
                Item upgradeItem = itemToUpgradeSlot.getItem();
                Salvage item = (Salvage) salvageSlot.getItem();

                progressBar.setPreviewAmount(0);
                progressBar.setPreviewProgress(0);

                if (item == null) {
                    return;
                }

                preview = upgradeItem.getAppliedSalvage() + item.getSalvageWorthFor(upgradeItem);
                preview /= 100f;

                progressBar.setPreviewAmount(item.getSalvageWorthFor(upgradeItem));
                progressBar.setPreviewProgress(preview);
            }
        });
    }

    @Override
    public void show() {
        super.show();

        window.setSize(Offset.UpgradeItemWindow.WINDOW_WIDTH, Offset.UpgradeItemWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 0, 0, 0, Offset.UpgradeItemWindow.WINDOW_OFFS_Y);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_X, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_Y);
        GUIHelper.setPosition(itemNameLabel, 0, 0, Offset.UpgradeItemWindow.ITEM_NAME_LABEL_OFFS_X, Offset.UpgradeItemWindow.ITEM_NAME_LABEL_OFFS_Y);

        GUIHelper.setPosition(itemToUpgradeSlot, 0, 0, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_SLOT_OFFS_X, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_SLOT_OFFS_Y);
        GUIHelper.setPosition(salvageSlot, 0, 0, Offset.UpgradeItemWindow.SALVAGE_SLOT_OFFS_X, Offset.UpgradeItemWindow.SALVAGE_SLOT_OFFS_Y);
        GUIHelper.setPosition(augmentationSlot, 0, 0, Offset.UpgradeItemWindow.AUGMENTATION_SLOT_OFFS_X, Offset.UpgradeItemWindow.AUGMENTATION_SLOT_OFFS_Y);
        GUIHelper.setPosition(divineFavorSlot, 0, 0, Offset.UpgradeItemWindow.DIVINE_FAVOR_SLOT_OFFS_X, Offset.UpgradeItemWindow.DIVINE_FAVOR_SLOT_OFFS_Y);
        GUIHelper.setPosition(itemToUpgradeTextArea, 0, 0, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_INFO_OFFS_X, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_INFO_OFFS_Y);
        GUIHelper.setPosition(ritualDetailsTextArea, 0, 0, Offset.UpgradeItemWindow.RITUAL_DETAILS_OFFS_X, Offset.UpgradeItemWindow.RITUAL_DETAILS_OFFS_Y);

        GUIHelper.setPosition(applySalvageButton, 0, 0, Offset.UpgradeItemWindow.ADD_SALVAGE_BUTTON_OFFS_X, Offset.UpgradeItemWindow.ADD_SALVAGE_BUTTON_OFFS_Y);
        GUIHelper.setPosition(applyAugmentationButton, 0, 0, Offset.UpgradeItemWindow.APPLY_AUGMENTATION_BUTTON_OFFS_X, Offset.UpgradeItemWindow.APPLY_AUGMENTATION_BUTTON_OFFS_Y);
        GUIHelper.setPosition(removeAugmentationButton, 0, 0, Offset.UpgradeItemWindow.REMOVE_AUGMENTATION_BUTTON_OFFS_X, Offset.UpgradeItemWindow.REMOVE_AUGMENTATION_BUTTON_OFFS_Y);
        GUIHelper.setPosition(performRitualButton, 0, 0, Offset.UpgradeItemWindow.RITUAL_BUTTON_OFFS_X, Offset.UpgradeItemWindow.RITUAL_BUTTON_OFFS_Y);

        GUIHelper.setSize(applySalvageButton, 0, 0, Offset.UpgradeItemWindow.BUTTON_WIDTH, Offset.UpgradeItemWindow.BUTTON_HEIGHT);
        GUIHelper.setSize(applyAugmentationButton, 0, 0, Offset.UpgradeItemWindow.BUTTON_WIDTH, Offset.UpgradeItemWindow.BUTTON_HEIGHT);
        GUIHelper.setSize(removeAugmentationButton, 0, 0, Offset.UpgradeItemWindow.BUTTON_WIDTH, Offset.UpgradeItemWindow.BUTTON_HEIGHT);
        GUIHelper.setSize(performRitualButton, 0, 0, Offset.UpgradeItemWindow.RITUAL_BUTTON_WIDTH, Offset.UpgradeItemWindow.BUTTON_HEIGHT);

        GUIHelper.setSize(progressBar, 0, 0, Offset.UpgradeItemWindow.SALVAGE_PROGRESS_WIDTH, Offset.UpgradeItemWindow.SALVAGE_PROGRESS_HEIGHT);
        GUIHelper.setPosition(progressBar, 0, 0, Offset.UpgradeItemWindow.SALVAGE_PROGRESS_OFFS_X, Offset.UpgradeItemWindow.SALVAGE_PROGRESS_OFFS_Y);

        GUIHelper.setSize(itemToUpgradeTextArea, 0, 0, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_INFO_WIDTH, Offset.UpgradeItemWindow.ITEM_TO_UPGRADE_INFO_HEIGHT);
        GUIHelper.setSize(ritualDetailsTextArea, 0, 0, Offset.UpgradeItemWindow.RITUAL_DETAILS_WIDTH, Offset.UpgradeItemWindow.RITUAL_DETAILS_HEIGHT);
    }

} // UpgradeItemWindow
