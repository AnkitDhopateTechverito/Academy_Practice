package com.tv.cart;

import com.tv.wallet.Money;
import com.tv.wallet.Wallet;

public class User {

    private final String email;
    private final String notificationPreference;
    private final String phoneNumber;
    private final Wallet wallet;

    public User(String email, String notificationPreference, String phoneNumber, Wallet wallet) {
        this.email = email;
        this.notificationPreference = notificationPreference;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
    }

    public void deposit(Money money){
        wallet.depositAmount(money);
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
