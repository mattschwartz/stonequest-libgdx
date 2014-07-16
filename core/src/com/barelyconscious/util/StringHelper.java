/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         StringHelper.java
 * Author:            Matt Schwartz
 * Date Created:      06.04.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.util;

import com.barelyconscious.stonequest.items.Material;
import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    public static final List<Character> vowels = new ArrayList<>();
    public static final List<Character> consonants = new ArrayList<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        consonants.add('b');
        consonants.add('c');
        consonants.add('d');
        consonants.add('f');
        consonants.add('g');
        consonants.add('h');
        consonants.add('j');
        consonants.add('k');
        consonants.add('l');
        consonants.add('m');
        consonants.add('n');
        consonants.add('p');
        consonants.add('q');
        consonants.add('r');
        consonants.add('s');
        consonants.add('t');
        consonants.add('v');
        consonants.add('w');
        consonants.add('x');
        consonants.add('y');
        consonants.add('z');
    }

    public static String aOrAn(String str) {
        if (vowels.contains(str.toLowerCase().toCharArray()[0])) {
            return "an " + str;
        }

        return "a " + str;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    public static String asPercent(double d) {
        return String.format("%.2f%%", d);
    }

    public static String pairToString(Pair p, String delimiter) {
        return p.first + delimiter + p.second;
    }

    public static String listAsString(List<Material> materials) {
        String result = "";

        if (materials == null || materials.isEmpty()) {
            return "";
        }

        for (Material material : materials) {
            result += material + ", ";
        }

        result = result.substring(0, result.length() - 2);

        return result;
    }
} // StringHelper
