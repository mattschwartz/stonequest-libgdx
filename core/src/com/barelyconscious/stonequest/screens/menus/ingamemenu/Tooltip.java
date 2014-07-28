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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.util.GUIHelper;
import java.util.HashMap;
import java.util.Map;

public class Tooltip extends Group {

    private Label tooltip;
    private Map<Actor, Anchor> actorMap;

    private class Anchor {

        public boolean doNotShow;
        public String text;

        public Anchor() {
        }

        public Anchor(boolean doNotShow, String text) {
            this.doNotShow = doNotShow;
            this.text = text;
        }
    }

    public Tooltip() {
        this(null, null);
    }

    public Tooltip(String text, Actor anchor) {
        tooltip = GUIHelper.createTooltipLabel(text);
        actorMap = new HashMap<>();

        tooltip.setAlignment(Align.center);
        tooltip.setTouchable(Touchable.disabled);

        if (anchor != null) {
            anchor.addListener(new AnchorListener());
            actorMap.put(anchor, new Anchor(false, text));
        }

        addActor(tooltip);
        setVisible(false);
    }

    public void setDoNotShow(Actor anchor, boolean doNotShow) {
        if (!actorMap.containsKey(anchor)) {
            return;
        }
        actorMap.get(anchor).doNotShow = doNotShow;
    }

    public boolean shouldShow(Actor anchor) {
        if (!actorMap.containsKey(anchor)) {
            return false;
        }
        return actorMap.get(anchor).doNotShow;
    }

    public void setText(Actor anchor, String text) {
        actorMap.put(anchor, new Anchor(false, text));
    }

    private void setText(Actor anchor) {
        if (!actorMap.containsKey(anchor)) {
            return;
        }

        tooltip.setText(actorMap.get(anchor).text);
        tooltip.setSize(tooltip.getPrefWidth(), tooltip.getPrefHeight());
        setVisible(false);
    }
    
    public void addAnchor(Actor anchor) {
        actorMap.put(anchor, null);
        anchor.addListener(new AnchorListener());
    }

    public void addAnchor(Actor anchor, String text) {
        actorMap.put(anchor, new Anchor(false, text));
        anchor.addListener(new AnchorListener());
    }

    @Override
    public void act(float delta) {
        setZIndex(Integer.MAX_VALUE); // Always on top
        super.act(delta);
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
            if (shouldShow(event.getListenerActor())) {
                return;
            }

            setPosition();
            setText(event.getListenerActor());
            setVisible(true);
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            setVisible(false);
        }
    }
}
