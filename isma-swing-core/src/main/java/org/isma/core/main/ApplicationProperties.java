package org.isma.core.main;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private static final String APPLICATION_PROPERTIES_FILE = "application.properties";
    private static final String APPLICATION_SPLASHSCREEN = "application.splashscreen";
    private static final String APPLICATION_SPLASH_SCREEN_SHOW = "application.splashScreen.show";
    private static final String APPLICATION_SPLASH_SCREEN_DURATION = "application.splashScreen.duration";
    private static final String APPLICATION_TITLE = "application.title";
    private static final String APPLICATION_ICON = "application.icon";
    private static final String APPLICATION_NAME = "application.name";
    private static final String APPLICATION_DESCRIPTION = "application.description";
    private static final String APPLICATION_VERSION = "application.version";
    private Properties props;

    public ApplicationProperties() throws Exception {
        loadProperties();
    }

    private void loadProperties() throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE);
        props = new Properties();
        props.load(stream);
    }

    public String getSplashScreen() {
        return getStringValue(APPLICATION_SPLASHSCREEN);
    }

    public boolean showSplashScreen() {
        return getBooleanValue(APPLICATION_SPLASH_SCREEN_SHOW);
    }

    public long getSplashScreenMinDuration() {
        return getLongValue(APPLICATION_SPLASH_SCREEN_DURATION);
    }


    public String getTitle() {
        return getStringValue(APPLICATION_TITLE);
    }

    public String getIcon() {
        return getStringValue(APPLICATION_ICON);
    }

    public String getApplicationName() {
        return getStringValue(APPLICATION_NAME);
    }

    public String getApplicationDescription() {
        return getStringValue(APPLICATION_DESCRIPTION);
    }

    public String getApplicationVersion() {
        return getStringValue(APPLICATION_VERSION);
    }

    private String getStringValue(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException(String.format("%s property not defined on application properties file", key));
        }
        return props.getProperty(key);
    }

    private Boolean getBooleanValue(String key) {
        return Boolean.parseBoolean(getStringValue(key));
    }

    private Long getLongValue(String key) {
        return Long.parseLong(getStringValue(key));
    }
}
