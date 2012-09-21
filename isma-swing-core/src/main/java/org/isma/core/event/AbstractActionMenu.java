package org.isma.core.event;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractActionMenu implements ActionListener {
    private String label;
    private ImageIcon icon;
    private int mnemonic;


    protected AbstractActionMenu(String label, ImageIcon icon, int mnemonic) {
        this.label = label;
        this.icon = icon;
        this.mnemonic = mnemonic;
    }


    public String getLabel() {
        return label;
    }


    public ImageIcon getIcon() {
        return icon;
    }


    public int getMnemonic() {
        return mnemonic;
    }
}
