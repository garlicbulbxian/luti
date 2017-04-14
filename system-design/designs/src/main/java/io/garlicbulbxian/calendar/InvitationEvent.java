package io.garlicbulbxian.calendar;

public class InvitationEvent extends Event {
    public InvitationEvent(CalendarManager.Meeting meeting, User notifiedUser) {
        super(meeting, notifiedUser);
    }

    public long getDelay() {
        return 0;
    }

    public String getMessage() {
        String message = "Invitation"
                + "";
        return message;
    }

}
