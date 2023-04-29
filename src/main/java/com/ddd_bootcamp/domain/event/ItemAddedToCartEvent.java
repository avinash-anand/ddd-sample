package com.ddd_bootcamp.domain.event;

public class ItemAddedToCartEvent implements DomainEvent {

    private final String productName;
    private final int quantity;

    public ItemAddedToCartEvent(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

}
