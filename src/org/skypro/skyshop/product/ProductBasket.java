package org.skypro.skyshop.product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {

        this.productsMap = new HashMap<>();
    }
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Нельзя добавить null в корзину");
        }
        String name = product.getName();
        if (productsMap.containsKey(name)) {
            throw new IllegalStateException("Этот продукт уже есть в корзине");
        }
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productsMap.put(name, productList);
    }
    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public void printProducts() {
        System.out.printf("\u001B[32mПечать корзины\u001B[0m%n");
        productsMap.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Product::getName))
                .forEach(p -> System.out.println(p));


        int specialCount = getSpecialCount();

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных продуктов " + specialCount);
    }

    public void expensiveProducts() {
        System.out.printf("\u001B[32mЭти продукты дорогие\u001B[0m%n");
        productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.getPrice() > 100)
                .sorted(Comparator.comparingInt(Product::getPrice))
                .forEach(product ->
                        System.out.printf("Продукт: \"%s\", Цена: %d рублей.%n", product.getName(), product.getPrice()));
    }

    public OptionalDouble averageProductCost(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя продукта в строке поиска не может быть пустым или содержать только пробелы");
        }
        String searchName = productName.toLowerCase();
        List<Product> filteredProducts = productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(p -> p.getName().toLowerCase().contains(searchName))
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                .collect(Collectors.toList());

        OptionalDouble average = filteredProducts.stream()
                .mapToInt(Product::getPrice)
                .average();

        if (average.isPresent()) {
            System.out.printf("\u001B[32mСредняя стоимость продукта \"%s\": %.2f рублей.\u001B[0m%n", productName, average.getAsDouble());
            System.out.println("Список продуктов (от самых дорогих к самым дешевым):");
            filteredProducts.forEach(product ->
                    System.out.printf("Продукт: \"%s\", Цена: %d рублей.%n", product.getName(), product.getPrice()));
        } else {
            System.out.println("Продуктов с именем, содержащим \"" + productName + "\", не найдено.");
        }
        return average;
    }
    private int getSpecialCount() {
        return (int) productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean findProduct(String name) {
        return productsMap.containsKey(name);
    }
    public void clear() {
        productsMap.clear();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        if (removedProducts == null) {
            return Collections.emptyList();
        }
        return removedProducts;
    }
}
