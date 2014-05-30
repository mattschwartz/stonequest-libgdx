/* *****************************************************************************
   * Project:           core
   * File Name:         EntityObject.java
   * Author:            Matt Schwartz
   * Date Created:      05.24.2014 
   * Redistribution:    You are free to use, reuse, and edit any of the text in
   *                    this file.  You are not allowed to take credit for code
   *                    that was not written fully by yourself, or to remove 
   *                    credit from code that was not written fully by yourself.  
   *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
   * File Description:  
   ************************************************************************** */

package com.barelyconscious.stonequest.gameobjects;

import com.barelyconscious.stonequest.entities.Entity;

public abstract class EntityObject extends GameObject {

    protected Entity entity;
    
    public EntityObject(String filepath, Entity entity) {
        super(filepath);
        this.entity = entity;
    }
} // EntityObject
