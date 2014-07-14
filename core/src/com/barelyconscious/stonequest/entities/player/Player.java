/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Player.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.entities.player;

import com.barelyconscious.stonequest.entities.Entity;
import com.barelyconscious.stonequest.journal.Journal;

public class Player extends Entity {

    private String profession;
    private final Journal journal;

    public Player(String name) {
        super(name);
        journal = new Journal();
        
        // since professions are not yet implemented
        profession = "Architect";
    }

    public Journal getJournal() {
        return journal;
    }

    public String getProfession() {
        return profession;
    }
} // Player
