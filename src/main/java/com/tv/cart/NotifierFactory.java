package com.tv.cart;

public class NotifierFactory {

    public Notification getNotifier(String notificationPreference) {
        if(notificationPreference.equals("Email")) return new EmailNotifier();
        return new SMSNotifier();
    }
}
