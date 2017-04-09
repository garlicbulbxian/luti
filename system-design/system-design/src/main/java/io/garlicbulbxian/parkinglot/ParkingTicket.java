package io.garlicbulbxian.parkinglot;

import java.util.Date;

public class ParkingTicket {
    private static double ratePerMinute = 0d;

    int id;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    Date enterTime;
    Date leaveTime;

    void generate() {
        this.enterTime = new Date();
    }

    void leave() {
        this.leaveTime = new Date();
    }

    double getBalance() {
        if (enterTime != null && leaveTime != null) {
            return ratePerMinute * (leaveTime.getTime() - enterTime.getTime()) / 1000 / 60;
        }

        throw new RuntimeException("not complete yet");
    }
}
