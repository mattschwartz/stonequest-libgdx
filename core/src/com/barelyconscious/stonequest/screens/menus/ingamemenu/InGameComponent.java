/* *****************************************************************************
 * Project:           StoneQuest
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

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;

public abstract class InGameComponent {

    private String imageBackground;
    protected InGameMenu inGameMenu;
    protected Window window;
    protected ImageButton closeWindowButton;

    public InGameComponent(InGameMenu inGameMenu, String background) {
        imageBackground = background;
        this.inGameMenu = inGameMenu;
    }

    public final void create() {
        createActors();
        createRootWindow();
        registerEvents();
        hide();
    }

    protected void createActors() {
        closeWindowButton = new ImageButton(GUIHelper.createImageButtonStyle("GUI_window_close_button", "GUI_window_close_button", "GUI_window_close_button"));
    }

    protected void createRootWindow() {
        Window.WindowStyle style = new Window.WindowStyle();
        style.background = GUIHelper.getDrawable(imageBackground);
        style.titleFont = FontFactory.getDefaultFont();

        window = new Window("", style);
        window.addActor(closeWindowButton);
        window.setZIndex(1);
    }

    protected void registerEvents() {
        closeWindowButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                hide();
            }

        });
    }

    public Window getWindow() {
        return window;
    }
    
    public void resize(int width, int height) {
    }

    public void show() {
        window.setVisible(true);
        window.setTouchable(Touchable.enabled);
    }

    public void hide() {
        window.setVisible(false);
        window.setTouchable(Touchable.disabled);
    }

    public void dispose() {
        window.clear();
        window.remove();
    }

    public final boolean toggle() {
        if (!window.isVisible()) {
            show();
        } else {
            hide();
        }
        
        return window.isVisible();
    }
} // InGameMenuComponent
