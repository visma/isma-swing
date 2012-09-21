package org.isma.core.event;

import org.isma.guitoolkit.util.RedAlertThread;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationWindowListener extends WindowAdapter {
    private IApplicationMenuBar menuBar;


    public ApplicationWindowListener(IApplicationMenuBar menuBar) {
        this.menuBar = menuBar;
    }


    @Override
    public void windowClosing(WindowEvent e) {
        new RedAlertThread(menuBar.getFileMenu()).start();
        new RedAlertThread(menuBar.getQuitMenuItem()).start();
    }
}
