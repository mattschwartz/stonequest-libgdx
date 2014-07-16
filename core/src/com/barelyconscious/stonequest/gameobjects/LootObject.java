/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         LootObject.java
 * Author:            Matt Schwartz
 * Date Created:      05.09.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gameobjects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.barelyconscious.stonequest.console.ConsoleWriter;
import com.barelyconscious.stonequest.console.ConsoleWriter.ChannelName;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.SpriteHelper;
import com.barelyconscious.util.StringHelper;

public class LootObject extends GameObject {

    private final Item item;
    private boolean itemUnderPlayer;
    private boolean mouseHoverOver;

    public LootObject(Item item) {
        super("sprites/items/potion_health_small.png");
        this.item = item;
        isSensor = true;
    }

    @Override
    public void update(float delta) {
        itemUnderPlayer = underPlayer();
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseHoverOver = sprite.getBoundingRectangle().contains(getWorldCoords(screenX, screenY));
        return mouseHoverOver;
    }

    @Override
    public void mouseClicked(int screenX, int screenY, int pointer, int button) {
        double distance;
        Player player;
        Rectangle playerBounds;
        
        playerBounds = GameWorld.getInstance().getPlayerBoundingBox();
        distance = SpriteHelper.distance(sprite.getBoundingRectangle(), playerBounds);

        if (distance <= sprite.getWidth() * 1.5) {
            removeOnUpdate = true;
            player = GameWorld.getInstance().getPlayer();
            player.getInventory().addItem(item);
            
            ConsoleWriter.writeLine(ChannelName.general, "You found "
                    + StringHelper.aOrAn(item.getName()) + ".");
        }
    }

    private boolean underPlayer() {
        Rectangle playerBounds = GameWorld.getInstance().getPlayerBoundingBox();

        playerBounds.height = sprite.getHeight();
        playerBounds.y += playerBounds.height;

        return Intersector.overlaps(sprite.getBoundingRectangle(), playerBounds);
    }

    @Override
    public void draw(Batch batch) {
        if (mouseHoverOver) {
            drawHighlighted(batch);
        } else {
            super.draw(batch);
        }
    }

}
