package com.tv.cart;

public class NoOffer implements Offers {


    @Override
    public int offerPrice(Integer quantity, int price) {
        return quantity * price;
    }
}

