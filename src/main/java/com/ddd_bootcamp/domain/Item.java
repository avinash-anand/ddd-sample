package com.ddd_bootcamp.domain;

public class Item {

    private final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProductName() {
        return product.name();
    }

    public Price getProductPrice() {
        return product.price();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

}
