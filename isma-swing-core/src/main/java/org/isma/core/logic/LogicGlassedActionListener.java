package org.isma.core.logic;

import org.isma.core.ApplicationContext;
import org.isma.guitoolkit.GuiRunnable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class LogicGlassedActionListener implements ActionListener {
    protected ApplicationContext context;


    protected LogicGlassedActionListener(ApplicationContext context) {
        this.context = context;
    }


    public void actionPerformed(ActionEvent e) {
        GuiRunnable guiRunnable = new GuiRunnable() {
            @Override
            public void doRun() throws Exception {
                try {
                    context.getMainFrame().getGlassPane().setVisible(true);
                    doAction();
                }
                finally {
                    context.getMainFrame().getGlassPane().setVisible(false);
                }
            }
        };
        guiRunnable.start();
    }


    protected abstract void doAction() throws Exception;
}
