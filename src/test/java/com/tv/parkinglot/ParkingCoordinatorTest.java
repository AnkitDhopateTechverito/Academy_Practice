package com.tv.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParkingCoordinatorTest {

    @Test
    public void shouldDirectCarToAttendant() {
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingCoordinator parkingCoordinator = new ParkingCoordinator(Arrays.asList(parkingAttendant));
        ParkingLot parkingLot_1 = new ParkingLot(1);
        parkingAttendant.addParkingLot(parkingLot_1);

        Object audi = new Object();

        parkingCoordinator.addAttendant(parkingAttendant);

        Assertions.assertTrue(parkingCoordinator.directCars(audi));
    }

    @Test
    public void shouldDirectCarToAttendantHavingAvailableParkingLot() {
        ParkingAttendant parkingAttendant_1 = new ParkingAttendant();
        ParkingAttendant parkingAttendant_2 = new ParkingAttendant();
        ParkingCoordinator parkingCoordinator = new ParkingCoordinator(Arrays.asList(parkingAttendant_1, parkingAttendant_2));
        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(1);
        parkingAttendant_1.addParkingLot(parkingLot_1);
        parkingAttendant_2.addParkingLot(parkingLot_2);

        Object audi = new Object();
        Object bmw = new Object();

        parkingCoordinator.addAttendant(parkingAttendant_1);
        parkingCoordinator.addAttendant(parkingAttendant_2);

        Assertions.assertTrue(parkingCoordinator.directCars(audi));
        Assertions.assertTrue(parkingCoordinator.directCars(bmw));
    }

    @Test
    public void shouldDirectCarToAttendantHavingAvailableParkingLots() {

        ParkingAttendant parkingAttendant_1 = new ParkingAttendant();
        ParkingAttendant parkingAttendant_2 = new ParkingAttendant();
        ParkingCoordinator parkingCoordinator = new ParkingCoordinator(Arrays.asList(parkingAttendant_1, parkingAttendant_2));


        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(1);
        ParkingLot parkingLot_3 = new ParkingLot(2);
        parkingAttendant_1.addParkingLot(parkingLot_1);
        parkingAttendant_2.addParkingLot(parkingLot_2);
        parkingAttendant_2.addParkingLot(parkingLot_3);

        Object audi = new Object();
        Object bmw = new Object();
        Object jaguar = new Object();

        parkingCoordinator.addAttendant(parkingAttendant_1);
        parkingCoordinator.addAttendant(parkingAttendant_2);

        Assertions.assertTrue(parkingCoordinator.directCars(audi));
        Assertions.assertTrue(parkingCoordinator.directCars(bmw));
        Assertions.assertTrue(parkingCoordinator.directCars(jaguar));
    }

    @Test
    @DisplayName("Should direct car to attendant when order is attendant and coordinator")
    public void test3() {

        ParkingAttendant parkingAttendant_1 = new ParkingAttendant();
        ParkingAttendant parkingAttendant_2 = new ParkingAttendantStub();

        ParkingCoordinator parkingCoordinator1 = new ParkingCoordinator(Arrays.asList(parkingAttendant_1));
        ParkingCoordinator parkingCoordinator2 = new ParkingCoordinator(Arrays.asList(parkingAttendant_2, parkingCoordinator1));

        ParkingLot parkingLot_2 = new ParkingLot(1);
        ParkingLot parkingLot_1 = new ParkingLot(1);

        parkingAttendant_1.addParkingLot(parkingLot_1);
        parkingAttendant_2.addParkingLot(parkingLot_2);


        Object audi = new Object();


        Assertions.assertTrue(parkingAttendant_2.directCars(audi));

    }

    @Test
    @DisplayName("Should  direct car to coordinator when order is attendant and coordinator")
    public void test_4() {

        ParkingAttendant kedar = new ParkingAttendant();
        ParkingAttendant rohit = new ParkingAttendant();


        ParkingCoordinatorStub sukhendu = new ParkingCoordinatorStub(Arrays.asList(kedar));
        ParkingCoordinator ashwinManager = new ParkingCoordinator(Arrays.asList(rohit, sukhendu));

        ParkingLot parkingLot_2 = new ParkingLot(1);
        ParkingLot parkingLot_1 = new ParkingLot(1);

        kedar.addParkingLot(parkingLot_1);
        rohit.addParkingLot(parkingLot_2);
        rohit.directCars(new Object());


        Object audi = new Object();

        Assertions.assertTrue(ashwinManager.directCars(audi));

        Assertions.assertEquals(audi, sukhendu.getLastDirectedCar());

    }

    private class ParkingAttendantStub extends ParkingAttendant {
        @Override
        public boolean directCars(Object car) {
            return true;
        }
    }

    private class ParkingCoordinatorStub extends ParkingCoordinator {
        private Object car;

        public ParkingCoordinatorStub(List<Employee> employees) {
            super(employees);
        }

        @Override
        public boolean directCars(Object car) {
            this.car = car;
            return true;
        }

        public Object getLastDirectedCar() {
            return car;
        }

    }

}
