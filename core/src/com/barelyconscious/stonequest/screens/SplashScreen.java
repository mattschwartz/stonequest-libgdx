/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         SplashScreen.java
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

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.tweening.SplashScreenAccessor;
import com.barelyconscious.util.GUIHelper;

public class SplashScreen extends GameScreen {

    private Timeline animation;
    private Stage stage;
    private Label loadingLabel;
    private Texture splashTexture;
    private Sprite splashSprite;
    private Batch batch;

    public SplashScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        manager.update(delta);
        batch.begin();
        splashSprite.draw(batch);
        batch.end();

        processInput();
        
        stage.act(delta);
        stage.draw();
        

        if (animation.isFinished() && !game.mainMenuScreen.stillLoading()) {
            game.setScreen(game.mainMenuScreen);
        }
    }

    private void processInput() {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)
                || Gdx.input.isButtonPressed(Buttons.LEFT)) {
            manager.killAll();
        }
    }

    @Override
    public void show() {
        createSprite();
        setupAnimation();
        GUIHelper.getInstance().init();
        stage = new Stage();
        loadingLabel = GUIHelper.createLabel("Loading...", 24, Color.WHITE);
        loadingLabel.setVisible(false);
        stage.addActor(loadingLabel);

        new Thread() {

            @Override
            public void run() {
                game.mainMenuScreen.create();
            }

        }.start();
    }

    private void createSprite() {
        float x = Gdx.graphics.getWidth() / 2;
        float y = Gdx.graphics.getHeight() / 2;

        splashTexture = new Texture("app/splash.png");
        splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        x -= splashTexture.getWidth() / 2;
        y -= splashTexture.getHeight() / 2;

        splashSprite = new Sprite(splashTexture);
        splashSprite.setColor(1, 1, 1, 0);
        splashSprite.setX(x);
        splashSprite.setY(y);

        batch = new SpriteBatch();
    }

    private void setupAnimation() {
        Tween.registerAccessor(Sprite.class, new SplashScreenAccessor());

        TweenCallback onFinish = new TweenCallback() {

            @Override
            public void onEvent(int type, BaseTween<?> source) {
                tweenCompleted();
            }
        };

        animation = Timeline.createSequence()
                .push(Tween.set(splashSprite, SplashScreenAccessor.ALPHA))
                .push(Tween.set(splashSprite, SplashScreenAccessor.Y))
                .beginParallel()
                .push(Tween
                        .to(splashSprite, SplashScreenAccessor.ALPHA, 2f)
                        .target(1f))
                .push(Tween
                        .to(splashSprite, SplashScreenAccessor.Y, 2f)
                        .target((Gdx.graphics.getHeight() - splashSprite.getHeight()) / 2))
                .end()
                .push(Tween
                        .to(splashSprite, SplashScreenAccessor.ALPHA, 2f)
                        .target(0f))
                .setCallback(onFinish)
                .setCallbackTriggers(TweenCallback.COMPLETE)
                .start(manager);
    }

    private void tweenCompleted() {
        splashTexture.dispose();
        loadingLabel.setVisible(true);
    }

    @Override
    public void dispose() {
        super.dispose();
        loadingLabel.remove();
        stage.dispose();
        batch.dispose();
    }
}
