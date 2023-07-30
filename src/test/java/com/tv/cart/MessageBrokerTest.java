package com.tv.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MessageBrokerTest {
    public static final UserCreatedEvent USER_CREATED_EVENT = new UserCreatedEvent("abc@example.com", null);
    public static final ItemAddedToCartEvent ITEM_ADDED_TO_CART_EVENT = new ItemAddedToCartEvent(new Fruit(10, 10), 10);

    @Test
    public void shouldConsumeCreatedUserToUserEvent() {
        MessageBroker messageBroker = new MessageBroker();
        messageBroker.subscribe(UserCreatedEvent.class, new Subscriber<UserCreatedEvent>() {
            @Override
            public void consume(UserCreatedEvent event) {
                System.out.println(event);
            }
        });
        messageBroker.publishEvent(USER_CREATED_EVENT);
    }

    @Test
    public void shouldConsumeCreatedUserToUserEventWithMultipleSubscribers() {
        MessageBroker messageBroker = new MessageBroker();
        messageBroker.subscribe(UserCreatedEvent.class, new Subscriber<UserCreatedEvent>() {
            @Override
            public void consume(UserCreatedEvent event) {
                System.out.println(event);
            }
        });
        messageBroker.subscribe(UserCreatedEvent.class, new Subscriber<UserCreatedEvent>() {
            @Override
            public void consume(UserCreatedEvent event) {
                System.out.println(event);
            }
        });
        messageBroker.publishEvent(USER_CREATED_EVENT);
    }

    @Test
    public void shouldSendItemAddedToCartEventToItsSubscribers() {
        MessageBroker messageBroker = new MessageBroker();
        messageBroker.subscribe(ItemAddedToCartEvent.class, new Subscriber<ItemAddedToCartEvent>() {
            @Override
            public void consume(ItemAddedToCartEvent event) {
                System.out.println(event);
            }
        });
        messageBroker.publishEvent(ITEM_ADDED_TO_CART_EVENT);
    }

    @Test
    void shouldConsumeUserCreatedEventClass() {
        EventCollector eventCollector = new EventCollector();
        eventCollector.trackEventClass(UserCreatedEvent.class);
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.publishEvent(USER_CREATED_EVENT);
        Assertions.assertEquals(UserCreatedEvent.class, eventCollector.getLastClass());
    }

    @Test
    void shouldConsumeItemAddToCartEventClass() {
        EventCollector eventCollector = new EventCollector();
        eventCollector.trackEventClass(ItemAddedToCartEvent.class);
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.publishEvent(ITEM_ADDED_TO_CART_EVENT);
        Assertions.assertEquals(ItemAddedToCartEvent.class, eventCollector.getLastClass());
    }

    @Test
    void shouldConsumeItemAddToCartEventClass_And_UserCreatedEventClass() {
        EventCollector eventCollector = new EventCollector();
        eventCollector.trackEventClass(ItemAddedToCartEvent.class);
        eventCollector.trackEventClass(UserCreatedEvent.class);
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.publishEvent(ITEM_ADDED_TO_CART_EVENT);
        MBInstance.publishEvent(USER_CREATED_EVENT);
        Assertions.assertEquals(ItemAddedToCartEvent.class, eventCollector.getEventClass(ITEM_ADDED_TO_CART_EVENT));
        Assertions.assertEquals(UserCreatedEvent.class, eventCollector.getEventClass(USER_CREATED_EVENT));
    }

    @Test
    void should_NOT_ConsumeUserCreatedEvent() {
        EventCollector eventCollector = new EventCollector();
        Assertions.assertEquals(null, eventCollector.getEventClass(USER_CREATED_EVENT));
    }

    @Test
    void shouldGet_TheLast_EventFromTheListOfEvents() {
        EventCollector eventCollector = new EventCollector();
        eventCollector.trackEventClass(ItemAddedToCartEvent.class);
        eventCollector.trackEventClass(UserCreatedEvent.class);
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.publishEvent(ITEM_ADDED_TO_CART_EVENT);
        MBInstance.publishEvent(USER_CREATED_EVENT);
        List<Event> expectedEventList = new ArrayList<>();
        expectedEventList.add(USER_CREATED_EVENT);
        Assertions.assertEquals(expectedEventList, eventCollector.getTheLastNumberOfEvents(1));
    }

    @Test
    void shouldGet_TheLastTwo_EventFromTheListOfEvents() {
        EventCollector eventCollector = new EventCollector();
        eventCollector.trackEventClass(ItemAddedToCartEvent.class);
        eventCollector.trackEventClass(UserCreatedEvent.class);
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.publishEvent(USER_CREATED_EVENT);
        MBInstance.publishEvent(ITEM_ADDED_TO_CART_EVENT);
        List<Event> expectedEventList = new ArrayList<>();
        expectedEventList.add(USER_CREATED_EVENT);
        expectedEventList.add(ITEM_ADDED_TO_CART_EVENT);
        Assertions.assertEquals(expectedEventList, eventCollector.getTheLastNumberOfEvents(2));
    }

    @Test
    void shouldReturn_Null_WhenAccessingMoreNumberOfEventAsComparedToSizeOfEventList() {
        EventCollector eventCollector = new EventCollector();
        Assertions.assertEquals(null, eventCollector.getTheLastNumberOfEvents(1));
    }
}