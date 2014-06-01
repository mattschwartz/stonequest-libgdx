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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;

public class InGameMenu {

    private final int INVENTORY_OFFS_X = 168;
    private final int INVENTORY_OFFS_Y = 57;
    private final int CHARACTER_OFFS_X = 119;
    private final int CHARACTER_OFFS_Y = INVENTORY_OFFS_Y;
    private final int UPGRADE_OFFS_X = 70;
    private final int UPGRADE_OFFS_Y = INVENTORY_OFFS_Y;
    private final int JOURNAL_OFFS_X = INVENTORY_OFFS_X;
    private final int JOURNAL_OFFS_Y = 20;
    private final int SALVAGE_OFFS_X = CHARACTER_OFFS_X;
    private final int SALVAGE_OFFS_Y = JOURNAL_OFFS_Y;
    private final int BREWING_OFFS_X = UPGRADE_OFFS_X;
    private final int BREWING_OFFS_Y = JOURNAL_OFFS_Y;

    private Stage stage;
    private InventoryWindow inventory;
    private ImageButton inventoryButton;
    private ImageButton characterButton;
    private ImageButton upgradeButton;
    private ImageButton journalButton;
    private ImageButton salvageButton;
    private ImageButton brewingButton;
    private Image uiLeft;
    private Image uiRight;
    private TextArea infoLog;

    public InGameMenu() {
        stage = new Stage();
    }

    public Batch getSpriteBatch() {
        return stage.getSpriteBatch();
    }

    public void resize(int width, int height) {
        GUIHelper.setPosition(infoLog, 0, 0, uiLeft.getWidth() - 1, -1);
        infoLog.setWidth(width - uiRight.getWidth() - uiLeft.getWidth() + 2);
        GUIHelper.setPosition(uiRight, 1f, 0, -uiRight.getWidth(), 0);
        GUIHelper.setPosition(inventoryButton, 1f, 0f, -INVENTORY_OFFS_X, INVENTORY_OFFS_Y);
        GUIHelper.setPosition(characterButton, 1f, 0f, -CHARACTER_OFFS_X, CHARACTER_OFFS_Y);
        GUIHelper.setPosition(upgradeButton, 1f, 0f, -UPGRADE_OFFS_X, UPGRADE_OFFS_Y);
        GUIHelper.setPosition(journalButton, 1f, 0f, -JOURNAL_OFFS_X, JOURNAL_OFFS_Y);
        GUIHelper.setPosition(salvageButton, 1f, 0f, -SALVAGE_OFFS_X, SALVAGE_OFFS_Y);
        GUIHelper.setPosition(brewingButton, 1f, 0f, -BREWING_OFFS_X, BREWING_OFFS_Y);
    }

    public void actAndDraw(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void show(InputMultiplexer inputMultiplexer) {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);

        inventory = new InventoryWindow(this);
        inventoryButton = new ImageButton(GUIHelper.createImageButtonStyle("inventoryButtonImageUp", "inventoryButtonImageDown", "inventoryButtonImageOver"));
        characterButton = new ImageButton(GUIHelper.createImageButtonStyle("characterButtonImageUp", "characterButtonImageDown", "characterButtonImageOver"));
        upgradeButton = new ImageButton(GUIHelper.createImageButtonStyle("upgradeItemButtonImageUp", "upgradeItemButtonImageDown", "upgradeItemButtonImageOver"));
        journalButton = new ImageButton(GUIHelper.createImageButtonStyle("journalButtonImageUp", "journalButtonImageDown", "journalButtonImageOver"));
        salvageButton = new ImageButton(GUIHelper.createImageButtonStyle("salvageButtonImageUp", "salvageButtonImageDown", "salvageButtonImageOver"));
        brewingButton = new ImageButton(GUIHelper.createImageButtonStyle("brewingButtonImageUp", "brewingButtonImageDown", "brewingButtonImageOver"));
        uiLeft = new Image(GUIHelper.getDrawable("ui_left"));
        uiRight = new Image(GUIHelper.getDrawable("ui_right"));

        TextFieldStyle style = new TextFieldStyle();
        style.background = GUIHelper.getDrawable("ui_middle");
        style.font = FontFactory.createDefaultFont(14);
        style.fontColor = Color.LIGHT_GRAY;
        infoLog = new TextArea("Welcome to " + Game.GAME_TITLE + " " + Game.GAME_VERSION, style);
        infoLog.setTouchable(Touchable.disabled);
        
        inventoryButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                inventory.toggle();
            }

        });
        
        inventory.create();
        
        stage.addActor(uiLeft);
        stage.addActor(uiRight);
        stage.addActor(infoLog);
        stage.addActor(inventoryButton);
        stage.addActor(characterButton);
        stage.addActor(upgradeButton);
        stage.addActor(journalButton);
        stage.addActor(salvageButton);
        stage.addActor(brewingButton);
        stage.addActor(inventory.getWindow());
    }

    public void dispose() {
        inventory.remove();
        characterButton.remove();
        upgradeButton.remove();
        journalButton.remove();
        salvageButton.remove();
        brewingButton.remove();
        stage.dispose();
    }

} // InGameMenu
