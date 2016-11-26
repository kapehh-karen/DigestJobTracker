package me.kapehh.DigestJobTracker.Controllers;

import me.kapehh.DigestJobTracker.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    @PostMapping("/new")
    public boolean newTask(@RequestBody Task task) {
        tasks.add(task);
        return true;
    }

    @GetMapping("/list")
    public List<Task> listOfTasks() {
        return tasks;
    }
}
