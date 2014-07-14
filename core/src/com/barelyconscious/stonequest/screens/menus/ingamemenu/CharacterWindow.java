/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         CharacterWindow.java
 * Author:            Matt Schwartz
 * Date Created:      06.03.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.gui.TabbedPane;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.ColorHelper;
import com.barelyconscious.util.GUIHelper;

public class CharacterWindow extends InGameComponent {

    private Label playerNameLabel;
    private JustifiedTextArea attributesTextArea;
    private JustifiedTextArea reputationTextArea;
    private JustifiedTextArea miscTextArea;
    private TabbedPane tabbedPane;

    public CharacterWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "GUI_character_window_background");
    }

    @Override
    protected void createActors() {
        super.createActors();

        playerNameLabel = new Label("cur_player_name", GUIHelper.createLabelStyle());
        attributesTextArea = new JustifiedTextArea(14, Color.BLACK, ColorHelper.FOREST_GREEN);
        reputationTextArea = new JustifiedTextArea(14, Color.BLACK, ColorHelper.FOREST_GREEN);
        miscTextArea = new JustifiedTextArea(14, Color.BLACK, ColorHelper.FOREST_GREEN);
        tabbedPane = new TabbedPane();

        playerNameLabel.setAlignment(Align.center);
        tabbedPane.addTab("Attributes", attributesTextArea)
                .setLabelBounds(Offset.CharacterWindow.ATTRIBUTES_LABEL_OFFS_X, 
                        Offset.CharacterWindow.ATTRIBUTES_LABEL_OFFS_Y, 
                        Offset.CharacterWindow.ATTRIBUTES_LABEL_WIDTH, 
                        Offset.CharacterWindow.ATTRIBUTES_LABEL_HEIGHT)
                .setContentBounds(Offset.CharacterWindow.TAB_CONTENT_OFFS_X, 
                        Offset.CharacterWindow.TAB_CONTENT_OFFS_Y,
                        Offset.CharacterWindow.TAB_CONTENT_WIDTH,
                        Offset.CharacterWindow.TAB_CONTENT_HEIGHT);
        tabbedPane.addTab("Reputation", reputationTextArea)
                .setLabelBounds(Offset.CharacterWindow.REPUTATION_LABEL_OFFS_X, 
                        Offset.CharacterWindow.REPUTATION_LABEL_OFFS_Y, 
                        Offset.CharacterWindow.REPUTATION_LABEL_WIDTH, 
                        Offset.CharacterWindow.REPUTATION_LABEL_HEIGHT)
                .setContentBounds(Offset.CharacterWindow.TAB_CONTENT_OFFS_X, 
                        Offset.CharacterWindow.TAB_CONTENT_OFFS_Y,
                        Offset.CharacterWindow.TAB_CONTENT_WIDTH,
                        Offset.CharacterWindow.TAB_CONTENT_HEIGHT);
        tabbedPane.addTab("Misc.", miscTextArea)
                .setLabelBounds(Offset.CharacterWindow.MISC_LABEL_OFFS_X, 
                        Offset.CharacterWindow.MISC_LABEL_OFFS_Y, 
                        Offset.CharacterWindow.MISC_LABEL_WIDTH, 
                        Offset.CharacterWindow.MISC_LABEL_HEIGHT)
                .setContentBounds(Offset.CharacterWindow.TAB_CONTENT_OFFS_X, 
                        Offset.CharacterWindow.TAB_CONTENT_OFFS_Y,
                        Offset.CharacterWindow.TAB_CONTENT_WIDTH,
                        Offset.CharacterWindow.TAB_CONTENT_HEIGHT);
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(playerNameLabel);
        tabbedPane.addToRoot(window);
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();
    }

    @Override
    public void show() {
        super.show();
        Player player = GameWorld.getInstance().getPlayer();
        playerNameLabel.setText(player.getName() + ", a level " + player.getLevel() + " " + player.getProfession());

        setAttributesText(player);
        setReputationText(player);
        setMiscText(player);
        adjustActors();
    }

    private void setAttributesText(Player player) {
        attributesTextArea.clearText();

        attributesTextArea.addLine("Physical damage dealt", "1-999");
        attributesTextArea.addLine("Critical strike chance", "100.99%");
        attributesTextArea.addLine("Armor value", "9,999");
        attributesTextArea.addLine("Physical damage reduction", "100.99%");
        attributesTextArea.addLine("Evasion value", "9,999");
        attributesTextArea.addLine("Chance to evade", "100.99%");
    }

    private void setReputationText(Player player) {
        reputationTextArea.clearText();

        reputationTextArea.addLine("Deity of Hate", "999 / 1000");
        reputationTextArea.addLine("Deity of Fortune", "999 / 1000");
    }

    private void setMiscText(Player player) {
        miscTextArea.clearText();
    }

    private void adjustActors() {
        window.setSize(Offset.CharacterWindow.WINDOW_WIDTH, Offset.CharacterWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1,
                -Offset.CharacterWindow.WINDOW_WIDTH,
                -Offset.CharacterWindow.WINDOW_HEIGHT);

        GUIHelper.setSize(playerNameLabel, 0, 0,
                Offset.CharacterWindow.PLAYER_NAME_LABEL_WIDTH,
                Offset.CharacterWindow.PLAYER_NAME_LABEL_HEIGHT);
        GUIHelper.setPosition(playerNameLabel, 0, 0,
                Offset.CharacterWindow.PLAYER_NAME_LABEL_OFFS_X,
                Offset.CharacterWindow.PLAYER_NAME_LABEL_OFFS_Y);

        GUIHelper.setSize(tabbedPane, 0, 0,
                Offset.CharacterWindow.TEXT_AREA_WIDTH,
                Offset.CharacterWindow.TEXT_AREA_HEIGHT);
        GUIHelper.setPosition(tabbedPane, 0, 0,
                Offset.CharacterWindow.TEXT_AREA_OFFS_X,
                Offset.CharacterWindow.TEXT_AREA_OFFS_Y);
    }
} // CharacterWindow
