/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Entry.java
 * Author:            Matt Schwartz
 * Date Created:      07.12.2014
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.journal;

import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.items.Item;
import java.util.List;

public class Entry {

    private boolean isComplete;
    private String title;
    private String description;
    private List<Item> rewards;

    public Entry(String title) {
        isComplete = false;
        this.title = title;
    }
    
    public void complete(Player player) {
        isComplete = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item[] getRewards() {
        return rewards.toArray(new Item[]{});
    }

    public void setRewards(List<Item> rewards) {
        this.rewards = rewards;
    }
}
