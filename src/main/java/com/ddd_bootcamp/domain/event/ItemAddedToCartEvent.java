package com.ddd_bootcamp.domain.event;

import com.ddd_bootcamp.domain.Price;

public class ItemAddedToCartEvent implements DomainEvent {

    private final String productName;
    private final int quantity;

    private final Price price;

    public ItemAddedToCartEvent(String productName, int quantity, Price price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }
}
