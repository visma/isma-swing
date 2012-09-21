package org.isma.core.components;

import org.isma.core.event.AbstractActionMenu;

import javax.swing.*;

public class MenuBuilder {

    public JMenuItem buildMenuItem(AbstractActionMenu actionMenu) {
        JMenuItem item = new JMenuItem(actionMenu.getLabel(), actionMenu.getIcon());
        item.setMnemonic(actionMenu.getMnemonic());
        item.addActionListener(actionMenu);
        return item;
    }


    public JMenu buildMenu(String label, int mnemonic) {
        JMenu menu = new JMenu(label);
        menu.setMnemonic(mnemonic);
        return menu;
    }
}
