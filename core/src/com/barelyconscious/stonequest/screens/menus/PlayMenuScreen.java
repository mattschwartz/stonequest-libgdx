/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         PlayMenuScreen.java
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

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.GUIHelper;

public class PlayMenuScreen extends MenuScreen {

    private Button backButton;
    private Button newPlayerButton;
    private Button loadPlayerButton;

    public PlayMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        GUIHelper.setSize(newPlayerButton, 0, 0, 150, 35);
        GUIHelper.setSize(loadPlayerButton, 0, 0, 125, 35);
        GUIHelper.setSize(backButton, 0, 0, 100, 35);

        GUIHelper.setPosition(newPlayerButton, 1, 0.15f, -150, 70);
        GUIHelper.setPosition(loadPlayerButton, 1, 0.15f, -125, 35);
        GUIHelper.setPosition(backButton, 1, 0.15f, -100, 0);
    }

    @Override
    public void show() {
        super.show();

        backButton = GUIHelper.createTextButton("Back");
        newPlayerButton = GUIHelper.createTextButton("New");
        loadPlayerButton = GUIHelper.createTextButton("Load");

        newPlayerButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                newPlayerEvent();
            }

        });
        loadPlayerButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                loadPlayerEvent();
            }

        });
        backButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                backEvent();
            }

        });

        stage.addActor(backButton);
        stage.addActor(newPlayerButton);
        stage.addActor(loadPlayerButton);
    }

    @Override
    public void hide() {
        backButton.remove();
        newPlayerButton.remove();
        loadPlayerButton.remove();
        stage.dispose();
    }

    private void newPlayerEvent() {
        game.setScreen(game.newPlayerMenuScreen);
    }

    private void loadPlayerEvent() {
    }

    @Override
    public void backEvent() {
        game.setScreen(game.mainMenuScreen);
    }

} // PlayMenuScreen
