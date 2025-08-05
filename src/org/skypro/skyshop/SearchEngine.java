package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> items;

    public SearchEngine() {
        this.items = new ArrayList<>();
    }
    public void add(Searchable item) {
        for (Searchable existingItem : items) {
            if (existingItem.equals(item)) {
                throw new IllegalStateException("Эта статья уже есть");
            }
        }
        items.add(item);
    }
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query)) {
                results.add(item);
                }
            }
        return results;
    }
    public void printSearchResults(String query) {
        List<Searchable> results = search(query);
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null) {
                String term = item.getSearchTerm();
                int count = countOccurrences(term, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                    System.out.println("Количество совпадений: " + maxCount);
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Подходящая статья не найдена для запроса: \"" + search + "\"");
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String sub) {
        int count=0, index=0;
        while ((index=str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchEngine)) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
