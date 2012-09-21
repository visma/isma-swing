package org.isma.guitoolkit.util;

import java.awt.*;

//TODO foutre ça sur toutes les applications ou trouver un moyen de faire un System.exit() sur la fermeture de la mainFrame sans que ça interfere sur codjo-release-test
public class RedAlertThread extends Thread {
    private static final int FLASH_DURATION = 500;
    private static final int THREAD_DURATION = 10 * FLASH_DURATION;
    private final Component component;


    public RedAlertThread(Component component) {
        this.component = component;
    }


    @Override
    public void run() {
        long end = System.currentTimeMillis() + THREAD_DURATION;
        synchronized (component) {
            long current = System.currentTimeMillis();
            Color normalBg = component.getBackground();
            Color normalFg = component.getForeground();
            Color flashBg = Color.RED;
            Color flashFg = Color.WHITE;
            try {
                while (current < end) {
                    component.setBackground(flashBg);
                    component.setForeground(flashFg);
                    Thread.sleep(FLASH_DURATION);

                    component.setBackground(normalBg);
                    component.setForeground(normalFg);
                    Thread.sleep(FLASH_DURATION);

                    current = System.currentTimeMillis();
                }
            }
            catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            finally {
                component.setBackground(normalBg);
                component.setForeground(normalFg);
            }
        }
    }
}