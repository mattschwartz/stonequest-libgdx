/* *****************************************************************************
   * Project:           StoneQuest
   * File Name:         WorldView.java
   * Author:            Matt Schwartz
   * Date Created:      02.21.2014 
   * Redistribution:    You are free to use, reuse, and edit any of the text in
   *                    this file.  You are not allowed to take credit for code
   *                    that was not written fully by yourself, or to remove 
   *                    credit from code that was not written fully by yourself.  
   *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
   * File Description:  
   ************************************************************************** */

package com.barelyconscious.game.graphics;

import com.barelyconscious.game.World;
import com.barelyconscious.game.player.Player;

public class WorldView extends View {
    public WorldView(Player player, int width, int height) {
        super(width, height);
        
        World.INSTANCE.spawnPlayer(player, 0, 0);
        World.INSTANCE.resize(width, height);
        addComponent(World.INSTANCE);
        
        //WindowManager.INSTANCE.start();
    } // constructor
} // WorldView

