/* *****************************************************************************
 * Project:           core
 * File Name:         Console.java
 * Author:            Matt Schwartz
 * Date Created:      06.04.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.util.FontFactory;
import com.barelyconscious.util.GUIHelper;

public class Console {

    private static final Console INSTANCE = new Console();

    private String log = "";
    private TextArea consoleLog;

    private Console() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public static Console getInstance() {
        return INSTANCE;
    }

    public void create(Stage root) {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.background = GUIHelper.getDrawable("infoLogBackground");
        style.font = FontFactory.createDefaultFont(14);
        style.fontColor = Color.LIGHT_GRAY;
        consoleLog = new TextArea("", style);
        consoleLog.setTouchable(Touchable.disabled);

        root.addActor(consoleLog);
    }
    
    public void resize(int width, int height) {
        GUIHelper.setPosition(consoleLog, 0, 0, 320 - 26, -1);
        consoleLog.setWidth(width - 363 - 320 + 30);
        consoleLog.setHeight(112 + 2);
    }
    
    public void write(String string) {
        log += string;
        consoleLog.setText(log);
    }
    
    public void writeLine(String string) {
        log += string + "\n";
        consoleLog.setText(log);
    }
}
