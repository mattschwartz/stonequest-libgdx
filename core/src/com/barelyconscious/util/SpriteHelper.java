/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         SpriteHelper.java
 * Author:            Matt Schwartz
 * Date Created:      07.15.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.util;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpriteHelper {

    public static double distance(Sprite sprite1, Sprite sprite2) {
        return distance(sprite1.getBoundingRectangle(), sprite2.getBoundingRectangle());
    }

    public static double distance(Rectangle sprite1, Rectangle sprite2) {
        Vector2 a = new Vector2(sprite1.getX(), sprite1.getY());
        Vector2 b = new Vector2(sprite2.getX(), sprite2.getY());

        return distance(a, b);
    }

    public static double distance(Vector2 v1, Vector2 v2) {
        double a = Math.pow((v2.x - v1.x), 2);
        double b = Math.pow((v2.y - v1.y), 2);

        return Math.sqrt(a + b);
    }
}
