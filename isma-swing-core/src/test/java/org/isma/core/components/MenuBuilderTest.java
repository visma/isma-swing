package org.isma.core.components;

import org.isma.core.event.AbstractActionMenu;
import org.isma.core.icons.CoreIconEnum;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static junit.framework.Assert.*;

public class MenuBuilderTest {
    private MenuBuilder menuBuilder = new MenuBuilder();


    @Test
    public void testMenuBuilding() throws Exception {
        JMenu menu = menuBuilder.buildMenu("toto", KeyEvent.VK_A);
        assertEquals("toto", menu.getText());
        assertEquals(KeyEvent.VK_A, menu.getMnemonic());
    }


    @Test
    public void testMenuItemBuilding() throws Exception {
        final ImageIcon helpIcon = CoreIconEnum.HELP_ICON.getImageIcon();
        assertNotNull(helpIcon);
        MyHelpActionMenu helpActionMenu = new MyHelpActionMenu(helpIcon);

        JMenuItem menuItem = menuBuilder.buildMenuItem(helpActionMenu);
        assertEquals("Help", menuItem.getText());
        assertEquals(KeyEvent.VK_H, menuItem.getMnemonic());
        assertEquals(helpIcon, menuItem.getIcon());
        assertFalse(helpActionMenu.isActionDone());

        helpActionMenu.actionPerformed(null);
        assertTrue(helpActionMenu.isActionDone());
    }


    class MyHelpActionMenu extends AbstractActionMenu {
        private boolean actionDone = false;


        MyHelpActionMenu(ImageIcon helpIcon) {
            super("Help", helpIcon, KeyEvent.VK_H);
        }


        public void actionPerformed(ActionEvent e) {
            actionDone = true;
        }


        public boolean isActionDone() {
            return actionDone;
        }
    }
}
