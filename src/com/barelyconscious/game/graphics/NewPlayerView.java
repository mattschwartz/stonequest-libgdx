/* *****************************************************************************
   * Project:           StoneQuest
   * File Name:         NewPlayerView.java
   * Author:            Matt Schwartz
   * Date Created:      05.09.2014 
   * Redistribution:    You are free to use, reuse, and edit any of the text in
   *                    this file.  You are not allowed to take credit for code
   *                    that was not written fully by yourself, or to remove 
   *                    credit from code that was not written fully by yourself.  
   *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
   * File Description:  
   ************************************************************************** */

package com.barelyconscious.game.graphics;

import com.barelyconscious.game.graphics.gui.BetterButton;
import com.barelyconscious.game.graphics.gui.ButtonCallback;
import com.barelyconscious.game.graphics.gui.Label;
import com.barelyconscious.game.services.SceneService;

public class NewPlayerView extends View {
    
    private Label playerNameLabel;
    private BetterButton backButton;
    private BetterButton startGameButton;
    
    public NewPlayerView() {
        createWidgets();
        setComponentsEnabled(false);
    }
    
    private void createWidgets() {
        ButtonCallback backEvent;
        ButtonCallback startGameEvent;
        
        backEvent = new ButtonCallback() {

            @Override
            public void action(BetterButton buttonPressed) {
                backButtonPressed();
            }

            @Override
            public void hoverOverAction(BetterButton caller) {
            }
        };
        startGameEvent = new ButtonCallback() {

            @Override
            public void action(BetterButton buttonPressed) {
                startButtonPressed();
            }

            @Override
            public void hoverOverAction(BetterButton caller) {
            }
        };
        
        playerNameLabel = new Label("Player name:");
        backButton = new BetterButton(backEvent, "Back");
        startGameButton = new BetterButton(startGameEvent, "Start Game");
        
        addComponent(playerNameLabel);
        addComponent(backButton);
        addComponent(startGameButton);
    } // createWidgets

    @Override
    public void showView() {
        SceneService.INSTANCE.setView(this);
        resize(SceneService.INSTANCE.getWidth(), SceneService.INSTANCE.getHeight());
        setComponentsEnabled(true);
    } // showView

    @Override
    public void resize(int newWidth, int newHeight) {
        super.resize(newWidth, newHeight);
        
        playerNameLabel.setSize(0.0f, 300.0f, 0.0f, 25.0f);
        playerNameLabel.setPosition(0.5f, -300.0f, 0.5f, -25.0f);
        
        backButton.setSize(0.0f, 150.0f, 0.0f, 25.0f);
        backButton.setPosition(0.5f, -150.0f, 0.5f, 0.0f);
        
        startGameButton.setSize(0.0f, 150.0f, 0.0f, 25.0f);
        startGameButton.setPosition(0.5f, 0.0f, 0.5f, 0.0f);
    }
    
    private void backButtonPressed() {
    } // backButtonPressed
    
    private void startButtonPressed() {
    } // startButtonPressed
} // NewPlayerView
