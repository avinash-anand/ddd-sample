package com.ddd_bootcamp.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void shouldAddApplePencilToCart() {
        Cart cart = new Cart();
        Product product = new Product("Apple Pencil");
        cart.add(product);

        List<Product> actual = cart.getProducts();

        assertEquals(1, actual.size());
        assertEquals("Apple Pencil", actual.get(0).getName());

    }

}
