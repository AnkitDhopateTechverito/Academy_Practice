package com.tv.cart;

public class ReferralNotification extends Subscriber<ReferralRewardCreditedEvent> {

    private final Notifier notifier;

    public ReferralNotification(Notifier notifier) {
        this.notifier = notifier;
        MessageBroker.getInstance().subscribe(ReferralRewardCreditedEvent.class, this);
    }

    @Override
    public void consume(ReferralRewardCreditedEvent event) {
        this.notifier.sendNotification(event.getUser(), "Referral Reward");
    }
}