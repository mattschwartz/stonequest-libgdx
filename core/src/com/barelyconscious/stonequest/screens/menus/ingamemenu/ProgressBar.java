/* *****************************************************************************
 * Project:           core
 * File Name:         ProgressBar.java
 * Author:            Matt Schwartz
 * Date Created:      06.07.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.stonequest.screens.menus.ingamemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ProgressBar extends Actor {

    public static final Color PROGRESS_BAR_BG_COLOR = new Color(22 / 255f, 40 / 255f, 22 / 255f, 1);
    public static final Color PROGRESS_BAR_FG_COLOR = new Color(75 / 255f, 137 / 255f, 75 / 255f, 1);

    private float progress;
    private float previewPercent;
    private Color backgroundColor;
    private Color progressColor;

    public ProgressBar() {
        this(PROGRESS_BAR_BG_COLOR, PROGRESS_BAR_FG_COLOR);
    }

    public ProgressBar(Color backgroundColor, Color progressColor) {
        this.backgroundColor = backgroundColor;
        this.progressColor = progressColor;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float progressWidth;
        ShapeRenderer shape = new ShapeRenderer();
        shape.setProjectionMatrix(batch.getProjectionMatrix());
        shape.setTransformMatrix(batch.getTransformMatrix());
        shape.translate(getX(), getY(), 0);

        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(backgroundColor);
        shape.box(0, 0, 0, getWidth(), getHeight(), 0);

        progressWidth = Math.min(getWidth() * progress, getWidth());
        shape.setColor(progressColor);
        shape.box(0, 0, 0, progressWidth, getHeight(), 0);

        shape.end();
        shape.dispose();
        batch.begin();
    }

} // ProgressBar
