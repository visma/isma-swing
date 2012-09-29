package org.isma.guitoolkit;

import org.isma.guitoolkit.util.WindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SplashScreenFrame extends JFrame {
    private ImageIcon image = null;
    private int pixels[][];


    public SplashScreenFrame(ImageIcon image) throws Exception {
        super("");
        this.image = image;
        setResizable(false);
        setUndecorated(true);
        int width = image.getIconWidth();
        int height = image.getIconHeight();
        setSize(width, height);
        WindowUtil.center(this);

        Robot robot = new Robot();
        int xOrigin = getLocation().x;
        int yOrigin = getLocation().y;

        Rectangle rect = new Rectangle(xOrigin, yOrigin, width, height);
        BufferedImage screenCapture = robot.createScreenCapture(rect);
        pixels = new int[width][height];
        for (int x = 0; x < width; x++) {
            pixels[x] = new int[height];
            for (int y = 0; y < height; y++) {
                pixels[x][y] = screenCapture.getRGB(x, y);
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gc = (Graphics2D) g;
        Image imageBuffer = createImage(pixels.length, pixels[0].length);
        Graphics buffer = imageBuffer.getGraphics();
        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[x].length; y++) {
                buffer.setColor(new Color(pixels[x][y]));
                buffer.drawLine(x, y, x, y);
            }
        }
        buffer.drawImage(image.getImage(), 0, 0, this);
        gc.drawImage(imageBuffer, 0, 0, this);
    }
}