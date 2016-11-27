package me.kapehh.DigestJobTracker.Model;

import me.kapehh.DigestJobTracker.Tasks.TaskStatus;
import me.kapehh.DigestJobTracker.Tasks.UserTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by karen on 26.11.2016.
 */
public class User {
    private UUID uuid;
    private List<UserTask> userTasks = new ArrayList<>();

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void addTask(Task task) {
        userTasks.add(new UserTask(task, TaskStatus.IN_QUEUE));
    }
}
