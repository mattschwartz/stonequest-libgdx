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
import java.util.ArrayList;
import java.util.List;

public class Channel {

    private boolean showDate = true;
    private List<String> log;

    public Channel() {
        log = new ArrayList<>();
    }

    public void clear() {
        log.clear();
    }

    public String[] getLines() {
        return log.toArray(new String[]{});
    }

    public void addLine(String line) {
        if (showDate) {
            line = "[" + DateUtility.currentTime() + "] " + line;
        }

        log.add(line);
    }
}
