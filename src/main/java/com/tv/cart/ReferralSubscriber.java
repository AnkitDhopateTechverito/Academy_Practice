package com.tv.cart;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;

class ReferralSubscriber extends Subscriber<UserCreatedEvent> {
    public ReferralSubscriber() {
        MessageBroker.getInstance().subscribe(UserCreatedEvent.class, this);
    }

    @Override
    public void consume(UserCreatedEvent event) {
        event.getUser().deposit(new Money(CurrencyType.INR, 10));

        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.publishEvent(new ReferralRewardCreditedEvent(event.getUser()));
    }
}
