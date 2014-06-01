/* *****************************************************************************
 * Project:           core
 * File Name:         ItemSlotArea.java
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.GUIHelper;

public class ItemSlotArea extends InputAdapter {

    private Image emptySlotArea;

    private Item contents;
    private Stage stage;

    public ItemSlotArea() {
        emptySlotArea = new Image(GUIHelper.getDrawable("itemSlot"));
    }

    public Item placeItemHere(Item item) {
        Item result = contents;

        contents = item;

        return result;
    }

    public Item getItem() {
        return contents;
    }

    public boolean itemGoesHere(Item item) {
        return true;
    }

    public void setPosition(float x, float y) {
        emptySlotArea.setPosition(x, y);
    }

    public void createAndAdd(Window root, InputMultiplexer inputMultiplexer) {
        stage = root.getStage();
        Gdx.app.log(null, "stagey");
        root.addActor(emptySlotArea);
        inputMultiplexer.addProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 mouse = stage.screenToStageCoordinates(new Vector2(screenX, screenY));
        Rectangle rect = new Rectangle(emptySlotArea.getX(), emptySlotArea.getY(), emptySlotArea.getWidth(), emptySlotArea.getHeight());

        if (rect.contains(mouse)) {
            Gdx.app.log(null, "touchy down");
            return true;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector2 mouse = stage.screenToStageCoordinates(new Vector2(screenX, screenY));
        Rectangle rect = new Rectangle(emptySlotArea.getX(), emptySlotArea.getY(), emptySlotArea.getWidth(), emptySlotArea.getHeight());

        if (rect.contains(mouse)) {
            Gdx.app.log(null, "touchy up");
            return true;
        }

        return false;
    }

} // ItemSlotArea
