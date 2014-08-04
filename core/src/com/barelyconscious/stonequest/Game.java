package com.barelyconscious.stonequest;

import com.barelyconscious.stonequest.screens.LoadingScreen;
import com.barelyconscious.stonequest.screens.mapcreatorscreen.MapCreatorScreen;
import com.barelyconscious.stonequest.screens.menus.MainMenuScreen;
import com.barelyconscious.stonequest.screens.SplashScreen;
import com.barelyconscious.stonequest.screens.WorldScreen;
import com.barelyconscious.stonequest.screens.menus.NewPlayerMenuScreen;
import com.barelyconscious.stonequest.screens.menus.PlayMenuScreen;

public class Game extends com.badlogic.gdx.Game {

    public static final String GAME_TITLE = "StoneQuest";
    public static final String GAME_VERSION = "Version 0.1.0_alpha";

    public SplashScreen splashScreen;
    public MainMenuScreen mainMenuScreen;
    public PlayMenuScreen playMenuScreen;
    public NewPlayerMenuScreen newPlayerMenuScreen;
    public LoadingScreen loadingScreen;
    public WorldScreen worldScreen;
    public MapCreatorScreen mapCreatorScreen;

    @Override
    public void create() {
        splashScreen = new SplashScreen(this);
        mainMenuScreen = new MainMenuScreen(this);
        playMenuScreen = new PlayMenuScreen(this);
        newPlayerMenuScreen = new NewPlayerMenuScreen(this);
        loadingScreen = new LoadingScreen(this);
        worldScreen = new WorldScreen(this);
        mapCreatorScreen = new MapCreatorScreen(this);

        setScreen(splashScreen);
    }

    @Override
    public void render() {
        super.render();
    }

}
