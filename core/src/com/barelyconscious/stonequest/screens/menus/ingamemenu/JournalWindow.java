/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         JournalWindow.java
 * Author:            Matt Schwartz
 * Date Created:      06.16.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.barelyconscious.util.GUIHelper;

public class JournalWindow extends InGameComponent {

    public JournalWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "journalBackground");
    }

    @Override
    protected void createActors() {
        super.createActors();
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();
    }

    @Override
    public void show() {
        super.show();
        
        window.setSize(Offset.JournalWindow.WINDOW_WIDTH, Offset.JournalWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 0, 0, 0, Offset.JournalWindow.WINDOW_OFFS_Y);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_X, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_Y);
    }
    
}
