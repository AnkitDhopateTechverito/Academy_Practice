package com.tv.cart;

public class UserService {
    private final Notifier notifier;

    public UserService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void register(User user) {
        this.register(user, null);
    }

    public void register(User aUser, User referredBy) {
        notifier.sendNotification(aUser, "Thank you");

        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.publishEvent(new UserCreatedEvent("abc@example.com", aUser));
    }

}
