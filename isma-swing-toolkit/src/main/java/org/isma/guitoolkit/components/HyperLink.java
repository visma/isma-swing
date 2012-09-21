package org.isma.guitoolkit.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.BLUE;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Cursor.getPredefinedCursor;

public class HyperLink extends JLabel {
    private List<ActionListener> leftActionListenerList = new ArrayList<ActionListener>();
    private List<ActionListener> rightActionListenerList = new ArrayList<ActionListener>();
    private String prefixName;


    public HyperLink(String text) {
        this(text, null);
        setText(text);
    }

    public HyperLink(String text, String prefixName) {
        this();
        this.prefixName = prefixName;
        setText(text);
    }

    public HyperLink() {
        setForeground(BLUE);
        setCursor(getPredefinedCursor(HAND_CURSOR));

        addMouseListener(new LinkMouseListener(this, leftActionListenerList, rightActionListenerList));
    }


    @Override
    public void setText(String text) {
        setName(prefixName == null ? "link." + text : prefixName + ".link." + text);
        super.setText("<html><u>" + text + "</u></html>");
    }


    public void addLeftActionListener(ActionListener actionListener) {
        this.leftActionListenerList.add(actionListener);
    }


    public void addRightActionListener(ActionListener actionListener) {
        this.rightActionListenerList.add(actionListener);
    }


    public void removeLeftActionListener(ActionListener actionListener) {
        this.leftActionListenerList.remove(actionListener);
    }


    public void removeAllActionListeners() {
        this.leftActionListenerList.clear();
    }


    private static class LinkMouseListener extends MouseAdapter {
        private JLabel label;
        private final List<ActionListener> leftActions;
        private final List<ActionListener> rightActions;
        private Color oldForeground;


        private LinkMouseListener(JLabel label,
                                  List<ActionListener> leftActions,
                                  List<ActionListener> rightActions) {
            this.label = label;
            this.leftActions = leftActions;
            this.rightActions = rightActions;
        }


        @Override
        public void mouseClicked(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                for (ActionListener action : leftActions) {
                    action.actionPerformed(new ActionEvent(label, 0, null));
                }
            }
            if (event.getButton() == MouseEvent.BUTTON3) {
                for (ActionListener action : rightActions) {
                    action.actionPerformed(new ActionEvent(label, 0, null));
                }
            }
            //TODO bidouille pour checker le click middle avec les tr
            if (event.getButton() == MouseEvent.BUTTON2) {
                for (ActionListener action : rightActions) {
                    action.actionPerformed(new ActionEvent(label, 0, null));
                }
            }
        }


        @Override
        public void mouseEntered(MouseEvent event) {
            oldForeground = label.getForeground();
            label.setForeground(oldForeground.darker().darker());
        }


        @Override
        public void mouseExited(MouseEvent event) {
            label.setForeground(oldForeground);
        }
    }
}