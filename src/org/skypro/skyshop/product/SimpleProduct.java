package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;
    public SimpleProduct(String name,int price) {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Цена должна быть больше либо равна 1 рублю");
        }
        this.price = price;
    }


    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  getName() + " " +
                "Цена: " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
