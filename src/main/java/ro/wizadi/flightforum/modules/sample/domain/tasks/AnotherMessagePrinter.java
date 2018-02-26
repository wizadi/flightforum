package ro.wizadi.flightforum.modules.sample.domain.tasks;

import java.time.Instant;
import java.util.concurrent.Callable;

public class AnotherMessagePrinter implements Callable {

    @Override
    public Object call() throws Exception {

        try {

            Thread.sleep(5000);
            Long time = Instant.now().toEpochMilli();
            System.out.println("Run at: " + time);

            return time;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
