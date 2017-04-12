package io.garlicbulbxian.calendar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class EventProcessor {
    private final static EventProcessor instance = new EventProcessor();

    // configure this constant based on the number of cores available for processing
    private static int WORKERS = 2;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(WORKERS);

    private EventProcessor() {}

    public static EventProcessor getInstance() {
        return instance;
    }

    /**
     * Send event to {@link EventProcessor} for processing.
     *
     * If all threads are occupied, events will be added to the internal worker queue of the underlying thread pool.
     * @param event
     */
    public synchronized void sendEvent(Event event) {
        // create Runnable envelope for the event

        executor.execute(event);
    }

    public static class Envelope {}
}
