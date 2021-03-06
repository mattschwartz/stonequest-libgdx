package com.barelyconscious.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.barelyconscious.stonequest.Game;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Game.GAME_TITLE + " " + Game.GAME_VERSION;
        config.useGL30 = true;
        config.width = 1600;
        config.height = 900;
        config.addIcon("app/applicationIcon.png", Files.FileType.Internal);
        config.addIcon("app/applicationIconSmall.png", Files.FileType.Internal);
        config.resizable = false;
        config.vSyncEnabled = true;
        config.foregroundFPS = 60;

        new LwjglApplication(new Game(), config);
    }
}
