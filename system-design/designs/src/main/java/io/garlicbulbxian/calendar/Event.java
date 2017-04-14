package io.garlicbulbxian.calendar;

public abstract class Event {
    CalendarManager.Meeting meeting;
    User notifiedUser;

    public Event(CalendarManager.Meeting meeting, User notifiedUser) {
        this.meeting = meeting;
        this.notifiedUser = notifiedUser;
    }

    public CalendarManager.Meeting getMeeting() {
        return meeting;
    }

    public User getNotifiedUser() {
        return notifiedUser;
    }

    /**
     * How long (in seconds) this event should be delayed before being processed.
     * @return
     */
    public abstract long getDelay();

    public abstract String getMessage();
}
