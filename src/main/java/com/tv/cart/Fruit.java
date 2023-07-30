package com.tv.cart;

public class Fruit {
    private int quantity;
    private final int price;
    private Offers offers= new NoOffer();

    public Fruit(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public boolean updateFruit(int quantity) {
        if (this.quantity < quantity) {
            return false;
        }
        this.quantity -= quantity;
        return true;
    }

    public int priceForQuantity(Integer quantity) {
        return offers.offerPrice(quantity, this.price);
    }

    public void applyOffer(Offers offer) {
        this.offers = offer;
    }
}
