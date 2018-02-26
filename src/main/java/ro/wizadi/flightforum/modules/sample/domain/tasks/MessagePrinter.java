package ro.wizadi.flightforum.modules.sample.domain.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class MessagePrinter {

    @Async
    public void printMessage() {

        try {
            Thread.sleep(5000);
            System.out.println("Message printer: " + Instant.now().toEpochMilli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
