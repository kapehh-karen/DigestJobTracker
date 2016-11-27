package me.kapehh.DigestJobTracker.Tasks;

import me.kapehh.DigestJobTracker.Model.Task;
import me.kapehh.DigestJobTracker.Model.User;

import java.util.List;

/**
 * Created by karen on 27.11.2016.
 */
public class UserTask {
    private Task task;
    private TaskStatus status;
    private String hash;

    public UserTask(Task task, TaskStatus status) {
        this.task = task;
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
