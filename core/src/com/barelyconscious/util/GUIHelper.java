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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class GUIHelper {

    private static final GUIHelper INSTANCE = new GUIHelper();
    
    public static TextButtonStyle DEFAULT_BUTTON_STYLE;
    
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
        DEFAULT_BUTTON_STYLE.over = skin.getDrawable("buttonHighlighted");
        DEFAULT_BUTTON_STYLE.font = FontFactory.createDefaultFont(25);
    }

    public static GUIHelper getInstance() {
        return INSTANCE;
    }

}
