/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         LightManager.java
 * Author:            Matt Schwartz
 * Date Created:      05.27.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.gameobjects;

import box2dLight.Light;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;
import java.util.List;

public class LightManager {

    public static final short IGNORED_CATEGORY = 1;
    public static final short IGNORED_GROUP =  -0x001;
    public static final short IGNORED_MASK = 1;
    
    private static final LightManager INSTANCE = new LightManager();

    private List<Light> lights = new ArrayList<>();
    public RayHandler handler;

    private LightManager() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been initialized.");
        }
    }

    public static LightManager getInstance() {
        return INSTANCE;
    }

    public void init(World world) {
        handler = new RayHandler(world);
        RayHandler.useDiffuseLight(true);
        handler.setAmbientLight(1);
        Light.setContactFilter(IGNORED_CATEGORY, IGNORED_GROUP, IGNORED_MASK);
    }

    public void updateAndRender(Camera camera) {
        handler.setCombinedMatrix(camera.combined);
        handler.updateAndRender();
    }

    public Light addPointLight(Color color, int distance, float x, float y) {
        Light light = new PointLight(handler, 1000, color, distance, x, y);
        lights.add(light);
        return light;
    }

    public void dispose() {
        lights.clear();
        handler.dispose();
    }

}
