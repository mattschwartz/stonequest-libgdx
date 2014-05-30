/* *****************************************************************************
 * Project:           core
 * File Name:         SpriteTween.java
 * Author:            Matt Schwartz
 * Date Created:      05.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.tweening;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SplashScreenAccessor implements TweenAccessor<Sprite> {

    public static final int ALPHA = 0;
    public static final int Y = 1;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case ALPHA:
                returnValues[0] = target.getColor().a;
                return 1;
            case Y:
                returnValues[0] = target.getY();
                return 1;
        }

        return 0;
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case ALPHA:
                target.setColor(1, 1, 1, newValues[0]);
                break;

            case Y:
                target.setY(newValues[0]);
                break;
        }
    }

} // SpriteTween
