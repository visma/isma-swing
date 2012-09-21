package org.isma.core.actions;

import org.isma.core.event.AbstractActionMenu;
import org.isma.guitoolkit.util.WindowUtil;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractDialogAction extends AbstractActionMenu {
    private JFrame frame;


    protected AbstractDialogAction(JFrame frame, String label, ImageIcon icon, int mnemonic) {
        super(label, icon, mnemonic);
        this.frame = frame;
    }


    protected void displayDialog(JPanel panel, String title, ImageIcon imageIcon) {
        displayDialog(panel, title, imageIcon, null);
    }


    protected void displayDialog(JPanel panel, String title, ImageIcon imageIcon, Dimension dimension) {
        JDialog dialog = new JDialog(frame, title, true);
        dialog.setGlassPane(frame.getGlassPane());
        dialog.setIconImage(imageIcon.getImage());
        dialog.setContentPane(panel);
        dialog.pack();
        if (dimension != null) {
            dialog.setSize(dimension);
        }
        WindowUtil.center(dialog, frame);
        dialog.setVisible(true);
    }
}
