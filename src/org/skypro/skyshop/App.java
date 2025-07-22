package org.skypro.skyshop;

import java.util.SortedMap;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        System.out.println("=====Добавляем продукты в корзину до предела=======");
        basket.addProduct(new Product("Масло", 100));
        basket.addProduct(new Product("Хлеб", 10));
        basket.addProduct(new Product("Картошка", 50));
        basket.addProduct(new Product("Макароны", 70));
        basket.addProduct(new Product("Гречка", 90));
        System.out.println("=====Пытаемся добавить в полную корзину продукт=====");
        basket.addProduct(new Product("Яблоки", 40));
        System.out.println("=====Печать всей корзины=====");
        basket.printProducts();
        System.out.println("=====Создаем новую корзину=====");
        ProductBasket householdBasket = new ProductBasket();
        householdBasket.addProduct(new Product("Мыло", 25));
        householdBasket.addProduct(new Product("Порошок", 85));
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
    }
}
