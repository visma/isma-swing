package org.isma.guitoolkit.menus.actions;

import javax.swing.*;

public enum GuiToolkitIconEnum {
    FOLDER_EXPANDED("images/folder_expanded.png"),
    FOLDER_COLLAPSED("images/folder_collapsed.png");

    private String path;
    private ImageIcon imageIcon;


    GuiToolkitIconEnum(String path) {
        this.path = path;
        this.imageIcon = new ImageIcon(getClass().getClassLoader().getResource(getPath()));
    }


    public String getPath() {
        return path;
    }


    public ImageIcon getImageIcon() {
        return imageIcon;
    }


    public static Icon getIcon(String extension) {
        for (GuiToolkitIconEnum iconEnum : values()) {
            if (iconEnum.path.startsWith("images/" + extension + ".")) {
                return iconEnum.getImageIcon();
            }
        }
        return null;
    }
}