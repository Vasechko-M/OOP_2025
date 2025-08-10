package org.skypro.skyshop;

import java.util.*;

public class SearchEngine {
    private Map<String, List<Searchable>> items;

    public SearchEngine() {
        this.items = new HashMap<>();
    }
    public void add(Searchable item) {
        String name = item.getName();
        List<Searchable> list = items.getOrDefault(name, new ArrayList<>());
        if (list.contains(item)) {
            throw new IllegalStateException("Этот продукт уже есть");
        }
        list.add(item);
        items.put(name, list);
    }
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (List<Searchable> productList : items.values()) {
            for (Searchable product : productList) {
                if (product != null && product.getSearchTerm().contains(query)) {
                    results.add(product);
                }
            }
        }
        return results;
    }
    public Map<String, List<Searchable>> searchAndSortByName(String query) {
        Map<String, List<Searchable>> resultMap = new TreeMap<>();
        for (Map.Entry<String, List<Searchable>> entry : items.entrySet()) {
            String name = entry.getKey();
            List<Searchable> filteredList = new ArrayList<>();
            for (Searchable item : entry.getValue()) {
                if (item != null && item.getSearchTerm().contains(query)) {
                    filteredList.add(item);
                }
            }
            if (!filteredList.isEmpty()) {
                resultMap.put(name, filteredList);
            }
        }
    return resultMap;
}
    public void printSearchResults(String query) {
        Map<String, List<Searchable>> resultsMap = searchAndSortByName(query);
        for (Map.Entry<String, List<Searchable>> entry : resultsMap.entrySet()) {
            for (Searchable item : entry.getValue()) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (List<Searchable> itemList : items.values()) {
            for (Searchable item : itemList) {
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
    public void printSortedSearchResultsMap(String query) {
        System.out.println("Результаты поиска по '" + query + "' (отсортированные Map):");
        Map<String, List<Searchable>> sortedResults = searchAndSortByName(query);
        for (Map.Entry<String, List<Searchable>> entry : sortedResults.entrySet()) {
            for (Searchable item : entry.getValue()) {
                System.out.println(item.getStringRepresentation());
            }
        }
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
