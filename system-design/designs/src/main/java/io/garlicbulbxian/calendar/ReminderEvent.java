package io.garlicbulbxian.calendar;

public class ReminderEvent extends Event {
    private long delay;

    public ReminderEvent(CalendarManager.Meeting meeting, User notifiedUser, long delay) {
        super(meeting, notifiedUser);

        this.delay = delay;
    }

    public long getDelay() {
        return delay;
    }

    public String getMessage() {
        return "Reminder email";
    }
}
