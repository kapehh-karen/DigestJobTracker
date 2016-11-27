package me.kapehh.DigestJobTracker.Controllers;

import me.kapehh.DigestJobTracker.Exceptions.ResourceNotFoundException;
import me.kapehh.DigestJobTracker.Model.Task;
import me.kapehh.DigestJobTracker.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    @PostMapping("/new")
    public void newTask(@RequestParam UUID uuid, @RequestBody Task task) {
        User user = UserController.getUsers()
                    .stream()
                    .filter(u -> u.getUuid().equals(uuid))
                    .findFirst()
                    .orElse(null);

        if (user != null) {
            user.addTask(task);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
