package com.tv.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void carShouldBeParkedInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();

        parkingLot.park(audi);

        Assertions.assertEquals(1, parkingLot.numberOfCarsParked());
    }

    @Test
    public void twoCarsShouldBeParkedInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();
        Object bmw = new Object();

        parkingLot.park(audi);
        parkingLot.park(bmw);

        Assertions.assertEquals(2, parkingLot.numberOfCarsParked());
    }

    @Test
    public void shouldNotParkSameCarTwiceInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();

        parkingLot.park(audi);
        parkingLot.park(audi);

        Assertions.assertEquals(1, parkingLot.numberOfCarsParked());
    }

    @Test
    public void carShouldNotCheckInWhenParkingLotHasTwoCars() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();
        Object bmw = new Object();
        Object benz = new Object();

        parkingLot.park(audi);
        parkingLot.park(bmw);
        parkingLot.park(benz);

        Assertions.assertEquals(2, parkingLot.numberOfCarsParked());
    }

    @Test
    public void carShouldBeUnparkedFromTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();

        parkingLot.park(audi);
        parkingLot.unPark(audi);

        Assertions.assertEquals(0, parkingLot.numberOfCarsParked());
    }

    @Test
    public void audiAndBmwAreParkedAndAudiIsRemovedFromTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2, null);
        Object audi = new Object();
        Object bmw = new Object();

        parkingLot.park(audi);
        parkingLot.park(bmw);

        Assertions.assertTrue(parkingLot.unPark(audi));
    }

    @Test
    public void shouldSendNotificationToOwner_ParkingFull() {
        NotificationStub notificationStub = new NotificationStub();
        ParkingLot parkingLot = new ParkingLot(2, notificationStub);
        Object audi = new Object();
        Object bmw = new Object();
        parkingLot.park(audi);
        parkingLot.park(bmw);

        Assertions.assertTrue(notificationStub.wasNotifiedOnFull());
    }

    @Test
    public void shouldNotSendNotificationToOwner_whenLotIsNotFull() {
        NotificationStub notificationStub = new NotificationStub();
        ParkingLot parkingLot = new ParkingLot(2, notificationStub);
        Object bmw = new Object();
        parkingLot.park(bmw);

        Assertions.assertFalse(notificationStub.wasNotifiedOnFull());
    }

    @Test
    public void shouldSendNotificationToOwnerWhenLotHasCapacity() {
        NotificationStub notificationStub = new NotificationStub();
        ParkingLot parkingLot = new ParkingLot(2, notificationStub);
        Object audi = new Object();
        Object bmw = new Object();
        parkingLot.park(audi);
        parkingLot.park(bmw);

        Assertions.assertTrue(notificationStub.wasNotifiedOnFull());

        parkingLot.unPark(audi);

        Assertions.assertTrue(notificationStub.wasNotifiedOnFreeAgain());
    }


    class NotificationStub implements ParkingLotNotifier {

        private boolean notifiedOnFull;
        private boolean notifiedOnFree;

        @Override
        public void notifyOnFull() {
            this.notifiedOnFull = true;
        }

        @Override
        public void notifyWhenFree() {
            this.notifiedOnFree = true;
        }

        public boolean wasNotifiedOnFull() {

            return this.notifiedOnFull;
        }

        public boolean wasNotifiedOnFreeAgain() {
            return notifiedOnFree;
        }
    }
}
