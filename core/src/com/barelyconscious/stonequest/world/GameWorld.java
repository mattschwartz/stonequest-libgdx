/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         World.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.gameobjects.LightManager;
import com.barelyconscious.stonequest.gameobjects.ObjectManager;
import com.barelyconscious.stonequest.gameobjects.PlayerObject;

public class GameWorld {

    private static final GameWorld INSTANCE = new GameWorld();

    private World boxWorld;
    private OrthographicCamera camera;
    private Batch batch;
    private Player player;
    private PlayerObject playerObject;
    private Zone zone;

    private GameWorld() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public static GameWorld getInstance() {
        return INSTANCE;
    }

    public void init(Batch batch, InputMultiplexer inputMultiplexer) {
        this.batch = batch;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        boxWorld = new com.badlogic.gdx.physics.box2d.World(new Vector2(0, 0), true);
        zone = new Zone("maps/introductionMap.tmx", boxWorld);

        ObjectManager.getInstance().init(boxWorld, inputMultiplexer);
        LightManager.getInstance().init(boxWorld);
    }

    public Vector2 getWorldCoords(float mouseX, float mouseY) {
        Vector3 result = new Vector3(mouseX, mouseY, 0);
        result = camera.unproject(result);
        return new Vector2(result.x, result.y);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void spawnPlayer() {
        playerObject = new PlayerObject(player);
        ObjectManager.getInstance().spawnObject(playerObject);
    }

    public Player getPlayer() {
        return player;
    }
    
    public Rectangle getPlayerBoundingBox() {
        return playerObject.getBoundingBox();
    }

    public boolean canMove(Rectangle boundingBox) {
        return zone.canMove(boundingBox);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.position.set(playerObject.getPosition(), 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        zone.render(camera);

        ObjectManager.getInstance().updateAndRender(batch, delta);
        LightManager.getInstance().updateAndRender(camera);

        boxWorld.step(1 / 60f, 6, 2);
    }

} // World
