package org.isma.guitoolkit.components.checkboxtree;

import java.util.Comparator;
import java.util.List;
public interface ComponentBean<T extends ComponentBean, V extends NodeVisitor> {

    void addChild(T bean);


    void removeChild(T bean);


    List<T> getChildren();


    void accept(V nodeVisitor) throws Exception;


    boolean isLeaf();


    void sortChildren(Comparator<T> comparator);


    ComponentBean getParent();
}
