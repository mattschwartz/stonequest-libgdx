/* *****************************************************************************
 * Project:           core
 * File Name:         Offset.java
 * Author:            Matt Schwartz
 * Date Created:      05.31.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

public class Offset {

    public class InGameMenu {

        public static final int INVENTORY_OFFS_X = 168;
        public static final int INVENTORY_OFFS_Y = 57;

        public static final int CHARACTER_OFFS_X = 119;
        public static final int CHARACTER_OFFS_Y = INVENTORY_OFFS_Y;

        public static final int UPGRADE_OFFS_X = 70;
        public static final int UPGRADE_OFFS_Y = INVENTORY_OFFS_Y;

        public static final int JOURNAL_OFFS_X = INVENTORY_OFFS_X;
        public static final int JOURNAL_OFFS_Y = 20;

        public static final int SALVAGE_OFFS_X = CHARACTER_OFFS_X;
        public static final int SALVAGE_OFFS_Y = JOURNAL_OFFS_Y;

        public static final int BREWING_OFFS_X = UPGRADE_OFFS_X;
        public static final int BREWING_OFFS_Y = JOURNAL_OFFS_Y;

        public static final int TOOLTIP_OFFS_X = 1;
        public static final int TOOLTIP_OFFS_Y = 1;
        public static final int TOOLTIP_WIDTH = 1;
        public static final int TOOLTIP_HEIGHT = 1;

    }

    public class InventoryWindow {

        public static final int WINDOW_WIDTH = 363;
        public static final int WINDOW_HEIGHT = 608;

        public static final int CLOSEBUTTON_OFFS_X = 319;
        public static final int CLOSEBUTTON_OFFS_Y = WINDOW_HEIGHT - 38;

        public static final int GOLD_AMOUNT_WIDTH = 83;
        public static final int GOLD_AMOUNT_HEIGHT = 22;
        public static final int GOLD_AMOUNT_OFFS_X = 130;
        public static final int GOLD_AMOUNT_OFFS_Y = WINDOW_HEIGHT - 366;

        public static final int SLOTS_OFFS_X = 37;
        public static final int SLOTS_OFFS_Y = WINDOW_HEIGHT - 434;
        public static final int SLOTS_STEP_X = 49;
        public static final int SLOTS_STEP_Y = 49;

        public static final int SLOTS_ROWS = 4;
        public static final int SLOTS_COLS = 6;

        public static final int EQUIPMENT_SLOT_HELMET_OFFS_X = 37;
        public static final int EQUIPMENT_SLOT_HELMET_OFFS_Y = WINDOW_HEIGHT - 186;

        public static final int EQUIPMENT_SLOT_CHEST_OFFS_X = EQUIPMENT_SLOT_HELMET_OFFS_X;
        public static final int EQUIPMENT_SLOT_CHEST_OFFS_Y = EQUIPMENT_SLOT_HELMET_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_LEGS_OFFS_X = EQUIPMENT_SLOT_HELMET_OFFS_X;
        public static final int EQUIPMENT_SLOT_LEGS_OFFS_Y = EQUIPMENT_SLOT_CHEST_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_BOOTS_OFFS_X = EQUIPMENT_SLOT_HELMET_OFFS_X;
        public static final int EQUIPMENT_SLOT_BOOTS_OFFS_Y = EQUIPMENT_SLOT_LEGS_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_GLOVES_OFFS_X = 282;
        public static final int EQUIPMENT_SLOT_GLOVES_OFFS_Y = EQUIPMENT_SLOT_HELMET_OFFS_Y;

        public static final int EQUIPMENT_SLOT_BELT_OFFS_X = EQUIPMENT_SLOT_GLOVES_OFFS_X;
        public static final int EQUIPMENT_SLOT_BELT_OFFS_Y = EQUIPMENT_SLOT_GLOVES_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_NECKLACE_OFFS_X = EQUIPMENT_SLOT_GLOVES_OFFS_X;
        public static final int EQUIPMENT_SLOT_NECKLACE_OFFS_Y = EQUIPMENT_SLOT_BELT_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_RING_OFFS_X = EQUIPMENT_SLOT_GLOVES_OFFS_X;
        public static final int EQUIPMENT_SLOT_RING_OFFS_Y = EQUIPMENT_SLOT_NECKLACE_OFFS_Y - 49;

        public static final int EQUIPMENT_SLOT_WEAPON_OFFS_X = 130;
        public static final int EQUIPMENT_SLOT_WEAPON_OFFS_Y = WINDOW_HEIGHT - 333;

        public static final int EQUIPMENT_SLOT_OFFHAND_OFFS_X = 189;
        public static final int EQUIPMENT_SLOT_OFFHAND_OFFS_Y = EQUIPMENT_SLOT_WEAPON_OFFS_Y;

    }

    public class CharacterWindow {

        public static final int WINDOW_WIDTH = 363;
        public static final int WINDOW_HEIGHT = 608;

        public static final int CLOSEBUTTON_OFFS_X = 319;
        public static final int CLOSEBUTTON_OFFS_Y = WINDOW_HEIGHT - 38;

        public static final int PLAYER_NAME_LABEL_OFFS_X = 46;
        public static final int PLAYER_NAME_LABEL_OFFS_Y = WINDOW_HEIGHT - 139;
        public static final int PLAYER_NAME_LABEL_WIDTH = 274;
        public static final int PLAYER_NAME_LABEL_HEIGHT = 28;

        public static final int STATS_WIDTH = 70;
        public static final int STATS_HEIGHT = 28;
        
        public static final int STATS_OFFS_X = 85;
        public static final int STATS_OFFS_Y = WINDOW_HEIGHT - 183;
        public static final int STATS_STEP_X = 166;
        public static final int STATS_STEP_Y = 39;

        public static final int SUBTITLE_LABEL_OFFS_X = 46;
        public static final int SUBTITLE_LABEL_OFFS_Y = WINDOW_HEIGHT - 387;
        public static final int SUBTITLE_LABEL_WIDTH = 274; // + 6
        public static final int SUBTITLE_LABEL_HEIGHT = 28; // + 6

        public static final int DETAILS_TEXTAREA_OFFS_X = 43 + 8;
        public static final int DETAILS_TEXTAREA_OFFS_Y = WINDOW_HEIGHT - 574 + 8;
        public static final int DETAILS_TEXTAREA_WIDTH = 280 - 16;
        public static final int DETAILS_TEXTAREA_HEIGHT = 166 - 16;
    }
} // Offset
