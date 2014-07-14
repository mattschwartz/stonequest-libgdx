/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Journal.java
 * Author:            Matt Schwartz
 * Date Created:      07.12.2014
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.journal;

import java.util.ArrayList;
import java.util.List;

public class Journal {

    private List<Entry> entries;

    public Journal() {
        entries = new ArrayList<>();
        
        // Debug
        Entry dbgEntry = new Entry("Find the Entrance");
        dbgEntry.setDescription("Near here is an entrance to the mountain. You'll know it when you see it.");
        addEntry(dbgEntry);

        dbgEntry = new Entry("Don't Die");
        dbgEntry.setDescription("Like the title says. Don't die, moron.");
        addEntry(dbgEntry);
        // end dbg
    }

    /**
     * Adds a journal entry to the list of entries within the Journal.
     *
     * @param entry The entry to be added to the Journal.
     */
    public final void addEntry(Entry entry) {
        entries.add(entry);
    }

    /**
     *
     * @param index The index of the Entry to retrieve.
     * @return Returns the Entry at the specified index, if one exists. Returns
     * null if the index specified is out of bounds.
     */
    public Entry getEntry(int index) {
        if (index < 0 || index >= entries.size()) {
            return null;
        }

        return entries.get(index);
    }

    /**
     *
     * @return Returns the list of Entries associated with the Journal as an
     * array.
     */
    public Entry[] getEntries() {
        return entries.toArray(new Entry[]{});
    }
}
