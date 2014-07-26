/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         ContextMenu.java
 * Author:            Matt Schwartz
 * Date Created:      07.25.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.barelyconscious.util.GUIHelper;
import java.util.ArrayList;
import java.util.List;

public class ContextMenu extends Group {

    private Rectangle bounds;
    private NinePatch background;
    private final List<MenuItem> menuItems;

    public ContextMenu(List<MenuItem> menuItems, Actor anchor) {
        background = GUIHelper.getPatch("GUI_component_transparent_box");
        bounds = new Rectangle();
        this.menuItems = new ArrayList<>();
        this.menuItems.addAll(menuItems);

        addListeners(anchor);
        setVisible(false);
    }

    private void addListeners(Actor anchor) {
        float width = 0;
        float height = 0;

        anchor.addListener(new AnchorListener());
        addListener(new MenuListener());

        for (MenuItem menuItem : menuItems) {
            addActor(menuItem.option);
            height += menuItem.option.getHeight();
            width = Math.max(width, menuItem.option.getWidth());
            menuItem.option.addListener(new ItemListener());
        }

        setSize(width + 4, height);
        bounds.width = getWidth();
        bounds.height = getHeight();
    }

    private MenuItem getMenuItem(String labelName) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.option.getText().toString().equals(labelName)) {
                return menuItem;
            }
        }

        return null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        background.draw(batch, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }

    private class AnchorListener extends ClickListener {

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            return button == Buttons.RIGHT;
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            int i = 1;

            for (MenuItem menuItem : menuItems) {
                menuItem.option.setPosition(2, getHeight() - i * (menuItem.option.getHeight()));
                i++;
            }

            setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY() - getHeight());
            bounds.x = getX();
            bounds.y = getY();
            setZIndex(Integer.MAX_VALUE);
            setVisible(true);
        }

    }

    private class MenuListener extends InputListener {

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            if (!bounds.contains(event.getStageX(), event.getStageY())) {
                setVisible(false);
            }
        }
    }

    private class ItemListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y) {
            Action action = getMenuItem(((Label) event.getListenerActor()).getText().toString()).action;
            setVisible(false);
        }

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            ((Label) event.getListenerActor()).setColor(Color.YELLOW);
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            ((Label) event.getListenerActor()).setColor(Color.WHITE);
        }

    }

} // ContextMenu
