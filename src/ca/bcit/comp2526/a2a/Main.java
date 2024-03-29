package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Main.
 * @author BCIT
 * @version 1.0
 */
public final class Main {
    private static final Toolkit TOOLKIT;

    static {
        TOOLKIT = Toolkit.getDefaultToolkit();
    }

    private Main() {
    }
    
    /**
     * main entry point of program.
     * @param argv .
     */
    public static void main(final String[] argv) {
        final GameFrame frame;
        final World     world;

        RandomGenerator.reset();
        world = new World(25, 25);
        world.init();
        frame = new GameFrame(world);
        position(frame);
        frame.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void position(final GameFrame frame) {
        final Dimension size;

        size = calculateScreenArea(0.80f,
                                   0.80f);
        frame.setSize(size);
        frame.setLocation(centreOnScreen(size));
    }

    /**
     * Centers the GameFrame on the screen.
     * @param size of screen.
     * @return center point.
     */
    public static Point centreOnScreen(final Dimension size) {
        final Dimension screenSize;

        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }

        screenSize = TOOLKIT.getScreenSize();

        return (new Point((screenSize.width - size.width) / 2,
                          (screenSize.height - size.height) / 2));
    }

    /**
     *  Calculates the screen area.
     * @param widthPercent width as percent of screen size.
     * @param heightPercent height as percent of screen size.
     * @return the screens area.
     */
    public static Dimension calculateScreenArea(final float widthPercent,
                                                final float heightPercent) {
        final Dimension screenSize;
        final Dimension area;
        final int       width;
        final int       height;
        final int       size;

        if ((widthPercent <= 0.0f) || (widthPercent > 100.0f)) {
            throw new IllegalArgumentException("widthPercent cannot be " 
                                                + "<= 0 or > 100 - got: " 
                                                + widthPercent);
        }

        if ((heightPercent <= 0.0f) || (heightPercent > 100.0f)) {
            throw new IllegalArgumentException("heightPercent cannot be " 
                                                + "<= 0 or > 100 - got: " 
                                                + heightPercent);
        }

        screenSize = TOOLKIT.getScreenSize();
        width      = (int)(screenSize.width * widthPercent);
        height     = (int)(screenSize.height * heightPercent);
        size       = Math.min(width,
                              height);
        area       = new Dimension(size,
                                   size);

        return (area);
    }
}
