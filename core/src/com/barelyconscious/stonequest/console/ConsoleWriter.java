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
