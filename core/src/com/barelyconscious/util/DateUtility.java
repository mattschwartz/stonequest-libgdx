/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         DateUtility.java
 * Author:            Matt Schwartz
 * Date Created:      07.15.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.util;

import java.util.Calendar;

public class DateUtility {

    public static String currentDate() {
        Calendar cal = Calendar.getInstance();
        StringBuilder result = new StringBuilder();

        result.append(String.format("%02d", cal.get(Calendar.MONTH) + 1)).append("/");
        result.append(String.format("%02d", cal.get(Calendar.DAY_OF_MONTH))).append("/");
        result.append(cal.get(Calendar.YEAR));

        return result.toString();
    }

    public static String currentTime() {
        Calendar cal = Calendar.getInstance();
        StringBuilder result = new StringBuilder();

        result.append(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))).append(":");
        result.append(String.format("%02d", cal.get(Calendar.MINUTE))).append(":");
        result.append(String.format("%02d", cal.get(Calendar.SECOND)));

        return result.toString();
    }

    public static String currentDateTime() {
        return currentDate() + " " + currentTime();
    }
}
