package org.isma.guitoolkit.components.checkboxtree;

import org.isma.utils.Labeleable;
public class CheckableNode extends AbstractNode<CheckableNode, CheckedNodeVisitor> {
    private final Labeleable beanToDisplay;
    private boolean selected;


    public CheckableNode(Labeleable beanToDisplay) {
        this(beanToDisplay, false);
    }


    public CheckableNode(Labeleable beanToDisplay, boolean selected) {
        this.beanToDisplay = beanToDisplay;
        this.selected = selected;
    }


    @Override
    protected void doAccept(CheckedNodeVisitor visitor) {
        visitor.visit(this);
    }


    public boolean isSelected() {
        return selected;
    }


    public void setSelected(boolean newValue) {
        selected = newValue;
    }


    public String getLabel() {
        return beanToDisplay.getLabel();
    }


    public Labeleable getBeanToDisplay() {
        return beanToDisplay;
    }


    @Override
    public String toString() {
        return "CheckableNode{beanToDisplay=" + beanToDisplay + '}';
    }
}

