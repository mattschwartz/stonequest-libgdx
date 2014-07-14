/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         TabbedPane.java
 * Author:            Matt Schwartz
 * Date Created:      07.13.2014
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.ArrayList;
import java.util.List;

public class TabbedPane extends Actor {

    private List<Tab> tabs;

    public TabbedPane() {
        tabs = new ArrayList<>();
    }

    public Tab addTab(String text, Widget tabContent) {
        final Tab tab = new Tab(text, tabContent);

        tab.getTabLabel().addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                for (Tab tab1 : tabs) {
                    tab1.setSelected(false);
                }

                tab.setSelected(true);
            }

        });

        tabs.add(tab);
        tabs.get(0).setSelected(true);

        return tab;
    }

    public void addToRoot(Window root) {
        root.add(this);

        for (Tab tab : tabs) {
            root.addActor(tab.getTabLabel());
        }
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);

        for (Tab tab : tabs) {
            tab.setSize(width, height);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Tab tab : tabs) {
            tab.draw(batch, parentAlpha);

            if (tab.isSelected()) {
                Widget content = tab.getContent();

                content.draw(batch, parentAlpha);
            }
        }
    }
}
