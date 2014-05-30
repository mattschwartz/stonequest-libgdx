/* *****************************************************************************
 * Project:           core
 * File Name:         GUIHelper.java
 * Author:            Matt Schwartz
 * Date Created:      05.28.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class GUIHelper {

    private static final GUIHelper INSTANCE = new GUIHelper();

    public static TextButtonStyle DEFAULT_BUTTON_STYLE;
    public static LabelStyle DEFAULT_LABEL_STYLE;

    public static Skin skin = new Skin();
    public static TextureAtlas atlas;

    private GUIHelper() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public void init() {
        atlas = new TextureAtlas(Gdx.files.internal("app/gui/button.pack"));
        skin.addRegions(atlas);

        DEFAULT_BUTTON_STYLE = new TextButtonStyle();
        DEFAULT_BUTTON_STYLE.up = skin.getDrawable("button");
        DEFAULT_BUTTON_STYLE.down = skin.getDrawable("buttonPressed");
        DEFAULT_BUTTON_STYLE.over = skin.getDrawable("buttonHighlighted");
        DEFAULT_BUTTON_STYLE.font = FontFactory.createDefaultFont(16);
    }

    public static GUIHelper getInstance() {
        return INSTANCE;
    }
    
    public static Button createButton(String text) {
        return new TextButton(text, DEFAULT_BUTTON_STYLE);
    }
    
    public static LabelStyle getLabelStyle(int size, Color color) {
        return new LabelStyle(FontFactory.createDefaultFont(size), color);
    }

    public static void setSize(Button button, float absWidth, float absHeight, float relWidth, float relHeight) {
        float width = absWidth * Gdx.graphics.getWidth() + relWidth;
        float height = absHeight * Gdx.graphics.getHeight() + relHeight;

        button.setWidth(width);
        button.setHeight(height);
    }

    public static void setPosition(Button button, float absX, float absY, float relX, float relY) {
        float x = absX * Gdx.graphics.getWidth() + relX;
        float y = absY * Gdx.graphics.getHeight() + relY;

        button.setX(x);
        button.setY(y);
    }
    
    public static void setSize(Label label, float absWidth, float absHeight, float relWidth, float relHeight) {
        float x = absWidth * Gdx.graphics.getWidth() + relWidth;
        float y = absHeight * Gdx.graphics.getHeight() + relHeight;

        label.setWidth(x);
        label.setHeight(y);
    }

    public static void setPosition(Label label, float absX, float absY, float relX, float relY) {
        float x = absX * Gdx.graphics.getWidth() + relX;
        float y = absY * Gdx.graphics.getHeight() + relY;

        label.setX(x);
        label.setY(y);
    }
}
