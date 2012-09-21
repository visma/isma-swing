package org.isma.guitoolkit.components;

import org.uispec4j.Mouse;
import org.uispec4j.TextBox;
import org.uispec4j.UISpecTestCase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HyperLinkTest extends UISpecTestCase {

    public void testColor() {
        HyperLink link = new HyperLink("toto");
        assertEquals(Color.BLUE, link.getForeground());
    }


    public void testText() {
        HyperLink link = new HyperLink("toto");
        assertEquals("<html><u>toto</u></html>", link.getText());
    }


    public void testName() {
        HyperLink link = new HyperLink("toto");
        assertEquals("link.toto", link.getName());
        link = new HyperLink("toto", "panel1");
        assertEquals("panel1.link.toto", link.getName());
    }


    //TODO pas reussi a faire le click droit avec uispec4j
    public void testLeftClick() {
        HyperLink link = new HyperLink("toto");
        final CountListener leftListener1 = new CountListener();
        final CountListener leftListener2 = new CountListener();
        link.addLeftActionListener(leftListener1);
        link.addLeftActionListener(leftListener2);

        TextBox uiComponent = new TextBox(link);
        Mouse.click(uiComponent);
        assertEquals(1, leftListener1.getCount());
        Mouse.click(uiComponent);
        assertEquals(2, leftListener1.getCount());

        Mouse.doubleClick(uiComponent);
        assertEquals(3, leftListener1.getCount());
        assertEquals(3, leftListener2.getCount());
    }


    private class CountListener implements ActionListener {
        int count = 0;


        public void actionPerformed(ActionEvent e) {
            count++;
        }


        public int getCount() {
            return count;
        }
    }
}
