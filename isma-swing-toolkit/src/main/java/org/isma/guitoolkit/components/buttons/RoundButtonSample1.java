package org.isma.guitoolkit.components.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButtonSample1 extends JButton {
    public RoundButtonSample1(String label) {
        super(label);

        // These statements enlarge the button so that it becomes a circle rather than an oval.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        // This call causes the JButton not to paint the background. This allows us to paint a round background.
        setContentAreaFilled(false);
    }


    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            // You might want to make the highlight color a property of the RoundButton class.
            g.setColor(Color.LIGHT_GRAY);
        }
        else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }


    // Paint the border of the button using a simple stroke.
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }


    // Hit detection.
    Shape shape;


    @Override
    public boolean contains(int x, int y) {
        // If the button has changed size, make a new shape object.
        if (shape == null ||
            !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }


    // Test routine.
    public static void main(String[] args) {
        // Create a button with the label "Jackpot".
        JButton button = new RoundButtonSample1("Jackpot");
        button.setBackground(Color.GREEN);

        // Create a frame in which to show the button.
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.getContentPane().add(button);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(150, 150);
        frame.setVisible(true);
    }
}
