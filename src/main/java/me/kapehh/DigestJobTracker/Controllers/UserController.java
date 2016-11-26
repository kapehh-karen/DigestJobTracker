package me.kapehh.DigestJobTracker.Controllers;

import me.kapehh.DigestJobTracker.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/new")
    public User newUserID() {
        User user = new User(UUID.randomUUID());
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> listOfUsers() {
        return users;
    }
}
