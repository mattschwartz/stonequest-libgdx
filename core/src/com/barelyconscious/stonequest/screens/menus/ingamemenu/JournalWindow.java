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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.util.GUIHelper;
import java.util.List;

public class JournalWindow extends InGameComponent {

    private Label questTitle;
    private TextArea detailsTextArea;
    private ScrollPane scrollPane;
    private List<ToggleButton> questBusttons;
    
    private ToggleButton testButton;

    public JournalWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "journalBackground");
    }

    @Override
    protected void createActors() {
        super.createActors();

        questTitle = GUIHelper.createLabel("quest title", 16, Color.LIGHT_GRAY);
        detailsTextArea = GUIHelper.createTextArea(Color.LIGHT_GRAY, 14);
        scrollPane = new ScrollPane(detailsTextArea);
        testButton = new ToggleButton();

        questTitle.setAlignment(Align.center);
        detailsTextArea.setTouchable(Touchable.disabled);
        detailsTextArea.setText("the quick brown fox jumps over the lazy red dog the quick brown fox jumps over the lazy red dog the quick");
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(questTitle);
        window.addActor(scrollPane);
        window.addActor(testButton);
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();
    }

    @Override
    public void show() {
        super.show();

        window.setSize(Offset.JournalWindow.WINDOW_WIDTH, Offset.JournalWindow.WINDOW_HEIGHT);
        GUIHelper.setSize(questTitle, 0, 0, Offset.JournalWindow.QUEST_TITLE_LABEL_WIDTH, Offset.JournalWindow.QUEST_TITLE_LABEL_HEIGHT);
        GUIHelper.setSize(scrollPane, 0, 0, Offset.JournalWindow.DETAILS_WIDTH, Offset.JournalWindow.DETAILS_HEIGHT);

        GUIHelper.setPosition(window, 0, 0, 0, Offset.JournalWindow.WINDOW_OFFS_Y);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_X, Offset.UpgradeItemWindow.CLOSEBUTTON_OFFS_Y);
        GUIHelper.setPosition(questTitle, 0, 0, Offset.JournalWindow.QUEST_TITLE_LABEL_OFFS_X, Offset.JournalWindow.QUEST_TITLE_LABEL_OFFS_Y);
        GUIHelper.setPosition(scrollPane, 0, 0, Offset.JournalWindow.DETAILS_OFFS_X, Offset.JournalWindow.DETAILS_OFFS_Y);
    }

}
