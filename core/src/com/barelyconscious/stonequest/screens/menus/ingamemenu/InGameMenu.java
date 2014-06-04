/* *****************************************************************************
 * Project:           core
 * File Name:         InGameMenu.java
 * Author:            Matt Schwartz
 * Date Created:      05.28.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.input.KeyBindings;
import com.barelyconscious.util.GUIHelper;

public class InGameMenu {

    private Stage stage;
    private InventoryWindow inventoryWindow;
    private CharacterWindow characterWindow;
    private ImageButton inventoryButton;
    private ImageButton characterButton;
    private ImageButton upgradeButton;
    private ImageButton journalButton;
    private ImageButton salvageButton;
    private ImageButton brewingButton;
    private Image uiLeft;
    private Image uiRight;

    public InGameMenu() {
        stage = new Stage();
    }

    public Batch getSpriteBatch() {
        return stage.getSpriteBatch();
    }

    public void resize(int width, int height) {
        Console.getInstance().resize(width, height);
        
        GUIHelper.setPosition(uiRight, 1f, 0, -uiRight.getWidth(), 0);
        GUIHelper.setPosition(inventoryButton, 1f, 0f, -Offset.InGameMenu.INVENTORY_OFFS_X, Offset.InGameMenu.INVENTORY_OFFS_Y);
        GUIHelper.setPosition(characterButton, 1f, 0f, -Offset.InGameMenu.CHARACTER_OFFS_X, Offset.InGameMenu.CHARACTER_OFFS_Y);
        GUIHelper.setPosition(upgradeButton, 1f, 0f, -Offset.InGameMenu.UPGRADE_OFFS_X, Offset.InGameMenu.UPGRADE_OFFS_Y);
        GUIHelper.setPosition(journalButton, 1f, 0f, -Offset.InGameMenu.JOURNAL_OFFS_X, Offset.InGameMenu.JOURNAL_OFFS_Y);
        GUIHelper.setPosition(salvageButton, 1f, 0f, -Offset.InGameMenu.SALVAGE_OFFS_X, Offset.InGameMenu.SALVAGE_OFFS_Y);
        GUIHelper.setPosition(brewingButton, 1f, 0f, -Offset.InGameMenu.BREWING_OFFS_X, Offset.InGameMenu.BREWING_OFFS_Y);
    }

    public void actAndDraw(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void show(InputMultiplexer inputMultiplexer) {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);

        inventoryWindow = new InventoryWindow(this);
        characterWindow = new CharacterWindow(this);
        inventoryButton = new ImageButton(GUIHelper.createImageButtonStyle("inventoryButtonImageUp", "inventoryButtonImageDown", "inventoryButtonImageOver"));
        characterButton = new ImageButton(GUIHelper.createImageButtonStyle("characterButtonImageUp", "characterButtonImageDown", "characterButtonImageOver"));
        upgradeButton = new ImageButton(GUIHelper.createImageButtonStyle("upgradeItemButtonImageUp", "upgradeItemButtonImageDown", "upgradeItemButtonImageOver"));
        journalButton = new ImageButton(GUIHelper.createImageButtonStyle("journalButtonImageUp", "journalButtonImageDown", "journalButtonImageOver"));
        salvageButton = new ImageButton(GUIHelper.createImageButtonStyle("salvageButtonImageUp", "salvageButtonImageDown", "salvageButtonImageOver"));
        brewingButton = new ImageButton(GUIHelper.createImageButtonStyle("brewingButtonImageUp", "brewingButtonImageDown", "brewingButtonImageOver"));
        uiLeft = new Image(GUIHelper.getDrawable("ui_left"));
        uiRight = new Image(GUIHelper.getDrawable("ui_right"));

        inventoryWindow.create();
        characterWindow.create();
        Console.getInstance().create(stage);
        Console.getInstance().writeLine("Welcome to " + Game.GAME_TITLE + " " + Game.GAME_VERSION);
        
        stage.addActor(uiLeft);
        stage.addActor(uiRight);
        stage.addActor(inventoryButton);
        stage.addActor(characterButton);
        stage.addActor(upgradeButton);
        stage.addActor(journalButton);
        stage.addActor(salvageButton);
        stage.addActor(brewingButton);
        stage.addActor(inventoryWindow.getWindow());
        stage.addActor(characterWindow.getWindow());

        addActionListeners();
    }

    private void addActionListeners() {
        inventoryButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                KeyBindings.invoke(KeyBindings.open_inventoryWindow);
            }

        });
        characterButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                KeyBindings.invoke(KeyBindings.open_characterWindow);
            }

        });

        KeyBindings.addAction(KeyBindings.open_inventoryWindow, new Runnable() {

            @Override
            public void run() {
                if (inventoryWindow.toggle()) {
                    characterWindow.hide();
                }
            }
        });
        KeyBindings.addAction(KeyBindings.open_characterWindow, new Runnable() {

            @Override
            public void run() {
                if (characterWindow.toggle()) {
                    inventoryWindow.hide();
                }
            }
        });
        KeyBindings.addAction(KeyBindings.close_allWindows, new Runnable() {

            @Override
            public void run() {
                inventoryWindow.hide();
                characterWindow.hide();
            }
        });
    }

    public void dispose() {
        inventoryWindow.dispose();
        characterButton.remove();
        upgradeButton.remove();
        journalButton.remove();
        salvageButton.remove();
        brewingButton.remove();
        stage.dispose();
    }

} // InGameMenu
