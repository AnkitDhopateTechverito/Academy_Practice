package com.tv.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingAttendantTest {
    @Test
    public void shouldDirectCarToParkingLot_1(){
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot_1 = new ParkingLot(2,null);
        parkingAttendant.addParkingLot(parkingLot_1);

        Object audi = new Object();

        parkingAttendant.directCars(audi);

        Assertions.assertEquals(1,parkingLot_1.numberOfCarsParked());
    }

    @Test
    public void shouldDirectCarToParkingLot_1_WhenParkingLot_2_IsFull(){
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot_1 = new ParkingLot(1,null);
        ParkingLot parkingLot_2 = new ParkingLot(1,null);
        parkingAttendant.addParkingLot(parkingLot_1);
        parkingAttendant.addParkingLot(parkingLot_2);
        Object audi = new Object();
        Object benz = new Object();
        parkingAttendant.directCars(audi);
        //Assertions.assertTrue();
        Assertions.assertTrue(parkingAttendant.directCars(benz));
    }

}
