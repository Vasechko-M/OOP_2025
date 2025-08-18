package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private Map<String, Set<Searchable>> items = new LinkedHashMap<>();

    public SearchEngine() {

    }
    public void add(Searchable item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        String name = item.getName();
        Set<Searchable> set = (Set<Searchable>) items.getOrDefault(name, new LinkedHashSet<>());
        if (set.contains(item)) {
            throw new IllegalStateException("Этот элемент уже есть");
        }
        set.add(item);
        items.putIfAbsent(name, set);
    }
    public Set<Searchable> search(String name) {
        Set<Searchable> results = new HashSet<>();
        String lowerCaseName = name.toLowerCase();

        for (Map.Entry<String, Set<Searchable>> entry : items.entrySet()) {
            String key = entry.getKey().toLowerCase(); //
            if (key.contains(lowerCaseName)) {
                results.addAll(entry.getValue());
            }
        }

        return results;
    }

    public void searchPrint(String name) {
        Set<Searchable> results = search(name);
        if (results.isEmpty()) {
            System.out.println("Нет результатов для поиска '" + name + "'.");
        } else {
            System.out.println("Найденные результаты для '" + name + "':");
            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Set<Searchable> itemList : items.values()) {
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
    public void printProducts() {
        for (Map.Entry<String, Set<Searchable>> entry : items.entrySet()) {
            for (Searchable product : entry.getValue()) {
                System.out.println(product.getStringRepresentation());
            }
        }
    }
    public TreeSet<Searchable> searchAndSortByNameLengthDesc(String query) {
        TreeSet<Searchable> resultSet = new TreeSet<>(new SearchableComparator());
        String lowerCaseQuery = query.toLowerCase();
        for (Set<Searchable> searchableSet : items.values()) {
            for (Searchable item : searchableSet) {
                if (item != null) {
                    String searchTerm = item.getSearchTerm();
                    if (searchTerm != null && searchTerm.toLowerCase().contains(lowerCaseQuery)) {
                        resultSet.add(item);
                    }
                }
            }
        }
        System.out.println("Найденные результаты: " + resultSet.size());
        return resultSet;
    }
    public void printSearchResultsSortedByNameLength(String query) {
        Set<Searchable> results = searchAndSortByNameLengthDesc(query);
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }
    public void remove(String name) {
        if (!items.containsKey(name)) {
            throw new NoSuchElementException("Продукт '" + name + "' не найден");
        }
        items.remove(name);
    }
    public boolean contains(String name) {
        return items.containsKey(name);
    }
}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof SearchEngine)) return false;
//        SearchEngine that = (SearchEngine) o;
//        return Objects.equals(items, that.items);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(items);
//    }

