/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         JustifiedTextArea.java
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.StringHelper;
import java.util.ArrayList;
import java.util.List;

public class JustifiedTextArea extends Widget {

    private boolean centerLines;
    private Color leftColor;
    private Color rightColor;
    private BitmapFont font;
    private final List<String> leftLines = new ArrayList<>();
    private final List<String> rightLines = new ArrayList<>();

    public JustifiedTextArea(int fontSize, Color leftColor, Color rightColor) {
        font = FontFactory.createFont(fontSize, false);
        this.leftColor = leftColor;
        this.rightColor = rightColor;
        centerLines = false;
    }

    public void setCenterLines(boolean centerLines) {
        this.centerLines = centerLines;
    }
    
    public void clearText() {
        leftLines.clear();
        rightLines.clear();
    }

    public void addLine(String left, String right) {
        if (!StringHelper.isNullOrEmpty(left)) {
            leftLines.add(left);
        }

        if (!StringHelper.isNullOrEmpty(right)) {
            rightLines.add(right);
        }
    }

    private float getStartY() {
        float textHeight = Math.max(leftLines.size(), rightLines.size()) * font.getLineHeight();
        float y = getY() + getHeight();

        if (centerLines) {
            y -= (getHeight() - textHeight) / 2;
        }

        return y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float x = getX();
        float y = getStartY();

        font.setColor(leftColor);
        for (String line : leftLines) {
            font.draw(batch, line, x, y);
            y -= font.getLineHeight();
            
            if ((y - font.getLineHeight()) <= getY()) {
                break;
            }
        }

        font.setColor(rightColor);
        y = getStartY();
        for (String line : rightLines) {
            x = getX() + getWidth() - font.getBounds(line).width;
            font.draw(batch, line, x, y);
            y -= font.getLineHeight();
            
            if ((y - font.getLineHeight()) <= getY()) {
                break;
            }
        }
    }

} // JustifiedTextArea
