package org.isma.guitoolkit.error;
import org.uispec4j.Trigger;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

public class ErrorHandlerTest extends UISpecTestCase {

    public void testHandleError() throws Exception {

        WindowInterceptor.init(new Trigger() {
            public void run() throws Exception {
                ErrorHandler.handleException(new Exception("toto"));
            }
        }).process(new WindowHandler() {
            @Override
            public Trigger process(Window window) throws Exception {
                assertEquals("Error", window.getTitle());
                window.containsLabel("toto").check();
                window.isModal().check();
                window.isVisible().check();
                return window.getButton().triggerClick();
            }
        }).run();
    }
}
