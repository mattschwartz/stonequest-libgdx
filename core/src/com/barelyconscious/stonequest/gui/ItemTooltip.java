/* *****************************************************************************
 * Project:           core
 * File Name:         ItemTooltip.java
 * Author:            Matt Schwartz
 * Date Created:      07.29.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.util.GUIHelper;
import java.util.HashMap;
import java.util.Map;

public class ItemTooltip extends Group {

    private final int background_height = 52;
    private final float name_offs_y = -28.5f;
    private final float description_offs_y = 6.5f;
    
    private float x;
    private float y;
    private float width;
    private float height;
    private NinePatch background;
    private Label name;
    private Label description;
    private Map<Actor, Anchor> actorMap;

    private class Anchor {

        public boolean doNotShow;
        public Item item;

        public Anchor() {
        }

        public Anchor(boolean doNotShow, Item item) {
            this.doNotShow = doNotShow;
            this.item = item;
        }
    }

    public ItemTooltip() {
        this("item name", "item description", null);
    }

    public ItemTooltip(String nameText, String descriptionText, Actor anchor) {
        background = GUIHelper.getPatch("GUI_component_item_tooltip_background");
        name = GUIHelper.createLabel(nameText, 14, Color.BLACK);
        description = GUIHelper.createLabel(descriptionText, 12, Color.WHITE);
        actorMap = new HashMap<>();

        name.setAlignment(Align.center);
        name.setTouchable(Touchable.disabled);
        name.setWrap(true);

        description.setAlignment(Align.center);
        description.setTouchable(Touchable.disabled);
        description.setWrap(true);

        if (anchor != null) {
            anchor.addListener(new AnchorListener());
            actorMap.put(anchor, new Anchor(false, null));
        }

        addActor(name);
        addActor(description);
        setVisible(false);
    }

    public ItemTooltip(Item item, Actor anchor) {
        this(item.getName(), item.getDescription(), anchor);

        if (anchor != null) {
            actorMap.put(anchor, new Anchor(false, item));
        }
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

    public void setItem(Actor anchor, Item item) {
        if (!actorMap.containsKey(anchor)) {
            actorMap.put(anchor, new Anchor(false, item));
        } else {
            actorMap.get(anchor).item = item;
        }
    }

    private void setContent(Actor anchor) {
        if (!actorMap.containsKey(anchor)) {
            return;
        }
        Item item = actorMap.get(anchor).item;

        name.setText(item.getName());
        description.setText(item.getDescription());

        width = 250;

        name.setHeight(20);
        name.setWidth(width);
        description.setWidth(width);
        description.setHeight(description.getPrefHeight());

        height = background_height + description.getPrefHeight();
    }

    public void addAnchor(Actor anchor) {
        actorMap.put(anchor, null);
        anchor.addListener(new AnchorListener());
    }

    public void addAnchor(Actor anchor, Item item) {
        anchor.addListener(new AnchorListener());
        actorMap.put(anchor, new Anchor(false, item));
    }

    @Override
    public void act(float delta) {
        setZIndex(Integer.MAX_VALUE); // Always on top
        name.setPosition(x, y + height + name_offs_y);
        description.setPosition(x, y + description_offs_y);
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        background.draw(batch, x, y, width, height);
        super.draw(batch, parentAlpha);
    }

    private class AnchorListener extends InputListener {

        private void setPosition() {
            x = Gdx.input.getX();
            y = Gdx.graphics.getHeight() - Gdx.input.getY();

            if ((y - height) < 0) {
                y -= height - y;
            }

            if ((x + width) > Gdx.graphics.getWidth()) {
                x -= (x + width) - Gdx.graphics.getWidth();
            }

            x = Math.max(x, 0);
            y = Math.max(y, 0);
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
            setContent(event.getListenerActor());
            setVisible(true);
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            setVisible(false);
        }
    }
}
