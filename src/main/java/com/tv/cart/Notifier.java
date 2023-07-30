package com.tv.cart;

public class Notifier {
    private final NotifierFactory notifierFactory;

    public Notifier(NotifierFactory notifierFactory) {
        this.notifierFactory = notifierFactory;
    }

    void sendNotification(User aUser, String message) {
        Notification notifier = this.notifierFactory.getNotifier(aUser.getNotificationPreference());

        String recipient = aUser.getEmail();

        if (aUser.getNotificationPreference().equals("SMS")) {
            recipient = aUser.getPhoneNumber();
        }

        notifier.sendNotification(message, recipient);
    }
}
