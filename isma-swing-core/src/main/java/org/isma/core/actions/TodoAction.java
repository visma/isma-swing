package org.isma.core.actions;

import org.isma.core.help.todo.logic.TodoLogic;
import org.isma.core.icons.CoreIconEnum;
import org.isma.guitoolkit.error.ErrorHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.awt.event.KeyEvent.VK_T;

public class TodoAction extends AbstractDialogAction {
    public TodoAction(JFrame frame) {
        super(frame, "Todo", CoreIconEnum.TODO_ICON.getImageIcon(), VK_T);
    }


    public void actionPerformed(ActionEvent e) {
        try {
            displayDialog(new TodoLogic().getGui(), getLabel(), getIcon());
        }
        catch (Exception e1) {
            ErrorHandler.handleException(e1);
        }
    }
}
