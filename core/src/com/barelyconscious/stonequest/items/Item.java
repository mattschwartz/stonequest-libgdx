/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Item.java
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

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.barelyconscious.stonequest.entities.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Items are a fundamental object to most RPGs. They are virtually physical
 * entities that the player uses to benefit his or her gameplay or simply add
 * flavor to the story.
 *
 * Items have an Entity that owns it. A null Entity means the Item exists within
 * the game world on its own. Entities typically carry Items in their Inventory
 * and can be consumed to achieve some effect.
 */
public class Item implements Comparable {

    public static final int MAX_UPGRADE_LEVEL = 20;

    /**
     * The Item level associated with each item which determines whether certain
     * attributes can occur on the item, how high the values can go as well as
     * how much vendors are willing to give for that item.
     */
    private int level;

    /**
     * The upgraded level of the item, which at level 0 represents an Item that
     * has not been upgraded. Through the Upgrade Item system, an Item's
     * upgradeLevel will be increased, providing improved benefits. An Item can
     * only be upgraded up to a certain level.
     */
    private int upgradeLevel;

    /**
     * The amount of salvage that has been applied to the item so far.
     */
    private int appliedSalvage;

    /**
     * The amount of gold this item is worth to a vendor.
     */
    protected int sellValue;

    private String name;
    protected Entity owner;
    protected Augment augment;
    protected DivineFavor divineFavor;
    protected Image inventoryImage;
    public Image worldImage;
    private List<Material> materials = new ArrayList<>();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    /**
     *
     * @return Returns the Item's current upgrade level as an integer.
     */
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public int getAppliedSalvage() {
        return appliedSalvage;
    }

    /**
     * Determines the total amount of salvage necessary to upgrade an Item's
     * upgrade level.
     *
     * @return Returns the total amount of salvage necessary to upgrade the Item
     * to the next level as an integer
     */
    public int getRequiredSalvage() {
        return Math.max(MAX_UPGRADE_LEVEL, (upgradeLevel + 1)) * 20;
    }
    
    public String getDescription() {
        return "A semmingly uninteresting object.";
    }
    
    public Augment getAugment() {
        return augment;
    }
    
    public DivineFavor getDivineFavor() {
        return divineFavor;
    }

    /**
     * This method is called when the owner (an Entity object) uses the Item.
     * This method should be overriden by subclasses to provide additional
     * unique benefits.
     */
    public void use() {
    }

    /**
     * Every Item can be broken down to its basic materials through the act of
     * Salvaging. These materials can then be applied to other Items in the game
     * to improve them.
     */
    public void salvage() {
    }

    /**
     * Applies amount salvage to the Item. When the amount of salvage applied to
     * an Item reaches a specific point, the Item's upgrade level will increase
     * and its power will increase, providing additional benefits.
     *
     * @param amount
     */
    public void applySalvage(int amount) {
        if (upgradeLevel < MAX_UPGRADE_LEVEL && appliedSalvage + amount >= getRequiredSalvage()) {
            amount = getRequiredSalvage() - appliedSalvage;
            appliedSalvage = amount;
            upgrade();
        } else {
            appliedSalvage += amount;
        }
    }

    protected void upgrade() {
        upgradeLevel++;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
