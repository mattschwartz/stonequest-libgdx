package com.barelyconscious.stonequest;

import com.barelyconscious.stonequest.screens.menus.MainMenuScreen;
import com.barelyconscious.stonequest.screens.SplashScreen;
import com.barelyconscious.stonequest.screens.WorldScreen;
import com.barelyconscious.stonequest.screens.menus.PlayMenuScreen;
import com.barelyconscious.util.GUIHelper;

public class Game extends com.badlogic.gdx.Game {

    public static final String GAME_TITLE = "StoneQuest";
    public static final String GAME_VERSION = "Version 0.1.0alpha";

    public SplashScreen splashScreen;
    public MainMenuScreen mainMenuScreen;
    public WorldScreen worldScreen;
    public PlayMenuScreen playMenuScreen;

    @Override
    public void create() {
        splashScreen = new SplashScreen(this);
        mainMenuScreen = new MainMenuScreen(this);
        playMenuScreen = new PlayMenuScreen(this);
        worldScreen = new WorldScreen(this);
        setScreen(splashScreen);

        GUIHelper.getInstance().init();
    }

    @Override
    public void render() {
        super.render();
    }

}
