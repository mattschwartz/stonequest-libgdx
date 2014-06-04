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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class GUIHelper {

    private static final GUIHelper INSTANCE = new GUIHelper();

    public static TextButtonStyle DEFAULT_BUTTON_STYLE;
    public static LabelStyle DEFAULT_LABEL_STYLE;
    public static TextFieldStyle DEFAULT_TEXTFIELD_STYLE;

    public static Skin skin = new Skin();

    private GUIHelper() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public void init() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("app/gui/button.pack"));
        skin.addRegions(atlas);

        DEFAULT_BUTTON_STYLE = new TextButtonStyle();
        DEFAULT_BUTTON_STYLE.up = skin.getDrawable("button");
        DEFAULT_BUTTON_STYLE.down = skin.getDrawable("buttonPressed");
        DEFAULT_BUTTON_STYLE.over = skin.getDrawable("buttonHighlighted");
        DEFAULT_BUTTON_STYLE.font = FontFactory.createDefaultFont(16);

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/textfield.pack"));
        skin.addRegions(atlas);

        DEFAULT_TEXTFIELD_STYLE = new TextFieldStyle();
        DEFAULT_TEXTFIELD_STYLE.background = skin.getDrawable("textField");
        DEFAULT_TEXTFIELD_STYLE.focusedBackground = skin.getDrawable("textFieldFocused");
        DEFAULT_TEXTFIELD_STYLE.selection = skin.getDrawable("textFieldSelection");
        DEFAULT_TEXTFIELD_STYLE.font = FontFactory.createDefaultFont(16);
        DEFAULT_TEXTFIELD_STYLE.fontColor = Color.WHITE;
        DEFAULT_TEXTFIELD_STYLE.cursor = skin.getDrawable("textFieldCursor");

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/window_buttons.pack"));
        skin.addRegions(atlas);

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/ui.pack"));
        skin.addRegions(atlas);
    }

    public static GUIHelper getInstance() {
        return INSTANCE;
    }

    public static ImageButtonStyle createImageButtonStyle(String name) {
        String up = name + "Up";
        String down = name + "Down";
        String over = name + "Over";

        return createImageButtonStyle(up, down, over);
    }

    public static ImageButtonStyle createImageButtonStyle(String up, String down, String over) {
        ImageButtonStyle result = new ImageButton.ImageButtonStyle();

        result.imageUp = skin.getDrawable(up);
        result.imageOver = skin.getDrawable(over);
        result.imageDown = skin.getDrawable(down);

        return result;
    }

    public static Sprite getSprite(String str) {
        return skin.getSprite(str);
    }

    public static Drawable getDrawable(String str) {
        return skin.getDrawable(str);
    }

    public static Button createButton(String text) {
        return new TextButton(text, DEFAULT_BUTTON_STYLE);
    }

    public static LabelStyle createLabelStyle() {
        return createLabelStyle(16, Color.LIGHT_GRAY);
    }

    public static LabelStyle createLabelStyle(int size, Color color) {
        return new LabelStyle(FontFactory.createDefaultFont(size), color);
    }

    public static void setSize(Actor actor, float absWidth, float absHeight, float relWidth, float relHeight) {
        float width = absWidth * Gdx.graphics.getWidth() + relWidth;
        float height = absHeight * Gdx.graphics.getHeight() + relHeight;

        actor.setWidth(width);
        actor.setHeight(height);
    }

    public static void setPosition(Actor actor, float absX, float absY, float relX, float relY) {
        float x = absX * Gdx.graphics.getWidth() + relX;
        float y = absY * Gdx.graphics.getHeight() + relY;

        actor.setX(x);
        actor.setY(y);
    }

}
