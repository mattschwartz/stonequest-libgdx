/* *****************************************************************************
 * Project:           StoneQuest
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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.console.ConsoleWriter;
import com.barelyconscious.stonequest.console.ConsoleWriter.ChannelName;
import com.barelyconscious.stonequest.input.KeyBindings;
import com.barelyconscious.util.GUIHelper;

public class InGameMenu {

    private Stage stage;
    private InventoryWindow inventoryWindow;
    private CharacterWindow characterWindow;
    private JournalWindow journalWindow;
    private Image buttonBackground;
    private ImageButton inventoryButton;
    private ImageButton characterButton;
    private ImageButton journalButton;
    private ImageButton menuButton;
    private TooltipArea tooltipArea;
    private MessageWindow messageWindow;

    public Batch getSpriteBatch() {
        return stage.getSpriteBatch();
    }

    public void resize(int width, int height) {
        GUIHelper.setPosition(tooltipArea, 1, 0,
                -Offset.InGameMenu.TOOLTIP_OFFS_X,
                Offset.InGameMenu.TOOLTIP_OFFS_Y);
        GUIHelper.setSize(tooltipArea, 0, 0,
                Offset.InGameMenu.TOOLTIP_WIDTH,
                Offset.InGameMenu.TOOLTIP_HEIGHT);

        GUIHelper.setPosition(buttonBackground, 1, 0, 
                Offset.InGameMenu.BUTTONS_BACKGROUND_OFFS_X, 
                Offset.InGameMenu.BUTTONS_BACKGROUND_OFFS_Y);
        
        GUIHelper.setPosition(inventoryButton, 1, 0,
                Offset.InGameMenu.INVENTORY_OFFS_X,
                Offset.InGameMenu.INVENTORY_OFFS_Y);
        GUIHelper.setPosition(characterButton, 1, 0,
                Offset.InGameMenu.CHARACTER_OFFS_X,
                Offset.InGameMenu.CHARACTER_OFFS_Y);
        GUIHelper.setPosition(journalButton, 1, 0,
                Offset.InGameMenu.JOURNAL_OFFS_X,
                Offset.InGameMenu.JOURNAL_OFFS_Y);
        GUIHelper.setPosition(menuButton, 1, 0,
                Offset.InGameMenu.MENU_OFFS_X,
                Offset.InGameMenu.MENU_OFFS_Y);
        
        GUIHelper.setSize(messageWindow, 0, 0, 500, 150);
        GUIHelper.setPosition(messageWindow, 0, 0, 10, 10);
    }

    public void actAndDraw(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void show(InputMultiplexer inputMultiplexer) {
        stage = new Stage() {

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                Actor a;
                Vector2 stagePos = stage.screenToStageCoordinates(new Vector2(screenX, screenY));

                a = hit(stagePos.x, stagePos.y, true);
                tooltipArea.setText("");

                if (a != null && a instanceof Image) {
                    if (a == characterButton.getImage()) {
                        tooltipArea.setText("Character Attributes");
                    } else if (a == inventoryButton.getImage()) {
                        tooltipArea.setText("Inventory And Equipment");
                    } else if (a == journalButton.getImage()) {
                        tooltipArea.setText("Journal");
                    }
                }

                return super.mouseMoved(screenX, screenY);
            }
        };
        inputMultiplexer.addProcessor(stage);

        inventoryWindow = new InventoryWindow(this);
        characterWindow = new CharacterWindow(this);
        journalWindow = new JournalWindow(this);
        inventoryButton = new ImageButton(GUIHelper.createImageButtonStyle("GUI_inventory_window_button"));
        characterButton = new ImageButton(GUIHelper.createImageButtonStyle("GUI_character_window_button"));
        journalButton = new ImageButton(GUIHelper.createImageButtonStyle("GUI_journal_window_button"));
        menuButton = new ImageButton(GUIHelper.createImageButtonStyle("GUI_menu_window_button"));
        buttonBackground = new Image(GUIHelper.getDrawable("GUI_buttons_background"));
        tooltipArea = new TooltipArea("", 14, Color.LIGHT_GRAY);
        messageWindow = new MessageWindow();

        inventoryWindow.create();
        characterWindow.create();
        journalWindow.create();
        
        messageWindow.addChannel(ConsoleWriter.getChannel(ChannelName.general));
        ConsoleWriter.writeLine(ChannelName.general, "Welcome to " + Game.GAME_TITLE + " " + Game.GAME_VERSION);

        stage.addActor(tooltipArea);
        stage.addActor(messageWindow);
        stage.addActor(buttonBackground);
        stage.addActor(inventoryButton);
        stage.addActor(characterButton);
        stage.addActor(journalButton);
        stage.addActor(menuButton);
        stage.addActor(inventoryWindow.getWindow());
        stage.addActor(characterWindow.getWindow());
        stage.addActor(journalWindow.getWindow());

        addActionListeners();
    }

    private void addActionListeners() {
        inventoryButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                KeyBindings.invoke(KeyBindings.open_inventoryWindow);
            }

        });
        characterButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                KeyBindings.invoke(KeyBindings.open_characterWindow);
            }

        });
        journalButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                KeyBindings.invoke(KeyBindings.open_journalWindow);
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
        KeyBindings.addAction(KeyBindings.open_journalWindow, new Runnable() {

            @Override
            public void run() {
                journalWindow.toggle();
            }
            
        });
        KeyBindings.addAction(KeyBindings.close_allWindows, new Runnable() {

            @Override
            public void run() {
                inventoryWindow.hide();
                characterWindow.hide();
                journalWindow.hide();
            }
        });
    }

    public void dispose() {
        inventoryWindow.dispose();
        characterWindow.dispose();
        journalWindow.dispose();
        characterButton.remove();
        journalButton.remove();
        menuButton.remove();
        stage.dispose();
    }

} // InGameMenu
