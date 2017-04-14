package io.garlicbulbxian.calendar;

import java.util.Map;
import java.util.concurrent.*;

public class EventProcessor {
    private final static EventProcessor instance = new EventProcessor();

    // configure this constant based on the number of cores available for processing
    private static int WORKERS = 2;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(WORKERS);

    private EventProcessor() {}

    public static EventProcessor getInstance() {
        return instance;
    }

    private Map<Event, ScheduledFuture> scheduledFutures = new ConcurrentHashMap<Event, ScheduledFuture>();

    /**
     * Send event to {@link EventProcessor} for processing.
     *
     * If all threads are occupied, events will be added to the internal worker queue of the underlying thread pool.
     * @param event
     */
    public synchronized void processEvent(Event event) {
        // create Runnable envelope for the event
        if (event.getDelay() == 0) {
            executor.execute(new EmailEnvelope(event));
        } else {
            ScheduledFuture scheduledFuture = executor.schedule(new EmailEnvelope(event), event.getDelay(), TimeUnit.MINUTES);
            scheduledFutures.put(event, scheduledFuture);
        }

        if (event instanceof CancelEvent) {
            for (Map.Entry<Event, ScheduledFuture> entry : scheduledFutures.entrySet()) {
                if (!entry.getValue().isDone()) {
                    // TODO: add another check if e should be cancelled by
                    entry.getValue().cancel(true);
                }
            }
        }
    }

    public static class EmailEnvelope implements Runnable {
        private Event event;
        public EmailEnvelope(Event event) {
            this.event = event;
        }

        public void run() {
            // send email to the user
            EmailController.sendEmail(event.getNotifiedUser().email, event.getMessage());
        }
    }

}
