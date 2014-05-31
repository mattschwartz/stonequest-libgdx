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
        config.width = 1280;
        config.height = 720;
        config.addIcon("app/applicationIcon.png", Files.FileType.Internal);
        config.addIcon("app/applicationIconSmall.png", Files.FileType.Internal);
        config.resizable = false;
        config.vSyncEnabled = true;

        new LwjglApplication(new Game(), config);
    }
}
