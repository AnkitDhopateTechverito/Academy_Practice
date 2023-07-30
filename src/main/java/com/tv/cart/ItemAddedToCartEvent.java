package com.tv.cart;

public class ItemAddedToCartEvent extends Event {
    private final Fruit fruit;
    private final int quantity;

    public ItemAddedToCartEvent(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemAddedToCartEvent{" +
                "fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }
}
