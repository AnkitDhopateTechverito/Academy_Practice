package com.tv.cart;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;
import com.tv.wallet.Wallet;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Fruit, Integer> items = new HashMap<>();

    public void add(Fruit fruit, int quantity) {
        if (fruit.updateFruit(quantity)) {
            items.put(fruit, items.getOrDefault(fruit, 0) + quantity);
        }
    }

    public int getTotal() {
        int total = 0;

        for (Fruit currentFruit : items.keySet()) {
            total += currentFruit.priceForQuantity(items.get(currentFruit));
        }

        return total;
    }

    public void checkout(Wallet wallet) {
        wallet.withdrawAmount(new Money(CurrencyType.INR, this.getTotal()));
    }

    public Boolean checkoutWithPayPal(PayPal payPal) {
        return true;
    }
}
