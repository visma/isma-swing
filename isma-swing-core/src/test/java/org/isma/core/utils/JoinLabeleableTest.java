package org.isma.core.utils;

import junit.framework.TestCase;
import org.isma.utils.Labeleable;

import java.util.ArrayList;
import java.util.List;

import static org.isma.core.utils.JoinLabeleable.join;

public class JoinLabeleableTest extends TestCase {
    private List<MyLabeleable> list = new ArrayList<MyLabeleable>();


    @Override
    public void setUp() throws Exception {
        list.clear();
    }


    public void testEmptyList() throws Exception {
        assertEquals("", join(list, ";"));
    }


    public void testOneElementList() throws Exception {
        list.add(new MyLabeleable("toto"));
        assertEquals("toto", join(list, ";"));
    }


    public void testXElementList() throws Exception {
        list.add(new MyLabeleable("toto"));
        list.add(new MyLabeleable("tata"));
        list.add(new MyLabeleable("tutu"));
        assertEquals("toto;tata;tutu", join(list, ";"));
        assertEquals("toto-tata-tutu", join(list, "-"));
    }


    class MyLabeleable implements Labeleable {
        private String label;


        MyLabeleable(String label) {
            this.label = label;
        }


        public String getLabel() {
            return label;
        }
    }
}
