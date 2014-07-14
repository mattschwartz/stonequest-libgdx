/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         FontFactory.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontFactory {

    private static final int MIN_SIZE = 10;
    private static BitmapFont defaultFont;
    private static BitmapFont titleFont;

    public static BitmapFont createFont(int size, boolean smallCaps) {
        String fontName;
        BitmapFont result;

        fontName = smallCaps 
                ? "font/Fontin-SmallCaps.ttf" 
                : "font/Fontin.ttf";
        
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontName));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = Math.max(size, MIN_SIZE);

        result = generator.generateFont(param);

        generator.dispose();

        return result;
    }

    public static BitmapFont getTitleFont() {
        if (titleFont != null) {
            return titleFont;
        }

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Fontin-SmallCaps.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 16;
        
        titleFont = generator.generateFont(param);
        
        generator.dispose();
        
        return titleFont;
    }
    
    public static BitmapFont getDefaultFont() {
        if (defaultFont != null) {
            return defaultFont;
        }

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Fontin.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 14;
        
        defaultFont = generator.generateFont(param);
        
        generator.dispose();
        
        return defaultFont;
    }

    public static BitmapFont createFontByName(String filepath, int size) {
        BitmapFont result;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(filepath));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = Math.max(size, MIN_SIZE);

        result = generator.generateFont(param);

        generator.dispose();

        return result;
    }
} // FontFactory
