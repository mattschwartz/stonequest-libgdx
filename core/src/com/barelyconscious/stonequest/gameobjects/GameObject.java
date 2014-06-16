/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         GameObject.java
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

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.barelyconscious.stonequest.world.GameWorld;

public abstract class GameObject extends InputAdapter {

    protected float x;
    protected float y;
    protected boolean isSensor = false;
    protected boolean removeOnUpdate = false;

    // Rendering variables
    protected Sprite sprite;
    protected Texture texture;
    protected Body spriteBody;
    protected Fixture spriteFixture;

    public GameObject(String filepath) {
        sprite = new Sprite(new Texture(filepath));
    }
    
    protected final Vector2 getWorldCoords(int x, int y) {
        return GameWorld.getInstance().getWorldCoords(x, y);
    }

    public void setPosition(Vector2 position) {
        setPosition(position.x, position.y);
    }

    public void setX(float x) {
        this.x = x;
        spriteBody.setTransform(x, y, spriteBody.getAngle());
        sprite.setPosition(x - sprite.getWidth() / 2f, y - sprite.getHeight() / 2f);
    }

    public void setY(float y) {
        this.y = y;
        spriteBody.setTransform(x, y, spriteBody.getAngle());
        sprite.setPosition(x - sprite.getWidth() / 2f, y - sprite.getHeight() / 2f);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        spriteBody.setTransform(x, y, spriteBody.getAngle());
        sprite.setPosition(x - sprite.getWidth() / 2f, y - sprite.getHeight() / 2f);
    }

    public Vector2 getPosition() {
        return new Vector2(x, y);
    }

    public Rectangle getBoundingBox() {
        return sprite.getBoundingRectangle();
    }
    
    public void spawnObject(World world) {
        spawnObject(world, x, y);
    }

    public void spawnObject(World world, float x, float y) {
        BodyDef spriteBodyDef = new BodyDef();
        PolygonShape spriteShape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();

        this.x = x;
        this.y = y;

        spriteShape.setAsBox(0, (sprite.getHeight()) / 2);
        fixtureDef.shape = spriteShape;
        fixtureDef.isSensor = isSensor;

        if (isSensor) {
            fixtureDef.filter.categoryBits = LightManager.IGNORED_CATEGORY;
            fixtureDef.filter.groupIndex = LightManager.IGNORED_GROUP;
            fixtureDef.filter.maskBits = LightManager.IGNORED_MASK;
        }

        spriteBodyDef.position.x = x;
        spriteBodyDef.position.y = y;

        spriteBody = world.createBody(spriteBodyDef);
        spriteBody.createFixture(fixtureDef);

        spriteShape.dispose();

        sprite.setPosition(spriteBody.getPosition().x - sprite.getWidth() / 2, spriteBody.getPosition().y - sprite.getHeight() / 2);
    }

    public void remove() {
        removeOnUpdate = true;
    }

    public boolean shouldRemove() {
        return removeOnUpdate;
    }

    public void update(float delta) {
    }

    public void draw(Batch batch) {
        sprite.draw(batch);
    }
} // GameObject
