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
package com.barelyconscious.stonequest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;

public class MainMenuScreen extends GameScreen {

    Stage stage;

    private Button button;
    private Label label;
    
    public MainMenuScreen(Game game) {
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
    public void resize(int width, int height) {
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        button = new TextButton("Play!", GUIHelper.DEFAULT_BUTTON_STYLE);
        button.setWidth(150);
        button.setHeight(40);
        button.setX((Gdx.graphics.getWidth() - button.getWidth()) / 2);
        button.setY((Gdx.graphics.getHeight() - button.getHeight()) / 2);

        button.addListener(new InputListener() {

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            }
            
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
                game.setScreen(game.worldScreen);
            }
        });

        LabelStyle ls = new LabelStyle(FontFactory.createDefaultFont(25), Color.PINK);
        label = new Label("StoneQuest", ls);
        label.setX(0);
        label.setY(0);
        label.setWidth(200);
        label.setAlignment(Align.center);

        stage.addActor(button);
        stage.addActor(label);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
        button.remove();
        label.remove();
        stage.dispose();
    }
    
} // MainMenuScreen
