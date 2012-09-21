package org.isma.core.help.help.logic;

import org.isma.core.help.logic.AbstractDocLogic;

import java.io.IOException;
import java.net.URL;

public class HelpLogic extends AbstractDocLogic {
    public HelpLogic() throws IOException {
    }


    @Override
    protected URL getURLResource() {
        return getClass().getClassLoader().getResource("doc/index.html");
    }
}
