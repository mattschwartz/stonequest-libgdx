/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Attribute.java
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

public enum Attribute {

    HITPOINTS,
    STRENGTH,
    ACCURACY,
    DEFENSE,
    EVASION,
    FIRE_MAGIC,
    ICE_MAGIC,
    HOLY_MAGIC,
    CHAOS_MAGIC,
    FAITH;

    public static final int NUM_ATTRIBUTES = values().length;

    public static Attribute toAttribute(int ordinal) {
        if (HITPOINTS.ordinal() == ordinal) {
            return HITPOINTS;
        }
        if (STRENGTH.ordinal() == ordinal) {
            return STRENGTH;
        }
        if (ACCURACY.ordinal() == ordinal) {
            return ACCURACY;
        }
        if (DEFENSE.ordinal() == ordinal) {
            return DEFENSE;
        }
        if (EVASION.ordinal() == ordinal) {
            return EVASION;
        }
        if (FIRE_MAGIC.ordinal() == ordinal) {
            return FIRE_MAGIC;
        }
        if (ICE_MAGIC.ordinal() == ordinal) {
            return ICE_MAGIC;
        }
        if (HOLY_MAGIC.ordinal() == ordinal) {
            return HOLY_MAGIC;
        }
        if (CHAOS_MAGIC.ordinal() == ordinal) {
            return CHAOS_MAGIC;
        }
        if (FAITH.ordinal() == ordinal) {
            return FAITH;
        }

        return null;
    }

    @Override
    public String toString() {
        switch (this) {
            case HITPOINTS:
                return "hitpoints";
            case STRENGTH:
                return "strength";
            case ACCURACY:
                return "accuracy";
            case DEFENSE:
                return "defense";
            case EVASION:
                return "evasion";
            case FIRE_MAGIC:
                return "fire magic";
            case ICE_MAGIC:
                return "ice magic";
            case HOLY_MAGIC:
                return "holy magic";
            case CHAOS_MAGIC:
                return "chaos magic";
            case FAITH:
                return "faith";
            default:
                return "invalid";
        }
    }
}
