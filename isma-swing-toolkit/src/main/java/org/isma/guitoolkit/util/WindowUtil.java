package org.isma.guitoolkit.util;

import java.awt.*;
import java.lang.reflect.Method;


/**
 * Méthodes d'usage divers à appliquer sur les fenêtres
 */
public class WindowUtil {
    static final Dimension[] SCREENS_SIZE =
          new Dimension[]{
                new Dimension(800, 600), new Dimension(1024, 768), new Dimension(1152, 864),
                new Dimension(1280, 1024), new Dimension(1280, 960)
          };


    private WindowUtil() {
    }


    /**
     * Centre une fenêtre sur l'écran sur la hauteur et la largeur
     *
     * @param w window à centrer
     */
    public static void center(Component w) {
        if (w == null) {
            return;
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double x = (screenSize.getWidth() - w.getWidth()) / 2;
        double y = (screenSize.getHeight() - w.getHeight()) / 2;
        w.setLocation((int)x, (int)y);
    }


    /**
     * Centre une fenêtre sur une fenetre parente sur la hauteur et la largeur
     *
     * @param toCenter window à centrer par rapport au parent
     * @param parent   parent window
     */
    public static void center(Component toCenter, Component parent) {
        if (toCenter == null || parent == null) {
            return;
        }
        double x = parent.getX() + (parent.getWidth() - toCenter.getWidth()) / 2;
        double y = parent.getY() + (parent.getHeight() - toCenter.getHeight()) / 2;
        toCenter.setLocation((int)x, (int)y);
    }


    /**
     * Centre une fenêtre sur l'écran sur la hauteur et la largeur
     *
     * @param w window à centrer
     */
    public static void centerTop(Component w) {
        if (w == null) {
            return;
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double x = (screenSize.getWidth() - w.getWidth()) / 2;
        w.setLocation((int)x, 0);
    }


    /**
     * Positionne la fenêtre sur tout l'écran (gauche s'il y a plusieurs écran)
     */
    public static void fullSize(Window w) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Logger.getLogger(WindowUtil.class).debug("Dimension de l'écran: " + screenSize.getWidth() + "," + screenSize.getHeight());
        double y = screenSize.getHeight();

        // Gestion des multi-écrans
        for (Dimension aScreensSize : SCREENS_SIZE) {
            if (y == aScreensSize.getHeight()) {
                Dimension dimension = new Dimension();
                dimension.setSize(aScreensSize.getWidth(), aScreensSize.getHeight() - 30);
                w.setSize(dimension);
                w.setLocation(0, 0);
                break;
            }
        }
    }


    public static void setOpaque(Window window, float opacity) throws Exception {
        Class<?> awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
        Method mSetWindowOpacity = awtUtilitiesClass.getMethod("setWindowOpacity", Window.class, float.class);
        mSetWindowOpacity.invoke(null, window, Float.valueOf(opacity));
    }
}
