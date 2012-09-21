package org.isma.core.utils;

import org.apache.commons.lang.StringUtils;
import org.isma.utils.Labeleable;

import java.util.List;

public class JoinLabeleable {
    private JoinLabeleable() {
    }


    public static <L extends Labeleable> String join(List<L> labeleableList, String separator) {
        String[] strings = new String[labeleableList.size()];
        for (int i = 0; i < labeleableList.size(); i++) {
            strings[i] = labeleableList.get(i).getLabel();
        }
        return StringUtils.join(strings, separator);
    }


    public static <L extends Labeleable> String join(List<L> labeleableList) {
        return join(labeleableList, ", ");
    }
}
