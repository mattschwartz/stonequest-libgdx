/* *****************************************************************************
 * Project:           StoneQuest
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

import com.barelyconscious.util.Pair;
import java.util.EnumMap;
import java.util.Map;

public abstract class Entity {

    protected int level;
    protected String name;
    protected final Map<Attribute, Double> attributes;
    protected final Inventory inventory;

    public Entity(String name) {
        this.name = name;
        attributes = new EnumMap<>(Attribute.class);
        inventory = new Inventory(this);
    }

    public void setAttribute(Attribute attribute, double value) {
        attributes.put(attribute, value);
    }

    public double getAttribute(Attribute attribute) {
        return attributes.get(attribute);
    }
    
    public Pair<Double, Double> getPhysicalDamage() {
        return new Pair(1, 5);
    }
    
    public double getCriticalStrikeChance() {
        return 0.05;
    }
    
    public double getDodgeChance() {
        return 0.05;
    }
    
    public double getPhysicalDamageReduction() {
        return 0.05;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getLevel() {
        return level;
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
