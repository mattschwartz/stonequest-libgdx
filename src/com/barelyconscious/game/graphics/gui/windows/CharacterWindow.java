/* *****************************************************************************
 * Project:          StoneQuest
 * File name:        CharacterWindow.java
 * Author:           Matt Schwartz
 * Date created:     08.31.2013
 * Redistribution:   You are free to use, reuse, and edit any of the text in
 *                   this file.  You are not allowed to take credit for code
 *                   that was not written fully by yourself, or to remove 
 *                   credit from code that was not written fully by yourself.  
 *                   Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File description: 
 **************************************************************************** */
package com.barelyconscious.game.graphics.gui.windows;

import com.barelyconscious.game.graphics.gui.CloseWindowButton;
import com.barelyconscious.game.graphics.gui.InterfaceWindowButton;
import com.barelyconscious.game.Screen;
import com.barelyconscious.game.World;
import com.barelyconscious.game.graphics.FontService;
import com.barelyconscious.game.graphics.UIElement;
import com.barelyconscious.game.graphics.gui.Button;
import com.barelyconscious.game.graphics.gui.ButtonAction;
import com.barelyconscious.game.graphics.gui.JustifiedTextArea;
import com.barelyconscious.game.graphics.gui.TextArea;
import com.barelyconscious.game.input.Interactable;
import com.barelyconscious.game.player.Player;
import com.barelyconscious.game.services.WindowManager;
import com.barelyconscious.game.spawnable.Entity;
import com.barelyconscious.util.StringHelper;
import com.barelyconscious.util.TextLogHelper;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class CharacterWindow extends Window implements ButtonAction {

    private static final UIElement CHARACTER_WINDOW_BACKGROUND = UIElement.createUIElement("/gfx/gui/components/windows/character/background.png");
    private final int HITPOINTS_ATTRIBUTE_OFFS_X = 43;
    private final int HITPOINTS_ATTRIBUTE_OFFS_Y = 153;
    private final int STRENGTH_ATTRIBUTE_OFFS_X = 43;
    private final int STRENGTH_ATTRIBUTE_OFFS_Y = 192;
    private final int ACCURACY_ATTRIBUTE_OFFS_X = 43;
    private final int ACCURACY_ATTRIBUTE_OFFS_Y = 231;
    private final int DEFENSE_ATTRIBUTE_OFFS_X = 43;
    private final int DEFENSE_ATTRIBUTE_OFFS_Y = 270;
    private final int AGILITY_ATTRIBUTE_OFFS_X = 43;
    private final int AGILITY_ATTRIBUTE_OFFS_Y = 309;
    private final int FIRE_MAGIC_ATTRIBUTE_OFFS_X = 208;
    private final int FIRE_MAGIC_ATTRIBUTE_OFFS_Y = 153;
    private final int FROST_MAGIC_ATTRIBUTE_OFFS_X = 208;
    private final int FROST_MAGIC_ATTRIBUTE_OFFS_Y = 192;
    private final int HOLY_MAGIC_ATTRIBUTE_OFFS_X = 208;
    private final int HOLY_MAGIC_ATTRIBUTE_OFFS_Y = 231;
    private final int CHAOS_MAGIC_ATTRIBUTE_OFFS_X = 208;
    private final int CHAOS_MAGIC_ATTRIBUTE_OFFS_Y = 270;
    private final int FAITH_ATTRIBUTE_OFFS_X = 208;
    private final int FAITH_ATTRIBUTE_OFFS_Y = 309;
    private final int ATTRIBUTE_HOVER_AREA_WIDTH = 115;
    private final int ATTRIBUTE_HOVER_AREA_HEIGHT = 34;
    private final int ATTRIBUTE_TEXT_OFFS_X = 43;
    private final int ATTRIBUTE_TEXT_OFFS_Y = 4;
    private final int PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH = 70;
    private final int PLAYER_NAME_TEXT_OFFS_X = 46;
    private final int PLAYER_NAME_TEXT_OFFS_Y = 124;
    private final int PLAYER_NAME_TEXT_WIDTH = 274;
    private final int PLAYER_NAME_TEXT_HEIGHT = 28;
    private final int DETAILS_TITLE_TEXT_OFFS_X = PLAYER_NAME_TEXT_OFFS_X;
    private final int DETAILS_TITLE_TEXT_OFFS_Y = 373;
    private final int DETAILS_TITLE_TEXT_WIDTH = PLAYER_NAME_TEXT_WIDTH;
    private final int DETAILS_TITLE_TEXT_HEIGHT = PLAYER_NAME_TEXT_HEIGHT;
    /* The player can hover over an attribute to learn more about it, here the
     mouse hover over regions are defined as Rectangles */
    private Rectangle attributesMouseRegion;
    private Rectangle hitpointsAttributeMouseRegion;
    private Rectangle strengthAttributeMouseRegion;
    private Rectangle accuracyAttributeMouseRegion;
    private Rectangle defenseAttributeMouseRegion;
    private Rectangle agilityAttributeMouseRegion;
    private Rectangle fireMagicAttributeMouseRegion;
    private Rectangle frostMagicAttributeMouseRegion;
    private Rectangle holyMagicAttributeMouseRegion;
    private Rectangle chaosMagicAttributeMouseRegion;
    private Rectangle faithAttributeMouseRegion;
    private final Color PLAYER_NAME_TEXT_COLOR = new Color(TextLogHelper.TEXTLOG_DEFAULT_COLOR);
    private int animationY;
    private int attributeHoverOver = -1;
    protected InterfaceWindowButton windowButton;
    private CloseWindowButton closeWindowButton;
    private JustifiedTextArea detailedStatsTextArea;
    private TextArea attributeInformationTextArea;
    private final Player player;

    public CharacterWindow() {
        this.player = World.INSTANCE.getPlayer();
        setWidth(CHARACTER_WINDOW_BACKGROUND.getWidth());
        setHeight(CHARACTER_WINDOW_BACKGROUND.getHeight());

        closeWindowButton = new CloseWindowButton(this, WindowManager.INTERFACE_WINDOW_CLOSE_BUTTON);
        detailedStatsTextArea = new JustifiedTextArea(getX() + 43, getY() + 409, 280, 166);
        attributeInformationTextArea = new TextArea(getX() + 43, getY() + 409, 280, 166);

        setAttributeMouseRegions();

        super.setRegion(getX(), getY(), getWidth(), getHeight());
        super.addMouseListener(Interactable.Z_BACKGROUND);
        hide();
    } // constructor

    private void setAttributeMouseRegions() {
        attributesMouseRegion = new Rectangle(getX() + 43, getY() + 153, 280, 190);
        hitpointsAttributeMouseRegion = new Rectangle(getX() + HITPOINTS_ATTRIBUTE_OFFS_X, getY() + HITPOINTS_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        strengthAttributeMouseRegion = new Rectangle(getX() + STRENGTH_ATTRIBUTE_OFFS_X, getY() + STRENGTH_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        accuracyAttributeMouseRegion = new Rectangle(getX() + ACCURACY_ATTRIBUTE_OFFS_X, getY() + ACCURACY_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        defenseAttributeMouseRegion = new Rectangle(getX() + DEFENSE_ATTRIBUTE_OFFS_X, getY() + DEFENSE_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        agilityAttributeMouseRegion = new Rectangle(getX() + AGILITY_ATTRIBUTE_OFFS_X, getY() + AGILITY_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        fireMagicAttributeMouseRegion = new Rectangle(getX() + FIRE_MAGIC_ATTRIBUTE_OFFS_X, getY() + FIRE_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        frostMagicAttributeMouseRegion = new Rectangle(getX() + FROST_MAGIC_ATTRIBUTE_OFFS_X, getY() + FROST_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        holyMagicAttributeMouseRegion = new Rectangle(getX() + HOLY_MAGIC_ATTRIBUTE_OFFS_X, getY() + HOLY_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        chaosMagicAttributeMouseRegion = new Rectangle(getX() + CHAOS_MAGIC_ATTRIBUTE_OFFS_X, getY() + CHAOS_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        faithAttributeMouseRegion = new Rectangle(getX() + FAITH_ATTRIBUTE_OFFS_X, getY() + FAITH_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
    } // setAttributeMouseRegions

    /**
     * Resize elements as necessary when the application is resized.
     *
     * @param artworkWindowOffsX the new getX() position of the artwork
     * interface window
     * @param artworkWindowOffsY the new getY() position of the artwork
     * interface window
     * @param windowButtonX the new getX() position of the upgrade item window's
     * button
     * @param windowButtonY the new getY() position of the upgrade item window's
     * button
     */
    public void resize(int gameWidth, int artworkWindowOffsY, int windowButtonX, int windowButtonY) {
        setX(gameWidth - getWidth());
        setY(artworkWindowOffsY - getHeight());

        windowButton.setX(windowButtonX);
        windowButton.setY(windowButtonY);

        closeWindowButton.setX(gameWidth - WindowManager.INTERFACE_WINDOW_CLOSE_BUTTON.getWidth() - 16);
        closeWindowButton.setY(getY() + 10);

        detailedStatsTextArea.resize(getX() + 43, getY() + 409);
        attributeInformationTextArea.resize(getX() + 43, getY() + 409);

        super.setRegion(getX(), getY(), getWidth(), getHeight());

        attributesMouseRegion = new Rectangle(getX() + 43, getY() + 153, 280, 190);
        hitpointsAttributeMouseRegion = new Rectangle(getX() + HITPOINTS_ATTRIBUTE_OFFS_X, getY() + HITPOINTS_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        strengthAttributeMouseRegion = new Rectangle(getX() + STRENGTH_ATTRIBUTE_OFFS_X, getY() + STRENGTH_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        accuracyAttributeMouseRegion = new Rectangle(getX() + ACCURACY_ATTRIBUTE_OFFS_X, getY() + ACCURACY_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        defenseAttributeMouseRegion = new Rectangle(getX() + DEFENSE_ATTRIBUTE_OFFS_X, getY() + DEFENSE_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        agilityAttributeMouseRegion = new Rectangle(getX() + AGILITY_ATTRIBUTE_OFFS_X, getY() + AGILITY_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        fireMagicAttributeMouseRegion = new Rectangle(getX() + FIRE_MAGIC_ATTRIBUTE_OFFS_X, getY() + FIRE_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        frostMagicAttributeMouseRegion = new Rectangle(getX() + FROST_MAGIC_ATTRIBUTE_OFFS_X, getY() + FROST_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        holyMagicAttributeMouseRegion = new Rectangle(getX() + HOLY_MAGIC_ATTRIBUTE_OFFS_X, getY() + HOLY_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        chaosMagicAttributeMouseRegion = new Rectangle(getX() + CHAOS_MAGIC_ATTRIBUTE_OFFS_X, getY() + CHAOS_MAGIC_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
        faithAttributeMouseRegion = new Rectangle(getX() + FAITH_ATTRIBUTE_OFFS_X, getY() + FAITH_ATTRIBUTE_OFFS_Y, ATTRIBUTE_HOVER_AREA_WIDTH, ATTRIBUTE_HOVER_AREA_HEIGHT);
    } // resize

    private void setComponentsEnabled(boolean enabled) {
        detailedStatsTextArea.setEnabled(enabled);
        attributeInformationTextArea.setEnabled(enabled);
        closeWindowButton.setEnabled(enabled);
    } // setComponentsEnabled

    private void writeDetailedStats() {
        detailedStatsTextArea.clearText();
        detailedStatsTextArea.appendLine("Melee damage", String.format("%.1f-%.1f", player.getMinimumPhysicalDamage(), player.getMaximumPhysicalDamage()));
        detailedStatsTextArea.appendLine("Magic damage", String.format("%.1f-%.1f", player.getMinimumMagicDamage(), player.getMaximumMagicDamage()));
        detailedStatsTextArea.appendLine("Crit chance", String.format("%.1f%%", player.getBonusFromAccuracy()));
        detailedStatsTextArea.appendLine("Armor", String.format("%.1f%%", player.getBonusFromDefense()));
        detailedStatsTextArea.appendLine("Evasion", String.format("%.1f%%", player.getBonusFromEvasion()));
        detailedStatsTextArea.appendLine("Fire magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.FIRE_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.appendLine("Frost magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.FROST_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.appendLine("Holy magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.HOLY_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.appendLine("Chaos magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.CHAOS_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.appendLine("Faith bonus", "12%");
        detailedStatsTextArea.appendLine("\n", null);
        detailedStatsTextArea.appendLine("Current level", "" + player.getLevel());
        detailedStatsTextArea.appendLine("Current experience", StringHelper.formatNumber(player.getCurrentExperience()));
        detailedStatsTextArea.appendLine("Next level in", StringHelper.formatNumber(player.getRequiredExperience()));
    } // writeDetailedStats

    private void updateDetailedStats() {
        detailedStatsTextArea.setLine(0, "Melee damage", String.format("%.1f-%.1f", player.getMinimumMagicDamage(), player.getMaximumPhysicalDamage()));
        detailedStatsTextArea.setLine(1, "Magic damage", String.format("%.1f-%.1f", player.getMinimumMagicDamage(), player.getMaximumMagicDamage()));
        detailedStatsTextArea.setLine(2, "Crit chance", String.format("%.1f%%", player.getBonusFromAccuracy()));
        detailedStatsTextArea.setLine(3, "Armor", String.format("%.1f%%", player.getBonusFromDefense()));
        detailedStatsTextArea.setLine(4, "Evasion", String.format("%.1f%%", player.getBonusFromEvasion()));
        detailedStatsTextArea.setLine(5, "Fire magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.FIRE_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.setLine(6, "Frost magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.FROST_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.setLine(7, "Holy magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.HOLY_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.setLine(8, "Chaos magic bonus", String.format("%.1f%%", player.getBonusFromElement(Entity.CHAOS_MAGIC_ATTRIBUTE)));
        detailedStatsTextArea.setLine(9, "Faith bonus", "12%");
        detailedStatsTextArea.setLine(11, "Current level", "" + player.getLevel());
        detailedStatsTextArea.setLine(12, "Current experience", StringHelper.formatNumber(player.getCurrentExperience()));
        detailedStatsTextArea.setLine(13, "Next level in", StringHelper.formatNumber(player.getRequiredExperience()));
    } // updateDetailedStats

    private void writeAttributeInformation() {
        attributeInformationTextArea.clearText();

        switch (attributeHoverOver) {
            case Entity.HEALTH_ATTRIBUTE:
                attributeInformationTextArea.append("Health keeps you alive and having more of it allows you to take more hits before you die. Health becomes more effective the higher it is.");
                break;
            case Entity.STRENGTH_ATTRIBUTE:
                attributeInformationTextArea.append("Strength improves the physical damage done by your attacks by " + (int) (player.getAttribute(Entity.STRENGTH_ATTRIBUTE) * 2) + "% and increases your weapon damage by a direct amount.");
                break;
            case Entity.ACCURACY_ATTRIBUTE:
                attributeInformationTextArea.append("Accuracy improves your chance to strike critically for double damage with physical attacks and reduces the change your attacks will glance off of enemies.");
                break;
            case Entity.DEFENSE_ATTRIBUTE:
                attributeInformationTextArea.append("Defense reduces the amount of physical damage taken by enemies and sufficient defense will stun attacking opponents.");
                break;
            case Entity.EVASION_ATTRIBUTE:
                attributeInformationTextArea.append("Evasion increases your chance to completely avoid incoming physical attacks.");
                break;
            case Entity.FIRE_MAGIC_ATTRIBUTE:
                attributeInformationTextArea.append("Fire magic improves your fire-based damage abilities as well as helps defend you from incoming fire-based atatcks.");
                break;
            case Entity.FROST_MAGIC_ATTRIBUTE:
                attributeInformationTextArea.append("Frost magic improves your frost-based damage abilities as well as helps defend you from incoming frost-based atatcks.");
                break;
            case Entity.HOLY_MAGIC_ATTRIBUTE:
                attributeInformationTextArea.append("Holy magic improves your holy-based damage abilities as well as helps defend you from incoming holy-based atatcks.");
                break;
            case Entity.CHAOS_MAGIC_ATTRIBUTE:
                attributeInformationTextArea.append("Chaos magic improves your chaos-based damage abilities as well as helps defend you from incoming chaos-based atatcks.");
                break;
            case Entity.FAITH_ATTRIBUTE:
                attributeInformationTextArea.append("Faith improves your worth to the divine and helps you gain their favor when performing religious rituals.");
                break;
            default:
                System.err.println("Unaccounted for: " + attributeHoverOver);
        } // switch-case
    } // writeAttributeInformation

    @Override
    public void mouseMoved(MouseEvent e) {
        attributeHoverOver = -1;
        if (!attributesMouseRegion.contains(e.getX(), e.getY())) {
            return;
        } // if

        // Is mouse hovering over the hitpoints attribute?
        if (hitpointsAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.HEALTH_ATTRIBUTE;
        } // if
        else if (strengthAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.STRENGTH_ATTRIBUTE;
        } // else if
        else if (accuracyAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.ACCURACY_ATTRIBUTE;
        } // else if
        else if (defenseAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.DEFENSE_ATTRIBUTE;
        } // else if
        else if (agilityAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.EVASION_ATTRIBUTE;
        } // else if
        else if (fireMagicAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.FIRE_MAGIC_ATTRIBUTE;
        } // else if
        else if (frostMagicAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.FROST_MAGIC_ATTRIBUTE;
        } // else if
        else if (holyMagicAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.HOLY_MAGIC_ATTRIBUTE;
        } // else if
        else if (chaosMagicAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.CHAOS_MAGIC_ATTRIBUTE;
        } // else if
        else if (faithAttributeMouseRegion.contains(e.getX(), e.getY())) {
            attributeHoverOver = Entity.FAITH_ATTRIBUTE;
        } // else if
    } // mouseMoved

    @Override
    public void mouseDragged(MouseEvent e) {
        attributeHoverOver = -1;
    } // mouseDragged

    @Override
    public void mouseExited() {
        attributeHoverOver = -1;
        super.mouseExited();
    } // mouseExited

    @Override
    public void show() {
        if (WindowManager.INVENTORY_WINDOW.isVisible()) {
            WindowManager.INVENTORY_WINDOW.hide();
        } // if

        super.show();
        animationY = 0 - CHARACTER_WINDOW_BACKGROUND.getHeight();
        setComponentsEnabled(true);
        setEnabled(true);
        writeDetailedStats();
    } // show

    @Override
    public final void hide() {
        super.hide();
        setComponentsEnabled(false);
        setEnabled(false);
        attributeHoverOver = -1;
    } // hide

    @Override
    public void action(Button buttonPressed) {
        if (buttonPressed == closeWindowButton || buttonPressed == windowButton) {
            toggleUI();

            if (buttonPressed == windowButton) {
                hoverOverAction(buttonPressed);
            } // if
        } // if
    } // action

    @Override
    public void hoverOverAction(Button caller) {
        if (caller == null) {
            WindowManager.INSTANCE.clearTooltipText();
            return;
        } // if

        if (caller == windowButton) {
            if (isVisible()) {
                WindowManager.INSTANCE.setTooltipText("Click to close\nthe Character\nWindow");
            } // if
            else {
                WindowManager.INSTANCE.setTooltipText("Click to open\nthe Character\nWindow");
            } // else
        } // if
        else if (caller == closeWindowButton) {
            WindowManager.INSTANCE.setTooltipText("Click to close\nthe Character\nWindow");
        } // else if
    } // hoverOverAction

    @Override
    public void render(Screen screen) {
        windowButton.render(screen);

        if (!isVisible()) {
            return;
        } // if

        animationY = Math.min(animationY + (int) (screen.getVisibleHeight() * FALL_RATE), getY());

        CHARACTER_WINDOW_BACKGROUND.render(screen, getX(), animationY);

        if (animationY == getY()) {
            renderSubtitleText(screen);
            renderPlayerAttributes(screen);
            closeWindowButton.render(screen);

            if (attributeHoverOver >= 0) {
                writeAttributeInformation();
                attributeInformationTextArea.render(screen);
            } // if
            else {
                updateDetailedStats();
                detailedStatsTextArea.render(screen);
            } // else
        } // if
    } // render

    /**
     * Draw the player's attributes to the screen on top of the background.
     *
     * @param screen the screen to render to
     */
    private void renderPlayerAttributes(Screen screen) {
        int textOffsX = getX() + ATTRIBUTE_TEXT_OFFS_X;
        int textOffsY = getY() + ATTRIBUTE_TEXT_OFFS_Y + 17;
        String attributeValue;

        attributeValue = "" + (int) player.getAttribute(Entity.HEALTH_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + HITPOINTS_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + HITPOINTS_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.STRENGTH_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + STRENGTH_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + STRENGTH_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.ACCURACY_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + ACCURACY_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + ACCURACY_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.DEFENSE_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + DEFENSE_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + DEFENSE_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.EVASION_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + AGILITY_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + AGILITY_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.FIRE_MAGIC_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + FIRE_MAGIC_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + FIRE_MAGIC_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.FROST_MAGIC_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + FROST_MAGIC_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + FROST_MAGIC_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.HOLY_MAGIC_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + HOLY_MAGIC_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + HOLY_MAGIC_ATTRIBUTE_OFFS_Y);

        attributeValue = "" + (int) player.getAttribute(Entity.CHAOS_MAGIC_ATTRIBUTE);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + CHAOS_MAGIC_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + CHAOS_MAGIC_ATTRIBUTE_OFFS_Y);

        attributeValue = "100";// + (int) player.getAttribute(Entity.FAITH);
        FontService.drawFont(attributeValue, PLAYER_NAME_TEXT_COLOR, null, textOffsX + FAITH_ATTRIBUTE_OFFS_X + (PLAYER_ATTRIBUTE_TEXT_AREA_WIDTH - FontService.getStringWidth(attributeValue)) / 2, textOffsY + FAITH_ATTRIBUTE_OFFS_Y);
    } // renderPlayerAttributes

    private void renderSubtitleText(Screen screen) {
        int textOffsX;
        int textOffsY;
        String attributeDetailsTitle;

        // Render the player's name
        textOffsX = getX() + PLAYER_NAME_TEXT_OFFS_X + (PLAYER_NAME_TEXT_WIDTH - FontService.getStringWidth(player.getName())) / 2;
        textOffsY = getY() + PLAYER_NAME_TEXT_OFFS_Y + (PLAYER_NAME_TEXT_HEIGHT - FontService.characterHeight) / 2;
        FontService.drawFont(player.getName(), PLAYER_NAME_TEXT_COLOR, null, textOffsX, textOffsY);

        // Render the attribute details title
        if (attributeHoverOver >= 0) {
            attributeDetailsTitle = Entity.attributeIdToString(attributeHoverOver);
        } // if
        else {
            attributeDetailsTitle = "Details";
        } // else

        textOffsX = getX() + DETAILS_TITLE_TEXT_OFFS_X + (DETAILS_TITLE_TEXT_WIDTH - FontService.getStringWidth(attributeDetailsTitle)) / 2;
        textOffsY = getY() + DETAILS_TITLE_TEXT_OFFS_Y + (DETAILS_TITLE_TEXT_HEIGHT - FontService.characterHeight) / 2;
        FontService.drawFont(attributeDetailsTitle, PLAYER_NAME_TEXT_COLOR, null, textOffsX, textOffsY);
    } // renderPlayerName
} // CharacterWindow
