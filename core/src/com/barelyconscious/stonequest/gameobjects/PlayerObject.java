/* *****************************************************************************
 * Project:           core
 * File Name:         PlayerObject.java
 * Author:            Matt Schwartz
 * Date Created:      05.24.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gameobjects;

import box2dLight.Light;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.barelyconscious.stonequest.entities.player.Player;
import com.barelyconscious.stonequest.world.GameWorld;

public class PlayerObject extends EntityObject {

    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

    private float speed;

    public PlayerObject(Player player) {
        super("sprites/player.png", player);
        speed = 175;
    }

    @Override
    public void spawnObject(World world, float x, float y) {
        super.spawnObject(world, x, y);
        Light light = LightManager.getInstance().addPointLight(new Color(1, 1, 1, 0.5f), 500, x, y);
        light.attachToBody(spriteBody, 0, 0);
    }

    @Override
    public void update(float delta) {
        boolean moved = false;
        Vector2 oldpos = getPosition();
        Vector2 newpos = getPosition();

        if (moveLeft) {
            moved = true;
            newpos.x -= speed * delta;
        }
        if (moveRight) {
            moved = true;
            newpos.x += speed * delta;
        }
        if (moveUp) {
            moved = true;
            newpos.y += speed * delta;
        }
        if (moveDown) {
            moved = true;
            newpos.y -= speed * delta;
        }

        if (!moved) {
            return;
        }

        setX(newpos.x);
        if (!GameWorld.getInstance().canMove(getBoundingBox())) {
            setX(oldpos.x);
        }

        setY(newpos.y);
        if (!GameWorld.getInstance().canMove(getBoundingBox())) {
            setY(oldpos.y);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return sprite.getBoundingRectangle().contains(GameWorld.getInstance().getWorldCoords(screenX, screenY));
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                moveUp = true;
                break;
            case Keys.A:
                moveLeft = true;
                break;
            case Keys.S:
                moveDown = true;
                break;
            case Keys.D:
                moveRight = true;
                break;
            default:
                return false;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W:
                moveUp = false;
                break;
            case Keys.A:
                moveLeft = false;
                break;
            case Keys.S:
                moveDown = false;
                break;
            case Keys.D:
                moveRight = false;
                break;
            default:
                return false;
        }

        return true;
    }

} // PlayerObject
