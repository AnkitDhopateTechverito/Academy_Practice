package com.tv.cart;

import java.util.*;

public class MessageBroker {
    private static MessageBroker instance;
    Map<Class<? extends Event>, List<Subscriber<? extends Event>>> events = new HashMap<>();

    public static MessageBroker getInstance() {
        if (instance == null) {
            instance = new MessageBroker();
        }
        return instance;
    }

    public <T extends Event> void publishEvent(T event) {
        Class<? extends Event> aClass = event.getClass();
        List<Subscriber<? extends Event>> subscribers = events.get(aClass);

        if (!Objects.isNull(subscribers)) {
            for (Subscriber<? extends Event> subscriber : subscribers) {
                Subscriber<T> aSubscriber = (Subscriber<T>) subscriber;
                aSubscriber.consume(event);
            }
        }
    }

    public <T extends Event> void subscribe(Class<T> event, Subscriber<T> subscriber) {
        if (events.containsKey(event)) {
            events.get(event).add(subscriber);
        } else {
            List<Subscriber<? extends Event>> subscribers = new ArrayList<>();
            subscribers.add(subscriber);
            events.put(event, subscribers);
        }
    }
}
