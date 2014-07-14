/* *****************************************************************************
 * Project:           StoneQuest
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
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
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
        DEFAULT_BUTTON_STYLE.down = skin.getDrawable("button_pressed");
        DEFAULT_BUTTON_STYLE.over = skin.getDrawable("button_highlighted");
        DEFAULT_BUTTON_STYLE.font = FontFactory.getTitleFont();

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/textfield.pack"));
        skin.addRegions(atlas);

        DEFAULT_TEXTFIELD_STYLE = new TextFieldStyle();
        DEFAULT_TEXTFIELD_STYLE.background = skin.getDrawable("textField");
        DEFAULT_TEXTFIELD_STYLE.focusedBackground = skin.getDrawable("textFieldFocused");
        DEFAULT_TEXTFIELD_STYLE.selection = skin.getDrawable("textFieldSelection");
        DEFAULT_TEXTFIELD_STYLE.font = FontFactory.getTitleFont();
        DEFAULT_TEXTFIELD_STYLE.fontColor = Color.WHITE;
        DEFAULT_TEXTFIELD_STYLE.cursor = skin.getDrawable("textFieldCursor");

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/gui_buttons.pack"));
        skin.addRegions(atlas);

        atlas = new TextureAtlas(Gdx.files.internal("app/gui/ui.pack"));
        skin.addRegions(atlas);
    }

    public static GUIHelper getInstance() {
        return INSTANCE;
    }

    public static ImageButtonStyle createImageButtonStyle(String name) {
        String up = name + "_up";
        String down = name + "_down";
        String over = name + "_over";

        return createImageButtonStyle(up, down, over);
    }

    public static ImageButtonStyle createImageButtonStyle(String up, String down, String over) {
        ImageButtonStyle result = new ImageButtonStyle();

        result.imageUp = skin.getDrawable(up);
        result.imageOver = skin.getDrawable(over);
        result.imageDown = skin.getDrawable(down);

        return result;
    }
    
    public static TextButtonStyle createTextButtonStyle(String up, String down, String over) {
        TextButtonStyle result = new TextButtonStyle();
        
        result.up = skin.getDrawable(up);
        result.over = skin.getDrawable(over);
        result.down = skin.getDrawable(down);
        
        return result;
    }
    
    public static NinePatch getPatch(String str) {
        return skin.getPatch(str);
    }

    public static Sprite getSprite(String str) {
        return skin.getSprite(str);
    }

    public static Drawable getDrawable(String str) {
        return skin.getDrawable(str);
    }
    
    public static TextArea createTextArea(Color col, int fontSize) {
        TextFieldStyle style = new TextFieldStyle();
        style.font = FontFactory.createFont(fontSize, false);
        style.fontColor = col;
        
        return new TextArea("", style);
    }
    
    public static List createList(String background, int fontSize) {
        ListStyle style = new ListStyle();
        
        style.font = FontFactory.createFont(fontSize, false);
        style.fontColorSelected = Color.BLACK;
        style.fontColorUnselected = Color.BLACK;
        style.selection = getDrawable("GUI_listbox_selection");
        
        
        if (background != null) {
            style.background = getDrawable(background);
        }
        
        return new List(style);
    }

    public static TextButton createTextButton(String text) {
        return new TextButton(text, DEFAULT_BUTTON_STYLE);
    }
    
    public static Label createLabel(String text) {
        return new Label(text, createLabelStyle(16, Color.BLACK));
    }
    
    public static Label createLabel(String text, int size, Color color) {
        return new Label(text, createLabelStyle(size, color));
    }

    public static LabelStyle createLabelStyle() {
        return createLabelStyle(16, Color.BLACK);
    }

    public static LabelStyle createLabelStyle(int size, Color color) {
        return new LabelStyle(FontFactory.createFont(size, true), color);
    }

    public static void setSize(Actor actor, float absWidth, float absHeight, float relWidth, float relHeight) {
        float width = absWidth * Gdx.graphics.getWidth() + relWidth;
        float height = absHeight * Gdx.graphics.getHeight() + relHeight;

        actor.setWidth(width);
        actor.setHeight(height);
        actor.setSize(width, height);
    }

    public static void setPosition(Actor actor, float absX, float absY, float relX, float relY) {
        float x = absX * Gdx.graphics.getWidth() + relX;
        float y = absY * Gdx.graphics.getHeight() + relY;

        actor.setX(x);
        actor.setY(y);
        actor.setPosition(x, y);
    }

}
