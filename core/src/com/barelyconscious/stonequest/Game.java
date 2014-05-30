package com.barelyconscious.stonequest;

import com.barelyconscious.stonequest.screens.MainMenuScreen;
import com.barelyconscious.stonequest.screens.SplashScreen;
import com.barelyconscious.stonequest.screens.WorldScreen;
import com.barelyconscious.util.GUIHelper;

public class Game extends com.badlogic.gdx.Game {

    public SplashScreen splashScreen;
    public MainMenuScreen mainMenuScreen;
    public WorldScreen worldScreen;

    @Override
    public void create() {
        splashScreen = new SplashScreen(this);
        mainMenuScreen = new MainMenuScreen(this);
        worldScreen = new WorldScreen(this);
        setScreen(splashScreen);
        
        GUIHelper.getInstance().init();
    }

    @Override
    public void render() {
        super.render();
    }

}
