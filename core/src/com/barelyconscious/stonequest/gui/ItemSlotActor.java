/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         ItemSlotActor.java
 * Author:            Matt Schwartz
 * Date Created:      05.31.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.barelyconscious.stonequest.entities.ItemSlot;
import com.barelyconscious.stonequest.screens.menus.ingamemenu.Tooltip;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemSlotActor extends Group {

    public static final int SLOT_WIDTH = 50;
    public static final int SLOT_HEIGHT = 50;

    private ItemSlot itemSlot;
    private final Tooltip tooltip;
    private ContextMenu popupMenu;

    public ItemSlotActor(Stage stage) {
        setSize(SLOT_WIDTH, SLOT_HEIGHT);
        tooltip = new Tooltip("item", this);
        popupMenu = new ContextMenu(Arrays.asList(
                new MenuItem[]{
                    new MenuItem("Use", null),
                    new MenuItem("Examine", null),
                    new MenuItem("Drop", null),
                    new MenuItem("Cancel", null)}), this);

        stage.addActor(tooltip);
        stage.addActor(popupMenu);

        addListener(new ItemSlotInputListener());
    }

    public void setItemSlot(final ItemSlot itemSlot) {
        this.itemSlot = itemSlot;
        this.itemSlot.addItemChangeAction(new Runnable() {

            @Override
            public void run() {
                tooltip.setText(itemSlot.getItem().getName() + "\n" + itemSlot.getItem().getDescription());
            }
        });
    }

    // Debug
    static Texture tex = new Texture(Gdx.files.internal("sprites/items/inventory/scroll.png"));
    static Image img = new Image(tex);

    @Override
    public void act(float delta) {
        if (itemSlot == null || itemSlot.empty()) {
            tooltip.doNotShow = true;
        } else {
            tooltip.doNotShow = false;
        }
        super.act(delta);
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (itemSlot == null || itemSlot.empty()) {
            return;
        }

        // Debug
        img.setPosition(getX(), getY());
        img.draw(batch, parentAlpha);
    }

    private class ItemSlotInputListener extends InputListener {

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            if (itemSlot == null || itemSlot.empty()) {
            }

        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        }

        @Override
        public boolean mouseMoved(InputEvent event, float x, float y) {
            return false;
        }

    }
} // ItemSlotActor
