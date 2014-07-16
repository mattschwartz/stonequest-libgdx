/* *****************************************************************************
 * Project:           stonequest
 * File Name:         Equippable.java
 * Author:            Matt Schwartz
 * Date Created:      05.11.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.items;

import java.util.ArrayList;
import java.util.List;

public class Equippable extends Item {

    public static enum EquipmentSlot {

        helmet,
        chest,
        legs,
        boots,
        gloves,
        belt,
        necklace,
        ring,
        weapon,
        offHand;

        public static final int NUM_SLOTS = values().length;
    }

    private EquipmentSlot slotId;
    private final List<Affix> itemAffixes;

    public Equippable(EquipmentSlot slotId) {
        itemAffixes = new ArrayList<>();
        this.slotId = slotId;
    }

    public EquipmentSlot getSlotId() {
        return slotId;
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }
} // Equippable
