package me.kapehh.DigestJobTracker.Controllers;

import me.kapehh.DigestJobTracker.Exceptions.UUIDNotFoundException;
import me.kapehh.DigestJobTracker.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static User getUserByUUID(UUID uuid) {
        return users
                .stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/new")
    public User createUser() {
        User user = new User(UUID.randomUUID());
        users.add(user);
        return user;
    }

    @GetMapping("/info")
    public User getUserTasks(@RequestParam UUID uuid) {
        User user = getUserByUUID(uuid);
        if (user != null) {
            return user;
        } else {
            throw new UUIDNotFoundException();
        }
    }

    @GetMapping("/list")
    public List<User> listOfUsers() {
        return users;
    }
}
