package org.skypro.skyshop;

import org.skypro.skyshop.product.*;

import java.util.*;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(new SimpleProduct("Масло", 100));
        searchEngine.add(new SimpleProduct("Хлеб", 10));
        searchEngine.add(new SimpleProduct("Картошка", 50));
        searchEngine.add(new SimpleProduct("Картошка для жарки", 43));
        searchEngine.add(new SimpleProduct("Картошка красная", 53));
        searchEngine.add(new Article("Война и мир 1", "Школьная литература"));
        searchEngine.add(new Article("Война и мир 2", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Книга по Java", "Учебник по Java"));


        System.out.println();
        //searchEngine.printProducts();
        System.out.println();
        searchEngine.printSearchResultsSortedByNameLength("картошка");
        System.out.println();
        try {
            searchEngine.remove("Пирог");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.remove("Масло");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        String missingName = "Масло";
        if (searchEngine.contains(missingName)) {
            System.out.println("В корзине '" + missingName + "' есть.");
        } else {
            System.out.println("В корзине '" + missingName + "' отсутствует.");
        }
        searchEngine.searchPrint("Картошка");
    }
}

