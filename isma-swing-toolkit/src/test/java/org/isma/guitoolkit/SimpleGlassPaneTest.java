package org.isma.guitoolkit;

import org.uispec4j.UISpecTestCase;

import javax.swing.*;

public class SimpleGlassPaneTest extends UISpecTestCase {

    public void testConstruction() throws Exception {
        JPanel panel = new SimpleGlassPane();
        assertEquals("waitingPanel", panel.getName());
        assertFalse(panel.isVisible());
        assertFalse(panel.isOpaque());
    }
}
