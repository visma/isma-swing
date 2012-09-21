package org.isma.guitoolkit.components.checkboxtree;

import java.util.ArrayList;
import java.util.List;

public class CheckedNodeVisitor implements NodeVisitor {
    private List<CheckableNode> treeNodeList;
    private final boolean onlySelected;


    public CheckedNodeVisitor(boolean onlySelected) {
        this.onlySelected = onlySelected;
    }




    public boolean propagateToChildren() {
        return true;
    }


    public void visit(CheckableNode node) {
        if (!onlySelected || node.isSelected()/* && node.isLeaf()*/) {
            treeNodeList.add(node);
        }
    }


    public List<CheckableNode> getSelectedNodes(CheckableNode root) throws Exception {
        treeNodeList = new ArrayList<CheckableNode>();
        root.accept(this);
        return treeNodeList;
    }
}
