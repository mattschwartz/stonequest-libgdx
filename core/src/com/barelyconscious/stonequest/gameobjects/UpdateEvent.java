/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         UpdateEvent.java
 * Author:            Matt Schwartz
 * Date Created:      05.15.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gameobjects;

import com.badlogic.gdx.physics.box2d.World;
import com.barelyconscious.stonequest.world.Zone;

public class UpdateEvent {

    public float delta;
    public World world;
    public Zone zone;

    public UpdateEvent(float delta, World world, Zone zone) {
        this.delta = delta;
        this.world = world;
        this.zone = zone;
    }

} // UpdateEvent
