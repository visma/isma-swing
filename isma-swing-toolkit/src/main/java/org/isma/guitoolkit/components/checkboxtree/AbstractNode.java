package org.isma.guitoolkit.components.checkboxtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;
public abstract class AbstractNode<C extends AbstractNode, V extends NodeVisitor>
      implements ComponentBean<C, V> {
    private final List<C> children;
    private AbstractNode parent = null;


    protected AbstractNode() {
        this(new ArrayList<C>());
    }


    protected AbstractNode(List<C> children) {
        this.children = children;
    }


    public void accept(V visitor) throws Exception {
        doAccept(visitor);
        if (visitor.propagateToChildren()) {
            for (C childNode : getChildren()) {
                childNode.accept(visitor);
            }
        }
    }


    protected abstract void doAccept(V visitor);


    public void addChild(C treeNode) {
        treeNode.setParent(this);
        children.add(treeNode);
    }


    public void removeChild(C bean) {
        C removedBean = children.remove(children.indexOf(bean));
        removedBean.setParent(null);
    }


    public List<C> getChildren() {
        return children;
    }


    public boolean isLeaf() {
        return getChildren().isEmpty();
    }


    private void setParent(AbstractNode parent) {
        this.parent = parent;
    }


    public AbstractNode getParent() {
        return parent;
    }


    public void sortChildren(Comparator<C> comparator) {
        sort(children, comparator);
    }
}
