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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.barelyconscious.stonequest.journal.Entry;
import com.barelyconscious.stonequest.journal.Journal;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.GUIHelper;

public class JournalWindow extends InGameComponent {

    private int selectedEntryIndex;
    private Label entryTitle;
    private Label rewardsTitle;
    private TextArea entryDescription;
    private TextArea rewardsDescription;
    private List<String> entryList;
    private ScrollPane entryDescriptionScrollPane;
    private ScrollPane entryListScrollPane;

    public JournalWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "GUI_journal_window_background");
        selectedEntryIndex = 0;
    }

    @Override
    protected void createActors() {
        super.createActors();

        entryTitle = new Label("", GUIHelper.createLabelStyle(16, Color.BLACK));
        rewardsTitle = GUIHelper.createLabel("Rewards");
        entryDescription = GUIHelper.createTextArea(Color.BLACK, 14);
        rewardsDescription = GUIHelper.createTextArea(Color.BLACK, 14);
        entryList = GUIHelper.createList(null, 14);
        entryDescriptionScrollPane = new ScrollPane(entryDescription);
        entryListScrollPane = new ScrollPane(entryList);

        entryDescription.setTouchable(Touchable.disabled);
        rewardsDescription.setTouchable(Touchable.disabled);
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(entryTitle);
        window.addActor(rewardsTitle);
        window.addActor(entryDescriptionScrollPane);
        window.addActor(rewardsDescription);
        window.addActor(entryListScrollPane);

        GUIHelper.setPosition(window, 0, 1, 0,
                -Offset.JournalWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(closeWindowButton, 0, 0, 
                Offset.JournalWindow.CLOSE_WINDOW_BUTTON_OFFS_X, 
                Offset.JournalWindow.CLOSE_WINDOW_BUTTON_OFFS_Y);
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();

        entryList.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                selectedEntryIndex = entryList.getSelectedIndex();
                showSelectedEntry();
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        GUIHelper.setSize(window, 0, 0, Offset.JournalWindow.WINDOW_WIDTH,
                Offset.JournalWindow.WINDOW_HEIGHT);

        GUIHelper.setPosition(entryTitle, 0, 0,
                Offset.JournalWindow.ENTRY_TITLE_OFFS_X,
                Offset.JournalWindow.ENTRY_TITLE_OFFS_Y);

        GUIHelper.setPosition(rewardsTitle, 0, 0,
                Offset.JournalWindow.ENTRY_REWARDS_TITLE_OFFS_X,
                Offset.JournalWindow.ENTRY_REWARDS_TITLE_OFFS_Y);

        GUIHelper.setSize(entryDescriptionScrollPane, 0, 0,
                Offset.JournalWindow.ENTRY_DESCRIPTION_WIDTH,
                Offset.JournalWindow.ENTRY_DESCRIPTION_HEIGHT);
        GUIHelper.setPosition(entryDescriptionScrollPane, 0, 0,
                Offset.JournalWindow.ENTRY_DESCRIPTION_OFFS_X,
                Offset.JournalWindow.ENTRY_DESCRIPTION_OFFS_Y);

        GUIHelper.setSize(entryListScrollPane, 0, 0,
                Offset.JournalWindow.ENTRY_LISTBOX_WIDTH,
                Offset.JournalWindow.ENTRY_LISTBOX_HEIGHT);
        GUIHelper.setPosition(entryListScrollPane, 0, 0,
                Offset.JournalWindow.ENTRY_LISTBOX_OFFS_X,
                Offset.JournalWindow.ENTRY_LISTBOX_OFFS_Y);
    }

    @Override
    public void show() {
        super.show();
        
        titleBounds.width = 302;
        showEntryDetails();
        showSelectedEntry();
    }

    private void showEntryDetails() {
        Journal journal = GameWorld.getInstance().getPlayer().getJournal();

        Array entryListItems = new Array();
        for (Entry entry : journal.getEntries()) {
            entryListItems.add(entry.getTitle());
        }

        entryList.setItems(new String[]{});
        entryList.setItems(entryListItems);
    }

    private void showSelectedEntry() {
        Journal journal = GameWorld.getInstance().getPlayer().getJournal();
        Entry selectedEntry = journal.getEntry(selectedEntryIndex);

        if (selectedEntry != null) {
            entryTitle.setText(selectedEntry.getTitle());
            entryDescription.setText(selectedEntry.getDescription());
        } else {
            entryTitle.setText("No Active Quests");
            entryDescription.setText("No description.");
        }
    }
}
