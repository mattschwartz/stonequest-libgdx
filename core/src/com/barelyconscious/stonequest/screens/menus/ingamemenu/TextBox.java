/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         TextBox.java
 * Author:            Matt Schwartz
 * Date Created:      06.16.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.barelyconscious.util.FontFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.WordUtils;

public class TextBox extends Actor {

    private boolean centered;
    private String text;
    private Color textColor;
    private BitmapFont font;

    public TextBox(int size, Color textColor) {
        font = FontFactory.createDefaultFont(size);
        this.textColor = textColor;
    }

    public void clearText() {
        text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addLine(String line) {
        text += line + "\n";
    }

    private List<String> getLines() {
        int wrapLength;
        List<String> result = new ArrayList<>();
        wrapLength = (int) (getWidth() / 8);

        result.addAll(Arrays.asList(WordUtils.wrap(text, wrapLength).split("\n")));

        return result;
    }

    private float getStartY(int size) {
        float lineHeight = size * font.getLineHeight();
        float y = getY() + getHeight();

        y -= (getHeight() - lineHeight) / 2;

        return y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float x;
        float y;
        List<String> lines = getLines();
        
        x = getX();
        y = getStartY(lines.size());
        
        Color oldColor = batch.getColor();
        batch.setColor(textColor);
        
        for (String line : lines) {
            font.draw(batch, line, x, y);
            y -= font.getLineHeight();
        }
        
        batch.setColor(oldColor);
    }

}
