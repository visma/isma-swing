package org.isma.guitoolkit;

import org.isma.guitoolkit.components.TestableFileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DirectoryChooserListener implements ActionListener {
    private Component parentComponent;
    private JTextField directoryPathTextField;
    private JFileChooser fileChooser = new TestableFileChooser();
    private File file;


    public DirectoryChooserListener(Component parentComponent, JTextField directoryPathTextField) {
        this.parentComponent = parentComponent;
        this.directoryPathTextField = directoryPathTextField;
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }


    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(parentComponent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            if (directoryPathTextField != null) {
                directoryPathTextField.setText(file.getAbsolutePath());
            }
        }
    }


    public File getFile() {
        return file;
    }
}
