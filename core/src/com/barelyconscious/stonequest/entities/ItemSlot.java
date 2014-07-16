/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         ItemSLot.java
 * Author:            Matt Schwartz
 * Date Created:      07.15.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.entities;

import com.barelyconscious.stonequest.items.Item;

public class ItemSlot {

    public Item item;

    public boolean itemGoesHere(Item item) {
        return true;
    }
    
    public boolean empty() {
        return item == null;
    }

    public Item swap(Item item) {
        Item result = this.item;
        this.item = item;

        return result;
    }
}
