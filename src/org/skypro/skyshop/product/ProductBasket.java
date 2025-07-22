package org.skypro.skyshop.product;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
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
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName() + " - " + products[i].getPrice() + " руб.");
            } else {
                System.out.println("Пустая ячейка");
            }
        }
        System.out.println("Итого: " + getTotalPrice());
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
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
