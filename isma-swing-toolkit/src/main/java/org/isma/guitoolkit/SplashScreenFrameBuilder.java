package org.isma.guitoolkit;

import org.isma.guitoolkit.util.WindowUtil;

import javax.swing.*;

public class SplashScreenFrameBuilder {

    private SplashScreenFrameBuilder() {
    }


    public static JFrame build(ImageIcon imageIcon) throws Exception {
        JFrame frame = new SplashScreenFrame(imageIcon);
        frame.setUndecorated(true);
        frame.getContentPane().add(new JLabel(imageIcon));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        frame.setVisible(true);
        WindowUtil.center(frame);
        return frame;
    }
}
