package org.isma.core.help.about.gui;

import org.isma.guitoolkit.IForm;

import javax.swing.*;

public class AboutForm implements IForm {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel versionLabel;
    private JLabel javaVersionLabel;
    private JLabel aboutLabel;


    public JPanel getMainPanel() {
        return mainPanel;
    }


    public JLabel getNameLabel() {
        return nameLabel;
    }


    public JLabel getVersionLabel() {
        return versionLabel;
    }


    public JLabel getJavaVersionLabel() {
        return javaVersionLabel;
    }


    public JLabel getAboutLabel() {
        return aboutLabel;
    }
}
