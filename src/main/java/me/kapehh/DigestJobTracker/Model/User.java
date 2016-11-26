package me.kapehh.DigestJobTracker.Model;

import java.util.UUID;

/**
 * Created by karen on 26.11.2016.
 */
public class User {
    private UUID uuid;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
