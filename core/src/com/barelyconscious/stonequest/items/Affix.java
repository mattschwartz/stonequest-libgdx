/* *****************************************************************************
 * Project:           stonequest
 * File Name:         Affix.java
 * Author:            Matt Schwartz
 * Date Created:      05.11.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** *//* *****************************************************************************
 * Project:           stonequest
 * File Name:         Affix.java
 * Author:            Matt Schwartz
 * Date Created:      05.11.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.items;

import com.barelyconscious.stonequest.entities.Entity.Attribute;

public abstract class Affix {
    
    public Attribute attribute;
    public double value;

    public Affix(Attribute attribute, double value) {
        this.attribute = attribute;
        this.value = value;
    } // constructor
} // Affix
