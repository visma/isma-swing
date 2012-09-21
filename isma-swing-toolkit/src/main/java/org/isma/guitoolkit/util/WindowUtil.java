package org.isma.guitoolkit.util;

import java.awt.*;
import java.lang.reflect.Method;


/**
 * M�thodes d'usage divers � appliquer sur les fen�tres
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
     * Centre une fen�tre sur l'�cran sur la hauteur et la largeur
     *
     * @param w window � centrer
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
     * Centre une fen�tre sur une fenetre parente sur la hauteur et la largeur
     *
     * @param toCenter window � centrer par rapport au parent
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
     * Centre une fen�tre sur l'�cran sur la hauteur et la largeur
     *
     * @param w window � centrer
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
     * Positionne la fen�tre sur tout l'�cran (gauche s'il y a plusieurs �cran)
     */
    public static void fullSize(Window w) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Logger.getLogger(WindowUtil.class).debug("Dimension de l'�cran: " + screenSize.getWidth() + "," + screenSize.getHeight());
        double y = screenSize.getHeight();

        // Gestion des multi-�crans
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
