/* *****************************************************************************
   * Project:           core
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

public class StringHelper {

    
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }
} // StringHelper