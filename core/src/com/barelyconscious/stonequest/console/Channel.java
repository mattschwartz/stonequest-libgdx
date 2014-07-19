/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Channel.java
 * Author:            Matt Schwartz
 * Date Created:      07.14.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.console;

import com.barelyconscious.util.DateUtility;
import com.barelyconscious.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Channel {

    private boolean showDate = true;
    private List<Pair<String, String>> log;

    public Channel() {
        log = new ArrayList<>();
    }

    public void clear() {
        log.clear();
    }

    public List<String> getLines() {
        String line;
        List<String> result = new ArrayList<>();
        
        for (Pair<String, String> pair : log) {
            line = "";
            
            if (showDate) {
                line = pair.first;
            }
            
            line += pair.second;
            
            result.add(line);
        }
        
        return result;
    }

    public void addLine(String line) {
        log.add(new Pair("[" + DateUtility.currentTime() + "] ", line));
    }
}
