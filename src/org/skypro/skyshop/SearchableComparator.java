package org.skypro.skyshop;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return 1;
        if (s2 == null) return -1;

        int lengthComparison = Integer.compare(s2.getStringRepresentation().length(), s1.getStringRepresentation().length());

        if (lengthComparison != 0) {
            return lengthComparison;
        } else {
            return s1.getStringRepresentation().compareTo(s2.getStringRepresentation());
        }
    }
}
