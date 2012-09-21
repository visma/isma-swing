package org.isma.guitoolkit;

import org.isma.guitoolkit.error.ErrorHandler;
public abstract class GuiRunnable extends Thread {

    @Override
    public void run() {
        try {
            doRun();
        } catch (Exception e) {
            ErrorHandler.handleException(e);
        }
    }


    protected abstract void doRun() throws Exception;
}
