/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         ConsoleWriter.java
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

import java.util.EnumMap;
import java.util.Map;

public class ConsoleWriter {

    public enum ChannelName {

        dev,
        general,
        combat,
        npc;
    }

    private static final Map<ChannelName, Channel> channels = new EnumMap<>(ChannelName.class);

    static {
        channels.put(ChannelName.dev, new Channel());
        channels.put(ChannelName.general, new Channel());
        channels.put(ChannelName.combat, new Channel());
        channels.put(ChannelName.npc, new Channel());
    }

    public static void writeLine(ChannelName channel, String line) {
        channels.get(channel).addLine(line);
    }

    public static Channel getChannel(ChannelName channel) {
        return channels.get(channel);
    }
}
