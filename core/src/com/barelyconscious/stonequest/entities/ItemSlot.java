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
import java.util.ArrayList;
import java.util.List;

public class ItemSlot {

    private Item item;
    private List<Runnable> itemChangeActions;

    public ItemSlot() {
        itemChangeActions = new ArrayList<>();
    }

    public boolean itemGoesHere(Item item) {
        return true;
    }

    public boolean empty() {
        return item == null;
    }
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
        swap(item);
    }
    
    public Item swap(Item item) {
        Item result = this.item;
        this.item = item;

        if (this.item != null) {
            for (Runnable action : itemChangeActions) {
                action.run();
            }
        }

        return result;
    }

    public void addItemChangeAction(Runnable action) {
        itemChangeActions.add(action);
    }
}
