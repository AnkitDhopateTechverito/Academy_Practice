package com.tv.cart;

public class BuyAndGetMore implements Offers {
    private final int quantity;
    private final int free;

    public BuyAndGetMore(int quantity, int free) {
        this.quantity = quantity;
        this.free = free;
    }

    @Override
    public int offerPrice(Integer quantity, int price) {
        int paidForQty = quantity / (this.quantity + free) * this.quantity;
        int modulus = quantity % (this.quantity + free);
        paidForQty = paidForQty + (modulus / this.quantity) + modulus % this.quantity;
        return paidForQty;
    }
}
