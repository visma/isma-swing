package org.isma.core.help.about.logic;

import org.isma.core.ApplicationContext;
import org.isma.core.help.about.gui.AboutForm;
import org.isma.core.logic.ILogic;

import javax.swing.*;

public class AboutLogic implements ILogic {
    private AboutForm form;


    public AboutLogic(ApplicationContext context) {
        form = new AboutForm();
        String applicationName = context.getApplicationName();
        String applicationVersion = context.getApplicationVersion();
        String applicationJavaVersion = context.getApplicationJavaVersion();
        String applicationDescription = context.getApplicationDescription();

        form.getAboutLabel().setText(applicationDescription);
        form.getNameLabel().setText(String.format("<html><b>Name : </b>%s</html>", applicationName));
        form.getVersionLabel().setText(String.format("<html><b>Version : </b>%s</html>", applicationVersion));
        form.getJavaVersionLabel().setText(String.format("<html><b>Jvm : </b>%s</html>", applicationJavaVersion));
    }


    public JPanel getGui() {
        return form.getMainPanel();
    }
}
