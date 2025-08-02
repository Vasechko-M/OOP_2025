package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null, пустым или содержать только пробелы");
        }
        this.name = name;
    }
    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract String toString();

    public abstract boolean isSpecial();
}
