package com.tv.cart;

public class Discount implements Offers {

    private final int percent;

    public Discount(int percent) {
        this.percent = percent;
    }

    @Override
    public int offerPrice(Integer quantity, int price) {
        return ((price*quantity) * (100 - this.percent)/100);
    }
}
