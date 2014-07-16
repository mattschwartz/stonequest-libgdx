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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.barelyconscious.stonequest.entities.ItemSlot;

public class ItemSlotActor extends Container {

    public static final int SLOT_WIDTH = 50;
    public static final int SLOT_HEIGHT = 50;
    
    private ItemSlot itemSlot;
    private Runnable onItemChanged;

    public ItemSlotActor() {
        addListener(new ItemSlotInputListener());
        setSize(SLOT_WIDTH, SLOT_HEIGHT);
    }
    
    public void setItemSlot(ItemSlot itemSlot) {
        this.itemSlot = itemSlot;
    }

    public void setItemChangeRunnable(Runnable runnable) {
        onItemChanged = runnable;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (itemSlot == null || itemSlot.empty()) {
            return;
        }
        
        // Debug
        Texture tex = new Texture(Gdx.files.internal("sprites/items/inventory/scroll.png"));
        Image img = new Image(tex);

        img.setPosition(getX(), getY());
        img.draw(batch, parentAlpha);
    }
    
    class ItemSlotInputListener extends InputListener {

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        }
    }
} // ItemSlotActor
