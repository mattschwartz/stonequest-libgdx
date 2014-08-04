/* *****************************************************************************
 * Project:           StoneQuest
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

    private boolean loading;
    private Button createMapButton;
    private Button playButton;
    private Button optionsButton;
    private Button exitButton;

    public MainMenuScreen(Game game) {
        super(game);
    }

    public boolean stillLoading() {
        return loading;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        GUIHelper.setSize(playButton, 0, 0, 175, 35);
        GUIHelper.setSize(createMapButton, 0, 0, 150, 35);
        GUIHelper.setSize(optionsButton, 0, 0, 125, 35);
        GUIHelper.setSize(exitButton, 0, 0, 100, 35);

        GUIHelper.setPosition(playButton, 1, 0.15f, -175, 105);
        GUIHelper.setPosition(createMapButton, 1, 0.15f, -150, 70);
        GUIHelper.setPosition(optionsButton, 1, 0.15f, -125, 35);
        GUIHelper.setPosition(exitButton, 1, 0.15f, -100, 0);
    }

    public void create() {
        loading = true;
        createMapButton = GUIHelper.createTextButton("Map Creator");
        playButton = GUIHelper.createTextButton("Play");
        optionsButton = GUIHelper.createTextButton("Options");
        exitButton = GUIHelper.createTextButton("Quit");

        createMapButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.loadingScreen.setToScreen(game.mapCreatorScreen);
                game.setScreen(game.loadingScreen);
            }
            
        });
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

        loading = false;
    }

    @Override
    public void show() {
        super.show();

        stage.addActor(createMapButton);
        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(exitButton);
    }

    @Override
    public void hide() {
        super.hide();

        createMapButton.remove();
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
