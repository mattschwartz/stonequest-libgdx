/* *****************************************************************************
 *   Project:        StoneQuest
 *   File name:      DivineFavor.java
 *   Author:         Matt Schwartz
 *   Date:           06.15.2014
 *   License:        You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email mattschwartz@utexas.edu for issues or concerns.
 *   Description:    
 **************************************************************************** */
package com.barelyconscious.stonequest.items;

public class DivineFavor extends Item {
    
    @Override
    public String getDescription() {
        return "The gods smile upon this trinket.";
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }
    
}
