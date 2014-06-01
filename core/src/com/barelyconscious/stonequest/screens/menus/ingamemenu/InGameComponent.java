/* *****************************************************************************
 * Project:           core
 * File Name:         InGameMenuComponent.java
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

public abstract class InGameComponent {

    protected InGameMenu inGameMenu;

    public InGameComponent(InGameMenu inGameMenu) {
        this.inGameMenu = inGameMenu;
    }
} // InGameMenuComponent
