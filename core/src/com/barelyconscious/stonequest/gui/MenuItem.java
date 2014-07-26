/* *****************************************************************************
 * Project:           core
 * File Name:         MenuItem.java
 * Author:            Matt Schwartz
 * Date Created:      07.25.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.barelyconscious.util.GUIHelper;

public class MenuItem {

    public Label option;
    public Action action;

    public MenuItem() {
    }

    public MenuItem(String option, Action action) {
        this.option = GUIHelper.createLabel(option, 14, Color.WHITE);
        this.action = action;
    }

} // MenuItem
