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
import com.barelyconscious.util.GUIHelper;

public class InventoryWindow extends InGameComponent {

    private Label goldAmountLabel;

    public InventoryWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "GUI_inventory_window_background");
    }

    @Override
    protected void createActors() {
        super.createActors();

        goldAmountLabel = GUIHelper.createLabel("0,123,456,789", 13, Color.BLACK);
        goldAmountLabel.setAlignment(Align.right);
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(goldAmountLabel);
    }

    @Override
    public void show() {
        super.show();

        window.setSize(Offset.InventoryWindow.WINDOW_WIDTH,
                Offset.InventoryWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1,
                -Offset.InventoryWindow.WINDOW_WIDTH,
                -Offset.InventoryWindow.WINDOW_HEIGHT);

        GUIHelper.setSize(goldAmountLabel, 0, 0,
                Offset.InventoryWindow.GOLD_AMOUNT_WIDTH,
                Offset.InventoryWindow.GOLD_AMOUNT_HEIGHT);
        GUIHelper.setPosition(goldAmountLabel, 0, 0,
                Offset.InventoryWindow.GOLD_AMOUNT_OFFS_X,
                Offset.InventoryWindow.GOLD_AMOUNT_OFFS_Y);
    }

    @Override
    public void dispose() {
        goldAmountLabel.remove();
        super.dispose();
    }

} // InventoryWindow
