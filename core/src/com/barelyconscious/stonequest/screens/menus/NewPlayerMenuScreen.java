/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         NewPlayerMenuScreen.java
 * Author:            Matt Schwartz
 * Date Created:      05.30.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.GUIHelper;

public class NewPlayerMenuScreen extends MenuScreen {

    private Button backButton;
    private Button continueButton;
    private Label playerNameLabel;
    private TextField playerNameTextArea;

    public NewPlayerMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        GUIHelper.setSize(playerNameLabel, 0, 0, 150, 35);
        GUIHelper.setSize(playerNameTextArea, 0, 0, 200, 35);
        GUIHelper.setSize(continueButton, 0, 0, 125, 35);
        GUIHelper.setSize(backButton, 0, 0, 100, 35);

        GUIHelper.setPosition(playerNameLabel, 1, 0.15f, -475, 35);
        GUIHelper.setPosition(playerNameTextArea, 1, 0.15f, -325, 35);
        GUIHelper.setPosition(continueButton, 1, 0.15f, -125, 35);
        GUIHelper.setPosition(backButton, 1, 0.15f, -100, 0);
    }

    @Override
    public void show() {
        super.show();

        backButton = GUIHelper.createTextButton("Back");
        continueButton = GUIHelper.createTextButton("Create");
        playerNameTextArea = new TextField("player1", GUIHelper.DEFAULT_TEXTFIELD_STYLE);
        playerNameLabel = new Label("Name:", GUIHelper.createLabelStyle(16, Color.WHITE));
        playerNameLabel.setAlignment(Align.right);

        continueButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                continueEvent();
            }

        });
        backButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                backEvent();
            }

        });

        stage.addActor(backButton);
        stage.addActor(continueButton);
        stage.addActor(playerNameLabel);
        stage.addActor(playerNameTextArea);
    }

    @Override
    public void dispose() {
        playerNameLabel.remove();
        backButton.remove();
        continueButton.remove();
        playerNameTextArea.remove();
        stage.dispose();
        game.mainMenuScreen.dispose();
        game.playMenuScreen.dispose();
        super.dispose();
    }
    
    private void continueEvent() {
        game.loadingScreen.setToScreen(game.worldScreen);
        game.setScreen(game.loadingScreen);
        GameWorld.getInstance().setPlayer(new Player(playerNameTextArea.getText()));
    }

    @Override
    public void backEvent() {
        game.setScreen(game.playMenuScreen);
    }
} // NewPlayerMenuScreen
