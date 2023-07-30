package com.tv.parkinglot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingAttendant implements Employee,ParkingLotObserver{
    private Set<ParkingLot> parkingLots = new HashSet<>();
    private List<ParkingLot> avialableParkingLot = new ArrayList<>();

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        avialableParkingLot.add(parkingLot);
        parkingLot.addObserver(this);
    }



    public boolean directCars(Object car) {
        ParkingLot parkingLot = avialableParkingLot.stream()
                .findFirst().orElseThrow();
        return parkingLot.park(car);
    }

    public boolean isAvailable(){
        return parkingLots.stream()
                .filter(freeParkingLot -> !freeParkingLot.isFull())
                .findAny().isPresent();
    }


    @Override
    public void onParkingFull(ParkingLot parkingLot) {
        this.avialableParkingLot.remove(parkingLot);
    }

    @Override
    public void onParkingFree(ParkingLot parkingLot) {
        this.avialableParkingLot.add(parkingLot);
    }
}
