package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Product;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Product applePencil = new Product("Apple Pencil");
        Item item1 = new Item(applePencil, 2);
        cart1.add(item1);

        Product sonyHeadphone = new Product("Sony Wireless Headphone");
        Item item2 = new Item(sonyHeadphone, 1);
        cart1.add(item2);

        System.out.println("Cart = " + cart1);
        List<Item> items = cart1.getItems();

        System.out.println("----------------------------------------");
        System.out.println("items = " + items);
        System.out.println("----------------------------------------");

        cart1.remove(item2);
        System.out.println(cart1);
        System.out.println("Removed product names = " + cart1.removedProductNames());

        Cart cart2 = new Cart();
        cart2.add(item1);
        System.out.print("cart1.equals(cart2) :");
        System.out.println(cart1.equals(cart2)? "true=Carts are same " : "false=Carts are different");
        System.out.print("cart1.hasSameIdentityAs(cart2) :");
        System.out.println(cart1.hasSameIdentityAs(cart2)? "true=Carts are same"  : "false=Carts are different");
    }
}
