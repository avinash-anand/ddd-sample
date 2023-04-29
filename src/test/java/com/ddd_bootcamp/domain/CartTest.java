package com.ddd_bootcamp.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    @Test
    void shouldAdd2ApplePencilToCart() {
        Cart cart = new Cart();
        Product product = new Product("Apple Pencil");
        cart.add(new Item(product, 2));

        List<Item> actual = cart.getItems();

        assertEquals(1, actual.size());
        assertEquals("Apple Pencil", actual.get(0).getProduct().getName());
        assertEquals(2, actual.get(0).getQuantity());

    }

}
