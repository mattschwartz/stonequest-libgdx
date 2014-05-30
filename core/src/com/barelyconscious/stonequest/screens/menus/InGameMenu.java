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
package com.barelyconscious.stonequest.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.barelyconscious.util.GUIHelper;

public class InGameMenu {

    private Stage stage;
    private Button button;

    public InGameMenu() {
        stage = new Stage();
    }

    public Batch getSpriteBatch() {
        return stage.getSpriteBatch();
    }

    public void resize(int width, int height) {
        button.setX((Gdx.graphics.getWidth() - button.getWidth() * 3) / 2);
        button.setY((Gdx.graphics.getHeight() - button.getHeight()) / 2);
    }

    public void actAndDraw(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void show(InputMultiplexer inputMultiplexer) {
        stage = new Stage();
        inputMultiplexer.addProcessor(stage);

        button = new TextButton("Options", GUIHelper.DEFAULT_BUTTON_STYLE);
        button.setWidth(150);
        button.setHeight(40);

        button.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

        });

        stage.addActor(button);
    }

    public void dispose() {
        stage.dispose();
    }

} // InGameMenu
