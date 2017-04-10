package io.garlicbulbxian.parkinglot;

public abstract class Vehicle {
    int id;
    ParkingTicket parkingTicket;

    abstract int getVehicleSize();

    abstract void parking();
    abstract void moveout();
}
