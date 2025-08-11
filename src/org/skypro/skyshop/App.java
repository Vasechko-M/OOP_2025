package org.skypro.skyshop;

import org.skypro.skyshop.product.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
//        ProductBasket basket = new ProductBasket();
//        System.out.println("=====Добавляем продукты в корзину=======");
//        basket.addProduct(new SimpleProduct("Масло", 1));
//        basket.addProduct(new SimpleProduct("Хлеб", 10));
//        basket.addProduct(new SimpleProduct("Картошка", 50));
//        basket.addProduct(new SimpleProduct("Макароны", 70));
//        basket.addProduct(new SimpleProduct("Гречка", 90));
//        try {
//            basket.addProduct(new SimpleProduct("Масло", 1));
//        } catch (IllegalStateException e) {
//            System.out.println("Обработка исключения при повторном добавлении: " + e.getMessage());
//        }
//
//
//        System.out.println("===== Удаляем продукт 'Масло' из корзины =====");
//        List<Product> removedProducts = basket.removeProductsByName("Масло");
//        if (removedProducts.isEmpty()) {
//            System.out.println("Список удаленных продуктов пуст");
//        } else {
//            System.out.println("Удаленные продукты:");
//            for (Product p : removedProducts) {
//                System.out.println(p);
//            }
//        }
//
//        System.out.println("\nСодержимое корзины после удаления:");
//        basket.printProducts();
//
//
//        System.out.println("\n===== Попытка удалить несуществующий продукт 'Кефир' =====");
//        List<Product> removedNonExistent = basket.removeProductsByName("Кефир");
//        if (removedNonExistent.isEmpty()) {
//            System.out.println("Список удаленных продуктов пуст");
//        } else {
//            System.out.println("Удаленные продукты:");
//            for (Product p : removedNonExistent) {
//                System.out.println(p);
//            }
//        }
//
//        System.out.println("\nСодержимое корзины после попытки удаления несуществующего продукта:");
//        basket.printProducts();
//
//
//        System.out.println("=====Печать всей корзины=====");
//        basket.printProducts();
//
//        System.out.println("=====Создаем новую корзину=====");
//        ProductBasket householdBasket = new ProductBasket();
//        householdBasket.addProduct(new SimpleProduct("Мыло", 25));
//        householdBasket.addProduct(new SimpleProduct("Порошок", 85));
//        householdBasket.addProduct(new DiscountedProduct("Порошок зубной", 1, 0));
//        householdBasket.addProduct(new FixPriceProduct("Мыло для рук"));
//
//        System.out.println("=====Печать всей корзины=====");
//        householdBasket.printProducts();
//
//        System.out.println("=====Стоимость продуктов в корзине=====");
//        System.out.println(basket.getTotalPrice());
//
//        System.out.println("=====Поиск продукта в корзине, который есть=====");
//        String product = "Масло";
//        System.out.println(basket.findProduct(product));
//
//        System.out.println("=====Поиск продукта в корзине, которого нет=====");
//        product = "Масло";
//        System.out.println(householdBasket.findProduct(product));
//
//        System.out.println("=====Очистка корзины=====");
//        basket.clear();
//
//        System.out.println("=====Печать пустой корзины=====");
//        basket.printProducts();
//
//        System.out.println("=====Стоимость пустой корзины");
//        System.out.println(basket.getTotalPrice());
//
//        System.out.println("=====Поиск продукта в пустой корзине=====");
//        product = "Масло";
//        System.out.println(basket.findProduct(product));
//
//        householdBasket.printProducts();


        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(new SimpleProduct("Масло", 100));
        searchEngine.add(new SimpleProduct("Хлеб", 10));
        searchEngine.add(new SimpleProduct("Картошка", 50));
        searchEngine.add(new SimpleProduct("Картошка красная", 53));
        searchEngine.add(new SimpleProduct("Макароны", 70));
        searchEngine.add(new SimpleProduct("Гречка", 90));


        searchEngine.add(new Article("Война и мир 1", "Школьная литература"));
        searchEngine.add(new Article("Война и мир 2", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Война и мир 3", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Война и мир 4", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Война и мир 5", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Война и мир 6", "Книга для вечернего чтения"));
        searchEngine.add(new Article("Книга по Java", "Учебник по Java"));
        searchEngine.add(new Article("Кулинария", "Рецепты и советы"));




//        List<Searchable> resultsMir = searchEngine.search("мир");
//        System.out.println("Результаты поиска по 'мир':");
//        for (Searchable item : resultsMir) {
//            System.out.println(item.getStringRepresentation());
//        }
//        System.out.println();
//        List<Searchable> resultsKartoshka = searchEngine.search("Картошка");
//        System.out.println("Результаты поиска по 'Картошка':");
//        for (Searchable item : resultsKartoshka) {
//            System.out.println(item.getStringRepresentation());
//        }
//        System.out.println();
//        searchEngine.printSearchResults("мир");
//        searchEngine.printSearchResults("Картошка");
        searchEngine.printSearchResultsList("мир");
        searchEngine.printSearchResultsList("Картошка");



//        ProductBasket basket2 = new ProductBasket();
//        try {
//            basket2.addProduct(new SimpleProduct("Картошка", -50));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
//        }
//
//        try {
//            basket2.addProduct(new SimpleProduct("", 50));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
//            //e.printStackTrace();
//        }
//
//        try {
//            basket2.addProduct(new DiscountedProduct("Варежки", 500,500));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
//        }
//
//        try {
//            basket2.addProduct(null);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
//        }



        SearchEngine engine = new SearchEngine();
        engine.add(new Article("Война и мир.", "Книга для вечернего чтения"));
        engine.add(new SimpleProduct("Война и мир. Книга про войну и мир", 100));
        engine.add(new Article("Книга по Java", "Учебник по Java"));
        engine.add(new Article("Кулинария", "Рецепты и советы"));


        try {
            Searchable bestItem = engine.findBestMatch("dfghj");
            System.out.println("Лучший результат: " + bestItem.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Исключение: " + e.getMessage());
        }

        try {
            engine.add(new Article("Война и мир.", "Книга для вечернего чтения"));
        } catch (IllegalStateException e) {
            System.out.println("Обработка исключения при повторном добавлении: " + e.getMessage());
        }

        System.out.println("Результаты поиска по 'мир' (отсортированные Map):");
        Map<String, List<Searchable>> sortedResultsMir = searchEngine.searchAndSortByName("мир");
        for (Map.Entry<String, List<Searchable>> entry : sortedResultsMir.entrySet()) {
            for (Searchable item : entry.getValue()) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();

        System.out.println("Результаты поиска по 'Картошка' (отсортированные Map):");
        Map<String, List<Searchable>> sortedResultsKartoshka = searchEngine.searchAndSortByName("Картошка");
        for (Map.Entry<String, List<Searchable>> entry : sortedResultsKartoshka.entrySet()) {
            for (Searchable item : entry.getValue()) {
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println();
        searchEngine.printSortedSearchResultsMap("мир");
        searchEngine.printSortedSearchResultsMap("Картошка");
    }
}

