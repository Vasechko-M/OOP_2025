package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {

        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Нельзя добавить null в корзину");
        }
        if (products.contains(product)) {
            throw new IllegalStateException("Этот продукт уже есть в корзине");
        }
        products.add(product);
    }
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }
    public void printProducts() {
        int count = 0;
        for (Product p : products) {
            if (p != null) {
                System.out.println(p);
                if (p != null && p.isSpecial()){
                    count++;
                }
            } else {
                System.out.println("Пустая ячейка");
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных продуктов " + count);
    }

    public boolean findProduct(String name) {
        for (Product p : products) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void clear() {
        products.clear();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
