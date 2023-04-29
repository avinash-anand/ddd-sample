package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Product;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product applePencil = new Product("Apple Pencil");
        Item item1 = new Item(applePencil, 2);
        cart.add(item1);

        Product sonyHeadphone = new Product("Sony Wireless Headphone");
        Item item2 = new Item(sonyHeadphone, 1);
        cart.add(item2);

        System.out.println("Cart = " + cart);
        List<Item> items = cart.getItems();

        System.out.println("----------------------------------------");
        System.out.println("items = " + items);
        System.out.println("----------------------------------------");

        cart.remove(item2);
        System.out.println(cart);

    }
}
