/* *****************************************************************************
 * Project:           StoneQuest
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

import com.barelyconscious.stonequest.screens.menus.ingamemenu.InGameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.barelyconscious.stonequest.Game;
import com.barelyconscious.stonequest.gameobjects.LightManager;
import com.barelyconscious.stonequest.gameobjects.LootObject;
import com.barelyconscious.stonequest.gameobjects.ObjectManager;
import com.barelyconscious.stonequest.input.WorldInputController;
import com.barelyconscious.stonequest.items.Item;
import com.barelyconscious.stonequest.world.GameWorld;

public class WorldScreen extends GameScreen {

    private boolean loading;
    private boolean paused;
    private InGameMenu menu;
    private InputMultiplexer inputMultiplexer;
    
    public WorldScreen(Game game) {
        super(game);
    }
    
    @Override
    public void resize(int width, int height) {
        menu.resize(width, height);
    }
    
    @Override
    public void render(float delta) {
        if (paused) {
            return;
        }
        GameWorld.getInstance().render(delta);
        menu.actAndDraw(delta);
    }
    
    public boolean stillLoading() {
        return loading;
    }
    
    public void loadAssets() {
        paused = true;
        loading = true;
        
        inputMultiplexer = new InputMultiplexer(Gdx.input.getInputProcessor());
        menu = new InGameMenu();
        Gdx.input.setInputProcessor(inputMultiplexer);
        inputMultiplexer.addProcessor(new WorldInputController());
        menu.load();
        
        loading = false;
    }
    
    @Override
    public void show() {
        menu.show(inputMultiplexer);
        
        GameWorld.getInstance().init(menu.getSpriteBatch(), inputMultiplexer);
        GameWorld.getInstance().spawnPlayer();
        
        paused = false;
        // Debug
        ObjectManager.getInstance().spawnObject(new LootObject(new Item("Potion of Healing")), 50, 50);
    }

    @Override
    public void dispose() {
        ObjectManager.getInstance().dispose();
        LightManager.getInstance().dispose();
        menu.dispose();
    }
    
} // WorldScreen
