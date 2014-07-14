/* *****************************************************************************
 * Project:           StoneQuest
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
package com.barelyconscious.stonequest.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.barelyconscious.util.GUIHelper;

public class ProgressBar extends Actor {

    public static final Color BG_COLOR = new Color(22 / 255f, 40 / 255f, 22 / 255f, 1);
    public static final Color PROGRESS_COLOR = new Color(75 / 255f, 137 / 255f, 75 / 255f, 1);
    public static final Color PREVIEW_COLOR = new Color(103 / 255f, 188 / 255f, 103 / 255f, 1);

    private final Color outline_color = new Color(1, 1, 1, 0.2f);

    private int previewAmount;
    private float progress;
    private float previewProgress;
    private Color backgroundColor;
    private Color progressColor;
    private Color previewProgressColor;
    private Label previewLabel;

    public ProgressBar() {
        this(BG_COLOR, PROGRESS_COLOR, PREVIEW_COLOR);
    }

    public ProgressBar(Color backgroundColor, Color progressColor, Color previewProgressColor) {
        this.backgroundColor = backgroundColor;
        this.progressColor = progressColor;
        this.previewProgressColor = previewProgressColor;

        previewLabel = GUIHelper.createLabel("+0", 12, PREVIEW_COLOR);
    }

    public void setPreviewAmount(int amount) {
        previewAmount = amount;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public void setPreviewProgress(float progress) {
        previewProgress = progress;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        String str = "+" + previewAmount;
        BitmapFont font = previewLabel.getStyle().font;

        previewLabel.setText(str);
        previewLabel.setPosition(getX() + getWidth() - font.getBounds(str).width - 2,
                getY() + getHeight() - 12 - (getHeight() - 7) / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float progressWidth;
        ShapeRenderer shape = new ShapeRenderer();
        NinePatch outlinePatch = GUIHelper.getPatch("outline_border");

        shape.setProjectionMatrix(batch.getProjectionMatrix());
        shape.setTransformMatrix(batch.getTransformMatrix());
        shape.translate(getX(), getY(), 0);

        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(backgroundColor);
        shape.box(0, 0, 0, getWidth(), getHeight(), 0);

        progressWidth = Math.min(getWidth() * previewProgress, getWidth());
        shape.setColor(previewProgressColor);
        shape.box(0, 0, 0, progressWidth, getHeight(), 0);

        progressWidth = Math.min(getWidth() * progress, getWidth());
        shape.setColor(progressColor);
        shape.box(0, 0, 0, progressWidth, getHeight(), 0);

//        Gdx.gl.glEnable(GL30.GL_BLEND);
//        Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
//        shape.end();
//        Gdx.gl.glEnable(GL30.GL_BLEND);
//        Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
//        shape.begin(ShapeRenderer.ShapeType.Line);
//
//        shape.setColor(outline_color);
//        shape.rect(0, 0, getWidth(), getHeight());
//        Gdx.gl.glDisable(GL30.GL_BLEND);
        shape.end();
        shape.dispose();
        batch.begin();

        if (previewAmount == 0) {
            return;
        }

        outlinePatch.draw(batch, getX() - 1, getY() - 1, getWidth() + 2, getHeight() + 2);
        previewLabel.draw(batch, parentAlpha);
    }

} // ProgressBar
