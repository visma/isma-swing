package org.isma.core;

import javax.swing.*;
public interface ApplicationContext<C extends Configuration> {
    public String getApplicationName();


    public String getApplicationDescription();


    public ImageIcon getApplicationImageIcon();


    public String getApplicationVersion();


    public String getApplicationJavaVersion();


    public C getConfiguration();


    public <T> T getGlobalComponent(Class<T> aClass);


    public JFrame getMainFrame();
}
