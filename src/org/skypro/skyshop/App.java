package org.skypro.skyshop;

import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        ProductBasket basket = new ProductBasket();
        System.out.println("=====Добавляем продукты в корзину до предела=======");
        basket.addProduct(new SimpleProduct("Масло", 1));
        basket.addProduct(new SimpleProduct("Хлеб", 10));
        basket.addProduct(new SimpleProduct("Картошка", 50));
        basket.addProduct(new SimpleProduct("Макароны", 70));
        basket.addProduct(new SimpleProduct("Гречка", 90));
        System.out.println("=====Пытаемся добавить в полную корзину продукт=====");
        basket.addProduct(new SimpleProduct("Яблоки", 40));
        System.out.println("=====Печать всей корзины=====");
        basket.printProducts();
        System.out.println("=====Создаем новую корзину=====");
        ProductBasket householdBasket = new ProductBasket();
        householdBasket.addProduct(new SimpleProduct("Мыло", 25));
        householdBasket.addProduct(new SimpleProduct("Порошок", 85));
        householdBasket.addProduct(new DiscountedProduct("Порошок зубной", 1, 0));
        householdBasket.addProduct(new FixPriceProduct("Мыло для рук"));
        System.out.println("=====Печать всей корзины=====");
        householdBasket.printProducts();
        System.out.println("=====Стоимость продуктов в корзине=====");
        System.out.println(basket.getTotalPrice());
        System.out.println("=====Поиск продукта в корзине, который есть=====");
        String product = "Масло";
        System.out.println(basket.findProduct(product));
        System.out.println("=====Поиск продукта в корзине, которого нет=====");
        product = "Масло";
        System.out.println(householdBasket.findProduct(product));
        System.out.println("=====Очистка корзины=====");
        basket.clear();
        System.out.println("=====Печать пустой корзины=====");
        basket.printProducts();
        System.out.println("=====Стоимость пустой корзины");
        System.out.println(basket.getTotalPrice());
        System.out.println("=====Поиск продукта в пустой корзине=====");
        product = "Масло";
        System.out.println(basket.findProduct(product));
        householdBasket.printProducts();


        SearchEngine searchEngine = new SearchEngine(20);


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



        System.out.println("Результаты поиска по 'мир':");
        System.out.println(Arrays.toString(searchEngine.search("мир")));
        System.out.println();
        System.out.println("Результаты поиска по 'Картошка':");
        System.out.println(Arrays.toString(searchEngine.search("Картошка")));
        System.out.println();
        searchEngine.printSearchResults("мир");
        searchEngine.printSearchResults("Картошка");


        ProductBasket basket2 = new ProductBasket();
        try {
            basket2.addProduct(new SimpleProduct("Картошка", -50));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
        }

        try {
            basket2.addProduct(new SimpleProduct("", 50));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
            //e.printStackTrace();
        }

        try {
            basket2.addProduct(new DiscountedProduct("Варежки", 500,500));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: "  + e.getMessage());
        }


        SearchEngine engine = new SearchEngine(10);
        engine.add(new Article("Война и мир.", "Книга для вечернего чтения"));
        engine.add(new SimpleProduct("Война и мир. Книга про войну и мир", 100));
        engine.add(new Article("Книга по Java", "Учебник по Java"));
        engine.add(new Article("Кулинария", "Рецепты и советы"));
        Searchable bestItem = engine.findBestMatch("dfghjk");
        if (bestItem != null) {
            System.out.println("Лучший результат: " + bestItem.getStringRepresentation());
        } else {
            System.out.println("Подходящих результатов не найдено");
        }
    }
}
