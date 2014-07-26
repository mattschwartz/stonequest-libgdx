/* *****************************************************************************
 * Project:           StoneQuest
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

        public static final int BUTTONS_BACKGROUND_OFFS_X = -229;
        public static final int BUTTONS_BACKGROUND_OFFS_Y = 0;

        public static final int MENU_OFFS_X = -60;
        public static final int MENU_OFFS_Y = 10;

        public static final int JOURNAL_OFFS_X = MENU_OFFS_X - 53;
        public static final int JOURNAL_OFFS_Y = MENU_OFFS_Y;

        public static final int INVENTORY_OFFS_X = JOURNAL_OFFS_X - 53;
        public static final int INVENTORY_OFFS_Y = MENU_OFFS_Y;

        public static final int CHARACTER_OFFS_X = INVENTORY_OFFS_X - 53;
        public static final int CHARACTER_OFFS_Y = MENU_OFFS_Y;

        public static final int TOOLTIP_OFFS_X = 345;
        public static final int TOOLTIP_OFFS_Y = 10;
        public static final int TOOLTIP_WIDTH = 151;
        public static final int TOOLTIP_HEIGHT = 94;
    }

    public class InventoryWindow {

        public static final int WINDOW_WIDTH = 500;
        public static final int WINDOW_HEIGHT = 567;
        
        public static final int CLOSE_WINDOW_BUTTON_OFFS_X = 455;
        public static final int CLOSE_WINDOW_BUTTON_OFFS_Y = WINDOW_HEIGHT - 45;

        public static final int GOLD_AMOUNT_WIDTH = 101 - 8;
        public static final int GOLD_AMOUNT_HEIGHT = 26;
        public static final int GOLD_AMOUNT_OFFS_X = 42 + 4;
        public static final int GOLD_AMOUNT_OFFS_Y = WINDOW_HEIGHT - 341;

        public static final int STAT_LABEL_WIDTH = 100 - 7;
        public static final int STAT_LABEL_LEFT_COL_OFFS_X = 149;
        public static final int STAT_LABEL_RIGHT_COL_OFFS_X = 334;
        public static final int HITPOINTS_OFFS_Y = WINDOW_HEIGHT - 138;
        public static final int STRENGTH_OFFS_Y = WINDOW_HEIGHT - 162;
        public static final int ACCURACY_OFFS_Y = WINDOW_HEIGHT - 185;
        public static final int DEFENSE_OFFS_Y = WINDOW_HEIGHT - 209;
        public static final int EVASION_OFFS_Y = WINDOW_HEIGHT - 233;

        public static final int FIRE_OFFS_Y = HITPOINTS_OFFS_Y;
        public static final int ICE_OFFS_Y = STRENGTH_OFFS_Y;
        public static final int HOLY_OFFS_Y = ACCURACY_OFFS_Y;
        public static final int CHAOS_OFFS_Y = DEFENSE_OFFS_Y;
        public static final int FAITH_OFFS_Y = EVASION_OFFS_Y;

        public static final int INVENTORY_ROWS = 4;
        public static final int INVENTORY_COLS = 9;
        public static final int INVENTORY_OFFS_X = 14;
        public static final int INVENTORY_OFFS_Y = WINDOW_HEIGHT - 394;
        public static final int INVENTORY_STEP_X = 53;
        public static final int INVENTORY_STEP_Y = 53;
    }

    public class CharacterWindow {

        public static final int WINDOW_WIDTH = 380;
        public static final int WINDOW_HEIGHT = 450;

        public static final int CLOSE_WINDOW_BUTTON_OFFS_X = 335;
        public static final int CLOSE_WINDOW_BUTTON_OFFS_Y = WINDOW_HEIGHT - 45;

        public static final int PLAYER_NAME_LABEL_WIDTH = 319;
        public static final int PLAYER_NAME_LABEL_HEIGHT = 32;
        public static final int PLAYER_NAME_LABEL_OFFS_X = 13;
        public static final int PLAYER_NAME_LABEL_OFFS_Y = WINDOW_HEIGHT - 44;

        public static final int TABBED_PANE_WIDTH = 354;
        public static final int TABBED_PANE_HEIGHT = 347;
        public static final int TABBED_PANE_OFFS_X = 13;
        public static final int TABBED_PANE_OFFS_Y = WINDOW_HEIGHT - TABBED_PANE_HEIGHT - 90;

        public static final int ATTRIBUTES_LABEL_WIDTH = 116;
        public static final int ATTRIBUTES_LABEL_HEIGHT = 26;
        public static final int ATTRIBUTES_LABEL_OFFS_X = 13;
        public static final int ATTRIBUTES_LABEL_OFFS_Y = WINDOW_HEIGHT - 86;

        public static final int REPUTATION_LABEL_WIDTH = ATTRIBUTES_LABEL_WIDTH;
        public static final int REPUTATION_LABEL_HEIGHT = ATTRIBUTES_LABEL_HEIGHT;
        public static final int REPUTATION_LABEL_OFFS_X = ATTRIBUTES_LABEL_OFFS_X + ATTRIBUTES_LABEL_WIDTH + 3;
        public static final int REPUTATION_LABEL_OFFS_Y = ATTRIBUTES_LABEL_OFFS_Y;

        public static final int MISC_LABEL_WIDTH = ATTRIBUTES_LABEL_WIDTH;
        public static final int MISC_LABEL_HEIGHT = ATTRIBUTES_LABEL_HEIGHT;
        public static final int MISC_LABEL_OFFS_X = REPUTATION_LABEL_OFFS_X + REPUTATION_LABEL_WIDTH + 3;
        public static final int MISC_LABEL_OFFS_Y = ATTRIBUTES_LABEL_OFFS_Y;

        public static final int TAB_CONTENT_WIDTH = 354 - 16;
        public static final int TAB_CONTENT_HEIGHT = 347 - 16;
        public static final int TAB_CONTENT_OFFS_X = 13 + 8;
        public static final int TAB_CONTENT_OFFS_Y = WINDOW_HEIGHT - TAB_CONTENT_HEIGHT - (90 + 8);
    }

    public class UpgradeItemWindow {

        public static final int WINDOW_WIDTH = 363;
        public static final int WINDOW_HEIGHT = 608;
        public static final int WINDOW_OFFS_Y = 112;

        public static final int CLOSEBUTTON_OFFS_X = 316;
        public static final int CLOSEBUTTON_OFFS_Y = WINDOW_HEIGHT - 38;

        public static final int ITEM_NAME_LABEL_OFFS_X = 25;
        public static final int ITEM_NAME_LABEL_OFFS_Y = WINDOW_HEIGHT - 105;

        public static final int ITEM_TO_UPGRADE_SLOT_OFFS_X = 40;
        public static final int ITEM_TO_UPGRADE_SLOT_OFFS_Y = WINDOW_HEIGHT - 173;

        public static final int SALVAGE_SLOT_OFFS_X = ITEM_TO_UPGRADE_SLOT_OFFS_X;
        public static final int SALVAGE_SLOT_OFFS_Y = WINDOW_HEIGHT - 278;

        public static final int AUGMENTATION_SLOT_OFFS_X = ITEM_TO_UPGRADE_SLOT_OFFS_X;
        public static final int AUGMENTATION_SLOT_OFFS_Y = WINDOW_HEIGHT - 374;

        public static final int DIVINE_FAVOR_SLOT_OFFS_X = ITEM_TO_UPGRADE_SLOT_OFFS_X;
        public static final int DIVINE_FAVOR_SLOT_OFFS_Y = WINDOW_HEIGHT - 468;

        public static final int ITEM_TO_UPGRADE_INFO_WIDTH = 212;
        public static final int ITEM_TO_UPGRADE_INFO_HEIGHT = 63;
        public static final int ITEM_TO_UPGRADE_INFO_OFFS_X = 112;
        public static final int ITEM_TO_UPGRADE_INFO_OFFS_Y = WINDOW_HEIGHT - 185;

        public static final int BUTTON_WIDTH = 114;
        public static final int BUTTON_HEIGHT = 27;
        public static final int ADD_SALVAGE_BUTTON_OFFS_X = 96;
        public static final int ADD_SALVAGE_BUTTON_OFFS_Y = WINDOW_HEIGHT - 284;

        public static final int APPLY_AUGMENTATION_BUTTON_OFFS_X = ADD_SALVAGE_BUTTON_OFFS_X;
        public static final int APPLY_AUGMENTATION_BUTTON_OFFS_Y = WINDOW_HEIGHT - 350;

        public static final int REMOVE_AUGMENTATION_BUTTON_OFFS_X = ADD_SALVAGE_BUTTON_OFFS_X;
        public static final int REMOVE_AUGMENTATION_BUTTON_OFFS_Y = WINDOW_HEIGHT - 380;

        public static final int RITUAL_BUTTON_WIDTH = 162 + 67;
        public static final int RITUAL_BUTTON_OFFS_X = ADD_SALVAGE_BUTTON_OFFS_X;
        public static final int RITUAL_BUTTON_OFFS_Y = WINDOW_HEIGHT - 444;

        public static final int SALVAGE_PROGRESS_WIDTH = 216;
        public static final int SALVAGE_PROGRESS_HEIGHT = 14;
        public static final int SALVAGE_PROGRESS_OFFS_X = 102;
        public static final int SALVAGE_PROGRESS_OFFS_Y = WINDOW_HEIGHT - 248;

        public static final int RITUAL_DETAILS_WIDTH = 272;
        public static final int RITUAL_DETAILS_HEIGHT = 93;
        public static final int RITUAL_DETAILS_OFFS_X = 43;
        public static final int RITUAL_DETAILS_OFFS_Y = WINDOW_HEIGHT - 577;
    }

    public class JournalWindow {

        public static final int WINDOW_WIDTH = 500;
        public static final int WINDOW_HEIGHT = 498;

        public static final int CLOSE_WINDOW_BUTTON_OFFS_X = 305;
        public static final int CLOSE_WINDOW_BUTTON_OFFS_Y = WINDOW_HEIGHT - 45;

        public static final int ENTRY_TITLE_OFFS_X = 18;
        public static final int ENTRY_TITLE_OFFS_Y = WINDOW_HEIGHT - 67;
        public static final int ENTRY_DESCRIPTION_WIDTH = 300;
        public static final int ENTRY_DESCRIPTION_HEIGHT = 269;
        public static final int ENTRY_DESCRIPTION_OFFS_X = ENTRY_TITLE_OFFS_X;
        public static final int ENTRY_DESCRIPTION_OFFS_Y = WINDOW_HEIGHT - ENTRY_DESCRIPTION_HEIGHT - 92;

        public static final int ENTRY_REWARDS_WIDTH = 330;
        public static final int ENTRY_REWARDS_HEIGHT = 156;
        public static final int ENTRY_REWARDS_TITLE_OFFS_X = ENTRY_TITLE_OFFS_X;
        public static final int ENTRY_REWARDS_TITLE_OFFS_Y = ENTRY_REWARDS_HEIGHT + 10 - 67;

        public static final int ENTRY_LISTBOX_WIDTH = 140 - 16;
        public static final int ENTRY_LISTBOX_HEIGHT = 198;
        public static final int ENTRY_LISTBOX_OFFS_X = 350 + 8;
        public static final int ENTRY_LISTBOX_OFFS_Y = WINDOW_HEIGHT - ENTRY_LISTBOX_HEIGHT - 90;
    }
} // Offset
