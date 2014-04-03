/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        ProgressBar.java
 * Author:           Matt Schwartz
 * Date created:     12.18.2013
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */
package com.barelyconscious.game.graphics.gui;

import com.barelyconscious.game.Screen;
import com.barelyconscious.game.graphics.Font;
import com.barelyconscious.util.TextLogHelper;
import java.awt.Color;

public class ProgressBar implements Component {

    private static final int BACKGROUND_COLOR = new Color(22, 40, 22).getRGB();
    private static final int BASE_COLOR = new Color(75, 137, 75).getRGB();
    private static final int INCREASE_COLOR = new Color(103, 188, 103).getRGB();
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public int max;
    public int current;
    public int increaseBy;

    public ProgressBar(int startX, int startY, int width) {
        x = startX;
        y = startY;
        this.width = width;
        height = 24;
    } // constructor

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int newX) {
        x = newX;
    }

    @Override
    public void setY(int newY) {
        y = newY;
    }

    public void resize(int x, int y) {
        this.x = x;
        this.y = y;
    } // resize

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void render(Screen screen) {
        renderBorder(screen);
        renderBackground(screen);
        renderText(screen);
    } // render

    private void renderBorder(Screen screen) {
        Button.borderLeft.render(screen, x, y);

        for (int i = x + Button.borderLeft.getWidth(); i < x + (width - Button.borderRight.getWidth()); i += Button.borderRepeat.getWidth()) {
            Button.borderRepeat.render(screen, i, y);
        } // for

        Button.borderRight.render(screen, x + width - Button.borderRight.getWidth(), y);
    } // renderBorder

    private void renderBackground(Screen screen) {
        double baseWidthPercent, increaseWidthPercent;
        int progressBarWidth = width - 10;

        screen.fillRectangle(BACKGROUND_COLOR, x + 5, y + 5, progressBarWidth, height - 10);

        // Base width
        baseWidthPercent = Math.min(((current * 1.0 / max)), 1);

        // Increase width
        increaseWidthPercent = Math.min(((increaseBy * 1.0 / max)), 1 - baseWidthPercent);

        screen.fillRectangle(BASE_COLOR, x + 5, y + 5, (int) (baseWidthPercent * progressBarWidth), height - 10);
        screen.fillRectangle(INCREASE_COLOR, x + 5 + (int) (baseWidthPercent * progressBarWidth), y + 5, (int) (increaseWidthPercent * progressBarWidth), height - 10);

    } // renderBackground

    private void renderText(Screen screen) {
        int startX, startY;
        String msg;

        if (increaseBy == 0) {
            return;
        } // if

        msg = "+" + increaseBy;

        startX = x + width - 6 - Font.getStringWidth(screen, msg);
        startY = y + Font.CHAR_HEIGHT + 1;

        screen.fillTransluscentRectangle(startX, y + 6, Font.getStringWidth(screen, msg), Font.CHAR_HEIGHT - 3);
        Font.drawFont(screen, msg, Color.white.getRGB(), startX, startY);
    } // renderText

} // ProgressBar
