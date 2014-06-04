/* *****************************************************************************
 * Project:           stonequest
 * File Name:         Zone.java
 * Author:            Matt Schwartz
 * Date Created:      05.19.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Zone {

    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    private MapObjects objects;

    public Zone(String path, World world) {
        map = new TmxMapLoader().load(path);
        renderer = new OrthogonalTiledMapRenderer(map);

        MapLayer collisionObjectLayer = map.getLayers().get("collision");
        objects = collisionObjectLayer.getObjects();

        addWalls(world);
    }

    private void addWalls(World world) {
        Body body;
        BodyDef bodyDef;
        PolygonShape shape;
        FixtureDef fixture;

        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();

            bodyDef = new BodyDef();
            shape = new PolygonShape();
            fixture = new FixtureDef();

            shape.setAsBox(rectangle.width / 2, rectangle.height / 2);
            fixture.shape = shape;

            bodyDef.position.x = rectangle.x + rectangle.width / 2;
            bodyDef.position.y = rectangle.y + rectangle.height / 2;

            body = world.createBody(bodyDef);
            body.createFixture(fixture);

            shape.dispose();
        }
    }

    public void render(OrthographicCamera camera) {
        renderer.setView(camera);
        renderer.render();
    }

    public boolean canMove(Rectangle boundingBox) {
        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();

            if (Intersector.overlaps(rectangle, boundingBox)) {
                return false;
            }
        }

        return true;
    }
} // Zone
