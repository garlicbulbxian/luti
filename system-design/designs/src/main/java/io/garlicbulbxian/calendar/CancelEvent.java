package io.garlicbulbxian.calendar;

public class CancelEvent extends Event {
    public CancelEvent(CalendarManager.Meeting meeting, User notifiedUser) {
       super(meeting, notifiedUser);
    }

    public long getDelay() {
        return 0;
    }

    public String getMessage() {
        return "Cancel Meeting";
    }
}
