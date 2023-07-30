package com.tv.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotifierFactoryTest {
    @Test
    public void shouldProduceEmailNotifierForEmailPreference(){
        NotifierFactory notifierFactory = new NotifierFactory();
        Notification notification = notifierFactory.getNotifier("Email");

        Assertions.assertEquals(EmailNotifier.class, notification.getClass());
    }

    @Test
    public void shouldProduceSMSNotifierForSMSPreference(){
        NotifierFactory notifierFactory = new NotifierFactory();
        Notification notification = notifierFactory.getNotifier("SMS");

        Assertions.assertEquals(SMSNotifier.class, notification.getClass());
    }
}