package org.isma.guitoolkit.components;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TestableFileChooser extends JFileChooser {
    private static final String FILE_TEXT_FIELD = "FILE_TEXT_FIELD";
    private static final String FILE_COMBO_BOX = "FILE_COMBO_BOX";
    private static final String OPEN_BUTON = "OPEN_BUTON";


    public TestableFileChooser(File currentDirectoryPath) {
        this();
        setCurrentDirectory(currentDirectoryPath);
    }


    public TestableFileChooser() {
        System.out.println("=>" + getComponentCount());
        getJComponent(this, JTextField.class).setName(FILE_TEXT_FIELD);
        getJComponent(this, JComboBox.class).setName(FILE_COMBO_BOX);
        getJComponent(this, JButton.class).setName(OPEN_BUTON);
    }


    private <E extends JComponent> E getJComponent(Container container, Class<E> jComponentClass) {
        E jComponent = null;
        for (Component component : container.getComponents()) {
            if (jComponentClass.isInstance(component)) {
                jComponent = jComponentClass.cast(component);
                break;
            }
            else if (component instanceof Container) {
                jComponent = getJComponent((Container)component, jComponentClass);
                if (jComponent != null) {
                    return jComponent;
                }
            }
        }
        return jComponent;
    }
}
