package com.tv.cart;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;
import com.tv.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    public static final String EMAIL = "abc@example.com";
    public static final String PHONE_NUMBER = "0123401234";

    @Test
    public void whenUserRegisterWithEmailSendNotificationUsingEmail() {
        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
        UserService userService = new UserService(new Notifier(notifierFactoryStub));
        userService.register(new User(EMAIL, "Email", PHONE_NUMBER, new Wallet(CurrencyType.INR)));

        NotificationStub emailNotifierStub = notifierFactoryStub.getEmailNotifier();
        Assertions.assertEquals("Thank you", emailNotifierStub.getLastSentMessage());
        Assertions.assertEquals(EMAIL, emailNotifierStub.lastRecipient());

    }

    @Test
    public void whenUserRegisterWithSMSSendNotificationUsingSMS() {
        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
        UserService userService = new UserService(new Notifier(notifierFactoryStub));
        userService.register(new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR)));

        NotificationStub smsNotifier = notifierFactoryStub.getSmsNotifier();
        Assertions.assertEquals("Thank you", smsNotifier.getLastSentMessage());
        Assertions.assertEquals(PHONE_NUMBER, smsNotifier.lastRecipient());

    }

    @Test
    public void _10_INRShouldBeCreditedToWalletWhenReferredAnotherUser() {
        NotificationStub notification = new NotificationStub();
        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
        UserService userService = new UserService(new Notifier(notifierFactoryStub));
        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));

        new ReferralSubscriber();
        userService.register(aUser, referredBy);

        Assertions.assertEquals(new Money(CurrencyType.INR, 10), aUser.getWallet().balance());
    }

    @Test
    public void referrerRewardNotificationIsSendToReferrerWhenRefereeRegisters() {
        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
        UserService userService = new UserService(new Notifier(notifierFactoryStub));
        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));

        new ReferralSubscriber();
        new ReferralNotification(new Notifier(notifierFactoryStub));
        userService.register(aUser, referredBy);

        NotificationStub smsNotificationStub = notifierFactoryStub.getSmsNotifier();
        Assertions.assertEquals("Referral Reward", smsNotificationStub.getLastSentMessage());
        Assertions.assertEquals(PHONE_NUMBER, smsNotificationStub.lastRecipient());
    }

    private class NotifierFactoryStub extends NotifierFactory {
        private final NotificationStub notificationStub;

        public NotifierFactoryStub() {
            this.notificationStub = new NotificationStub();
        }

        public Notification getNotifier(String preference) {
            return this.notificationStub;
        }

        public NotificationStub getSmsNotifier() {
            return this.notificationStub;
        }

        public NotificationStub getEmailNotifier() {
            return this.notificationStub;
        }
    }
}


class NotificationStub implements Notification {

    private String message;
    private String recipient;

    @Override
    public void sendNotification(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }


    public String getLastSentMessage() {
        return this.message;
    }

    public String lastRecipient() {
        return this.recipient;
    }
}


