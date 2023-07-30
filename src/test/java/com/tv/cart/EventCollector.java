package com.tv.cart;

import java.util.ArrayList;
import java.util.List;

public class EventCollector {
    private final SubscriberStub subscriberStub;

    public EventCollector() {
        this.subscriberStub = new SubscriberStub();
    }

    public void trackEventClass(Class eventClass) {
        MessageBroker MBInstance = MessageBroker.getInstance();
        MBInstance.subscribe(eventClass, subscriberStub);
    }

    public Class<? extends Event> getLastClass() {
        return subscriberStub.getLastEventClass();
    }

    public Class<? extends Event> getEventClass(Event customEvent) {
        return subscriberStub.getCustomEventClass(customEvent);
    }

    public List<Event> getTheLastNumberOfEvents(int numberOfEvents) {
        return subscriberStub.getSpecificNumberOfEvents(numberOfEvents);
    }
}

class SubscriberStub extends Subscriber<Event> {
    private Event event;
    List<Event> eventsList = new ArrayList<>();

    @Override
    public void consume(Event event) {
        this.event = event;
        eventsList.add(event);
    }

    public Class<? extends Event> getLastEventClass() {
        return this.eventsList.get(eventsList.size()-1).getClass();
    }

    public Class<? extends Event> getCustomEventClass(Event customEvent) {
        for (Event value : eventsList) {
            if (value.getClass() == customEvent.getClass())
                return value.getClass();
        }
        return null;
    }

    public List<Event> getSpecificNumberOfEvents(int numberOfEvents) {
        if (numberOfEvents > eventsList.size())
            return null;
        List<Event> specificNumberOfEvents = new ArrayList<>();
        for (int i = eventsList.size() - numberOfEvents; i < eventsList.size(); i++) {
            specificNumberOfEvents.add(eventsList.get(i));
        }
        return specificNumberOfEvents;
    }
}