package ro.wizadi.flightforum.modules.sample.web.controllers;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.wizadi.flightforum.modules.sample.domain.tasks.AnotherMessagePrinter;
import ro.wizadi.flightforum.modules.sample.domain.tasks.HourPrinter;
import ro.wizadi.flightforum.modules.sample.domain.tasks.MessagePrinter;

import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/tasks")
public class TasksController {



    private MessagePrinter messagePrinter;

    private TaskScheduler taskScheduler;
    private ScheduledFuture<?> scheduledFuture;

    public TasksController(TaskScheduler taskScheduler,
                            MessagePrinter messagePrinter)
    {
        this.taskScheduler = taskScheduler;
        this.messagePrinter = messagePrinter;
    }


    @GetMapping("time")
    @ResponseBody
    public String printTime() {

        scheduledFuture = taskScheduler.schedule(new HourPrinter(), new CronTrigger("0/10 * * * * *"));

        return "ok";
    }

    @GetMapping("stoptime")
    @ResponseBody
    public String stopTimePrint() {

        scheduledFuture.cancel(true);

        return "stopped";
    }

    @GetMapping("async")
    @ResponseBody
    public String runAsync() {
        messagePrinter.printMessage();

        return "async ran @ " + Instant.now().toEpochMilli();
    }

    @GetMapping("async2")
    @ResponseBody
    public String runAsync2() throws ExecutionException, InterruptedException {

        Future result  = ((ThreadPoolTaskScheduler)taskScheduler).submit(new AnotherMessagePrinter());
        System.out.println("Method: " + Instant.now().toEpochMilli() );


        return "async2 ran @ " + result.get();
    }

}
