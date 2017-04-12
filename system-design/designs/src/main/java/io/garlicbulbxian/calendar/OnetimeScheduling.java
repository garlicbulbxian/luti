package io.garlicbulbxian.calendar;

import java.util.Date;

public class OnetimeScheduling implements Scheduling {
    Date startTime;
    Date endTime;
    String place;

    public OnetimeScheduling(Date startTime, Date endTime, String place) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
    }
}
