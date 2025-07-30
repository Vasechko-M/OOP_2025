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
}
