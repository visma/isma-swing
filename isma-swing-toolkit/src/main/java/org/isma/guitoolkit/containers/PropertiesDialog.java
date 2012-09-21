package org.isma.guitoolkit.containers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class PropertiesDialog extends JDialog {

    public PropertiesDialog(Frame owner, List<SimpleEntry<String, Object>> propertyList) {
        super(owner, "Properties");
        JPanel mainPanel = new JPanel();

        GridLayout layout = new GridLayout(propertyList.size(), 2);
        //setLayout(layout);
        mainPanel.setLayout(layout);
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(mainPanel, BorderLayout.NORTH);
        for (SimpleEntry<String, Object> entry : propertyList) {
            addProperty(mainPanel, entry.getKey(), entry.getValue());
        }
    }


    private void addProperty(JPanel mainPanel, String key, Object obj) {
        JLabel label = new JLabel(key + " : ", JLabel.TRAILING) {
//            @Override
//            public Dimension getPreferredSize() {
//                Dimension preferred = super.getPreferredSize();
//                Dimension minimum = getMinimumSize();
//                Dimension maximum = getMaximumSize();
//                preferred.width = Math.min(Math.max(preferred.width, minimum.width), maximum.width);
//                preferred.height = Math.min(Math.max(preferred.height, minimum.height), maximum.height);
//                return preferred;
//            }
        };
        JLabel value = new JLabel(obj.toString());
        final Font font = value.getFont();
        value.setFont(font.deriveFont(Font.PLAIN));

        label.setHorizontalAlignment(SwingConstants.LEFT);
        value.setHorizontalAlignment(SwingConstants.LEFT);

        label.setMaximumSize(new Dimension(200, 20));
        value.setMaximumSize(new Dimension(200, 20));

        label.setPreferredSize(new Dimension(200,20));
        value.setPreferredSize(new Dimension(200,20));

        label.setOpaque(true);
        value.setOpaque(true);
        label.setBackground(Color.GREEN);
        value.setBackground(Color.YELLOW);
        mainPanel.add(label);
        mainPanel.add(value);
    }


    public static void main(String[] args) {
        List<SimpleEntry<String, Object>> list = new ArrayList<SimpleEntry<String, Object>>();
        list.add(new SimpleEntry<String, Object>("one", "un"));
        list.add(new SimpleEntry<String, Object>("two", "deux"));

        final PropertiesDialog frame = new PropertiesDialog(null, list);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}
