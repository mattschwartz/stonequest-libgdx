/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Inventory.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.entities;

import com.barelyconscious.stonequest.items.Equippable;
import com.barelyconscious.stonequest.items.Item;
import java.util.List;

public class Inventory {

    public static final int INVENTORY_SLOTS = 24;
    public static final int EQUIPMENT_SLOTS = Equippable.SLOT_ID.NUM_SLOTS;

    private List<Item> inventory;
    private List<Item> equipment;
} // Inventory
