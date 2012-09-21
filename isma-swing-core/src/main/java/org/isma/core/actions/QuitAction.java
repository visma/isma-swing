package org.isma.core.actions;

import org.isma.core.event.AbstractActionMenu;
import org.isma.core.icons.CoreIconEnum;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class QuitAction extends AbstractActionMenu {
    public QuitAction() {
        super("Quitter", CoreIconEnum.SHUTDOWN_ICON.getImageIcon(), KeyEvent.VK_Q);
    }


    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
