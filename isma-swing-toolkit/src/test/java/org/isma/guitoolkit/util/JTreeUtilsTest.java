package org.isma.guitoolkit.util;

import org.uispec4j.Tree;
import org.uispec4j.UISpecTestCase;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class JTreeUtilsTest extends UISpecTestCase {

    public void testExpand() throws Exception {
        JTree jtree = createJTree();
        Tree tree = new Tree(jtree);
        tree.setSeparator("|");
        assertFalse(tree.pathIsExpanded("cars"));
        assertFalse(tree.pathIsExpanded("fruits"));
        assertFalse(tree.pathIsExpanded("apple"));

        JTreeUtils.expandAll(jtree);
        assertTrue(tree.pathIsExpanded("cars"));
        assertTrue(tree.pathIsExpanded("fruits"));
        assertTrue(tree.pathIsExpanded("fruits|apple"));

    }

    public void testCollaspe() throws Exception {
        JTree jtree = createJTree();
        Tree tree = new Tree(jtree);
        tree.setSeparator("|");
        JTreeUtils.expandAll(jtree);
        JTreeUtils.collapseAll(jtree);
        assertFalse(tree.pathIsExpanded("cars"));
        assertFalse(tree.pathIsExpanded("fruits"));
        assertFalse(tree.pathIsExpanded("fruits|apple"));

    }


    private JTree createJTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        DefaultMutableTreeNode carNode = addNode(treeModel, root, "cars", 0);
        DefaultMutableTreeNode fruitNode = addNode(treeModel, root, "fruits", 1);
        addNode(treeModel, carNode, "ferrari", 0);
        addNode(treeModel, carNode, "toyota", 1);
        addNode(treeModel, carNode, "renault", 2);

        DefaultMutableTreeNode appleNode = addNode(treeModel, fruitNode, "apple", 0);
        addNode(treeModel, fruitNode, "banana", 1);
        addNode(treeModel, fruitNode, "grapes", 2);

        addNode(treeModel, appleNode, "golden", 0);
        addNode(treeModel, appleNode, "grannySmith", 1);

        JTree jTree = new JTree(treeModel);
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setTextNonSelectionColor(Color.BLACK);
        jTree.setCellRenderer(cellRenderer);
        return jTree;
    }


    private DefaultMutableTreeNode addNode(DefaultTreeModel treeModel,
                                           DefaultMutableTreeNode parentNode,
                                           Object childBean,
                                           int index) {
        DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(childBean);
        treeModel.insertNodeInto(newChild, parentNode, index);
        return newChild;
    }
}

