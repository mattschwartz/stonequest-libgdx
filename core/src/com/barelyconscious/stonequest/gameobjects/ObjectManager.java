/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         ObjectManager.java
 * Author:            Matt Schwartz
 * Date Created:      05.26.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gameobjects;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectManager {

    private static final ObjectManager INSTANCE = new ObjectManager();

    private World world;
    private List<GameObject> gameObjects = new CopyOnWriteArrayList<>();
    private InputMultiplexer inputMultiplexer;

    private ObjectManager() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public void init(World world, InputMultiplexer inputMultiplexer) {
        this.world = world;
        this.inputMultiplexer = inputMultiplexer;
    }

    public void resize(int width, int height) {
    }

    public static ObjectManager getInstance() {
        return INSTANCE;
    }

    public void spawnObject(GameObject object) {
        spawnObject(object, object.x, object.y);
    }

    public void spawnObject(GameObject object, float x, float y) {
        object.spawnObject(world, x, y);
        gameObjects.add(object);
        inputMultiplexer.addProcessor(object);
    }

    public void updateAndRender(Batch batch, float delta) {
        batch.begin();

        for (GameObject object : gameObjects) {
            if (object.shouldRemove()) {
                object.remove();
                inputMultiplexer.removeProcessor(object);
                gameObjects.remove(object);
            } else {
                object.draw(batch);
                object.update(delta);
            }
        }

        batch.end();
    }

    public void dispose() {
        gameObjects.clear();
        world.dispose();
    }
}
