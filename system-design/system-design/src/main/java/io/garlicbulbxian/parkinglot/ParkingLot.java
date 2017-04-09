package io.garlicbulbxian.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int id;
    List<ParkingSpot> parkingSpots;

    public ParkingLot() {
        parkingSpots = new ArrayList<>();
    }
}
