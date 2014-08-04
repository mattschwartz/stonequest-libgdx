/* *****************************************************************************
   * Project:           core
   * File Name:         MapController.java
   * Author:            Matt Schwartz
   * Date Created:      07.30.2014 
   * Redistribution:    You are free to use, reuse, and edit any of the text in
   *                    this file.  You are not allowed to take credit for code
   *                    that was not written fully by yourself, or to remove 
   *                    credit from code that was not written fully by yourself.  
   *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
   * File Description:  
   ************************************************************************** */

package com.barelyconscious.stonequest.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class MapController extends InputAdapter {

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }
    
} // MapController
