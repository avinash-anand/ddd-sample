package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Price;
import com.ddd_bootcamp.domain.Product;
import com.ddd_bootcamp.domain.service.CompetitorBasedPricer;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Product applePencil = new Product("Apple Pencil", new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item item1 = new Item(applePencil, 2);
        cart1.add(item1);

        Product sonyHeadphone = new Product("Sony Wireless Headphone", new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
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
        System.out.println(cart1.equals(cart2) ? "true=Carts are same " : "false=Carts are different");
        System.out.print("cart1.hasSameIdentityAs(cart2) :");
        System.out.println(cart1.hasSameIdentityAs(cart2) ? "true=Carts are same" : "false=Carts are different");

        Price price1 = new Price(BigDecimal.valueOf(5), Currency.getInstance("USD"));
        Price price2 = new Price(BigDecimal.valueOf(5), Currency.getInstance("USD"));
        System.out.println("price1.equals(price2) = " + price1.equals(price2));
        System.out.println("price1.sameValueAs(price2) = " + price1.sameValueAs(price2));

        Price applePencilPrice = CompetitorBasedPricer.getPrice("Apple Pencil");

        System.out.println("Discounted Price for Apple Pencil: " + applePencilPrice);

        Price sonyWirelessHeadphonePrice = CompetitorBasedPricer.getPrice("Sony Wireless headphone");

        System.out.println("Discounted Price for Sony Wireless headphone: " + sonyWirelessHeadphonePrice);

        Cart cart3 = new Cart();
        cart3.add(new Item(new Product("Apple Pencil", applePencilPrice), 1));
        System.out.println("cart 3 = " + cart3);
    }
}
