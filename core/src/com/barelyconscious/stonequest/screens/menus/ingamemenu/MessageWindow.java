/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         MessageWindow.java
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
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.barelyconscious.stonequest.console.Channel;
import com.barelyconscious.util.GUIHelper;
import java.util.ArrayList;
import java.util.List;

public class MessageWindow extends Actor {

    private TextArea textArea;
    private List<Channel> channels;

    public MessageWindow() {
        channels = new ArrayList<>();
        textArea = GUIHelper.createTextArea(Color.WHITE, 14);
        textArea.getStyle().background = GUIHelper.getDrawable("GUI_component_transparent_box");
        textArea.setTouchable(Touchable.disabled);
    }
    
    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void setPosition(float x, float y) {
        textArea.setPosition(x, y);
    }

    @Override
    public void setSize(float width, float height) {
        textArea.setSize(width, height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        StringBuilder text = new StringBuilder();
        
        for (Channel channel : channels) {
            for (String line : channel.getLines()) {
                text.append(line).append("\n");
            }
        }
        
        textArea.setText(text.toString());
        textArea.moveCursorLine(Integer.MAX_VALUE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        textArea.draw(batch, parentAlpha);
    }
}
