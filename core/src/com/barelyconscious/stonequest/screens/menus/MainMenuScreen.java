/* *****************************************************************************
 * Project:           core
 * File Name:         MainMenuScreen.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.GUIHelper;

public class MainMenuScreen extends MenuScreen {

    private Button playButton;
    private Button optionsButton;
    private Button exitButton;

    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        GUIHelper.setSize(playButton, 0, 0, 150, 35);
        GUIHelper.setSize(optionsButton, 0, 0, 150, 35);
        GUIHelper.setSize(exitButton, 0, 0, 150, 35);

        GUIHelper.setPosition(playButton, 0, 0.5f, 5, 0);
        GUIHelper.setPosition(optionsButton, 0, 0.5f, 5, -35);
        GUIHelper.setPosition(exitButton, 0, 0, 5, 50);
    }

    @Override
    public void show() {
        super.show();

        playButton = GUIHelper.createButton("Play");
        optionsButton = GUIHelper.createButton("Options");
        exitButton = GUIHelper.createButton("Quit");

        playButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                startGame();
            }
        });
        optionsButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                showOptions();
            }
        });
        exitButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                quitGame();
            }
        });

        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(exitButton);
    }

    @Override
    public void hide() {
        super.hide();
        
        playButton.remove();
        exitButton.remove();
        stage.dispose();
    }

    private void startGame() {
        game.setScreen(game.playMenuScreen);
    }

    private void showOptions() {
//        game.setScreen(game.optionsScreen);
    }

    private void quitGame() {
        Gdx.app.exit();
    }

} // MainMenuScreen
