package org.isma.core.main;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import org.isma.core.ApplicationContext;
import org.isma.core.Configuration;
import org.isma.core.event.ApplicationWindowListener;
import org.isma.core.logic.IMenuBarLogic;
import org.isma.guitoolkit.SplashScreenFrameBuilder;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractApplicationLauncher<C extends Configuration, L extends IMenuBarLogic>
      implements ApplicationContext<C> {
    protected MutablePicoContainer picoContainer = new DefaultPicoContainer();
    private Properties props;
    protected C conf;
    private JFrame mainFrame;
    private L mainLogic;


    protected AbstractApplicationLauncher() throws Exception {
        loadProperties();
        conf = buildConfiguration();
        registerImplementations();
    }


    protected abstract C buildConfiguration() throws Exception;


    protected void registerImplementations() {
    }


    public <T> T getGlobalComponent(Class<T> aClass) {
        return (T)picoContainer.getComponentInstanceOfType(aClass);
    }


    protected void loadProperties() throws Exception {
        InputStream stream = Class.forName(getClass().getName()).getResourceAsStream("application.properties");
        props = new Properties();
        props.load(stream);
    }


    protected void launch() throws Exception {
        UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());

        loadApplication();

        mainFrame = new JFrame(getTitle());
        configureMainFrame(mainFrame);
        mainLogic = buildMainLogic(mainFrame);

        mainFrame.addWindowListener(new ApplicationWindowListener(mainLogic.getMenuBar()));

        mainFrame.setContentPane(mainLogic.getGui());
        mainFrame.setIconImage(getApplicationImageIcon().getImage());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }


    protected void configureMainFrame(JFrame mainFrame) {
    }


    protected boolean mustDisplaySplashScreen() {
        return false;
    }


    private void loadApplication() throws Exception {
        JFrame splashFrame = null;
        if (mustDisplaySplashScreen()) {
            splashFrame = SplashScreenFrameBuilder.build(getSplashScreenImageIcon());
            splashFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
           
        }
        loadBeforeUI();
        if (mustDisplaySplashScreen()) {
            splashFrame.dispose();
        }
    }


    protected void loadBeforeUI() throws Exception {
        Thread.sleep(500);
    }


    protected ImageIcon getSplashScreenImageIcon() {
        return new ImageIcon(getClass().getResource(props.getProperty("application.splashscreen")));
    }


    public L getMainLogic() {
        return mainLogic;
    }


    private String getTitle() {
        return props.getProperty("application.title");
    }


    public ImageIcon getApplicationImageIcon() {
        String iconPath = props.getProperty("application.icon");
        return new ImageIcon(getClass().getResource(iconPath));
    }


    protected abstract L buildMainLogic(JFrame frame) throws Exception;


    public String getApplicationName() {
        return props.getProperty("application.name");
    }


    public String getApplicationDescription() {
        return props.getProperty("application.description");
    }


    public String getApplicationVersion() {
        return props.getProperty("application.version");
    }


    public String getApplicationJavaVersion() {
        return System.getProperties().getProperty("java.runtime.version");
    }


    public C getConfiguration() {
        return conf;
    }


    public JFrame getMainFrame() {
        return mainFrame;
    }
}
