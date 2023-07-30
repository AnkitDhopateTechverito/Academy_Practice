package com.tv.parkinglot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingAttendant implements Employee, ParkingLotObserver {
    private final Set<ParkingLot> parkingLots = new HashSet<>();
    private final List<ParkingLot> availableParkingLot = new ArrayList<>();

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        availableParkingLot.add(parkingLot);
        parkingLot.addObserver(this);
    }


    @Override
    public boolean directCars(Object car) {
        ParkingLot parkingLot = availableParkingLot.stream()
                .findFirst().orElseThrow(() -> new RuntimeException("Could not find parking lot"));
        return parkingLot.park(car);
    }

    @Override
    public boolean isAvailable() {
        return parkingLots.stream()
                .filter(freeParkingLot -> !freeParkingLot.isFull())
                .findAny().isPresent();
    }

    @Override
    public void onParkingFull(ParkingLot parkingLot) {
        this.availableParkingLot.remove(parkingLot);
    }

    @Override
    public void onParkingFree(ParkingLot parkingLot) {
        this.availableParkingLot.add(parkingLot);
    }
}
