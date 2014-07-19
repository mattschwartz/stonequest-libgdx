/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Tab.java
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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.barelyconscious.stonequest.screens.menus.ingamemenu.Tooltip;
import com.barelyconscious.util.GUIHelper;

public class Tab extends Actor {

    private boolean selected;
    private Label tabLabel;
    private Widget content;
    private Tooltip tooltip;

    public Tab(String text, Widget content) {
        tabLabel = GUIHelper.createLabel(text);
        tabLabel.setAlignment(Align.center);
        this.content = content;
    }

    public void addToRoot(Window root) {
        root.addActor(tabLabel);

        if (tooltip != null) {
            root.addActor(tooltip);
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public final void toggle() {
        selected = !selected;
    }

    public Label getTabLabel() {
        return tabLabel;
    }

    public Widget getContent() {
        return content;
    }

    public void setContent(Widget content) {
        this.content = content;
    }

    public Tab setLabelBounds(float x, float y, float width, float height) {
        tabLabel.setBounds(x, y, width, height);

        return this;
    }

    public Tab setContentBounds(float x, float y, float width, float height) {
        content.setBounds(x, y, width, height);

        return this;
    }

    public Tab setTooltip(String text) {
        tooltip = new Tooltip(text, tabLabel);

        return this;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (selected) {
            float x = tabLabel.getX() - 1;
            float y = tabLabel.getY() - 9;
            float width = tabLabel.getWidth() + 2;
            float height = 13;

            GUIHelper.getPatch("GUI_element_tab_selector").draw(batch, x, y, width, height);
            tabLabel.getStyle().fontColor = Color.BLACK;
        } else {
            tabLabel.getStyle().fontColor = Color.DARK_GRAY;
        }

        tabLabel.draw(batch, parentAlpha);
    }

    @Override
    public boolean remove() {
        if (tooltip != null) {
            tooltip.remove();
        }

        if (content != null) {
            content.remove();
        }

        tabLabel.remove();

        return super.remove();
    }
}
