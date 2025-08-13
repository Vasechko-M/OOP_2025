package org.skypro.skyshop;

import java.util.Comparator;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();

    default String getStringRepresentation() {

        return getName() + " — тип " + getContentType();
    }


}
