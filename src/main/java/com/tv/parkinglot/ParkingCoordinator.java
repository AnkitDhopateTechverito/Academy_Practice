package com.tv.parkinglot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingCoordinator implements Employee{
    private final List<Employee> employees;
    private Set<ParkingAttendant> parkingAttendants =new HashSet<>();

    public  ParkingCoordinator(List<Employee> employees) {
        this.employees = employees;
    }

    public void addAttendant(ParkingAttendant parkingAttendant) {
        parkingAttendants.add(parkingAttendant);
    }

    public boolean directCars(Object car) {
        Employee employee = employees.stream()
                .filter(subordinate -> subordinate.isAvailable())
                .findFirst().get();
        return employee.directCars(car);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }



}
