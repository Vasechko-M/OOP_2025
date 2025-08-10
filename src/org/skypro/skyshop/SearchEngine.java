package org.skypro.skyshop;

import java.util.*;

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
public Map<String, Searchable> searchAndSortByName(String query) {
    List<Searchable> results = search(query);
    Map<String, Searchable> sortedMap = new TreeMap<>();
    for (Searchable item : results) {
        String name = item.getName();
        sortedMap.put(name, item);
    }
    return sortedMap;
}
    public void printSearchResults(String query) {
        Map<String, Searchable> resultsMap = searchAndSortByName(query);
        for (Map.Entry<String, Searchable> entry : resultsMap.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
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
    public void printSearchResultsList(String query) {
        List<Searchable> results = search(query);
        results.sort(Comparator.comparing(Searchable::getStringRepresentation));
        System.out.println("Результаты поиска по '" + query + "':");
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
        System.out.println();
    }
    public void printSortedSearchResultsMap(String query) { //отдельный метод не просили, поэтому в мэйне 2 варианта (мне это больше нравится, он более универсален)
        System.out.println("Результаты поиска по '" + query + "' (отсортированные Map):");
        Map<String, Searchable> sortedResults = searchAndSortByName(query);
        for (Map.Entry<String, Searchable> entry : sortedResults.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
        }
        System.out.println();
    }
//    public void printResultsMap(Map<String, Searchable> resultsMap) { //для проверки
//        for (Map.Entry<String, Searchable> entry : resultsMap.entrySet()) {
//            System.out.println("Имя: " + entry.getKey() + ", Объект: " + entry.getValue().getStringRepresentation());
//        }
//    }

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
