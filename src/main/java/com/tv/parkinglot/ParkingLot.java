package com.tv.parkinglot;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {
    private Set<Object> parkedCars = new HashSet<>();
    private final int capacity;
    private final ParkingLotNotifier notifier;
    private List<ParkingLotObserver> observers = new ArrayList<>();

    public ParkingLot(int capacity, ParkingLotNotifier notifier) {
        this.capacity = capacity;
        this.notifier = notifier;
    }

    public boolean isFull() {
        return parkedCars.size() == capacity;
    }

    public boolean park(Object object) {
        if (isFull()) {
            return false;
        }
        parkedCars.add(object);
        notifyWhenFull();
        return true;
    }

    private void notifyWhenFull() {
        if (isFull() && notifier!=null) {
            notifier.notifyOnFull();
        }
        if(isFull()){
            observers.forEach(observer -> observer.onParkingFull(this));
        }
    }

    public int numberOfCarsParked() {
        return parkedCars.size();
    }

    public boolean unPark(Object object) {
        boolean isFull = isFull();
        boolean isRemoved = parkedCars.remove(object);
        if(isFull && isRemoved && notifier!=null){
            notifier.notifyWhenFree();
        }
        if(isFull && isRemoved) {
            observers.forEach(observer -> observer.onParkingFree(this));
        }

        return isRemoved;
    }

    public void addObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }
}
