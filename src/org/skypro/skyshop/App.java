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
        searchEngine.printSearchResultsStream("о");
        System.out.println();

        ProductBasket householdBasket = new ProductBasket();
        householdBasket.addProduct(new SimpleProduct("Мыло", 25));
        householdBasket.addProduct(new SimpleProduct("Мыло звездочка", 2));
        householdBasket.addProduct(new SimpleProduct("Корыто", 247));
        householdBasket.addProduct(new SimpleProduct("Мыло взрослое", 250));
        householdBasket.addProduct(new SimpleProduct("Порошок", 85));
        householdBasket.addProduct(new SimpleProduct("Велосипед", 1285));
        householdBasket.addProduct(new DiscountedProduct("Порошок зубной",30,18));
        householdBasket.addProduct(new DiscountedProduct("Порошок для белого",35,18));
        householdBasket.addProduct(new FixPriceProduct("Мыло для рук"));

        householdBasket.printProducts();

        System.out.println();
        householdBasket.averageProductCost("мыло");
        System.out.println();
        householdBasket.averageProductCost("порошок");
        System.out.println();
        householdBasket.expensiveProducts();

    }
}

