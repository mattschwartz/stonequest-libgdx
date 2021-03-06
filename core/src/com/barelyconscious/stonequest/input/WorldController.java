/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         WorldController.java
 * Author:            Matt Schwartz
 * Date Created:      05.31.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.input;

import com.badlogic.gdx.InputAdapter;

public class WorldController extends InputAdapter {

    @Override
    public boolean keyDown(int keycode) {
        return KeyBindings.invoke(keycode);
    }

} // WorldController
