/* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         SceneService.java
 * Author:            Matt Schwartz
 * Date Created:      01.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** *//* *****************************************************************************
 * Project:           StoneQuest
 * File Name:         Scene.java
 * Author:            Matt Schwartz
 * Date Created:      01.22.2014 
 * Redistribution:    You are free to use, reuse, and edit any of the text in
 *                    this file.  You are not allowed to take credit for code
 *                    that was not written fully by yourself, or to remove 
 *                    credit from code that was not written fully by yourself.  
 *                    Please email stonequest.bcgames@gmail.com for issues or concerns.
 * File Description:  
 ************************************************************************** */
package com.barelyconscious.game.services;

import com.barelyconscious.game.file.FileHandler;
import com.barelyconscious.game.graphics.UIElement;
import com.barelyconscious.game.graphics.View;
import com.barelyconscious.game.graphics.WorldView;
import com.barelyconscious.game.graphics.gui.Component;
import com.barelyconscious.game.graphics.gui.Cursors;
import com.barelyconscious.game.player.Player;
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SceneService extends JFrame implements Service {

    public static final SceneService INSTANCE = new SceneService();
    public static final int TILE_SIZE = 32;
    public static final String GAME_TITLE = "StoneQuest";
    public static final String GAME_VERSION = "0.7.0";
    private final InputHandler inputHandler = InputHandler.INSTANCE;
    private View view;

    /**
     * Constructs a new Scene object. This constructor may only be called within
     * this class as only one Scene may exist during runtime.
     */
    private SceneService() {
        if (INSTANCE != null) {
            throw new IllegalStateException(this + " has already been instantiated.");
        } // if
    } // constructor
    
    public void saveScreenshot() {
        String hour, minute, second, day, month, year;
        String date;
        File file = FileHandler.INSTANCE.getScreenshotDir();
        Robot robot;
        Rectangle bounds = new Rectangle();
        BufferedImage capture;
        Calendar cal = Calendar.getInstance();

        hour = cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY) : "" + cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : "" + cal.get(Calendar.MINUTE);
        second = cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(Calendar.SECOND) : "" + cal.get(Calendar.SECOND);
        month = (cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : "" + (cal.get(Calendar.MONTH) + 1);
        day = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + cal.get(Calendar.DAY_OF_MONTH) : "" + cal.get(Calendar.DAY_OF_MONTH);
        year = "" + cal.get(Calendar.YEAR);

        date = day + month + year + "_" + hour + minute + second;

        file = new File(file.getAbsolutePath() + FileHandler.delimiter + "screenshot" + date + ".png");

        System.err.println(" [NOTIFY] Saving screenshot at '" + file.getAbsolutePath() + "'.");

        try {
            robot = new Robot();
            bounds.setBounds(getLocationOnScreen().x, getLocationOnScreen().y, getWidth(), getHeight());
            capture = robot.createScreenCapture(bounds);
            ImageIO.write(capture, "png", file);
        } catch (IOException ex) {
            System.err.println("Error: " + ex);
        } catch (AWTException ex) {
            System.err.println("Error: " + ex);
        } // try-catch
    } // saveScreenshot

    /**
     * Changes the current View to <code>view</code> which must be non-null. The
     * new View will be rendered and the old one destroyed.
     *
     * @param view The new View for the SceneService. If null, an
 IllegalArgumentException is thrown
     */
    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("Argument 'view' must be non-null.");
        } // if
        this.view = view;
    } // setView

    /**
     * A View is what is being rendered within the SceneService which may be the game
 or a menu, etc.
     *
     * @return The current View for the SceneService
     */
    public View getView() {
        return view;
    } // getView
    
    public Graphics2D getCurrentGraphics() {
        return view == null ? null : view.getGraphics();
    } // getCurrentGraphics

    /**
     * The height of a View is used for relative positioning of elements and
     * components.
     *
     * @return The height of the current View
     */
    public int getViewHeight() {
        return view.height;
    } // getHeight

    /**
     * The width of a View is used for relative positioning of elements and
     * components.
     *
     * @return The width of the current View
     */
    public int getViewWidth() {
        return view.width;
    } // getWidth

    /**
     * Add a Component to the current View. Components are interactable objects
     * that act independently of the View.
     *
     * @param c The Component to be added to the View
     */
    public void addComponent(Component c) {
        view.addComponent(c);
    } // addComponent

    /**
     * Removes the specified Component from the current View.
     *
     * @param c The Component to be removed from the current View. Should not be
     * null
     * @return True if the supplied Component was found and removed. False
     * otherwise
     */
    public boolean removeComponent(Component c) {
        return view.removeComponent(c);
    } // removeComponent

    /**
     * Renders the current View to the window application. This is done
     * repeatedly during runtime.
     */
    public void render() {
        view.render();
    } // render

    @Override
    public void start() {
        initializeComponents();
        // Normally we get a new player from WelcomeView
        view = new WorldView(new Player("bcgames"), getWidth(), getHeight());
        add(view);
        setApplicationIcons();
        inputHandler.addListeners(this);
        Cursors.setCursor(Cursors.DEFAULT_CURSOR);
    } // start

    /**
     * Load and set the application icons for both the small and large sizes,
     * the large icon is what is displayed in the OS-dependent toolbar-like area
     * and the small icon is what is displayed in the OS-dependent application
     * window (if applicable, i.e., Windows-based OSs).
     */
    private void setApplicationIcons() {
        Image applicationIcon32; // 32x32
        Image applicationIcon16; // 16x16
        List<Image> icons;

        icons = new ArrayList<Image>();
        applicationIcon32 = UIElement.loadImage("/gfx/applicationIcon.png");
        applicationIcon16 = UIElement.loadImage("/gfx/applicationIconSmall.png");

        icons.add(applicationIcon16);
        icons.add(applicationIcon32);

        setIconImages(icons);
    } // setApplicationIcons

    /**
     * Set other application window properties such as adding the game's
     * rendering engine to the window and its title, and other JFrame
     * properties.
     */
    private void initializeComponents() {
        setTitle(GAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusTraversalKeysEnabled(false);
    } // setApplicationWindowProperties

    @Override
    public void stop() {
    } // stop

    @Override
    public void restart() {
        stop();
        start();
    } // restart
} // SceneService
