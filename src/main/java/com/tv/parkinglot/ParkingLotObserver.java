package com.tv.parkinglot;

public interface ParkingLotObserver {
    void onParkingFull(ParkingLot parkingLot);

    void onParkingFree(ParkingLot parkingLot);
}
