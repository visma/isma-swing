package org.isma.guitoolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class DragAndDropGlassPane extends JLabel {
    private static final Color GLASSPANE_COLOR = new Color(80, 255, 80, 40);


    public DragAndDropGlassPane() {
        setVisible(false);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
    }


    @Override
    public void paintComponent(Graphics graphics) {
        //super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setColor(GLASSPANE_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());

//        Point absoluteLocation = MouseInfo.getPointerInfo().getLocation();
//        Window windowAncestor = SwingUtilities.getWindowAncestor(this);
//        System.out.printf("window.x=%s, window.y=%s\n", windowAncestor.getLocation().x, windowAncestor.getLocation().y);
//        System.out.printf("absoluteLocation.x=%s, absoluteLocation.y=%s\n",
//                          absoluteLocation.getLocation().x,
//                          absoluteLocation.getLocation().y);
//        g2.fillRect(absoluteLocation.x - windowAncestor.getLocation().x,
//                    absoluteLocation.y - windowAncestor.getLocation().y,
//                    50,
//                    50);
    }


    @Override
    public void setVisible(boolean isVisible) {
        if (isVisible) {
            //C est pas la main refermée
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
        super.setVisible(isVisible);
    }
}