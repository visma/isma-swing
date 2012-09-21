package org.isma.guitoolkit.util;

import javax.swing.*;

public class JTreeUtils {
    private JTreeUtils() {
    }


    public static void expandAll(JTree tree) {
        long start = System.currentTimeMillis();
        int row = 0;

        while (row < tree.getRowCount()) {
            tree.expandRow(row);
            row++;
        }
        long end = System.currentTimeMillis();
        long second = (end - start) / 1000;
        //sans optim 1) 23s 2) 17s 3) 17s 4) 16s 5) 16s
        System.out.println("expandAll time ellapsed : " + second);
    }


    public static void collapseAll(JTree tree) {
        int row = tree.getRowCount() - 1;
        while (row >= 0) {
            tree.collapseRow(row);
            row--;
        }
    }
}
