package org.isma.guitoolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

//TODO verifier la compatibilté avec assertProgressDisplay de codjo-release-test
public class SimpleGlassPane extends JPanel {
    private static final Color GLASSPANE_COLOR = new Color(80, 80, 255, 127);


    public SimpleGlassPane() {
        setName("waitingPanel");
        setVisible(false);
        setOpaque(false);
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentHidden(ComponentEvent e) {
//                setVisible(true);
//            }
//        });
        addMouseListener(new MouseAdapter() {
        });
    }


    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setColor(GLASSPANE_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }


    @Override
    public void setVisible(boolean isVisible) {
        if (isVisible) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
        else {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
        super.setVisible(isVisible);
    }
}