package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.getPrice();
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }


    @Override
    public String toString() {
        return getName() + " " +
                "Цена со скидкой: " + getPrice() + " " +
                "Скидка: " + discount + " %";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
