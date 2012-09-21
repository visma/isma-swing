package org.isma.guitoolkit.error;

import javax.swing.*;

public class ErrorHandler {
    private ErrorHandler() {
    }


    public static void handleException(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
