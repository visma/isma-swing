package org.isma.guitoolkit.components.checkboxtree;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;
public class CompositeBeanTreeModel implements TreeModel {

    private ComponentBean root;

    protected final List<TreeModelListener> listenerList = new ArrayList<TreeModelListener>();

    private final JTree tree;


    public CompositeBeanTreeModel(ComponentBean root, JTree tree) {
        this(tree);
        this.root = root;
    }


    public CompositeBeanTreeModel(JTree tree) {
        this.tree = tree;
    }


    public Object getRoot() {
        return root;
    }


    public void setRoot(ComponentBean root) {
        this.root = root;
        nootifyChange(root);
    }


    public Object getChild(Object parent, int index) {
        return ((ComponentBean)parent).getChildren().get(index);
    }


    public int getChildCount(Object parent) {
        return ((ComponentBean)parent).getChildren().size();
    }


    public boolean isLeaf(Object node) {
        return ((ComponentBean)node).getChildren().isEmpty();
    }


    public int getIndexOfChild(Object parent, Object child) {
        return ((ComponentBean)parent).getChildren().indexOf(child);
    }


    public void valueForPathChanged(TreePath path, Object newValue) {
        tree.updateUI();
    }


    public void addTreeModelListener(TreeModelListener listener) {
        listenerList.add(listener);
    }


    public void removeTreeModelListener(TreeModelListener listener) {
        listenerList.remove(listener);
    }


    public void nootifyChange(ComponentBean... path) {
        TreeModelEvent event = new TreeModelEvent(this, path);
        for (TreeModelListener listener : listenerList) {
            listener.treeStructureChanged(event);
        }
    }
}