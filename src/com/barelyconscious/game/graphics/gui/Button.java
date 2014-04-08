/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        Button.java
 * Author:           Matt Schwartz
 * Date created:     08.25.2013
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */
package com.barelyconscious.game.graphics.gui;

import com.barelyconscious.game.Screen;
import com.barelyconscious.game.graphics.FontService;
import com.barelyconscious.game.graphics.UIElement;
import com.barelyconscious.game.input.Interactable;
import com.barelyconscious.util.TextLogHelper;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button extends Interactable implements Component {

    public static final String BUTTON_BORDER_PATH = "/gfx/gui/components/button/buttonBorder.png";
    public static final int DEFAULT_WIDTH = 108;
    public static final int DEFAULT_HEIGHT = 24;
    public static final int MARGIN = 5;
    protected int x;
    protected int y;
    protected int width = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;
    protected int titleOffsX;
    protected int titleOffsY;
    private int borderHighlightColor = new Color(137, 137, 137).getRGB();
    private int borderShadowColor = new Color(38, 38, 38).getRGB();
    protected boolean hasBorder = false;
    private boolean destroy = false;
    protected String title = "button";
    protected ButtonAction callbackFunction = null;
    protected static UIElement borderLeft;
    protected static UIElement borderRight;
    protected static UIElement borderRepeat;

    /**
     * Creates a new button with a title and at coordinates, startX, startY and automatic values for width and height.
     *
     * @param title the title of the button
     * @param startX the x starting location of the button
     * @param startY the y starting location of the button
     */
    public Button(String title, int startX, int startY, boolean hasBorder) {
        this(title, startX, startY, 50, 25, hasBorder);
    } // constructor

    /**
     *
     * @param screen
     * @param title
     * @param startX
     * @param startY
     * @param hasBorder
     */
    public Button(ButtonAction callback, String title, int zLevel, int startX, int startY, boolean hasBorder) {
        this(title, zLevel, startX, startY, 50, 25, hasBorder);
        callbackFunction = callback;
    } // constructor

    /**
     * Create a new button at the coordinates, (startX, startY) with the width width and height height. None of these values should be below 0 and if
     * any are, they will be disregarded and set to 0.
     *
     * @param startX the starting x coordinate
     * @param startY the starting y coordinate
     * @param width the width of the button
     * @param height the height of the button
     */
    public Button(String title, int startX, int startY, int width, int height, boolean hasBorder) {
        this(title, Interactable.Z_BUTTON, startX, startY, width, height, hasBorder);
    } // constructor

    public Button(String title, int zLevel, int startX, int startY, int width, int height, boolean hasBorder) {
        loadBorder();
        x = Math.max(0, startX);
        y = Math.max(0, startY);

        if (height < 0) {
            height = this.height;
        } // if

        this.width = width;
        this.height = height;

        this.title = title;

        // Find a better way to do this
//        titleOffsX = x + MARGIN + (width - MARGIN * 2 - Font.getStringWidth(Game.screen, title)) / 2;
        titleOffsY = y + FontService.characterHeight;

        this.hasBorder = hasBorder;
        super.setRegion(x, y, this.width, this.height);
        super.addMouseListener(zLevel);
    } // constructor

    /**
     * Loads the border from disk by locating subimages within the larger image. This results in a single, large disk access instead of multiple,
     * smaller accesses
     */
    private void loadBorder() {
        if (borderLeft != null) {
            return;
        } // if
        
        int[] pixels;
        int subWidth = 4;
        int subHeight = 24;
        BufferedImage unparsedImage = UIElement.loadImage(BUTTON_BORDER_PATH);

        pixels = unparsedImage.getRGB(0, 0, subWidth, subHeight, null, 0, subWidth);
        borderLeft = new UIElement(pixels, subWidth, subHeight);
        pixels = unparsedImage.getRGB(subWidth, 0, subWidth, subHeight, null, 0, subWidth);
        borderRight = new UIElement(pixels, subWidth, subHeight);
        pixels = unparsedImage.getRGB(subWidth * 2, 0, subWidth, subHeight, null, 0, subWidth);
        borderRepeat = new UIElement(pixels, subWidth, subHeight);
    } // loadBorder

    public void setCallbackFunction(ButtonAction callbackFunction) {
        this.callbackFunction = callbackFunction;
    } // setCallbackFunction

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Cursors.setCursor(Cursors.DEFAULT_CURSOR);


        if (!enabled && callbackFunction != null) {
            callbackFunction.hoverOverAction(null);
        } // if
    } // setEnabled

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!isEnabled()) {
            return;
        } // if

        if (callbackFunction != null && e.getButton() == Interactable.MOUSE_LEFT_CLICK) {
            callbackFunction.action(this);
        } // if
    } // mouseClicked

    @Override
    public void mouseEntered() {
        if (!isEnabled()) {
            return;
        } // if

        if (callbackFunction != null) {
            callbackFunction.hoverOverAction(this);
        } // if

        super.mouseEntered();
    } // mouseEntered

    @Override
    public void mouseExited() {
        if (!isEnabled()) {
            return;
        } // if

        if (callbackFunction != null) {
            callbackFunction.hoverOverAction(null);
        } // if

        super.mouseExited();
    } // mouseExited

    @Override
    public int getX() {
        return x;
    } // getX

    @Override
    public int getY() {
        return y;
    } // getY

    @Override
    public void setX(int newX) {
        int titleWidth = titleOffsX - x;
        x = Math.max(0, newX);
        titleOffsX = x + titleWidth;

        super.setRegion(x, y, width, height);
    } // setX

    @Override
    public void setY(int newY) {
        y = Math.max(0, newY);
        titleOffsY = y + FontService.characterHeight + 2;

        super.setRegion(x, y, width, height);
    } // setY

    public void setHeight(int newHeight) {
        height = newHeight;
        super.setRegion(x, y, this.width, this.height);
    } // setHeight

    @Override
    public int getHeight() {
        return height;
    } // getHeight

    public void setWidth(int newWidth) {
        width = newWidth;
        super.setRegion(x, y, this.width, this.height);
    } // setWidth

    @Override
    public int getWidth() {
        return width;
    } // getWidth

    /**
     * This function is called when the DialogPane is no longer necessary and should be removed as determined by the JRE.
     */
    @Override
    public void dispose() {
        destroy = true;
        removeMouseListener();
    } // dispose

    @Override
    public boolean shouldRemove() {
        return destroy;
    } // shouldDestroy

    @Override
    public void render(Screen screen) {
        int xOffs = x;
        int yOffs = y;

        if (isMouseInFocus()) {
            renderHighlighted(screen);
            return;
        } // if

        if (isMouseButtonDown()) {
            xOffs++;
            yOffs++;
        } // if

        borderLeft.render(screen, xOffs, yOffs);

        for (int i = xOffs + borderLeft.getWidth(); i < xOffs + (width - borderRight.getWidth()); i += borderRepeat.getWidth()) {
            borderRepeat.render(screen, i, yOffs);
        } // for

        borderRight.render(screen, xOffs + width - borderRight.getWidth(), yOffs);

        renderText(screen);

        if (hasBorder) {
            renderBorder(screen);
        } // if
    } // render

    /**
     * If the user is hovering over the button, the border is highlighted to help provide visual feedback to him/her.
     *
     * @param screen the rendering screen object
     */
    protected void renderHighlighted(Screen screen) {
        int xOffs = x;
        int yOffs = y;

        if (isMouseButtonDown()) {
            xOffs++;
            yOffs++;
        } // if

        borderLeft.renderHighlighted(screen, xOffs, yOffs);

        for (int i = xOffs + borderLeft.getWidth(); i < xOffs + (width - borderRight.getWidth()); i += borderRepeat.getWidth()) {
            borderRepeat.renderHighlighted(screen, i, yOffs);
        } // for

        borderRight.renderHighlighted(screen, xOffs + width - borderRight.getWidth(), yOffs);

        if (title != null && !(title.equals(""))) {
            renderText(screen);
        } // if

        if (hasBorder) {
            renderBorder(screen);
        } // if
    } // renderHighlighted

    protected void renderText(Screen screen) {
        int offsX = titleOffsX;
        int offsY = titleOffsY;

        if (isMouseButtonDown()) {
            offsX++;
            offsY++;
            FontService.drawFont(title, TextLogHelper.TEXTLOG_DEFAULT_COLOR, offsX, offsY);
        } // if
        else {
            FontService.drawFont(title, Color.white, offsX, offsY);
        } // else
    } // renderText

    private void renderBorder(Screen screen) {
        int xOffs = x;
        int yOffs = y;

        if (isMouseButtonDown()) {
            xOffs++;
            yOffs++;
            screen.drawLine(borderShadowColor, xOffs - 1, yOffs - 1, xOffs - 1, yOffs + height + 1);
            screen.drawLine(borderShadowColor, xOffs, yOffs - 1, xOffs + width, yOffs - 1);

            screen.drawLine(borderHighlightColor, xOffs + width, yOffs, xOffs + width, yOffs + height);
            screen.drawLine(borderHighlightColor, xOffs, yOffs + height, xOffs + width, yOffs + height);
        } // if
        else {
            screen.drawLine(borderHighlightColor, xOffs - 1, yOffs - 1, xOffs - 1, yOffs + height + 1);
            screen.drawLine(borderHighlightColor, xOffs, yOffs - 1, xOffs + width, yOffs - 1);

            screen.drawLine(borderShadowColor, xOffs + width, yOffs, xOffs + width, yOffs + height);
            screen.drawLine(borderShadowColor, xOffs, yOffs + height, xOffs + width, yOffs + height);
        } // else
    } // renderButton

    @Override
    public String toString() {
        return "[Button] Title: " + title;
    } // toString
} // Button
