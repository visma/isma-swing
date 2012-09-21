package org.isma.core.icons;

import javax.swing.*;

public enum CoreIconEnum {
    HELP_ICON("images/help.png"),
    TODO_ICON("images/todo.png"),
    SHUTDOWN_ICON("images/shutdown.png");

    private String path;
    private ImageIcon imageIcon;


    CoreIconEnum(String path) {
        this.path = path;
        this.imageIcon = new ImageIcon(getClass().getClassLoader().getResource(getPath()));
    }


    public String getPath() {
        return path;
    }


    public ImageIcon getImageIcon() {
        return imageIcon;
    }


}
