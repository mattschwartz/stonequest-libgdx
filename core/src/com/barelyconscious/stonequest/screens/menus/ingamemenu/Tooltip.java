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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.util.GUIHelper;
import static com.barelyconscious.util.GUIHelper.createLabelStyle;

public class Tooltip extends Actor {

    private boolean showTooltip;
    private String text;
    private final Label tooltip;
    private final Actor anchor;

    public Tooltip(String text, Actor anchor) {
        tooltip = GUIHelper.createTooltipLabel(text);
        this.text = text;
        this.anchor = anchor;

        tooltip.setAlignment(Align.center);
        anchor.addListener(new AnchorListener());
    }

    public void setText(String text) {
        this.text = text;
        tooltip.setText(text);
    }

    @Override
    public void act(float delta) {
        float x = anchor.getX();
        float y = anchor.getY();

        x -= (tooltip.getWidth() - anchor.getWidth()) / 2;
        y += anchor.getHeight() + 5;

        tooltip.setPosition(x, y);
        tooltip.act(delta);
    }

    private void checkBounds(Batch batch) {
        if (!showTooltip) {
            return;
        }

        float x = tooltip.getX();
        float y = tooltip.getY();

        if ((y + tooltip.getHeight()) > getStage().getHeight()) {
            y -= (tooltip.getHeight() + y) - getStage().getHeight();
        }

        if ((x + tooltip.getWidth()) > getStage().getWidth()) {
            x -= (x + tooltip.getWidth()) - getStage().getWidth();
        }
        if (y < 0) {
            y = 0;
        }
        if (x < 0) {
            x = 0;
        }

        // TODO: Figure out this stage bullshit.
//        Vector2 pos = getStage().toScreenCoordinates(new Vector2(x, y),
//                batch.getTransformMatrix());
//        if ((pos.y - tooltip.getHeight()) < 0) {
//            y -= tooltip.getHeight() - pos.y;
//        }
//        
//        if ((pos.x + tooltip.getWidth()) > Gdx.graphics.getWidth()) {
//            x -= (pos.x + tooltip.getWidth()) - Gdx.graphics.getWidth();
//        }
        tooltip.setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (!showTooltip) {
            return;
        }

        checkBounds(batch);
        tooltip.draw(batch, parentAlpha);
    }

    @Override
    public boolean remove() {
        tooltip.remove();

        return super.remove();
    }

    private class AnchorListener extends InputListener {

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            showTooltip = true;
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            showTooltip = false;
        }
    }
}