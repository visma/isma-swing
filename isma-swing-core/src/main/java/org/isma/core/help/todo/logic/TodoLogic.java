package org.isma.core.help.todo.logic;

import org.isma.core.help.logic.AbstractDocLogic;

import java.io.IOException;
import java.net.URL;

public class TodoLogic extends AbstractDocLogic {
    public TodoLogic() throws IOException {
    }


    @Override
    protected URL getURLResource() {
        return getClass().getClassLoader().getResource("doc/todo.html");
    }
}
