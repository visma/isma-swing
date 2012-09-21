package org.isma.guitoolkit.components.checkboxtree;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
public class CheckBoxNodeRenderer implements TreeCellRenderer {

    private JCheckBox checkBox = new JCheckBox();


    public CheckBoxNodeRenderer() {
        checkBox.setOpaque(false);
    }


    protected JCheckBox getCheckBox() {
        return checkBox;
    }


    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object value,
                                                  boolean selected,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus) {

        CheckableNode node = (CheckableNode)value;
        checkBox.setText(node.getLabel());
        checkBox.setSelected(node.isSelected());
        return checkBox;
    }
}
