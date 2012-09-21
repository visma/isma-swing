package org.isma.core.components;

import org.isma.core.ApplicationContext;
import org.isma.core.Configuration;
import org.isma.core.actions.AboutAction;
import org.isma.core.actions.HelpAction;
import org.isma.core.actions.QuitAction;
import org.isma.core.actions.TodoAction;
import org.isma.core.event.IApplicationMenuBar;

import javax.swing.*;
import java.awt.event.KeyEvent;

public abstract class AbstractApplicationMenuBar<C extends Configuration> extends JMenuBar
      implements IApplicationMenuBar {
    protected ApplicationContext<C> context;

    protected MenuBuilder menuBuilder = new MenuBuilder();
    protected JMenu fileMenu;
    protected JMenu helpMenu;
    protected JMenuItem quitMenuItem;


    protected AbstractApplicationMenuBar(ApplicationContext<C> context) {
        this.context = context;
    }


    public void build() {
        buildFileMenu();
        buildHelpMenu();
        add(fileMenu);
        add(helpMenu);
    }


    protected void fillHelpMenu() {
    }


    protected void fillFileMenu() {
    }


    private void buildFileMenu() {
        fileMenu = menuBuilder.buildMenu("Fichier", KeyEvent.VK_F);
        fillFileMenu();
        quitMenuItem = menuBuilder.buildMenuItem(buildQuitAction());
        fileMenu.add(quitMenuItem);
    }


    protected QuitAction buildQuitAction() {
        return new QuitAction();
    }


    private void buildHelpMenu() {
        helpMenu = menuBuilder.buildMenu("Help", KeyEvent.VK_H);
        fillHelpMenu();
        helpMenu.add(menuBuilder.buildMenuItem(new TodoAction(context.getMainFrame())));
        helpMenu.add(menuBuilder.buildMenuItem(new HelpAction(context.getMainFrame())));
        helpMenu.add(menuBuilder.buildMenuItem(new AboutAction(context)));
    }


    public JMenu getFileMenu() {
        return fileMenu;
    }


    public JMenuItem getQuitMenuItem() {
        return quitMenuItem;
    }
}
