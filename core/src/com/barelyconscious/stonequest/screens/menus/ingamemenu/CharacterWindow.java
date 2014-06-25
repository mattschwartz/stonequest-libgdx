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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.entities.Entity.Attribute;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.world.GameWorld;
import com.barelyconscious.util.ColorHelper;
import com.barelyconscious.util.GUIHelper;
import java.util.HashMap;
import java.util.Map;

public class CharacterWindow extends InGameComponent {

    private Label playerNameLabel;
    private Label subtitleLabel;
    private TextArea attributesInfoTextArea;
    private JustifiedTextArea detailsTextArea;
    private ScrollPane scrollPane;
    private Map<Attribute, Label> statsLabels;

    public CharacterWindow(InGameMenu inGameMenu) {
        super(inGameMenu, "characterBackground");
        statsLabels = new HashMap<>();
    }

    @Override
    protected void createActors() {
        super.createActors();

        playerNameLabel = new Label("player's name", GUIHelper.createLabelStyle());
        subtitleLabel = new Label("Details", GUIHelper.createLabelStyle());
        detailsTextArea = new JustifiedTextArea(14, Color.LIGHT_GRAY, ColorHelper.SUMMER_GREEN);
        scrollPane = new ScrollPane(detailsTextArea);
        attributesInfoTextArea = GUIHelper.createTextArea(Color.LIGHT_GRAY, 14);

        detailsTextArea.setCenterLines(true);
        detailsTextArea.addLine("melee damage", "999.9-999.9");
        detailsTextArea.addLine("magic damage", "999.9-999.9");
        detailsTextArea.addLine("crit chance", "100.99%");
        detailsTextArea.addLine("armor", "100.99%");
        detailsTextArea.addLine("evasion", "100.99%");
        detailsTextArea.addLine("fire magic bonus", "100.99%");
        detailsTextArea.addLine("frost magic bonus", "100.99%");
        detailsTextArea.addLine("holy magic bonus", "100.99%");
        detailsTextArea.addLine("chaos magic bonus", "100.99%");

        playerNameLabel.setAlignment(Align.center);
        subtitleLabel.setAlignment(Align.center);

        for (int i = 0; i < Attribute.NUM_ATTRIBUTES; i++) {
            final Label label = new Label("", GUIHelper.createLabelStyle());
            label.setAlignment(Align.center);
            label.setColor(Color.LIGHT_GRAY);
            
            label.addListener(new InputListener() {

                @Override
                public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                    label.setColor(Color.WHITE);
                }

                @Override
                public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                    label.setColor(Color.LIGHT_GRAY);
                }

            });
            statsLabels.put(Attribute.toAttribute(i), label);
        }
    }

    @Override
    protected void createRootWindow() {
        super.createRootWindow();

        window.addActor(playerNameLabel);
        window.addActor(subtitleLabel);
        window.addActor(scrollPane);

        for (Label label : statsLabels.values()) {
            window.addActor(label);
        }
    }

    @Override
    protected void registerEvents() {
        super.registerEvents();

        window.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                Actor hit = window.hit(x, y, false);

                subtitleLabel.setText("Details");
                scrollPane.setWidget(detailsTextArea);

                for (Attribute attr : statsLabels.keySet()) {
                    if (hit == statsLabels.get(attr)) {
                        subtitleLabel.setText(attr.toString());
                        attributesInfoTextArea.setText(Attribute.getDescription(attr));
                        scrollPane.setWidget(attributesInfoTextArea);
                    }
                }

                return super.mouseMoved(event, x, y);
            }

        });
    }

    @Override
    public void show() {
        super.show();

        setLocations();
        setPlayerAttributes();
    }

    private void setPlayerAttributes() {
        Player player = GameWorld.getInstance().getPlayer();
        playerNameLabel.setText(player.getName());

        Attribute attr;
        for (int i = 0; i < Attribute.NUM_ATTRIBUTES; i++) {
            attr = Attribute.toAttribute(i);
            statsLabels.get(attr).setText("" + Math.round(player.getAttribute(attr)));
        }
    }

    private void setLocations() {
        int i = 0;
        float statsOffsX = Offset.CharacterWindow.STATS_OFFS_X;
        float statsOffsY;

        for (int c = 0; c < 2; c++) {
            statsOffsY = Offset.CharacterWindow.STATS_OFFS_Y;

            for (int r = 0; r < 5; r++) {
                Label label = statsLabels.get(Attribute.toAttribute(i++));
                GUIHelper.setSize(label, 0, 0, Offset.CharacterWindow.STATS_WIDTH, Offset.CharacterWindow.STATS_HEIGHT);
                GUIHelper.setPosition(label, 0, 0, statsOffsX, statsOffsY);

                statsOffsY -= Offset.CharacterWindow.STATS_STEP_Y;
            }
            statsOffsX += Offset.CharacterWindow.STATS_STEP_X;
        }

        window.setSize(Offset.CharacterWindow.WINDOW_WIDTH, Offset.CharacterWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(window, 1, 1, -Offset.CharacterWindow.WINDOW_WIDTH, -Offset.CharacterWindow.WINDOW_HEIGHT);
        GUIHelper.setPosition(closeWindowButton, 0, 0, Offset.CharacterWindow.CLOSEBUTTON_OFFS_X, Offset.CharacterWindow.CLOSEBUTTON_OFFS_Y);

        GUIHelper.setSize(playerNameLabel, 0, 0, Offset.CharacterWindow.PLAYER_NAME_LABEL_WIDTH, Offset.CharacterWindow.PLAYER_NAME_LABEL_HEIGHT);
        GUIHelper.setPosition(playerNameLabel, 0, 0, Offset.CharacterWindow.PLAYER_NAME_LABEL_OFFS_X, Offset.CharacterWindow.PLAYER_NAME_LABEL_OFFS_Y);

        GUIHelper.setSize(subtitleLabel, 0, 0, Offset.CharacterWindow.SUBTITLE_LABEL_WIDTH, Offset.CharacterWindow.SUBTITLE_LABEL_HEIGHT);
        GUIHelper.setPosition(subtitleLabel, 0, 0, Offset.CharacterWindow.SUBTITLE_LABEL_OFFS_X, Offset.CharacterWindow.SUBTITLE_LABEL_OFFS_Y);

        GUIHelper.setSize(scrollPane, 0, 0, Offset.CharacterWindow.DETAILS_TEXTAREA_WIDTH, Offset.CharacterWindow.DETAILS_TEXTAREA_HEIGHT);
        GUIHelper.setPosition(scrollPane, 0, 0, Offset.CharacterWindow.DETAILS_TEXTAREA_OFFS_X, Offset.CharacterWindow.DETAILS_TEXTAREA_OFFS_Y);
    }

} // CharacterWindow
