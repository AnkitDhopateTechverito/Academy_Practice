package com.tv.cart;

public abstract class Subscriber<T extends Event> {

    public abstract void consume(T event);
}
