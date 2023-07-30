package com.tv.cart;

public class UserCreatedEvent extends Event {
    private final String email;
    private final User user;

    public UserCreatedEvent(String email, User aUser) {
        this.email = email;
        this.user = aUser;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "email='" + email + '\'' +
                ", aUser=" + user +
                '}';
    }
}
