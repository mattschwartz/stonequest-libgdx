/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         MenuScreen.java
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.screens.GameScreen;
import com.barelyconscious.util.GUIHelper;

public abstract class MenuScreen extends GameScreen implements InputProcessor {

    protected Stage stage;
    private Sprite backgroundImage;
    private Label label;
    private InputMultiplexer multiplexer;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        stage.getSpriteBatch().begin();
        backgroundImage.draw(stage.getSpriteBatch());
        stage.getSpriteBatch().end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        backgroundImage.setSize(width, height);
//        backgroundImage.setPosition((Gdx.graphics.getWidth()
//                - backgroundImage.getWidth()) / 2, (Gdx.graphics.getHeight()
//                - backgroundImage.getHeight()) / 2);
        GUIHelper.setSize(label, 0, 0, 250, 50);
        GUIHelper.setPosition(label, 1, 0, -255, 0);
    }

    @Override
    public void show() {
        stage = new Stage();

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);

        backgroundImage = new Sprite(new Texture(Gdx.files.internal("app/background4.jpg")));
        label = new Label(Game.GAME_TITLE + "\n" + Game.GAME_VERSION, GUIHelper.createLabelStyle(16, Color.LIGHT_GRAY));
        label.setAlignment(Align.right);

        stage.addActor(label);
    }

    @Override
    public void hide() {
        label.remove();
        multiplexer.removeProcessor(this);
        multiplexer.removeProcessor(stage);
    }

    public void backEvent() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.ESCAPE) {
            backEvent();
            return true;
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

} // MenuScreen
