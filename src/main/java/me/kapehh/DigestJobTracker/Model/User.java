package me.kapehh.DigestJobTracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by karen on 26.11.2016.
 */
public class User {
    private UUID uuid;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Task> userTasks;

    public User(UUID uuid) {
        this.userTasks = new ArrayList<>();
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }
}
