package com.ddd_bootcamp.domain;

import com.ddd_bootcamp.domain.event.DomainEvent;
import com.ddd_bootcamp.domain.event.ItemAddedToCartEvent;
import com.ddd_bootcamp.domain.event.ItemRemovedFromCartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart implements Entity<Cart> {

    private final CartId cartId;
    private final List<DomainEvent> events = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    public Cart() {
        cartId = CartId.generateCartId();
    }
    public void add(Item item) {
        ItemAddedToCartEvent itemAddedEvent =
                new ItemAddedToCartEvent(item.getProductName(), item.getQuantity());

        apply(itemAddedEvent);
    }

    public List<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
        ItemRemovedFromCartEvent itemRemovedFromCartEvent =
                new ItemRemovedFromCartEvent(item.getProductName());

        apply(itemRemovedFromCartEvent);
    }

    private void apply(ItemAddedToCartEvent event) {
        events.add(event);
        this.items.add(new Item(new Product(event.getProductName()), event.getQuantity()));
    }

    private void apply(ItemRemovedFromCartEvent event) {
        events.add(event);
        this.items.
                remove(this.items.stream().filter(item -> item.getProductName()
                        .equals(event.getProductName())).findFirst().get());
    }

    public Set<String> removedProductNames() {
        return events.stream()
                .filter(ItemRemovedFromCartEvent.class::isInstance)
                .map(event -> ((ItemRemovedFromCartEvent) event).getProductName())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean hasSameIdentityAs(Cart other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return cartId.equals(other.cartId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        return cartId.equals(cart.cartId);
    }

    @Override
    public int hashCode() {
        return cartId.hashCode();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "events=" + events +
                ", items=" + items +
                '}';
    }
}
