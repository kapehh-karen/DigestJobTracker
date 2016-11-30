package me.kapehh.DigestJobTracker.Task;

import me.kapehh.DigestJobTracker.Enums.TaskStatus;
import me.kapehh.DigestJobTracker.Model.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karen on 01.12.2016.
 */
public class Worker implements Runnable {
    private static final ExecutorService service = Executors.newFixedThreadPool(1);

    public static void addWorkerTask(Task task) {
        service.submit(new Worker(task));
    }

    // ------

    private Task task;

    private Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.setStatus(TaskStatus.WORKING);

        System.out.println("START WORKER: " + task.getSrc());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            task.setStatus(TaskStatus.ERROR);
        }
        System.out.println("END WORKER: " + task.getSrc());

        task.setStatus(TaskStatus.COMPLETED);
    }
}
