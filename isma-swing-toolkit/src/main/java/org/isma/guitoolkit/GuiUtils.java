package org.isma.guitoolkit;

import javax.swing.*;

public class GuiUtils {
    private GuiUtils() {
    }


    public static void plugDirectoryChooser(JComponent parent, JButton browseButton, JTextField pathTextField) {
        browseButton.addActionListener(new DirectoryChooserListener(parent, pathTextField));
    }
}
