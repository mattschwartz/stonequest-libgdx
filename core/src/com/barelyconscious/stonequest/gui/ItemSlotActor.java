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
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.stonequest.entities.ItemSlot;

public class ItemSlotActor extends Group {

    public static final int SLOT_WIDTH = 50;
    public static final int SLOT_HEIGHT = 50;

    private ItemSlot itemSlot;
    private ItemTooltip tooltip;
    private ContextMenu popupMenu;

    public ItemSlotActor() {
        setSize(SLOT_WIDTH, SLOT_HEIGHT);
        addListener(new ItemSlotInputListener());
    }

    public void setTooltip(ItemTooltip tooltip) {
        this.tooltip = tooltip;
        this.tooltip.addAnchor(this, null);
    }

    public void show(Stage stage) {
//        popupMenu = new ContextMenu(Arrays.asList(
//                new MenuItem[]{
//                    new MenuItem("Use", null),
//                    new MenuItem("Examine", null),
//                    new MenuItem("Drop", null),
//                    new MenuItem("Cancel", null)}), this);
//
//        stage.addActor(popupMenu);
    }

    public void setItemSlot(final ItemSlot itemSlot) {
        final ItemSlotActor actor = this; // wtf is this??

        this.itemSlot = itemSlot;
        this.itemSlot.addItemChangeAction(new Runnable() {

            @Override
            public void run() {
                tooltip.setItem(actor, itemSlot.getItem());
            }
        });
    }

    // Debug
    static Texture tex = new Texture(Gdx.files.internal("sprites/items/inventory/scroll.png"));
    static Image img = new Image(tex);

    @Override
    public void act(float delta) {
        if (itemSlot == null || itemSlot.empty()) {
            tooltip.setDoNotShow(this, true);
        } else {
            tooltip.setDoNotShow(this, false);
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

    private class ItemSlotInputListener extends ClickListener {

        
        
        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (getTapCount() >= 2) {
                Gdx.app.log("", "doubly clicky");
            }
        }

    }
} // ItemSlotActor
