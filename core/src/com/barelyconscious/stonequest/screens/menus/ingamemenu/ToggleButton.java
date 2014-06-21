/* *****************************************************************************
 * Project:           core
 * File Name:         ToggleButton.java
 * Author:            Matt Schwartz
 * Date Created:      06.20.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.util.GUIHelper;

public class ToggleButton extends Button {

    private boolean toggled;
    private TextButtonStyle enabledStyle;
    private TextButtonStyle disabledStyle;

    public ToggleButton() {
        enabledStyle = GUIHelper.createTextButtonStyle("journalButtonEnabledUp", "journalButtonEnabledDown", "journalButtonEnabledOver");
        disabledStyle = GUIHelper.createTextButtonStyle("journalButtonDisabledUp", "journalButtonDisabledDown", "journalButtonDisabledOver");
        init();
    }

    public ToggleButton(TextButtonStyle enabled, TextButtonStyle disabled) {
        this.enabledStyle = enabled;
        this.disabledStyle = disabled;
        init();
    }
    
    private void init() {
        setStyle(disabledStyle);
        
        addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggled = !toggled;

                if (toggled) {
                    setStyle(enabledStyle);
                } else {
                    setStyle(disabledStyle);
                }
            }

        });
    }

    public boolean isToggled() {
        return toggled;
    }
    
    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        
        if (toggled) {
            setStyle(enabledStyle);
        } else {
            setStyle(disabledStyle);
        }
    }

} // ToggleButton
