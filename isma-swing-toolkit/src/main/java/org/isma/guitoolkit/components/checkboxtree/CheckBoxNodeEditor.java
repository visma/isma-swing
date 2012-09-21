package org.isma.guitoolkit.components.checkboxtree;

import javax.swing.*;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor, ItemListener {
    private CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
    private CheckableNode currentEditingNode;


    public CheckBoxNodeEditor(ActionListener actionListener) {
        renderer.getCheckBox().addItemListener(this);
        renderer.getCheckBox().addActionListener(actionListener);
    }


    public Object getCellEditorValue() {
        currentEditingNode.setSelected(renderer.getCheckBox().isSelected());
        return renderer.getCheckBox().isSelected();
    }


    public Component getTreeCellEditorComponent(JTree tree,
                                                Object value,
                                                boolean selected,
                                                boolean expanded,
                                                boolean leaf,
                                                int row) {

        currentEditingNode = (CheckableNode)value;
        return renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);
    }


    public void itemStateChanged(ItemEvent event) {
        if (stopCellEditing()) {
            fireEditingStopped();
        }
        //TODO voir si cette activation a une utilité fonctionellement parlant...
        //setSelectedOnChildren(currentEditingNode);
    }


    private void setSelectedOnChildren(CheckableNode parent) {
        for (CheckableNode child : parent.getChildren()) {
            child.setSelected(parent.isSelected());
            setSelectedOnChildren(child);
        }
    }
}
