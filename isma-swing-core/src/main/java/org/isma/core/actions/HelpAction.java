package org.isma.core.actions;

import org.isma.core.help.help.logic.HelpLogic;
import org.isma.core.icons.CoreIconEnum;
import org.isma.guitoolkit.error.ErrorHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.awt.event.KeyEvent.VK_H;

public class HelpAction extends AbstractDialogAction {
    public HelpAction(JFrame frame) {
        super(frame, "Help", CoreIconEnum.HELP_ICON.getImageIcon(), VK_H);
    }


    public void actionPerformed(ActionEvent e) {
        try {
            displayDialog(new HelpLogic().getGui(), getLabel(), getIcon());
        }
        catch (Exception e1) {
            ErrorHandler.handleException(e1);
        }
    }
}
