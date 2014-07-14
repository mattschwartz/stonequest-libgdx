/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         TooltipArea.java
 * Author:            Matt Schwartz
 * Date Created:      06.04.2014 
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

public class TooltipArea extends Actor {

    private BitmapFont font;
    private String text;

    public TooltipArea(String text, int fontSize, Color color) {
        font = FontFactory.createFont(fontSize, true);
        font.setColor(color);
        setText(text);
    }

    public final void setText(String text) {
        this.text = text;
    }

    private List<String> getLines() {
        int wrapLength;
        List<String> result = new ArrayList<>();
        wrapLength = (int) (getWidth() / 12);

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

        for (String line : lines) {
            x = getX() + (getWidth() - font.getBounds(line).width) / 2;
            font.draw(batch, line, x, y);
            y -= font.getLineHeight();
        }
    }

} // TooltipArea
