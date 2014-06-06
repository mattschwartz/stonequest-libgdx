/* *****************************************************************************
 * Project:           core
 * File Name:         Entity.java
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

import java.util.EnumMap;
import java.util.Map;

public abstract class Entity {

    public static enum Attribute {

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

        public static String toString(Attribute attr) {
            switch (attr) {
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

        public static String getDescription(Attribute attr) {
            switch (attr) {
                case HITPOINTS:
                    return "Your hitpoints. Lose them all and you're dead.";

                case STRENGTH:
                    return "More of this, the harder you hit with physical attacks.";

                case ACCURACY:
                    return "Hit harder.";

                case DEFENSE:
                    return "Get hit less hard.";

                case EVASION:
                    return "Get hit less often.";

                case FIRE_MAGIC:
                    return "Firey.";

                case ICE_MAGIC:
                    return "C-c-c-cold.";

                case HOLY_MAGIC:
                    return "Holier than thou.";

                case CHAOS_MAGIC:
                    return "Chaotic!";

                case FAITH:
                    return "If you have it, hold onto it.";

                default:
                    return toString(attr);
            }
        }
    }

    private final Map<Attribute, Double> attributes;
    private final Inventory inventory;
    protected String name;

    public Entity(String name) {
        this.name = name;
        attributes = new EnumMap<>(Attribute.class);
        inventory = new Inventory();
        setDefaultAttributes();
    }

    private void setDefaultAttributes() {
        for (Attribute attribute : attributes.keySet()) {
            attributes.put(attribute, 10.0);
        }
    }

    public void setAttribute(Attribute attribute, double value) {
        attributes.put(attribute, value);
    }

    public double getAttribute(Attribute attribute) {
        return attributes.get(attribute);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onSpawn() {
    }

    public void onDeath() {
    }

    public void onDamageTaken() {
    }

    public void onDamageDealt() {
    }
} // Entity
