/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        StoneWallTile.java
 * Author:           Matt Schwartz
 * Date created:     12.18.2013
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */

package com.barelyconscious.game.graphics.tiles;

public class StoneWallTile extends Tile {
    public StoneWallTile () {
        super("stone wall", "/gfx/tiles/world/environment/walls/stoneWall.png", 0, true, true);
    } // constructor

    @Override
    public String getDescription() {
        return "A wall built of stones.";
    } // getDescription
} // StoneWallTile
