package com.barelyconscious.stonequest.console;

import java.util.ArrayList;
import java.util.List;

public class Channel {

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
        log.add(line);
    }
}
