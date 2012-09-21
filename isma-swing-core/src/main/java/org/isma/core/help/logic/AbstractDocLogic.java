package org.isma.core.help.logic;

import org.isma.core.logic.ILogic;
import org.isma.guitoolkit.error.ErrorHandler;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractDocLogic implements ILogic {
    //TODO trouver pourquoi ça marche pas avec mvn package
    //private DocForm form = new DocForm();
    private JPanel form = new JPanel();

    protected AbstractDocLogic() throws IOException {
//        System.out.println("initial sout");
//        if (form.getMainPanel() == null){
//            System.out.println("form.getMainPanel is null");
//        }
//        form.getMainPanel().add(buildEditorPane());
        form.add(buildEditorPane());
    }

    protected abstract URL getURLResource();


    private JScrollPane buildEditorPane() throws IOException {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.addHyperlinkListener(new MyHyperlinkListener());

        //getClass().getClassLoader().getResource("doc/index.html");
        editorPane.setPage(getURLResource());

        //Put the editor pane in a scroll pane.
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 1;
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 1;
        editorScrollPane.setPreferredSize(new Dimension((int)width, (int)height));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));

        return editorScrollPane;
    }


    private static class MyHyperlinkListener implements HyperlinkListener {
        public void hyperlinkUpdate(HyperlinkEvent evt) {
            try {
                if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    JEditorPane pane = (JEditorPane)evt.getSource();
                    URL url = evt.getURL();
                    pane.setPage(url);
                }
            }
            catch (Exception e) {
                ErrorHandler.handleException(e);
            }
        }
    }


    public JPanel getGui() {
        return form;
        //return form.getMainPanel();
    }
}
