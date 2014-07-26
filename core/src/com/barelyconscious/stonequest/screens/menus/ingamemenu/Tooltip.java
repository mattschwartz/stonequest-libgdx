/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Tooltip.java
 * Author:            Matt Schwartz
 * Date Created:      07.19.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.util.GUIHelper;

public class Tooltip extends Group {

    public boolean doNotShow = false;
    private Label tooltip;
    private Actor anchor;

    public Tooltip(String text, Actor anchor) {
        tooltip = GUIHelper.createTooltipLabel(text);
        this.anchor = anchor;

        tooltip.setAlignment(Align.center);
        tooltip.setTouchable(Touchable.disabled);
        anchor.addListener(new AnchorListener());

        addActor(tooltip);
        setVisible(false);
    }

    public void setText(String text) {
        Label newLabel = GUIHelper.createTooltipLabel(text);
        newLabel.setPosition(tooltip.getX(), tooltip.getY());
        newLabel.setAlignment(Align.center);
        tooltip.remove();
        tooltip = newLabel;
        tooltip.setTouchable(Touchable.disabled);
        addActor(tooltip);
        setVisible(false);
    }

    public void setAnchor(Actor anchor) {
        this.anchor = anchor;
    }

    @Override
    public void act(float delta) {
        if (doNotShow) {
            return;
        }
        
        setZIndex(Integer.MAX_VALUE);
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (doNotShow) {
            return;
        }
        
        super.draw(batch, parentAlpha); //To change body of generated methods, choose Tools | Templates.
    }

    private class AnchorListener extends InputListener {

        private void setPosition() {
            float x = Gdx.input.getX() - tooltip.getWidth() / 2;
            float y = Gdx.graphics.getHeight() - Gdx.input.getY() + 2;

            if ((y - tooltip.getHeight()) < 0) {
                y -= tooltip.getHeight() - y;
            }

            if ((x + tooltip.getWidth()) > Gdx.graphics.getWidth()) {
                x -= (x + tooltip.getWidth()) - Gdx.graphics.getWidth();
            }

            x = Math.max(x, 0);
            y = Math.max(y, 0);
            
            tooltip.setPosition(x, y);
        }

        @Override
        public boolean mouseMoved(InputEvent event, float x, float y) {
            setPosition();
            return false;
        }

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            setPosition();
            setVisible(true);
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            setVisible(false);
        }
    }
}
