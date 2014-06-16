/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        Salvage.java
 * Author:           Matt Schwartz
 * Date created:     06.15.2014
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */
package com.barelyconscious.stonequest.items;

public class Salvage extends Item {
    public int getSalvageWorthFor(Item item) {
        // if item materials match this item's material, the worth is greater
        return 6;
    }
}
