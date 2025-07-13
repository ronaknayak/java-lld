package com.lld.design.pattern.behavioural;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Command design pattern decouples the sender of a request from the receiver, providing a way
 * to issue commands without knowing the specific operation that will be performed or the receiver
 * of the request.
 * <p>
 * Use cases:
 * <p>
 * 1. Job scheduling
 * Command objects can be utilized in job scheduling systems. Each job or task to be executed is
 * encapsulated as a command object, which contains all the necessary information and logic to
 * perform the task. The job scheduler maintains a queue of command objects and executes them
 * based on predefined criteria, such as priority, time, or dependencies.
 * <p>
 * 2. You want to group a set of operations as a single unit - batch jobs
 */
public class CommandPattern {
    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        // Create command objects
        Command email = new EmailTask("ronak@example.com");
        Command sms = new SmsTask("+918888888888");
        Command sync = new DataSyncTask();

        // Add to a batch
        BatchCommand batch = new BatchCommand();
        batch.addCommand(email);
        batch.addCommand(sms);
        batch.addCommand(sync);

        taskExecutor.submitTask(batch);

        // Shutdown after delay to allow async execution
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        taskExecutor.shutdown();
    }
}

class BatchCommand implements Command {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command cmd) {
        commands.add(cmd);
    }

    @Override
    public void run() {
        System.out.println("🚀 Starting batch execution of " + commands.size() + " tasks");
        for (Command cmd : commands) {
            cmd.run();
        }
        System.out.println("✅ Batch execution complete");
    }
}

class TaskExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public void submitTask(Command task) {
        executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}


interface Command extends Runnable {
    // No additional methods; extend Runnable for ExecutorService
}

class EmailTask implements Command {
    private final String recipient;

    public EmailTask(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public void run() {
        System.out.println("📧 Sending email to " + recipient);
        // Simulate delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("✅ Email sent to " + recipient);
    }
}

class SmsTask implements Command {
    private final String phoneNumber;

    public SmsTask(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void run() {
        System.out.println("📱 Sending SMS to " + phoneNumber);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        System.out.println("✅ SMS sent to " + phoneNumber);
    }
}

class DataSyncTask implements Command {
    @Override
    public void run() {
        System.out.println("🔄 Starting data sync...");
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
        System.out.println("✅ Data sync completed.");
    }
}
