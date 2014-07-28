/* *****************************************************************************
 * Project:           core
 * File Name:         LoadingScreen.java
 * Author:            Matt Schwartz
 * Date Created:      07.26.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.GUIHelper;

public class LoadingScreen extends GameScreen {

    private Stage stage;
    private Label loadingLabel;

    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

        if (!game.worldScreen.stillLoading()) {
            game.setScreen(game.worldScreen);
        }
    }

    @Override
    public void show() {
        stage = new Stage();
        loadingLabel = GUIHelper.createLabel("Loading", 24, Color.WHITE);
        stage.addActor(loadingLabel);
        GUIHelper.setPosition(loadingLabel, 0.5f, 0.5f,
                -loadingLabel.getWidth() / 2, -loadingLabel.getHeight() / 2);

        new Thread() {

            @Override
            public void run() {
                game.worldScreen.loadAssets();
            }

        }.start();
    }

    public void initializeGame() {
    }

    @Override
    public void dispose() {
        loadingLabel.remove();
        stage.dispose();
        super.dispose();
    }

} // LoadingScreen
