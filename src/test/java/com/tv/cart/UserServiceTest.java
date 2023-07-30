package com.tv.cart;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;
import com.tv.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    public static final String EMAIL = "abc@example.com";
    public static final String PHONE_NUMBER = "0123401234";

    @Test
    public void whenUserRegisterWithEmailSendNotificationUsingEmail() {
//        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
//        UserService userService = new UserService(new Notifier(notifierFactoryStub));
//        userService.register(new User(EMAIL, "Email", PHONE_NUMBER, new Wallet(CurrencyType.INR)));
//
//        NotificationStub emailNotifierStub = notifierFactoryStub.getEmailNotifier();
//        Assertions.assertEquals("Thank you", emailNotifierStub.getLastSentMessage());
//        Assertions.assertEquals(EMAIL, emailNotifierStub.lastRecipient());

        Notifier emailNotifierMock = mock(Notifier.class);
        UserService userService = new UserService(emailNotifierMock);
        User user = new User(EMAIL, "Email", PHONE_NUMBER, new Wallet(CurrencyType.INR));

        userService.register(user);
        verify(emailNotifierMock).sendNotification(user, "Thank you");
    }

    @Test
    public void whenUserRegisterWithSMSSendNotificationUsingSMS() {
//        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
//        UserService userService = new UserService(new Notifier(notifierFactoryStub));
//        userService.register(new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR)));
//
//        NotificationStub smsNotifier = notifierFactoryStub.getSmsNotifier();
//        Assertions.assertEquals("Thank you", smsNotifier.getLastSentMessage());
//        Assertions.assertEquals(PHONE_NUMBER, smsNotifier.lastRecipient());

        Notifier smsNotifierMock = mock(Notifier.class);
        UserService userService = new UserService(smsNotifierMock);
        User user = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));

        userService.register(user);

        verify(smsNotifierMock).sendNotification(user, "Thank you");

    }

    @Test
    public void _10_INRShouldBeCreditedToWalletWhenReferredAnotherUser() {
//        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
//        UserService userService = new UserService(new Notifier(notifierFactoryStub));
//        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
//        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));
//
//        new ReferralSubscriber();
//        userService.register(aUser, referredBy);
//
//        Assertions.assertEquals(new Money(CurrencyType.INR, 10), aUser.getWallet().balance());

        Notifier notifierMock = mock(Notifier.class);
        UserService userService = new UserService(notifierMock);
        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));

        new ReferralSubscriber();
        userService.register(aUser, referredBy);

        Assertions.assertEquals(new Money(CurrencyType.INR, 10), aUser.getWallet().balance());
    }

    // There is slight error in following implementation of sendNotification.
    // The referral reward message is sent to new registered user, rather being sent to the referrer.
    @Test
    public void referrerRewardNotificationIsSendToReferrerWhenRefereeRegisters() {
//        NotifierFactoryStub notifierFactoryStub = new NotifierFactoryStub();
//        UserService userService = new UserService(new Notifier(notifierFactoryStub));
//        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
//        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));
//
//        new ReferralSubscriber();
//        new ReferralNotification(new Notifier(notifierFactoryStub));
//        userService.register(aUser, referredBy);
//
//        NotificationStub smsNotificationStub = notifierFactoryStub.getSmsNotifier();
//        Assertions.assertEquals("Referral Reward", smsNotificationStub.getLastSentMessage());
//        Assertions.assertEquals(PHONE_NUMBER, smsNotificationStub.lastRecipient());

        Notifier smsNotifierMock = mock(Notifier.class);
        UserService userService = new UserService(smsNotifierMock);
        User aUser = new User(EMAIL, "SMS", PHONE_NUMBER, new Wallet(CurrencyType.INR));
        User referredBy = new User("xyz@example.com", "SMS", "1234567890", new Wallet(CurrencyType.INR));

        new ReferralSubscriber();
        new ReferralNotification(smsNotifierMock);
        userService.register(aUser, referredBy);

        verify(smsNotifierMock).sendNotification(aUser, "Referral Reward");
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


