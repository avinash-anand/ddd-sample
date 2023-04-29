package com.ddd_bootcamp.domain.event;

public class ItemRemovedFromCartEvent implements DomainEvent {
    private final String productName;

    public ItemRemovedFromCartEvent(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
