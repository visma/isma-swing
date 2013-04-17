package org.isma.core.main;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import org.isma.core.ApplicationContext;
import org.isma.core.Configuration;
import org.isma.core.event.ApplicationWindowListener;
import org.isma.core.logic.IMenuBarLogic;
import org.isma.guitoolkit.SplashScreenFrameBuilder;
import org.isma.utils.OsValidator;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractApplicationLauncher<C extends Configuration, L extends IMenuBarLogic>
        implements ApplicationContext<C> {
    private final ApplicationProperties properties;
    protected MutablePicoContainer picoContainer = new DefaultPicoContainer();
    protected final C conf;
    private JFrame mainFrame;
    private L mainLogic;


    protected AbstractApplicationLauncher() throws Exception {
        properties = new ApplicationProperties();
        conf = buildConfiguration();
        registerImplementations();
    }


    protected abstract C buildConfiguration() throws Exception;


    protected void registerImplementations() {
    }


    public <T> T getGlobalComponent(Class<T> aClass) {
        return (T) picoContainer.getComponentInstanceOfType(aClass);
    }


    protected void launch() throws Exception {
        setLookAndFeel();

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

    private void setLookAndFeel() throws UnsupportedLookAndFeelException {
        if (OsValidator.isWindows()){
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
        }
    }


    protected void configureMainFrame(JFrame mainFrame) {
    }


    protected boolean showSplashScreen() {
        return properties.showSplashScreen();
    }


    private void loadApplication() throws Exception {
        if (showSplashScreen()) {
            JFrame splashFrame = SplashScreenFrameBuilder.build(getSplashScreenImageIcon());
            splashFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            loadBeforeUI();
            killSplashScreen(splashFrame);
        }
    }

    protected void loadBeforeUI() {
        ;
    }

    private void killSplashScreen(JFrame splashFrame) throws InterruptedException {
        Thread.sleep(properties.getSplashScreenMinDuration());
        splashFrame.dispose();
    }


    protected ImageIcon getSplashScreenImageIcon() {
        return new ImageIcon(getClass().getResource(properties.getSplashScreen()));
    }


    public L getMainLogic() {
        return mainLogic;
    }


    private String getTitle() {
        return properties.getTitle();
    }


    public ImageIcon getApplicationImageIcon() {
        String iconPath = properties.getIcon();
        return new ImageIcon(getClass().getResource(iconPath));
    }


    protected abstract L buildMainLogic(JFrame frame) throws Exception;


    public String getApplicationName() {
        return properties.getApplicationName();
    }


    public String getApplicationDescription() {
        return properties.getApplicationDescription();
    }


    public String getApplicationVersion() {
        return properties.getApplicationVersion();
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
