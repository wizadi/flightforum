package ro.wizadi.flightforum.modules.sample.domain.tasks;

import java.time.Instant;

public class HourPrinter implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from Hour Printer: " + Instant.now().toEpochMilli());
    }
}
