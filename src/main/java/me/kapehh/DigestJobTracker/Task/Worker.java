package me.kapehh.DigestJobTracker.Task;

import me.kapehh.DigestJobTracker.Enums.TaskStatus;
import me.kapehh.DigestJobTracker.Model.Task;
import me.kapehh.DigestJobTracker.Utils.ExceptionUtil;
import me.kapehh.DigestJobTracker.Utils.HashUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karen on 01.12.2016.
 */
public class Worker implements Runnable {
    private static final ExecutorService service = Executors.newFixedThreadPool(5);

    public static void addWorkerTask(Task task) {
        task.setWorkerTask(service.submit(new Worker(task)));
    }

    public static void cancelWorkerTask(Task task) {
        if (task.getWorkerTask() != null) {
            task.getWorkerTask().cancel(true);
            task.setStatus(TaskStatus.CANCELED);
        }
    }

    // ------

    private Task task;

    private Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.setStatus(TaskStatus.WORKING);
            switch (task.getTypeUrl()) {
                case LOCAL:
                    task.setHash(HashUtil.calculateLocalHash(task.getSrc(), task.getAlgo()));
                    break;
                case REMOTE:
                    task.setHash(HashUtil.calculateRemoteHash(task.getSrc(), task.getAlgo()));
                    break;
            }
            task.setStatus(TaskStatus.COMPLETED);
        } catch (Throwable e) {
            task.setStackTrace(ExceptionUtil.getStackTrace(e));
            task.setStatus(TaskStatus.ERROR);
        }
    }
}
