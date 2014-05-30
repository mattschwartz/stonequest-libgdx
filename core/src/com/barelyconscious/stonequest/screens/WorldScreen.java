/* *****************************************************************************
 * Project:           core
 * File Name:         WorldScreen.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens;

import com.barelyconscious.stonequest.screens.menus.InGameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.gameobjects.LightManager;
import com.barelyconscious.stonequest.gameobjects.LootObject;
import com.barelyconscious.stonequest.gameobjects.ObjectManager;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.stonequest.world.GameWorld;

public class WorldScreen extends GameScreen {

    private InGameMenu menu;
    private InputMultiplexer inputMultiplexer;
    
    public WorldScreen(Game game) {
        super(game);
    }
    
    @Override
    public void resize(int width, int height) {
        menu.resize(width, height);
    }

    boolean pressed = false;

    @Override
    public void render(float delta) {
        GameWorld.getInstance().render(delta);
        menu.actAndDraw(delta);

        // debugging
        if (!Gdx.input.isButtonPressed(0)) {
            pressed = false;
        }

        if (!pressed && Gdx.input.isButtonPressed(0)) {
            pressed = true;
            Color color;
            Vector2 mouseCoords = GameWorld.getInstance().getWorldCoords(Gdx.input.getX(), Gdx.input.getY());

            int ran = MathUtils.random(7);
            switch (ran) {
                case 0:
                    color = Color.BLUE;
                    break;
                case 1:
                    color = Color.CYAN;
                    break;
                case 2:
                    color = Color.GREEN;
                    break;
                case 3:
                    color = Color.MAGENTA;
                    break;
                case 4:
                    color = Color.ORANGE;
                    break;
                case 5:
                    color = Color.PINK;
                    break;
                case 6:
                    color = Color.RED;
                    break;
                default:
                    color = Color.YELLOW;
            }

            LightManager.getInstance().addPointLight(color, 350, mouseCoords.x, mouseCoords.y);
        }
    }
    
    @Override
    public void show() {
        inputMultiplexer = new InputMultiplexer(Gdx.input.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
        menu = new InGameMenu();
        menu.show(inputMultiplexer);
        
        GameWorld.getInstance().init(menu.getSpriteBatch(), inputMultiplexer);
        GameWorld.getInstance().spawnPlayer(new Player("awdaw"));
        ObjectManager.getInstance().spawnObject(new LootObject(new Item("")), 50, 50);
    }

    @Override
    public void dispose() {
        ObjectManager.getInstance().dispose();
        LightManager.getInstance().dispose();
        menu.dispose();
    }

} // WorldScreen
