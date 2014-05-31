/* *****************************************************************************
 * Project:           core
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
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
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
        GUIHelper.setSize(loadPlayerButton, 0, 0, 150, 35);
        GUIHelper.setSize(backButton, 0, 0, 150, 35);

        GUIHelper.setPosition(newPlayerButton, 0, 0.5f, 5, 0);
        GUIHelper.setPosition(loadPlayerButton, 0, 0.5f, 5, -35);
        GUIHelper.setPosition(backButton, 0, 0, 5, 50);
    }

    @Override
    public void show() {
        super.show();

        backButton = GUIHelper.createButton("Back");
        newPlayerButton = GUIHelper.createButton("New");
        loadPlayerButton = GUIHelper.createButton("Load");

        newPlayerButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                newPlayerEvent();
            }

        });
        loadPlayerButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                loadPlayerEvent();
            }

        });
        backButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
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
