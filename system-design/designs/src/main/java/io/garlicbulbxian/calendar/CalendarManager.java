package io.garlicbulbxian.calendar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalendarManager {
    private static CalendarManager instance = new CalendarManager();

    private List<Meeting> meetings = new ArrayList<Meeting>();
    private CalendarManager() {}

    public static CalendarManager getInstance() {
        return instance;
    }

    /**
     * Request a meeting.
     *
     * @param organizer
     * @param recipients
     * @param scheduling
     * @return the {@link Meeting} object
     */
    public Meeting requestMeeting(User organizer, List<User> recipients, Scheduling scheduling) {
        // validate meeting

        // create the meeting object and add it to the managed list
        Meeting meeting = new Meeting(organizer, recipients, scheduling);

        // send invitation events
        for (User user: meeting.recipients) {
            Event event = new InvitationEvent(meeting, user);
            EventProcessor.getInstance().sendEvent(event);
        }

        return meeting;
    }

    public void addRecipient(Meeting meeting, User newRecipient) {
        if (meeting.recipients.contains(newRecipient)) {
            throw new IllegalArgumentException("The meeting recipients list already has the user");
        }

        meeting.addRecipient(newRecipient);
        Event event = new InvitationEvent(meeting, newRecipient);
        EventProcessor.getInstance().sendEvent(event);
    }


    public class Meeting {
        // auto increment internal id
        private int id;

        // these variables are package level
        User organizer;
        Scheduling scheduling;
        Set<User> recipients;

        // all the methods below (including the constructor) is marked as private scope
        // so that it can only be called by the parent CalendarManager

        private Meeting(User organizer, List<User> recipients, Scheduling scheduling) {
            this.organizer = organizer;
            this.scheduling = scheduling;
            this.recipients = new HashSet<User>(recipients);
        }

        void addRecipient(User user) {
            recipients.add(user);
        }


        void removeRecipient(User user) {
            recipients.remove(user);
        }
    }
}
