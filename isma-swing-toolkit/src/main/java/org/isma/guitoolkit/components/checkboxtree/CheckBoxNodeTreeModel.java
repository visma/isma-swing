package org.isma.guitoolkit.components.checkboxtree;

import javax.swing.*;
import java.util.List;
public class CheckBoxNodeTreeModel extends CompositeBeanTreeModel {

    public CheckBoxNodeTreeModel(CheckableNode checkBoxNodeRoot, JTree tree) {
        super(checkBoxNodeRoot, tree);
    }


    public List<CheckableNode> getSelectedNodes() throws Exception {
        CheckableNode checkableRoot = (CheckableNode)getRoot();
        return new CheckedNodeVisitor(true).getSelectedNodes(checkableRoot);
    }

    public List<CheckableNode> getAllNodes() throws Exception {
        CheckableNode checkableRoot = (CheckableNode)getRoot();
        return new CheckedNodeVisitor(false).getSelectedNodes(checkableRoot);
    }
}
