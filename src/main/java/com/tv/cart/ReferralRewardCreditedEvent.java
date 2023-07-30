package com.tv.cart;

public class ReferralRewardCreditedEvent extends Event {
    private final User user;

    public ReferralRewardCreditedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "ReferralRewardCreditedEvent{" +
                "user=" + user +
                '}';
    }
}
