package org.isma.core.logic;

import org.isma.core.ApplicationContext;
import org.isma.core.Configuration;

public abstract class AbstractLogic<C extends Configuration> implements ILogic {
    protected final ApplicationContext<C> context;


    protected AbstractLogic(ApplicationContext<C> context) {
        this.context = context;
    }
}
