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
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;

public class InventoryWindow {

    private final int WINDOW_WIDTH = 363;
    private final int WINDOW_HEIGHT = 608;
    private final int CLOSEBUTTON_OFFS_X = 320;
    private final int CLOSEBUTTON_OFFS_Y = WINDOW_HEIGHT - 37;
    private final int GOLD_AMOUNT_WIDTH = 83;
    private final int GOLD_AMOUNT_HEIGHT = 22;
    private final int GOLD_AMOUNT_OFFS_X = 130;
    private final int GOLD_AMOUNT_OFFS_Y = WINDOW_HEIGHT - 366;

    private Window window;
    private ImageButton closeWindowButton;
    private Label goldAmountLabel;

    public void create() {
        createActors();
        createRootWindow();
        registerEvents();

        hide();
    }

    private void createActors() {
        closeWindowButton = new ImageButton(GUIHelper.createImageButtonStyle("closeWindowButton"));
        goldAmountLabel = new Label("0 g", GUIHelper.createLabelStyle(14, new Color(234f/255f, (185f/255f), (51f/255f), 1)));
        goldAmountLabel.setAlignment(Align.right);
    }

    private void createRootWindow() {
        WindowStyle style = new WindowStyle();
        style.background = GUIHelper.getDrawable("inventoryBackground");
        style.titleFont = FontFactory.createDefaultFont(18);

        window = new Window("", style);

        window.addActor(closeWindowButton);
        window.addActor(goldAmountLabel);
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
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1, -WINDOW_WIDTH, -WINDOW_HEIGHT);
        GUIHelper.setPosition(closeWindowButton, 0, 0, CLOSEBUTTON_OFFS_X, CLOSEBUTTON_OFFS_Y);
        
        GUIHelper.setSize(goldAmountLabel, 0, 0, GOLD_AMOUNT_WIDTH, GOLD_AMOUNT_HEIGHT);
        GUIHelper.setPosition(goldAmountLabel, 0, 0, GOLD_AMOUNT_OFFS_X, GOLD_AMOUNT_OFFS_Y);
        
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
