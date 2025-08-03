package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
        this.size = 0;
    }
    public void add(Searchable item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        } else {
            System.out.println("Массив для поиска переполнен, создайте новый");
        }
    }
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            Searchable item = items[i];
            if (item != null && item.getSearchTerm().contains(query)) {
                results[count] = item;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }
    public void printSearchResults(String query) {
        Searchable[] results = search(query);
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i=0; i < size; i++) {
            Searchable item = items[i];
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
}
