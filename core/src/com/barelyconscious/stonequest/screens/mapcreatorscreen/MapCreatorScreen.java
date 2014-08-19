/* *****************************************************************************
 * Project:           core
 * File Name:         MapCreatorScreen.java
 * Author:            Matt Schwartz
 * Date Created:      07.31.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.mapcreatorscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.input.MapController;
import com.barelyconscious.stonequest.screens.GameScreen;

public class MapCreatorScreen extends GameScreen {

    private Stage stage;
    private InputMultiplexer inputMultiplexer;

    public MapCreatorScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public boolean stillLoading() {
        return loading;
    }

    @Override
    public void load() {
        loading = true;

        inputMultiplexer = new InputMultiplexer(Gdx.input.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
        inputMultiplexer.addProcessor(new MapController());
        
        loading = false;
    }

    @Override
    public void show() {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);
    }

    @Override
    public void dispose() {
        stage.dispose();
        super.dispose();
    }
}
