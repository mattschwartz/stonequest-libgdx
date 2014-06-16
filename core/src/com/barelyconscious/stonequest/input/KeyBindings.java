/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         KeyBindings.java
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

import com.badlogic.gdx.Input.Keys;
import java.util.HashMap;
import java.util.Map;

public class KeyBindings {
    
    public static int open_inventoryWindow = Keys.I;
    public static int open_characterWindow = Keys.C;
    public static int open_brewingWindow = Keys.B;
    public static int open_journalWindow = Keys.J;
    public static int open_upgradeWindow = Keys.U;
    public static int open_salvageWindow = Keys.V;
    public static int close_allWindows = Keys.ESCAPE;

    private static final Map<Integer, Runnable> BINDINGS = new HashMap<>();
    
    public static void addAction(int keycode, Runnable action) {
        BINDINGS.put(keycode, action);
    }

    public static boolean invoke(int keycode) {
        if (BINDINGS.containsKey(keycode)) {
            BINDINGS.get(keycode).run();
            return true;
        }
        
        return false;
    }
} // KeyBindings
