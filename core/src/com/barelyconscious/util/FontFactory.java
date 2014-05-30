/* *****************************************************************************
   * Project:           core
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
    
    private static final int MIN_SIZE = 11;
    private static int currentSize = -1;
    private static BitmapFont defaultFont;
    
    public static BitmapFont createDefaultFont(int size) {
        BitmapFont result;
        
        if (currentSize == size && defaultFont != null) {
            return defaultFont;
        }
        
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Exocet.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = Math.max(size, MIN_SIZE);
        
        result = generator.generateFont(param);
        
        currentSize = param.size;
        defaultFont = result;
        
        generator.dispose();
        
        return result;
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
