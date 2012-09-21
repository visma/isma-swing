package org.isma.core.actions;

import org.isma.core.ApplicationContext;
import org.isma.core.help.about.logic.AboutLogic;
import org.isma.guitoolkit.error.ErrorHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.awt.event.KeyEvent.VK_A;

public class AboutAction extends AbstractDialogAction {
    private ApplicationContext context;


    public AboutAction(ApplicationContext context) {
        super(context.getMainFrame(), "About", context.getApplicationImageIcon(), VK_A);
        this.context = context;
    }


    public void actionPerformed(ActionEvent e) {
        try {
            final ImageIcon imageIcon = context.getApplicationImageIcon();
            displayDialog(new AboutLogic(context).getGui(), "About", imageIcon);
        }
        catch (Exception e1) {
            ErrorHandler.handleException(e1);
        }
    }
}
