package org.skypro.skyshop.product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsMap;

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
        int total = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }
    public void printProducts() {
        int count = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product p : productList) {
                if (p != null) {
                    System.out.println(p);
                    if (p.isSpecial()) {
                        count++;
                    }
                } else {
                    System.out.println("Пустая ячейка");
                }
                }
            }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных продуктов " + count);
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
