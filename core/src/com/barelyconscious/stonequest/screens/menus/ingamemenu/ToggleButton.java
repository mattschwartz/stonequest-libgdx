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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.util.GUIHelper;

public class ToggleButton extends Button {

    private boolean toggled;
    private Label textLabel;
    private TextButtonStyle enabledStyle;
    private TextButtonStyle disabledStyle;

    public ToggleButton() {
        enabledStyle = GUIHelper.createTextButtonStyle("toggleButtonEnabledUp", "toggleButtonEnabledDown", "toggleButtonEnabledOver");
        disabledStyle = GUIHelper.createTextButtonStyle("toggleButtonDisabledUp", "toggleButtonDisabledDown", "toggleButtonDisabledOver");
        init();
    }

    public ToggleButton(TextButtonStyle enabled, TextButtonStyle disabled) {
        this.enabledStyle = enabled;
        this.disabledStyle = disabled;
        init();
    }

    public void setText(String text) {
        textLabel.setText(text);
    }

    private void init() {
        setStyle(disabledStyle);
        textLabel = GUIHelper.createLabel("", 14, Color.BLACK);
        textLabel.setAlignment(Align.center);

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

    @Override
    public void act(float delta) {
        super.act(delta);
        textLabel.setPosition(getX(), getY());
        textLabel.setSize(getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        textLabel.draw(batch, parentAlpha);
    }

} // ToggleButton
