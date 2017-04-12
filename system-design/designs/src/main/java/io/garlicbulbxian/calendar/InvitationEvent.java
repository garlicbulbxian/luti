package io.garlicbulbxian.calendar;

public class InvitationEvent implements Event {
    CalendarManager.Meeting meeting;
    User notifiedUser;

    public InvitationEvent(CalendarManager.Meeting meeting, User notifiedUser) {
        this.meeting = meeting;
        this.notifiedUser = notifiedUser;
    }
}
