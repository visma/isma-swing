package org.isma.guitoolkit.cursors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CursorHelper {

    public static Cursor createCustomCursor(String name, Image image) {
        return Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), name);
    }


    public static void createAnimatedCustomCursor(final String name,
                                                  final Component component,
                                                  final Image[] images,
                                                  final Thread thread) {
        final Cursor[] cursors = createCustomCursors(name, images);
        thread.start();
        new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (thread.isAlive()) {
                    try {
                        sleep(1000 / images.length);
                    }
                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    component.setCursor(cursors[count % cursors.length]);
                    count++;
                }
                component.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }.start();
    }


    private static Cursor[] createCustomCursors(String name, Image[] images) {
        Cursor[] cursors = new Cursor[images.length];
        for (int i = 0; i < images.length; i++) {
            String currentName = String.format("%s.%s", name, i);
            cursors[i] = createCustomCursor(currentName, images[i]);
        }
        return cursors;
    }


    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(50000);
                }
                catch (InterruptedException e) {
                }
            }
        };
        final JPanel panel = new JPanel();
        final ImageIcon one = new ImageIcon(CursorHelper.class.getClassLoader()
                                                  .getResource("images/corbeau.png"));
        final ImageIcon two = new ImageIcon(CursorHelper.class.getClassLoader()
                                                  .getResource("images/corbeau2.png"));
        createAnimatedCustomCursor("toto", panel, new Image[]{one.getImage(), two.getImage()}, thread);

        JFrame frame = new JFrame("Test CursorHelper");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}
