/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        UpgradeItemWindow.java
 * Author:           Matt Schwartz
 * Date created:     08.29.2013
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */
package com.barelyconscious.game.graphics.gui.windows;

import com.barelyconscious.game.graphics.gui.CloseWindowButton;
import com.barelyconscious.game.graphics.gui.InterfaceWindowButton;
import com.barelyconscious.game.Screen;
import com.barelyconscious.game.graphics.UIElement;
import com.barelyconscious.game.graphics.gui.Button;
import com.barelyconscious.game.graphics.gui.ButtonAction;
import com.barelyconscious.game.graphics.gui.ItemSlotArea;
import com.barelyconscious.game.graphics.gui.JustifiedTextArea;
import com.barelyconscious.game.graphics.gui.ProgressBar;
import com.barelyconscious.game.input.Interactable;
import com.barelyconscious.game.item.Augment;
import com.barelyconscious.game.item.DivineFavor;
import com.barelyconscious.game.item.Item;

public class UpgradeItemWindow extends Window implements ButtonAction {

    private static final UIElement UPGRADE_ITEM_WINDOW_BACKGROUND = UIElement.createUIElement("/gfx/gui/components/windows/upgradeItem/background.png");
    private final int ITEM_TO_UPGRADE_OFFS_X = 40;
    private final int ITEM_TO_UPGRADE_OFFS_Y = 127;
    private final int SALVAGE_OFFS_X = 40;
    private final int SALVAGE_OFFS_Y = 232;
    private final int ITEM_AUGMENT_OFFS_X = 40;
    private final int ITEM_AUGMENT_OFFS_Y = 328;
    private final int DIVINE_FAVOR_OFFS_X = 40;
    private final int DIVINE_FAVOR_OFFS_Y = 422;
    private final int ITEM_DESCRIPTION_WIDTH = 226;
    private final int ITEM_DESCRIPTION_HEIGHT = 69;
    private final int DIVINE_FAVOR_DESCRIPTION_WIDTH = 286;
    private final int DIVINE_FAVOR_DESCRIPTION_HEIGHT = 109;
    private final int SALVAGE_PROGRESS_BAR_WIDTH = 226;
    private int animationY;
    protected InterfaceWindowButton windowButton;
    private CloseWindowButton closeWindowButton;
    private Button applySalvageButton;
    private Button applyAugmentationButton;
    private Button removeAugmentationButton;
    private Button performRitualButton;
    private JustifiedTextArea itemDescriptionTextArea;
    private JustifiedTextArea divineFavorDescriptionTextArea;
    private ItemSlotArea itemToUpgradeSlot;
    private ItemSlotArea salvageSlot;
    private ItemSlotArea itemAugmentSlot;
    private ItemSlotArea divineFavorSlot;
    private ProgressBar itemSalvageProgressBar;

    public UpgradeItemWindow() {
        width = UPGRADE_ITEM_WINDOW_BACKGROUND.getWidth();
        height = UPGRADE_ITEM_WINDOW_BACKGROUND.getHeight();

        closeWindowButton = new CloseWindowButton(this, InterfaceDelegate.INTERFACE_WINDOW_CLOSE_BUTTON);

        applySalvageButton = new Button("Apply", Interactable.Z_BUTTON, windowOffsX + 97, windowOffsY + 258, 111, 24, true);
        applyAugmentationButton = new Button("Apply", Interactable.Z_BUTTON, windowOffsX + 97, windowOffsY + 325, 111, 24, true);
        removeAugmentationButton = new Button("Remove", Interactable.Z_BUTTON, windowOffsX + 97, windowOffsY + 354, 111, 24, true);
        performRitualButton = new Button("Perform Ritual", Interactable.Z_BUTTON, windowOffsX + 97, windowOffsY + 419, 159, 24, true);

        itemDescriptionTextArea = new JustifiedTextArea(windowOffsX + 105, windowOffsY + 116, ITEM_DESCRIPTION_WIDTH, ITEM_DESCRIPTION_HEIGHT);
        divineFavorDescriptionTextArea = new JustifiedTextArea(windowOffsX + 37, windowOffsY + 478, DIVINE_FAVOR_DESCRIPTION_WIDTH, DIVINE_FAVOR_DESCRIPTION_HEIGHT);

        itemSalvageProgressBar = new ProgressBar(windowOffsX + 97, windowOffsY + 229, SALVAGE_PROGRESS_BAR_WIDTH);

        // Disable all buttons when the window is not visible
        setComponentsEnabled(false);
        createItemSlots();
        resizeItemSlots();

        // Set the callback functions for the buttons
        setCallbacks();

        super.setRegion(windowOffsX, windowOffsY, width, height);
        super.addMouseListener(Interactable.Z_BACKGROUND);
        hide();
    } // constructor

    /**
     * Disable or enable all buttons associated with the upgrade item window
     * that should not be interactable with whenever the frame is hidden.
     *
     * @param enabled if true, all buttons will be enabled
     */
    private void setComponentsEnabled(boolean enabled) {
        closeWindowButton.setEnabled(enabled);
        applySalvageButton.setEnabled(enabled);
        applyAugmentationButton.setEnabled(enabled);
        removeAugmentationButton.setEnabled(enabled);
        performRitualButton.setEnabled(enabled);
        itemDescriptionTextArea.setEnabled(enabled);
        divineFavorDescriptionTextArea.setEnabled(enabled);
        // item slot areas
    } // setComponentsEnabled

    /**
     * Sets the callback functions for all of the buttons so this class so that
     * each button knows who to call when an action is performed.
     */
    private void setCallbacks() {
        applySalvageButton.setCallbackFunction(this);
        applyAugmentationButton.setCallbackFunction(this);
        removeAugmentationButton.setCallbackFunction(this);
        performRitualButton.setCallbackFunction(this);
    } // setCallbacks

    /**
     * Resize elements as necessary when the application is resized.
     *
     * @param artworkWindowOffsX the new windowOffsX position of the artwork
     * interface window
     * @param artworkWindowOffsY the new windowOffsY position of the artwork
     * interface window
     * @param windowButtonX the new windowOffsX position of the upgrade item
     * window's button
     * @param windowButtonY the new windowOffsY position of the upgrade item
     * window's button
     */
    public void resize(int artworkWindowOffsX, int artworkWindowOffsY, int windowButtonX, int windowButtonY) {
        windowOffsX = artworkWindowOffsX;
        windowOffsY = artworkWindowOffsY - UPGRADE_ITEM_WINDOW_BACKGROUND.getHeight();

        /* Relocate (if necessary) the button in the interface which toggles the 
         * showing of the Upgrade Item window */
        windowButton.setX(windowButtonX);
        windowButton.setY(windowButtonY);

        // Relocate all other buttons as necessary
        resizeButtons(windowOffsX, windowOffsY);
        resizeItemSlots();

        // Relocate text logs as necessary
        itemDescriptionTextArea.resize(windowOffsX + 105, windowOffsY + 116);
        divineFavorDescriptionTextArea.resize(windowOffsX + 37, windowOffsY + 478);

        itemSalvageProgressBar.resize(windowOffsX + 97, windowOffsY + 229);

        super.setRegion(windowOffsX, windowOffsY, width, height);
    } // resize

    /**
     * Given the new coordinates for the Upgrade Item window interface, all
     * inner buttons may need to be shifted accordingly so that the interface
     * maintains a complete image.
     *
     * @param windowOffsX the new windowOffsX coordinate of the starting
     * location for the Upgrade Item window interface
     * @param windowOffsY the new windowOffsY coordinate of the starting
     * location for the Upgrade Item window interface
     */
    private void resizeButtons(int windowOffsX, int windowOffsY) {
        closeWindowButton.setX(windowOffsX + 16);
        closeWindowButton.setY(windowOffsY + 10);

        applySalvageButton.setX(windowOffsX + 97);
        applySalvageButton.setY(windowOffsY + 258);

        applyAugmentationButton.setX(windowOffsX + 97);
        applyAugmentationButton.setY(windowOffsY + 325);

        removeAugmentationButton.setX(windowOffsX + 97);
        removeAugmentationButton.setY(windowOffsY + 354);

        performRitualButton.setX(windowOffsX + 97);
        performRitualButton.setY(windowOffsY + 419);
    } // resizeButtons

    private void createItemSlots() {
        itemToUpgradeSlot = new ItemSlotArea() {

            @Override
            public Item setItem(Item item) {
                itemSalvageProgressBar.max = item.getRequiredSalvage();
                itemSalvageProgressBar.current = item.getAppliedSalvage();
                return super.setItem(item);
            }

            @Override
            public Item removeItem() {
                itemSalvageProgressBar.max = 0;
                itemSalvageProgressBar.current = 0;
                itemSalvageProgressBar.increaseBy = 0;
                return super.removeItem();
            }

        };
        salvageSlot = new ItemSlotArea() {

            @Override
            public Item setItem(Item item) {
                itemSalvageProgressBar.increaseBy = (int) (Math.random() * 400);
                return super.setItem(item);
            }

            @Override
            public Item removeItem() {
                itemSalvageProgressBar.increaseBy = 0;
                return super.removeItem();
            }

        };
        itemAugmentSlot = new ItemSlotArea() {

            @Override
            public boolean itemGoesHere(Item item) {
                return item instanceof Augment;
            }

        };
        divineFavorSlot = new ItemSlotArea() {

            @Override
            public boolean itemGoesHere(Item item) {
                return item instanceof DivineFavor;
            }

        };
    } // createItemSlots

    private void resizeItemSlots() {
        itemToUpgradeSlot.resize(windowOffsX + ITEM_TO_UPGRADE_OFFS_X, windowOffsY + ITEM_TO_UPGRADE_OFFS_Y);
        salvageSlot.resize(windowOffsX + SALVAGE_OFFS_X, windowOffsY + SALVAGE_OFFS_Y);
        itemAugmentSlot.resize(windowOffsX + ITEM_AUGMENT_OFFS_X, windowOffsY + ITEM_AUGMENT_OFFS_Y);
        divineFavorSlot.resize(windowOffsX + DIVINE_FAVOR_OFFS_X, windowOffsY + DIVINE_FAVOR_OFFS_Y);
    } // resizeItemSlots

    @Override
    public void show() {
        if (InterfaceDelegate.getInstance().journalWindow.isVisible) {
            InterfaceDelegate.getInstance().journalWindow.hide();
        } // if

        super.show();
        animationY = 0 - UPGRADE_ITEM_WINDOW_BACKGROUND.getHeight();
        setComponentsEnabled(true);
        setEnabled(true);
    } // show

    @Override
    public final void hide() {
        super.hide();
        setComponentsEnabled(false);
        setEnabled(false);
        itemToUpgradeSlot.onHide();
        salvageSlot.onHide();
    } // hide

    @Override
    public void action(Button buttonPressed) {
        if (buttonPressed == closeWindowButton || buttonPressed == windowButton) {
            toggleUI();

            if (buttonPressed == windowButton) {
                hoverOverAction(buttonPressed);
            } // if
        } // if
        else if (buttonPressed == applySalvageButton) {
            System.err.println("Applying salvage to item!");
        } // else if
        else if (buttonPressed == applyAugmentationButton) {
            System.err.println("Applying augmentation to item!");
        } // else if
        else if (buttonPressed == removeAugmentationButton) {
            System.err.println("Removing augmentation from item!");
        } // else if
        else if (buttonPressed == performRitualButton) {
            System.err.println("Performing ritual!");
        } // else if
        else {
            System.err.println("Unkown button: " + buttonPressed);
        } // else
    } // action

    @Override
    public void hoverOverAction(Button caller) {
        if (caller == null) {
            InterfaceDelegate.getInstance().clearTooltipText();
            return;
        } // if

        if (caller == windowButton) {
            if (isVisible) {
                InterfaceDelegate.getInstance().setTooltipText("Click to close\nthe Upgrade\nItem Window");
            } // if
            else {
                InterfaceDelegate.getInstance().setTooltipText("Click to open\nthe Upgrade\nItem Window");
            } // else
        } // if
        else if (caller == closeWindowButton) {
            InterfaceDelegate.getInstance().setTooltipText("Click to close\nthe Upgrade\nItem Window");
        } // else if
        else if (caller == applySalvageButton) {
            InterfaceDelegate.getInstance().setTooltipText("Adds selected\nsalvage to the\nitem, improving\nit");
        } // else if
        else if (caller == applyAugmentationButton) {
            InterfaceDelegate.getInstance().setTooltipText("Applies an\naugmentation\nto the item");
        } // else if
        else if (caller == removeAugmentationButton) {
            InterfaceDelegate.getInstance().setTooltipText("Removes the\naugmentation\nfrom the item");
        } // else if
        else if (caller == performRitualButton) {
            InterfaceDelegate.getInstance().setTooltipText("Performs a\nreligious ritual\nin the hopes of\ngaining divine\nfavor");
        } // else if
    } // hoverOverAction

    private void updateItemInfo() {
        Item item = itemToUpgradeSlot.getItem();

        itemDescriptionTextArea.clearText();
        if (item == null) {
            return;
        } // if

        itemDescriptionTextArea.appendLine("Item level", "" + item.getItemLevel());
        itemDescriptionTextArea.appendLine("Next level", "" + item.getRequiredSalvage());
        itemDescriptionTextArea.appendLine("Material", item.getMaterial());
    } // updateItemInfo

    private void updateDivineFavorInfo() {
        Item item = divineFavorSlot.getItem();

        divineFavorDescriptionTextArea.clearText();
        if (item == null) {
            return;
        } // if
    } // updateDivineFavorInfo

    @Override
    public void render(Screen screen) {
        windowButton.render(screen);

        if (!isVisible) {
            return;
        } // if

        animationY = Math.min(animationY + (int) (screen.getVisibleHeight() * FALL_RATE), windowOffsY);

        UPGRADE_ITEM_WINDOW_BACKGROUND.render(screen, windowOffsX, animationY);

        if (animationY == windowOffsY) {
            closeWindowButton.render(screen);
            applySalvageButton.render(screen);
            applyAugmentationButton.render(screen);
            removeAugmentationButton.render(screen);
            performRitualButton.render(screen);

            updateItemInfo();
            itemDescriptionTextArea.render(screen);

            updateDivineFavorInfo();
            divineFavorDescriptionTextArea.render(screen);
            renderItemSlots(screen);

            itemSalvageProgressBar.render(screen);
        } // if
    } // render

    private void renderItemSlots(Screen screen) {
        itemToUpgradeSlot.render(screen);
        salvageSlot.render(screen);
        itemAugmentSlot.render(screen);
        divineFavorSlot.render(screen);
    } // renderItemSlots
} // UpgradeItemWindow
