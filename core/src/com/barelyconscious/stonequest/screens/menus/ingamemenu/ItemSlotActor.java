/* *****************************************************************************
 * Project:           core
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
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.barelyconscious.util.GUIHelper;

public class ItemSlotActor extends Container {

    private Image emptySlotImage;

    public ItemSlotActor() {
        emptySlotImage = new Image(GUIHelper.getDrawable("itemSlot"));
        setWidget(emptySlotImage);
        setSize(emptySlotImage.getWidth(), emptySlotImage.getHeight());
        addListener(new ItemSlotInputListener());
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
