package org.isma.guitoolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class LogicActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        GuiRunnable guiRunnable = new GuiRunnable() {
            @Override
            public void doRun() throws Exception {
                doAction();
            }
        };
        guiRunnable.start();
    }


    protected abstract void doAction() throws Exception;
}
